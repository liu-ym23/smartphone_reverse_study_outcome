package com.squareup.wire;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
final class Preconditions {
    private Preconditions() {
    }

    public static void checkNotNull(Object r0, String r1) {
        if (r0 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r1);
    }
}
