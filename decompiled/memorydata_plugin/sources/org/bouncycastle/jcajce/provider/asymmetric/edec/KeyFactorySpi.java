package org.bouncycastle.jcajce.provider.asymmetric.edec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.params.Ed448PublicKeyParameters;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.crypto.params.X448PublicKeyParameters;
import org.bouncycastle.crypto.util.OpenSSHPrivateKeyUtil;
import org.bouncycastle.crypto.util.OpenSSHPublicKeyUtil;
import org.bouncycastle.jcajce.interfaces.EdDSAPublicKey;
import org.bouncycastle.jcajce.interfaces.XDHPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.spec.OpenSSHPrivateKeySpec;
import org.bouncycastle.jcajce.spec.OpenSSHPublicKeySpec;
import org.bouncycastle.jcajce.spec.RawEncodedKeySpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi {
    static final byte[] Ed25519Prefix = null;
    static final byte[] Ed448Prefix = null;
    static final byte[] x25519Prefix = null;
    static final byte[] x448Prefix = null;
    private final boolean isXdh;
    private final int specificBase;

    static {
        x448Prefix = Hex.decode("3042300506032b656f033900");
        x25519Prefix = Hex.decode("302a300506032b656e032100");
        Ed448Prefix = Hex.decode("3043300506032b6571033a00");
        Ed25519Prefix = Hex.decode("302a300506032b6570032100");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r3) {
        KeySpec r4 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r3, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, OpenSSHPrivateKeySpec.class) == false) goto L11;
        AsymmetricKeyParameter r2 = OpenSSHPrivateKeyUtil.parsePrivateKeyBlob(((OpenSSHPrivateKeySpec) ZeusTransformUtils.preCheckCast(r4, OpenSSHPrivateKeySpec.class, "com.obric.memorydata.plugin")).getEncoded());
        if (ZeusTransformUtils.instanceOf(r2, Ed25519PrivateKeyParameters.class) == false) goto L9;
        return new BCEdDSAPrivateKey((Ed25519PrivateKeyParameters) ZeusTransformUtils.preCheckCast(r2, Ed25519PrivateKeyParameters.class, "com.obric.memorydata.plugin"));
    L9:
        throw new IllegalStateException("openssh private key not Ed25519 private key");
    L11:
        return super.engineGeneratePrivate(r4);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r6) {
        KeySpec r7 = (KeySpec) ZeusTransformUtils.wrapperContextForParams(r6, KeySpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, X509EncodedKeySpec.class) == false) goto L31;
        byte[] r0 = ((X509EncodedKeySpec) ZeusTransformUtils.preCheckCast(r7, X509EncodedKeySpec.class, "com.obric.memorydata.plugin")).getEncoded();
        int r1 = this.specificBase;
        if (r1 == 0) goto L9;
        if (r1 == r0[8]) goto L9;
    L53:
        return super.engineGeneratePublic(r7);
    L9:
        if (r0[9] != 5) goto L19;
        if (r0[10] != 0) goto L19;
        SubjectPublicKeyInfo r2 = SubjectPublicKeyInfo.getInstance(r0);
        r0 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(r2.getAlgorithm().getAlgorithm()), r2.getPublicKeyData().getBytes()).getEncoded("DER");     // Catch: IOException -> L15
    L15:
        e = move-exception;
        throw new InvalidKeySpecException("attempt to reconstruct key failed: " + e.getMessage());
    L19:
        switch(r0[8]) {
            case 110: goto L29;
            case 111: goto L27;
            case 112: goto L25;
            case 113: goto L23;
            default: goto L21;
        };
    L21:
        return super.engineGeneratePublic(r7);
    L23:
        return new BCEdDSAPublicKey(Ed448Prefix, r0);
    L25:
        return new BCEdDSAPublicKey(Ed25519Prefix, r0);
    L27:
        return new BCXDHPublicKey(x448Prefix, r0);
    L29:
        return new BCXDHPublicKey(x25519Prefix, r0);
    L31:
        if (ZeusTransformUtils.instanceOf(r7, RawEncodedKeySpec.class) == false) goto L45;
        byte[] r8 = ((RawEncodedKeySpec) ZeusTransformUtils.preCheckCast(r7, RawEncodedKeySpec.class, "com.obric.memorydata.plugin")).getEncoded();
        switch(this.specificBase) {
            case 110: goto L43;
            case 111: goto L41;
            case 112: goto L39;
            case 113: goto L37;
            default: goto L35;
        };
    L35:
        throw new InvalidKeySpecException("factory not a specific type, cannot recognise raw encoding");
    L37:
        return new BCEdDSAPublicKey(new Ed448PublicKeyParameters(r8));
    L39:
        return new BCEdDSAPublicKey(new Ed25519PublicKeyParameters(r8));
    L41:
        return new BCXDHPublicKey(new X448PublicKeyParameters(r8));
    L43:
        return new BCXDHPublicKey(new X25519PublicKeyParameters(r8));
    L45:
        if (ZeusTransformUtils.instanceOf(r7, OpenSSHPublicKeySpec.class) == false) goto L53;
        AsymmetricKeyParameter r5 = OpenSSHPublicKeyUtil.parsePublicKey(((OpenSSHPublicKeySpec) ZeusTransformUtils.preCheckCast(r7, OpenSSHPublicKeySpec.class, "com.obric.memorydata.plugin")).getEncoded());
        if (ZeusTransformUtils.instanceOf(r5, Ed25519PublicKeyParameters.class) == false) goto L51;
        return new BCEdDSAPublicKey(new byte[0], ((Ed25519PublicKeyParameters) ZeusTransformUtils.preCheckCast(r5, Ed25519PublicKeyParameters.class, "com.obric.memorydata.plugin")).getEncoded());
    L51:
        throw new IllegalStateException("openssh public key not Ed25519 public key");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key r9, Class r10) {
        Key r11 = (Key) ZeusTransformUtils.wrapperContextForParams(r9, Key.class, "com.obric.memorydata.plugin");
        if (r10.isAssignableFrom(OpenSSHPrivateKeySpec.class) == false) goto L12;
        if (ZeusTransformUtils.instanceOf(r11, BCEdDSAPrivateKey.class) == false) goto L12;
        return new OpenSSHPrivateKeySpec(OpenSSHPrivateKeyUtil.encodePrivateKey(new Ed25519PrivateKeyParameters(ASN1OctetString.getInstance(ASN1Primitive.fromByteArray(ASN1OctetString.getInstance(ASN1Sequence.getInstance(r11.getEncoded()).getObjectAt(2)).getOctets())).getOctets())));
    L8:
        e = move-exception;
        throw new InvalidKeySpecException(e.getMessage(), e.getCause());
    L12:
        if (r10.isAssignableFrom(OpenSSHPublicKeySpec.class) == false) goto L25;
        if (ZeusTransformUtils.instanceOf(r11, BCEdDSAPublicKey.class) == false) goto L25;
        byte[] r8 = r11.getEncoded();     // Catch: IOException -> L21
        byte[] r12 = Ed25519Prefix;     // Catch: IOException -> L21
        if (Arrays.areEqual(r12, 0, r12.length, r8, 0, r8.length - 32) == false) goto L20;
        return new OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new Ed25519PublicKeyParameters(r8, r12.length)));
    L20:
        throw new InvalidKeySpecException("Invalid Ed25519 public key encoding");     // Catch: IOException -> L21
    L21:
        e = move-exception;
        throw new InvalidKeySpecException(e.getMessage(), e.getCause());
    L25:
        if (r10.isAssignableFrom(RawEncodedKeySpec.class) == false) goto L35;
        if (ZeusTransformUtils.instanceOf(r11, XDHPublicKey.class) == false) goto L31;
        return new RawEncodedKeySpec(((XDHPublicKey) ZeusTransformUtils.preCheckCast(r11, XDHPublicKey.class, "com.obric.memorydata.plugin")).getUEncoding());
    L31:
        if (ZeusTransformUtils.instanceOf(r11, EdDSAPublicKey.class) == false) goto L35;
        return new RawEncodedKeySpec(((EdDSAPublicKey) ZeusTransformUtils.preCheckCast(r11, EdDSAPublicKey.class, "com.obric.memorydata.plugin")).getPointEncoding());
    L35:
        return super.engineGetKeySpec(r11, r10);
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key r2) {
        Key r1 = (Key) ZeusTransformUtils.wrapperContextForParams(r2, Key.class, "com.obric.memorydata.plugin");
        throw new InvalidKeyException("key type unknown");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r4) {
        ASN1ObjectIdentifier r0 = r4.getPrivateKeyAlgorithm().getAlgorithm();
        if (this.isXdh == false) goto L21;
        int r1 = this.specificBase;
        if (r1 == 0) goto L9;
        if (r1 == 111) goto L9;
    L12:
        int r3 = this.specificBase;
        if (r3 == 0) goto L17;
        if (r3 == 110) goto L17;
    L41:
        throw new IOException("algorithm identifier " + r0 + " in key not recognized");
    L17:
        if (r0.equals(EdECObjectIdentifiers.id_X25519) == false) goto L41;
        return new BCXDHPrivateKey(r4);
    L9:
        if (r0.equals(EdECObjectIdentifiers.id_X448) == false) goto L12;
        return new BCXDHPrivateKey(r4);
    L21:
        if (r0.equals(EdECObjectIdentifiers.id_Ed448) == false) goto L23;
    L24:
        int r2 = this.specificBase;
        if (r2 == 0) goto L29;
        if (r2 == 113) goto L29;
    L32:
        int r5 = this.specificBase;
        if (r5 == 0) goto L37;
        if (r5 != 112) goto L41;
    L37:
        if (r0.equals(EdECObjectIdentifiers.id_Ed25519) == false) goto L41;
        return new BCEdDSAPrivateKey(r4);
    L29:
        if (r0.equals(EdECObjectIdentifiers.id_Ed448) == false) goto L32;
        return new BCEdDSAPrivateKey(r4);
    L23:
        if (r0.equals(EdECObjectIdentifiers.id_Ed25519) == false) goto L41;
        goto L24
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r4) {
        ASN1ObjectIdentifier r0 = r4.getAlgorithm().getAlgorithm();
        if (this.isXdh == false) goto L21;
        int r1 = this.specificBase;
        if (r1 == 0) goto L9;
        if (r1 == 111) goto L9;
    L12:
        int r3 = this.specificBase;
        if (r3 == 0) goto L17;
        if (r3 == 110) goto L17;
    L41:
        throw new IOException("algorithm identifier " + r0 + " in key not recognized");
    L17:
        if (r0.equals(EdECObjectIdentifiers.id_X25519) == false) goto L41;
        return new BCXDHPublicKey(r4);
    L9:
        if (r0.equals(EdECObjectIdentifiers.id_X448) == false) goto L12;
        return new BCXDHPublicKey(r4);
    L21:
        if (r0.equals(EdECObjectIdentifiers.id_Ed448) == false) goto L23;
    L24:
        int r2 = this.specificBase;
        if (r2 == 0) goto L29;
        if (r2 == 113) goto L29;
    L32:
        int r5 = this.specificBase;
        if (r5 == 0) goto L37;
        if (r5 != 112) goto L41;
    L37:
        if (r0.equals(EdECObjectIdentifiers.id_Ed25519) == false) goto L41;
        return new BCEdDSAPublicKey(r4);
    L29:
        if (r0.equals(EdECObjectIdentifiers.id_Ed448) == false) goto L32;
        return new BCEdDSAPublicKey(r4);
    L23:
        if (r0.equals(EdECObjectIdentifiers.id_Ed25519) == false) goto L41;
        goto L24
    }
}
