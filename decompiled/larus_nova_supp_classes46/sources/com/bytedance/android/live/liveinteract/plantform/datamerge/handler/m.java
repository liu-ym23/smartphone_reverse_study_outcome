package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ n a;

    public m(n r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        n r0 = this.a;
        ch0.c r1 = r0.c;
        r1.a = ((fd2.z) r3).a;
        r0.a().W0(this.a.c);
    }
}
