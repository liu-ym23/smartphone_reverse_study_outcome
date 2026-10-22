package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.browser.jsbridge.base.DismissLotteryIconResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import w20.r8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends w20.l0<r8, DismissLotteryIconResultModel> {
    public final com.bytedance.live.datacontext.k<Object> a;

    public a(com.bytedance.live.datacontext.k r2) {
        Intrinsics.checkNotNullParameter(r2, "onSubmit");
        this.a = r2;
    }

    public final void invoke(Object r2, CallContext r3) {
        r8 r4 = (r8) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a.post(r4);
        finishWithSuccess();
    }
}
