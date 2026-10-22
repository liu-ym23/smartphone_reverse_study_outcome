package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements MotionHelperInterface {
    private float mProgress;
    private boolean mUseOnHide;
    private boolean mUseOnShow;
    protected View[] views;

    public MotionHelper(Context r10) {
        super(r10);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
    }

    public MotionHelper(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(r11);
    }

    public MotionHelper(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(r11);
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public float getProgress() {
        return this.mProgress;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r10) {
        super.init(r10);
        if (r10 == null) goto L19;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.MotionHelper);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L13;
        int r14 = r11.getIndex(r13);
        if (r14 != R.styleable.MotionHelper_onShow) goto L10;
        this.mUseOnShow = r11.getBoolean(r14, this.mUseOnShow);
    L12:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R.styleable.MotionHelper_onHide) goto L12;
        this.mUseOnHide = r11.getBoolean(r14, this.mUseOnHide);
        goto L12
    L13:
        r11.recycle();
        return;
    }

    public boolean isDecorator() {
        return false;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onFinishedMotionScene(MotionLayout r10) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPostDraw(Canvas r10) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreDraw(Canvas r10) {
    }

    public void onPreSetup(MotionLayout r10, HashMap<View, MotionController> r11) {
    }

    public void onTransitionChange(MotionLayout r10, int r11, int r12, float r13) {
    }

    public void onTransitionCompleted(MotionLayout r10, int r11) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionStarted(MotionLayout r10, int r11, int r12) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionTrigger(MotionLayout r10, int r11, boolean r12, float r13) {
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public void setProgress(float r10) {
        this.mProgress = r10;
        int r11 = 0;
        if (this.mCount <= 0) goto L8;
        this.views = getViews((ConstraintLayout) getParent());
    L6:
        if (r11 >= this.mCount) goto L15;
        setProgress(this.views[r11], r10);
        r11 = r11 + 1;
        goto L6
    L15:
        return;
    L8:
        ViewGroup r12 = (ViewGroup) getParent();
        int r13 = r12.getChildCount();
    L9:
        if (r11 >= r13) goto L20;
        View r14 = r12.getChildAt(r11);
        if ((r14 instanceof MotionHelper) == true) goto L14;
        setProgress(r14, r10);
    L14:
        r11 = r11 + 1;
        goto L9
    }

    public void setProgress(View r10, float r11) {
    }
}
