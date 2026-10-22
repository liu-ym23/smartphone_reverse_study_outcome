package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ EntranceDataSource$subscribeEvent$6 a;

    public g(EntranceDataSource$subscribeEvent$6 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        IRoom r3 = (IRoom) sh6.c.b((sh6.b) r2);
        if (r3 == null) goto L6;
        this.a.invoke(r3);
        return;
    }
}
