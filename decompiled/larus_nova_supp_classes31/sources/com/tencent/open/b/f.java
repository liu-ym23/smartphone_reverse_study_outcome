package com.tencent.open.b;

import com.tencent.open.utils.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class f {
    public static int a() {
        int r0 = i.a(com.tencent.open.utils.g.a(), null).a("Common_HttpRetryCount");
        if (r0 != 0) goto L6;
        return 2;
    L6:
        return r0;
    }

    public static int a(String r2) {
        if (com.tencent.open.utils.g.a() != null) goto L5;
        return 100;
    L5:
        int r3 = i.a(com.tencent.open.utils.g.a(), r2).a("Common_BusinessReportFrequency");
        if (r3 != 0) goto L9;
        return 100;
    L9:
        return r3;
    }
}
