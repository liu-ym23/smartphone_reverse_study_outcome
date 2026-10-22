package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ m a;

    public i(m r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        final PayGrade r5 = (PayGrade) r4;
        this.a.g("profitPayGrade_" + r5, new GiftProfitDataStore$initPayGradeObservable$$inlined$let$lambda$1$1(this, r5));
    }
}
