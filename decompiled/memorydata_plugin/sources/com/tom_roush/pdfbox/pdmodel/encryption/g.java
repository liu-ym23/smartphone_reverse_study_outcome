package com.tom_roush.pdfbox.pdmodel.encryption;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes6.dex */
public class g extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KeyStore f16203b;
    private final String c;

    public g(KeyStore r1, String r2, String r3) {
        this.f16203b = r1;
        this.c = r2;
        this.f16202a = r3;
    }

    public X509Certificate a() {
        if (this.f16203b.size() != 1) goto L8;
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.f16203b.aliases().nextElement(), String.class, "com.obric.memorydata.plugin");
        Certificate r3 = this.f16203b.getCertificate(r0);
    L6:
        return (X509Certificate) ZeusTransformUtils.preCheckCast(r3, X509Certificate.class, "com.obric.memorydata.plugin");
    L8:
        if (this.f16203b.containsAlias(this.c) == false) goto L11;
        r3 = this.f16203b.getCertificate(this.c);
        goto L6
    L11:
        throw new KeyStoreException("the keystore does not contain the given alias");
    }

    public Key b() {
    L12:
        e = move-exception;
        throw new KeyStoreException("the algorithm necessary to recover the key is not available", e);
    L15:
        e = move-exception;
        throw new KeyStoreException("the private key is not recoverable", e);
    L3:
        if (this.f16203b.size() != 1) goto L7;
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.f16203b.aliases().nextElement(), String.class, "com.obric.memorydata.plugin");     // Catch: NoSuchAlgorithmException -> L12 UnrecoverableKeyException -> L15
        return this.f16203b.getKey(r0, this.f16202a.toCharArray());
    L7:
        if (this.f16203b.containsAlias(this.c) == false) goto L11;
        return this.f16203b.getKey(this.c, this.f16202a.toCharArray());
    L11:
        throw new KeyStoreException("the keystore does not contain the given alias");     // Catch: NoSuchAlgorithmException -> L12 UnrecoverableKeyException -> L15
    }
}
