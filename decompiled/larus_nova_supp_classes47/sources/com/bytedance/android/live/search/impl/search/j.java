package com.bytedance.android.live.search.impl.search;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ h a;

    public j(h r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        h r0 = this.a;
        r0.a = false;
        r0.j.cF(new Exception((Throwable) r3));
    }
}
