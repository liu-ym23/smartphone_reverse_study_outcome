package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class VirtualLayout extends ConstraintHelper {
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;

    public VirtualLayout(Context r5) {
        super(r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r10) {
        super.init(r10);
        if (r10 == null) goto L19;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r5 = r11.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r5) goto L13;
        int r13 = r11.getIndex(r12);
        if (r13 != R.styleable.ConstraintLayout_Layout_android_visibility) goto L10;
        this.mApplyVisibilityOnAttach = true;
    L12:
        r12 = r12 + 1;
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
        if (this.mApplyVisibilityOnAttach == false) goto L5;
    L6:
        ViewParent r5 = getParent();
        if (r5 != null) goto L9;
        return;
    L9:
        if ((r5 instanceof ConstraintLayout) == false) goto L31;
        ConstraintLayout r10 = (ConstraintLayout) r5;
        int r11 = getVisibility();
        float r12 = getElevation();
        int r13 = 0;
    L12:
        if (r13 >= this.mCount) goto L32;
        View r14 = r10.getViewById(this.mIds[r13]);
        if (r14 == null) goto L23;
        if (this.mApplyVisibilityOnAttach == false) goto L19;
        r14.setVisibility(r11);
    L19:
        if (this.mApplyElevationOnAttach == false) goto L23;
        if (r12 <= 0.0f) goto L23;
        r14.setTranslationZ(r14.getTranslationZ() + r12);
    L23:
        r13 = r13 + 1;
        goto L12
    L32:
        return;
    L31:
        return;
    L5:
        if (this.mApplyElevationOnAttach == true) goto L6;
    }

    public void onMeasure(androidx.constraintlayout.solver.widgets.VirtualLayout r5, int r10, int r11) {
    }

    @Override // android.view.View
    public void setElevation(float r5) {
        super.setElevation(r5);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        super.setVisibility(r5);
        applyLayoutFeatures();
    }

    public VirtualLayout(Context r5, AttributeSet r10) {
        super(r5, r10);
    }

    public VirtualLayout(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }
}
