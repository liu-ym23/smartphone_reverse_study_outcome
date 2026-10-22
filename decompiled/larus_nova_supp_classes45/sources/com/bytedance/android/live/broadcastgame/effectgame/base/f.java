package com.bytedance.android.live.broadcastgame.effectgame.base;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T1, T2> implements ttc.a {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    public final void accept(Object r1, Object r2) {
        Throwable r3 = (Throwable) r2;
        c.b r4 = this.a.a;
        r4.onSuccess((List) r1);
    }
}
