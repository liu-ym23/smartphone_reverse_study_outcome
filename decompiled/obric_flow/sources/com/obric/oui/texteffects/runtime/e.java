package com.obric.oui.texteffects.runtime;

import ai.j0;
import android.util.LruCache;
import android.view.animation.PathInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import js.f;
import js.g;
import js.h;
import js.i;
import js.j;
import js.m;
import js.n;
import js.p;
import js.r;
import js.s;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache f14755a = null;

    static {
        f14755a = new LruCache(16);
        new LruCache(16);
    }

    public static float a(f4.b r10, float r11) {
        if (Intrinsics.areEqual(r10, js.b.f18455b) == false) goto L6;
        return r11;
    L6:
        if ((r10 instanceof js.a) == false) goto L13;
        js.a r12 = (js.a) r10;
        LruCache r5 = f14755a;
        PathInterpolator r13 = (PathInterpolator) r5.get(r12);
        if (r13 != null) goto L11;
        float r14 = r12.f18453b;
        float r15 = r12.d;
        r13 = new PathInterpolator(r14, 0.0f, r12.f18454c, r15);
        r5.put(r12, r13);
    L11:
        return r13.getInterpolation(r11);
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public static float b(f8.b r5, float r10) {
        if ((r5 instanceof h) == false) goto L6;
        return ((h) r5).f18466a;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return r10;
    L8:
        return ((g) r5).f18465a;
    }

    public static int c(List r5, long r10) {
        int r11 = CollectionsKt.getLastIndex(r5);
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L10;
        int r13 = (r12 + r11) >>> 1;
        if (((m) r5.get(r13)).f18472a >= r10) goto L7;
        r12 = r13 + 1;
        goto L4
    L7:
        r11 = r13;
        goto L4
    L10:
        return RangesKt.coerceAtLeast(r12, 1);
    }

    public static c d(s r23, long r24) {
        Intrinsics.checkNotNullParameter(r23, "spec");
        long r10 = RangesKt.coerceAtLeast(r23.f18480c, 1);
        n r5 = n.d;
        i.a r11 = r23.d;
        long r12 = 0;
        if (Intrinsics.areEqual(r11, r5) == false) goto L8;
        long r13 = r24 % r10;
        if (r13 >= 0) goto L10;
        r13 = r13 + r10;
    L10:
        List r14 = r23.e;
        Iterator r15 = r14.iterator();
        if (r15.hasNext() == true) goto L13;
        Integer r16 = null;
    L19:
        if (r16 != null) goto L21;
        int r17 = 0;
    L22:
        ArrayList r18 = new ArrayList(r17);
        Iterator r19 = r14.iterator();
    L24:
        if (r19.hasNext() == false) goto L58;
        f r110 = (f) r19.next();
        r110.getClass();
        if (r13 < r12) goto L24;
        if (r13 > r110.f18463b) goto L24;
        Iterator r20 = r110.f18464c.iterator();
    L32:
        if (r20.hasNext() == false) goto L24;
        js.e r21 = (js.e) r20.next();
        Iterator r22 = r21.b().iterator();
        float r111 = Float.NaN;
        float r112 = Float.NaN;
        float r113 = Float.NaN;
        float r114 = Float.NaN;
        r r115 = null;
        f8.b r116 = null;
        f8.b r25 = null;
        f8.b r26 = null;
    L35:
        if (r22.hasNext() == false) goto L49;
        p r27 = (p) r22.next();
        switch(d.f14754a[r27.f18475a.ordinal()]) {
            case 1: goto L48;
            case 2: goto L47;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            default: goto L35;
        };
    L39:
        r26 = e(r27, r13);
        goto L35
    L40:
        r25 = e(r27, r13);
        goto L35
    L41:
        r116 = e(r27, r13);
        goto L35
    L42:
        r114 = f(r27, r13);
        goto L35
    L43:
        r112 = f(r27, r13);
        jm.c r28 = r27.d;
        if ((r28 instanceof r) == true) goto L45;
        r115 = null;
        goto L35
    L45:
        r115 = (r) r28;
        goto L35
    L47:
        r113 = f(r27, r13);
        goto L35
    L48:
        r111 = f(r27, r13);
        goto L35
    L49:
        String r29 = r21.a();
        if ((r21 instanceof js.c) == false) goto L52;
        js.c r30 = (js.c) r21;
    L53:
        if (r30 != null) goto L55;
        String r31 = null;
    L56:
        Iterator r210 = r19;
        ArrayList r32 = r18;
        r32.add(new b(r110.f18462a, r29, r31, r13, r111, r112, r113, r115, r114, r116, r25, r26));
        r18 = r32;
        r110 = r110;
        r12 = 0;
        r19 = r210;
        goto L32
    L55:
        r31 = r30.f18457b;
        goto L56
    L52:
        r30 = null;
        goto L53
    L58:
        return new c(r24, r13, r18);
    L21:
        r17 = r16.intValue();
        goto L22
    L13:
        r16 = Integer.valueOf(((f) r15.next()).f18464c.size());
    L15:
        if (r15.hasNext() == false) goto L19;
        Integer r33 = Integer.valueOf(((f) r15.next()).f18464c.size());
        if (r16.compareTo(r33) >= 0) goto L15;
        r16 = r33;
        goto L15
    L8:
        if (Intrinsics.areEqual(r11, n.e) == false) goto L60;
        r13 = RangesKt.coerceIn(r24, 0, r10);
        goto L10
    L60:
        throw new NoWhenBranchMatchedException();
    }

    public static f8.b e(p r10, long r11) {
        List r5 = r10.f18476b;
        if (r5.isEmpty() == false) goto L7;
        return new h(0.0f);
    L7:
        if (r11 > ((m) CollectionsKt.first(r5)).f18472a) goto L11;
        return ((m) CollectionsKt.first(r5)).f18473b;
    L11:
        if (r11 >= ((m) CollectionsKt.last(r5)).f18472a) goto L13;
        int r12 = c(r5, r11);
        m r13 = (m) r5.get(r12 - 1);
        m r14 = (m) r5.get(r12);
        float r15 = a(r10.f18477c, RangesKt.coerceIn((r11 - r13.f18472a) / RangesKt.coerceAtLeast(r14.f18472a - r13.f18472a, 1), 0.0f, 1.0f));
        f8.b r16 = r13.f18473b;
        boolean r17 = r16 instanceof h;
        f8.b r18 = r14.f18473b;
        if (r17 == true) goto L17;
    L20:
        boolean r19 = r16 instanceof g;
        if (r19 == true) goto L23;
    L25:
        if (r17 == true) goto L32;
        if (r19 == true) goto L32;
        if ((r16 instanceof j) == true) goto L32;
        if ((r16 instanceof i) == true) goto L32;
    L41:
        if (r15 >= 1.0f) goto L46;
        return r16;
    L46:
        return r18;
    L32:
        if ((r18 instanceof h) == false) goto L34;
    L44:
        f8.b r110 = new i(r16, r18, r15);
    L45:
        return r110;
    L34:
        if ((r18 instanceof g) == true) goto L44;
        if ((r18 instanceof j) == true) goto L44;
        if ((r18 instanceof i) == false) goto L41;
    L23:
        if ((r18 instanceof g) == false) goto L25;
        float r20 = ((g) r18).f18465a;
        float r21 = ((g) r16).f18465a;
        r110 = new g(j0.b(r20, r21, r15, r21));
        goto L45
    L17:
        if ((r18 instanceof h) == false) goto L20;
        float r22 = ((h) r18).f18466a;
        float r23 = ((h) r16).f18466a;
        r110 = new h(j0.b(r22, r23, r15, r23));
        goto L45
    L13:
        return ((m) CollectionsKt.last(r5)).f18473b;
    }

    public static float f(p r10, long r11) {
        List r5 = r10.f18476b;
        if (r5.isEmpty() == false) goto L6;
        return 0.0f;
    L6:
        if (r11 > ((m) CollectionsKt.first(r5)).f18472a) goto L10;
        return b(((m) CollectionsKt.first(r5)).f18473b, 0.0f);
    L10:
        if (r11 >= ((m) CollectionsKt.last(r5)).f18472a) goto L12;
        int r12 = c(r5, r11);
        m r13 = (m) r5.get(r12 - 1);
        m r14 = (m) r5.get(r12);
        float r15 = a(r10.f18477c, RangesKt.coerceIn((r11 - r13.f18472a) / RangesKt.coerceAtLeast(r14.f18472a - r13.f18472a, 1), 0.0f, 1.0f));
        f8.b r16 = r13.f18473b;
        float r17 = b(r16, 0.0f);
        return ((b(r14.f18473b, b(r16, 0.0f)) - r17) * r15) + r17;
    L12:
        return b(((m) CollectionsKt.last(r5)).f18473b, 0.0f);
    }
}
