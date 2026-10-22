package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ m a;

    public j(m r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        final TouchPositionData r4 = (TouchPositionData) r3;
        this.a.g("touchPosition", new GiftProfitDataStore$initTouchPositionResponseSubscribe$$inlined$let$lambda$1$1(this, r4));
    }
}
