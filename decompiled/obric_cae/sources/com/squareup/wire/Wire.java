package com.squareup.wire;

/* JADX INFO: loaded from: classes2.dex */
public final class Wire {
    private Wire() {
    }

    public static <T> T get(T r8, T r10) {
        if (r8 == null) goto L5;
        return r8;
    L5:
        return r10;
    }
}
