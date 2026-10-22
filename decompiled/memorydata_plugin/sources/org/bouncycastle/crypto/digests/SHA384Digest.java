package org.bouncycastle.crypto.digests;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SHA384Digest extends LongDigest {
    public SHA384Digest() {
        this(CryptoServicePurpose.ANY);
    }

    public SHA384Digest(CryptoServicePurpose r1) {
        super(r1);
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        reset();
    }

    public SHA384Digest(SHA384Digest r1) {
        super(r1);
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SHA384Digest(this);
    }

    public CryptoServiceProperties cryptoServiceProperties() {
        return Utils.getDefaultProperties(this, 256, this.purpose);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r4, int r5) {
        finish();
        Pack.longToBigEndian(this.H1, r4, r5);
        Pack.longToBigEndian(this.H2, r4, r5 + 8);
        Pack.longToBigEndian(this.H3, r4, r5 + 16);
        Pack.longToBigEndian(this.H4, r4, r5 + 24);
        Pack.longToBigEndian(this.H5, r4, r5 + 32);
        Pack.longToBigEndian(this.H6, r4, r5 + 40);
        reset();
        return 48;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-384";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 48;
    }

    @Override // org.bouncycastle.crypto.digests.LongDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H1 = -3766243637369397544L;
        this.H2 = 7105036623409894663L;
        this.H3 = -7973340178411365097L;
        this.H4 = 1526699215303891257L;
        this.H5 = 7436329637833083697L;
        this.H6 = -8163818279084223215L;
        this.H7 = -2662702644619276377L;
        this.H8 = 5167115440072839076L;
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r3) {
        super.copyIn((SHA384Digest) ZeusTransformUtils.preCheckCast((Memoable) ZeusTransformUtils.wrapperContextForParams(r3, Memoable.class, "com.obric.memorydata.plugin"), SHA384Digest.class, "com.obric.memorydata.plugin"));
    }
}
