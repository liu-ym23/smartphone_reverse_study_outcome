package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import eu0.s;
import eu0.y;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ i a;

    public a(i r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        com.bytedance.android.live.profit.fansclub.g r5 = (com.bytedance.android.live.profit.fansclub.g) r4;
        EntranceMVIFacade r0 = fu0.b.b(i.a(this.a));
        if (r0 == null) goto L6;
        r0.a(new y(i.a(this.a)));
    L6:
        if (r5.d == false) goto L11;
        EntranceMVIFacade r6 = fu0.b.b(i.a(this.a));
        if (r6 == null) goto L12;
        r6.a(new s(i.a(this.a)));
        return;
    L12:
        return;
    }
}
