package com.bytedance.ies.bullet.secure;

import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f5904c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f5905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f5906b;

    static {
        f5904c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, HybridSecureManager$Companion$instance$2.f5889a);
    }

    public f() {
        this.f5906b = new LinkedHashMap();
    }

    public final e a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        SccConfig r5 = null;
        if (Intrinsics.areEqual("default_bid", r10) == false) goto L6;
        com.bytedance.ies.bullet.base.utils.logger.a.g("HybridSecureManager", "getSecureConfig: get global config", null, 12);
        return this.f5905a;
    L6:
        int r11 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("HybridSecureManager", "getSecureConfig: get config for " + r10, null, 12);
        e r12 = (e) this.f5906b.get(r10);
        if (r12 == null) goto L30;
        e r13 = this.f5905a;
        if (r13 == null) goto L30;
        e r14 = new e();
        r14.f5901a = r13.f5901a;
        r14.f5902b = r13.f5902b;
        r14.f5903c = r13.f5903c;
        SccConfig r15 = r13.d;
        if (r15 == null) goto L13;
        r5 = r15.a();
    L13:
        r14.d = r5;
        Intrinsics.checkNotNullParameter(r12, "config");
        Function3 r16 = r12.f5901a;
        if (r16 == null) goto L16;
        r14.f5901a = r16;
    L16:
        Function3 r17 = r12.f5902b;
        if (r17 == null) goto L19;
        r14.f5902b = r17;
    L19:
        r9.c r18 = r12.f5903c;
        if (r18 == null) goto L22;
        r14.f5903c = r18;
    L22:
        SccConfig r19 = r12.d;
        if (r19 == null) goto L29;
        SccConfig r20 = r14.d;
        if (r20 == null) goto L28;
        r20.b(r19);
        return r14;
    L28:
        r14.d = r19;
        Unit r21 = Unit.INSTANCE;
    L29:
        return r14;
    L30:
        return null;
    }
}
