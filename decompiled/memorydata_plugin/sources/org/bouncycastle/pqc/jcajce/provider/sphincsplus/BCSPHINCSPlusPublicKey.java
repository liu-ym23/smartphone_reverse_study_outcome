package org.bouncycastle.pqc.jcajce.provider.sphincsplus;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusPublicKeyParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSPlusPublicKey;
import org.bouncycastle.pqc.jcajce.spec.SPHINCSPlusParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCSPHINCSPlusPublicKey implements SPHINCSPlusPublicKey {
    private static final long serialVersionUID = 1;
    private transient SPHINCSPlusPublicKeyParameters params;

    public BCSPHINCSPlusPublicKey(SubjectPublicKeyInfo r1) {
        init(r1);
    }

    public BCSPHINCSPlusPublicKey(SPHINCSPlusPublicKeyParameters r1) {
        this.params = r1;
    }

    private void init(SubjectPublicKeyInfo r3) {
        this.params = (SPHINCSPlusPublicKeyParameters) ZeusTransformUtils.preCheckCast(PublicKeyFactory.createKey(r3), SPHINCSPlusPublicKeyParameters.class, "com.obric.memorydata.plugin");
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        init(SubjectPublicKeyInfo.getInstance((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, BCSPHINCSPlusPublicKey.class) == false) goto L10;
        BCSPHINCSPlusPublicKey r4 = (BCSPHINCSPlusPublicKey) ZeusTransformUtils.preCheckCast(r3, BCSPHINCSPlusPublicKey.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.params.getEncoded(), r4.params.getEncoded());
    L10:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS+";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.params).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    CipherParameters getKeyParams() {
        return this.params;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SPHINCSPlusKey
    public SPHINCSPlusParameterSpec getParameterSpec() {
        return SPHINCSPlusParameterSpec.fromName(this.params.getParameters().getName());
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getEncoded());
    }
}
