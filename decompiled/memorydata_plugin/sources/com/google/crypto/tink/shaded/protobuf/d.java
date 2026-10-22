package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f5012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?> f5013b = null;
    private static final boolean c = false;

    static {
        f5013b = a("libcore.io.Memory");
        if (f5012a == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        c = r0;
        return;
    L5:
        if (a("org.robolectric.Robolectric") == null) goto L7;
        r0 = true;
        goto L8
    }

    private static <T> Class<T> a(String r1) {
        return ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin");
    L4:
        return null;
    }

    static boolean a() {
        if (f5012a == false) goto L5;
    L10:
        return true;
    L5:
        if (f5013b != null) goto L7;
    L9:
        return false;
    L7:
        if (c == true) goto L9;
        goto L9
    }

    static Class<?> b() {
        return f5013b;
    }
}
