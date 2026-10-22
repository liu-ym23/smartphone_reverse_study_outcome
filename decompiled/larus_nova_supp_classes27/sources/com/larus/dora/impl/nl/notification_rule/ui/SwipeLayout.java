package com.larus.dora.impl.nl.notification_rule.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0002./B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\"\u001a\u00020#H\u0014J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000bJ\u0006\u0010&\u001a\u00020#J\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020#J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020#H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/SwipeLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxSwipeDistance", "", "swipeThreshold", "touchSlop", "minFlingVelocity", "onSwipeListener", "Lcom/larus/dora/impl/nl/notification_rule/ui/SwipeLayout$OnSwipeListener;", "getOnSwipeListener", "()Lcom/larus/dora/impl/nl/notification_rule/ui/SwipeLayout$OnSwipeListener;", "setOnSwipeListener", "(Lcom/larus/dora/impl/nl/notification_rule/ui/SwipeLayout$OnSwipeListener;)V", "contentView", "Landroid/view/View;", "menuView", "value", "", "isOpen", "()Z", "isDragging", "downX", "downY", "lastX", "velocityTracker", "Landroid/view/VelocityTracker;", "onFinishInflate", "", "setMaxSwipeDistance", "distance", "open", "close", "toggle", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "onDetachedFromWindow", "Companion", "OnSwipeListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwipeLayout extends FrameLayout {
    public float a;
    public final float b;
    public final int c;
    public final float d;
    public b e;
    public View f;
    public View g;
    public boolean h;
    public boolean i;
    public float j;
    public float k;
    public float l;
    public VelocityTracker m;

    public static final class a {
    }

    public interface b {
        void a(SwipeLayout r1);

        void b(SwipeLayout r1);

        void c(SwipeLayout r1);
    }

    static {
    }

    public SwipeLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SwipeLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        View r0 = this.f;
        if (r0 == null) goto L18;
        if (r0 == null) goto L14;
        ViewPropertyAnimator r1 = r0.animate();
        if (r1 == null) goto L14;
        ViewPropertyAnimator r2 = r1.translationX(0.0f);
        if (r2 == null) goto L14;
        ViewPropertyAnimator r3 = r2.setDuration(200);
        if (r3 == null) goto L14;
        ViewPropertyAnimator r4 = r3.withEndAction(new g0(this));
        if (r4 == null) goto L14;
        r4.start();
    L14:
        this.h = false;
        b r5 = this.e;
        if (r5 == null) goto L19;
        r5.a(this);
        return;
    L19:
        return;
    }

    public final void b() {
        if (this.f == null) goto L20;
        View r0 = this.g;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        View r1 = this.f;
        if (r1 == null) goto L16;
        ViewPropertyAnimator r2 = r1.animate();
        if (r2 == null) goto L16;
        ViewPropertyAnimator r3 = r2.translationX(-this.a);
        if (r3 == null) goto L16;
        ViewPropertyAnimator r4 = r3.setDuration(200);
        if (r4 == null) goto L16;
        r4.start();
    L16:
        this.h = true;
        b r5 = this.e;
        if (r5 == null) goto L21;
        r5.b(this);
        return;
    L21:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VelocityTracker r0 = this.m;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        this.m = null;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() < 2) goto L6;
        this.g = getChildAt(0);
        this.f = getChildAt(1);
        return;
    }

    public final b getOnSwipeListener() {
        return this.e;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        int r0 = r6.getAction();
        if (r0 != 0) goto L5;
        this.j = r6.getX();
        this.k = r6.getY();
        this.l = r6.getX();
        this.i = false;
        VelocityTracker r1 = this.m;
        if (r1 == null) goto L28;
        r1.recycle();
    L28:
        VelocityTracker r2 = VelocityTracker.obtain();
        this.m = r2;
        if (r2 == null) goto L32;
        r2.addMovement(r6);
    L32:
        return super.onInterceptTouchEvent(r6);
    L5:
        if (r0 != 2) goto L32;
        float r3 = r6.getX() - this.j;
        float r4 = r6.getY() - this.k;
        if (this.i == true) goto L20;
        if (Math.abs(r3) <= this.c) goto L20;
        if (Math.abs(r3) <= Math.abs(r4)) goto L20;
        this.i = true;
        ViewParent r5 = getParent();
        if (r5 == null) goto L16;
        r5.requestDisallowInterceptTouchEvent(true);
    L16:
        b r7 = this.e;
        if (r7 == null) goto L20;
        r7.c(this);
    L20:
        if (this.i == false) goto L32;
        VelocityTracker r8 = this.m;
        if (r8 == null) goto L24;
        r8.addMovement(r6);
    L24:
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        VelocityTracker r0 = this.m;
        if (r0 == null) goto L5;
        r0.addMovement(r7);
    L5:
        int r1 = r7.getAction();
        boolean r4 = false;
        if (r1 == 1) goto L36;
        if (r1 == 2) goto L26;
        if (r1 == 3) goto L13;
    L64:
        return true;
    L13:
        if (this.i == false) goto L64;
        this.i = false;
        ViewParent r8 = getParent();
        if (r8 == null) goto L18;
        r8.requestDisallowInterceptTouchEvent(false);
    L18:
        if (this.h == false) goto L20;
        b();
    L21:
        VelocityTracker r9 = this.m;
        if (r9 == null) goto L24;
        r9.recycle();
    L24:
        this.m = null;
        goto L64
    L20:
        a();
        goto L21
    L26:
        if (this.i == false) goto L64;
        if (this.f == null) goto L64;
        float r2 = r7.getX() - this.l;
        this.l = r7.getX();
        View r10 = this.f;
        Intrinsics.checkNotNull(r10);
        float r11 = RangesKt.coerceIn(r10.getTranslationX() + r2, -this.a, 0.0f);
        if (r11 >= 0.0f) goto L34;
        View r3 = this.g;
        if (r3 == null) goto L34;
        r3.setVisibility(0);
    L34:
        View r5 = this.f;
        Intrinsics.checkNotNull(r5);
        r5.setTranslationX(r11);
        goto L64
    L36:
        if (this.i == false) goto L64;
        if (this.f == null) goto L64;
        this.i = false;
        ViewParent r12 = getParent();
        if (r12 == null) goto L42;
        r12.requestDisallowInterceptTouchEvent(false);
    L42:
        VelocityTracker r13 = this.m;
        if (r13 == null) goto L45;
        r13.computeCurrentVelocity(1000);
    L45:
        VelocityTracker r14 = this.m;
        if (r14 == null) goto L48;
        float r15 = r14.getXVelocity();
    L50:
        if (Math.abs(r15) > this.d) goto L52;
        View r16 = this.f;
        Intrinsics.checkNotNull(r16);
        if (r16.getTranslationX() >= ((-this.a) * this.b)) goto L57;
    L56:
        r4 = true;
    L57:
        if (r4 == false) goto L59;
        b();
    L60:
        VelocityTracker r17 = this.m;
        if (r17 == null) goto L63;
        r17.recycle();
    L63:
        this.m = null;
        goto L64
    L59:
        a();
        goto L60
    L52:
        if (r15 >= 0.0f) goto L57;
    L48:
        r15 = 0.0f;
        goto L50
    }

    public final void setMaxSwipeDistance(float r1) {
        this.a = r1;
    }

    public final void setOnSwipeListener(b r1) {
        this.e = r1;
    }

    public SwipeLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = r2.getResources().getDimension(v19.c.b(2130971536, r2, 2131167441)) * 2;
        this.b = 0.5f;
        this.c = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.d = ViewConfiguration.get(r2).getScaledMinimumFlingVelocity();
    }

    public /* synthetic */ SwipeLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
