package com.bytedance.android.livesdk.jsbridge.methods;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "openLiveLifeGrouponPage")
public final class r2 extends n<s2, OpenLiveLifeGrouponPageResultModel> {
    public r2() {
    }

    public final void invoke(Object r6, CallContext r7) {
        s2 r8 = (s2) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        if ((r7.getContext() instanceof FragmentActivity) == false) goto L17;
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("page_source", r8.a());
        r9.put("page_type", r8.b());
        LinkedHashMap r1 = new LinkedHashMap();
        s2.a r2 = r8.c();
        String r3 = null;
        if (r2 == null) goto L7;
        String r4 = r2.a();
    L8:
        r1.put("coupon_ids", r4);
        s2.a r5 = r8.c();
        if (r5 == null) goto L11;
        String r10 = r5.c();
    L12:
        r1.put("from_position", r10);
        s2.a r11 = r8.c();
        if (r11 == null) goto L15;
        r3 = r11.b();
    L15:
        r1.put("extra_request_params", r3);
        Unit r13 = Unit.INSTANCE;
        r9.put("params", r1);
        jc1.k.n(IHostLiveLocalLife.class).openLiveLifeGrouponPage(r9);
        OpenLiveLifeGrouponPageResultModel r14 = new OpenLiveLifeGrouponPageResultModel();
        r14.a(OpenLiveLifeGrouponPageResultModel.Code.Success);
        r14.b("success");
        finishWithResult(r14);
        return;
    L11:
        r10 = null;
        goto L12
    L7:
        r4 = null;
        goto L8
    }
}
