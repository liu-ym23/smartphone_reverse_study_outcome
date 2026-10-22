package com.google.android.material.timepicker;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class ClockHandView extends View {
    private static final int DEFAULT_ANIMATION_DURATION = 200;
    private boolean animatingOnTouchUp;
    private final int animationDuration;
    private final TimeInterpolator animationInterpolator;
    private final float centerDotRadius;
    private boolean changedDuringTouch;
    private int circleRadius;
    private int currentLevel;
    private double degRad;
    private float downX;
    private float downY;
    private boolean isInTapRegion;
    private boolean isMultiLevel;
    private final List<OnRotateListener> listeners;
    private OnActionUpListener onActionUpListener;
    private float originalDeg;
    private final Paint paint;
    private final ValueAnimator rotationAnimator;
    private final int scaledTouchSlop;
    private final RectF selectorBox;
    private final int selectorRadius;

    @Px
    private final int selectorStrokeWidth;

    public interface OnActionUpListener {
        void onActionUp(@FloatRange(from = 0.0d, to = 360.0d) float r5, boolean r10);
    }

    public interface OnRotateListener {
        void onRotate(@FloatRange(from = 0.0d, to = 360.0d) float r5, boolean r10);
    }

    public ClockHandView(Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(ClockHandView r5, ValueAnimator r10) {
        r5.lambda$setHandRotation$0(r10);
    }

    private void adjustLevel(float r5, float r10) {
        int r11 = 2;
        if (MathUtils.dist(getWidth() / 2, getHeight() / 2, r5, r10) <= (getLeveledCircleRadius(2) + ViewUtils.dpToPx(getContext(), 12))) goto L6;
        r11 = 1;
    L6:
        this.currentLevel = r11;
    }

    private void drawSelector(Canvas r12) {
        int r5 = getHeight() / 2;
        int r10 = getWidth() / 2;
        int r11 = getLeveledCircleRadius(this.currentLevel);
        float r13 = r10;
        float r14 = r11;
        float r15 = (((float) Math.cos(this.degRad)) * r14) + r13;
        float r16 = r5;
        float r17 = (r14 * ((float) Math.sin(this.degRad))) + r16;
        this.paint.setStrokeWidth(0.0f);
        r12.drawCircle(r15, r17, this.selectorRadius, this.paint);
        double r18 = Math.sin(this.degRad);
        double r19 = Math.cos(this.degRad);
        double r20 = r11 - this.selectorRadius;
        this.paint.setStrokeWidth(this.selectorStrokeWidth);
        r12.drawLine(r13, r16, r10 + ((int) (r19 * r20)), r5 + ((int) (r20 * r18)), this.paint);
        r12.drawCircle(r13, r16, this.centerDotRadius, this.paint);
    }

    private int getDegreesFromXY(float r5, float r10) {
        int r11 = getWidth() / 2;
        int r12 = (int) Math.toDegrees(Math.atan2(r10 - (getHeight() / 2), r5 - r11));
        int r13 = r12 + 90;
        if (r13 < 0) goto L5;
        return r13;
    L5:
        return r12 + 450;
    }

    @Dimension
    private int getLeveledCircleRadius(int r5) {
        int r10 = this.circleRadius;
        if (r5 == 2) goto L5;
        return r10;
    L5:
        return Math.round(r10 * 0.66f);
    }

    private Pair<Float, Float> getValuesForAnimation(float r5) {
        float r10 = getHandRotation();
        if (Math.abs(r10 - r5) <= 180.0f) goto L15;
        if (r10 <= 180.0f) goto L10;
        if (r5 >= 180.0f) goto L10;
        r5 = r5 + 360.0f;
    L10:
        if (r10 >= 180.0f) goto L15;
        if (r5 <= 180.0f) goto L15;
        r10 = r10 + 360.0f;
    L15:
        return new Pair(Float.valueOf(r10), Float.valueOf(r5));
    }

    private boolean handleTouchInput(float r5, float r10, boolean r11, boolean r12, boolean r13) {
        float r14 = getDegreesFromXY(r5, r10);
        boolean r15 = false;
        if (getHandRotation() == r14) goto L5;
        boolean r16 = true;
    L6:
        if (r12 == false) goto L9;
        if (r16 == false) goto L9;
        return true;
    L9:
        if (r16 == true) goto L13;
        if (r11 == true) goto L13;
        return false;
    L13:
        if (r13 == true) goto L15;
    L17:
        setHandRotation(r14, r15);
        return true;
    L15:
        if (this.animatingOnTouchUp == false) goto L17;
        r15 = true;
        goto L17
    L5:
        r16 = false;
        goto L6
    }

    private /* synthetic */ void lambda$setHandRotation$0(ValueAnimator r5) {
        setHandRotationInternal(((Float) r5.getAnimatedValue()).floatValue(), true);
    }

    private void setHandRotationInternal(@FloatRange(from = 0.0d, to = 360.0d) float r10, boolean r11) {
        float r12 = r10 % 360.0f;
        this.originalDeg = r12;
        this.degRad = Math.toRadians(r12 - 90.0f);
        int r5 = getHeight() / 2;
        int r13 = getWidth() / 2;
        float r14 = getLeveledCircleRadius(this.currentLevel);
        float r15 = (((float) Math.cos(this.degRad)) * r14) + r13;
        float r16 = (r14 * ((float) Math.sin(this.degRad))) + r5;
        RectF r17 = this.selectorBox;
        int r18 = this.selectorRadius;
        r17.set(r15 - r18, r16 - r18, r15 + r18, r16 + r18);
        Iterator<OnRotateListener> r19 = this.listeners.iterator();
    L4:
        if (r19.hasNext() == false) goto L6;
        r19.next().onRotate(r12, r11);
        goto L4
    L6:
        invalidate();
    }

    public void addOnRotateListener(OnRotateListener r5) {
        this.listeners.add(r5);
    }

    public int getCurrentLevel() {
        return this.currentLevel;
    }

    public RectF getCurrentSelectorBox() {
        return this.selectorBox;
    }

    @FloatRange(from = 0.0d, to = 360.0d)
    public float getHandRotation() {
        return this.originalDeg;
    }

    public int getSelectorRadius() {
        return this.selectorRadius;
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        super.onDraw(r5);
        drawSelector(r5);
    }

    @Override // android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        if (this.rotationAnimator.isRunning() == true) goto L6;
        setHandRotation(getHandRotation());
        return;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent r11) {
        int r5 = r11.getActionMasked();
        float r10 = r11.getX();
        float r12 = r11.getY();
        if (r5 == 0) goto L20;
        if (r5 != 1) goto L6;
    L8:
        int r13 = (int) (r10 - this.downX);
        int r14 = (int) (r12 - this.downY);
        if (((r14 * r14) + (r13 * r13)) <= this.scaledTouchSlop) goto L11;
        boolean r15 = true;
    L12:
        this.isInTapRegion = r15;
        boolean r16 = this.changedDuringTouch;
        if (r5 != 1) goto L15;
        boolean r17 = true;
    L17:
        if (this.isMultiLevel == false) goto L19;
        adjustLevel(r10, r12);
    L19:
        boolean r18 = false;
        boolean r19 = r16;
    L21:
        boolean r20 = handleTouchInput(r10, r12, r19, r18, r17) | this.changedDuringTouch;
        this.changedDuringTouch = r20;
        if (r20 == false) goto L27;
        if (r17 == false) goto L27;
        OnActionUpListener r21 = this.onActionUpListener;
        if (r21 == null) goto L27;
        r21.onActionUp(getDegreesFromXY(r10, r12), this.isInTapRegion);
    L27:
        return true;
    L15:
        r17 = false;
        goto L17
    L11:
        r15 = false;
        goto L12
    L6:
        if (r5 == 2) goto L8;
        r17 = false;
        r19 = false;
        r18 = false;
        goto L21
    L20:
        this.downX = r10;
        this.downY = r12;
        this.isInTapRegion = true;
        this.changedDuringTouch = false;
        r17 = false;
        r19 = false;
        r18 = true;
        goto L21
    }

    public void setAnimateOnTouchUp(boolean r5) {
        this.animatingOnTouchUp = r5;
    }

    public void setCircleRadius(@Dimension int r5) {
        this.circleRadius = r5;
        invalidate();
    }

    public void setCurrentLevel(int r5) {
        this.currentLevel = r5;
        invalidate();
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float r5) {
        setHandRotation(r5, false);
    }

    public void setMultiLevel(boolean r5) {
        if (this.isMultiLevel == false) goto L6;
        if (r5 == true) goto L6;
        this.currentLevel = 1;
    L6:
        this.isMultiLevel = r5;
        invalidate();
    }

    public void setOnActionUpListener(OnActionUpListener r5) {
        this.onActionUpListener = r5;
    }

    public ClockHandView(Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.materialClockStyle);
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float r5, boolean r10) {
        ValueAnimator r11 = this.rotationAnimator;
        if (r11 == null) goto L5;
        r11.cancel();
    L5:
        if (r10 == true) goto L8;
        setHandRotationInternal(r5, false);
        return;
    L8:
        Pair<Float, Float> r12 = getValuesForAnimation(r5);
        this.rotationAnimator.setFloatValues(new float[]{((Float) r12.first).floatValue(), ((Float) r12.second).floatValue()});
        this.rotationAnimator.setDuration(this.animationDuration);
        this.rotationAnimator.setInterpolator(this.animationInterpolator);
        this.rotationAnimator.addUpdateListener(new a(this));
        this.rotationAnimator.addListener(new AnonymousClass1(this));
        this.rotationAnimator.start();
    }

    public ClockHandView(Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.rotationAnimator = new ValueAnimator();
        this.listeners = new ArrayList();
        Paint r12 = new Paint();
        this.paint = r12;
        this.selectorBox = new RectF();
        this.currentLevel = 1;
        TypedArray r13 = r5.obtainStyledAttributes(r10, R.styleable.ClockHandView, r11, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.animationDuration = MotionUtils.resolveThemeDuration(r5, R.attr.motionDurationLong2, 200);
        this.animationInterpolator = MotionUtils.resolveThemeInterpolator(r5, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.circleRadius = r13.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.selectorRadius = r13.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        Resources r14 = getResources();
        this.selectorStrokeWidth = r14.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.centerDotRadius = r14.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int r15 = r13.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        r12.setAntiAlias(true);
        r12.setColor(r15);
        setHandRotation(0.0f);
        this.scaledTouchSlop = ViewConfiguration.get(r5).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        r13.recycle();
    }
}
