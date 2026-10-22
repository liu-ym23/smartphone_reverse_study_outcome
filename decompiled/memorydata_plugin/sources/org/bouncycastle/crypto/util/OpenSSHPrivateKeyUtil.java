package org.bouncycastle.crypto.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.bouncycastle.asn1.sec.ECPrivateKey;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class OpenSSHPrivateKeyUtil {
    static final byte[] AUTH_MAGIC = null;

    static {
        AUTH_MAGIC = Strings.toByteArray("openssh-key-v1\u0000");
    }

    private static boolean allIntegers(ASN1Sequence r4) {
        int r1 = 0;
    L4:
        if (r1 >= r4.size()) goto L9;
        if (ZeusTransformUtils.instanceOf(r4.getObjectAt(r1), ASN1Integer.class) == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static byte[] encodePrivateKey(AsymmetricKeyParameter r6) {
        if (r6 == null) goto L26;
        if (ZeusTransformUtils.instanceOf(r6, RSAPrivateCrtKeyParameters.class) == false) goto L8;
        return PrivateKeyInfoFactory.createPrivateKeyInfo(r6).parsePrivateKey().toASN1Primitive().getEncoded();
    L8:
        if (ZeusTransformUtils.instanceOf(r6, ECPrivateKeyParameters.class) == false) goto L12;
        return PrivateKeyInfoFactory.createPrivateKeyInfo(r6).parsePrivateKey().toASN1Primitive().getEncoded();
    L12:
        if (ZeusTransformUtils.instanceOf(r6, DSAPrivateKeyParameters.class) == false) goto L20;
        DSAPrivateKeyParameters r7 = (DSAPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r6, DSAPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        DSAParameters r0 = r7.getParameters();
        ASN1EncodableVector r1 = new ASN1EncodableVector();
        r1.add(new ASN1Integer(0));
        r1.add(new ASN1Integer(r0.getP()));
        r1.add(new ASN1Integer(r0.getQ()));
        r1.add(new ASN1Integer(r0.getG()));
        r1.add(new ASN1Integer(r0.getG().modPow(r7.getX(), r0.getP())));
        r1.add(new ASN1Integer(r7.getX()));
        return new DERSequence(r1).getEncoded();
    L16:
        e = move-exception;
        throw new IllegalStateException("unable to encode DSAPrivateKeyParameters " + e.getMessage());
    L20:
        if (ZeusTransformUtils.instanceOf(r6, Ed25519PrivateKeyParameters.class) == false) goto L24;
        Ed25519PublicKeyParameters r2 = ((Ed25519PrivateKeyParameters) ZeusTransformUtils.preCheckCast(r6, Ed25519PrivateKeyParameters.class, "com.obric.memorydata.plugin")).generatePublicKey();
        SSHBuilder r3 = new SSHBuilder();
        r3.writeBytes(AUTH_MAGIC);
        r3.writeString("none");
        r3.writeString("none");
        r3.writeString("");
        r3.u32(1);
        r3.writeBlock(OpenSSHPublicKeyUtil.encodePublicKey(r2));
        SSHBuilder r4 = new SSHBuilder();
        int r5 = CryptoServicesRegistrar.getSecureRandom().nextInt();
        r4.u32(r5);
        r4.u32(r5);
        r4.writeString("ssh-ed25519");
        byte[] r8 = r2.getEncoded();
        r4.writeBlock(r8);
        r4.writeBlock(Arrays.concatenate(((Ed25519PrivateKeyParameters) ZeusTransformUtils.preCheckCast(r6, Ed25519PrivateKeyParameters.class, "com.obric.memorydata.plugin")).getEncoded(), r8));
        r4.writeString("");
        r3.writeBlock(r4.getPaddedBytes());
        return r3.getBytes();
    L24:
        throw new IllegalArgumentException("unable to convert " + r6.getClass().getName() + " to openssh private key");
    L26:
        throw new IllegalArgumentException("param is null");
    }

    public static AsymmetricKeyParameter parsePrivateKeyBlob(byte[] r13) {
        AsymmetricKeyParameter r3 = null;
        if (r13[0] != 48) goto L25;
        ASN1Sequence r14 = ASN1Sequence.getInstance(r13);
        if (r14.size() != 6) goto L12;
        if (allIntegers(r14) == true) goto L9;
    L56:
        if (r3 == null) goto L59;
        return r3;
    L59:
        throw new IllegalArgumentException("unable to parse key");
    L9:
        if (((ASN1Integer) ZeusTransformUtils.preCheckCast(r14.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin")).getPositiveValue().equals(BigIntegers.ZERO) == false) goto L56;
        r3 = new DSAPrivateKeyParameters(((ASN1Integer) ZeusTransformUtils.preCheckCast(r14.getObjectAt(5), ASN1Integer.class, "com.obric.memorydata.plugin")).getPositiveValue(), new DSAParameters(((ASN1Integer) ZeusTransformUtils.preCheckCast(r14.getObjectAt(1), ASN1Integer.class, "com.obric.memorydata.plugin")).getPositiveValue(), ((ASN1Integer) ZeusTransformUtils.preCheckCast(r14.getObjectAt(2), ASN1Integer.class, "com.obric.memorydata.plugin")).getPositiveValue(), ((ASN1Integer) ZeusTransformUtils.preCheckCast(r14.getObjectAt(3), ASN1Integer.class, "com.obric.memorydata.plugin")).getPositiveValue()));
        goto L56
    L12:
        if (r14.size() != 9) goto L19;
        if (allIntegers(r14) == false) goto L56;
        if (((ASN1Integer) ZeusTransformUtils.preCheckCast(r14.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin")).getPositiveValue().equals(BigIntegers.ZERO) == false) goto L56;
        RSAPrivateKey r15 = RSAPrivateKey.getInstance(r14);
        r3 = new RSAPrivateCrtKeyParameters(r15.getModulus(), r15.getPublicExponent(), r15.getPrivateExponent(), r15.getPrime1(), r15.getPrime2(), r15.getExponent1(), r15.getExponent2(), r15.getCoefficient());
        goto L56
    L19:
        if (r14.size() != 4) goto L56;
        if (ZeusTransformUtils.instanceOf(r14.getObjectAt(3), ASN1TaggedObject.class) == false) goto L56;
        if (ZeusTransformUtils.instanceOf(r14.getObjectAt(2), ASN1TaggedObject.class) == false) goto L56;
        ECPrivateKey r16 = ECPrivateKey.getInstance(r14);
        ASN1ObjectIdentifier r0 = ASN1ObjectIdentifier.getInstance(r16.getParametersObject());
        r3 = new ECPrivateKeyParameters(r16.getKey(), new ECNamedDomainParameters(r0, ECNamedCurveTable.getByOID(r0)));
        goto L56
    L25:
        SSHBuffer r1 = new SSHBuffer(AUTH_MAGIC, r13);
        if ("none".equals(r1.readString()) == false) goto L69;
        r1.skipBlock();
        r1.skipBlock();
        if (r1.readU32() != 1) goto L67;
        OpenSSHPublicKeyUtil.parsePublicKey(r1.readBlock());
        byte[] r17 = r1.readPaddedBlock();
        if (r1.hasRemaining() == true) goto L65;
        SSHBuffer r2 = new SSHBuffer(r17);
        if (r2.readU32() != r2.readU32()) goto L63;
        String r18 = r2.readString();
        if ("ssh-ed25519".equals(r18) == false) goto L41;
        r2.readBlock();
        byte[] r19 = r2.readBlock();
        if (r19.length != 64) goto L39;
        r3 = new Ed25519PrivateKeyParameters(r19, 0);
    L54:
        r2.skipBlock();
        if (r2.hasRemaining() == false) goto L56;
        throw new IllegalArgumentException("private key block has trailing data");
    L39:
        throw new IllegalStateException("private key value of wrong length");
    L41:
        if (r18.startsWith("ecdsa") == false) goto L52;
        ASN1ObjectIdentifier r4 = SSHNamedCurves.getByName(Strings.fromByteArray(r2.readBlock()));
        if (r4 == null) goto L50;
        X9ECParameters r110 = NISTNamedCurves.getByOID(r4);
        if (r110 == null) goto L48;
        r2.readBlock();
        r3 = new ECPrivateKeyParameters(new BigInteger(1, r2.readBlock()), new ECNamedDomainParameters(r4, r110));
        goto L54
    L48:
        throw new IllegalStateException("Curve not found for: " + r4);
    L50:
        throw new IllegalStateException("OID not found for: " + r18);
    L52:
        if (r18.startsWith("ssh-rsa") == false) goto L54;
        BigInteger r5 = new BigInteger(1, r2.readBlock());
        BigInteger r6 = new BigInteger(1, r2.readBlock());
        BigInteger r7 = new BigInteger(1, r2.readBlock());
        BigInteger r12 = new BigInteger(1, r2.readBlock());
        BigInteger r8 = new BigInteger(1, r2.readBlock());
        BigInteger r9 = new BigInteger(1, r2.readBlock());
        r3 = new RSAPrivateCrtKeyParameters(r5, r6, r7, r8, r9, r7.remainder(r8.subtract(BigIntegers.ONE)), r7.remainder(r9.subtract(BigIntegers.ONE)), r12);
        goto L54
    L63:
        throw new IllegalStateException("private key check values are not the same");
    L65:
        throw new IllegalArgumentException("decoded key has trailing data");
    L67:
        throw new IllegalStateException("multiple keys not supported");
    L69:
        throw new IllegalStateException("encrypted keys not supported");
    }
}
