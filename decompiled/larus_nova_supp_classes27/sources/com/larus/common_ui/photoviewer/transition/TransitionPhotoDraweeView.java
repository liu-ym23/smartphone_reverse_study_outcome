package com.larus.common_ui.photoviewer.transition;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.larus.common_ui.photoviewer.PhotoDraweeView;
import j19.e;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l19.a;
import l19.f;
import l19.g;
import l19.i;
import l19.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB'\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0006\u0010\u0016\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u00020\tX\u0096\u000f¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u00020\u001eX\u0096\u000f¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010#\u001a\u00020$X\u0096\u000f¢\u0006\f\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R\u0018\u0010(\u001a\u00020$X\u0096\u000f¢\u0006\f\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u0018\u0010*\u001a\u00020$X\u0096\u000f¢\u0006\f\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u0018\u0010,\u001a\u00020-X\u0096\u000f¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00102\u001a\u00020\tX\u0096\u000f¢\u0006\f\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u001a\u00105\u001a\u0004\u0018\u000106X\u0096\u000f¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0018\u0010;\u001a\u00020<X\u0096\u000f¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lcom/larus/common_ui/photoviewer/transition/TransitionPhotoDraweeView;", "Lcom/larus/common_ui/photoviewer/PhotoDraweeView;", "Lcom/larus/common_ui/photoviewer/transition/TransitionView;", "Lcom/larus/common_ui/photoviewer/transition/ITransitionParams;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "controllerImp", "Lcom/larus/common_ui/photoviewer/transition/TransitionZoomableControllerImp;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/larus/common_ui/photoviewer/transition/TransitionZoomableControllerImp;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "transitionListeners", "Ljava/util/LinkedHashSet;", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "transitionListenerWrapper", "addTransitionListener", "", "listener", "dismissAnimated", "removeTransitionListener", "dismissAnimationType", "getDismissAnimationType", "()I", "setDismissAnimationType", "(I)V", "enterTransitionStartRect", "Landroid/graphics/Rect;", "getEnterTransitionStartRect", "()Landroid/graphics/Rect;", "setEnterTransitionStartRect", "(Landroid/graphics/Rect;)V", "isDismissAnimatedEnable", "", "()Z", "setDismissAnimatedEnable", "(Z)V", "isDragTransitionEnabled", "setDragTransitionEnabled", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "maxDragTransitionFactor", "", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", "pos", "getPos", "setPos", "restoreTransitionProvider", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "getRestoreTransitionProvider", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", "transitionAnimationDuration", "", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransitionPhotoDraweeView extends PhotoDraweeView implements i, a {
    public final l l;
    public final LinkedHashSet<f> m;

    public TransitionPhotoDraweeView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TransitionPhotoDraweeView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // l19.i
    public final View b() {
        return null;
    }

    @Override // l19.a
    public final boolean isSingleTagDismissEnabled() {
        return this.l.isSingleTagDismissEnabled();
    }

    public void setDismissAnimatedEnable(boolean r2) {
        this.l.B(r2);
    }

    @Override // l19.a
    public void setEnterTransitionStartRect(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l.setEnterTransitionStartRect(r2);
    }

    @Override // l19.a
    public void setSingleTagDismissEnabled(boolean r2) {
        this.l.setSingleTagDismissEnabled(r2);
    }

    @Override // l19.a
    public int getDismissAnimationType() {
        return this.l.R;
    }

    @Override // l19.a
    public Rect getEnterTransitionStartRect() {
        return this.l.N;
    }

    @Override // l19.a
    public float getMaxDragTransitionFactor() {
        return this.l.I.d;
    }

    @Override // l19.a
    public int getPos() {
        return this.l.Q;
    }

    @Override // l19.a
    public e getRestoreTransitionProvider() {
        return this.l.P;
    }

    @Override // l19.a
    public long getTransitionAnimationDuration() {
        return this.l.K;
    }

    @Override // l19.a
    public final boolean isDragTransitionEnabled() {
        return this.l.L;
    }

    @Override // l19.i
    public final void c(f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.m.add(r2);
    }

    @Override // l19.i
    public final void e(f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.m.remove(r2);
    }

    @Override // l19.a
    public void setDismissAnimationType(int r2) {
        this.l.R = r2;
    }

    @Override // l19.a
    public void setDragTransitionEnabled(boolean r2) {
        this.l.L = r2;
    }

    @Override // l19.a
    public void setMaxDragTransitionFactor(float r2) {
        this.l.I.d = r2;
    }

    @Override // l19.a
    public void setPos(int r2) {
        this.l.Q = r2;
    }

    @Override // l19.a
    public void setRestoreTransitionProvider(e r2) {
        this.l.P = r2;
    }

    @Override // l19.a
    public void setTransitionAnimationDuration(long r2) {
        this.l.K = r2;
    }

    public TransitionPhotoDraweeView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        l r0 = new l(new k19.e(), r3);
        super(r3, r4, r5);
        this.l = r0;
        this.m = new LinkedHashSet();
        r0.c(new g(this));
        setZoomableControllerImp(r0);
        setGestureHandler(new k19.f(r0));
    }

    public /* synthetic */ TransitionPhotoDraweeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
