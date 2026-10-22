package com.bytedance.ies.bullet.web.pia;

import com.bytedance.ies.bullet.service.base.api.LogLevel;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f6234a = null;

    static {
        f6234a = new LinkedHashMap();
    }

    public static void a(String r10) {
        int r5 = 1;
        int r11 = 0;
        ConcurrentHashMap r12 = yc.a.f23246a;     // Catch: NullPointerException -> L21
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");     // Catch: NullPointerException -> L21
        xc.e r13 = (xc.e) yc.a.a(xc.e.class, "default_bid");     // Catch: NullPointerException -> L21
        if (r13 == null) goto L8;
        xc.d r14 = (xc.d) r13.a(xc.d.class);     // Catch: NullPointerException -> L21
        if (r14 == null) goto L8;
        Boolean r15 = r14.A0();     // Catch: NullPointerException -> L21
    L9:
        LinkedHashMap r16 = f6234a;     // Catch: NullPointerException -> L21
        if (r16.containsKey(r10) == true) goto L25;
        boolean r17 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: NullPointerException -> L21
        com.bytedance.ies.bullet.service.base.b.d("init PiaEnv for " + r10, LogLevel.f5954b, "XWebKit");     // Catch: NullPointerException -> L21
        d r18 = new d(r10, MapsKt.emptyMap());     // Catch: NullPointerException -> L21
        r16.put(r10, r18);     // Catch: NullPointerException -> L21
        oh.e r19 = (oh.e) ai.p.g(oh.e.class);     // Catch: NullPointerException -> L21
        if (r19 == null) goto L26;
        zg.c r20 = new zg.c();     // Catch: NullPointerException -> L21
        r20.f23441a = "bullet-".concat(r10);     // Catch: NullPointerException -> L21
        if (Intrinsics.areEqual(r10, "webcast") == true) goto L16;
    L18:
        fh.b r21 = new f(r18, r11);     // Catch: NullPointerException -> L21
    L19:
        r20.g = r21;     // Catch: NullPointerException -> L21
        r20.f = new f(r18, r5);     // Catch: NullPointerException -> L21
        r20.f23443c = new e(r10, r5);     // Catch: NullPointerException -> L21
        r20.f23442b = new g(r18, r10);     // Catch: NullPointerException -> L21
        r19.a(r20);     // Catch: NullPointerException -> L21
        return;
    L16:
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == false) goto L18;
        r21 = new e(r10, r11);     // Catch: NullPointerException -> L21
        goto L19
    L26:
        return;
    L25:
        return;
    L8:
        r15 = null;
    L21:
        boolean r22 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("init PiaEnv failed", LogLevel.d, "XWebKit");
    }
}
