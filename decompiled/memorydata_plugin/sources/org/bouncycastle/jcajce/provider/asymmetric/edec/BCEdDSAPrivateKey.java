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
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed448PrivateKeyParameters;
import org.bouncycastle.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.jcajce.interfaces.EdDSAPrivateKey;
import org.bouncycastle.jcajce.interfaces.EdDSAPublicKey;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes7.dex */
public class BCEdDSAPrivateKey implements EdDSAPrivateKey {
    static final long serialVersionUID = 1;
    private final byte[] attributes;
    transient AsymmetricKeyParameter eddsaPrivateKey;
    private final boolean hasPublicKey;

    BCEdDSAPrivateKey(PrivateKeyInfo r2) {
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

    BCEdDSAPrivateKey(AsymmetricKeyParameter r2) {
        this.hasPublicKey = true;
        this.attributes = null;
        this.eddsaPrivateKey = r2;
    }

    private void populateFromPrivateKeyInfo(PrivateKeyInfo r3) {
        byte[] r0 = ASN1OctetString.getInstance(r3.parsePrivateKey()).getOctets();
        if (EdECObjectIdentifiers.id_Ed448.equals(r3.getPrivateKeyAlgorithm().getAlgorithm()) == false) goto L5;
        AsymmetricKeyParameter r4 = new Ed448PrivateKeyParameters(r0);
    L6:
        this.eddsaPrivateKey = r4;
        return;
    L5:
        r4 = new Ed25519PrivateKeyParameters(r0);
        goto L6
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
        return this.eddsaPrivateKey;
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
        if (ZeusTransformUtils.instanceOf(this.eddsaPrivateKey, Ed448PrivateKeyParameters.class) == false) goto L5;
        return "Ed448";
    L5:
        return "Ed25519";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        ASN1Set r0 = ASN1Set.getInstance(this.attributes);     // Catch: IOException -> L10
        PrivateKeyInfo r1 = PrivateKeyInfoFactory.createPrivateKeyInfo(this.eddsaPrivateKey, r0);     // Catch: IOException -> L10
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

    @Override // org.bouncycastle.jcajce.interfaces.EdDSAPrivateKey
    public EdDSAPublicKey getPublicKey() {
        if (ZeusTransformUtils.instanceOf(this.eddsaPrivateKey, Ed448PrivateKeyParameters.class) == false) goto L7;
        return new BCEdDSAPublicKey(((Ed448PrivateKeyParameters) ZeusTransformUtils.preCheckCast(this.eddsaPrivateKey, Ed448PrivateKeyParameters.class, "com.obric.memorydata.plugin")).generatePublicKey());
    L7:
        return new BCEdDSAPublicKey(((Ed25519PrivateKeyParameters) ZeusTransformUtils.preCheckCast(this.eddsaPrivateKey, Ed25519PrivateKeyParameters.class, "com.obric.memorydata.plugin")).generatePublicKey());
    }

    public int hashCode() {
        return Arrays.hashCode(getEncoded());
    }

    public String toString() {
        if (ZeusTransformUtils.instanceOf(this.eddsaPrivateKey, Ed448PrivateKeyParameters.class) == false) goto L5;
        AsymmetricKeyParameter r0 = ((Ed448PrivateKeyParameters) ZeusTransformUtils.preCheckCast(this.eddsaPrivateKey, Ed448PrivateKeyParameters.class, "com.obric.memorydata.plugin")).generatePublicKey();
    L7:
        return Utils.keyToString("Private Key", getAlgorithm(), r0);
    L5:
        r0 = ((Ed25519PrivateKeyParameters) ZeusTransformUtils.preCheckCast(this.eddsaPrivateKey, Ed25519PrivateKeyParameters.class, "com.obric.memorydata.plugin")).generatePublicKey();
        goto L7
    }
}
