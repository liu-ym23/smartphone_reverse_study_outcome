package com.bytedance.android.livesdk.clearscreen.gesture;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.ViewGroupUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPagerLayout;
import com.bytedance.android.livesdk.utils.f1;
import com.bytedance.android.livesdk.widget.f0;
import com.bytedance.android.livesdk.widget.y;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements y {
    public static final /* synthetic */ int t = 0;
    public final String a;
    public final int b;
    public final Lazy c;
    public final Lazy d;
    public final int e;
    public VelocityTracker f;
    public final Lazy g;
    public boolean h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public boolean o;
    public final Rect p;
    public boolean q;
    public WeakReference<View> r;
    public final com.bytedance.android.livesdk.widget.b.d s;

    public static final class a {
    }

    static {
    }

    public final f0 getConfig() {
        return this.s;
    }

    public static ViewGroup d(View r4) {
        if ((r4 instanceof PublicScreenAreaPagerLayout) == false) goto L7;
        return (ViewGroup) r4;
    L7:
        if ((r4 instanceof ViewGroup) == false) goto L20;
        ViewGroup r5 = (ViewGroup) r4;
        if (r5.getChildCount() <= 0) goto L24;
        int r0 = r5.getChildCount();
        if (r0 < 0) goto L25;
        int r1 = 0;
    L13:
        View r2 = r5.getChildAt(r1);
        if (r2 == null) goto L18;
        ViewGroup r3 = d(r2);
        if ((r3 instanceof PublicScreenAreaPagerLayout) == false) goto L18;
        return r3;
    L18:
        if (r1 == r0) goto L26;
        r1 = r1 + 1;
        goto L13
    L26:
        return null;
    L25:
        return null;
    L24:
        return null;
    L20:
        return null;
    }

    public final boolean a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        return false;
    }

    public b(final View r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        this.a = "RightScroll2LeaveRoomGestureBehavior";
        this.b = ViewConfiguration.get(r3).getScaledTouchSlop();
        this.c = LazyKt.lazy(RightScroll2LeaveRoomGestureBehavior$minScrollDistance$2.INSTANCE);
        this.d = LazyKt.lazy(RightScroll2LeaveRoomGestureBehavior$minVelocity$2.INSTANCE);
        this.e = ViewConfiguration.getMaximumFlingVelocity();
        this.g = LazyKt.lazy(new RightScroll2LeaveRoomGestureBehavior$exitGestureArea$2(r2));
        this.i = Float.MIN_VALUE;
        this.j = Float.MIN_VALUE;
        this.p = new Rect();
        this.s = com.bytedance.android.livesdk.widget.b.d.c;
    }

    public final boolean b(ViewGroup r9, MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r9, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r10, "ev");
        int r0 = r10.getAction() & 255;
        if (r0 != 0) goto L5;
        this.i = r10.getX();
        float r11 = r10.getY();
        this.j = r11;
        this.k = this.i;
        this.l = r11;
        this.m = 0.0f;
        this.n = 0.0f;
        this.q = false;
        this.o = false;
        this.h = ((Rect) this.g.getValue()).contains((int) this.i, (int) this.j);
        WeakReference<View> r12 = this.r;
        if (r12 == null) goto L42;
        if (r12.get() == null) goto L42;
    L47:
        float r13 = this.i;
        float r1 = this.j;
        WeakReference<View> r2 = this.r;
        if (r2 == null) goto L57;
        View r3 = r2.get();
        if (r3 == null) goto L57;
        int r14 = (int) r13;
        int r4 = (int) r1;
        ViewGroupUtils.getDescendantRect(r9, r3, this.p);
        boolean r15 = this.p.contains(r14, r4);     // Catch: Throwable -> L54
        this.p.setEmpty();
        this.q = r15;
        ALogger.d(this.a, "是否点击了公屏：" + this.q);
    L54:
        th = move-exception;
        this.p.setEmpty();
        throw th;
    L57:
        return false;
    L42:
        if (r9 == null) goto L45;
        Object r5 = r9.findViewById(2131383413);
        if (r5 == null) goto L45;
    L46:
        this.r = new WeakReference(r5);
        Unit r16 = Unit.INSTANCE;
    L45:
        r5 = d(r9);
        goto L46
    L5:
        if (r0 != 2) goto L57;
        if (this.h == true) goto L10;
    L36:
        return false;
    L10:
        if (this.q == false) goto L36;
        float r17 = r10.getX();
        float r18 = r10.getY();
        float r6 = r17 - this.i;
        float r7 = r18 - this.j;
        this.m = r17 - this.k;
        this.n = r18 - this.l;
        if (this.o == false) goto L15;
    L21:
        WeakReference<View> r8 = this.r;
        if (r8 == null) goto L28;
        View r19 = r8.get();
        if (r19 == null) goto L28;
        if (r19.canScrollHorizontally(-1) != true) goto L28;
        boolean r20 = true;
    L29:
        ALogger.d(this.a, "onInterceptTouchEvent, dx=" + this.m + ", dy=" + this.n + ", totalDx=" + r6 + ", totalDy=" + r7 + ", touchSlop=" + this.b + ", isScrollRight=" + this.o + ", canPSScrollRight=" + r20);
        this.k = r17;
        this.l = r18;
        if (this.o == false) goto L57;
        if (this.q == false) goto L57;
        if (r20 == true) goto L57;
        ALogger.d(this.a, "开始在公屏上右滑了，拦截事件");
        return true;
    L28:
        r20 = false;
        goto L29
    L15:
        if (Math.abs(r6) > Math.abs(r7)) goto L17;
    L19:
        boolean r21 = false;
    L20:
        this.o = r21;
        goto L21
    L17:
        if (r6 < this.b) goto L19;
        r21 = true;
        goto L20
    }

    public final boolean c(ViewGroup r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r3, "ev");
        y.a.a(r2, r3);
        return false;
    }

    public final boolean onTouchEvent(ViewGroup r10, MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r10, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r11, "ev");
        if (this.f != null) goto L5;
        this.f = VelocityTracker.obtain();
    L5:
        VelocityTracker r12 = this.f;
        if (r12 == null) goto L8;
        r12.addMovement(r11);
    L8:
        int r13 = r11.getAction();
        float r0 = 0.0f;
        boolean r1 = false;
        if (r13 == 0) goto L74;
        boolean r2 = true;
        if (r13 == 1) goto L35;
        if (r13 == 2) goto L22;
        if (r13 != 3) goto L75;
        ALogger.d(this.a, "ACTION_CANCEL");
        VelocityTracker r14 = this.f;
        if (r14 == null) goto L20;
        r14.recycle();
    L20:
        this.f = null;
    L75:
        return r1;
    L22:
        if (this.h == true) goto L24;
        return false;
    L24:
        float r15 = r11.getX();
        float r16 = r11.getY();
        float r3 = r15 - this.k;
        this.m = r3;
        this.n = r16 - this.l;
        if (this.o == false) goto L27;
    L33:
        this.k = r15;
        this.l = r16;
        goto L75
    L27:
        if (Math.abs(r3) > (Math.abs(this.n) * 1.5f)) goto L29;
    L31:
        r2 = false;
    L32:
        this.o = r2;
        goto L33
    L29:
        if ((r15 - this.i) < this.b) goto L31;
    L35:
        if (this.h == false) goto L70;
        VelocityTracker r17 = this.f;
        if (r17 == null) goto L39;
        r17.computeCurrentVelocity(BubbleId.PadCast, this.e);
    L39:
        if (r17 == null) goto L41;
        float r4 = r17.getYVelocity();
    L42:
        if (r17 == null) goto L44;
        r0 = r17.getXVelocity();
    L44:
        float r18 = r11.getX() - this.i;
        float r19 = r11.getY() - this.j;
        float r5 = this.m;
        if (r5 >= this.n) goto L47;
    L55:
        boolean r6 = false;
    L57:
        if (Math.abs(r0) > Math.abs(r4)) goto L59;
    L61:
        boolean r7 = false;
    L62:
        if (r6 == false) goto L65;
        if (r7 == false) goto L65;
        r1 = true;
    L65:
        ALogger.d(this.a, "onTouchEvent, consume=" + r1 + ", dx=" + this.m + ", dy=" + this.n + ", totalX=" + r18 + ", totalY=" + r19 + "， minScrollDistance=" + ((Number) this.c.getValue()).intValue() + ", isScrollRight=" + this.o + ", velocityX=" + r0 + ", velocityY=" + r4 + ", minVelocity=" + ((Number) this.d.getValue()).intValue() + ", isScrollSatisfy=" + r6 + ", isVelocitySatisfy=" + r7);
        if (r1 == false) goto L70;
        if (f1.a(-1996) == true) goto L70;
        ALogger.d(this.a, "ACTION_UP, 右滑退出直播间");
        xs2.b.a().post(new h1(78));
        goto L70
    L59:
        if (r0 <= ((Number) this.d.getValue()).intValue()) goto L61;
        r7 = true;
        goto L62
    L47:
        if (r5 < 0) goto L55;
        if (this.o == false) goto L55;
        if (r18 <= r19) goto L55;
        if (r18 < ((Number) this.c.getValue()).intValue()) goto L55;
        r6 = true;
        goto L57
    L41:
        r4 = 0.0f;
    L70:
        VelocityTracker r110 = this.f;
        if (r110 == null) goto L73;
        r110.recycle();
    L73:
        this.f = null;
        goto L75
    L74:
        this.i = r11.getX();
        float r111 = r11.getY();
        this.j = r111;
        this.k = this.i;
        this.l = r111;
        this.m = 0.0f;
        this.n = 0.0f;
        this.h = ((Rect) this.g.getValue()).contains((int) this.i, (int) this.j);
        goto L75
    }
}
