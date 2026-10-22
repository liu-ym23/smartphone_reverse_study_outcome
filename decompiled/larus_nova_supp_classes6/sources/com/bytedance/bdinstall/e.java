package com.bytedance.bdinstall;

import android.content.Context;
import e84.k;
import i84.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e {
    public static void a(Context r3, o0 r4, StringBuilder r5) {
        if (r4.u == true) goto L15;
        d.b(r5, "build_serial", q.c(r3, r4));
        if (r4.D == false) goto L15;
        String[] r6 = q.d(r3, r4);
        if (r6 == null) goto L15;
        if (r6.length <= 0) goto L15;
        String r0 = r6[0];
        int r1 = 1;
    L12:
        if (r1 >= r6.length) goto L14;
        r0 = r0 + "," + r6[r1];
        r1 = r1 + 1;
        goto L12
    L14:
        d.b(r5, "sim_serial_number", r0);
    L15:
        k.e(r3).c();
    }
}
