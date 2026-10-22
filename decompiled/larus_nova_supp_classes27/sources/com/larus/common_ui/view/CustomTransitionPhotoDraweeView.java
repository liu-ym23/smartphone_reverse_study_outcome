package com.larus.common_ui.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.larus.common_ui.photoviewer.PhotoDraweeView;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB'\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000eJ\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0006\u0010(\u001a\u00020\u0017J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0013H\u0016J\u001a\u0010*\u001a\u00020\u00172\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00170,J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020-2\u0006\u00102\u001a\u000203H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u00104\u001a\u00020\tX\u0096\u000f¢\u0006\f\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$R\u0018\u00107\u001a\u000208X\u0096\u000f¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0018\u0010=\u001a\u00020-X\u0096\u000f¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0018\u0010A\u001a\u00020-X\u0096\u000f¢\u0006\f\u001a\u0004\bA\u0010>\"\u0004\bB\u0010@R\u0018\u0010C\u001a\u00020-X\u0096\u000f¢\u0006\f\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R\u0018\u0010E\u001a\u00020\u001dX\u0096\u000f¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0018\u0010J\u001a\u00020\tX\u0096\u000f¢\u0006\f\u001a\u0004\bK\u0010\"\"\u0004\bL\u0010$R\u001a\u0010M\u001a\u0004\u0018\u00010NX\u0096\u000f¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0018\u0010S\u001a\u00020TX\u0096\u000f¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X¨\u0006Y"}, d2 = {"Lcom/larus/common_ui/view/CustomTransitionPhotoDraweeView;", "Lcom/larus/common_ui/photoviewer/PhotoDraweeView;", "Lcom/larus/common_ui/photoviewer/transition/TransitionView;", "Lcom/larus/common_ui/photoviewer/transition/ITransitionParams;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "controllerImp", "Lcom/larus/common_ui/view/CustomZoomableControllerImpl;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/larus/common_ui/view/CustomZoomableControllerImpl;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getControllerImp", "()Lcom/larus/common_ui/view/CustomZoomableControllerImpl;", "transitionListeners", "Ljava/util/LinkedHashSet;", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "Lkotlin/collections/LinkedHashSet;", "dismissCallback", "Lkotlin/Function0;", "", "getDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "dismissOffset", "", "startX", "startY", "slideDirection", "getSlideDirection", "()I", "setSlideDirection", "(I)V", "transitionListenerWrapper", "addTransitionListener", "listener", "dismissAnimated", "removeTransitionListener", "setOnScaleChangeCallback", "callback", "Lkotlin/Function1;", "", "hasScale", "matrix", "Landroid/graphics/Matrix;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "dismissAnimationType", "getDismissAnimationType", "setDismissAnimationType", "enterTransitionStartRect", "Landroid/graphics/Rect;", "getEnterTransitionStartRect", "()Landroid/graphics/Rect;", "setEnterTransitionStartRect", "(Landroid/graphics/Rect;)V", "isDismissAnimatedEnable", "()Z", "setDismissAnimatedEnable", "(Z)V", "isDragTransitionEnabled", "setDragTransitionEnabled", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "maxDragTransitionFactor", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", "pos", "getPos", "setPos", "restoreTransitionProvider", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "getRestoreTransitionProvider", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", "transitionAnimationDuration", "", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomTransitionPhotoDraweeView extends PhotoDraweeView implements l19.i, l19.a {
    public static final /* synthetic */ int s = 0;
    public final s l;
    public final LinkedHashSet<l19.f> m;
    public Function0<Unit> n;
    public final float o;
    public int p;
    public int q;
    public int r;

    public CustomTransitionPhotoDraweeView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomTransitionPhotoDraweeView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // l19.i
    public final View b() {
        return null;
    }

    @Override // l19.a
    public void setEnterTransitionStartRect(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l.setEnterTransitionStartRect(r2);
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
    public j19.e getRestoreTransitionProvider() {
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

    @Override // l19.a
    public final boolean isSingleTagDismissEnabled() {
        return this.l.M;
    }

    public final s getControllerImp() {
        return this.l;
    }

    public final Function0<Unit> getDismissCallback() {
        return this.n;
    }

    public final int getSlideDirection() {
        return this.r;
    }

    @Override // l19.i
    public final void c(l19.f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.m.add(r2);
    }

    @Override // l19.i
    public final void e(l19.f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.m.remove(r2);
    }

    @Override // com.larus.common_ui.photoviewer.PhotoDraweeView
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        boolean r0 = super.onTouchEvent(r8);
        int r1 = r8.getAction();
        if (r1 != 0) goto L5;
        this.p = (int) r8.getX();
        this.q = (int) r8.getY();
    L32:
        return r0;
    L5:
        if (r1 != 2) goto L32;
        int r2 = (int) r8.getX();
        int r9 = (int) r8.getY();
        int r3 = Math.abs(r2 - this.p);
        int r4 = Math.abs(r9 - this.q);
        boolean r5 = false;
        if ((r2 - this.p) <= 0) goto L16;
        if (r3 <= r4) goto L16;
        if (r3 <= this.o) goto L16;
        if (r0 == true) goto L16;
        if (this.r != 1) goto L16;
        boolean r6 = true;
    L18:
        if ((r9 - this.q) <= 0) goto L26;
        if (r4 <= r3) goto L26;
        if (r4 <= this.o) goto L26;
        if (r0 == true) goto L26;
        if (this.r != 0) goto L26;
        r5 = true;
    L26:
        if (r6 == true) goto L28;
        if (r5 == false) goto L32;
    L28:
        Function0<Unit> r10 = this.n;
        if (r10 == null) goto L32;
        r10.invoke();
    L16:
        r6 = false;
        goto L18
    }

    public void setDismissAnimatedEnable(boolean r2) {
        this.l.O = r2;
    }

    @Override // l19.a
    public void setDismissAnimationType(int r2) {
        this.l.R = r2;
    }

    public final void setDismissCallback(Function0<Unit> r1) {
        this.n = r1;
    }

    @Override // l19.a
    public void setDragTransitionEnabled(boolean r2) {
        this.l.L = r2;
    }

    @Override // l19.a
    public void setMaxDragTransitionFactor(float r2) {
        this.l.I.d = r2;
    }

    public final void setOnScaleChangeCallback(final Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        s r0 = this.l;
        Function1<? super Matrix, Unit> r1 = new o(r3, this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        r0.T = r1;
    }

    @Override // l19.a
    public void setPos(int r2) {
        this.l.Q = r2;
    }

    @Override // l19.a
    public void setRestoreTransitionProvider(j19.e r2) {
        this.l.P = r2;
    }

    @Override // l19.a
    public void setSingleTagDismissEnabled(boolean r2) {
        this.l.M = r2;
    }

    public final void setSlideDirection(int r1) {
        this.r = r1;
    }

    @Override // l19.a
    public void setTransitionAnimationDuration(long r2) {
        this.l.K = r2;
    }

    public CustomTransitionPhotoDraweeView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        s r0 = new s(new k19.e(), r3);
        super(r3, r4, r5);
        this.l = r0;
        this.m = new LinkedHashSet();
        this.o = 30.0f;
        this.r = 1;
        r0.c(new p(this));
        setZoomableControllerImp(r0);
        setGestureHandler(new k19.f(r0));
    }

    public /* synthetic */ CustomTransitionPhotoDraweeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
