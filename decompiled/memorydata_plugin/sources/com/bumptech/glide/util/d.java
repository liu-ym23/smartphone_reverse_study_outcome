package com.bumptech.glide.util;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Executor f977a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Executor f978b = null;

    static {
        f977a = new AnonymousClass1();
        f978b = new AnonymousClass2();
    }

    public static Executor a() {
        return f977a;
    }

    public static Executor b() {
        return f978b;
    }
}
