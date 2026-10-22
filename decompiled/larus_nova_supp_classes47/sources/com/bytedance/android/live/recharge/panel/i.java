package com.bytedance.android.live.recharge.panel;

import io.reactivex.functions.Consumer;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ h.b a;

    public i(h.b r1) {
        this.a = r1;
    }

    public final void accept(T r2) {
        h r3 = this.a.b;
        KProperty[] r0 = h.B;
        r3.a();
    }
}
