package com.squareup.wire;

/* JADX INFO: loaded from: classes3.dex */
final class Preconditions {
    private Preconditions() {
    }

    public static void checkNotNull(Object r5, String r10) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r10);
    }
}
