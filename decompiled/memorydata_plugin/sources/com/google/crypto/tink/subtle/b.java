package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T_WRAPPER extends com.google.crypto.tink.subtle.c<JcePrimitiveT>, JcePrimitiveT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<com.google.crypto.tink.subtle.c.a, Cipher> f5053a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b<com.google.crypto.tink.subtle.c.e, Mac> f5054b = null;
    public static final b<com.google.crypto.tink.subtle.c.g, Signature> c = null;
    public static final b<com.google.crypto.tink.subtle.c.f, MessageDigest> d = null;
    public static final b<com.google.crypto.tink.subtle.c.b, KeyAgreement> e = null;
    public static final b<com.google.crypto.tink.subtle.c.d, KeyPairGenerator> f = null;
    public static final b<com.google.crypto.tink.subtle.c.C0211c, KeyFactory> g = null;
    private final d<JcePrimitiveT> h;

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a<JcePrimitiveT> implements d<JcePrimitiveT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.crypto.tink.subtle.c<JcePrimitiveT> f5055a;

        private a(com.google.crypto.tink.subtle.c<JcePrimitiveT> r3) {
            this.f5055a = (com.google.crypto.tink.subtle.c) ZeusTransformUtils.wrapperContextForParams(r3, com.google.crypto.tink.subtle.c.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ a(com.google.crypto.tink.subtle.c r2, AnonymousClass1 r3) {
            this((com.google.crypto.tink.subtle.c) ZeusTransformUtils.wrapperContextForParams(r2, com.google.crypto.tink.subtle.c.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.subtle.b.d
        public JcePrimitiveT a(String r7) {
            Iterator<Provider> r0 = b.a(new String[]{"GmsCore_OpenSSL", "AndroidOpenSSL"}).iterator();
            Exception r2 = null;
        L4:
            if (r0.hasNext() == false) goto L12;
            return this.f5055a.a(r7, (Provider) ZeusTransformUtils.preCheckCast(r0.next(), Provider.class, "com.obric.memorydata.plugin"));
        L8:
            e = move-exception;
            if (r2 != null) goto L4;
            r2 = e;
            goto L4
        L12:
            return this.f5055a.a(r7, null);
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.b$b, reason: collision with other inner class name */
    private static class C0210b<JcePrimitiveT> implements d<JcePrimitiveT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.crypto.tink.subtle.c<JcePrimitiveT> f5056a;

        private C0210b(com.google.crypto.tink.subtle.c<JcePrimitiveT> r3) {
            this.f5056a = (com.google.crypto.tink.subtle.c) ZeusTransformUtils.wrapperContextForParams(r3, com.google.crypto.tink.subtle.c.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ C0210b(com.google.crypto.tink.subtle.c r2, AnonymousClass1 r3) {
            this((com.google.crypto.tink.subtle.c) ZeusTransformUtils.wrapperContextForParams(r2, com.google.crypto.tink.subtle.c.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.subtle.b.d
        public JcePrimitiveT a(String r2) {
            return this.f5056a.a(r2, null);
        }
    }

    private static class c<JcePrimitiveT> implements d<JcePrimitiveT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.crypto.tink.subtle.c<JcePrimitiveT> f5057a;

        private c(com.google.crypto.tink.subtle.c<JcePrimitiveT> r3) {
            this.f5057a = (com.google.crypto.tink.subtle.c) ZeusTransformUtils.wrapperContextForParams(r3, com.google.crypto.tink.subtle.c.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ c(com.google.crypto.tink.subtle.c r2, AnonymousClass1 r3) {
            this((com.google.crypto.tink.subtle.c) ZeusTransformUtils.wrapperContextForParams(r2, com.google.crypto.tink.subtle.c.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.crypto.tink.subtle.b.d
        public JcePrimitiveT a(String r6) {
            Iterator<Provider> r0 = b.a(new String[]{"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"}).iterator();
            Exception r1 = null;
        L4:
            if (r0.hasNext() == false) goto L12;
            Provider r2 = (Provider) ZeusTransformUtils.preCheckCast(r0.next(), Provider.class, "com.obric.memorydata.plugin");
            return this.f5057a.a(r6, r2);
        L8:
            e = move-exception;
            if (r1 != null) goto L4;
            r1 = e;
            goto L4
        L12:
            throw new GeneralSecurityException("No good Provider found.", r1);
        }
    }

    private interface d<JcePrimitiveT> {
        JcePrimitiveT a(String r1);
    }

    static {
        f5053a = new b(new com.google.crypto.tink.subtle.c.a());
        f5054b = new b(new com.google.crypto.tink.subtle.c.e());
        c = new b(new com.google.crypto.tink.subtle.c.g());
        d = new b(new com.google.crypto.tink.subtle.c.f());
        e = new b(new com.google.crypto.tink.subtle.c.b());
        f = new b(new com.google.crypto.tink.subtle.c.d());
        g = new b(new com.google.crypto.tink.subtle.c.C0211c());
    }

    public b(T_WRAPPER r3) {
        com.google.crypto.tink.subtle.c r4 = (com.google.crypto.tink.subtle.c) ZeusTransformUtils.wrapperContextForParams(r3, com.google.crypto.tink.subtle.c.class, "com.obric.memorydata.plugin");
        AnonymousClass1 r1 = null;
        if (TinkFipsUtil.a() == false) goto L7;
        d<JcePrimitiveT> r0 = new c(r4, r1);
    L5:
        this.h = r0;
        return;
    L7:
        if (e.a() == false) goto L9;
        r0 = new a(r4, r1);
        goto L5
    L9:
        r0 = new C0210b(r4, r1);
        goto L5
    }

    public static List<Provider> a(String... r4) {
        ArrayList r0 = new ArrayList();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        Provider r3 = Security.getProvider(r4[r2]);
        if (r3 == null) goto L7;
        r0.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    public JcePrimitiveT a(String r1) {
        return this.h.a(r1);
    }
}
