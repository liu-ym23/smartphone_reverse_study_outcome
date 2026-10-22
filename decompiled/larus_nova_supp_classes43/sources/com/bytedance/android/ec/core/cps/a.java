package com.bytedance.android.ec.core.cps;

import java.util.zip.CRC32;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements k {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        CRC32 r0 = new CRC32();     // Catch: Throwable -> L10
        r0.update(r10.getBytes(Charsets.UTF_8));     // Catch: Throwable -> L10
        String r11 = Long.toHexString(r0.getValue());     // Catch: Throwable -> L10
        if (r11.length() >= 8) goto L15;
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L10
        int r12 = r11.length();     // Catch: Throwable -> L10
    L6:
        if (r12 >= 8) goto L8;
        r1.append("0");     // Catch: Throwable -> L10
        r12 = r12 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        return r1 + r11;
    L15:
        return r11;
    L10:
        return null;
    }
}
