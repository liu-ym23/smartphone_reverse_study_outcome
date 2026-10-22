package org.bouncycastle.crypto.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;

/* JADX INFO: loaded from: classes7.dex */
public class OpenSSHPublicKeyUtil {
    public static byte[] encodePublicKey(AsymmetricKeyParameter r5) {
        if (r5 == null) goto L30;
        if (ZeusTransformUtils.instanceOf(r5, RSAKeyParameters.class) == false) goto L12;
        if (r5.isPrivate() == true) goto L10;
        RSAKeyParameters r6 = (RSAKeyParameters) ZeusTransformUtils.preCheckCast(r5, RSAKeyParameters.class, "com.obric.memorydata.plugin");
        SSHBuilder r0 = new SSHBuilder();
        r0.writeString("ssh-rsa");
        r0.writeBigNum(r6.getExponent());
        r0.writeBigNum(r6.getModulus());
        return r0.getBytes();
    L10:
        throw new IllegalArgumentException("RSAKeyParamaters was for encryption");
    L12:
        if (ZeusTransformUtils.instanceOf(r5, ECPublicKeyParameters.class) == false) goto L20;
        SSHBuilder r1 = new SSHBuilder();
        String r2 = SSHNamedCurves.getNameForParameters(((ECPublicKeyParameters) ZeusTransformUtils.preCheckCast(r5, ECPublicKeyParameters.class, "com.obric.memorydata.plugin")).getParameters());
        if (r2 == null) goto L18;
        r1.writeString("ecdsa-sha2-" + r2);
        r1.writeString(r2);
        r1.writeBlock(((ECPublicKeyParameters) ZeusTransformUtils.preCheckCast(r5, ECPublicKeyParameters.class, "com.obric.memorydata.plugin")).getQ().getEncoded(false));
        return r1.getBytes();
    L18:
        throw new IllegalArgumentException("unable to derive ssh curve name for " + ((ECPublicKeyParameters) ZeusTransformUtils.preCheckCast(r5, ECPublicKeyParameters.class, "com.obric.memorydata.plugin")).getParameters().getCurve().getClass().getName());
    L20:
        if (ZeusTransformUtils.instanceOf(r5, DSAPublicKeyParameters.class) == false) goto L24;
        DSAPublicKeyParameters r7 = (DSAPublicKeyParameters) ZeusTransformUtils.preCheckCast(r5, DSAPublicKeyParameters.class, "com.obric.memorydata.plugin");
        DSAParameters r3 = r7.getParameters();
        SSHBuilder r4 = new SSHBuilder();
        r4.writeString("ssh-dss");
        r4.writeBigNum(r3.getP());
        r4.writeBigNum(r3.getQ());
        r4.writeBigNum(r3.getG());
        r4.writeBigNum(r7.getY());
        return r4.getBytes();
    L24:
        if (ZeusTransformUtils.instanceOf(r5, Ed25519PublicKeyParameters.class) == false) goto L28;
        SSHBuilder r8 = new SSHBuilder();
        r8.writeString("ssh-ed25519");
        r8.writeBlock(((Ed25519PublicKeyParameters) ZeusTransformUtils.preCheckCast(r5, Ed25519PublicKeyParameters.class, "com.obric.memorydata.plugin")).getEncoded());
        return r8.getBytes();
    L28:
        throw new IllegalArgumentException("unable to convert " + r5.getClass().getName() + " to private key");
    L30:
        throw new IllegalArgumentException("cipherParameters was null.");
    }

    public static AsymmetricKeyParameter parsePublicKey(SSHBuffer r6) {
        String r0 = r6.readString();
        if ("ssh-rsa".equals(r0) == false) goto L6;
        AsymmetricKeyParameter r3 = new RSAKeyParameters(false, r6.readBigNumPositive(), r6.readBigNumPositive());
    L24:
        if (r3 == null) goto L31;
        if (r6.hasRemaining() == true) goto L29;
        return r3;
    L29:
        throw new IllegalArgumentException("decoded key has trailing data");
    L31:
        throw new IllegalArgumentException("unable to parse key");
    L6:
        if ("ssh-dss".equals(r0) == false) goto L10;
        AsymmetricKeyParameter r4 = new DSAPublicKeyParameters(r6.readBigNumPositive(), new DSAParameters(r6.readBigNumPositive(), r6.readBigNumPositive(), r6.readBigNumPositive()));
    L8:
        r3 = r4;
        goto L24
    L10:
        if (r0.startsWith("ecdsa") == false) goto L17;
        String r1 = r6.readString();
        ASN1ObjectIdentifier r2 = SSHNamedCurves.getByName(r1);
        X9ECParameters r5 = SSHNamedCurves.getParameters(r2);
        if (r5 == null) goto L15;
        r4 = new ECPublicKeyParameters(r5.getCurve().decodePoint(r6.readBlock()), new ECNamedDomainParameters(r2, r5));
        goto L8
    L15:
        throw new IllegalStateException("unable to find curve for " + r0 + " using curve name " + r1);
    L17:
        if ("ssh-ed25519".equals(r0) == false) goto L23;
        byte[] r7 = r6.readBlock();
        if (r7.length != 32) goto L22;
        r3 = new Ed25519PublicKeyParameters(r7, 0);
        goto L24
    L22:
        throw new IllegalStateException("public key value of wrong length");
    L23:
        r3 = null;
        goto L24
    }

    public static AsymmetricKeyParameter parsePublicKey(byte[] r1) {
        return parsePublicKey(new SSHBuffer(r1));
    }
}
