package org.bouncycastle.jcajce.provider.asymmetric.edec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.X25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.X448PrivateKeyParameters;
import org.bouncycastle.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.jcajce.interfaces.XDHPrivateKey;
import org.bouncycastle.jcajce.interfaces.XDHPublicKey;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes7.dex */
public class BCXDHPrivateKey implements XDHPrivateKey {
    static final long serialVersionUID = 1;
    private final byte[] attributes;
    private final boolean hasPublicKey;
    transient AsymmetricKeyParameter xdhPrivateKey;

    BCXDHPrivateKey(PrivateKeyInfo r2) {
        this.hasPublicKey = r2.hasPublicKey();
        if (r2.getAttributes() == null) goto L5;
        byte[] r0 = r2.getAttributes().getEncoded();
    L6:
        this.attributes = r0;
        populateFromPrivateKeyInfo(r2);
        return;
    L5:
        r0 = null;
        goto L6
    }

    BCXDHPrivateKey(AsymmetricKeyParameter r2) {
        this.hasPublicKey = true;
        this.attributes = null;
        this.xdhPrivateKey = r2;
    }

    private void populateFromPrivateKeyInfo(PrivateKeyInfo r4) {
        byte[] r0 = r4.getPrivateKey().getOctets();
        if (r0.length == 32) goto L8;
        if (r0.length == 56) goto L8;
        r0 = ASN1OctetString.getInstance(r4.parsePrivateKey()).getOctets();
    L8:
        if (EdECObjectIdentifiers.id_X448.equals(r4.getPrivateKeyAlgorithm().getAlgorithm()) == false) goto L10;
        AsymmetricKeyParameter r5 = new X448PrivateKeyParameters(r0);
    L11:
        this.xdhPrivateKey = r5;
        return;
    L10:
        r5 = new X25519PrivateKeyParameters(r0);
        goto L11
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        populateFromPrivateKeyInfo(PrivateKeyInfo.getInstance((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    AsymmetricKeyParameter engineGetKeyParameters() {
        return this.xdhPrivateKey;
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, PrivateKey.class) == true) goto L10;
        return false;
    L10:
        return Arrays.areEqual(((PrivateKey) ZeusTransformUtils.preCheckCast(r3, PrivateKey.class, "com.obric.memorydata.plugin")).getEncoded(), getEncoded());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        if (ZeusTransformUtils.instanceOf(this.xdhPrivateKey, X448PrivateKeyParameters.class) == false) goto L5;
        return "X448";
    L5:
        return "X25519";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        ASN1Set r0 = ASN1Set.getInstance(this.attributes);     // Catch: IOException -> L10
        PrivateKeyInfo r1 = PrivateKeyInfoFactory.createPrivateKeyInfo(this.xdhPrivateKey, r0);     // Catch: IOException -> L10
        if (this.hasPublicKey == false) goto L9;
        if (Properties.isOverrideSet("org.bouncycastle.pkcs8.v1_info_only") == true) goto L9;
        return r1.getEncoded();
    L9:
        return new PrivateKeyInfo(r1.getPrivateKeyAlgorithm(), r1.parsePrivateKey(), r0).getEncoded();
    L10:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.jcajce.interfaces.XDHPrivateKey
    public XDHPublicKey getPublicKey() {
        if (ZeusTransformUtils.instanceOf(this.xdhPrivateKey, X448PrivateKeyParameters.class) == false) goto L7;
        return new BCXDHPublicKey(((X448PrivateKeyParameters) ZeusTransformUtils.preCheckCast(this.xdhPrivateKey, X448PrivateKeyParameters.class, "com.obric.memorydata.plugin")).generatePublicKey());
    L7:
        return new BCXDHPublicKey(((X25519PrivateKeyParameters) ZeusTransformUtils.preCheckCast(this.xdhPrivateKey, X25519PrivateKeyParameters.class, "com.obric.memorydata.plugin")).generatePublicKey());
    }

    public int hashCode() {
        return Arrays.hashCode(getEncoded());
    }

    public String toString() {
        if (ZeusTransformUtils.instanceOf(this.xdhPrivateKey, X448PrivateKeyParameters.class) == false) goto L5;
        AsymmetricKeyParameter r0 = ((X448PrivateKeyParameters) ZeusTransformUtils.preCheckCast(this.xdhPrivateKey, X448PrivateKeyParameters.class, "com.obric.memorydata.plugin")).generatePublicKey();
    L7:
        return Utils.keyToString("Private Key", getAlgorithm(), r0);
    L5:
        r0 = ((X25519PrivateKeyParameters) ZeusTransformUtils.preCheckCast(this.xdhPrivateKey, X25519PrivateKeyParameters.class, "com.obric.memorydata.plugin")).generatePublicKey();
        goto L7
    }
}
