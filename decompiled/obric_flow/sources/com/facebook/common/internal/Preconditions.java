package com.facebook.common.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Preconditions {
    public static Object a(Object r5, String r10) {
        if (r5 == null) goto L5;
        return r5;
    L5:
        throw new NullPointerException(String.valueOf(r10));
    }
}
