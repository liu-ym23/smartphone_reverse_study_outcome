package com.squareup.wire;

/* JADX INFO: loaded from: classes3.dex */
public final class Wire {
    private Wire() {
    }

    public static <T> T get(T r5, T r10) {
        if (r5 == null) goto L5;
        return r5;
    L5:
        return r10;
    }
}
