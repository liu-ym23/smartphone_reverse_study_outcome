package com.bytedance.frameworks.baselib.network.dispatcher;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements IRequest, Comparable<IRequest>, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AtomicBoolean f2325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final AtomicBoolean f2326b;
    protected int c;
    protected int d;

    public b() {
        this.f2325a = new AtomicBoolean(false);
        this.f2326b = new AtomicBoolean(false);
        this.c = 0;
    }

    public b c(int r1) {
        this.d = r1;
        return this;
    }

    @Deprecated
    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return this.f2326b.get();
    }

    public int f() {
        return this.c;
    }
}
