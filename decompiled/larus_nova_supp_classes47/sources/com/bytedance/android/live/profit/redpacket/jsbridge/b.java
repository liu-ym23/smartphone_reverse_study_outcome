package com.bytedance.android.live.profit.redpacket.jsbridge;

import com.bytedance.android.live.browser.jsbridge.base.RedEnvelopeUpdateResultModel;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ d a;

    public b(d r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ExtraResponse r4 = (ExtraResponse) r3;
        d r5 = this.a;
        RedEnvelopeUpdateResultModel r0 = new RedEnvelopeUpdateResultModel();
        r0.a(RedEnvelopeUpdateResultModel.Code.Success);
        r0.b(0);
        Unit r1 = Unit.INSTANCE;
        r5.finishWithResult(r0);
    }
}
