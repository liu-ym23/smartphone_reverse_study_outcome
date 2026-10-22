package com.bytedance.crypto.utils;

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

/* JADX INFO: loaded from: classes.dex */
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

        public /* synthetic */ LengthInfo(AnonymousClass1 r10) {
            this();
        }
    }

    public CryptoUtils() {
    }

    public static PublicKey byteArrayToECPublicKey(byte[] r10) {
        boolean r11 = false;
        if (r10.length == 65) goto L5;
    L16:
        KeyFactory r12 = KeyFactory.getInstance(CryptoConst.ALGORITHM_EC);     // Catch: Exception -> L13
        if (r11 == false) goto L12;
        AlgorithmParameters r13 = AlgorithmParameters.getInstance(CryptoConst.ALGORITHM_EC);     // Catch: Exception -> L13
        r13.init(new ECGenParameterSpec("secp256r1"));     // Catch: Exception -> L13
        return r12.generatePublic(new ECPublicKeySpec(new ECPoint(new BigInteger(1, Arrays.copyOfRange(r10, 1, 33)), new BigInteger(1, Arrays.copyOfRange(r10, 33, 65))), (ECParameterSpec) r13.getParameterSpec(ECParameterSpec.class)));
    L12:
        return r12.generatePublic(new X509EncodedKeySpec(r10));
    L13:
        e = move-exception;
        LogUtils.e(TAG, "Bytes to EC public key failed, error:" + e.getMessage());
        return null;
    L5:
        if (r10[0] != 4) goto L16;
        r11 = true;
        goto L16
    }

    public static String byteArrayToHexString(byte[] r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r11.append(String.format("%02x", new Object[]{Byte.valueOf(r10[r13])}));
        r13 = r13 + 1;
        goto L3
    L6:
        return r11.toString();
    }

    public static int byteArrayToInt(byte[] r10) {
        int r11 = (((r10[0] & 255) << 24) | ((r10[1] & 255) << 16)) | ((r10[2] & 255) << 8);
        return (r10[3] & 255) | r11;
    }

    public static byte[] convertPEMToUncompressedECPubKey(String r10) {
        String r11 = r10.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s+", "");
        String r12 = TAG;
        LogUtils.d(r12, "base64PublicKey: " + r11);
        ECPoint r13 = ((ECPublicKey) KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(r11)))).getW();     // Catch: Exception -> L5
        byte[] r14 = convertToFixedECPoint(r13.getAffineX().toByteArray(), 32);     // Catch: Exception -> L5
        byte[] r15 = convertToFixedECPoint(r13.getAffineY().toByteArray(), 32);     // Catch: Exception -> L5
        byte[] r16 = new byte[65];     // Catch: Exception -> L5
        r16[0] = 4;     // Catch: Exception -> L5
        LogUtils.d(r12, "x.length: " + r14.length);     // Catch: Exception -> L5
        LogUtils.d(r12, "y.length: " + r15.length);     // Catch: Exception -> L5
        System.arraycopy(r14, 0, r16, 1, r14.length);     // Catch: Exception -> L5
        System.arraycopy(r15, 0, r16, r14.length + 1, r15.length);     // Catch: Exception -> L5
        LogUtils.d(r12, "uncompressedPublicKey: " + byteArrayToHexString(r16));     // Catch: Exception -> L5
        return r16;
    L5:
        e = move-exception;
        LogUtils.e(TAG, "convertPEMToUncompressedECPubKey failed, exception: " + e.getMessage());
        return null;
    }

    private static byte[] convertToFixedECPoint(byte[] r10, int r11) {
        if (r10.length != r11) goto L5;
        return r10;
    L5:
        byte[] r12 = new byte[r11];
        if (r10.length <= r11) goto L8;
        System.arraycopy(r10, r10.length - r11, r12, 0, r11);
    L9:
        return r12;
    L8:
        System.arraycopy(r10, 0, r12, r11 - r10.length, r10.length);
        goto L9
    }

    public static String ecdsaSign(String r10, PrivateKey r11) {
        Signature r12 = Signature.getInstance("SHA256withECDSA");
        r12.initSign(r11);
        r12.update(r10.getBytes(StandardCharsets.UTF_8));
        byte[] r13 = r12.sign();
        return Base64.getEncoder().encodeToString(r13);
    }

    public static byte[] extractPrivateKey(byte[] r10) {
        if (r10[0] != 48) goto L17;
        int r11 = 1;
        int r12 = parseLengthEx(r10, 1).lengthBytes;
    L5:
        int r13 = r12 + r11;
        if (r13 >= r10.length) goto L15;
        int r14 = r10[r13] & 255;
        int r15 = r13 + 1;
        LengthInfo r16 = parseLengthEx(r10, r15);
        r12 = r15 + r16.lengthBytes;
        if (r14 != 4) goto L13;
        int r17 = r16.valueLength;
        if (r17 != 32) goto L13;
        byte[] r18 = new byte[r17];
        System.arraycopy(r10, r12, r18, 0, r17);
        return r18;
    L13:
        r11 = r16.valueLength;
        goto L5
    L15:
        throw new IllegalArgumentException("未找到私钥材料");
    L17:
        throw new IllegalArgumentException("不是有效的ASN.1序列");
    }

    public static KeyPair generateECCKeyPair() {
        KeyPairGenerator r10 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC);     // Catch: Exception -> L4
        r10.initialize(256);     // Catch: Exception -> L4
        return r10.generateKeyPair();
    L4:
        e = move-exception;
        LogUtils.e(TAG, "Generate ecc keypair failed, error:" + e.getMessage());
        return null;
    }

    public static byte[] generateSecureRandom(int r10) {
        byte[] r11 = new byte[r10];
        new SecureRandom().nextBytes(r11);
        return r11;
    }

    public static SecretKey generateSymmetricKey(String r10) {
        return KeyGenerator.getInstance(r10).generateKey();
    L4:
        e = move-exception;
        LogUtils.e(TAG, "Generate symmetric key failed,algorithm:" + r10 + " error:" + e.getMessage());
        return null;
    }

    public static SecretKey generateSymmetricKey(String r10, int r11) {
        return new SecretKeySpec(generateSecureRandom(r11), r10);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "Generate symmetric key failed,algorithm:" + r10 + " keyLen:" + r11 + " error:" + e.getMessage());
        return null;
    }

    public static byte[] hexStringToByteArray(String r10) {
        if ((r10.length() % 2) == 0) goto L7;
        String r11 = TAG;
        StringBuilder r12 = new StringBuilder();
        r12.append("Invalid hex string length:");
        r12.append(r10.length());
    L5:
        LogUtils.e(r11, r12.toString());
        return new byte[0];
    L7:
        int r13 = r10.length() / 2;
        byte[] r14 = new byte[r13];
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L14;
        int r16 = r15 * 2;
        r14[r15] = (byte) Integer.parseInt(r10.substring(r16, r16 + 2), 16);     // Catch: Exception -> L12
        r15 = r15 + 1;
    L12:
        e = move-exception;
        r11 = TAG;
        r12 = new StringBuilder();
        r12.append("Hex string to byte array failed, error:");
        r12.append(e.getMessage());
        goto L5
    L14:
        return r14;
    }

    public static byte[] intToBytes(int r10) {
        return new byte[]{(byte) (r10 >> 24), (byte) ((r10 >> 16) & 255), (byte) ((r10 >> 8) & 255), (byte) (r10 & 255)};
    }

    public static byte[] longToBytes(long r10) {
        byte[] r11 = new byte[8];
        int r12 = 7;
    L3:
        if (r12 < 0) goto L5;
        r11[r12] = (byte) (255 & r10);
        r10 = r10 >> 8;
        r12 = r12 - 1;
        goto L3
    L5:
        return r11;
    }

    public static byte[] messageDigest(byte[] r10, String r11) {
        LogUtils.d(TAG, "digestAlgorithm: " + r11);
        MessageDigest r12 = MessageDigest.getInstance(r11);     // Catch: Exception -> L5
        r12.update(r10);     // Catch: Exception -> L5
        return r12.digest();
    L5:
        LogUtils.e(TAG, "SHA256 failed.");
        return new byte[0];
    }

    public static byte[] parseECCPublicKey(byte[] r10) {
        if (r10[0] != 48) goto L18;
        int r11 = parseLengthEx(r10, 1).lengthBytes + 1;
        if (r10[r11] != 48) goto L16;
        int r12 = r11 + 1;
        LengthInfo r13 = parseLengthEx(r10, r12);
        int r14 = r12 + (r13.lengthBytes + r13.valueLength);
        if (r10[r14] != 3) goto L14;
        int r15 = r14 + 1;
        LengthInfo r16 = parseLengthEx(r10, r15);
        int r17 = r16.valueLength;
        int r18 = r15 + r16.lengthBytes;
        if (r10[r18] != 0) goto L12;
        r18 = r18 + 1;
        r17 = r17 - 1;
    L12:
        return Arrays.copyOfRange(r10, r18, r17 + r18);
    L14:
        throw new IllegalArgumentException("Invalid BIT STRING tag");
    L16:
        throw new IllegalArgumentException("Invalid algorithm identifier");
    L18:
        throw new IllegalArgumentException("Invalid ASN.1 SEQUENCE tag");
    }

    public static byte[] parseEccPrivateKey(byte[] r10) {
        if (r10[0] != 48) goto L19;
        int r11 = parseLengthEx(r10, 1).lengthBytes + 1;
        if (r10[r11] != 2) goto L17;
        int r12 = r11 + 1;
        LengthInfo r13 = parseLengthEx(r10, r12);
        int r14 = r12 + (r13.lengthBytes + r13.valueLength);
        if (r10[r14] != 48) goto L15;
        int r15 = r14 + 1;
        LengthInfo r16 = parseLengthEx(r10, r15);
        int r17 = r15 + (r16.lengthBytes + r16.valueLength);
        if (r10[r17] != 4) goto L13;
        int r18 = r17 + 1;
        LengthInfo r19 = parseLengthEx(r10, r18);
        int r20 = r18 + r19.lengthBytes;
        return extractPrivateKey(Arrays.copyOfRange(r10, r20, r19.valueLength + r20));
    L13:
        throw new IllegalArgumentException("Invalid OCTET STRING tag");
    L15:
        throw new IllegalArgumentException("Invalid algorithm identifier");
    L17:
        throw new IllegalArgumentException("Invalid version tag");
    L19:
        throw new IllegalArgumentException("Invalid ASN.1 SEQUENCE tag");
    }

    private static LengthInfo parseLengthEx(byte[] r10, int r11) {
        int r12 = r10[r11] & 255;
        LengthInfo r13 = new LengthInfo(null);
        if ((r12 & 128) != 0) goto L5;
        r13.valueLength = r12;
        r13.lengthBytes = 1;
    L8:
        return r13;
    L5:
        int r14 = r12 & 127;
        r13.lengthBytes = r14 + 1;
        int r15 = 0;
        r13.valueLength = 0;
    L6:
        if (r15 >= r14) goto L8;
        r13.valueLength = (r13.valueLength << 8) | (r10[(r11 + 1) + r15] & 255);
        r15 = r15 + 1;
        goto L6
    }

    public static boolean verifyECDSASignature(PublicKey r10, byte[] r11, byte[] r12, String r13) {
        if ((r10 instanceof ECPublicKey) == true) goto L11;
        LogUtils.e(TAG, "Provided publicKey is not an EC public key");
        return false;
    L11:
        Signature r14 = Signature.getInstance(r13);     // Catch: Throwable -> L8
        r14.initVerify(r10);     // Catch: Throwable -> L8
        r14.update(r11);     // Catch: Throwable -> L8
        return r14.verify(r12);
    L8:
        e = move-exception;
        LogUtils.e(TAG, "verifyECDSASignature failed, exception: " + e.getMessage());
        return false;
    }
}
