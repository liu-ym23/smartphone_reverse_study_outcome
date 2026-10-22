package com.bytedance.crypto.a;

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
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f2206a = null;

    static {
        f2206a = new ConcurrentHashMap();
    }

    public static int a(Context r9, InputStream r10, OutputStream r11, String r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        LogUtils.d("ModelDistUtils", "decryptModelByFEKCipher enter");
        DataInputStream r2 = new DataInputStream(r10);     // Catch: IOException -> L43
        e r3 = a(r2);     // Catch: Throwable -> L37
        if (r3 != null) goto L9;
        LogUtils.e("ModelDistUtils", "parseModelHeader failed.");     // Catch: Throwable -> L37
        r2.close();     // Catch: IOException -> L43
        return -8;
    L9:
        int r6 = r2.readInt();     // Catch: Throwable -> L37
        if (r6 >= 0) goto L14;
        LogUtils.e("ModelDistUtils", "Model cipher length is invalid: " + r6);     // Catch: Throwable -> L37
        r2.close();     // Catch: IOException -> L43
        return -8;
    L14:
        LogUtils.d("ModelDistUtils", "cipherLen: " + r6);     // Catch: Throwable -> L37
        j r15 = b(r14, r13);     // Catch: Throwable -> L37
        if (r15 != null) goto L20;
        LogUtils.e("ModelDistUtils", "Get external device key failed.");     // Catch: Throwable -> L37
        r2.close();     // Catch: IOException -> L43
        return -15;
    L20:
        LogUtils.d("ModelDistUtils", CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(CryptoUtils.hexStringToByteArray(r15.f), CryptoConst.ALGORITHM_SHA256)));     // Catch: Throwable -> L37
        byte[] r16 = AES.gcmXcrypt(2, CryptoUtils.hexStringToByteArray(r15.f), null, CryptoUtils.hexStringToByteArray(r15.d), CryptoUtils.hexStringToByteArray(r12));     // Catch: Throwable -> L37
        if (r16 != null) goto L23;
    L33:
        LogUtils.e("ModelDistUtils", "decrypt FEKCipher failed.");     // Catch: Throwable -> L37
        r2.close();     // Catch: IOException -> L43
        return -4;
    L23:
        if (r16.length != 32) goto L33;
        LogUtils.d("ModelDistUtils", "FEK: " + CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(r16, CryptoConst.ALGORITHM_SHA256)));     // Catch: Throwable -> L37
        int r17 = ChaCha20.decryptStreamWithPoly1305(new SecretKeySpec(r16, CryptoConst.ALGORITHM_CHACHA20), r3.f2210a, r3.f2211b, r6, r10, r11);     // Catch: Throwable -> L37
        if (r17 == 0) goto L30;
        LogUtils.e("ModelDistUtils", "decrypt model cipher failed, ret: " + r17);     // Catch: Throwable -> L37
        r2.close();     // Catch: IOException -> L43
        return r17;
    L30:
        int r18 = a(r10, r2.readLong(), r11);     // Catch: Throwable -> L37
        r2.close();     // Catch: IOException -> L43
        return r18;
    L37:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L40
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

    public static int a(InputStream r8, long r9, OutputStream r11) {
        byte[] r1 = new byte[32768];
    L4:
        if (r9 <= 0) goto L11;
        int r2 = r8.read(r1, 0, (int) Math.min(32768, r9));     // Catch: IOException -> L13
        if (r2 == (-1)) goto L8;
        r11.write(r1, 0, r2);     // Catch: IOException -> L13
        r9 = r9 - ((long) r2);     // Catch: IOException -> L13
        goto L4
    L8:
        LogUtils.e("ModelDistUtils", "InputStream ended before reading the required length!!");     // Catch: IOException -> L13
        return -1;
    L13:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "concatModelPlainData failed, exception: " + e.getMessage());
        return -1;
    L11:
        r11.flush();     // Catch: IOException -> L13
        return 0;
    }

    public static e a(DataInputStream r8) {
        int r2 = r8.readInt();     // Catch: Exception -> L20
        if (r2 == 329978795) goto L7;
        LogUtils.e("ModelDistUtils", "magicNum mismatch, excepted: 329978795, actually: " + r2);     // Catch: Exception -> L20
        return null;
    L7:
        byte r3 = r8.readByte();     // Catch: Exception -> L20
        LogUtils.d("ModelDistUtils", "version: " + r3);     // Catch: Exception -> L20
        int r4 = r8.readByte();     // Catch: Exception -> L20
        if (r4 == 12) goto L11;
        LogUtils.e("ModelDistUtils", "Invalid iv len: " + r4);     // Catch: Exception -> L20
        return null;
    L11:
        byte[] r5 = new byte[r4];     // Catch: Exception -> L20
        r8.readFully(r5);     // Catch: Exception -> L20
        LogUtils.d("ModelDistUtils", "dataIVLen: " + r4);     // Catch: Exception -> L20
        int r9 = r8.readInt();     // Catch: Exception -> L20
        if (r9 > 0) goto L14;
    L18:
        LogUtils.e("ModelDistUtils", "Invalid cipherBlockSize: " + r9);     // Catch: Exception -> L20
        return null;
    L14:
        if (r9 > 1048576) goto L18;
        LogUtils.d("ModelDistUtils", "cipherBlockSize: " + r9);     // Catch: Exception -> L20
        return new e(r2, r3, r5, r9);
    L20:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "parseModelHeader failed, exception: " + e.getMessage());
        return null;
    }

    public static f a(String r9, String r10) {
        JSONObject r2 = new JSONObject(r9);     // Catch: Exception -> L17
        String r11 = r2.getString(r10);     // Catch: Exception -> L17
        if (r10.equals(ModelDistConst.EPHEMERAL_PUBLIC_KEY) == false) goto L6;
        LogUtils.d("ModelDistUtils", "EPHEMERAL_PUBLIC_KEY");     // Catch: Exception -> L17
        r11 = CryptoUtils.byteArrayToHexString(Base64.getUrlDecoder().decode(r11));     // Catch: Exception -> L17
    L7:
        String r8 = r11;
        LogUtils.d("ModelDistUtils", "pubKey: " + r8);     // Catch: Exception -> L17
        ByteBuffer r12 = ByteBuffer.wrap(Base64.getUrlDecoder().decode(r2.getString(ModelDistConst.DATA_KEY_CIPHER)));     // Catch: Exception -> L17
        int r4 = r12.getInt();     // Catch: Exception -> L17
        if (r4 == 329978795) goto L11;
        LogUtils.e("ModelDistUtils", "MagicNum: " + r4 + " mismatch!!");     // Catch: Exception -> L17
        return null;
    L11:
        byte r5 = r12.get();     // Catch: Exception -> L17
        LogUtils.d("ModelDistUtils", "version: " + r5);     // Catch: Exception -> L17
        int r13 = r12.get();     // Catch: Exception -> L17
        if (r13 == 12) goto L15;
        LogUtils.e("ModelDistUtils", "Invalid ivLen: " + r13);     // Catch: Exception -> L17
        return null;
    L15:
        LogUtils.d("ModelDistUtils", "ivLen: " + r13);     // Catch: Exception -> L17
        byte[] r6 = new byte[r13];     // Catch: Exception -> L17
        r12.get(r6);     // Catch: Exception -> L17
        LogUtils.d("ModelDistUtils", "FEK IV: " + CryptoUtils.byteArrayToHexString(r6));     // Catch: Exception -> L17
        byte[] r7 = new byte[48];     // Catch: Exception -> L17
        r12.get(r7);     // Catch: Exception -> L17
        LogUtils.d("ModelDistUtils", "FEK Cipher: " + CryptoUtils.byteArrayToHexString(r7));     // Catch: Exception -> L17
        return new f(r4, r5, r6, r7, r8);
    L6:
        LogUtils.d("ModelDistUtils", "PLATFORM_BUSINESS_PUBLIC_KEY");     // Catch: Exception -> L17
    L17:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "parseModelKeyCipher failed! exception: " + e.getMessage());
        return null;
    }

    public static j a(Context r4, String r5, k r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Bundle r0 = new Bundle();
        r0.putInt("query_mode", 2);
        i r2 = r6.a(r7, r5, r0);
        if (r2.f2222a == 0) goto L6;
        r2 = r6.a(r7, r5, r0);
    L6:
        if (r2.f2222a == 0) goto L8;
    L11:
        LogUtils.e("ModelDistUtils", "Query the data of the alias failed, errorCode: " + r2.f2222a);
        return null;
    L8:
        if (r2.f2223b.size() != 1) goto L11;
        return (j) ZeusTransformUtils.preCheckCast(r2.f2223b.get(0), j.class, "com.obric.memorydata.plugin");
    }

    public static ModelInitResult a(List<Certificate> r5, boolean r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L16:
        StringBuilder r8 = new StringBuilder().append("Invalid certs: ");
        if (r7 != null) goto L19;
        String r9 = "null";
    L20:
        LogUtils.e("ModelDistUtils", r8.append(r9).toString());
        return new ModelInitResult(-100, "");
    L19:
        r9 = r7.size() + "";
        goto L20
    L5:
        if (r7.size() < 4) goto L16;
        if (r6 == false) goto L11;
        LogUtils.d("ModelDistUtils", "ByteDance device");     // Catch: Exception -> L13
        return new ModelInitResult(0, CertUtils.certsToPemString(r7, r7.size() - 1));
    L11:
        LogUtils.d("ModelDistUtils", "Third-party device");     // Catch: Exception -> L13
        return new ModelInitResult(0, CertUtils.certsToPemString(r7, r7.size()));
    L13:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "Convert certificates to PEM String failed! Exception: " + e.getMessage());
        return new ModelInitResult(-100, "");
    }

    public static boolean a(Context r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        k r0 = k.a();
        Bundle r1 = new Bundle();
        r1.putInt("query_mode", 0);
        i r2 = r0.a(r8, r7, r1);
        int r4 = r2.f2222a;
        if (r4 == 0) goto L8;
        if (r4 == (-5)) goto L8;
        r2 = r0.a(r8, r7, r1);
    L8:
        if (r2.f2222a != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public static boolean a(String r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.isEmpty() == true) goto L8;
        if (r1.length() > 128) goto L8;
        return true;
    }

    public static byte[] a(Context r11, InputStream r12, String r13, String r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        LogUtils.d("ModelDistUtils", "decryptModelByFEKCipher enter");
        DataInputStream r3 = new DataInputStream(r12);     // Catch: IOException -> L46
        LogUtils.i("ModelDistUtils", "in.available(): " + r12.available());     // Catch: Throwable -> L40
        e r4 = a(r3);     // Catch: Throwable -> L40
        if (r4 != null) goto L9;
        LogUtils.e("ModelDistUtils", "parseModelHeader failed.");     // Catch: Throwable -> L40
        byte[] r16 = new byte[0];     // Catch: Throwable -> L40
        r3.close();     // Catch: IOException -> L46
        return r16;
    L9:
        int r7 = r3.readInt();     // Catch: Throwable -> L40
        if (r7 >= 0) goto L14;
        LogUtils.e("ModelDistUtils", "Model cipher length is invalid: " + r7);     // Catch: Throwable -> L40
        byte[] r17 = new byte[0];     // Catch: Throwable -> L40
        r3.close();     // Catch: IOException -> L46
        return r17;
    L14:
        LogUtils.d("ModelDistUtils", "cipherLen: " + r7);     // Catch: Throwable -> L40
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();     // Catch: Throwable -> L40
        j r18 = b(r15, r14);     // Catch: Throwable -> L40
        if (r18 != null) goto L19;
        LogUtils.e("ModelDistUtils", "Get external device key failed.");     // Catch: Throwable -> L40
        byte[] r19 = new byte[0];     // Catch: Throwable -> L40
        r3.close();     // Catch: IOException -> L46
        return r19;
    L19:
        LogUtils.d("ModelDistUtils", CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(CryptoUtils.hexStringToByteArray(r18.f), CryptoConst.ALGORITHM_SHA256)));     // Catch: Throwable -> L40
        byte[] r110 = AES.gcmXcrypt(2, CryptoUtils.hexStringToByteArray(r18.f), null, CryptoUtils.hexStringToByteArray(r18.d), CryptoUtils.hexStringToByteArray(r13));     // Catch: Throwable -> L40
        if (r110 != null) goto L22;
    L37:
        LogUtils.e("ModelDistUtils", "decrypt FEKCipher failed.");     // Catch: Throwable -> L40
        byte[] r111 = new byte[0];     // Catch: Throwable -> L40
        r3.close();     // Catch: IOException -> L46
        return r111;
    L22:
        if (r110.length != 32) goto L37;
        LogUtils.d("ModelDistUtils", "FEK: " + CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(r110, CryptoConst.ALGORITHM_SHA256)));     // Catch: Throwable -> L40
        int r112 = ChaCha20.decryptStreamWithPoly1305(new SecretKeySpec(r110, CryptoConst.ALGORITHM_CHACHA20), r4.f2210a, r4.f2211b, r7, r12, r10);     // Catch: Throwable -> L40
        if (r112 == 0) goto L29;
        LogUtils.e("ModelDistUtils", "decrypt model cipher failed, ret: " + r112);     // Catch: Throwable -> L40
        byte[] r113 = new byte[0];     // Catch: Throwable -> L40
        r3.close();     // Catch: IOException -> L46
        return r113;
    L29:
        int r114 = a(r12, r3.readLong(), r10);     // Catch: Throwable -> L40
        if (r114 == 0) goto L34;
        LogUtils.e("ModelDistUtils", "concat model plain data failed, ret: " + r114);     // Catch: Throwable -> L40
        byte[] r115 = new byte[0];     // Catch: Throwable -> L40
        r3.close();     // Catch: IOException -> L46
        return r115;
    L34:
        byte[] r116 = r10.toByteArray();     // Catch: Throwable -> L40
        r3.close();     // Catch: IOException -> L46
        return r116;
    L40:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L43
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

    public static j b(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        k r0 = k.a();
        if (a(r7, r6) == true) goto L5;
        Object r1 = f2206a.computeIfAbsent(r6, $$Lambda$TlMKf5yq6syCeKRONXzfZ3Brb94.INSTANCE);
        monitor-enter(r1);
    L20:
        th = move-exception;
        throw th;
    L9:
        if (a(r7, r6) == false) goto L13;
        j r8 = a(r7, r6, r0);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        return r8;
    L13:
        SecureRandom r2 = new SecureRandom();     // Catch: Throwable -> L20
        byte[] r3 = new byte[32];     // Catch: Throwable -> L20
        byte[] r4 = new byte[12];     // Catch: Throwable -> L20
        r2.nextBytes(r3);     // Catch: Throwable -> L20
        r2.nextBytes(r4);     // Catch: Throwable -> L20
        j r9 = new j();     // Catch: Throwable -> L20
        r9.f2224a = r6;     // Catch: Throwable -> L20
        r9.f2225b = "AESKey";     // Catch: Throwable -> L20
        r9.f = CryptoUtils.byteArrayToHexString(r3);     // Catch: Throwable -> L20
        r9.d = CryptoUtils.byteArrayToHexString(r4);     // Catch: Throwable -> L20
        if (r0.a(r7, r9, new Bundle()).f2203a == 0) goto L18;
        LogUtils.e("ModelDistUtils", "Save key&iv to SecretDataService failed.");     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        return null;
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L20
        return r9;
    L5:
        return a(r7, r6, r0);
    }

    public static /* synthetic */ Object b(String r0) {
        return new Object();
    }
}
