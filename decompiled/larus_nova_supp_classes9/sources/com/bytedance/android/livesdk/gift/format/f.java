package com.bytedance.android.livesdk.gift.format;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ GiftPlayerView a;
    public final /* synthetic */ tr.a b;

    public f(GiftPlayerView r1, tr.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        GiftPlayerView r0 = this.a;
        String r6 = "download assets failed!!, assetId: " + this.b.d + ", error: " + ((Throwable) r5);
        int r1 = GiftPlayerView.k;
        r0.e(r6);
        GiftPlayerView.c(this.a);
    }
}
