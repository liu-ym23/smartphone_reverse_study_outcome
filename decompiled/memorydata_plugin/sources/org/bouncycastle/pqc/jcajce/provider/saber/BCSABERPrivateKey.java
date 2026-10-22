package org.bouncycastle.pqc.jcajce.provider.saber;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.pqc.crypto.saber.SABERPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.pqc.jcajce.interfaces.SABERKey;
import org.bouncycastle.pqc.jcajce.spec.SABERParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCSABERPrivateKey implements PrivateKey, SABERKey {
    private static final long serialVersionUID = 1;
    private transient ASN1Set attributes;
    private transient SABERPrivateKeyParameters params;

    public BCSABERPrivateKey(PrivateKeyInfo r1) {
        init(r1);
    }

    public BCSABERPrivateKey(SABERPrivateKeyParameters r1) {
        this.params = r1;
    }

    private void init(PrivateKeyInfo r3) {
        this.attributes = r3.getAttributes();
        this.params = (SABERPrivateKeyParameters) ZeusTransformUtils.preCheckCast(PrivateKeyFactory.createKey(r3), SABERPrivateKeyParameters.class, "com.obric.memorydata.plugin");
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
        if (ZeusTransformUtils.instanceOf(r3, BCSABERPrivateKey.class) == false) goto L10;
        BCSABERPrivateKey r4 = (BCSABERPrivateKey) ZeusTransformUtils.preCheckCast(r3, BCSABERPrivateKey.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.params.getEncoded(), r4.params.getEncoded());
    L10:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SABER";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return PrivateKeyInfoFactory.createPrivateKeyInfo(this.params, this.attributes).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    SABERPrivateKeyParameters getKeyParams() {
        return this.params;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.SABERKey
    public SABERParameterSpec getParameterSpec() {
        return SABERParameterSpec.fromName(this.params.getParameters().getName());
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getEncoded());
    }
}
