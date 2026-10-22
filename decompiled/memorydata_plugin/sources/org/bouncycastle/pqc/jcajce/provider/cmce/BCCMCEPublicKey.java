package org.bouncycastle.pqc.jcajce.provider.cmce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.pqc.crypto.cmce.CMCEPublicKeyParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.pqc.jcajce.interfaces.CMCEKey;
import org.bouncycastle.pqc.jcajce.spec.CMCEParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCCMCEPublicKey implements PublicKey, CMCEKey {
    private static final long serialVersionUID = 1;
    private transient CMCEPublicKeyParameters params;

    public BCCMCEPublicKey(SubjectPublicKeyInfo r1) {
        init(r1);
    }

    public BCCMCEPublicKey(CMCEPublicKeyParameters r1) {
        this.params = r1;
    }

    private void init(SubjectPublicKeyInfo r3) {
        this.params = (CMCEPublicKeyParameters) ZeusTransformUtils.preCheckCast(PublicKeyFactory.createKey(r3), CMCEPublicKeyParameters.class, "com.obric.memorydata.plugin");
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
        if (ZeusTransformUtils.instanceOf(r3, BCCMCEPublicKey.class) == false) goto L10;
        BCCMCEPublicKey r4 = (BCCMCEPublicKey) ZeusTransformUtils.preCheckCast(r3, BCCMCEPublicKey.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.params.getEncoded(), r4.params.getEncoded());
    L10:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "CMCE";
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

    CMCEPublicKeyParameters getKeyParams() {
        return this.params;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.CMCEKey
    public CMCEParameterSpec getParameterSpec() {
        return CMCEParameterSpec.fromName(this.params.getParameters().getName());
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getEncoded());
    }
}
