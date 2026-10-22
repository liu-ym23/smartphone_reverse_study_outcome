package com.larus.common_ui.photoviewer.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import j19.c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k19.b;
import k19.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l19.d;
import l19.f;
import l19.h;
import l19.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001T\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u000bH\u0014J\u0012\u0010Z\u001a\u00020W2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0014J\n\u0010]\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010^\u001a\u00020-2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020W2\u0006\u0010b\u001a\u00020-H\u0016J\u0010\u0010c\u001a\u00020-2\u0006\u0010d\u001a\u00020`H\u0016J\u0010\u0010e\u001a\u00020W2\u0006\u0010f\u001a\u00020 H\u0016J\u0010\u0010g\u001a\u00020W2\u0006\u0010f\u001a\u00020 H\u0016J\u0010\u0010h\u001a\u00020W2\u0006\u0010i\u001a\u00020\u000fH\u0002J\u0010\u0010j\u001a\u00020W2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010k\u001a\u00020W2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0014\u0010l\u001a\u00020W*\u00020\u00162\u0006\u0010i\u001a\u00020\u000fH\u0002J\u0010\u0010m\u001a\u00020W2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0012\u0010n\u001a\u00020W*\u00020\u000f2\u0006\u0010o\u001a\u00020\u0014J\b\u0010p\u001a\u00020WH\u0002J\u0018\u0010q\u001a\u00020W2\u0006\u0010r\u001a\u00020\u000f2\b\u0010O\u001a\u0004\u0018\u00010PJ\u000e\u0010s\u001a\u00020W2\u0006\u0010t\u001a\u00020\u0004R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020'8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u00020-2\u0006\u0010&\u001a\u00020-@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R&\u00102\u001a\u00020%2\u0006\u0010&\u001a\u00020%8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u00020-2\u0006\u0010&\u001a\u00020-@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010/\"\u0004\b8\u00101R\u001a\u00109\u001a\u00020-X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010/\"\u0004\b:\u00101R$\u0010;\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010A\u001a\u0004\u0018\u00010@2\b\u0010&\u001a\u0004\u0018\u00010@@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010F\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010K\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR\u000e\u0010N\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U¨\u0006u"}, d2 = {"Lcom/larus/common_ui/photoviewer/transition/TransitionLayout;", "Landroid/widget/FrameLayout;", "Lcom/larus/common_ui/photoviewer/gestures/GestureListener;", "Lcom/larus/common_ui/photoviewer/gestures/TransformGestureDetector;", "Lcom/larus/common_ui/photoviewer/transition/TransitionView;", "Lcom/larus/common_ui/photoviewer/transition/ITransitionParams;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "workingStartRect", "Landroid/graphics/Rect;", "workingEndRect", "currentViewRect", "tempRect", "tempRectF", "Landroid/graphics/RectF;", "tempTransform", "Landroid/graphics/Matrix;", "childView", "Landroid/view/View;", "animator", "Landroid/animation/ValueAnimator;", "detector", "transitionState", "transitionViewDelegate", "transitionListeners", "Ljava/util/LinkedHashSet;", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "Lkotlin/collections/LinkedHashSet;", "dragActionHelper", "Lcom/larus/common_ui/photoviewer/DragActionHelper;", "savedScaleFactor", "", "value", "", "transitionAnimationDuration", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "", "isDragTransitionEnabled", "()Z", "setDragTransitionEnabled", "(Z)V", "maxDragTransitionFactor", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "isDismissAnimatedEnable", "setDismissAnimatedEnable", "enterTransitionStartRect", "getEnterTransitionStartRect", "()Landroid/graphics/Rect;", "setEnterTransitionStartRect", "(Landroid/graphics/Rect;)V", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "restoreTransitionProvider", "getRestoreTransitionProvider", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", "pos", "getPos", "()I", "setPos", "(I)V", "dismissAnimationType", "getDismissAnimationType", "setDismissAnimationType", "isChildViewRequestDisallowInterceptTouchEvent", "endViewInfo", "Lcom/larus/common_ui/photoviewer/transition/TransitionEndViewInfo;", "animatorUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "animatorListener", "com/larus/common_ui/photoviewer/transition/TransitionLayout$animatorListener$1", "Lcom/larus/common_ui/photoviewer/transition/TransitionLayout$animatorListener$1;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "checkAndGetChildView", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "requestDisallowInterceptTouchEvent", "disallowIntercept", "onTouchEvent", "event", "addTransitionListener", "listener", "removeTransitionListener", "transformView", "rect", "onGestureBegin", "onGestureUpdate", "mapRect", "onGestureEnd", "set", "rectF", "updateWorkingEndRect", "startEnterTransition", "startRect", "setDelegateDragTransitionView", "transitionView", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransitionLayout extends FrameLayout implements b<e>, i, l19.a {
    public static final /* synthetic */ int w = 0;
    public final Rect a;
    public final Rect b;
    public final Rect c;
    public final Rect d;
    public final RectF e;
    public final Matrix f;
    public View g;
    public final ValueAnimator h;
    public final e i;
    public int j;
    public i k;
    public final LinkedHashSet<f> l;
    public final j19.b m;
    public long n;
    public boolean o;
    public boolean p;
    public final Rect q;
    public j19.e r;
    public int s;
    public int t;
    public boolean u;
    public l19.b v;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ TransitionLayout a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public a(TransitionLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            onAnimationEnd(r2);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            TransitionLayout r5 = this.a;
            int r0 = r5.j;
            Iterator<T> r1 = r5.l.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((f) r1.next()).onTransitionEnd(r5.j);
            goto L4
        L6:
            this.a.j = -1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            TransitionLayout r5 = this.a;
            Iterator<T> r0 = r5.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((f) r0.next()).onTransitionBegin(r5.j);
            goto L4
        L6:
            int r6 = this.a.j;
        }
    }

    public TransitionLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TransitionLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // l19.i
    public final View b() {
        return null;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return true;
    }

    public void setDismissAnimatedEnable(boolean r1) {
    }

    public final View a() {
        i r0 = this.k;
        if (r0 == null) goto L5;
        View r1 = r0.b();
    L6:
        if (r1 == null) goto L12;
        i r2 = this.k;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.b();
    L12:
        if (getChildCount() >= 2) goto L19;
        if (this.g != null) goto L17;
        this.g = getChildAt(0);
    L17:
        return this.g;
    L19:
        throw new IllegalStateException("only allow one child view");
    L5:
        r1 = null;
        goto L6
    }

    public final void g() {
        l19.b r0 = this.v;
        if (r0 == null) goto L5;
        Gravity.apply(r0.c, r0.a, r0.b, new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight()), this.b);
        return;
    L5:
        this.b.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // l19.a
    public float getMaxDragTransitionFactor() {
        return this.m.d;
    }

    @Override // l19.a
    public int getDismissAnimationType() {
        return this.t;
    }

    @Override // l19.a
    public Rect getEnterTransitionStartRect() {
        return this.q;
    }

    @Override // l19.a
    public int getPos() {
        return this.s;
    }

    @Override // l19.a
    public j19.e getRestoreTransitionProvider() {
        return this.r;
    }

    @Override // l19.a
    public long getTransitionAnimationDuration() {
        return this.n;
    }

    @Override // l19.a
    public final boolean isDragTransitionEnabled() {
        return this.o;
    }

    @Override // l19.a
    public final boolean isSingleTagDismissEnabled() {
        return this.p;
    }

    @Override // l19.i
    public final void c(f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.l.add(r2);
        i r0 = this.k;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.c(r2);
        return;
    L8:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        boolean r1 = false;
        if (this.h.isRunning() == false) goto L6;
        return false;
    L6:
        if (r6 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L14;
        this.u = false;
    L14:
        if (this.k != null) goto L26;
        if (this.u == true) goto L26;
        if (r6 == null) goto L19;
        this.i.b(r6);
    L19:
        ViewParent r3 = getParent();
        if (r3 == null) goto L26;
        if (this.j != 3) goto L24;
        r1 = true;
    L24:
        r3.requestDisallowInterceptTouchEvent(r1);
    L26:
        return super.dispatchTouchEvent(r6);
    L8:
        if (r6.getAction() != 0) goto L10;
        r2 = true;
        goto L11
    }

    @Override // l19.i
    public final void e(f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.l.remove(r2);
        i r0 = this.k;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.e(r2);
        return;
    L8:
        return;
    }

    public final void f(Rect r4) {
        View r0 = a();
        if (r0 != null) goto L5;
        return;
    L5:
        this.c.set(r4);
        r0.setX(r4.left);
        r0.setY(r4.top);
        r0.getLayoutParams().width = r4.width();
        r0.getLayoutParams().height = r4.height();
        r0.requestLayout();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        View r4 = a();
        if (r4 == null) goto L6;
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r4.post(new d(this));
        return;
    }

    @Override // k19.b
    public final void onGestureBegin(e r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        this.j = -1;
    }

    @Override // k19.b
    public final void onGestureEnd(e r4) {
        Intrinsics.checkNotNullParameter(r4, "detector");
        this.m.a();
        if (this.j != 3) goto L33;
        Iterator<T> r5 = this.l.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        ((f) r5.next()).onTransitionEnd(this.j);
        goto L6
    L8:
        j19.b r6 = this.m;
        boolean r1 = false;
        if ((r6.b.f / r6.c) <= r6.d) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L30;
        this.a.set(this.c);
        j19.e r8 = getRestoreTransitionProvider();
        if (r8 == null) goto L18;
        View r9 = r8.d(getPos());
        if (r9 == null) goto L18;
        Rect r10 = h.a(r9);
    L19:
        if (r10 != null) goto L21;
    L23:
        if (r1 == false) goto L25;
        Rect r0 = this.b;
        Intrinsics.checkNotNull(r10);
        r0.set(r10);
    L29:
        this.j = 2;
        this.h.start();
        return;
    L25:
        this.f.reset();
        if (getDismissAnimationType() != 0) goto L28;
        this.f.postScale(0.1f, 0.1f, this.c.centerX(), this.c.centerY());
    L28:
        this.d.set(this.a);
        d(this.f, this.d);
        this.b.set(this.d);
        goto L29
    L21:
        if (r10.isEmpty() == true) goto L23;
        r1 = true;
    L18:
        r10 = null;
        goto L19
    L30:
        this.a.set(this.c);
        this.j = 1;
        this.h.start();
        return;
    L11:
        r7 = false;
        goto L12
    }

    @Override // k19.b
    public final void onGestureUpdate(e r5) {
        Intrinsics.checkNotNullParameter(r5, "detector");
        if (this.i.l != 4) goto L14;
        if (this.j == 3) goto L14;
        if (this.o == false) goto L14;
        this.j = 3;
        Iterator<T> r6 = this.l.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        ((f) r6.next()).onTransitionBegin(this.j);
        goto L10
    L12:
        this.a.set(this.c);
    L14:
        if (this.j != 3) goto L19;
        this.f.reset();
        this.f.postScale(this.m.a(), this.m.a(), this.a.centerX(), this.a.centerY());
        Matrix r7 = this.f;
        e r0 = this.i;
        r7.postTranslate(r0.e, r0.f);
        this.d.set(this.a);
        d(this.f, this.d);
        f(this.d);
        Iterator<T> r8 = this.l.iterator();
    L17:
        if (r8.hasNext() == false) goto L22;
        f r1 = (f) r8.next();
        int r2 = this.j;
        j19.b r3 = this.m;
        r1.onTransitionChanged(r2, r3.b.f / r3.c);
        goto L17
    L22:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
        this.u = r1;
    }

    public final void setDelegateDragTransitionView(i r4) {
        Intrinsics.checkNotNullParameter(r4, "transitionView");
        i r0 = this.k;
        if (r0 == null) goto L8;
        Iterator<T> r1 = this.l.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r0.e((f) r1.next());
    L8:
        this.k = r4;
        Iterator<T> r5 = this.l.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        f r2 = (f) r5.next();
        i r3 = this.k;
        if (r3 == null) goto L10;
        r3.c(r2);
        goto L10
    L14:
        i r6 = this.k;
        if (r6 == null) goto L24;
        c.e(r6, this);
        return;
    }

    @Override // l19.a
    public void setDismissAnimationType(int r1) {
        this.t = r1;
        i r2 = this.k;
        if (r2 == null) goto L6;
        c.e(r2, this);
        return;
    }

    @Override // l19.a
    public void setDragTransitionEnabled(boolean r1) {
        this.o = r1;
        i r2 = this.k;
        if (r2 == null) goto L6;
        c.e(r2, this);
        return;
    }

    @Override // l19.a
    public void setEnterTransitionStartRect(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.q.set(r2);
        i r3 = this.k;
        if (r3 == null) goto L6;
        c.e(r3, this);
        return;
    }

    @Override // l19.a
    public void setMaxDragTransitionFactor(float r2) {
        this.m.d = r2;
        i r3 = this.k;
        if (r3 == null) goto L6;
        c.e(r3, this);
        return;
    }

    @Override // l19.a
    public void setPos(int r1) {
        this.s = r1;
        i r2 = this.k;
        if (r2 == null) goto L6;
        c.e(r2, this);
        return;
    }

    @Override // l19.a
    public void setRestoreTransitionProvider(j19.e r1) {
        this.r = r1;
        i r2 = this.k;
        if (r2 == null) goto L6;
        c.e(r2, this);
        return;
    }

    @Override // l19.a
    public void setSingleTagDismissEnabled(boolean r1) {
        this.p = r1;
        i r2 = this.k;
        if (r2 == null) goto L6;
        c.e(r2, this);
        return;
    }

    @Override // l19.a
    public void setTransitionAnimationDuration(long r2) {
        this.n = r2;
        this.h.setDuration(r2);
        i r3 = this.k;
        if (r3 == null) goto L6;
        c.e(r3, this);
        return;
    }

    public final void d(Matrix r2, Rect r3) {
        this.e.set(r3);
        r2.mapRect(this.e);
        RectF r4 = this.e;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "rectF");
        r3.left = (int) r4.left;
        r3.top = (int) r4.top;
        r3.right = (int) r4.right;
        r3.bottom = (int) r4.bottom;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        if (this.j != (-1)) goto L6;
        g();
        this.c.set(this.b);
        return;
    }

    public TransitionLayout(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new Rect();
        this.d = new Rect();
        this.e = new RectF();
        this.f = new Matrix();
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.h = r8;
        e r0 = new e();
        this.i = r0;
        this.j = -1;
        this.l = new LinkedHashSet();
        this.m = new j19.b(r5, r0);
        this.n = 300;
        this.o = true;
        this.p = true;
        this.q = new Rect();
        this.s = -1;
        ValueAnimator.AnimatorUpdateListener r9 = new l19.c(this);
        a r1 = new a(this);
        if (r0.c.contains(2) == true) goto L5;
        r0.c.add(2);
    L5:
        r8.addUpdateListener(r9);
        r8.addListener(r1);
        r8.setDuration(getTransitionAnimationDuration());
        Intrinsics.checkNotNullParameter(this, "listener");
        r0.a.add(this);
    }

    public /* synthetic */ TransitionLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
