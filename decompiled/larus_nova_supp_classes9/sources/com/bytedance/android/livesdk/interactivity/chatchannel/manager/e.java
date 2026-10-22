package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ c a;
    public final /* synthetic */ s22.e b;

    public e(c r1, s22.e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        this.b.notifyChannelUnreadCountChanged(this.a, ((Integer) r3).intValue());
    }
}
