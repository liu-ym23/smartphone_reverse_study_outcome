package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.j;

/* JADX INFO: loaded from: classes.dex */
public class b<T> implements s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f825a;

    public b(T r1) {
        this.f825a = (T) j.a(r1);
    }

    @Override // com.bumptech.glide.load.engine.s
    public Class<T> c() {
        return (Class<T>) this.f825a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.s
    public final T d() {
        return this.f825a;
    }

    @Override // com.bumptech.glide.load.engine.s
    public final int e() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.s
    public void f() {
    }
}
