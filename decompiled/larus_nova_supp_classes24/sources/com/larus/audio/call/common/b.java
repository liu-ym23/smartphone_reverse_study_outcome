package com.larus.audio.call.common;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.call.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final String a = null;
    public static final String b = null;

    static {
        a = f.c().k();
        int r0 = com.larus.audio.call.aec.f.l;
        if (f.d().c.a == false) goto L15;
        String r1 = f.d().c.f;
        int r2 = com.larus.audio.call.util.d.a;
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L14;
        PolarisFileWrapper r4 = new PolarisFileWrapper(f.d().c.f);
        if (r4.exists() == true) goto L14;
        r4.mkdirs();
    L14:
        String r5 = f.d().c.f;
    L16:
        b = r5;
        return;
    L7:
        if (r1.length() <= 0) goto L9;
        r3 = true;
        goto L10
    L15:
        r5 = "";
        goto L16
    }
}
