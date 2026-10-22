package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f2<T> implements Consumer {
    public final /* synthetic */ GiftResourceFileCacheService a;

    public f2(GiftResourceFileCacheService r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        this.a.m.onNext(Boolean.TRUE);
    }
}
