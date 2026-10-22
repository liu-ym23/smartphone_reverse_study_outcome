package com.bytedance.android.live.room.discovery.drawer.template;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ LiveDrawerEntranceCommonWidget a;

    public e(LiveDrawerEntranceCommonWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        LiveDrawerEntranceCommonWidget r4 = this.a;
        List<String> r0 = LiveDrawerEntranceCommonWidget.G;
        r4.Gq();
    }
}
