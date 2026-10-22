package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TransUtils {
    private static final String TAG = "TransUtils";

    public TransUtils() {
    }

    public static long byteArrayToLong(byte[] r5) {
        long r0 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L6;
        r0 = (r0 << 8) | ((long) (r5[r2] & 255));
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static int bytesToInt(byte[] r2) {
        if (r2.length != 4) goto L7;
        int r0 = (((r2[0] & 255) << 24) | ((r2[1] & 255) << 16)) | ((r2[2] & 255) << 8);
        return (r2[3] & 255) | r0;
    L7:
        throw new IllegalArgumentException("Byte array must be exactly 4 bytes long");
    }

    public static long bytesToLong(byte[] r6) {
        if (r6.length != 8) goto L7;
        long r2 = (((((((long) (r6[0] & 255)) << 56) | (((long) (r6[1] & 255)) << 48)) | (((long) (r6[2] & 255)) << 40)) | (((long) (r6[3] & 255)) << 32)) | (((long) (r6[4] & 255)) << 24)) | (((long) (r6[5] & 255)) << 16);
        return ((((long) (r6[6] & 255)) << 8) | r2) | ((long) (r6[7] & 255));
    L7:
        throw new IllegalArgumentException("Byte array must be exactly 8 bytes long");
    }

    public static String certChainsToPEM(Certificate[] r4, int r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L10;
        r0.append("-----BEGIN CERTIFICATE-----\\n").append(Base64.getEncoder().encodeToString(r4[r1].getEncoded())).append("\\n-----END CERTIFICATE-----\\n");     // Catch: Exception -> L6
        r1 = r1 + 1;
    L6:
        e = move-exception;
        throw new CloudTransException("certChainsToPEM failed, error: " + e.getMessage());
    L10:
        return r0.toString();
    }

    private static boolean checkRotProvisionState(Context r4) {
        String r5 = FrameworkSecurityCompat.rotCheckState((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), new Bundle());     // Catch: Exception -> L8
        LogUtils.i(TAG, "checkRotProvisionState:" + r5);     // Catch: Exception -> L8
        JSONObject r1 = new JSONObject(r5);     // Catch: Exception -> L8
        boolean r6 = r1.getBoolean("dev_key_provisioned");     // Catch: Exception -> L8
        boolean r2 = r1.getBoolean("dev_cert_provisioned");     // Catch: Exception -> L8
        if (r6 == false) goto L13;
        if (r2 == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static boolean checkVendorKmProp() {
        return TextUtils.equals(getSystemProperty("vendor.km.devcert.status"), "ok");
    }

    public static byte[] concatenate(byte[]... r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.write(r4[r2]);
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toByteArray();
    }

    public static String convertToPem(PublicKey r2) {
        PublicKey r3 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r2, PublicKey.class, "com.obric.memorydata.plugin");
        if (CryptoConst.ALGORITHM_EC.equals(r3.getAlgorithm()) == false) goto L7;
        return "-----BEGIN PUBLIC KEY-----\\n" + Base64.getEncoder().encodeToString(r3.getEncoded()) + "\\n-----END PUBLIC KEY-----";
    L7:
        throw new IllegalArgumentException("不是有效的ECC公钥");
    }

    public static PublicKey getPublicKeyFromBytes(byte[] r1) {
        X509EncodedKeySpec r0 = new X509EncodedKeySpec(r1);
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(r0);
    }

    public static PublicKey getPublicKeyFromPEM(String r3) {
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(r3.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s", ""))));
    L5:
        e = move-exception;
        throw new CloudTransException("getPublicKeyFromPEM failed, " + e.getMessage());
    }

    public static String getSystemProperty(String r9) {
        return (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r9, "unknown"}), String.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        LogUtils.e(TAG, "Get system property failed!! error:" + e.getMessage());
        return "unknown";
    }

    public static byte[] intToByteArray(int r1) {
        ByteBuffer r0 = ByteBuffer.allocate(4);
        r0.putInt(r1);
        return r0.array();
    }

    public static boolean isBDDevice() {
        ZeusTransformUtils.forName("com.bytedance.security.secretdata.SecretDataManager", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L5
        return true;
    L5:
        ZeusTransformUtils.forName("com.obric.security.secretdata.SecretDataManager", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L7
        return true;
    L7:
        ZeusTransformUtils.forName("com.aiassistant.security.secretdata.SecretDataManager", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L9
        return true;
    L9:
        return false;
    }

    public static boolean isDevCertExist(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (checkVendorKmProp() == false) goto L5;
    L8:
        return true;
    L5:
        if (checkRotProvisionState(r3) == true) goto L8;
        return false;
    }

    public static void logLongString(String r3, String r4) {
        if (r4.length() <= 4000) goto L8;
        int r0 = 0;
    L6:
        if (r0 >= r4.length()) goto L11;
        int r2 = r0 + 4000;
        Log.i(r3, r4.substring(r0, Math.min(r4.length(), r2)));
        r0 = r2;
        goto L6
    L11:
        return;
    L8:
        Log.i(r3, r4);
    }

    public static byte[] longToByteArray(long r1) {
        ByteBuffer r0 = ByteBuffer.allocate(8);
        r0.putLong(r1);
        return r0.array();
    }

    public static void printErrorInfo(String r0, String r1) {
        LogUtils.e(r0, r1);
        throw new CloudTransException(r1);
    }

    public static byte[] sha256(byte[] r1) {
        return MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256).digest(r1);
    }

    public static boolean verifySignature(PublicKey r2, byte[] r3, String r4) {
        PublicKey r5 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r2, PublicKey.class, "com.obric.memorydata.plugin");
        Signature r0 = Signature.getInstance("SHA256withECDSA");
        r0.initVerify(r5);
        r0.update(r3);
        return r0.verify(CryptoUtils.hexStringToByteArray(r4));
    }
}
