package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.service.base.api.LogLevel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f5365a = null;

    static {
        f5365a = new ConcurrentHashMap();
    }

    public static void a(String r5) {
        if (r5 != null) goto L4;
        r5 = "default_bid";
    L4:
        ConcurrentHashMap r10 = f5365a;
        if (r10.get(r5) != null) goto L7;
    L10:
        dc.b.a("register rl report controller");
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("BulletCore init bid == ".concat(r5), LogLevel.f5953a, "XView");
        wc.e r12 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r5).d();
        uj.a r13 = new uj.a();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.f22834m = r13;
        dc.b.f16633a = new wc.f(5);
        r10.put(r5, Boolean.TRUE);
        return;
    L7:
        if (Intrinsics.areEqual(r10.get(r5), Boolean.FALSE) == true) goto L10;
    }
}
