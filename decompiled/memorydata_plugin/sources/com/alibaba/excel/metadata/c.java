package com.alibaba.excel.metadata;

import com.alibaba.excel.metadata.c;
import com.alibaba.excel.metadata.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<T extends c, C extends d> {
    public c() {
    }

    public T a() {
        return this;
    }

    public T a(Class<?> r2) {
        b().a(r2);
        return (T) a();
    }

    public abstract C b();
}
