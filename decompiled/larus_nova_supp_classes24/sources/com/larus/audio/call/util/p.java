package com.larus.audio.call.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class p {
    public static final boolean a(String r1) {
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        return !r2;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L10
    }
}
