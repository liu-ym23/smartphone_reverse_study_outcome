package com.bytedance.android.live.core.utils;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ Runnable b;

    public b(Runnable r2) {
        this.a = "showCountDownView";
        this.b = r2;
    }

    public final void accept(Object r2) {
        AnchorMainPostOptUtils.b(this.a, this.b);
    }
}
