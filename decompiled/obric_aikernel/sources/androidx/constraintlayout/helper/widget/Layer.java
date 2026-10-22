package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class Layer extends ConstraintHelper {
    private static final String TAG = "Layer";
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;
    protected float mComputedCenterX;
    protected float mComputedCenterY;
    protected float mComputedMaxX;
    protected float mComputedMaxY;
    protected float mComputedMinX;
    protected float mComputedMinY;
    ConstraintLayout mContainer;
    private float mGroupRotateAngle;
    boolean mNeedBounds;
    private float mRotationCenterX;
    private float mRotationCenterY;
    private float mScaleX;
    private float mScaleY;
    private float mShiftX;
    private float mShiftY;
    View[] mViews;

    public Layer(Context r10) {
        super(r10);
        this.mRotationCenterX = Float.NaN;
        this.mRotationCenterY = Float.NaN;
        this.mGroupRotateAngle = Float.NaN;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    public Layer(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mRotationCenterX = Float.NaN;
        this.mRotationCenterY = Float.NaN;
        this.mGroupRotateAngle = Float.NaN;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    public Layer(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mRotationCenterX = Float.NaN;
        this.mRotationCenterY = Float.NaN;
        this.mGroupRotateAngle = Float.NaN;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        this.mComputedMaxX = Float.NaN;
        this.mComputedMaxY = Float.NaN;
        this.mComputedMinX = Float.NaN;
        this.mComputedMinY = Float.NaN;
        this.mNeedBounds = true;
        this.mViews = null;
        this.mShiftX = 0.0f;
        this.mShiftY = 0.0f;
    }

    private void reCacheViews() {
        if (this.mContainer != null) goto L5;
        return;
    L5:
        int r10 = this.mCount;
        if (r10 != 0) goto L8;
        return;
    L8:
        View[] r11 = this.mViews;
        if (r11 != null) goto L11;
    L12:
        this.mViews = new View[r10];
    L13:
        int r12 = 0;
    L15:
        if (r12 >= this.mCount) goto L17;
        int r13 = this.mIds[r12];
        this.mViews[r12] = this.mContainer.getViewById(r13);
        r12 = r12 + 1;
        goto L15
    L17:
        return;
    L11:
        if (r11.length == r10) goto L13;
        goto L12
    }

    private void transform() {
        if (this.mContainer != null) goto L6;
        return;
    L6:
        if (this.mViews != null) goto L8;
        reCacheViews();
    L8:
        calcCenters();
        if (Float.isNaN(this.mGroupRotateAngle) == false) goto L11;
        double r10 = 0.0d;
    L12:
        float r11 = (float) Math.sin(r10);
        float r12 = (float) Math.cos(r10);
        float r13 = this.mScaleX;
        float r14 = r13 * r12;
        float r15 = this.mScaleY;
        float r16 = (-r15) * r11;
        float r17 = r13 * r11;
        float r18 = r15 * r12;
        int r19 = 0;
    L14:
        if (r19 >= this.mCount) goto L19;
        View r20 = this.mViews[r19];
        int r21 = (r20.getLeft() + r20.getRight()) / 2;
        int r22 = (r20.getTop() + r20.getBottom()) / 2;
        float r23 = r21 - this.mComputedCenterX;
        float r24 = r22 - this.mComputedCenterY;
        float r25 = (((r14 * r23) + (r16 * r24)) - r23) + this.mShiftX;
        float r26 = (((r23 * r17) + (r18 * r24)) - r24) + this.mShiftY;
        r20.setTranslationX(r25);
        r20.setTranslationY(r26);
        r20.setScaleY(this.mScaleY);
        r20.setScaleX(this.mScaleX);
        if (Float.isNaN(this.mGroupRotateAngle) == true) goto L18;
        r20.setRotation(this.mGroupRotateAngle);
    L18:
        r19 = r19 + 1;
        goto L14
    L19:
        return;
    L11:
        r10 = Math.toRadians(this.mGroupRotateAngle);
        goto L12
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void applyLayoutFeaturesInConstraintSet(ConstraintLayout r10) {
        applyLayoutFeatures(r10);
    }

    protected void calcCenters() {
        if (this.mContainer != null) goto L6;
        return;
    L6:
        if (this.mNeedBounds == true) goto L13;
        if (Float.isNaN(this.mComputedCenterX) == true) goto L13;
        if (Float.isNaN(this.mComputedCenterY) == true) goto L13;
        return;
    L13:
        if (Float.isNaN(this.mRotationCenterX) == false) goto L15;
    L18:
        View[] r10 = getViews(this.mContainer);
        int r11 = 0;
        int r12 = r10[0].getLeft();
        int r13 = r10[0].getTop();
        int r14 = r10[0].getRight();
        int r15 = r10[0].getBottom();
    L20:
        if (r11 >= this.mCount) goto L22;
        View r16 = r10[r11];
        r12 = Math.min(r12, r16.getLeft());
        r13 = Math.min(r13, r16.getTop());
        r14 = Math.max(r14, r16.getRight());
        r15 = Math.max(r15, r16.getBottom());
        r11 = r11 + 1;
        goto L20
    L22:
        this.mComputedMaxX = r14;
        this.mComputedMaxY = r15;
        this.mComputedMinX = r12;
        this.mComputedMinY = r13;
        if (Float.isNaN(this.mRotationCenterX) == false) goto L25;
        float r17 = (r12 + r14) / 2;
    L26:
        this.mComputedCenterX = r17;
        if (Float.isNaN(this.mRotationCenterY) == false) goto L29;
        float r18 = (r13 + r15) / 2;
    L30:
        this.mComputedCenterY = r18;
        return;
    L29:
        r18 = this.mRotationCenterY;
        goto L30
    L25:
        r17 = this.mRotationCenterX;
        goto L26
    L15:
        if (Float.isNaN(this.mRotationCenterY) == true) goto L18;
        this.mComputedCenterY = this.mRotationCenterY;
        this.mComputedCenterX = this.mRotationCenterX;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r10) {
        super.init(r10);
        int r11 = 0;
        this.mUseViewMeasure = false;
        if (r10 == null) goto L19;
        TypedArray r12 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r13 = r12.getIndexCount();
    L5:
        if (r11 >= r13) goto L13;
        int r14 = r12.getIndex(r11);
        if (r14 != R.styleable.ConstraintLayout_Layout_android_visibility) goto L10;
        this.mApplyVisibilityOnAttach = true;
    L12:
        r11 = r11 + 1;
        goto L5
    L10:
        if (r14 != R.styleable.ConstraintLayout_Layout_android_elevation) goto L12;
        this.mApplyElevationOnAttach = true;
        goto L12
    L13:
        r12.recycle();
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        if (this.mApplyVisibilityOnAttach == false) goto L5;
    L6:
        int r10 = getVisibility();
        if (Build.VERSION.SDK_INT < 21) goto L9;
        float r11 = getElevation();
    L10:
        int r12 = 0;
    L12:
        if (r12 >= this.mCount) goto L33;
        View r13 = this.mContainer.getViewById(this.mIds[r12]);
        if (r13 == null) goto L25;
        if (this.mApplyVisibilityOnAttach == false) goto L19;
        r13.setVisibility(r10);
    L19:
        if (this.mApplyElevationOnAttach == false) goto L25;
        if (r11 <= 0.0f) goto L25;
        if (Build.VERSION.SDK_INT < 21) goto L25;
        r13.setTranslationZ(r13.getTranslationZ() + r11);
    L25:
        r12 = r12 + 1;
        goto L12
    L33:
        return;
    L9:
        r11 = 0.0f;
        goto L10
    L5:
        if (this.mApplyElevationOnAttach == true) goto L6;
    }

    @Override // android.view.View
    public void setElevation(float r10) {
        super.setElevation(r10);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setPivotX(float r10) {
        this.mRotationCenterX = r10;
        transform();
    }

    @Override // android.view.View
    public void setPivotY(float r10) {
        this.mRotationCenterY = r10;
        transform();
    }

    @Override // android.view.View
    public void setRotation(float r10) {
        this.mGroupRotateAngle = r10;
        transform();
    }

    @Override // android.view.View
    public void setScaleX(float r10) {
        this.mScaleX = r10;
        transform();
    }

    @Override // android.view.View
    public void setScaleY(float r10) {
        this.mScaleY = r10;
        transform();
    }

    @Override // android.view.View
    public void setTranslationX(float r10) {
        this.mShiftX = r10;
        transform();
    }

    @Override // android.view.View
    public void setTranslationY(float r10) {
        this.mShiftY = r10;
        transform();
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout r10) {
        reCacheViews();
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        ConstraintWidget r11 = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
        r11.setWidth(0);
        r11.setHeight(0);
        calcCenters();
        layout(((int) this.mComputedMinX) - getPaddingLeft(), ((int) this.mComputedMinY) - getPaddingTop(), ((int) this.mComputedMaxX) + getPaddingRight(), ((int) this.mComputedMaxY) + getPaddingBottom());
        transform();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout r10) {
        this.mContainer = r10;
        float r11 = getRotation();
        if (r11 == 0.0f) goto L5;
    L6:
        this.mGroupRotateAngle = r11;
        return;
    L5:
        if (Float.isNaN(this.mGroupRotateAngle) == false) goto L6;
    }
}
