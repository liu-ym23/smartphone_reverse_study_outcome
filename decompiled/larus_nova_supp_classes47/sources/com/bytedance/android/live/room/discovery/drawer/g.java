package com.bytedance.android.live.room.discovery.drawer;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ NewLiveDrawerEntranceWidget a;

    public g(NewLiveDrawerEntranceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        NewLiveDrawerEntranceWidget r4 = this.a;
        List<String> r0 = NewLiveDrawerEntranceWidget.y;
        r4.Iq();
    }
}
