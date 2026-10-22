package com.bytedance.android.live.livepkaudience.emoji;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ p a;

    public z(p r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        p r0 = this.a;
        r0.c = false;
        p.a r1 = (p.a) ((q46.b) r0).a;
        if (r1 == null) goto L6;
        r1.U2(r4);
        return;
    }
}
