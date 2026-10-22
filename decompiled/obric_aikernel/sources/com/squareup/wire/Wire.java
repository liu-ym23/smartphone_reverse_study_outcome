package com.squareup.wire;

/* JADX INFO: loaded from: classes2.dex */
public final class Wire {
    private Wire() {
    }

    public static <T> T get(T r10, T r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        return r11;
    }
}
