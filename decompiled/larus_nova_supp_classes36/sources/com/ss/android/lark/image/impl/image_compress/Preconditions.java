package com.ss.android.lark.image.impl.image_compress;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
final class Preconditions {
    public static <T> T checkNotNull(T r0, Object r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(String.valueOf(r1));
    }
}
