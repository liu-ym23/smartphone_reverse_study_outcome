package com.larus.avlink.gallery.processor;

import com.larus.common.apphost.AppHost;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l {
    public static k a(k r18, int r19, String r20, String r21, int r22, int r23) {
        int r2 = 0;
        if ((r23 & 1) == 0) goto L5;
        int r1 = 0;
    L6:
        String r4 = "";
        if ((r23 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r23 & 4) != 0) goto L15;
        r4 = r21;
    L15:
        if ((r23 & 8) != 0) goto L18;
        r2 = r22;
    L18:
        Object r6 = null;
        if ((r23 & 16) == 0) goto L24;
        f09.a r5 = AppHost.a.a();
        if (r5 == null) goto L23;
        r6 = Integer.valueOf(r5.isAppBackground() ? 1 : 0);
    L23:
        r6 = String.valueOf(r6);
    L24:
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Intrinsics.checkNotNullParameter(r3, "resultAlgorithm");
        Intrinsics.checkNotNullParameter(r4, "sdkVersion");
        Intrinsics.checkNotNullParameter(r6, "background");
        Map r9 = MapsKt.toMutableMap(r18.e);
        r9.put("code", Integer.valueOf(r1));
        r9.put("resultAlgorithm", r3);
        r9.put("sdkVersion", r4);
        r9.put("background", r6);
        r9.put("activeMask", Integer.valueOf(r2));
        boolean r11 = r18.a;
        String r12 = r18.b;
        String r13 = r18.c;
        long r14 = r18.d;
        boolean r0 = r18.f;
        Intrinsics.checkNotNullParameter(r12, "outputPath");
        Intrinsics.checkNotNullParameter(r13, "error");
        Intrinsics.checkNotNullParameter(r9, "extras");
        return new k(r11, r12, r13, r14, r9, r0);
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r19;
        goto L6
    }
}
