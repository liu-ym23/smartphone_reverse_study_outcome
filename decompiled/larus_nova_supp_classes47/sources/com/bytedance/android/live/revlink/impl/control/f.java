package com.bytedance.android.live.revlink.impl.control;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        sh6.b r2 = (sh6.b) r1;
        e.b r3 = (e.b) ((com.bytedance.android.livesdk.common.k) this.a).a;
        if (r3 == null) goto L6;
        r3.Ab();
        return;
    }
}
