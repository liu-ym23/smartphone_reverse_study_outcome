package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f9401b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f9402a;

    static {
        final String r5 = "Failure occurred while trying to finish a future.";
        f9401b = new b(new AbstractFuture$Failure$1(r5));
    }

    public b(Throwable r5) {
        r5.getClass();
        this.f9402a = r5;
    }
}
