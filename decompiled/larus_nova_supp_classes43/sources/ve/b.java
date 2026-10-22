package ve;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements c<a> {
    public b() {
    }

    public final Object decode(g r10) throws Exception {
        a r0 = new a();
        r0.targetOpenIds = new ArrayList();
        long r1 = r10.c();
    L3:
        int r11 = r10.f();
        if (r11 == (-1)) goto L30;
        if (r11 != 1) goto L8;
        ((BaseMessage) r0).baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r10);
        goto L3
    L8:
        if (r11 != 2) goto L10;
        r0.msgType = r10.i();
        goto L3
    L10:
        if (r11 != 8) goto L12;
        r0.ecomNotice = h.c(r10);
        goto L3
    L12:
        if (r11 != 10) goto L14;
        r0.updateType = r10.i();
        goto L3
    L14:
        if (r11 != 26) goto L16;
        r0.updatedCartInfo = com.bytedance.android.ec.adapter.api.message.model.a.a(r10);
        goto L3
    L16:
        if (r11 != 5000) goto L18;
        r0.targetOpenIds.add(h.c(r10));
        goto L3
    L18:
        if (r11 != 21) goto L20;
        r0.commerceAuthorityChangeToast = h.c(r10);
        goto L3
    L20:
        if (r11 != 22) goto L21;
        r0.traceTimeMetric = de.c.a(r10);
        goto L3
    L21:
        h.e(r10);
        goto L3
    L30:
        r10.d(r1);
        return r0;
    }
}
