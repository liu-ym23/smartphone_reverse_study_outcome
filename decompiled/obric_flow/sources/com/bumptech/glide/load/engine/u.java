package com.bumptech.glide.load.engine;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.request.d f1564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f1565b;

    public u(com.bumptech.glide.request.d r5, Executor r10) {
        this.f1564a = r5;
        this.f1565b = r10;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof u) == true) goto L5;
        return false;
    L5:
        return this.f1564a.equals(((u) r5).f1564a);
    }

    public final int hashCode() {
        return this.f1564a.hashCode();
    }
}
