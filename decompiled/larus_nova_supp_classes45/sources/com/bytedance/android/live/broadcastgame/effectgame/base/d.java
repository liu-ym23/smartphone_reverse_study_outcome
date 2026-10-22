package com.bytedance.android.live.broadcastgame.effectgame.base;

import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T1, T2> implements ttc.a {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    public final void accept(Object r2, Object r3) {
        Throwable r4 = (Throwable) r3;
        e r5 = this.a;
        c.a r0 = r5.a;
        String r6 = r5.b;
        r0.a(r6, (Sticker) r2);
    }
}
