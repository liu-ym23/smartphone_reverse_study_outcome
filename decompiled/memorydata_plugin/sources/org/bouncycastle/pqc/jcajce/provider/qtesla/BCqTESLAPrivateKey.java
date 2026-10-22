package org.bouncycastle.pqc.jcajce.provider.qtesla;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.pqc.jcajce.spec.QTESLAParameterSpec;
import org.bouncycastle.pqc.legacy.crypto.qtesla.QTESLAPrivateKeyParameters;
import org.bouncycastle.pqc.legacy.crypto.qtesla.QTESLASecurityCategory;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCqTESLAPrivateKey implements PrivateKey {
    private static final long serialVersionUID = 1;
    private transient ASN1Set attributes;
    private transient QTESLAPrivateKeyParameters keyParams;

    public BCqTESLAPrivateKey(PrivateKeyInfo r1) {
        init(r1);
    }

    public BCqTESLAPrivateKey(QTESLAPrivateKeyParameters r1) {
        this.keyParams = r1;
    }

    private void init(PrivateKeyInfo r3) {
        this.attributes = r3.getAttributes();
        this.keyParams = (QTESLAPrivateKeyParameters) ZeusTransformUtils.preCheckCast(PrivateKeyFactory.createKey(r3), QTESLAPrivateKeyParameters.class, "com.obric.memorydata.plugin");
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
        if (ZeusTransformUtils.instanceOf(r5, BCqTESLAPrivateKey.class) == false) goto L14;
        BCqTESLAPrivateKey r6 = (BCqTESLAPrivateKey) ZeusTransformUtils.preCheckCast(r5, BCqTESLAPrivateKey.class, "com.obric.memorydata.plugin");
        if (this.keyParams.getSecurityCategory() != r6.keyParams.getSecurityCategory()) goto L13;
        if (Arrays.areEqual(this.keyParams.getSecret(), r6.keyParams.getSecret()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return QTESLASecurityCategory.getName(this.keyParams.getSecurityCategory());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return PrivateKeyInfoFactory.createPrivateKeyInfo(this.keyParams, this.attributes).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    CipherParameters getKeyParams() {
        return this.keyParams;
    }

    public QTESLAParameterSpec getParams() {
        return new QTESLAParameterSpec(getAlgorithm());
    }

    public int hashCode() {
        return this.keyParams.getSecurityCategory() + (Arrays.hashCode(this.keyParams.getSecret()) * 37);
    }
}
