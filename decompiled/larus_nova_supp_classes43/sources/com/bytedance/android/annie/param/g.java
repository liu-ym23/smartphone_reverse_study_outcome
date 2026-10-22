package com.bytedance.android.annie.param;

import com.bytedance.android.annie.Annie;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g<V> implements Callable {
    public static final g<V> a = null;

    static {
        a = new g();
    }

    public g() {
    }

    @Override // java.util.concurrent.Callable
    public final k call() {
        k r0 = new k(null);
        ((p9.f) Annie.getService$default(p9.f.class, null, 2, null)).C1(r0);
        return r0;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
