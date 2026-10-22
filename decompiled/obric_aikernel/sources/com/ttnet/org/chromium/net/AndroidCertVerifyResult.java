package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net::android")
public class AndroidCertVerifyResult {
    private final List<X509Certificate> mCertificateChain;
    private final boolean mIsIssuedByKnownRoot;
    private final int mStatus;

    public AndroidCertVerifyResult(int r10) {
        this.mStatus = r10;
        this.mIsIssuedByKnownRoot = false;
        this.mCertificateChain = Collections.emptyList();
    }

    public AndroidCertVerifyResult(int r10, boolean r11, List<X509Certificate> r12) {
        this.mStatus = r10;
        this.mIsIssuedByKnownRoot = r11;
        this.mCertificateChain = new ArrayList(r12);
    }

    @CalledByNative
    public byte[][] getCertificateChainEncoded() {
        byte[][] r10 = new byte[this.mCertificateChain.size()][];
        int r11 = 0;
    L10:
        if (r11 >= this.mCertificateChain.size()) goto L7;
        r10[r11] = this.mCertificateChain.get(r11).getEncoded();     // Catch: CertificateEncodingException -> L8
        r11 = r11 + 1;
        goto L10
    L7:
        return r10;
    L9:
        return new byte[0][];
    }

    @CalledByNative
    public int getStatus() {
        return this.mStatus;
    }

    @CalledByNative
    public boolean isIssuedByKnownRoot() {
        return this.mIsIssuedByKnownRoot;
    }
}
