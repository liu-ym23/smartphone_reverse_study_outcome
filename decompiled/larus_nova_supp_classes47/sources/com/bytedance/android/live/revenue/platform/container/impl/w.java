package com.bytedance.android.live.revenue.platform.container.impl;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w {
    public static final i57.g a(xy0.a r6, Context r7, com.bytedance.android.scope.j r8) {
        int r0 = i57.c.a;
        i57.b r1 = new i57.b();
        if (r6 == null) goto L5;
        Map r2 = r1.a;
        i57.e r3 = i57.e.f;
        r3.getClass();
        r2.put(((i57.a.a) i57.e.b.getValue(r3, i57.e.a[0])).a, r6);
    L5:
        if (r8 != null) goto L11;
        cy0.e r9 = (cy0.e) CollectionsKt.lastOrNull(ab0.a.c);
        if (r9 != null) goto L10;
        r9 = (rh6.a) CollectionsKt.lastOrNull(com.bytedance.android.live.revenue.core.f.a);
    L10:
        r8 = r9;
    L11:
        if (r8 == null) goto L13;
        Intrinsics.checkNotNullParameter(r8, "value");
        r1.a.put(i57.e.f.b().a, r8);
    L13:
        if (r7 == null) goto L16;
        r1.a(r7);
    L16:
        return i57.d.a(r1);
    }

    public static Pair b(com.bytedance.platform.aio.channel.js.a r2, xy0.a r3, Context r4, com.bytedance.android.scope.j r5, final Function0 r6, int r7) {
        final KProperty r1 = null;
        if ((r7 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r5 = null;
    L8:
        Intrinsics.checkNotNullParameter(r2, "bridge");
        Intrinsics.checkNotNullParameter(r6, "getHybridView");
        final Lazy r8 = LazyKt.lazy(new JsDriverBridgeFactoryKt$initJsDriver$hybridView$2(r6));
        final RevenueJsDriver r9 = new RevenueJsDriver(r2, a(r3, r4, r5), new JsDriverBridgeFactoryKt$initJsDriver$jsDriver$1(r8, r1));
        cy0.e.a.getClass();
        cy0.j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(ny0.a.class));
        Intrinsics.checkNotNull(r12);
        ((ny0.a) ((f80.a) r12)).J0(r9);
        int r13 = com.bytedance.revenue.platform.api.core.rx.h.a;
        return TuplesKt.to(com.bytedance.revenue.platform.api.core.rx.h.a(new JsDriverBridgeFactoryKt$initJsDriver$1(r9)), r9);
    }
}
