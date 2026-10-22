package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v2<T> implements Consumer {
    public final /* synthetic */ m2 a;

    public v2(m2 r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Unit r2 = (Unit) r1;
        this.a.b.dispose();
    }
}
