package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final r<?> f5037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final r<?> f5038b = null;

    static {
        f5037a = new s();
        f5038b = c();
    }

    static r<?> a() {
        return f5037a;
    }

    static r<?> b() {
        r<?> r0 = f5038b;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static r<?> c() {
        return (r) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull", "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), r.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }
}
