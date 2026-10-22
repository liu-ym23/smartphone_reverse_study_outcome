package com.facebook.common.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Throwables {
    public static void a(Throwable r5, Class r10) {
        if (r10.isInstance(r5) == true) goto L6;
        return;
    L6:
        throw ((Throwable) r10.cast(r5));
    }
}
