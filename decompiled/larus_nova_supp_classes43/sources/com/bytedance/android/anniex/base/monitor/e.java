package com.bytedance.android.anniex.base.monitor;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e<V> implements Callable {
    public final /* synthetic */ MonitorCenter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List<String> c;

    public e(MonitorCenter r1, String r10, List<String> r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // java.util.concurrent.Callable
    public final String call() {
        MonitorCenter.b r0 = this.a.b.get(this.b);
        if (r0 == null) goto L7;
        r0.getClass();
        return null;
    L7:
        return null;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
