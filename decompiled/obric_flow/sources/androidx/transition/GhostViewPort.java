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

    public GhostViewPort(View r5) {
        super(r5.getContext());
        this.mOnPreDrawListener = new AnonymousClass1(this);
        this.mView = r5;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, null);
    }

    public static GhostViewPort addGhost(View r5, ViewGroup r10, Matrix r11) {
        if ((r5.getParent() instanceof ViewGroup) == false) goto L23;
        GhostViewHolder r12 = GhostViewHolder.getHolder(r10);
        GhostViewPort r13 = getGhostView(r5);
        if (r13 == null) goto L9;
        GhostViewHolder r14 = (GhostViewHolder) r13.getParent();
        if (r14 == r12) goto L9;
        int r15 = r13.mReferences;
        r14.removeView(r13);
        r13 = null;
    L10:
        if (r13 != null) goto L18;
        if (r11 != null) goto L13;
        r11 = new Matrix();
        calculateMatrix(r5, r10, r11);
    L13:
        r13 = new GhostViewPort(r5);
        r13.setMatrix(r11);
        if (r12 != null) goto L16;
        r12 = new GhostViewHolder(r10);
    L17:
        copySize(r10, r12);
        copySize(r10, r13);
        r12.addGhostView(r13);
        r13.mReferences = r15;
    L20:
        r13.mReferences++;
        return r13;
    L16:
        r12.popToOverlayTop();
        goto L17
    L18:
        if (r11 == null) goto L20;
        r13.setMatrix(r11);
    L9:
        r15 = 0;
        goto L10
    L23:
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    public static void calculateMatrix(View r5, ViewGroup r10, Matrix r11) {
        ViewGroup r12 = (ViewGroup) r5.getParent();
        r11.reset();
        ViewUtils.transformMatrixToGlobal(r12, r11);
        r11.preTranslate(-r12.getScrollX(), -r12.getScrollY());
        ViewUtils.transformMatrixToLocal(r10, r11);
    }

    public static void copySize(View r5, View r10) {
        int r11 = r10.getLeft();
        int r12 = r10.getTop();
        int r13 = r10.getLeft();
        int r14 = r5.getWidth() + r13;
        int r15 = r10.getTop();
        ViewUtils.setLeftTopRightBottom(r10, r11, r12, r14, r5.getHeight() + r15);
    }

    public static GhostViewPort getGhostView(View r5) {
        return (GhostViewPort) r5.getTag(R.id.ghost_view);
    }

    public static void removeGhost(View r5) {
        GhostViewPort r10 = getGhostView(r5);
        if (r10 == null) goto L8;
        int r11 = r10.mReferences - 1;
        r10.mReferences = r11;
        if (r11 > 0) goto L9;
        ((GhostViewHolder) r10.getParent()).removeView(r10);
        return;
    L9:
        return;
    }

    public static void setGhostView(@NonNull View r5, @Nullable GhostViewPort r10) {
        r5.setTag(R.id.ghost_view, r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setGhostView(this.mView, this);
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 4);
        if (this.mView.getParent() == null) goto L6;
        ((View) this.mView.getParent()).invalidate();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        setGhostView(this.mView, null);
        if (this.mView.getParent() == null) goto L5;
        ((View) this.mView.getParent()).invalidate();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas r5) {
        CanvasUtils.enableZ(r5, true);
        r5.setMatrix(this.mMatrix);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        this.mView.invalidate();
        ViewUtils.setTransitionVisibility(this.mView, 4);
        drawChild(r5, this.mView, getDrawingTime());
        CanvasUtils.enableZ(r5, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup r5, View r10) {
        this.mStartParent = r5;
        this.mStartView = r10;
    }

    public void setMatrix(@NonNull Matrix r5) {
        this.mMatrix = r5;
    }

    @Override // android.view.View, androidx.transition.GhostView
    public void setVisibility(int r5) {
        super.setVisibility(r5);
        if (getGhostView(this.mView) != this) goto L9;
        if (r5 != 0) goto L6;
        int r10 = 4;
    L7:
        ViewUtils.setTransitionVisibility(this.mView, r10);
        return;
    L6:
        r10 = 0;
        goto L7
    }
}
