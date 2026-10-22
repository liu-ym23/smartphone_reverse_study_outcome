package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ GiftRoomCleanCacheService a;

    public g(GiftRoomCleanCacheService r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        this.a.c();
    }
}
