package com.bytedance.platform.godzilla.a;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static <T> T a(T r0, String r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new IllegalArgumentException(r1);
    }

    public static void a(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r1);
    }
}
