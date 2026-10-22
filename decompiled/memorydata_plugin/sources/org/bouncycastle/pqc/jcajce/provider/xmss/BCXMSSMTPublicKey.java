package org.bouncycastle.pqc.jcajce.provider.xmss;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCXMSSMTPublicKey implements PublicKey {
    private static final long serialVersionUID = 3230324130542413475L;
    private transient XMSSMTPublicKeyParameters keyParams;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSMTPublicKey(ASN1ObjectIdentifier r1, XMSSMTPublicKeyParameters r2) {
        this.treeDigest = r1;
        this.keyParams = r2;
    }

    public BCXMSSMTPublicKey(SubjectPublicKeyInfo r1) {
        init(r1);
    }

    private void init(SubjectPublicKeyInfo r3) {
        XMSSMTPublicKeyParameters r4 = (XMSSMTPublicKeyParameters) ZeusTransformUtils.preCheckCast(PublicKeyFactory.createKey(r3), XMSSMTPublicKeyParameters.class, "com.obric.memorydata.plugin");
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
        if (ZeusTransformUtils.instanceOf(r5, BCXMSSMTPublicKey.class) == false) goto L14;
        BCXMSSMTPublicKey r6 = (BCXMSSMTPublicKey) ZeusTransformUtils.preCheckCast(r5, BCXMSSMTPublicKey.class, "com.obric.memorydata.plugin");
        if (this.treeDigest.equals(r6.treeDigest) == false) goto L13;
        if (Arrays.areEqual(this.keyParams.toByteArray(), r6.keyParams.toByteArray()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSSMT";
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

    public int getLayers() {
        return this.keyParams.getParameters().getLayers();
    }

    public String getTreeDigest() {
        return DigestUtil.getXMSSDigestName(this.treeDigest);
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (Arrays.hashCode(this.keyParams.toByteArray()) * 37);
    }
}
