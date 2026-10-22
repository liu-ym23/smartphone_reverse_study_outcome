package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w0<T> implements Consumer {
    public final /* synthetic */ GiftMVITabView a;

    public w0(GiftMVITabView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.x(((Integer) r2).intValue());
    }
}
