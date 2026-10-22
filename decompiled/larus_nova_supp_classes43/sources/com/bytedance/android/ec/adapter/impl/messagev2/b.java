package com.bytedance.android.ec.adapter.impl.messagev2;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements c<a> {
    public b() {
    }

    public final Object decode(g r10) throws Exception {
        a r0 = new a();
        long r1 = r10.c();
    L3:
        int r11 = r10.f();
        if (r11 == (-1)) goto L13;
        switch(r11) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        r0.content = h.b(r10);
        goto L3
    L8:
        r0.traceTimeMetric = com.bytedance.android.ec.adapter.api.messagev2.model.a.a(r10);
        goto L3
    L9:
        r0.logicClock = r10.j();
        goto L3
    L10:
        r0.contentFormat = h.c(r10);
        goto L3
    L11:
        r0.contentType = h.c(r10);
        goto L3
    L12:
        ((BaseMessage) r0).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r10);
        goto L3
    L6:
        h.e(r10);
        goto L3
    L13:
        r10.d(r1);
        return r0;
    }
}
