package org.bouncycastle.jcajce.provider.asymmetric.edec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.params.Ed448PublicKeyParameters;
import org.bouncycastle.jcajce.interfaces.EdDSAPublicKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCEdDSAPublicKey implements EdDSAPublicKey {
    static final long serialVersionUID = 1;
    transient AsymmetricKeyParameter eddsaPublicKey;

    BCEdDSAPublicKey(SubjectPublicKeyInfo r1) {
        populateFromPubKeyInfo(r1);
    }

    BCEdDSAPublicKey(AsymmetricKeyParameter r1) {
        this.eddsaPublicKey = r1;
    }

    BCEdDSAPublicKey(byte[] r4, byte[] r5) {
        int r0 = r4.length;
        if (Utils.isValidPrefix(r4, r5) == false) goto L15;
        if ((r5.length - r0) != 57) goto L9;
        AsymmetricKeyParameter r6 = new Ed448PublicKeyParameters(r5, r0);
    L7:
        this.eddsaPublicKey = r6;
        return;
    L9:
        if ((r5.length - r0) != 32) goto L13;
        r6 = new Ed25519PublicKeyParameters(r5, r0);
        goto L7
    L13:
        throw new InvalidKeySpecException("raw key data not recognised");
    L15:
        throw new InvalidKeySpecException("raw key data not recognised");
    }

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo r3) {
        byte[] r0 = r3.getPublicKeyData().getOctets();
        if (EdECObjectIdentifiers.id_Ed448.equals(r3.getAlgorithm().getAlgorithm()) == false) goto L5;
        AsymmetricKeyParameter r4 = new Ed448PublicKeyParameters(r0);
    L6:
        this.eddsaPublicKey = r4;
        return;
    L5:
        r4 = new Ed25519PublicKeyParameters(r0);
        goto L6
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3.readObject(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(getEncoded());
    }

    AsymmetricKeyParameter engineGetKeyParameters() {
        return this.eddsaPublicKey;
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, PublicKey.class) == true) goto L10;
        return false;
    L10:
        return Arrays.areEqual(((PublicKey) ZeusTransformUtils.preCheckCast(r3, PublicKey.class, "com.obric.memorydata.plugin")).getEncoded(), getEncoded());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        if (ZeusTransformUtils.instanceOf(this.eddsaPublicKey, Ed448PublicKeyParameters.class) == false) goto L5;
        return "Ed448";
    L5:
        return "Ed25519";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (ZeusTransformUtils.instanceOf(this.eddsaPublicKey, Ed448PublicKeyParameters.class) == false) goto L6;
        byte[] r0 = new byte[KeyFactorySpi.Ed448Prefix.length + 57];
        System.arraycopy(KeyFactorySpi.Ed448Prefix, 0, r0, 0, KeyFactorySpi.Ed448Prefix.length);
        ((Ed448PublicKeyParameters) ZeusTransformUtils.preCheckCast(this.eddsaPublicKey, Ed448PublicKeyParameters.class, "com.obric.memorydata.plugin")).encode(r0, KeyFactorySpi.Ed448Prefix.length);
        return r0;
    L6:
        byte[] r1 = new byte[KeyFactorySpi.Ed25519Prefix.length + 32];
        System.arraycopy(KeyFactorySpi.Ed25519Prefix, 0, r1, 0, KeyFactorySpi.Ed25519Prefix.length);
        ((Ed25519PublicKeyParameters) ZeusTransformUtils.preCheckCast(this.eddsaPublicKey, Ed25519PublicKeyParameters.class, "com.obric.memorydata.plugin")).encode(r1, KeyFactorySpi.Ed25519Prefix.length);
        return r1;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.jcajce.interfaces.EdDSAPublicKey
    public byte[] getPointEncoding() {
        boolean r0 = ZeusTransformUtils.instanceOf(this.eddsaPublicKey, Ed448PublicKeyParameters.class);
        AsymmetricKeyParameter r2 = this.eddsaPublicKey;
        if (r0 == false) goto L7;
        return ((Ed448PublicKeyParameters) ZeusTransformUtils.preCheckCast(r2, Ed448PublicKeyParameters.class, "com.obric.memorydata.plugin")).getEncoded();
    L7:
        return ((Ed25519PublicKeyParameters) ZeusTransformUtils.preCheckCast(r2, Ed25519PublicKeyParameters.class, "com.obric.memorydata.plugin")).getEncoded();
    }

    public int hashCode() {
        return Arrays.hashCode(getEncoded());
    }

    public String toString() {
        return Utils.keyToString("Public Key", getAlgorithm(), this.eddsaPublicKey);
    }
}
