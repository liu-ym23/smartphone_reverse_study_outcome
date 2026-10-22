package org.bouncycastle.pqc.jcajce.provider.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.lms.HSSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPublicKeyParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.pqc.jcajce.interfaces.LMSKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCLMSPublicKey implements PublicKey, LMSKey {
    private static final long serialVersionUID = -5617456225328969766L;
    private transient LMSKeyParameters keyParams;

    public BCLMSPublicKey(SubjectPublicKeyInfo r1) {
        init(r1);
    }

    public BCLMSPublicKey(LMSKeyParameters r1) {
        this.keyParams = r1;
    }

    private void init(SubjectPublicKeyInfo r3) {
        this.keyParams = (LMSKeyParameters) ZeusTransformUtils.preCheckCast(PublicKeyFactory.createKey(r3), LMSKeyParameters.class, "com.obric.memorydata.plugin");
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        init(SubjectPublicKeyInfo.getInstance((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    public boolean equals(Object r4) {
        if (r4 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, BCLMSPublicKey.class) == false) goto L11;
        BCLMSPublicKey r5 = (BCLMSPublicKey) ZeusTransformUtils.preCheckCast(r4, BCLMSPublicKey.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.keyParams.getEncoded(), r5.keyParams.getEncoded());
    L11:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "LMS";
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

    CipherParameters getKeyParams() {
        return this.keyParams;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSKey
    public int getLevels() {
        if (ZeusTransformUtils.instanceOf(this.keyParams, LMSPublicKeyParameters.class) == false) goto L7;
        return 1;
    L7:
        return ((HSSPublicKeyParameters) ZeusTransformUtils.preCheckCast(this.keyParams, HSSPublicKeyParameters.class, "com.obric.memorydata.plugin")).getL();
    }

    public int hashCode() {
        return Arrays.hashCode(this.keyParams.getEncoded());
    L4:
        return -1;
    }
}
