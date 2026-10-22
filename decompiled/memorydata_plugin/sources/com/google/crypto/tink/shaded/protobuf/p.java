package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Class<?> f5031a = null;

    static {
        f5031a = a();
    }

    private static final q a(String r4) {
        Class<?> r0 = f5031a;
        if (r0 != null) goto L9;
        return null;
    L9:
        return (q) ZeusTransformUtils.preCheckCast(r0.getDeclaredMethod(r4, new Class[0]).invoke(null, new Object[0]), q.class, "com.obric.memorydata.plugin");
    L8:
        return null;
    }

    static Class<?> a() {
        return ZeusTransformUtils.forName("com.google.crypto.tink.shaded.protobuf.ExtensionRegistry", "com.obric.memorydata.plugin");
    L4:
        return null;
    }

    public static q b() {
        q r0 = a("getEmptyRegistry");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return q.f5032a;
    }
}
