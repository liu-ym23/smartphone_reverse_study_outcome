package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f2.k;
import f4.x;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final Activity a;
        public final boolean b;
        public final s4.a.C0194a c;
        public final double d;
        public final int e;
        public final int f;

        public final Activity getActivity() {
            return this.a;
        }

        public a(Activity r10, Context r11, boolean r12, s4.a.C0194a r13, double r14, int r15, int r16) {
            Intrinsics.checkNotNullParameter(r11, "baseContext");
            Intrinsics.checkNotNullParameter(r13, "screenSizeInfo");
            this.a = r10;
            this.b = r12;
            this.c = r13;
            this.d = r14;
            this.e = r15;
            this.f = r16;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (this.e == r11.e) goto L24;
            return false;
        L24:
            if (this.f == r11.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
        }

        public final String toString() {
            return "SafeAreaInfo(left=" + this.a + ", right=" + this.b + ", top=" + this.c + ", bottom=" + this.d + ", width=" + this.e + ", height=" + this.f + ')';
        }

        public b(int r1, int r10, int r11, int r12, int r13, int r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.system.c$c, reason: collision with other inner class name */
    public static final class C0037c {
        public final double a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final b g;
        public final int h;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0037c) == true) goto L8;
            return false;
        L8:
            C0037c r11 = (C0037c) r10;
            if (Double.compare(this.a, r11.a) == 0) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (this.e == r11.e) goto L24;
            return false;
        L24:
            if (this.f == r11.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r11.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            long r0 = Double.doubleToLongBits(this.a);
            return (((((((((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g.hashCode()) * 31) + this.h;
        }

        public final String toString() {
            return "WindowInfo(pixelRatio=" + this.a + ", screenWidth=" + this.b + ", screenHeight=" + this.c + ", windowWidth=" + this.d + ", windowHeight=" + this.e + ", statusBarHeight=" + this.f + ", safeArea=" + this.g + ", screenTop=" + this.h + ')';
        }

        public C0037c(double r10, int r11, int r12, int r13, int r14, int r15, b r16, int r17) {
            Intrinsics.checkNotNullParameter(r16, "safeArea");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
            this.g = r16;
            this.h = r17;
        }
    }

    static {
    }

    public static View a(Window r10) {
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    public static C0037c d(Context r11) {
        a r12 = e(r11);
        if (r12 != null) goto L6;
        return null;
    L6:
        boolean r1 = false;
        if (r12.getActivity() == null) goto L9;
        Rect r0 = new Rect();
        a(r12.getActivity().getWindow()).getWindowVisibleDisplayFrame(r0);
    L10:
        int r10 = d.a;
        s4.a.C0194a r13 = r12.c;
        int r14 = r13.b;
        int r15 = r13.c;
        int r16 = r12.e;
        if (r12.getActivity() != null) goto L13;
    L15:
        Rect r17 = d.d(r0, r14, r15, r16, r1);
        return b(r12, r17, d.b(r12.c.e, r12.f, r17, r12.d, r12.b));
    L13:
        if (a(r12.getActivity().getWindow()).getHeight() != 0) goto L15;
        r1 = true;
        goto L15
    L9:
        int r18 = r12.e;
        s4.a.C0194a r19 = r12.c;
        r0 = new Rect(0, r18, r19.b, r19.c);
        goto L10
    }

    public static a e(Context r11) {
        int r0 = s4.a.a;
        Context r1 = r11;
    L4:
        if (r1 == null) goto L11;
        if ((r1 instanceof Activity) == true) goto L7;
        if ((r1 instanceof ContextWrapper) == false) goto L11;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L4
    L7:
        Activity r10 = (Activity) r1;
    L12:
        if (r10 != null) goto L24;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r12 = AppletRuntimeManager.d;
        if (r12 == null) goto L16;
        r10 = r12.currentActivity();
    L17:
        if (r10 != null) goto L24;
        g2.b r13 = AppletRuntimeManager.d;
        if (r13 == null) goto L21;
        r10 = r13.O();
    L22:
        if (r10 != null) goto L24;
        r10 = k.b();
        goto L24
    L21:
        r10 = null;
        goto L22
    L16:
        r10 = null;
    L24:
        Activity r14 = r10;
        if (r14 == null) goto L27;
        Context r15 = r14;
    L33:
        if (r15.getResources().getConfiguration().orientation != 2) goto L35;
        boolean r16 = true;
    L36:
        s4.a.C0194a r17 = s4.a.a(r15);
        double r18 = r17.a;
        int r19 = s4.a.b(r15, true);
        return new a(r14, r15, r16, r17, r18, r19, s4.a.c(r19, r18));
    L35:
        r16 = false;
        goto L36
    L27:
        if (r11 != null) goto L31;
        r11 = k.a();
        if (r11 != null) goto L31;
        return null;
    L31:
        r15 = r11;
    L11:
        r10 = null;
        goto L12
    }

    public static void c(Context r12, final Function1 r13) {
        Intrinsics.checkNotNullParameter(r13, "callback");
        final a r14 = e(r12);
        if (r14 != null) goto L6;
        r13.invoke(null);
        return;
    L6:
        int r0 = d.a;
        Activity r1 = r14.getActivity();
        s4.a.C0194a r10 = r14.c;
        d.c(r1, r10.b, r10.c, r10.e, r14.d, r14.f, r14.e, r14.b, true, new x(r13, r14));
    }

    public static C0037c b(a r25, Rect r26, d.a r27) {
        int r10 = d.a;
        s4.a.C0194a r11 = r25.c;
        int r12 = r11.d;
        int r13 = r11.e;
        Intrinsics.checkNotNullParameter(r27, "safeAreaInsets");
        int r14 = r27.c;
        int r15 = r12 - r27.d;
        int r16 = r27.a;
        int r1 = r13 - r27.b;
        int r17 = RangesKt.coerceIn(r14, 0, r12);
        int r18 = RangesKt.coerceIn(r16, 0, r13);
        int r19 = RangesKt.coerceIn(r15, r17, r12);
        int r110 = RangesKt.coerceIn(r1, r18, r13);
        int r111 = RangesKt.coerceAtLeast(r19 - r17, 0);
        int r112 = RangesKt.coerceAtLeast(r110 - r18, 0);
        double r20 = r25.d;
        s4.a.C0194a r21 = r25.c;
        int r22 = r21.d;
        int r23 = r21.e;
        int r24 = s4.a.a;
        return new C0037c(r20, r22, r23, s4.a.c(RangesKt.coerceAtLeast(r26.width(), 0), r25.d), s4.a.c(RangesKt.coerceAtLeast(r26.height(), 0), r25.d), r25.f, new b(r17, r19, r18, r110, r111, r112), s4.a.c(RangesKt.coerceAtLeast(r26.top, 0), r25.d));
    }
}
