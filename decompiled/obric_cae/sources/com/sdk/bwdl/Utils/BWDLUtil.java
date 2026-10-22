package com.sdk.bwdl.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import com.sdk.bwdl.ExternalAPI.BWDLConstant;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class BWDLUtil {
    private static final String TAG = "BWDLUtil";
    private static final int mDeviceId = 0;

    static {
        mDeviceId = buildRandomDeviceID();
    }

    public BWDLUtil() {
    }

    public static byte[] AESDecrypt(byte[] r8, SecretKey r10) {
        Cipher r11 = Cipher.getInstance("AES");
        r11.init(2, r10);
        return r11.doFinal(r8);
    }

    public static byte[] AESEncrypt(byte[] r8, SecretKey r10) {
        Cipher r11 = Cipher.getInstance("AES");
        r11.init(1, r10);
        return r11.doFinal(r8);
    }

    public static short buildRandomChannelID(String r8) {
        byte[] r10 = MessageDigest.getInstance("SHA-256").digest((r8 + System.currentTimeMillis()).getBytes(StandardCharsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L5
        return (short) (((r10[1] & 255) << 8) | (r10[0] & 255));
    L5:
        e = move-exception;
        throw new RuntimeException("SHA-256 algorithm not found", e);
    }

    public static int buildRandomDeviceID() {
        return UUID.randomUUID().hashCode();
    }

    public static int byteToInt(byte[] r8) {
        if (r8 == null) goto L8;
        if (r8.length != 4) goto L8;
        int r10 = (((r8[0] & 255) << 24) | ((r8[1] & 255) << 16)) | ((r8[2] & 255) << 8);
        return (r8[3] & 255) | r10;
    L8:
        throw new IllegalArgumentException("Invalid byte array length, must be 4");
    }

    public static short byteToShort(byte[] r8) {
        if (r8 == null) goto L8;
        if (r8.length != 2) goto L8;
        int r10 = r8[1] << 8;
        return (short) ((r8[0] & 255) | r10);
    L8:
        throw new IllegalArgumentException("The byte array must contain two bytes.");
    }

    private static int bytesToInt(byte[] r8) {
        int r10 = r8.length;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r12 = (r12 << 8) + (r8[r11] & 255);
        r11 = r11 + 1;
        goto L3
    L5:
        return r12;
    }

    public static int convertStringToUniqueCode(String r8) {
        return bytesToInt(MessageDigest.getInstance("SHA-256").digest(r8.getBytes(StandardCharsets.UTF_8)));
    L5:
        return getDeviceId();
    }

    public static SecretKey generateKey() {
        SecretKeyFactory r8 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        char[] r10 = "BWDLSeed".toCharArray();
        return new SecretKeySpec(r8.generateSecret(new PBEKeySpec(r10, new byte[]{2, 3, 4, 5, 6}, 1000, 128)).getEncoded(), "AES");
    }

    @SuppressLint({"HardwareIds"})
    public static String getAndroidId(Context r8) {
        String r10 = Settings.Secure.getString(r8.getContentResolver(), "android_id");     // Catch: Exception -> L10
        if (r10 == null) goto L9;
        if (r10.isEmpty() == true) goto L9;
        return r10;
    L9:
        return null;
    }

    public static BWDLConstant.LinkType getApplicationLayerType(BWDLConstant.LinkType[] r8) {
        int r10 = r8.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L11;
        BWDLConstant.LinkType r12 = r8[r11];
        BWDLConstant.LinkType r13 = BWDLConstant.LinkType.Socket;
        if (r12 == r13) goto L6;
        BWDLConstant.LinkType r14 = BWDLConstant.LinkType.SocketChannel;
        if (r12 == r14) goto L9;
        r11 = r11 + 1;
        goto L3
    L9:
        return r14;
    L6:
        return r13;
    L11:
        return null;
    }

    public static int getDeviceId() {
        return mDeviceId;
    }

    public static BWDLConstant.LinkType getLinkLayerType(BWDLConstant.LinkType[] r8) {
        int r10 = r8.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        BWDLConstant.LinkType r12 = r8[r11];
        BWDLConstant.LinkType r13 = BWDLConstant.LinkType.P2P;
        if (r12 == r13) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r13;
    L8:
        return null;
    }

    public static byte[] intToBytes(int r8) {
        return new byte[]{(byte) (r8 >>> 24), (byte) (r8 >>> 16), (byte) (r8 >>> 8), (byte) r8};
    }

    public static void printByteArray(byte[] r8) {
        StringBuilder r10 = new StringBuilder();
        int r11 = r8.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.append(String.format("%02X", new Object[]{Byte.valueOf(r8[r12])}));
        r12 = r12 + 1;
        goto L3
    L5:
        BWDLLog.d(TAG, "" + r10.toString());
    }

    public static byte[] shortToByte(short r8) {
        ByteBuffer r10 = ByteBuffer.allocate(2);
        r10.order(ByteOrder.LITTLE_ENDIAN);
        r10.putShort(r8);
        return r10.array();
    }
}
