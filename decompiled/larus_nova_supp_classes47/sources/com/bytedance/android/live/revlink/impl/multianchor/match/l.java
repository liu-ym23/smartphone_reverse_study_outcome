package com.bytedance.android.live.revlink.impl.multianchor.match;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ int a;

    public l(int r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        jy0.b.c("ttlive_anchor_link_match", "cancelMatch " + this.a + " failed " + ((Throwable) r4), null, 4);
    }
}
