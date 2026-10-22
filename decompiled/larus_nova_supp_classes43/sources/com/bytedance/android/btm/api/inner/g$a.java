package com.bytedance.android.btm.api.inner;

import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g$a {
    public static /* synthetic */ void c(String r10, Object r11, Function1 r12) {
        BtmMonitor.c.i(r10, "", r11, null, false, r12);
    }

    public static /* synthetic */ void a(g r10, int r11, String r12, Object r13, Function1 r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r12 = "";
    L5:
        String r16 = r12;
        if ((r15 & 4) == 0) goto L8;
        r13 = null;
    L8:
        Object r17 = r13;
        if ((r15 & 32) == 0) goto L11;
        r14 = IMonitor$monitor$1.INSTANCE;
    L11:
        r10.c(r11, r16, r17, null, false, r14);
    }

    public static /* synthetic */ void b(g r10, int r11, String r12, Throwable r13, boolean r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r12 = "";
    L5:
        String r16 = r12;
        if ((r15 & 8) == 0) goto L8;
        r13 = null;
    L8:
        Throwable r17 = r13;
        if ((r15 & 16) == 0) goto L11;
        boolean r18 = false;
    L12:
        r10.a(r11, r16, null, r17, r18);
        return;
    L11:
        r18 = r14;
        goto L12
    }
}
