package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import eu0.f0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ i a;

    public c(i r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.profit.vip.h r4 = (com.bytedance.android.live.profit.vip.h) r3;
        EntranceMVIFacade r5 = fu0.b.b(i.a(this.a));
        if (r5 == null) goto L6;
        r5.a(new f0(i.a(this.a)));
        return;
    }
}
