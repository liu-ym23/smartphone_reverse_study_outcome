package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ boolean a;

    public c(boolean r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ExtraResponse r4 = (ExtraResponse) r3;
        jy0.b.d("ttlive_anchor_link", "updateSetting showScore=" + this.a + " success");
        com.bytedance.android.live.revlink.impl.multianchor.profit.a r5 = com.bytedance.android.live.revlink.impl.global.b.Y();
        if (r5 == null) goto L6;
        boolean r0 = this.a;
        int r1 = com.bytedance.android.live.revlink.impl.multianchor.profit.a.e;
        r5.n(r0, null);
        return;
    }
}
