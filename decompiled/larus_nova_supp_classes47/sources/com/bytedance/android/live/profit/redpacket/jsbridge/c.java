package com.bytedance.android.live.profit.redpacket.jsbridge;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.browser.jsbridge.base.RedEnvelopeUpdateResultModel;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        ApiServerException r5 = (Throwable) r4;
        d r0 = this.a;
        RedEnvelopeUpdateResultModel r1 = new RedEnvelopeUpdateResultModel();
        if ((r5 instanceof ApiServerException) == false) goto L5;
        r1.b(Integer.valueOf(r5.getErrorCode()));
    L5:
        r1.a(RedEnvelopeUpdateResultModel.Code.Failed);
        Unit r6 = Unit.INSTANCE;
        r0.finishWithResult(r1);
    }
}
