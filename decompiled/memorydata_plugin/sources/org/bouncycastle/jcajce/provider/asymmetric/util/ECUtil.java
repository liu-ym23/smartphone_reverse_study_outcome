package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Fingerprint;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class ECUtil {
    static int[] convertMidTerms(int[] r6) {
        int[] r1 = new int[3];
        if (r6.length != 1) goto L6;
        r1[0] = r6[0];
    L25:
        return r1;
    L6:
        if (r6.length != 3) goto L27;
        if (r6[0] >= r6[1]) goto L16;
        if (r6[0] >= r6[2]) goto L16;
        r1[0] = r6[0];
        if (r6[1] >= r6[2]) goto L14;
        r1[1] = r6[1];
        r1[2] = r6[2];
        goto L25
    L14:
        r1[1] = r6[2];
        r1[2] = r6[1];
    L16:
        if (r6[1] >= r6[2]) goto L21;
        r1[0] = r6[1];
        if (r6[0] >= r6[2]) goto L20;
        r1[1] = r6[0];
        r1[2] = r6[2];
        goto L25
    L20:
        r1[1] = r6[2];
        r1[2] = r6[0];
        goto L25
    L21:
        r1[0] = r6[2];
        if (r6[0] >= r6[1]) goto L24;
        r1[1] = r6[0];
        r1[2] = r6[1];
        goto L25
    L24:
        r1[1] = r6[1];
        r1[2] = r6[0];
        goto L25
    L27:
        throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
    }

    public static String generateKeyFingerprint(ECPoint r4, ECParameterSpec r5) {
        ECCurve r0 = r5.getCurve();
        ECPoint r6 = r5.getG();
        if (r0 == null) goto L7;
        return new Fingerprint(Arrays.concatenate(r4.getEncoded(false), r0.getA().getEncoded(), r0.getB().getEncoded(), r6.getEncoded(false))).toString();
    L7:
        return new Fingerprint(r4.getEncoded(false)).toString();
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey r11) {
        PrivateKey r12 = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r11, PrivateKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, ECPrivateKey.class) == false) goto L14;
        ECPrivateKey r13 = (ECPrivateKey) ZeusTransformUtils.preCheckCast(r12, ECPrivateKey.class, "com.obric.memorydata.plugin");
        ECParameterSpec r0 = r13.getParameters();
        if (r0 != null) goto L8;
        r0 = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    L8:
        if (ZeusTransformUtils.instanceOf(r13.getParameters(), ECNamedCurveParameterSpec.class) == false) goto L12;
        return new ECPrivateKeyParameters(r13.getD(), new ECNamedDomainParameters(ECNamedCurveTable.getOID(((ECNamedCurveParameterSpec) ZeusTransformUtils.preCheckCast(r13.getParameters(), ECNamedCurveParameterSpec.class, "com.obric.memorydata.plugin")).getName()), r0.getCurve(), r0.getG(), r0.getN(), r0.getH(), r0.getSeed()));
    L12:
        return new ECPrivateKeyParameters(r13.getD(), new ECDomainParameters(r0.getCurve(), r0.getG(), r0.getN(), r0.getH(), r0.getSeed()));
    L14:
        if (ZeusTransformUtils.instanceOf(r12, java.security.interfaces.ECPrivateKey.class) == false) goto L30;
        java.security.interfaces.ECPrivateKey r14 = (java.security.interfaces.ECPrivateKey) ZeusTransformUtils.preCheckCast(r12, java.security.interfaces.ECPrivateKey.class, "com.obric.memorydata.plugin");
        ECParameterSpec r1 = EC5Util.convertSpec(r14.getParams());
        return new ECPrivateKeyParameters(r14.getS(), new ECDomainParameters(r1.getCurve(), r1.getG(), r1.getN(), r1.getH(), r1.getSeed()));
    L30:
        byte[] r15 = r12.getEncoded();     // Catch: Exception -> L27
        if (r15 == null) goto L26;
        PrivateKey r16 = BouncyCastleProvider.getPrivateKey(PrivateKeyInfo.getInstance(r15));     // Catch: Exception -> L27
        if (ZeusTransformUtils.instanceOf(r16, java.security.interfaces.ECPrivateKey.class) == false) goto L24;
        return generatePrivateKeyParameter(r16);
    L24:
        throw new InvalidKeyException("can't identify EC private key.");
    L26:
        throw new InvalidKeyException("no encoding for EC private key");     // Catch: Exception -> L27
    L27:
        e = move-exception;
        throw new InvalidKeyException("cannot identify EC private key: " + e.toString());
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r9) {
        PublicKey r10 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r9, PublicKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, ECPublicKey.class) == false) goto L7;
        ECPublicKey r11 = (ECPublicKey) ZeusTransformUtils.preCheckCast(r10, ECPublicKey.class, "com.obric.memorydata.plugin");
        ECParameterSpec r0 = r11.getParameters();
        return new ECPublicKeyParameters(r11.getQ(), new ECDomainParameters(r0.getCurve(), r0.getG(), r0.getN(), r0.getH(), r0.getSeed()));
    L7:
        if (ZeusTransformUtils.instanceOf(r10, java.security.interfaces.ECPublicKey.class) == false) goto L23;
        java.security.interfaces.ECPublicKey r12 = (java.security.interfaces.ECPublicKey) ZeusTransformUtils.preCheckCast(r10, java.security.interfaces.ECPublicKey.class, "com.obric.memorydata.plugin");
        ECParameterSpec r1 = EC5Util.convertSpec(r12.getParams());
        return new ECPublicKeyParameters(EC5Util.convertPoint(r12.getParams(), r12.getW()), new ECDomainParameters(r1.getCurve(), r1.getG(), r1.getN(), r1.getH(), r1.getSeed()));
    L23:
        byte[] r13 = r10.getEncoded();     // Catch: Exception -> L20
        if (r13 == null) goto L19;
        PublicKey r14 = BouncyCastleProvider.getPublicKey(SubjectPublicKeyInfo.getInstance(r13));     // Catch: Exception -> L20
        if (ZeusTransformUtils.instanceOf(r14, java.security.interfaces.ECPublicKey.class) == false) goto L17;
        return generatePublicKeyParameter(r14);
    L17:
        throw new InvalidKeyException("cannot identify EC public key.");
    L19:
        throw new InvalidKeyException("no encoding for EC public key");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        throw new InvalidKeyException("cannot identify EC public key: " + e.toString());
    }

    public static String getCurveName(ASN1ObjectIdentifier r0) {
        return ECNamedCurveTable.getName(r0);
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration r6, X962Parameters r7) {
        ProviderConfiguration r8 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r6, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        if (r7.isNamedCurve() == false) goto L9;
        ASN1ObjectIdentifier r9 = ASN1ObjectIdentifier.getInstance(r7.getParameters());
        X9ECParameters r0 = getNamedCurveByOid(r9);
        if (r0 != null) goto L14;
        r0 = (X9ECParameters) ZeusTransformUtils.preCheckCast(r8.getAdditionalECParameters().get(r9), X9ECParameters.class, "com.obric.memorydata.plugin");
    L14:
        return new ECNamedDomainParameters(r9, r0);
    L9:
        if (r7.isImplicitlyCA() == false) goto L11;
        ECParameterSpec r10 = r8.getEcImplicitlyCa();
        ECDomainParameters r11 = new ECDomainParameters(r10.getCurve(), r10.getG(), r10.getN(), r10.getH(), r10.getSeed());
    L13:
        return r11;
    L11:
        X9ECParameters r12 = X9ECParameters.getInstance(r7.getParameters());
        r11 = new ECDomainParameters(r12.getCurve(), r12.getG(), r12.getN(), r12.getH(), r12.getSeed());
        goto L13
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration r12, ECParameterSpec r13) {
        ProviderConfiguration r14 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r12, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ECNamedCurveParameterSpec.class) == false) goto L5;
        ECNamedCurveParameterSpec r15 = (ECNamedCurveParameterSpec) ZeusTransformUtils.preCheckCast(r13, ECNamedCurveParameterSpec.class, "com.obric.memorydata.plugin");
        return new ECNamedDomainParameters(getNamedCurveOid(r15.getName()), r15.getCurve(), r15.getG(), r15.getN(), r15.getH(), r15.getSeed());
    L5:
        if (r13 != null) goto L8;
        ECParameterSpec r16 = r14.getEcImplicitlyCa();
        return new ECDomainParameters(r16.getCurve(), r16.getG(), r16.getN(), r16.getH(), r16.getSeed());
    L8:
        return new ECDomainParameters(r13.getCurve(), r13.getG(), r13.getN(), r13.getH(), r13.getSeed());
    }

    public static X9ECParameters getNamedCurveByOid(ASN1ObjectIdentifier r1) {
        X9ECParameters r0 = CustomNamedCurves.getByOID(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ECNamedCurveTable.getByOID(r1);
    }

    public static ASN1ObjectIdentifier getNamedCurveOid(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.length() < 1) goto L16;
        int r0 = r2.indexOf(32);
        if (r0 <= 0) goto L9;
        r2 = r2.substring(r0 + 1);
    L9:
        ASN1ObjectIdentifier r1 = getOID(r2);
        if (r1 == null) goto L13;
        return r1;
    L13:
        return ECNamedCurveTable.getOID(r2);
    L16:
        return null;
    }

    private static ASN1ObjectIdentifier getOID(String r2) {
        char r0 = r2.charAt(0);
        if (r0 >= '0') goto L5;
        return null;
    L5:
        if (r0 > '2') goto L13;
        return new ASN1ObjectIdentifier(r2);
    L14:
        return null;
    L13:
        return null;
    }

    public static int getOrderBitLength(ProviderConfiguration r2, BigInteger r3, BigInteger r4) {
        ProviderConfiguration r5 = (ProviderConfiguration) ZeusTransformUtils.wrapperContextForParams(r2, ProviderConfiguration.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L11;
        ECParameterSpec r6 = r5.getEcImplicitlyCa();
        if (r6 != null) goto L9;
        return r4.bitLength();
    L9:
        return r6.getN().bitLength();
    L11:
        return r3.bitLength();
    }

    public static String privateKeyToString(String r4, BigInteger r5, ECParameterSpec r6) {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        ECPoint r7 = new FixedPointCombMultiplier().multiply(r6.getG(), r5).normalize();
        r0.append(r4);
        r0.append(" Private Key [").append(generateKeyFingerprint(r7, r6)).append("]").append(r1);
        r0.append("            X: ").append(r7.getAffineXCoord().toBigInteger().toString(16)).append(r1);
        r0.append("            Y: ").append(r7.getAffineYCoord().toBigInteger().toString(16)).append(r1);
        return r0.toString();
    }

    public static String publicKeyToString(String r3, ECPoint r4, ECParameterSpec r5) {
        StringBuffer r0 = new StringBuffer();
        String r1 = Strings.lineSeparator();
        r0.append(r3);
        r0.append(" Public Key [").append(generateKeyFingerprint(r4, r5)).append("]").append(r1);
        r0.append("            X: ").append(r4.getAffineXCoord().toBigInteger().toString(16)).append(r1);
        r0.append("            Y: ").append(r4.getAffineYCoord().toBigInteger().toString(16)).append(r1);
        return r0.toString();
    }
}
