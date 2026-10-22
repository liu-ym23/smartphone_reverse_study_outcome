package org.bouncycastle.jcajce.provider.asymmetric.edec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.crypto.params.X448PublicKeyParameters;
import org.bouncycastle.jcajce.interfaces.XDHPublicKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCXDHPublicKey implements XDHPublicKey {
    static final long serialVersionUID = 1;
    transient AsymmetricKeyParameter xdhPublicKey;

    BCXDHPublicKey(SubjectPublicKeyInfo r1) {
        populateFromPubKeyInfo(r1);
    }

    BCXDHPublicKey(AsymmetricKeyParameter r1) {
        this.xdhPublicKey = r1;
    }

    BCXDHPublicKey(byte[] r4, byte[] r5) {
        int r0 = r4.length;
        if (Utils.isValidPrefix(r4, r5) == false) goto L15;
        if ((r5.length - r0) != 56) goto L9;
        AsymmetricKeyParameter r6 = new X448PublicKeyParameters(r5, r0);
    L7:
        this.xdhPublicKey = r6;
        return;
    L9:
        if ((r5.length - r0) != 32) goto L13;
        r6 = new X25519PublicKeyParameters(r5, r0);
        goto L7
    L13:
        throw new InvalidKeySpecException("raw key data not recognised");
    L15:
        throw new InvalidKeySpecException("raw key data not recognised");
    }

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo r3) {
        byte[] r0 = r3.getPublicKeyData().getOctets();
        if (EdECObjectIdentifiers.id_X448.equals(r3.getAlgorithm().getAlgorithm()) == false) goto L5;
        AsymmetricKeyParameter r4 = new X448PublicKeyParameters(r0);
    L6:
        this.xdhPublicKey = r4;
        return;
    L5:
        r4 = new X25519PublicKeyParameters(r0);
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
        return this.xdhPublicKey;
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
        if (ZeusTransformUtils.instanceOf(this.xdhPublicKey, X448PublicKeyParameters.class) == false) goto L5;
        return "X448";
    L5:
        return "X25519";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (ZeusTransformUtils.instanceOf(this.xdhPublicKey, X448PublicKeyParameters.class) == false) goto L6;
        byte[] r0 = new byte[KeyFactorySpi.x448Prefix.length + 56];
        System.arraycopy(KeyFactorySpi.x448Prefix, 0, r0, 0, KeyFactorySpi.x448Prefix.length);
        ((X448PublicKeyParameters) ZeusTransformUtils.preCheckCast(this.xdhPublicKey, X448PublicKeyParameters.class, "com.obric.memorydata.plugin")).encode(r0, KeyFactorySpi.x448Prefix.length);
        return r0;
    L6:
        byte[] r1 = new byte[KeyFactorySpi.x25519Prefix.length + 32];
        System.arraycopy(KeyFactorySpi.x25519Prefix, 0, r1, 0, KeyFactorySpi.x25519Prefix.length);
        ((X25519PublicKeyParameters) ZeusTransformUtils.preCheckCast(this.xdhPublicKey, X25519PublicKeyParameters.class, "com.obric.memorydata.plugin")).encode(r1, KeyFactorySpi.x25519Prefix.length);
        return r1;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.jcajce.interfaces.XDHPublicKey
    public BigInteger getU() {
        byte[] r2 = getUEncoding();
        Arrays.reverseInPlace(r2);
        return new BigInteger(1, r2);
    }

    @Override // org.bouncycastle.jcajce.interfaces.XDHPublicKey
    public byte[] getUEncoding() {
        boolean r0 = ZeusTransformUtils.instanceOf(this.xdhPublicKey, X448PublicKeyParameters.class);
        AsymmetricKeyParameter r2 = this.xdhPublicKey;
        if (r0 == false) goto L7;
        return ((X448PublicKeyParameters) ZeusTransformUtils.preCheckCast(r2, X448PublicKeyParameters.class, "com.obric.memorydata.plugin")).getEncoded();
    L7:
        return ((X25519PublicKeyParameters) ZeusTransformUtils.preCheckCast(r2, X25519PublicKeyParameters.class, "com.obric.memorydata.plugin")).getEncoded();
    }

    public int hashCode() {
        return Arrays.hashCode(getEncoded());
    }

    public String toString() {
        return Utils.keyToString("Public Key", getAlgorithm(), this.xdhPublicKey);
    }
}
