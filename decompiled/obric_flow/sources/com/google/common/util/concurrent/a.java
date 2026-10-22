package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9398c = null;
    public static final a d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RuntimeException f9400b;

    static {
        if (o.d == false) goto L5;
        d = null;
        f9398c = null;
        return;
    L5:
        d = new a(false, null);
        f9398c = new a(true, null);
    }

    public a(boolean r5, RuntimeException r10) {
        this.f9399a = r5;
        this.f9400b = r10;
    }
}
