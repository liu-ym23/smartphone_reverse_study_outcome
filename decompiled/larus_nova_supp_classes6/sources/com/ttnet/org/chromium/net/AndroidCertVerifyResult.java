package com.ttnet.org.chromium.net;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@JNINamespace("net::android")
public class AndroidCertVerifyResult {
    private final List<X509Certificate> mCertificateChain;
    private final boolean mIsIssuedByKnownRoot;
    private final int mStatus;

    public byte[][] getCertificateChainEncoded() {
        byte[][] r0 = new byte[this.mCertificateChain.size()][];
        int r2 = 0;
    L10:
        if (r2 >= this.mCertificateChain.size()) goto L7;
        r0[r2] = ((X509Certificate) ListProtector.get(this.mCertificateChain, r2)).getEncoded();     // Catch: CertificateEncodingException -> L8
        r2 = r2 + 1;
        goto L10
    L7:
        return r0;
    L9:
        return new byte[0][];
    }

    public int getStatus() {
        return this.mStatus;
    }

    public boolean isIssuedByKnownRoot() {
        return this.mIsIssuedByKnownRoot;
    }

    public AndroidCertVerifyResult(int r1) {
        this.mStatus = r1;
        this.mIsIssuedByKnownRoot = false;
        this.mCertificateChain = Collections.emptyList();
    }

    public AndroidCertVerifyResult(int r1, boolean r2, List<X509Certificate> r3) {
        this.mStatus = r1;
        this.mIsIssuedByKnownRoot = r2;
        this.mCertificateChain = new ArrayList(r3);
    }
}
