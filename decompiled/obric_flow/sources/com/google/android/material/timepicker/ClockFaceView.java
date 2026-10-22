package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.OnRotateListener {
    private static final float EPSILON = 0.001f;
    private static final int INITIAL_CAPACITY = 12;
    private static final String VALUE_PLACEHOLDER = "";
    private final int clockHandPadding;
    private final ClockHandView clockHandView;
    private final int clockSize;
    private float currentHandRotation;
    private final int[] gradientColors;
    private final float[] gradientPositions;
    private final int minimumHeight;
    private final int minimumWidth;
    private final RectF scratch;
    private final Rect scratchLineBounds;
    private final ColorStateList textColor;
    private final SparseArray<TextView> textViewPool;
    private final Rect textViewRect;
    private final AccessibilityDelegateCompat valueAccessibilityDelegate;
    private String[] values;

    public ClockFaceView(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ ClockHandView access$000(ClockFaceView r5) {
        return r5.clockHandView;
    }

    public static /* synthetic */ int access$100(ClockFaceView r5) {
        return r5.clockHandPadding;
    }

    public static /* synthetic */ SparseArray access$200(ClockFaceView r5) {
        return r5.textViewPool;
    }

    public static /* synthetic */ Rect access$300(ClockFaceView r5) {
        return r5.textViewRect;
    }

    private void findIntersectingTextView() {
        RectF r5 = this.clockHandView.getCurrentSelectorBox();
        TextView r10 = getSelectedTextView(r5);
        int r11 = 0;
    L4:
        if (r11 >= this.textViewPool.size()) goto L13;
        TextView r12 = this.textViewPool.get(r11);
        if (r12 == null) goto L12;
        if (r12 != r10) goto L10;
        boolean r13 = true;
    L11:
        r12.setSelected(r13);
        r12.getPaint().setShader(getGradientForTextView(r5, r12));
        r12.invalidate();
        goto L12
    L10:
        r13 = false;
    L12:
        r11 = r11 + 1;
        goto L4
    }

    @Nullable
    private RadialGradient getGradientForTextView(RectF r10, TextView r11) {
        r11.getHitRect(this.textViewRect);
        this.scratch.set(this.textViewRect);
        r11.getLineBounds(0, this.scratchLineBounds);
        RectF r12 = this.scratch;
        Rect r5 = this.scratchLineBounds;
        r12.inset(r5.left, r5.top);
        if (RectF.intersects(r10, this.scratch) == true) goto L7;
        return null;
    L7:
        return new RadialGradient(r10.centerX() - this.scratch.left, r10.centerY() - this.scratch.top, r10.width() * 0.5f, this.gradientColors, this.gradientPositions, Shader.TileMode.CLAMP);
    }

    @Nullable
    private TextView getSelectedTextView(RectF r10) {
        float r5 = Float.MAX_VALUE;
        TextView r11 = null;
        int r12 = 0;
    L4:
        if (r12 >= this.textViewPool.size()) goto L12;
        TextView r13 = this.textViewPool.get(r12);
        if (r13 == null) goto L11;
        r13.getHitRect(this.textViewRect);
        this.scratch.set(this.textViewRect);
        this.scratch.union(r10);
        float r14 = this.scratch.width();
        float r15 = this.scratch.height() * r14;
        if (r15 >= r5) goto L11;
        r11 = r13;
        r5 = r15;
    L11:
        r12 = r12 + 1;
        goto L4
    L12:
        return r11;
    }

    private static float max3(float r5, float r10, float r11) {
        return Math.max(Math.max(r5, r10), r11);
    }

    private void updateTextViews(@StringRes int r11) {
        LayoutInflater r5 = LayoutInflater.from(getContext());
        int r10 = this.textViewPool.size();
        int r12 = 0;
        boolean r13 = false;
    L4:
        if (r12 >= Math.max(this.values.length, r10)) goto L17;
        TextView r14 = this.textViewPool.get(r12);
        if (r12 < this.values.length) goto L8;
        removeView(r14);
        this.textViewPool.remove(r12);
    L16:
        r12 = r12 + 1;
        goto L4
    L8:
        if (r14 != null) goto L10;
        r14 = (TextView) r5.inflate(R.layout.material_clockface_textview, this, false);
        this.textViewPool.put(r12, r14);
        addView(r14);
    L10:
        r14.setText(this.values[r12]);
        r14.setTag(R.id.material_value_index, Integer.valueOf(r12));
        int r15 = (r12 / 12) + 1;
        r14.setTag(R.id.material_clock_level, Integer.valueOf(r15));
        if (r15 <= 1) goto L13;
        r13 = true;
    L13:
        ViewCompat.setAccessibilityDelegate(r14, this.valueAccessibilityDelegate);
        r14.setTextColor(this.textColor);
        if (r11 == 0) goto L16;
        r14.setContentDescription(getResources().getString(r11, new Object[]{this.values[r12]}));
        goto L16
    L17:
        this.clockHandView.setMultiLevel(r13);
    }

    public int getCurrentLevel() {
        return this.clockHandView.getCurrentLevel();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        AccessibilityNodeInfoCompat.wrap(r5).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.values.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        findIntersectingTextView();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        DisplayMetrics r11 = getResources().getDisplayMetrics();
        int r12 = (int) (this.clockSize / max3(this.minimumHeight / r11.heightPixels, this.minimumWidth / r11.widthPixels, 1.0f));
        int r13 = View.MeasureSpec.makeMeasureSpec(r12, BasicMeasure.EXACTLY);
        setMeasuredDimension(r12, r12);
        super.onMeasure(r13, r13);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float r5, boolean r10) {
        if (Math.abs(this.currentHandRotation - r5) <= EPSILON) goto L6;
        this.currentHandRotation = r5;
        findIntersectingTextView();
        return;
    }

    public void setCurrentLevel(int r5) {
        this.clockHandView.setCurrentLevel(r5);
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float r5) {
        this.clockHandView.setHandRotation(r5);
        findIntersectingTextView();
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void setRadius(int r5) {
        if (r5 == getRadius()) goto L6;
        super.setRadius(r5);
        this.clockHandView.setCircleRadius(getRadius());
        return;
    }

    public void setValues(String[] r5, @StringRes int r10) {
        this.values = r5;
        updateTextViews(r10);
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void updateLayoutParams() {
        super.updateLayoutParams();
        int r5 = 0;
    L4:
        if (r5 >= this.textViewPool.size()) goto L6;
        this.textViewPool.get(r5).setVisibility(0);
        r5 = r5 + 1;
        goto L4
    }

    public ClockFaceView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.materialClockStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.textViewRect = new Rect();
        this.scratch = new RectF();
        this.scratchLineBounds = new Rect();
        this.textViewPool = new SparseArray();
        this.gradientPositions = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray r13 = r10.obtainStyledAttributes(r11, R.styleable.ClockFaceView, r12, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources r14 = getResources();
        ColorStateList r5 = MaterialResources.getColorStateList(r10, r13, R.styleable.ClockFaceView_clockNumberTextColor);
        this.textColor = r5;
        LayoutInflater.from(r10).inflate(R.layout.material_clockface_view, this, true);
        ClockHandView r15 = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.clockHandView = r15;
        this.clockHandPadding = r14.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int r16 = r5.getColorForState(new int[]{android.R.attr.state_selected}, r5.getDefaultColor());
        this.gradientColors = new int[]{r16, r16, r5.getDefaultColor()};
        r15.addOnRotateListener(this);
        int r17 = AppCompatResources.getColorStateList(r10, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList r18 = MaterialResources.getColorStateList(r10, r13, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        if (r18 == null) goto L6;
        r17 = r18.getDefaultColor();
    L6:
        setBackgroundColor(r17);
        getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(this));
        setFocusable(true);
        r13.recycle();
        this.valueAccessibilityDelegate = new AnonymousClass2(this);
        String[] r19 = new String[12];
        Arrays.fill(r19, "");
        setValues(r19, 0);
        this.minimumHeight = r14.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.minimumWidth = r14.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.clockSize = r14.getDimensionPixelSize(R.dimen.material_clock_size);
    }
}
