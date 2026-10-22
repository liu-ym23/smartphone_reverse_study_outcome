package com.bytedance.android.ec.adapter.api.messagev2.model;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements c<TraceTimeMetricV2> {
    public a() {
    }

    public static TraceTimeMetricV2 a(g r10) throws Exception {
        TraceTimeMetricV2 r0 = new TraceTimeMetricV2();
        long r1 = r10.c();
    L3:
        int r11 = r10.f();
        if (r11 == (-1)) goto L18;
        if (r11 != 1) goto L8;
        r0.opTimestamp = r10.j();
        goto L3
    L8:
        if (r11 != 2) goto L10;
        r0.producerDuration = r10.j();
        goto L3
    L10:
        if (r11 != 3) goto L12;
        r0.consumerDuration = r10.j();
        goto L3
    L12:
        if (r11 != 4) goto L13;
        r0.msgSendTimestamp = r10.j();
        goto L3
    L13:
        h.e(r10);
        goto L3
    L18:
        r10.d(r1);
        return r0;
    }

    public final Object decode(g r1) throws Exception {
        return a(r1);
    }
}
