package org.bouncycastle.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

/* JADX INFO: loaded from: classes7.dex */
public class CompositePublicKey implements PublicKey {
    private final List<PublicKey> keys;

    public CompositePublicKey(PublicKey... r4) {
        if (r4 == null) goto L13;
        if (r4.length == 0) goto L13;
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = 0;
    L8:
        if (r1 == r4.length) goto L10;
        r0.add(r4[r1]);
        r1 = r1 + 1;
        goto L8
    L10:
        this.keys = Collections.unmodifiableList(r0);
        return;
    L13:
        throw new IllegalArgumentException("at least one public key must be provided");
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, CompositePublicKey.class) == true) goto L9;
        return false;
    L9:
        return this.keys.equals(((CompositePublicKey) ZeusTransformUtils.preCheckCast(r3, CompositePublicKey.class, "com.obric.memorydata.plugin")).keys);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "Composite";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        int r1 = 0;
    L4:
        if (r1 == this.keys.size()) goto L11;
        r0.add(SubjectPublicKeyInfo.getInstance(((PublicKey) ZeusTransformUtils.preCheckCast(this.keys.get(r1), PublicKey.class, "com.obric.memorydata.plugin")).getEncoded()));
        r1 = r1 + 1;
        goto L4
    L11:
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(MiscObjectIdentifiers.id_composite_key), new DERSequence(r0)).getEncoded("DER");
    L8:
        e = move-exception;
        throw new IllegalStateException("unable to encode composite key: " + e.getMessage());
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public List<PublicKey> getPublicKeys() {
        return this.keys;
    }

    public int hashCode() {
        return this.keys.hashCode();
    }
}
