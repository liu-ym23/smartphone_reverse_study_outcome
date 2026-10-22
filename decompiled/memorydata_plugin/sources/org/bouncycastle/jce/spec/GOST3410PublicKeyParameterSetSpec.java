package org.bouncycastle.jce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class GOST3410PublicKeyParameterSetSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f17977a;
    private BigInteger p;
    private BigInteger q;

    public GOST3410PublicKeyParameterSetSpec(BigInteger r1, BigInteger r2, BigInteger r3) {
        this.p = r1;
        this.q = r2;
        this.f17977a = r3;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, GOST3410PublicKeyParameterSetSpec.class) == false) goto L12;
        GOST3410PublicKeyParameterSetSpec r5 = (GOST3410PublicKeyParameterSetSpec) ZeusTransformUtils.preCheckCast(r4, GOST3410PublicKeyParameterSetSpec.class, "com.obric.memorydata.plugin");
        if (this.f17977a.equals(r5.f17977a) == true) goto L7;
        return false;
    L7:
        if (this.p.equals(r5.p) == true) goto L9;
        return false;
    L9:
        if (this.q.equals(r5.q) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public BigInteger getA() {
        return this.f17977a;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public int hashCode() {
        int r0 = this.f17977a.hashCode() ^ this.p.hashCode();
        return this.q.hashCode() ^ r0;
    }
}
