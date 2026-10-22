package com.google.common.cache;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    public h() {
    }

    public static <K, V> h asyncReloading(h r5, Executor r10) {
        r5.getClass();
        r10.getClass();
        return new g(r5, r10);
    }

    public static <K, V> h from(com.google.common.base.q r5) {
        return new CacheLoader$FunctionToCacheLoader(r5);
    }

    public abstract Object load(Object r5);

    public Map<Object, Object> loadAll(Iterable<Object> r5) throws Exception {
        throw new CacheLoader$UnsupportedLoadingOperationException();
    }

    public com.google.common.util.concurrent.w0 reload(Object r5, Object r10) throws Exception {
        r5.getClass();
        r10.getClass();
        Object r11 = load(r5);
        if (r11 != null) goto L6;
        return com.google.common.util.concurrent.u0.f9438b;
    L6:
        return new com.google.common.util.concurrent.u0(r11);
    }

    public static <V> h from(com.google.common.base.e0 r5) {
        return new CacheLoader$SupplierToCacheLoader(r5);
    }
}
