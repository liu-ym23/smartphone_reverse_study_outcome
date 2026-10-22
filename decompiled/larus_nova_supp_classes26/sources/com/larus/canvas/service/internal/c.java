package com.larus.canvas.service.internal;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class c<T> {
    public final ny8.d<T> a;
    public final Lazy b;
    public final Lazy c;

    public c(ny8.d<T> r1) {
        this.a = r1;
        this.b = LazyKt.lazy(new a());
        this.c = LazyKt.lazy(new b());
    }
}
