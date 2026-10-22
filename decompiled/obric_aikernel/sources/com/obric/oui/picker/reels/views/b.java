package com.obric.oui.picker.reels.views;

import android.widget.OverScroller;
import java.lang.reflect.Method;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f7033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f7034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f7035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f7036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f7037e = null;

    static {
        f7037e = new b();
    }

    private b() {
    }

    private final int a(OverScroller r18, int r19, int r20, int r21) {
        if (f7036d == true) goto L6;
        ea.b.b("ScrollerExt", "calculateSnapVelocity, reflect failed, use original velocityY: " + r19);
        return r19;
    L6:
        if (r19 == 0) goto L49;
        float r10 = r20;
        float r11 = r21;
        float r12 = c(r18, r19) + r10;
        double r13 = r12 / r11;
        float r14 = ((float) Math.floor(r13)) * r11;
        float r15 = ((float) Math.ceil(r13)) * r11;
        if (Math.abs(r12 - r14) < Math.abs(r15 - r12)) goto L11;
        r14 = r15;
    L11:
        if (r19 <= 0) goto L13;
        byte r16 = 1;
    L15:
        if (r19 <= 0) goto L17;
        int r17 = 40000;
        int r22 = 0;
    L18:
        float r23 = Float.MAX_VALUE;
        int r24 = 20;
        int r110 = r19;
        int r111 = 0;
    L19:
        if (r111 >= r24) goto L54;
        int r112 = (r22 + r17) / 2;
        float r25 = c(r18, r112) + r10;
        float r113 = r25 - r14;
        if (Math.abs(r113) >= r23) goto L23;
        r23 = Math.abs(r113);
        r110 = r112;
    L23:
        ea.b.i("ScrollerExt", "calculateSnapVelocity, iteration: " + r111 + ", mid: " + r112 + ", low: " + r22 + ", high: " + r17 + ", diff: " + r113 + ", dist: " + r25 + ", targetDistance: " + r14 + ", bestDiff: " + r23 + ", bestVelocity: " + r110 + ", velocityY: " + r19 + ", currentOffset: " + r10);
        if (r16 <= 0) goto L32;
        if (r113 < 0) goto L36;
        if (Math.abs(r113) > 0.3f) goto L36;
        return r110;
    L36:
        float r26 = 0;
        if (r16 <= 0) goto L42;
        if (r113 > r26) goto L44;
    L43:
        r22 = r112 + 1;
    L45:
        if (r22 > r17) goto L57;
        r111 = r111 + 1;
        r24 = 20;
        goto L19
    L57:
        return r110;
    L44:
        r17 = r112 - 1;
        goto L45
    L42:
        if (r113 >= r26) goto L44;
    L32:
        if (r113 > 0) goto L36;
        if (Math.abs(r113) > 0.3f) goto L36;
        return r110;
    L54:
        return r110;
    L17:
        r22 = -40000;
        r17 = 0;
        goto L18
    L13:
        r16 = -1;
        goto L15
    L49:
        return r19;
    }

    private final void b(OverScroller r10) {
    L11:
        e = move-exception;
        ea.b.k("ScrollerExt", "disableDynamicScroll, failed", e);
        return;
    L3:
        if (f7035c != null) goto L7;
        Method r11 = OverScroller.class.getDeclaredMethod("disableDynamicScroll", new Class[0]);     // Catch: Exception -> L11
        f7035c = r11;     // Catch: Exception -> L11
        if (r11 == null) goto L7;
        r11.setAccessible(true);     // Catch: Exception -> L11
    L7:
        Method r12 = f7035c;     // Catch: Exception -> L11
        if (r12 == null) goto L16;
        r12.invoke(r10, new Object[0]);     // Catch: Exception -> L11
        return;
    }

    private final int c(OverScroller r10, int r11) {
        double r12 = e(r10, r11);
        if (r11 != 0) goto L5;
        Number r13 = 0;
    L10:
        return r13.intValue();
    L5:
        if (r11 > 0) goto L8;
        r12 = -r12;
    L8:
        r13 = Double.valueOf(r12);
        goto L10
    }

    @JvmStatic
    public static final double e(OverScroller r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "overScroller");
        f7037e.b(r10);     // Catch: Exception -> L11
        Method r12 = f7034b;     // Catch: Exception -> L11
        if (r12 == null) goto L6;
        Object r13 = r12.invoke(r10, new Object[]{Integer.valueOf(r11)});     // Catch: Exception -> L11
    L7:
        if (r13 == null) goto L10;
        return ((Double) r13).doubleValue();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");     // Catch: Exception -> L11
    L6:
        r13 = null;
    L11:
        e = move-exception;
        ea.b.c("ScrollerExt", "reflectGetSplineFlingDistance, velocity: " + r11 + ", error", e);
        f7036d = false;
        return 0.0d;
    }

    public final void d() {
    L13:
        e = move-exception;
        ea.b.c("ScrollerExt", "init reflect error", e);
        f7036d = false;
        return;
    L4:
        if (f7033a != null) goto L7;
        f7033a = Class.forName("android.widget.OverScroller");     // Catch: Exception -> L13
    L7:
        if (f7034b != null) goto L11;
        Class<?> r10 = f7033a;     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L13
        Method r11 = r10.getDeclaredMethod("getSplineFlingDistance", new Class[]{Integer.TYPE});     // Catch: Exception -> L13
        f7034b = r11;     // Catch: Exception -> L13
        if (r11 == null) goto L11;
        r11.setAccessible(true);     // Catch: Exception -> L13
    L11:
        f7036d = true;     // Catch: Exception -> L13
    }

    public final void f(OverScroller r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        Intrinsics.checkNotNullParameter(r12, "$this$snapFlingVertically");
        r12.fling(0, r14, 0, a(r12, r15, r14, r13), 0, 0, r16, r17, 0, r18);
    }
}
