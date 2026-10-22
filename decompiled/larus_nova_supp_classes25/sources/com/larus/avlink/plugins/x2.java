package com.larus.avlink.plugins;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.settings.value.e10;
import com.larus.settings.value.zo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x2 {
    public static final Map<Function1<Boolean, Unit>, k4> a = null;

    public x2() {
    }

    static {
        a = new LinkedHashMap();
    }

    public static int a() {
        e10 r0 = e10.a;
        int r1 = com.larus.utils.l0.a;
        Integer r2 = Integer.valueOf(((Number) com.larus.utils.l0.a(45, new zo())).intValue());
        if (r2.intValue() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L9;
        r2 = null;
    L9:
        if (r2 != null) goto L11;
        return 45;
    L11:
        return r2.intValue();
    L5:
        r3 = false;
        goto L6
    }

    public static v2 b() {
        e10 r0 = e10.a;
        nu9.r r1 = e10.P();
        return new v2(r1.e(), r1.d(), r1.f());
    }

    public static IDoraService c() {
        return (IDoraService) ServiceManager.get().getService(IDoraService.class);
    }

    public static void d(k4 r1) {
        Intrinsics.checkNotNullParameter(r1, "callback");
        IDoraService r0 = c();
        if (r0 == null) goto L8;
        SessionService r2 = r0.d();
        if (r2 == null) goto L9;
        r2.i(r1);
        return;
    L9:
        return;
    }

    public static void f(int r1) {
        IDoraService r0 = c();
        if (r0 == null) goto L8;
        DeviceService r2 = r0.device();
        if (r2 == null) goto L9;
        r2.E0(r1);
        return;
    L9:
        return;
    }

    public static void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        IDoraService r0 = c();
        if (r0 == null) goto L8;
        SessionService r1 = r0.d();
        if (r1 == null) goto L9;
        r1.t(r2, null);
        return;
    L9:
        return;
    }

    public static void k(k4 r1) {
        Intrinsics.checkNotNullParameter(r1, "callback");
        IDoraService r0 = c();
        if (r0 == null) goto L8;
        SessionService r2 = r0.d();
        if (r2 == null) goto L9;
        r2.x(r1);
        return;
    L9:
        return;
    }

    public static void e(String r1, Map r2) {
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r2, "params");
        IDoraService r0 = c();
        if (r0 == null) goto L6;
        r0.A0(r1, r2);
        return;
    }

    public static void i(byte[] r2, int r3) {
        Intrinsics.checkNotNullParameter("RESET", "event");
        Intrinsics.checkNotNullParameter(r2, "payload");
        IDoraService r0 = c();
        if (r0 == null) goto L8;
        SessionService r1 = r0.d();
        if (r1 == null) goto L9;
        r1.u("RESET", r2, Integer.valueOf(r3));
        return;
    L9:
        return;
    }

    public static void j(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "event");
        IDoraService r0 = c();
        if (r0 == null) goto L8;
        SessionService r3 = r0.d();
        if (r3 == null) goto L9;
        r3.v(r1, r2);
        return;
    L9:
        return;
    }

    public static void g(int r2, String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "params");
        IDoraService r0 = c();
        if (r0 == null) goto L12;
        SessionService r1 = r0.d();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r4.isEmpty() == false) goto L10;
        r1.r(r2, r3);
        return;
    L10:
        r1.s(r2, r4, r3);
        return;
    }

    public static Object l(int r1, int r2, boolean r3, Continuation r4) {
        IDoraService r0 = c();
        if (r0 == null) goto L12;
        SessionService r5 = r0.d();
        if (r5 == null) goto L12;
        Deferred r6 = r5.y(r1, r2, r3);
        if (r6 == null) goto L12;
        Object r7 = r6.await(r4);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        return r7;
    L14:
        return (Integer) r7;
    L12:
        return null;
    }
}
