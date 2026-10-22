package com.bytedance.crypto.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class CryptoUtils {
    public static final String TAG = "CryptoUtils";

    /* JADX INFO: renamed from: com.bytedance.crypto.utils.CryptoUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class LengthInfo {
        public int lengthBytes;
        public int valueLength;

        private LengthInfo() {
        }

        public /* synthetic */ LengthInfo(AnonymousClass1 r1) {
            this();
        }
    }

    public CryptoUtils() {
    }

    public static PublicKey byteArrayToECPublicKey(byte[] r6) {
        boolean r2 = false;
        if (r6.length == 65) goto L5;
    L16:
        KeyFactory r1 = KeyFactory.getInstance(CryptoConst.ALGORITHM_EC);     // Catch: Exception -> L13
        if (r2 == false) goto L12;
        AlgorithmParameters r0 = AlgorithmParameters.getInstance(CryptoConst.ALGORITHM_EC);     // Catch: Exception -> L13
        r0.init(new ECGenParameterSpec("secp256r1"));     // Catch: Exception -> L13
        return r1.generatePublic(new ECPublicKeySpec(new ECPoint(new BigInteger(1, Arrays.copyOfRange(r6, 1, 33)), new BigInteger(1, Arrays.copyOfRange(r6, 33, 65))), (ECParameterSpec) ZeusTransformUtils.preCheckCast(r0.getParameterSpec(ECParameterSpec.class), ECParameterSpec.class, "com.obric.memorydata.plugin")));
    L12:
        return r1.generatePublic(new X509EncodedKeySpec(r6));
    L13:
        e = move-exception;
        LogUtils.e(TAG, "Bytes to EC public key failed, error:" + e.getMessage());
        return null;
    L5:
        if (r6[0] != 4) goto L16;
        r2 = true;
        goto L16
    }

    public static String byteArrayToHexString(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.append(String.format("%02x", new Object[]{Byte.valueOf(r6[r3])}));
        r3 = r3 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public static int byteArrayToInt(byte[] r2) {
        int r0 = (((r2[0] & 255) << 24) | ((r2[1] & 255) << 16)) | ((r2[2] & 255) << 8);
        return (r2[3] & 255) | r0;
    }

    public static byte[] convertPEMToUncompressedECPubKey(String r6) {
        String r7 = r6.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s+", "");
        String r0 = TAG;
        LogUtils.d(r0, "base64PublicKey: " + r7);
        ECPoint r8 = ((ECPublicKey) ZeusTransformUtils.preCheckCast(KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(r7))), ECPublicKey.class, "com.obric.memorydata.plugin")).getW();     // Catch: Exception -> L5
        byte[] r1 = convertToFixedECPoint(r8.getAffineX().toByteArray(), 32);     // Catch: Exception -> L5
        byte[] r9 = convertToFixedECPoint(r8.getAffineY().toByteArray(), 32);     // Catch: Exception -> L5
        byte[] r2 = new byte[65];     // Catch: Exception -> L5
        r2[0] = 4;     // Catch: Exception -> L5
        LogUtils.d(r0, "x.length: " + r1.length);     // Catch: Exception -> L5
        LogUtils.d(r0, "y.length: " + r9.length);     // Catch: Exception -> L5
        System.arraycopy(r1, 0, r2, 1, r1.length);     // Catch: Exception -> L5
        System.arraycopy(r9, 0, r2, r1.length + 1, r9.length);     // Catch: Exception -> L5
        LogUtils.d(r0, "uncompressedPublicKey: " + byteArrayToHexString(r2));     // Catch: Exception -> L5
        return r2;
    L5:
        e = move-exception;
        LogUtils.e(TAG, "convertPEMToUncompressedECPubKey failed, exception: " + e.getMessage());
        return null;
    }

    private static byte[] convertToFixedECPoint(byte[] r3, int r4) {
        if (r3.length != r4) goto L5;
        return r3;
    L5:
        byte[] r0 = new byte[r4];
        if (r3.length <= r4) goto L8;
        System.arraycopy(r3, r3.length - r4, r0, 0, r4);
    L9:
        return r0;
    L8:
        System.arraycopy(r3, 0, r0, r4 - r3.length, r3.length);
        goto L9
    }

    public static String ecdsaSign(String r2, PrivateKey r3) {
        PrivateKey r4 = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, PrivateKey.class, "com.obric.memorydata.plugin");
        Signature r0 = Signature.getInstance("SHA256withECDSA");
        r0.initSign(r4);
        r0.update(r2.getBytes(StandardCharsets.UTF_8));
        byte[] r5 = r0.sign();
        return Base64.getEncoder().encodeToString(r5);
    }

    public static byte[] extractPrivateKey(byte[] r5) {
        if (r5[0] != 48) goto L17;
        int r1 = 1;
        int r2 = parseLengthEx(r5, 1).lengthBytes;
    L5:
        int r3 = r2 + r1;
        if (r3 >= r5.length) goto L15;
        int r4 = r5[r3] & 255;
        int r6 = r3 + 1;
        LengthInfo r7 = parseLengthEx(r5, r6);
        r2 = r6 + r7.lengthBytes;
        if (r4 != 4) goto L13;
        int r8 = r7.valueLength;
        if (r8 != 32) goto L13;
        byte[] r9 = new byte[r8];
        System.arraycopy(r5, r2, r9, 0, r8);
        return r9;
    L13:
        r1 = r7.valueLength;
        goto L5
    L15:
        throw new IllegalArgumentException("未找到私钥材料");
    L17:
        throw new IllegalArgumentException("不是有效的ASN.1序列");
    }

    public static KeyPair generateECCKeyPair() {
        KeyPairGenerator r0 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC);     // Catch: Exception -> L4
        r0.initialize(256);     // Catch: Exception -> L4
        return r0.generateKeyPair();
    L4:
        e = move-exception;
        LogUtils.e(TAG, "Generate ecc keypair failed, error:" + e.getMessage());
        return null;
    }

    public static byte[] generateSecureRandom(int r1) {
        byte[] r2 = new byte[r1];
        new SecureRandom().nextBytes(r2);
        return r2;
    }

    public static SecretKey generateSymmetricKey(String r4) {
        return KeyGenerator.getInstance(r4).generateKey();
    L4:
        e = move-exception;
        LogUtils.e(TAG, "Generate symmetric key failed,algorithm:" + r4 + " error:" + e.getMessage());
        return null;
    }

    public static SecretKey generateSymmetricKey(String r4, int r5) {
        return new SecretKeySpec(generateSecureRandom(r5), r4);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "Generate symmetric key failed,algorithm:" + r4 + " keyLen:" + r5 + " error:" + e.getMessage());
        return null;
    }

    public static byte[] hexStringToByteArray(String r6) {
        if ((r6.length() % 2) == 0) goto L7;
        String r0 = TAG;
        StringBuilder r7 = new StringBuilder().append("Invalid hex string length:").append(r6.length());
    L5:
        LogUtils.e(r0, r7.toString());
        return new byte[0];
    L7:
        int r1 = r6.length() / 2;
        byte[] r2 = new byte[r1];
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L14;
        int r4 = r3 * 2;
        r2[r3] = (byte) Integer.parseInt(r6.substring(r4, r4 + 2), 16);     // Catch: Exception -> L12
        r3 = r3 + 1;
    L12:
        e = move-exception;
        r0 = TAG;
        r7 = new StringBuilder().append("Hex string to byte array failed, error:").append(e.getMessage());
        goto L5
    L14:
        return r2;
    }

    public static byte[] intToBytes(int r3) {
        return new byte[]{(byte) (r3 >> 24), (byte) ((r3 >> 16) & 255), (byte) ((r3 >> 8) & 255), (byte) (r3 & 255)};
    }

    public static byte[] longToBytes(long r5) {
        byte[] r1 = new byte[8];
        int r2 = 7;
    L3:
        if (r2 < 0) goto L5;
        r1[r2] = (byte) (255 & r5);
        r5 = r5 >> 8;
        r2 = r2 - 1;
        goto L3
    L5:
        return r1;
    }

    public static byte[] messageDigest(byte[] r3, String r4) {
        LogUtils.d(TAG, "digestAlgorithm: " + r4);
        MessageDigest r5 = MessageDigest.getInstance(r4);     // Catch: Exception -> L5
        r5.update(r3);     // Catch: Exception -> L5
        return r5.digest();
    L5:
        LogUtils.e(TAG, "SHA256 failed.");
        return new byte[0];
    }

    public static byte[] parseECCPublicKey(byte[] r4) {
        if (r4[0] != 48) goto L18;
        int r2 = parseLengthEx(r4, 1).lengthBytes + 1;
        if (r4[r2] != 48) goto L16;
        int r3 = r2 + 1;
        LengthInfo r1 = parseLengthEx(r4, r3);
        int r5 = r3 + (r1.lengthBytes + r1.valueLength);
        if (r4[r5] != 3) goto L14;
        int r6 = r5 + 1;
        LengthInfo r0 = parseLengthEx(r4, r6);
        int r7 = r0.valueLength;
        int r8 = r6 + r0.lengthBytes;
        if (r4[r8] != 0) goto L12;
        r8 = r8 + 1;
        r7 = r7 - 1;
    L12:
        return Arrays.copyOfRange(r4, r8, r7 + r8);
    L14:
        throw new IllegalArgumentException("Invalid BIT STRING tag");
    L16:
        throw new IllegalArgumentException("Invalid algorithm identifier");
    L18:
        throw new IllegalArgumentException("Invalid ASN.1 SEQUENCE tag");
    }

    public static byte[] parseEccPrivateKey(byte[] r5) {
        if (r5[0] != 48) goto L19;
        int r2 = parseLengthEx(r5, 1).lengthBytes + 1;
        if (r5[r2] != 2) goto L17;
        int r3 = r2 + 1;
        LengthInfo r4 = parseLengthEx(r5, r3);
        int r6 = r3 + (r4.lengthBytes + r4.valueLength);
        if (r5[r6] != 48) goto L15;
        int r7 = r6 + 1;
        LengthInfo r1 = parseLengthEx(r5, r7);
        int r8 = r7 + (r1.lengthBytes + r1.valueLength);
        if (r5[r8] != 4) goto L13;
        int r9 = r8 + 1;
        LengthInfo r0 = parseLengthEx(r5, r9);
        int r10 = r9 + r0.lengthBytes;
        return extractPrivateKey(Arrays.copyOfRange(r5, r10, r0.valueLength + r10));
    L13:
        throw new IllegalArgumentException("Invalid OCTET STRING tag");
    L15:
        throw new IllegalArgumentException("Invalid algorithm identifier");
    L17:
        throw new IllegalArgumentException("Invalid version tag");
    L19:
        throw new IllegalArgumentException("Invalid ASN.1 SEQUENCE tag");
    }

    private static LengthInfo parseLengthEx(byte[] r6, int r7) {
        int r0 = r6[r7] & 255;
        LengthInfo r1 = new LengthInfo(null);
        if ((r0 & 128) != 0) goto L5;
        r1.valueLength = r0;
        r1.lengthBytes = 1;
    L8:
        return r1;
    L5:
        int r2 = r0 & 127;
        r1.lengthBytes = r2 + 1;
        int r3 = 0;
        r1.valueLength = 0;
    L6:
        if (r3 >= r2) goto L8;
        r1.valueLength = (r1.valueLength << 8) | (r6[(r7 + 1) + r3] & 255);
        r3 = r3 + 1;
        goto L6
    }

    public static byte[] publicKeyToUncompressedECPubKey(PublicKey r2) {
        PublicKey r3 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r2, PublicKey.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L18;
        if (r3.getEncoded() == null) goto L18;
        if (ZeusTransformUtils.instanceOf(r3, ECPublicKey.class) == false) goto L16;
        byte[] r4 = parseECCPublicKey(r3.getEncoded());
        if (r4.length != 65) goto L14;
        if (r4[0] != 4) goto L14;
        return r4;
    L14:
        throw new IllegalArgumentException("invalid uncompressed EC public key");
    L16:
        throw new IllegalArgumentException("publicKey is not an EC public key");
    L18:
        throw new IllegalArgumentException("publicKey is empty");
    }

    public static boolean verifyECDSASignature(PublicKey r2, byte[] r3, byte[] r4, String r5) {
        PublicKey r6 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r2, PublicKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ECPublicKey.class) == true) goto L11;
        LogUtils.e(TAG, "Provided publicKey is not an EC public key");
        return false;
    L11:
        Signature r7 = Signature.getInstance(r5);     // Catch: Throwable -> L8
        r7.initVerify(r6);     // Catch: Throwable -> L8
        r7.update(r3);     // Catch: Throwable -> L8
        return r7.verify(r4);
    L8:
        e = move-exception;
        LogUtils.e(TAG, "verifyECDSASignature failed, exception: " + e.getMessage());
        return false;
    }
}
