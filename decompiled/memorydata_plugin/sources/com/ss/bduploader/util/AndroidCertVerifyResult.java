package com.ss.bduploader.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class AndroidCertVerifyResult {
    private final List<X509Certificate> mCertificateChain;
    private final boolean mIsIssuedByKnownRoot;
    private final int mStatus;

    public AndroidCertVerifyResult(int r1) {
        this.mStatus = r1;
        this.mIsIssuedByKnownRoot = false;
        this.mCertificateChain = Collections.emptyList();
    }

    public AndroidCertVerifyResult(int r3, boolean r4, List<X509Certificate> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.mStatus = r3;
        this.mIsIssuedByKnownRoot = r4;
        this.mCertificateChain = new ArrayList(r6);
    }

    public byte[][] getCertificateChainEncoded() {
        byte[][] r0 = new byte[this.mCertificateChain.size()][];
        int r2 = 0;
    L10:
        if (r2 >= this.mCertificateChain.size()) goto L7;
        r0[r2] = ((X509Certificate) ZeusTransformUtils.preCheckCast(this.mCertificateChain.get(r2), X509Certificate.class, "com.obric.memorydata.plugin")).getEncoded();     // Catch: CertificateEncodingException -> L8
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
}
