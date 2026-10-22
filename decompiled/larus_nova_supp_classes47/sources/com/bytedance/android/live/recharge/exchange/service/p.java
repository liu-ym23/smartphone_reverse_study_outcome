package com.bytedance.android.live.recharge.exchange.service;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ SaaSWalletInfoService a;

    public p(SaaSWalletInfoService r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.c = (com.bytedance.android.live.recharge.exchange.model.h) r2;
    }
}
