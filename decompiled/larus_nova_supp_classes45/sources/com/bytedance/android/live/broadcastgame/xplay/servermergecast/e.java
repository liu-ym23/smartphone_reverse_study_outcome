package com.bytedance.android.live.broadcastgame.xplay.servermergecast;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ XplayRTCManager a;

    public e(XplayRTCManager r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Unit r2 = (Unit) r1;
        ei6.a r3 = this.a.h;
        if (r3 == null) goto L8;
        vi6.a r4 = r3.v();
        if (r4 == null) goto L9;
        r4.f();
        return;
    L9:
        return;
    }
}
