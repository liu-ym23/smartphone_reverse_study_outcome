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

    public AndroidCertVerifyResult(int r8) {
        this.mStatus = r8;
        this.mIsIssuedByKnownRoot = false;
        this.mCertificateChain = Collections.emptyList();
    }

    @CalledByNative
    public byte[][] getCertificateChainEncoded() {
        byte[][] r8 = new byte[this.mCertificateChain.size()][];
        int r10 = 0;
    L10:
        if (r10 >= this.mCertificateChain.size()) goto L7;
        r8[r10] = this.mCertificateChain.get(r10).getEncoded();     // Catch: CertificateEncodingException -> L8
        r10 = r10 + 1;
        goto L10
    L7:
        return r8;
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

    public AndroidCertVerifyResult(int r8, boolean r10, List<X509Certificate> r11) {
        this.mStatus = r8;
        this.mIsIssuedByKnownRoot = r10;
        this.mCertificateChain = new ArrayList(r11);
    }
}
