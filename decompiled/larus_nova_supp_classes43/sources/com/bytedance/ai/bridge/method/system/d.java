package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f4.a0;
import f4.b0;
import f4.c0;
import f4.y;
import f4.z;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "SafeAreaInsets(marginTop=" + this.a + ", marginBottom=" + this.b + ", marginLeft=" + this.c + ", marginRight=" + this.d + ')';
        }

        public a(int r1, int r10, int r11, int r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }
    }

    public static final class b {
        public final Rect a;
        public final a b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "WindowSafeAreaInfo(windowRectPx=" + this.a + ", safeAreaInsets=" + this.b + ')';
        }

        public b(Rect r10, a r11) {
            Intrinsics.checkNotNullParameter(r10, "windowRectPx");
            Intrinsics.checkNotNullParameter(r11, "safeAreaInsets");
            this.a = r10;
            this.b = r11;
        }
    }

    static {
    }

    public d() {
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

    public static a b(int r1, int r10, Rect r11, double r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "windowRectPx");
        int r0 = s4.a.a;
        int r14 = Math.max(r1 - s4.a.c(RangesKt.coerceAtLeast(r11.bottom, 0), r12), 0);
        if (r13 == false) goto L6;
        return new a(0, 0, r10, r14);
    L6:
        return new a(r10, r14, 0, 0);
    }

    public static Rect d(Rect r10, int r11, int r12, int r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "rawRect");
        Rect r0 = new Rect(r10);
        if (r0.right > r0.left) goto L5;
        r0.right = r11;
    L5:
        int r15 = r0.bottom;
        int r1 = r0.top;
        if (r15 > r1) goto L8;
        r0.bottom = r12;
    L8:
        if (r14 == false) goto L11;
        if (r1 != 0) goto L11;
        r0.top = r1 + r13;
        r0.bottom = RangesKt.coerceAtMost(r0.bottom + r13, r12);
    L11:
        r0.left = RangesKt.coerceIn(r0.left, 0, r11);
        r0.top = RangesKt.coerceIn(r0.top, 0, r12);
        r0.right = RangesKt.coerceIn(r0.right, r0.left, r11);
        r0.bottom = RangesKt.coerceIn(r0.bottom, r0.top, r12);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [f4.y] */
    /* JADX WARN: Type inference failed for: r2v3, types: [f4.z] */
    /* JADX WARN: Type inference failed for: r3v5, types: [f4.a0, java.lang.Runnable] */
    public static void c(final Activity r18, final int r19, final int r20, final int r21, final double r22, final int r24, final int r25, final boolean r26, boolean r27, final Function1 r28) {
        Intrinsics.checkNotNullParameter(r28, "callback");
        if (r18 != null) goto L7;
        if (r27 == true) goto L6;
        r28.invoke(null);
        return;
    L6:
        Rect r0 = d(new Rect(0, r25, r19, r20), r19, r20, r25, false);
        r28.invoke(new b(r0, b(r21, r24, r0, r22, r26)));
        return;
    L7:
        final ?? r12 = new y(r19, r20, r25, r18, r28, r21, r24, r22, r26);
        final View r1 = a(r18.getWindow());
        int r10 = Build.VERSION.SDK_INT;
        boolean r11 = true;
        if (r10 < 30) goto L14;
        WindowInsets r13 = a(r18.getWindow()).getRootWindowInsets();
        if (r13 != null) goto L12;
    L17:
        r11 = false;
    L19:
        if (r10 < 30) goto L24;
        final AtomicBoolean r14 = new AtomicBoolean(false);
        final ?? r15 = new z(r1, r12);
        if (r11 == true) goto L23;
        r15.invoke();
        return;
    L23:
        ?? r16 = new a0(r14, r15);
        r1.setWindowInsetsAnimationCallback(new c0(r14, r1, r16, r15));
        r1.postDelayed(r16, 300 + ((long) 50));
        return;
    L24:
        Rect r17 = new Rect();
        r1.getWindowVisibleDisplayFrame(r17);
        if (r11 == true) goto L27;
        r12.invoke(r17);
        return;
    L27:
        r1.postDelayed(new b0(r1, r12), 300);
        return;
    L12:
        if (r13.isVisible(WindowInsets.Type.ime()) != true) goto L17;
    L14:
        View r23 = a(r18.getWindow());
        Rect r29 = new Rect();
        r23.getWindowVisibleDisplayFrame(r29);
        int r30 = r23.getHeight();
        if ((r30 - r29.bottom) <= (((double) r30) * 0.15d)) goto L17;
        goto L17
    }
}
