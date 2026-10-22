package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.anya.p;
import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import eu0.c0;
import eu0.x;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ i a;

    public e(i r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        br2.a r0 = vh6.c.b(br2.a.class);
        IRoom r1 = this.a.getRoom();
        boolean r4 = r0.nk(r1, (IFollowPair) r3);
        EntranceMVIFacade r2 = fu0.b.b(i.a(this.a));
        if (r2 == null) goto L9;
        if (r4 == true) goto L6;
        p r5 = new c0(i.a(this.a));
    L7:
        r2.a(r5);
        return;
    L6:
        r5 = new x(i.a(this.a));
        goto L7
    }
}
