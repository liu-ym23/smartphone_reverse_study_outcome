package com.bytedance.crypto.obfuscated;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.modeldist.ModelInitResult;
import com.bytedance.crypto.utils.CertUtils;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f1471a = null;

    static {
        f1471a = new ConcurrentHashMap();
    }

    public static int a(Context r10, InputStream r11, OutputStream r12, String r13, String r14) {
        LogUtils.d("ModelDistUtils", "decryptModelByFEKCipher enter");
        DataInputStream r15 = new DataInputStream(r11);     // Catch: IOException -> L43
        d r16 = a(r15);     // Catch: Throwable -> L37
        if (r16 != null) goto L9;
        LogUtils.e("ModelDistUtils", "parseModelHeader failed.");     // Catch: Throwable -> L37
        r15.close();     // Catch: IOException -> L43
        return -8;
    L9:
        int r17 = r15.readInt();     // Catch: Throwable -> L37
        if (r17 >= 0) goto L14;
        LogUtils.e("ModelDistUtils", "Model cipher length is invalid: " + r17);     // Catch: Throwable -> L37
        r15.close();     // Catch: IOException -> L43
        return -8;
    L14:
        LogUtils.d("ModelDistUtils", "cipherLen: " + r17);     // Catch: Throwable -> L37
        i r18 = a(r10, r14);     // Catch: Throwable -> L37
        if (r18 != null) goto L20;
        LogUtils.e("ModelDistUtils", "Get external device key failed.");     // Catch: Throwable -> L37
        r15.close();     // Catch: IOException -> L43
        return -15;
    L20:
        LogUtils.d("ModelDistUtils", CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(CryptoUtils.hexStringToByteArray(r18.f1493f), CryptoConst.ALGORITHM_SHA256)));     // Catch: Throwable -> L37
        byte[] r19 = AES.gcmXcrypt(2, CryptoUtils.hexStringToByteArray(r18.f1493f), null, CryptoUtils.hexStringToByteArray(r18.f1491d), CryptoUtils.hexStringToByteArray(r13));     // Catch: Throwable -> L37
        if (r19 != null) goto L23;
    L33:
        LogUtils.e("ModelDistUtils", "decrypt FEKCipher failed.");     // Catch: Throwable -> L37
        r15.close();     // Catch: IOException -> L43
        return -4;
    L23:
        if (r19.length != 32) goto L33;
        LogUtils.d("ModelDistUtils", "FEK: " + CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(r19, CryptoConst.ALGORITHM_SHA256)));     // Catch: Throwable -> L37
        int r20 = ChaCha20.decryptStreamWithPoly1305(new SecretKeySpec(r19, CryptoConst.ALGORITHM_CHACHA20), r16.f1473a, r16.f1474b, r17, r11, r12);     // Catch: Throwable -> L37
        if (r20 == 0) goto L30;
        LogUtils.e("ModelDistUtils", "decrypt model cipher failed, ret: " + r20);     // Catch: Throwable -> L37
        r15.close();     // Catch: IOException -> L43
        return r20;
    L30:
        int r21 = a(r11, r15.readLong(), r12);     // Catch: Throwable -> L37
        r15.close();     // Catch: IOException -> L43
        return r21;
    L37:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L40
    L42:
        throw th;     // Catch: IOException -> L43
    L40:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L43
    L43:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "decryptModelByFEKCipher failed, exception: " + e.getMessage());
        return -100;
    }

    public static int a(InputStream r10, long r11, OutputStream r12) {
        byte[] r13 = new byte[32768];
    L4:
        if (r11 <= 0) goto L11;
        int r14 = r10.read(r13, 0, (int) Math.min(32768, r11));     // Catch: IOException -> L13
        if (r14 == (-1)) goto L8;
        r12.write(r13, 0, r14);     // Catch: IOException -> L13
        r11 = r11 - ((long) r14);     // Catch: IOException -> L13
        goto L4
    L8:
        LogUtils.e("ModelDistUtils", "InputStream ended before reading the required length!!");     // Catch: IOException -> L13
        return -1;
    L13:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "concatModelPlainData failed, exception: " + e.getMessage());
        return -1;
    L11:
        r12.flush();     // Catch: IOException -> L13
        return 0;
    }

    public static ModelInitResult a(List<Certificate> r10, boolean r11) {
        if (r10 != null) goto L5;
    L16:
        StringBuilder r12 = new StringBuilder();
        r12.append("Invalid certs: ");
        if (r10 != null) goto L19;
        String r13 = "null";
    L20:
        r12.append(r13);
        LogUtils.e("ModelDistUtils", r12.toString());
        return new ModelInitResult(-100, "");
    L19:
        r13 = r10.size() + "";
        goto L20
    L5:
        if (r10.size() < 4) goto L16;
        if (r11 == false) goto L11;
        LogUtils.d("ModelDistUtils", "ByteDance device");     // Catch: Exception -> L13
        return new ModelInitResult(0, CertUtils.certsToPemString(r10, r10.size() - 1));
    L11:
        LogUtils.d("ModelDistUtils", "Third-party device");     // Catch: Exception -> L13
        return new ModelInitResult(0, CertUtils.certsToPemString(r10, r10.size()));
    L13:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "Convert certificates to PEM String failed! Exception: " + e.getMessage());
        return new ModelInitResult(-100, "");
    }

    public static d a(DataInputStream r10) {
        int r11 = r10.readInt();     // Catch: Exception -> L20
        if (r11 == 329978795) goto L7;
        LogUtils.e("ModelDistUtils", "magicNum mismatch, excepted: 329978795, actually: " + r11);     // Catch: Exception -> L20
        return null;
    L7:
        byte r12 = r10.readByte();     // Catch: Exception -> L20
        LogUtils.d("ModelDistUtils", "version: " + r12);     // Catch: Exception -> L20
        int r13 = r10.readByte();     // Catch: Exception -> L20
        if (r13 == 12) goto L11;
        LogUtils.e("ModelDistUtils", "Invalid iv len: " + r13);     // Catch: Exception -> L20
        return null;
    L11:
        byte[] r14 = new byte[r13];     // Catch: Exception -> L20
        r10.readFully(r14);     // Catch: Exception -> L20
        LogUtils.d("ModelDistUtils", "dataIVLen: " + r13);     // Catch: Exception -> L20
        int r15 = r10.readInt();     // Catch: Exception -> L20
        if (r15 > 0) goto L14;
    L18:
        LogUtils.e("ModelDistUtils", "Invalid cipherBlockSize: " + r15);     // Catch: Exception -> L20
        return null;
    L14:
        if (r15 > 1048576) goto L18;
        LogUtils.d("ModelDistUtils", "cipherBlockSize: " + r15);     // Catch: Exception -> L20
        return new d(r11, r12, r14, r15);
    L20:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "parseModelHeader failed, exception: " + e.getMessage());
        return null;
    }

    public static e a(String r10, String r11) {
        JSONObject r12 = new JSONObject(r10);     // Catch: Exception -> L17
        String r13 = r12.getString(r11);     // Catch: Exception -> L17
        if (r11.equals(ModelDistConst.EPHEMERAL_PUBLIC_KEY) == false) goto L6;
        LogUtils.d("ModelDistUtils", "EPHEMERAL_PUBLIC_KEY");     // Catch: Exception -> L17
        r13 = CryptoUtils.byteArrayToHexString(Base64.getUrlDecoder().decode(r13));     // Catch: Exception -> L17
    L7:
        String r14 = r13;
        LogUtils.d("ModelDistUtils", "pubKey: " + r14);     // Catch: Exception -> L17
        ByteBuffer r15 = ByteBuffer.wrap(Base64.getUrlDecoder().decode(r12.getString(ModelDistConst.DATA_KEY_CIPHER)));     // Catch: Exception -> L17
        int r16 = r15.getInt();     // Catch: Exception -> L17
        if (r16 == 329978795) goto L11;
        LogUtils.e("ModelDistUtils", "MagicNum: " + r16 + " mismatch!!");     // Catch: Exception -> L17
        return null;
    L11:
        byte r17 = r15.get();     // Catch: Exception -> L17
        LogUtils.d("ModelDistUtils", "version: " + r17);     // Catch: Exception -> L17
        int r18 = r15.get();     // Catch: Exception -> L17
        if (r18 == 12) goto L15;
        LogUtils.e("ModelDistUtils", "Invalid ivLen: " + r18);     // Catch: Exception -> L17
        return null;
    L15:
        LogUtils.d("ModelDistUtils", "ivLen: " + r18);     // Catch: Exception -> L17
        byte[] r19 = new byte[r18];     // Catch: Exception -> L17
        r15.get(r19);     // Catch: Exception -> L17
        LogUtils.d("ModelDistUtils", "FEK IV: " + CryptoUtils.byteArrayToHexString(r19));     // Catch: Exception -> L17
        byte[] r20 = new byte[48];     // Catch: Exception -> L17
        r15.get(r20);     // Catch: Exception -> L17
        LogUtils.d("ModelDistUtils", "FEK Cipher: " + CryptoUtils.byteArrayToHexString(r20));     // Catch: Exception -> L17
        return new e(r16, r17, r19, r20, r14);
    L6:
        LogUtils.d("ModelDistUtils", "PLATFORM_BUSINESS_PUBLIC_KEY");     // Catch: Exception -> L17
    L17:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "parseModelKeyCipher failed! exception: " + e.getMessage());
        return null;
    }

    public static i a(Context r10, String r11) {
        j r12 = j.a();
        if (b(r10, r11) == true) goto L5;
        Object r13 = f1471a.computeIfAbsent(r11, i2.a.f9375a);
        monitor-enter(r13);
    L20:
        th = move-exception;
        throw th;
    L9:
        if (b(r10, r11) == false) goto L13;
        i r14 = a(r10, r11, r12);     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        return r14;
    L13:
        SecureRandom r15 = new SecureRandom();     // Catch: Throwable -> L20
        byte[] r16 = new byte[32];     // Catch: Throwable -> L20
        byte[] r17 = new byte[12];     // Catch: Throwable -> L20
        r15.nextBytes(r16);     // Catch: Throwable -> L20
        r15.nextBytes(r17);     // Catch: Throwable -> L20
        i r18 = new i();     // Catch: Throwable -> L20
        r18.f1488a = r11;     // Catch: Throwable -> L20
        r18.f1489b = "AESKey";     // Catch: Throwable -> L20
        r18.f1493f = CryptoUtils.byteArrayToHexString(r16);     // Catch: Throwable -> L20
        r18.f1491d = CryptoUtils.byteArrayToHexString(r17);     // Catch: Throwable -> L20
        if (r12.a(r10, r18, new Bundle()).f1470a == 0) goto L18;
        LogUtils.e("ModelDistUtils", "Save key&iv to SecretDataService failed.");     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        return null;
    L18:
        monitor-exit(r13);     // Catch: Throwable -> L20
        return r18;
    L5:
        return a(r10, r11, r12);
    }

    public static i a(Context r10, String r11, j r12) {
        Bundle r13 = new Bundle();
        r13.putInt("query_mode", 2);
        h r14 = r12.a(r10, r11, r13);
        if (r14.f1486a == 0) goto L6;
        r14 = r12.a(r10, r11, r13);
    L6:
        if (r14.f1486a == 0) goto L8;
    L11:
        LogUtils.e("ModelDistUtils", "Query the data of the alias failed, errorCode: " + r14.f1486a);
        return null;
    L8:
        if (r14.f1487b.size() != 1) goto L11;
        return r14.f1487b.get(0);
    }

    public static boolean a(String r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if (r10.isEmpty() == true) goto L8;
        if (r10.length() > 128) goto L8;
        return true;
    }

    public static byte[] a(Context r11, InputStream r12, String r13, String r14) {
        LogUtils.d("ModelDistUtils", "decryptModelByFEKCipher enter");
        DataInputStream r10 = new DataInputStream(r12);     // Catch: IOException -> L46
        LogUtils.i("ModelDistUtils", "in.available(): " + r12.available());     // Catch: Throwable -> L40
        d r15 = a(r10);     // Catch: Throwable -> L40
        if (r15 != null) goto L9;
        LogUtils.e("ModelDistUtils", "parseModelHeader failed.");     // Catch: Throwable -> L40
        byte[] r16 = new byte[0];     // Catch: Throwable -> L40
        r10.close();     // Catch: IOException -> L46
        return r16;
    L9:
        int r17 = r10.readInt();     // Catch: Throwable -> L40
        if (r17 >= 0) goto L14;
        LogUtils.e("ModelDistUtils", "Model cipher length is invalid: " + r17);     // Catch: Throwable -> L40
        byte[] r18 = new byte[0];     // Catch: Throwable -> L40
        r10.close();     // Catch: IOException -> L46
        return r18;
    L14:
        LogUtils.d("ModelDistUtils", "cipherLen: " + r17);     // Catch: Throwable -> L40
        ByteArrayOutputStream r19 = new ByteArrayOutputStream();     // Catch: Throwable -> L40
        i r110 = a(r11, r14);     // Catch: Throwable -> L40
        if (r110 != null) goto L19;
        LogUtils.e("ModelDistUtils", "Get external device key failed.");     // Catch: Throwable -> L40
        byte[] r111 = new byte[0];     // Catch: Throwable -> L40
        r10.close();     // Catch: IOException -> L46
        return r111;
    L19:
        LogUtils.d("ModelDistUtils", CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(CryptoUtils.hexStringToByteArray(r110.f1493f), CryptoConst.ALGORITHM_SHA256)));     // Catch: Throwable -> L40
        byte[] r112 = AES.gcmXcrypt(2, CryptoUtils.hexStringToByteArray(r110.f1493f), null, CryptoUtils.hexStringToByteArray(r110.f1491d), CryptoUtils.hexStringToByteArray(r13));     // Catch: Throwable -> L40
        if (r112 != null) goto L22;
    L37:
        LogUtils.e("ModelDistUtils", "decrypt FEKCipher failed.");     // Catch: Throwable -> L40
        byte[] r113 = new byte[0];     // Catch: Throwable -> L40
        r10.close();     // Catch: IOException -> L46
        return r113;
    L22:
        if (r112.length != 32) goto L37;
        LogUtils.d("ModelDistUtils", "FEK: " + CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(r112, CryptoConst.ALGORITHM_SHA256)));     // Catch: Throwable -> L40
        int r114 = ChaCha20.decryptStreamWithPoly1305(new SecretKeySpec(r112, CryptoConst.ALGORITHM_CHACHA20), r15.f1473a, r15.f1474b, r17, r12, r19);     // Catch: Throwable -> L40
        if (r114 == 0) goto L29;
        LogUtils.e("ModelDistUtils", "decrypt model cipher failed, ret: " + r114);     // Catch: Throwable -> L40
        byte[] r115 = new byte[0];     // Catch: Throwable -> L40
        r10.close();     // Catch: IOException -> L46
        return r115;
    L29:
        int r116 = a(r12, r10.readLong(), r19);     // Catch: Throwable -> L40
        if (r116 == 0) goto L34;
        LogUtils.e("ModelDistUtils", "concat model plain data failed, ret: " + r116);     // Catch: Throwable -> L40
        byte[] r117 = new byte[0];     // Catch: Throwable -> L40
        r10.close();     // Catch: IOException -> L46
        return r117;
    L34:
        byte[] r118 = r19.toByteArray();     // Catch: Throwable -> L40
        r10.close();     // Catch: IOException -> L46
        return r118;
    L40:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L43
    L45:
        throw th;     // Catch: IOException -> L46
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L46
    L46:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "decryptModelByFEKCipher failed, exception: " + e.getMessage());
        return new byte[0];
    }

    public static /* synthetic */ Object b(String r10) {
        return new Object();
    }

    public static boolean b(Context r10, String r11) {
        j r12 = j.a();
        Bundle r13 = new Bundle();
        r13.putInt("query_mode", 0);
        h r14 = r12.a(r10, r11, r13);
        int r15 = r14.f1486a;
        if (r15 == 0) goto L8;
        if (r15 == (-5)) goto L8;
        r14 = r12.a(r10, r11, r13);
    L8:
        if (r14.f1486a != 0) goto L11;
        return true;
    L11:
        return false;
    }
}
