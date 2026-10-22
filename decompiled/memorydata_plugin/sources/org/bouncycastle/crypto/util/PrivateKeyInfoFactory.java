package org.bouncycastle.crypto.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.sec.ECPrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECGOST3410Parameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed448PrivateKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.crypto.params.X25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.X448PrivateKeyParameters;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

/* JADX INFO: loaded from: classes7.dex */
public class PrivateKeyInfoFactory {
    private static Set cryptoProOids;

    static {
        HashSet r0 = new HashSet(5);
        cryptoProOids = r0;
        r0.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB);
    }

    public static PrivateKeyInfo createPrivateKeyInfo(AsymmetricKeyParameter r1) {
        return createPrivateKeyInfo(r1, null);
    }

    public static PrivateKeyInfo createPrivateKeyInfo(AsymmetricKeyParameter r14, ASN1Set r15) {
        if (ZeusTransformUtils.instanceOf(r14, RSAKeyParameters.class) == false) goto L7;
        RSAPrivateCrtKeyParameters r16 = (RSAPrivateCrtKeyParameters) ZeusTransformUtils.preCheckCast(r14, RSAPrivateCrtKeyParameters.class, "com.obric.memorydata.plugin");
        return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), new RSAPrivateKey(r16.getModulus(), r16.getPublicExponent(), r16.getExponent(), r16.getP(), r16.getQ(), r16.getDP(), r16.getDQ(), r16.getQInv()), r15);
    L7:
        if (ZeusTransformUtils.instanceOf(r14, DSAPrivateKeyParameters.class) == false) goto L11;
        DSAPrivateKeyParameters r17 = (DSAPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r14, DSAPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        DSAParameters r0 = r17.getParameters();
        return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(r0.getP(), r0.getQ(), r0.getG())), new ASN1Integer(r17.getX()), r15);
    L11:
        if (ZeusTransformUtils.instanceOf(r14, ECPrivateKeyParameters.class) == false) goto L40;
        ECPrivateKeyParameters r18 = (ECPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r14, ECPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        ECDomainParameters r1 = r18.getParameters();
        if (r1 != null) goto L16;
        X962Parameters r2 = new X962Parameters(DERNull.INSTANCE);
        int r3 = r18.getD().bitLength();
    L38:
        return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, r2), new ECPrivateKey(r3, r18.getD(), new DERBitString(new FixedPointCombMultiplier().multiply(r1.getG(), r18.getD()).getEncoded(false)), r2), r15);
    L16:
        if (ZeusTransformUtils.instanceOf(r1, ECGOST3410Parameters.class) == false) goto L33;
        GOST3410PublicKeyAlgParameters r19 = new GOST3410PublicKeyAlgParameters(((ECGOST3410Parameters) ZeusTransformUtils.preCheckCast(r1, ECGOST3410Parameters.class, "com.obric.memorydata.plugin")).getPublicKeyParamSet(), ((ECGOST3410Parameters) ZeusTransformUtils.preCheckCast(r1, ECGOST3410Parameters.class, "com.obric.memorydata.plugin")).getDigestParamSet(), ((ECGOST3410Parameters) ZeusTransformUtils.preCheckCast(r1, ECGOST3410Parameters.class, "com.obric.memorydata.plugin")).getEncryptionParamSet());
        int r4 = 32;
        if (cryptoProOids.contains(r19.getPublicKeyParamSet()) == false) goto L21;
        ASN1ObjectIdentifier r5 = CryptoProObjectIdentifiers.gostR3410_2001;
    L30:
        byte[] r6 = new byte[r4];
        extractBytes(r6, r4, 0, r18.getD());
        return new PrivateKeyInfo(new AlgorithmIdentifier(r5, r19), new DEROctetString(r6));
    L21:
        if (r18.getD().bitLength() <= 256) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
        ASN1ObjectIdentifier r8 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512;
    L27:
        if (r7 == false) goto L29;
        r4 = 64;
    L29:
        r5 = r8;
        goto L30
    L26:
        r8 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256;
        goto L27
    L23:
        r7 = false;
        goto L24
    L33:
        if (ZeusTransformUtils.instanceOf(r1, ECNamedDomainParameters.class) == false) goto L35;
        X962Parameters r9 = new X962Parameters(((ECNamedDomainParameters) ZeusTransformUtils.preCheckCast(r1, ECNamedDomainParameters.class, "com.obric.memorydata.plugin")).getName());
    L36:
        X962Parameters r13 = r9;
        r3 = r1.getN().bitLength();
        r2 = r13;
        goto L38
    L35:
        r9 = new X962Parameters(new X9ECParameters(r1.getCurve(), new X9ECPoint(r1.getG(), false), r1.getN(), r1.getH(), r1.getSeed()));
        goto L36
    L40:
        if (ZeusTransformUtils.instanceOf(r14, X448PrivateKeyParameters.class) == false) goto L44;
        X448PrivateKeyParameters r110 = (X448PrivateKeyParameters) ZeusTransformUtils.preCheckCast(r14, X448PrivateKeyParameters.class, "com.obric.memorydata.plugin");
        return new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_X448), new DEROctetString(r110.getEncoded()), r15, r110.generatePublicKey().getEncoded());
    L44:
        if (ZeusTransformUtils.instanceOf(r14, X25519PrivateKeyParameters.class) == false) goto L48;
        X25519PrivateKeyParameters r111 = (X25519PrivateKeyParameters) ZeusTransformUtils.preCheckCast(r14, X25519PrivateKeyParameters.class, "com.obric.memorydata.plugin");
        return new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_X25519), new DEROctetString(r111.getEncoded()), r15, r111.generatePublicKey().getEncoded());
    L48:
        if (ZeusTransformUtils.instanceOf(r14, Ed448PrivateKeyParameters.class) == false) goto L52;
        Ed448PrivateKeyParameters r112 = (Ed448PrivateKeyParameters) ZeusTransformUtils.preCheckCast(r14, Ed448PrivateKeyParameters.class, "com.obric.memorydata.plugin");
        return new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed448), new DEROctetString(r112.getEncoded()), r15, r112.generatePublicKey().getEncoded());
    L52:
        if (ZeusTransformUtils.instanceOf(r14, Ed25519PrivateKeyParameters.class) == false) goto L56;
        Ed25519PrivateKeyParameters r113 = (Ed25519PrivateKeyParameters) ZeusTransformUtils.preCheckCast(r14, Ed25519PrivateKeyParameters.class, "com.obric.memorydata.plugin");
        return new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519), new DEROctetString(r113.getEncoded()), r15, r113.generatePublicKey().getEncoded());
    L56:
        throw new IOException("key parameters not recognized");
    }

    private static void extractBytes(byte[] r4, int r5, int r6, BigInteger r7) {
        byte[] r8 = r7.toByteArray();
        int r1 = 0;
        if (r8.length >= r5) goto L5;
        byte[] r0 = new byte[r5];
        System.arraycopy(r8, 0, r0, r5 - r8.length, r8.length);
        r8 = r0;
    L5:
        if (r1 == r5) goto L7;
        r4[r6 + r1] = r8[(r8.length - 1) - r1];
        r1 = r1 + 1;
        goto L5
    }
}
