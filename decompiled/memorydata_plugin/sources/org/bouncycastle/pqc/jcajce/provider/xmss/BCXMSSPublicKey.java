package org.bouncycastle.pqc.jcajce.provider.xmss;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCXMSSPublicKey implements PublicKey {
    private static final long serialVersionUID = -5617456225328969766L;
    private transient XMSSPublicKeyParameters keyParams;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSPublicKey(ASN1ObjectIdentifier r1, XMSSPublicKeyParameters r2) {
        this.treeDigest = r1;
        this.keyParams = r2;
    }

    public BCXMSSPublicKey(SubjectPublicKeyInfo r1) {
        init(r1);
    }

    private void init(SubjectPublicKeyInfo r3) {
        XMSSPublicKeyParameters r4 = (XMSSPublicKeyParameters) ZeusTransformUtils.preCheckCast(PublicKeyFactory.createKey(r3), XMSSPublicKeyParameters.class, "com.obric.memorydata.plugin");
        this.keyParams = r4;
        this.treeDigest = DigestUtil.getDigestOID(r4.getTreeDigest());
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        init(SubjectPublicKeyInfo.getInstance((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BCXMSSPublicKey.class) == false) goto L15;
        BCXMSSPublicKey r6 = (BCXMSSPublicKey) ZeusTransformUtils.preCheckCast(r5, BCXMSSPublicKey.class, "com.obric.memorydata.plugin");
        if (this.treeDigest.equals(r6.treeDigest) == false) goto L14;
        if (Arrays.areEqual(this.keyParams.getEncoded(), r6.keyParams.getEncoded()) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.keyParams).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int getHeight() {
        return this.keyParams.getParameters().getHeight();
    }

    CipherParameters getKeyParams() {
        return this.keyParams;
    }

    public String getTreeDigest() {
        return DigestUtil.getXMSSDigestName(this.treeDigest);
    }

    public int hashCode() {
        int r0 = this.treeDigest.hashCode();     // Catch: IOException -> L5
        return r0 + (Arrays.hashCode(this.keyParams.getEncoded()) * 37);
    L6:
        return this.treeDigest.hashCode();
    }
}
