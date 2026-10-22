package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.live.profit.fansclub.r;
import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ i a;

    public b(i r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        r r4 = (r) r3;
        EntranceMVIFacade r5 = fu0.b.b(i.a(this.a));
        if (r5 == null) goto L6;
        r5.a(new eu0.r(i.a(this.a)));
        return;
    }
}
