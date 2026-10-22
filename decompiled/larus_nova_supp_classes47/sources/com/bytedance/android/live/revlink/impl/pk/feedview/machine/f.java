package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.c3;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ d a;

    public f(a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ExtraResponse r4 = (ExtraResponse) r3;
        c3 r0 = ((com.bytedance.android.livesdk.link.model.r) r4.data).getBattleStatsMeta();
        if (r0 == null) goto L7;
        this.a.a(r0, ((com.bytedance.android.livesdk.link.model.r) r4.data).getBizExtra());
        return;
    }
}
