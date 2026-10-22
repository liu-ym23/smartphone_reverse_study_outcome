package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.PrerenderParamModel;
import com.bytedance.android.annie.bridge.method.abs.PrerenderResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "prerender")
public final class p1 extends e7.r<PrerenderParamModel, PrerenderResultModel> {
    public p1() {
    }

    public final void invoke(Object r10, CallContext r11) {
        PrerenderParamModel r12 = (PrerenderParamModel) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        if (r12.b() != null) goto L5;
        PrerenderResultModel r13 = new PrerenderResultModel();
        r13.a(PrerenderResultModel.Code.Failed);
        r13.b("schema is null");
        finishWithResult(r13);
        return;
    L5:
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r0 = com.bytedance.android.annie.ng.g.c;
        com.bytedance.android.annie.ng.a r1 = r0.get(r11.a());
        if (r1 == null) goto L12;
        o8.g r14 = r1.d;
        if (r14 == null) goto L12;
        boolean r15 = true;
        if (r14.b != true) goto L12;
    L13:
        if (r15 == true) goto L16;
        PrerenderResultModel r16 = new PrerenderResultModel();
        r16.a(PrerenderResultModel.Code.Failed);
        r16.b("not enable");
        finishWithResult(r16);
        return;
    L16:
        if (r12.a() != null) goto L22;
        com.bytedance.android.annie.ng.a r17 = r0.get(r11.a());
        if (r17 == null) goto L26;
        o8.g r18 = r17.d;
        if (r18 == null) goto L26;
        int r19 = r18.c;
    L25:
        int r20 = r19;
    L27:
        PrerenderParamModel.Strategy r21 = r12.c();
        if (r21 != null) goto L30;
        r21 = PrerenderParamModel.Strategy.Onidle;
    L30:
        Context r22 = r11.getContext();
        String r23 = r12.b();
        Intrinsics.checkNotNull(r23);
        String r24 = r11.a();
        Annie.prerenderWithSchema(r22, r23, r24, r20, r21, new o1(this));
        return;
    L26:
        r20 = 10;
        goto L27
    L22:
        Integer r25 = r12.a();
        if (r25 == null) goto L26;
        r19 = r25.intValue();
    L12:
        r15 = false;
        goto L13
    }
}
