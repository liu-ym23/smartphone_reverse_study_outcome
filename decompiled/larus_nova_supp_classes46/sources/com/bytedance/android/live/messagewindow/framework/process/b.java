package com.bytedance.android.live.messagewindow.framework.process;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        z61.b r4 = (z61.b) r3;
        this.a.a.put(r4.f, r4.e);
    }
}
