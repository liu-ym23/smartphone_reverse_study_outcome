package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class X9ECPoint extends ASN1Object {
    private ECCurve c;
    private final ASN1OctetString encoding;
    private ECPoint p;

    public X9ECPoint(ECCurve r1, ASN1OctetString r2) {
        this(r1, r2.getOctets());
    }

    public X9ECPoint(ECCurve r1, byte[] r2) {
        this.c = r1;
        this.encoding = new DEROctetString(Arrays.clone(r2));
    }

    public X9ECPoint(ECPoint r2, boolean r3) {
        this.p = r2.normalize();
        this.encoding = new DEROctetString(r2.getEncoded(r3));
    }

    public synchronized ECPoint getPoint() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.p != null) goto L6;
        this.p = this.c.decodePoint(this.encoding.getOctets()).normalize();     // Catch: Throwable -> L9
    L6:
        ECPoint r0 = this.p;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.encoding;
    }
}
