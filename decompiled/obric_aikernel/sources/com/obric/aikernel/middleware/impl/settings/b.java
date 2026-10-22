package com.obric.aikernel.middleware.impl.settings;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements s7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c("start_delay_second")
    private final int f4593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d6.c("interval_second")
    private final int f4594b;

    public b() {
        this.f4593a = 360;
        this.f4594b = 360;
    }

    @Override // s7.c
    public int a() {
        return this.f4593a;
    }

    @Override // s7.c
    public int b() {
        return this.f4594b;
    }

    public b c() {
        return new b();
    }
}
