package org.bouncycastle.pqc.jcajce.provider.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCLMSPrivateKey implements PrivateKey, LMSPrivateKey {
    private static final long serialVersionUID = 8568701712864512338L;
    private transient ASN1Set attributes;
    private transient LMSKeyParameters keyParams;

    public BCLMSPrivateKey(PrivateKeyInfo r1) {
        init(r1);
    }

    public BCLMSPrivateKey(LMSKeyParameters r1) {
        this.keyParams = r1;
    }

    private void init(PrivateKeyInfo r3) {
        this.attributes = r3.getAttributes();
        this.keyParams = (LMSKeyParameters) ZeusTransformUtils.preCheckCast(PrivateKeyFactory.createKey(r3), LMSKeyParameters.class, "com.obric.memorydata.plugin");
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        init(PrivateKeyInfo.getInstance((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, BCLMSPrivateKey.class) == false) goto L13;
        BCLMSPrivateKey r4 = (BCLMSPrivateKey) ZeusTransformUtils.preCheckCast(r3, BCLMSPrivateKey.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.keyParams.getEncoded(), r4.keyParams.getEncoded());
    L12:
        throw new IllegalStateException("unable to perform equals");
    L13:
        return false;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey
    public LMSPrivateKey extractKeyShard(int r4) {
        if (ZeusTransformUtils.instanceOf(this.keyParams, LMSPrivateKeyParameters.class) == false) goto L7;
        return new BCLMSPrivateKey(((LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(this.keyParams, LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin")).extractKeyShard(r4));
    L7:
        return new BCLMSPrivateKey(((HSSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(this.keyParams, HSSPrivateKeyParameters.class, "com.obric.memorydata.plugin")).extractKeyShard(r4));
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "LMS";
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

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey
    public long getIndex() {
        if (getUsagesRemaining() == 0) goto L11;
        boolean r0 = ZeusTransformUtils.instanceOf(this.keyParams, LMSPrivateKeyParameters.class);
        LMSKeyParameters r4 = this.keyParams;
        if (r0 == false) goto L9;
        return ((LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r4, LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getIndex();
    L9:
        return ((HSSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r4, HSSPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getIndex();
    L11:
        throw new IllegalStateException("key exhausted");
    }

    CipherParameters getKeyParams() {
        return this.keyParams;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSKey
    public int getLevels() {
        if (ZeusTransformUtils.instanceOf(this.keyParams, LMSPrivateKeyParameters.class) == false) goto L7;
        return 1;
    L7:
        return ((HSSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(this.keyParams, HSSPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getL();
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey
    public long getUsagesRemaining() {
        boolean r0 = ZeusTransformUtils.instanceOf(this.keyParams, LMSPrivateKeyParameters.class);
        LMSKeyParameters r2 = this.keyParams;
        if (r0 == false) goto L7;
        return ((LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r2, LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getUsagesRemaining();
    L7:
        return ((HSSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r2, HSSPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getUsagesRemaining();
    }

    public int hashCode() {
        return Arrays.hashCode(this.keyParams.getEncoded());
    L5:
        throw new IllegalStateException("unable to calculate hashCode");
    }
}
