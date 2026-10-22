package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CreateVipEmojiByTemplateResultModel;
import com.bytedance.android.live.profit.api.IProfitServiceExternal;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "createVipEmojiByTemplate")
public final class k2 extends w20.j0<w20.p8, CreateVipEmojiByTemplateResultModel> {
    public k2() {
    }

    public final void invoke(Object r3, CallContext r4) {
        w20.p8 r5 = (w20.p8) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        IProfitServiceExternal r6 = jc1.k.n(IProfitServiceExternal.class);
        String r0 = r5.b();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r7 = r5.a();
        if (r7 == null) goto L9;
        r1 = r7;
    L9:
        r6.showVipEmojiTemplatePanel(r0, r1);
        CreateVipEmojiByTemplateResultModel r8 = new CreateVipEmojiByTemplateResultModel();
        r8.a(CreateVipEmojiByTemplateResultModel.Code.Success);
        r8.b("success");
        Unit r9 = Unit.INSTANCE;
        finishWithResult(r8);
    }
}
