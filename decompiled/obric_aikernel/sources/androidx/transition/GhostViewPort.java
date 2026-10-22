package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class GhostViewPort extends ViewGroup implements GhostView {

    @Nullable
    private Matrix mMatrix;
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    int mReferences;
    ViewGroup mStartParent;
    View mStartView;
    final View mView;

    GhostViewPort(View r10) {
        super(r10.getContext());
        this.mOnPreDrawListener = new AnonymousClass1(this);
        this.mView = r10;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    static GhostViewPort addGhost(View r10, ViewGroup r11, Matrix r12) {
        if ((r10.getParent() instanceof ViewGroup) == false) goto L22;
        GhostViewHolder r13 = GhostViewHolder.getHolder(r11);
        GhostViewPort r14 = getGhostView(r10);
        int r15 = 0;
        if (r14 == null) goto L9;
        GhostViewHolder r16 = (GhostViewHolder) r14.getParent();
        if (r16 == r13) goto L9;
        r15 = r14.mReferences;
        r16.removeView(r14);
        r14 = null;
    L9:
        if (r14 != null) goto L17;
        if (r12 != null) goto L12;
        r12 = new Matrix();
        calculateMatrix(r10, r11, r12);
    L12:
        r14 = new GhostViewPort(r10);
        r14.setMatrix(r12);
        if (r13 != null) goto L15;
        r13 = new GhostViewHolder(r11);
    L16:
        copySize(r11, r13);
        copySize(r11, r14);
        r13.addGhostView(r14);
        r14.mReferences = r15;
    L19:
        r14.mReferences++;
        return r14;
    L15:
        r13.popToOverlayTop();
        goto L16
    L17:
        if (r12 == null) goto L19;
        r14.setMatrix(r12);
        goto L19
    L22:
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    static void calculateMatrix(View r10, ViewGroup r11, Matrix r12) {
        ViewGroup r13 = (ViewGroup) r10.getParent();
        r12.reset();
        ViewUtils.transformMatrixToGlobal(r13, r12);
        r12.preTranslate(-r13.getScrollX(), -r13.getScrollY());
        ViewUtils.transformMatrixToLocal(r11, r12);
    }

    static void copySize(View r10, View r11) {
        ViewUtils.setLeftTopRightBottom(r11, r11.getLeft(), r11.getTop(), r11.getLeft() + r10.getWidth(), r11.getTop() + r10.getHeight());
    }

    static GhostViewPort getGhostView(View r10) {
        return (GhostViewPort) r10.getTag(R.id.ghost_view);
    }

    static void removeGhost(View r10) {
        GhostViewPort r11 = getGhostView(r10);
        if (r11 == null) goto L8;
        int r12 = r11.mReferences - 1;
        r11.mReferences = r12;
        if (r12 > 0) goto L9;
        ((GhostViewHolder) r11.getParent()).removeView(r11);
        return;
    L9:
        return;
    }

    static void setGhostView(@NonNull View r10, @Nullable GhostViewPort r11) {
        r10.setTag(R.id.ghost_view, r11);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setGhostView(this.mView, this);
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 4);
        if (this.mView.getParent() == null) goto L6;
        ((View) this.mView.getParent()).invalidate();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        setGhostView(this.mView, null);
        if (this.mView.getParent() == null) goto L5;
        ((View) this.mView.getParent()).invalidate();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r10) {
        CanvasUtils.enableZ(r10, true);
        r10.setMatrix(this.mMatrix);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        this.mView.invalidate();
        ViewUtils.setTransitionVisibility(this.mView, 4);
        drawChild(r10, this.mView, getDrawingTime());
        CanvasUtils.enableZ(r10, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup r10, View r11) {
        this.mStartParent = r10;
        this.mStartView = r11;
    }

    void setMatrix(@NonNull Matrix r10) {
        this.mMatrix = r10;
    }

    @Override // android.view.View, androidx.transition.GhostView
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        if (getGhostView(this.mView) != this) goto L9;
        if (r10 != 0) goto L6;
        int r11 = 4;
    L7:
        ViewUtils.setTransitionVisibility(this.mView, r11);
        return;
    L6:
        r11 = 0;
        goto L7
    }
}
