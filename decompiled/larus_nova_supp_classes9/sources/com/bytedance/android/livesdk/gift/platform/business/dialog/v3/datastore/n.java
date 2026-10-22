package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ u a;

    public n(u r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        u r4 = this.a;
        r4.m.fetchAutoExchangeStatus(r4.f);
    }
}
