package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p0<T> implements Consumer {
    public final /* synthetic */ i0.e a;
    public final /* synthetic */ i0.f b;

    public p0(i0.e r1, i0.g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.d = true;
        this.b.onFinish();
    }
}
