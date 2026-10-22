package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
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

/* JADX INFO: loaded from: classes.dex */
public class TransUtils {
    private static final String TAG = "TransUtils";

    public TransUtils() {
    }

    public static long byteArrayToLong(byte[] r10) {
        long r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11 = (r11 << 8) | ((long) (r10[r12] & 255));
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static int bytesToInt(byte[] r10) {
        if (r10.length != 4) goto L7;
        int r11 = (((r10[0] & 255) << 24) | ((r10[1] & 255) << 16)) | ((r10[2] & 255) << 8);
        return (r10[3] & 255) | r11;
    L7:
        throw new IllegalArgumentException("Byte array must be exactly 4 bytes long");
    }

    public static long bytesToLong(byte[] r10) {
        if (r10.length != 8) goto L7;
        long r11 = (((((((long) (r10[0] & 255)) << 56) | (((long) (r10[1] & 255)) << 48)) | (((long) (r10[2] & 255)) << 40)) | (((long) (r10[3] & 255)) << 32)) | (((long) (r10[4] & 255)) << 24)) | (((long) (r10[5] & 255)) << 16);
        return ((((long) (r10[6] & 255)) << 8) | r11) | ((long) (r10[7] & 255));
    L7:
        throw new IllegalArgumentException("Byte array must be exactly 8 bytes long");
    }

    public static String certChainsToPEM(Certificate[] r10, int r11) {
        StringBuilder r12 = new StringBuilder();
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        String r14 = Base64.getEncoder().encodeToString(r10[r13].getEncoded());     // Catch: Exception -> L6
        r12.append("-----BEGIN CERTIFICATE-----\\n");     // Catch: Exception -> L6
        r12.append(r14);     // Catch: Exception -> L6
        r12.append("\\n-----END CERTIFICATE-----\\n");     // Catch: Exception -> L6
        r13 = r13 + 1;
    L6:
        e = move-exception;
        throw new CloudTransException("certChainsToPEM failed, error: " + e.getMessage());
    L10:
        return r12.toString();
    }

    private static boolean checkRotProvisionState(Context r10) {
        String r11 = FrameworkSecurityCompat.rotCheckState(r10, new Bundle());     // Catch: Exception -> L8
        LogUtils.i(TAG, "checkRotProvisionState:" + r11);     // Catch: Exception -> L8
        JSONObject r12 = new JSONObject(r11);     // Catch: Exception -> L8
        boolean r13 = r12.getBoolean("dev_key_provisioned");     // Catch: Exception -> L8
        boolean r14 = r12.getBoolean("dev_cert_provisioned");     // Catch: Exception -> L8
        if (r13 == false) goto L13;
        if (r14 == false) goto L14;
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

    public static byte[] concatenate(byte[]... r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r11.write(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L6:
        return r11.toByteArray();
    }

    public static String convertToPem(PublicKey r10) {
        if (CryptoConst.ALGORITHM_EC.equals(r10.getAlgorithm()) == false) goto L7;
        return "-----BEGIN PUBLIC KEY-----\\n" + Base64.getEncoder().encodeToString(r10.getEncoded()) + "\\n-----END PUBLIC KEY-----";
    L7:
        throw new IllegalArgumentException("不是有效的ECC公钥");
    }

    public static PublicKey getPublicKeyFromBytes(byte[] r10) {
        X509EncodedKeySpec r11 = new X509EncodedKeySpec(r10);
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(r11);
    }

    public static PublicKey getPublicKeyFromPEM(String r10) {
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(r10.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s", ""))));
    L5:
        e = move-exception;
        throw new CloudTransException("getPublicKeyFromPEM failed, " + e.getMessage());
    }

    public static String getSystemProperty(String r10) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r10, "unknown"});
    L5:
        e = move-exception;
        LogUtils.e(TAG, "Get system property failed!! error:" + e.getMessage());
        return "unknown";
    }

    public static byte[] intToByteArray(int r10) {
        ByteBuffer r11 = ByteBuffer.allocate(4);
        r11.putInt(r10);
        return r11.array();
    }

    public static boolean isBDDevice() {
        Class.forName("com.bytedance.security.secretdata.SecretDataManager");     // Catch: ClassNotFoundException -> L5
    L4:
        return true;
    }

    public static boolean isDevCertExist(Context r10) {
        if (checkVendorKmProp() == false) goto L5;
    L8:
        return true;
    L5:
        if (checkRotProvisionState(r10) == true) goto L8;
        return false;
    }

    public static void logLongString(String r10, String r11) {
        if (r11.length() <= 4000) goto L8;
        int r12 = 0;
    L6:
        if (r12 >= r11.length()) goto L11;
        int r13 = r12 + 4000;
        Log.i(r10, r11.substring(r12, Math.min(r11.length(), r13)));
        r12 = r13;
        goto L6
    L11:
        return;
    L8:
        Log.i(r10, r11);
    }

    public static byte[] longToByteArray(long r10) {
        ByteBuffer r11 = ByteBuffer.allocate(8);
        r11.putLong(r10);
        return r11.array();
    }

    public static void printErrorInfo(String r10, String r11) {
        LogUtils.e(r10, r11);
        throw new CloudTransException(r11);
    }

    public static byte[] sha256(byte[] r10) {
        return MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256).digest(r10);
    }

    public static boolean verifySignature(PublicKey r10, byte[] r11, String r12) {
        Signature r13 = Signature.getInstance("SHA256withECDSA");
        r13.initVerify(r10);
        r13.update(r11);
        return r13.verify(CryptoUtils.hexStringToByteArray(r12));
    }
}
