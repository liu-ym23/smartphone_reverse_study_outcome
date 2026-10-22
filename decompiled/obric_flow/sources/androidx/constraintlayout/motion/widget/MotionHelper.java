package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements Animatable, MotionLayout.TransitionListener {
    private float mProgress;
    private boolean mUseOnHide;
    private boolean mUseOnShow;
    protected View[] views;

    public MotionHelper(Context r5) {
        super(r5);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public float getProgress() {
        return this.mProgress;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r5) {
        super.init(r5);
        if (r5 == null) goto L19;
        TypedArray r10 = getContext().obtainStyledAttributes(r5, R.styleable.MotionHelper);
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L13;
        int r13 = r10.getIndex(r12);
        if (r13 != R.styleable.MotionHelper_onShow) goto L10;
        this.mUseOnShow = r10.getBoolean(r13, this.mUseOnShow);
    L12:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != R.styleable.MotionHelper_onHide) goto L12;
        this.mUseOnHide = r10.getBoolean(r13, this.mUseOnHide);
        goto L12
    L13:
        r10.recycle();
        return;
    }

    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout r5, int r10, int r11, float r12) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout r5, int r10) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionStarted(MotionLayout r5, int r10, int r11) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionTrigger(MotionLayout r5, int r10, boolean r11, float r12) {
    }

    public void setProgress(View r5, float r10) {
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public void setProgress(float r10) {
        this.mProgress = r10;
        int r5 = 0;
        if (this.mCount <= 0) goto L8;
        this.views = getViews((ConstraintLayout) getParent());
    L6:
        if (r5 >= this.mCount) goto L15;
        setProgress(this.views[r5], r10);
        r5 = r5 + 1;
        goto L6
    L15:
        return;
    L8:
        ViewGroup r11 = (ViewGroup) getParent();
        int r12 = r11.getChildCount();
    L9:
        if (r5 >= r12) goto L20;
        View r13 = r11.getChildAt(r5);
        if ((r13 instanceof MotionHelper) == true) goto L14;
        setProgress(r13, r10);
    L14:
        r5 = r5 + 1;
        goto L9
    }

    public MotionHelper(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(r10);
    }

    public MotionHelper(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(r10);
    }
}
