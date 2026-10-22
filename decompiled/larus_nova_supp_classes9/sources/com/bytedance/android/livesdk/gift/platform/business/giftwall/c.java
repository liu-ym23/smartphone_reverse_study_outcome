package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ String a;

    public c(String r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        jy0.b.a("ttlive_gift_wall", "fetchExhibitionData uid=" + this.a + " failed " + ((Throwable) r3));
    }
}
