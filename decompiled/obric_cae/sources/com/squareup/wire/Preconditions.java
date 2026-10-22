package com.squareup.wire;

/* JADX INFO: loaded from: classes2.dex */
final class Preconditions {
    private Preconditions() {
    }

    public static void checkNotNull(Object r8, String r10) {
        if (r8 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r10);
    }
}
