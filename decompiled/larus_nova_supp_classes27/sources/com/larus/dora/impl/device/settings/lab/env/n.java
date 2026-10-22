package com.larus.dora.impl.device.settings.lab.env;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.wear.WearState;
import com.larus.dora.impl.device.settings.lab.env.override.EnvObserveWearState;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n implements uk4.c {
    public n() {
    }

    public final void a(DoraDevice r12, WearState r13, WearState r14) {
        DoraEnvObserveManager r0 = DoraEnvObserveManager.a;
        r0.getClass();
        String r15 = r12.mac;
        if (r15 != null) goto L5;
        r0.getClass();
        r15 = DoraEnvObserveManager.e();
    L5:
        if (r15 == null) goto L38;
        r49.d r1 = DoraEnvObserveManager.f();
        r49.d.b r2 = null;
        if (r13 == null) goto L9;
        Integer r16 = Integer.valueOf(r13.ordinal());
    L10:
        if (r14 == null) goto L12;
        Integer r17 = Integer.valueOf(r14.ordinal());
    L13:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r15, "mac");
        int r3 = r49.d.j;
        EnvObserveWearState r18 = r49.d.a.a(r16, r17);
        Object r110 = r1.f;
        monitor-enter(r110);
        r1.h.put(r15, r18);     // Catch: Throwable -> L35
        r49.d.b r4 = (r49.d.b) ((LinkedHashMap) r1.g).get(r15);     // Catch: Throwable -> L35
        if (r4 == null) goto L32;
        EnvObserveWearState r5 = EnvObserveWearState.UNWORN;     // Catch: Throwable -> L35
        if (r18 == r5) goto L21;
    L23:
        if (r18 != r5) goto L26;
        Long r111 = r4.b;     // Catch: Throwable -> L35
    L25:
        Long r6 = r111;
    L28:
        if (Intrinsics.areEqual(r6, r4.b) == true) goto L32;
        r49.d.b r112 = new r49.d.b(r4.a, r6, r4.c, r1.e(r15));     // Catch: Throwable -> L35
        r1.g.put(r15, r112);     // Catch: Throwable -> L35
        r2 = r112;
        goto L32
    L26:
        r6 = null;
        goto L28
    L21:
        if (r4.b != null) goto L23;
        r111 = (Long) r1.a.invoke();     // Catch: Throwable -> L35
    L32:
        monitor-exit(r110);
        if (r2 == null) goto L41;
        r1.f(r15, r2);
        return;
    L41:
        return;
    L35:
        th = move-exception;
        throw th;
    L12:
        r17 = null;
        goto L13
    L9:
        r16 = null;
        goto L10
    }
}
