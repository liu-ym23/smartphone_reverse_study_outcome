package com.larus.voicecall.impl.utils;

import com.larus.platform.service.z2;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k {
    static {
    }

    public static void a(StringBuilder r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        RealtimeCallUtil.a.getClass();
        if (((Boolean) RealtimeCallUtil.f0.getValue()).booleanValue() == false) goto L5;
        String r0 = "enable processor";
    L6:
        r2.append(r0);
        r2.append(";");
        boolean r1 = z2.a.realtimeCallAutoInterrupt();
        if (r1 == true) goto L9;
    L14:
        if (r1 == false) goto L16;
        String r3 = "sami aec（不再维护）";
    L17:
        r2.append(r3);
        return;
    L16:
        r3 = "none aec";
        goto L17
    L9:
        if (((Boolean) RealtimeCallUtil.d0.getValue()).booleanValue() == false) goto L14;
        if (RealtimeCallUtil.j() == false) goto L13;
        r3 = "rtc speech aec";
        goto L17
    L13:
        r3 = "rtc aec";
        goto L17
    L5:
        r0 = "disable processor";
        goto L6
    }
}
