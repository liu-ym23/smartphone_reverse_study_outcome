package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.payment.payment.AbsDyPayMethodIDL;
import com.bytedance.ai.bridge.service.OnPayOrderResultCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements OnPayOrderResultCallback {
    public final /* synthetic */ f3.h<ResultModel> a;
    public final /* synthetic */ DyPayMethod b;

    @Override // com.bytedance.ai.bridge.service.OnPayOrderResultCallback
    public final void onSuccess() {
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_DyPayMethod", "call success");
        f3.h<ResultModel> r0 = this.a;
        Intrinsics.checkNotNullParameter(AbsDyPayMethodIDL.c.class, "<this>");
        f3.h.a.b(r0, (ResultModel) k3.c.a(AbsDyPayMethodIDL.c.class));
    }

    public c(f3.h<ResultModel> r1, DyPayMethod r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // com.bytedance.ai.bridge.service.OnPayOrderResultCallback
    public final void onFailed(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "errorNo");
        Intrinsics.checkNotNullParameter(r11, "errorMsg");
        DyPayMethod r0 = this.b;
        f3.h<ResultModel> r1 = this.a;
        int r12 = DyPayMethod.b;
        f3.a r13 = f3.a.f;
        r0.getClass();
        DyPayMethod.b(r1, r10, r11, r13);
    }
}
