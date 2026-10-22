package com.bytedance.android.livesdk.gift.format;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ GiftPlayerView a;

    public c(GiftPlayerView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        GiftPlayerView r0 = this.a;
        GiftPlayerView.d(r0, (tr.a) r2);
    }
}
