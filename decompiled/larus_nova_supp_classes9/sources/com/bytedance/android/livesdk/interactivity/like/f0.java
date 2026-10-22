package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Consumer;
import zg1.n3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f0<T> implements Consumer {
    public final /* synthetic */ DiggWidget a;

    public f0(DiggWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        DiggWidget r0 = this.a;
        r0.onEvent((n3) r2);
    }
}
