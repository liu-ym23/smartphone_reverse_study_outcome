package com.obric.aikernel.middleware.impl.settings;

import s7.g;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c("interval_hours")
    private final long f4603a;

    public d() {
        this.f4603a = 1;
    }

    @Override // s7.g
    public long a() {
        return this.f4603a;
    }

    public d b() {
        return new d();
    }
}
