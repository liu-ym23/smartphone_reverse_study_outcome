package com.google.crypto.tink.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SecureRandom> f4880a = null;

    static {
        f4880a = new AnonymousClass1();
    }

    static /* synthetic */ SecureRandom a() {
        return d();
    }

    public static byte[] a(int r3) {
        byte[] r4 = new byte[r3];
        ((SecureRandom) ZeusTransformUtils.preCheckCast(f4880a.get(), SecureRandom.class, "com.obric.memorydata.plugin")).nextBytes(r4);
        return r4;
    }

    private static Provider b() {
        return (Provider) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("org.conscrypt.Conscrypt", "com.obric.memorydata.plugin").getMethod("newProvider", new Class[0]).invoke(null, new Object[0]), Provider.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new GeneralSecurityException("Failed to get Conscrypt provider", e);
    }

    private static SecureRandom c() {
        return SecureRandom.getInstance("SHA1PRNG", "GmsCore_OpenSSL");
    L5:
        return SecureRandom.getInstance("SHA1PRNG", "AndroidOpenSSL");
    L7:
        return SecureRandom.getInstance("SHA1PRNG", "Conscrypt");
    L9:
        return SecureRandom.getInstance("SHA1PRNG", b());
    L12:
        return new SecureRandom();
    }

    private static SecureRandom d() {
        SecureRandom r0 = c();
        r0.nextLong();
        return r0;
    }
}
