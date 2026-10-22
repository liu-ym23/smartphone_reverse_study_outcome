package org.bouncycastle.pqc.jcajce.provider.dilithium;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.pqc.crypto.crystals.dilithium.DilithiumPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.crystals.dilithium.DilithiumPublicKeyParameters;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.pqc.jcajce.interfaces.DilithiumPrivateKey;
import org.bouncycastle.pqc.jcajce.interfaces.DilithiumPublicKey;
import org.bouncycastle.pqc.jcajce.spec.DilithiumParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCDilithiumPrivateKey implements DilithiumPrivateKey {
    private static final long serialVersionUID = 1;
    private transient ASN1Set attributes;
    private transient DilithiumPrivateKeyParameters params;

    public BCDilithiumPrivateKey(PrivateKeyInfo r1) {
        init(r1);
    }

    public BCDilithiumPrivateKey(DilithiumPrivateKeyParameters r1) {
        this.params = r1;
    }

    private void init(PrivateKeyInfo r3) {
        this.attributes = r3.getAttributes();
        this.params = (DilithiumPrivateKeyParameters) ZeusTransformUtils.preCheckCast(PrivateKeyFactory.createKey(r3), DilithiumPrivateKeyParameters.class, "com.obric.memorydata.plugin");
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
        if (ZeusTransformUtils.instanceOf(r3, BCDilithiumPrivateKey.class) == false) goto L10;
        BCDilithiumPrivateKey r4 = (BCDilithiumPrivateKey) ZeusTransformUtils.preCheckCast(r3, BCDilithiumPrivateKey.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.params.getEncoded(), r4.params.getEncoded());
    L10:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Dilithium";
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

    DilithiumPrivateKeyParameters getKeyParams() {
        return this.params;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.DilithiumKey
    public DilithiumParameterSpec getParameterSpec() {
        return DilithiumParameterSpec.fromName(this.params.getParameters().getName());
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.DilithiumPrivateKey
    public DilithiumPublicKey getPublicKey() {
        return new BCDilithiumPublicKey(new DilithiumPublicKeyParameters(this.params.getParameters(), this.params.getRho(), this.params.getT1()));
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getEncoded());
    }
}
