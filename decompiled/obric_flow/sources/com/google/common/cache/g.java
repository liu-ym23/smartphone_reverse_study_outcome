package com.google.common.cache;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f8716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f8717b;

    public g(h r5, Executor r10) {
        this.f8716a = r5;
        this.f8717b = r10;
    }

    @Override // com.google.common.cache.h
    public final Object load(Object r5) {
        return this.f8716a.load(r5);
    }

    @Override // com.google.common.cache.h
    public final Map loadAll(Iterable r5) {
        return this.f8716a.loadAll(r5);
    }

    @Override // com.google.common.cache.h
    public final com.google.common.util.concurrent.w0 reload(Object r5, Object r10) {
        com.google.common.util.concurrent.x0 r11 = new com.google.common.util.concurrent.x0(new com.airbnb.lottie.k(this, r5, r10));
        this.f8717b.execute(r11);
        return r11;
    }
}
