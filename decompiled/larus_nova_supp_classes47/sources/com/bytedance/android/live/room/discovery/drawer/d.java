package com.bytedance.android.live.room.discovery.drawer;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.message.model.hg;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ NewLiveDrawerEntranceWidget a;

    public d(NewLiveDrawerEntranceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        NewLiveDrawerEntranceWidget.wq(this.a, (hg) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r2)).data);
    }
}
