package com.bytedance.android.ec.core.hybrid.bridges;

import android.app.Activity;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "ec.anniePrerender")
public final class h extends a {
    public h() {
    }

    public final void handle(IBDXBridgeContext r10, XBaseParamModel r11, CompletionBlock r12) {
        a.b r13 = (a.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        boolean r0 = ECServiceManager.a;
        pd.e r1 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();
        Activity r14 = r10.getOwnerActivity();
        if (r14 == null) goto L7;
        if (r1 == null) goto L8;
        r1.prerenderAnnieWithSchema(r14, r13.getSchema(), "webcast", (Integer) r13.getExpiredTime(), r13.getStrategy(), new g(r1, r13, r12));
        return;
    L8:
        return;
    }
}
