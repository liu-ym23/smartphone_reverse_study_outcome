package org.bouncycastle.pqc.jcajce.provider.sphincs;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCSphincs256PrivateKey implements PrivateKey, SPHINCSKey {
    private static final long serialVersionUID = 1;
    private transient ASN1Set attributes;
    private transient SPHINCSPrivateKeyParameters params;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCSphincs256PrivateKey(ASN1ObjectIdentifier r1, SPHINCSPrivateKeyParameters r2) {
        this.treeDigest = r1;
        this.params = r2;
    }

    public BCSphincs256PrivateKey(PrivateKeyInfo r1) {
        init(r1);
    }

    private void init(PrivateKeyInfo r3) {
        this.attributes = r3.getAttributes();
        this.treeDigest = SPHINCS256KeyParams.getInstance(r3.getPrivateKeyAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
        this.params = (SPHINCSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(PrivateKeyFactory.createKey(r3), SPHINCSPrivateKeyParameters.class, "com.obric.memorydata.plugin");
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        init(PrivateKeyInfo.getInstance((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BCSphincs256PrivateKey.class) == false) goto L14;
        BCSphincs256PrivateKey r6 = (BCSphincs256PrivateKey) ZeusTransformUtils.preCheckCast(r5, BCSphincs256PrivateKey.class, "com.obric.memorydata.plugin");
        if (this.treeDigest.equals(r6.treeDigest) == false) goto L13;
        if (Arrays.areEqual(this.params.getKeyData(), r6.params.getKeyData()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
    L8:
        return null;
    L3:
        if (this.params.getTreeDigest() == null) goto L5;
        PrivateKeyInfo r5 = PrivateKeyInfoFactory.createPrivateKeyInfo(this.params, this.attributes);     // Catch: IOException -> L8
    L6:
        return r5.getEncoded();
    L5:
        r5 = new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, new SPHINCS256KeyParams(new AlgorithmIdentifier(this.treeDigest))), new DEROctetString(this.params.getKeyData()), this.attributes);     // Catch: IOException -> L8
        goto L6
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey
    public byte[] getKeyData() {
        return this.params.getKeyData();
    }

    CipherParameters getKeyParams() {
        return this.params;
    }

    ASN1ObjectIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (Arrays.hashCode(this.params.getKeyData()) * 37);
    }
}
