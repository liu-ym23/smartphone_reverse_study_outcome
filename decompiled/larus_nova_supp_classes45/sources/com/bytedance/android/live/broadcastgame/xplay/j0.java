package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j0<T> implements Consumer {
    public final /* synthetic */ m0 a;

    public j0(m0 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.a.j.a(new e.a.c(((Float) r3).floatValue()));
    }
}
