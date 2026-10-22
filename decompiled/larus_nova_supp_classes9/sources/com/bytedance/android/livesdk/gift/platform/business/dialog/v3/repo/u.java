package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ boolean a;

    public u(boolean r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        if (this.a == false) goto L6;
        GiftListRepo r0 = GiftListRepo.k;
        com.bytedance.android.livesdk.gift.platform.core.model.i r4 = (com.bytedance.android.livesdk.gift.platform.core.model.i) r3.data;
        r0.getClass();
        GiftListRepo.d(r4);
        return;
    }
}
