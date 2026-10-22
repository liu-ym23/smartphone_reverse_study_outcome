package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.content.Context;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ RevShareViewServiceImpl a;
    public final /* synthetic */ Context b;

    public i(RevShareViewServiceImpl r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.b.remove(this.b);
    }
}
