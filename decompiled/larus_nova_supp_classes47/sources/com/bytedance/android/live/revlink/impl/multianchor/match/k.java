package com.bytedance.android.live.revlink.impl.multianchor.match;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ int a;

    public k(int r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        ExtraResponse r5 = (ExtraResponse) r4;
        jy0.b.c("ttlive_anchor_link_match", "cancelMatch " + this.a + " success", null, 4);
    }
}
