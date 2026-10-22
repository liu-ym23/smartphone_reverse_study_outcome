package com.larus.community.impl.applet;

import com.larus.dora.impl.ota.g2.j0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class p implements Function1 {
    public /* synthetic */ p() {
    }

    public final Object invoke(Object r5) {
        Map.Entry r6 = (Map.Entry) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        ConcurrentHashMap<String, r.a> r0 = r.a;
        r.a r7 = (r.a) r6.getValue();
        if ((System.currentTimeMillis() - r7.b) <= j0.G2_OTA_MANUAL_REARM_DELAY_MS) goto L5;
        boolean r8 = true;
    L7:
        return Boolean.valueOf(r8);
    L5:
        r8 = false;
        goto L7
    }
}
