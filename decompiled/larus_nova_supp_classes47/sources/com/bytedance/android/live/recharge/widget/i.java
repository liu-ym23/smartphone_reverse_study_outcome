package com.bytedance.android.live.recharge.widget;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ RechargeCjComponentWidget a;

    public i(RechargeCjComponentWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ALogger.e("cjComponent", "onDealSelected: get render info failed: " + ((Throwable) r3).getMessage());
        this.a.h.getRepository().R.onNext(12);
        RechargeCjComponentWidget r4 = this.a;
        int r0 = RechargeCjComponentWidget.k;
        r4.zq();
        this.a.h.isPreQueryInfo().a(Boolean.FALSE);
    }
}
