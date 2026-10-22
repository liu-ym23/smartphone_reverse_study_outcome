package com.bytedance.android.ec.core.hybrid.prefetch;

import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ NativePrefetch a;
    public final /* synthetic */ String b;
    public final /* synthetic */ t c;

    public i(NativePrefetch r1, String r10, t r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void accept(Object r10) {
        ConcurrentHashMap<String, NativePrefetch> r0 = NativePrefetchUtil.a;
        NativePrefetchUtil.k("NativePrefetch", "end post request success, api key is " + this.b);
        this.a.w(this.b);
        NativePrefetch.b(this.a, (Serializable) r10, this.c, this.b);
    }
}
