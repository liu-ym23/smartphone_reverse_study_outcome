package com.google.common.cache;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Callable f8783a;

    public z(Callable r5) {
        this.f8783a = r5;
    }

    @Override // com.google.common.cache.h
    public final Object load(Object r5) {
        return this.f8783a.call();
    }
}
