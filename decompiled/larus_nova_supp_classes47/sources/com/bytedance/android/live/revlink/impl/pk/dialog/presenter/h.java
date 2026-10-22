package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ j a;

    public h(j r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        InteractDialogPKSearchContract$View r0 = (InteractDialogPKSearchContract$View) this.a.c;
        if (r0 == null) goto L7;
        r0.ca0((IRivalRankRecommendResponse) r3.data);
        return;
    }
}
