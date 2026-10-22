package com.bytedance.android.bcm.impl.monitor;

import com.bytedance.android.btm.impl.setting.i;
import com.bytedance.android.btm.impl.setting.k;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
    }

    public static final k a(i r10, JSONObject r11) {
        Iterator r12 = r10.a().iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        k r0 = (k) r12.next();
        if (r0.c().isEmpty() == true) goto L16;
        if (r0.c().contains(r11.optString(r0.b())) == false) goto L4;
        return r0;
    L16:
        return r0;
    L11:
        return new k();
    }

    public static void b(final int r10, String r11, String r12, String r13, Throwable r14, Function1 r15, int r16) {
        if ((r16 & 2) == 0) goto L5;
        r11 = "";
    L5:
        final String r17 = r11;
        if ((r16 & 4) == 0) goto L8;
        final String r18 = null;
    L10:
        if ((r16 & 8) == 0) goto L12;
        final String r1 = null;
    L13:
        final boolean r19 = false;
        if ((r16 & 32) == 0) goto L16;
        final BcmMonitor$monitor$1 r20 = BcmMonitor$monitor$1.INSTANCE;
    L18:
        if ((r16 & 64) == 0) goto L20;
        final Throwable r21 = null;
    L22:
        if ((r16 & 128) == 0) goto L24;
        r15 = BcmMonitor$monitor$2.INSTANCE;
    L24:
        final Function1 r22 = r15;
        com.bytedance.android.btm.impl.thread.b.e.a(new BcmMonitor$monitor$runnable$1(r1, r10, r22, r17, r20, r21, r19, r18), true);
        return;
    L20:
        r21 = r14;
        goto L22
    L16:
        r20 = null;
        goto L18
    L12:
        r1 = r13;
        goto L13
    L8:
        r18 = r12;
        goto L10
    }

    public static void c(final int r11, final com.bytedance.android.bcm.impl.paramcheck.checker.b r12, String r13, String r14, final String r15, String r16, int r17) {
        if ((r17 & 4) == 0) goto L5;
        final String r10 = null;
    L7:
        if ((r17 & 8) == 0) goto L9;
        final String r18 = null;
    L11:
        if ((r17 & 32) == 0) goto L13;
        final String r19 = null;
    L14:
        final String r20 = null;
        final boolean r110 = false;
        com.bytedance.android.btm.impl.thread.b.e.a(new BcmMonitor$monitorParamsCheck$runnable$1(r10, r11, r18, r19, r15, r20, r12, r110), true);
        return;
    L13:
        r19 = r16;
        goto L14
    L9:
        r18 = r14;
        goto L11
    L5:
        r10 = r13;
        goto L7
    }
}
