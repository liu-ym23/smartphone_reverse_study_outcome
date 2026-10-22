package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ m0 a;

    public k0(m0 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Disposable r5 = (Disposable) r4;
        XplayMainService r6 = this.a.a;
        e r0 = r6.j;
        Throwable r7 = r6.e;
        if (r7 != null) goto L5;
        r7 = new RuntimeException("unknown reason");
    L5:
        r0.a(new e.a.C0102a(r7));
    }
}
