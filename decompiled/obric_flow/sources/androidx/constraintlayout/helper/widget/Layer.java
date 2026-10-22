package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
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

    public Layer(Context r5) {
        super(r5);
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
        int r5 = this.mCount;
        if (r5 != 0) goto L8;
        return;
    L8:
        View[] r10 = this.mViews;
        if (r10 != null) goto L11;
    L12:
        this.mViews = new View[r5];
    L13:
        int r11 = 0;
    L15:
        if (r11 >= this.mCount) goto L17;
        int r12 = this.mIds[r11];
        this.mViews[r11] = this.mContainer.getViewById(r12);
        r11 = r11 + 1;
        goto L15
    L17:
        return;
    L11:
        if (r10.length == r5) goto L13;
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
        double r5 = 0.0d;
    L12:
        float r10 = (float) Math.sin(r5);
        float r11 = (float) Math.cos(r5);
        float r12 = this.mScaleX;
        float r13 = r12 * r11;
        float r14 = this.mScaleY;
        float r15 = (-r14) * r10;
        float r16 = r12 * r10;
        float r17 = r14 * r11;
        int r18 = 0;
    L14:
        if (r18 >= this.mCount) goto L19;
        View r19 = this.mViews[r18];
        int r20 = (r19.getRight() + r19.getLeft()) / 2;
        int r21 = (r19.getBottom() + r19.getTop()) / 2;
        float r22 = r20 - this.mComputedCenterX;
        float r23 = r21 - this.mComputedCenterY;
        float r24 = (((r15 * r23) + (r13 * r22)) - r22) + this.mShiftX;
        float r25 = (((r17 * r23) + (r22 * r16)) - r23) + this.mShiftY;
        r19.setTranslationX(r24);
        r19.setTranslationY(r25);
        r19.setScaleY(this.mScaleY);
        r19.setScaleX(this.mScaleX);
        if (Float.isNaN(this.mGroupRotateAngle) == true) goto L18;
        r19.setRotation(this.mGroupRotateAngle);
    L18:
        r18 = r18 + 1;
        goto L14
    L19:
        return;
    L11:
        r5 = Math.toRadians(this.mGroupRotateAngle);
        goto L12
    }

    public void calcCenters() {
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
        View[] r5 = getViews(this.mContainer);
        int r10 = 0;
        int r11 = r5[0].getLeft();
        int r12 = r5[0].getTop();
        int r13 = r5[0].getRight();
        int r14 = r5[0].getBottom();
    L20:
        if (r10 >= this.mCount) goto L22;
        View r15 = r5[r10];
        r11 = Math.min(r11, r15.getLeft());
        r12 = Math.min(r12, r15.getTop());
        r13 = Math.max(r13, r15.getRight());
        r14 = Math.max(r14, r15.getBottom());
        r10 = r10 + 1;
        goto L20
    L22:
        this.mComputedMaxX = r13;
        this.mComputedMaxY = r14;
        this.mComputedMinX = r11;
        this.mComputedMinY = r12;
        if (Float.isNaN(this.mRotationCenterX) == false) goto L25;
        this.mComputedCenterX = (r11 + r13) / 2;
    L27:
        if (Float.isNaN(this.mRotationCenterY) == false) goto L29;
        this.mComputedCenterY = (r12 + r14) / 2;
        return;
    L29:
        this.mComputedCenterY = this.mRotationCenterY;
        return;
    L25:
        this.mComputedCenterX = this.mRotationCenterX;
        goto L27
    L15:
        if (Float.isNaN(this.mRotationCenterY) == true) goto L18;
        this.mComputedCenterY = this.mRotationCenterY;
        this.mComputedCenterX = this.mRotationCenterX;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r10) {
        super.init(r10);
        int r5 = 0;
        this.mUseViewMeasure = false;
        if (r10 == null) goto L19;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r12 = r11.getIndexCount();
    L5:
        if (r5 >= r12) goto L13;
        int r13 = r11.getIndex(r5);
        if (r13 != R.styleable.ConstraintLayout_Layout_android_visibility) goto L10;
        this.mApplyVisibilityOnAttach = true;
    L12:
        r5 = r5 + 1;
        goto L5
    L10:
        if (r13 != R.styleable.ConstraintLayout_Layout_android_elevation) goto L12;
        this.mApplyElevationOnAttach = true;
        goto L12
    L13:
        r11.recycle();
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        if (this.mApplyVisibilityOnAttach == false) goto L5;
    L6:
        int r5 = getVisibility();
        float r10 = getElevation();
        int r11 = 0;
    L8:
        if (r11 >= this.mCount) goto L26;
        int r12 = this.mIds[r11];
        View r13 = this.mContainer.getViewById(r12);
        if (r13 == null) goto L19;
        if (this.mApplyVisibilityOnAttach == false) goto L15;
        r13.setVisibility(r5);
    L15:
        if (this.mApplyElevationOnAttach == false) goto L19;
        if (r10 <= 0.0f) goto L19;
        r13.setTranslationZ(r13.getTranslationZ() + r10);
    L19:
        r11 = r11 + 1;
        goto L8
    L26:
        return;
    L5:
        if (this.mApplyElevationOnAttach == true) goto L6;
    }

    @Override // android.view.View
    public void setElevation(float r5) {
        super.setElevation(r5);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setPivotX(float r5) {
        this.mRotationCenterX = r5;
        transform();
    }

    @Override // android.view.View
    public void setPivotY(float r5) {
        this.mRotationCenterY = r5;
        transform();
    }

    @Override // android.view.View
    public void setRotation(float r5) {
        this.mGroupRotateAngle = r5;
        transform();
    }

    @Override // android.view.View
    public void setScaleX(float r5) {
        this.mScaleX = r5;
        transform();
    }

    @Override // android.view.View
    public void setScaleY(float r5) {
        this.mScaleY = r5;
        transform();
    }

    @Override // android.view.View
    public void setTranslationX(float r5) {
        this.mShiftX = r5;
        transform();
    }

    @Override // android.view.View
    public void setTranslationY(float r5) {
        this.mShiftY = r5;
        transform();
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        super.setVisibility(r5);
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout r5) {
        reCacheViews();
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        ConstraintWidget r10 = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
        r10.setWidth(0);
        r10.setHeight(0);
        calcCenters();
        int r11 = ((int) this.mComputedMinX) - getPaddingLeft();
        int r12 = ((int) this.mComputedMinY) - getPaddingTop();
        int r13 = (int) this.mComputedMaxX;
        int r14 = getPaddingRight() + r13;
        int r15 = (int) this.mComputedMaxY;
        layout(r11, r12, r14, getPaddingBottom() + r15);
        transform();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout r5) {
        this.mContainer = r5;
        float r10 = getRotation();
        if (r10 == 0.0f) goto L5;
        this.mGroupRotateAngle = r10;
        return;
    L5:
        if (Float.isNaN(this.mGroupRotateAngle) == true) goto L9;
        this.mGroupRotateAngle = r10;
        return;
    }

    public Layer(Context r5, AttributeSet r10) {
        super(r5, r10);
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

    public Layer(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
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
}
