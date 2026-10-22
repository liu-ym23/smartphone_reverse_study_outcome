package com.bytedance.android.live.revlink.impl.multianchor.match;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ g a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public j(g r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r10) {
        Long r12 = (Long) r10;
        g r0 = this.a;
        IRoomBase r13 = r0.a;
        if (r13 == null) goto L5;
        long r1 = IRoomKtKt.getId(r13);
    L6:
        r0.f(r1, this.b, false, this.c, false, null, null);
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
