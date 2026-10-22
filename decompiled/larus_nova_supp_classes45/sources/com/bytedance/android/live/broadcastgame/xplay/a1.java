package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.functions.Consumer;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a1<T> implements Consumer {
    public final /* synthetic */ XplayPanelService a;

    public a1(XplayPanelService r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        int r5 = this.a.h.j;
        if (r5 >= 99) goto L7;
        int r6 = Random.Default.nextInt(r5, 99);
        this.a.h.a(r6);
        return;
    }
}
