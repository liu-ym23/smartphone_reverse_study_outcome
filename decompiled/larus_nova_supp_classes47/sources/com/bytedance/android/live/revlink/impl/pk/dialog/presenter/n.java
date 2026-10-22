package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ k a;

    public n(k r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        k r0 = this.a;
        r0.d((Throwable) r2);
    }
}
