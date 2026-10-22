package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u3<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.t a;

    public u3(GiftTransaction r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Disposable r2 = (Disposable) r1;
        this.a.finish();
    }
}
