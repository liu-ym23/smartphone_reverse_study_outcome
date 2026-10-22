package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final c d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f9403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f9404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f9405c;

    static {
        d = new c();
    }

    public c(Runnable r5, Executor r10) {
        this.f9403a = r5;
        this.f9404b = r10;
    }

    public c() {
        this.f9403a = null;
        this.f9404b = null;
    }
}
