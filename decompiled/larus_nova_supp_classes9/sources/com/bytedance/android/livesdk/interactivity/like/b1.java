package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b1<T> implements Consumer {
    public final /* synthetic */ x0 a;

    public b1(x0 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        int r0 = com.bytedance.android.livesdk.interactivity.like.utils.b.a;
        com.bytedance.android.livesdk.interactivity.like.utils.b.b(this.a.getSpm(), "Fetch Icon Failed, Error: " + ((Throwable) r4).getMessage());
    }
}
