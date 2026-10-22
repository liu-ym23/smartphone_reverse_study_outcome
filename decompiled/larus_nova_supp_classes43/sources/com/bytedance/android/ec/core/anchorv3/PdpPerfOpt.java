package com.bytedance.android.ec.core.anchorv3;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PdpPerfOpt {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static m a() {
        return (m) a.getValue();
    }

    public static n b() {
        return (n) b.getValue();
    }

    static {
        a = LazyKt.lazy(PdpPerfOpt$setting$2.INSTANCE);
        b = LazyKt.lazy(PdpPerfOpt$settingV2$2.INSTANCE);
    }

    public static int j() {
        int r0 = ECSdk.a;
        cj.b r1 = (cj.b) ECSdk.a(cj.b.class);
        if (r1 == null) goto L6;
        r1.f();
    L6:
        return a().d();
    }

    public static boolean c() {
        return b().f();
    }

    public static boolean d() {
        return a().c();
    }

    public static boolean e() {
        if (b().i() == false) goto L5;
    L8:
        return true;
    L5:
        if (com.bytedance.android.ec.core.abtest.d.a() == true) goto L8;
        return false;
    }

    public static boolean f() {
        if (a().f() == false) goto L8;
        int r0 = ECSdk.a;
        cj.b r1 = (cj.b) ECSdk.a(cj.b.class);
        if (r1 == null) goto L7;
        r1.f();
    L7:
        return true;
    L8:
        return false;
    }

    public static boolean g() {
        if (a().g() == false) goto L8;
        int r0 = ECSdk.a;
        cj.b r1 = (cj.b) ECSdk.a(cj.b.class);
        if (r1 == null) goto L7;
        r1.f();
    L7:
        qh.a.a();
        return true;
    L8:
        return false;
    }

    public static boolean h() {
        return a().e();
    }

    public static void i(String r1) {
        Intrinsics.checkNotNullParameter(r1, MessageIndication.MESSAGE_TYPE_MSG);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        dm.a.a("PdpPerfOpt").i(r1);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
