package com.google.android.material.timepicker;

import android.R;
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
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Arrays;
import q5.d;
import q5.f;
import q5.h;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes2.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.d {
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
    private final ColorStateList textColor;
    private final SparseArray<TextView> textViewPool;
    private final Rect textViewRect;
    private final AccessibilityDelegateCompat valueAccessibilityDelegate;
    private String[] values;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ClockFaceView f4026c;

        a(ClockFaceView r10) {
            this.f4026c = r10;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (this.f4026c.isShown() == true) goto L5;
            return true;
        L5:
            this.f4026c.getViewTreeObserver().removeOnPreDrawListener(this);
            int r10 = ((this.f4026c.getHeight() / 2) - ClockFaceView.access$000(this.f4026c).g()) - ClockFaceView.access$100(this.f4026c);
            this.f4026c.setRadius(r10);
            return true;
        }
    }

    public ClockFaceView(@NonNull Context r10) {
        this(r10, null);
    }

    public ClockFaceView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.materialClockStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.textViewRect = new Rect();
        this.scratch = new RectF();
        this.textViewPool = new SparseArray();
        this.gradientPositions = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray r13 = r10.obtainStyledAttributes(r11, l.ClockFaceView, r12, k.Widget_MaterialComponents_TimePicker_Clock);
        Resources r14 = getResources();
        ColorStateList r15 = com.google.android.material.resources.c.a(r10, r13, l.ClockFaceView_clockNumberTextColor);
        this.textColor = r15;
        LayoutInflater.from(r10).inflate(h.material_clockface_view, this, true);
        ClockHandView r16 = (ClockHandView) findViewById(f.material_clock_hand);
        this.clockHandView = r16;
        this.clockHandPadding = r14.getDimensionPixelSize(d.material_clock_hand_padding);
        int r17 = r15.getColorForState(new int[]{R.attr.state_selected}, r15.getDefaultColor());
        this.gradientColors = new int[]{r17, r17, r15.getDefaultColor()};
        r16.b(this);
        int r18 = AppCompatResources.getColorStateList(r10, q5.c.material_timepicker_clockface).getDefaultColor();
        ColorStateList r19 = com.google.android.material.resources.c.a(r10, r13, l.ClockFaceView_clockFaceBackgroundColor);
        if (r19 == null) goto L6;
        r18 = r19.getDefaultColor();
    L6:
        setBackgroundColor(r18);
        getViewTreeObserver().addOnPreDrawListener(new a(this));
        setFocusable(true);
        r13.recycle();
        this.valueAccessibilityDelegate = new AnonymousClass2(this);
        String[] r20 = new String[12];
        Arrays.fill(r20, "");
        setValues(r20, 0);
        this.minimumHeight = r14.getDimensionPixelSize(d.material_time_picker_minimum_screen_height);
        this.minimumWidth = r14.getDimensionPixelSize(d.material_time_picker_minimum_screen_width);
        this.clockSize = r14.getDimensionPixelSize(d.material_clock_size);
    }

    static /* synthetic */ ClockHandView access$000(ClockFaceView r10) {
        return r10.clockHandView;
    }

    static /* synthetic */ int access$100(ClockFaceView r10) {
        return r10.clockHandPadding;
    }

    static /* synthetic */ SparseArray access$200(ClockFaceView r10) {
        return r10.textViewPool;
    }

    private void findIntersectingTextView() {
        RectF r10 = this.clockHandView.d();
        int r11 = 0;
    L4:
        if (r11 >= this.textViewPool.size()) goto L10;
        TextView r12 = this.textViewPool.get(r11);
        if (r12 == null) goto L9;
        r12.getDrawingRect(this.textViewRect);
        offsetDescendantRectToMyCoords(r12, this.textViewRect);
        r12.setSelected(r10.contains(this.textViewRect.centerX(), this.textViewRect.centerY()));
        r12.getPaint().setShader(getGradientForTextView(r10, this.textViewRect, r12));
        r12.invalidate();
    L9:
        r11 = r11 + 1;
        goto L4
    }

    @Nullable
    private RadialGradient getGradientForTextView(RectF r10, Rect r11, TextView r12) {
        this.scratch.set(r11);
        this.scratch.offset(r12.getPaddingLeft(), r12.getPaddingTop());
        if (RectF.intersects(r10, this.scratch) == true) goto L7;
        return null;
    L7:
        return new RadialGradient(r10.centerX() - this.scratch.left, r10.centerY() - this.scratch.top, r10.width() * 0.5f, this.gradientColors, this.gradientPositions, Shader.TileMode.CLAMP);
    }

    private static float max3(float r10, float r11, float r12) {
        return Math.max(Math.max(r10, r11), r12);
    }

    private void updateTextViews(@StringRes int r10) {
        LayoutInflater r11 = LayoutInflater.from(getContext());
        int r12 = this.textViewPool.size();
        int r13 = 0;
    L4:
        if (r13 >= Math.max(this.values.length, r12)) goto L14;
        TextView r14 = this.textViewPool.get(r13);
        if (r13 < this.values.length) goto L8;
        removeView(r14);
        this.textViewPool.remove(r13);
    L13:
        r13 = r13 + 1;
        goto L4
    L8:
        if (r14 != null) goto L10;
        r14 = (TextView) r11.inflate(h.material_clockface_textview, this, false);
        this.textViewPool.put(r13, r14);
        addView(r14);
    L10:
        r14.setVisibility(0);
        r14.setText(this.values[r13]);
        r14.setTag(f.material_value_index, Integer.valueOf(r13));
        ViewCompat.setAccessibilityDelegate(r14, this.valueAccessibilityDelegate);
        r14.setTextColor(this.textColor);
        if (r10 == 0) goto L13;
        r14.setContentDescription(getResources().getString(r10, new Object[]{this.values[r13]}));
        goto L13
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        AccessibilityNodeInfoCompat.wrap(r10).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.values.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        findIntersectingTextView();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        DisplayMetrics r12 = getResources().getDisplayMetrics();
        int r13 = (int) (this.clockSize / max3(this.minimumHeight / r12.heightPixels, this.minimumWidth / r12.widthPixels, 1.0f));
        int r14 = View.MeasureSpec.makeMeasureSpec(r13, 1073741824);
        setMeasuredDimension(r13, r13);
        super.onMeasure(r14, r14);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void onRotate(float r10, boolean r11) {
        if (Math.abs(this.currentHandRotation - r10) <= 0.001f) goto L6;
        this.currentHandRotation = r10;
        findIntersectingTextView();
        return;
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float r10) {
        this.clockHandView.l(r10);
        findIntersectingTextView();
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void setRadius(int r10) {
        if (r10 == getRadius()) goto L6;
        super.setRadius(r10);
        this.clockHandView.k(getRadius());
        return;
    }

    public void setValues(String[] r10, @StringRes int r11) {
        this.values = r10;
        updateTextViews(r11);
    }
}
