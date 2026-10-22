package com.larus.dora.impl.device.scan;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k {
    public static final j a(DoraDevice r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        String r1 = r8.mac;
        if (r1 != null) goto L5;
        String r3 = "";
    L6:
        String r2 = r8.name;
        if (r2 != null) goto L9;
        String r4 = "";
    L10:
        String r5 = r8.sn;
        if (r5 != null) goto L13;
        String r6 = "";
    L14:
        String r7 = r3;
        String r10 = r4;
        String r11 = r6;
        return new j(r7, r10, r11, r8.sku, r9, r8.type);
    L13:
        r6 = r5;
        goto L14
    L9:
        r4 = r2;
        goto L10
    L5:
        r3 = r1;
        goto L6
    }
}
