package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<V> implements Callable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ DataCenter b;
    public final /* synthetic */ int c;

    public r(Context r1, DataCenter r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.concurrent.Callable
    public final Long call() {
        long r0 = System.currentTimeMillis();
        ih0.c r2 = u.a;
        u.a(this.a, this.b, this.c);
        return Long.valueOf(System.currentTimeMillis() - r0);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
