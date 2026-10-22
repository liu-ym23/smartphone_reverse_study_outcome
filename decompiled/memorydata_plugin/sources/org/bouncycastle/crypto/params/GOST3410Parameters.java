package org.bouncycastle.crypto.params;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class GOST3410Parameters implements CipherParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f17975a;
    private BigInteger p;
    private BigInteger q;

    public GOST3410Parameters(BigInteger r1, BigInteger r2, BigInteger r3) {
        this.p = r1;
        this.q = r2;
        this.f17975a = r3;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, GOST3410Parameters.class) == true) goto L5;
        return false;
    L5:
        GOST3410Parameters r5 = (GOST3410Parameters) ZeusTransformUtils.preCheckCast(r4, GOST3410Parameters.class, "com.obric.memorydata.plugin");
        if (r5.getP().equals(this.p) == true) goto L8;
        return false;
    L8:
        if (r5.getQ().equals(this.q) == true) goto L10;
        return false;
    L10:
        if (r5.getA().equals(this.f17975a) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public BigInteger getA() {
        return this.f17975a;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public int hashCode() {
        int r0 = this.p.hashCode() ^ this.q.hashCode();
        return this.f17975a.hashCode() ^ r0;
    }
}
