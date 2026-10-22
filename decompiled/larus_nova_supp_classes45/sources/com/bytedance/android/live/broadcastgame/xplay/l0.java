package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l0<T> implements Consumer {
    public final /* synthetic */ m0 a;

    public l0(m0 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Disposable r3 = (Disposable) r2;
        this.a.a.j.a(e.a.b.a);
    }
}
