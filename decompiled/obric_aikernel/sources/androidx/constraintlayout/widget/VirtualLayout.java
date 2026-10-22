package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class VirtualLayout extends ConstraintHelper {
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;

    public VirtualLayout(Context r10) {
        super(r10);
    }

    public VirtualLayout(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public VirtualLayout(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void applyLayoutFeaturesInConstraintSet(ConstraintLayout r10) {
        applyLayoutFeatures(r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r10) {
        super.init(r10);
        if (r10 == null) goto L19;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L13;
        int r14 = r11.getIndex(r13);
        if (r14 != R.styleable.ConstraintLayout_Layout_android_visibility) goto L10;
        this.mApplyVisibilityOnAttach = true;
    L12:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R.styleable.ConstraintLayout_Layout_android_elevation) goto L12;
        this.mApplyElevationOnAttach = true;
        goto L12
    L13:
        r11.recycle();
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mApplyVisibilityOnAttach == false) goto L5;
    L6:
        ViewParent r10 = getParent();
        if ((r10 instanceof ConstraintLayout) == false) goto L35;
        ConstraintLayout r11 = (ConstraintLayout) r10;
        int r12 = getVisibility();
        if (Build.VERSION.SDK_INT < 21) goto L11;
        float r13 = getElevation();
    L12:
        int r14 = 0;
    L14:
        if (r14 >= this.mCount) goto L36;
        View r15 = r11.getViewById(this.mIds[r14]);
        if (r15 == null) goto L27;
        if (this.mApplyVisibilityOnAttach == false) goto L21;
        r15.setVisibility(r12);
    L21:
        if (this.mApplyElevationOnAttach == false) goto L27;
        if (r13 <= 0.0f) goto L27;
        if (Build.VERSION.SDK_INT < 21) goto L27;
        r15.setTranslationZ(r15.getTranslationZ() + r13);
    L27:
        r14 = r14 + 1;
        goto L14
    L36:
        return;
    L11:
        r13 = 0.0f;
        goto L12
    L35:
        return;
    L5:
        if (this.mApplyElevationOnAttach == true) goto L6;
    }

    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout r10, int r11, int r12) {
    }

    @Override // android.view.View
    public void setElevation(float r10) {
        super.setElevation(r10);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        applyLayoutFeatures();
    }
}
