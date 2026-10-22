package com.bytedance.crypto.modeldist;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ECDHHelper;
import com.bytedance.crypto.engine.KeyPairHelper;
import com.bytedance.crypto.network.ChallengeManager;
import com.bytedance.crypto.obfuscated.b;
import com.bytedance.crypto.obfuscated.c;
import com.bytedance.crypto.obfuscated.d;
import com.bytedance.crypto.obfuscated.e;
import com.bytedance.crypto.obfuscated.i;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ExternalModelDistManager {
    public static final String TAG = "ExternalModelDistManager";
    private static volatile ExternalModelDistManager externalModelDistManager;

    private ExternalModelDistManager() {
    }

    public static ExternalModelDistManager getInstance() {
        if (externalModelDistManager != null) goto L15;
        monitor-enter(ExternalModelDistManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (externalModelDistManager != null) goto L9;
        externalModelDistManager = new ExternalModelDistManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ExternalModelDistManager.class);     // Catch: Throwable -> L11
    L15:
        return externalModelDistManager;
    }

    public long calculateModelSize(InputStream r10) {
        c.a().getClass();
        ConcurrentHashMap<String, Object> r11 = b.f1471a;
        if (r10 != null) goto L38;
        LogUtils.e("ModelDistUtils", "InputStream is null.");
        return -2;
    L38:
        DataInputStream r12 = new DataInputStream(r10);     // Catch: IOException -> L32
        d r13 = b.a(r12);     // Catch: Throwable -> L26
        if (r13 != null) goto L9;
        String r14 = "parseModelHeader failed.";
    L17:
        LogUtils.e("ModelDistUtils", r14);     // Catch: Throwable -> L26
        long r15 = -8;
    L24:
        r12.close();     // Catch: IOException -> L32
        return r15;
    L9:
        int r16 = r12.readInt();     // Catch: Throwable -> L26
        if (r16 >= 0) goto L14;
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L26
        r17.append("Model cipher length is invalid: ");     // Catch: Throwable -> L26
        r17.append(r16);     // Catch: Throwable -> L26
    L13:
        r14 = r17.toString();     // Catch: Throwable -> L26
        goto L17
    L14:
        r12.skip(r16);     // Catch: Throwable -> L26
        long r18 = r12.readLong();     // Catch: Throwable -> L26
        if (r18 >= 0) goto L18;
        r17 = new StringBuilder();     // Catch: Throwable -> L26
        r17.append("Model cipher length is invalid: ");     // Catch: Throwable -> L26
        r17.append(r18);     // Catch: Throwable -> L26
        goto L13
    L18:
        int r19 = r13.f1474b;     // Catch: Throwable -> L26
        int r20 = r19 + 16;     // Catch: Throwable -> L26
        int r21 = r16 / r20;     // Catch: Throwable -> L26
        int r22 = r16 % r20;     // Catch: Throwable -> L26
        int r23 = r21 * r19;
        if (r22 == 0) goto L23;
        r23 = r23 + (r22 - 16);
    L23:
        r15 = ((long) r23) + r18;
    L26:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: IOException -> L32
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L32
    L32:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "calculateModelSize failed, exception: " + e.getMessage());
        return -100;
    }

    public int checkModelIntegrity(InputStream r10) {
        return c.a().a(r10);
    }

    public int decryptModelFile(Context r10, InputStream r11, OutputStream r12, String r13) {
        return c.a().a(r10, r11, r12, r13);
    }

    public int deleteAttestKey(Context r10, String r11) {
        c.a().getClass();
        if (r10 != null) goto L5;
    L8:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return -2;
    L5:
        if (b.a(r11) == false) goto L8;
        KeyPairHelper.deleteKey(r11);
        return 0;
    }

    public ModelInitResult initModelRequest(Context r10, String r11, Bundle r12) {
        c.a().getClass();
        if (r10 != null) goto L5;
    L36:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        ModelInitResult r13 = new ModelInitResult(-2, "");
    L38:
        return r13;
    L5:
        if (b.a(r11) == false) goto L36;
        if (r12 == null) goto L36;
        int r14 = r12.getInt(ModelDistConst.KEY_ATTEST_STRATEGY, 0);
        Certificate[] r15 = null;
        Certificate[] r16 = KeyPairHelper.getCertificateChain(r11);     // Catch: CloudTransException -> L11
    L13:
        if (r16 != null) goto L15;
    L22:
        String r17 = ChallengeManager.requestChallenge();
        if (r17 != null) goto L25;
    L31:
        String r18 = "Request challenge failed!!";
    L32:
        LogUtils.e("ModelDistUtils", r18);
    L33:
        if (r15 != null) goto L35;
        r13 = new ModelInitResult(-100, "");
        goto L38
    L35:
        List r19 = Arrays.asList(r15);
    L43:
        return b.a(r19, false);
    L25:
        if (r17.isEmpty() == true) goto L31;
        KeyPairHelper.deleteKey(r11);     // Catch: CloudTransException -> L29
        KeyPairHelper.generateECDSAKeyPair(r11, r17);     // Catch: CloudTransException -> L29
        r15 = KeyPairHelper.getCertificateChain(r11);     // Catch: CloudTransException -> L29
    L29:
        e = move-exception;
        r18 = "generateECDSAKeyPair failed, errorCode: " + e.getErrorCode() + ", message: " + e.getMessage();
        goto L32
    L15:
        if (r14 != 1) goto L19;
        r19 = Arrays.asList(r16);
        goto L43
    L19:
        if (r14 != 2) goto L21;
        r13 = new ModelInitResult(-13, "");
        goto L38
    L21:
        LogUtils.i("ModelDistributionManagerImpl", "Re-generating certificate chain as per strategy.");
    L11:
        e = move-exception;
        LogUtils.e("ModelDistributionManagerImpl", "getCertificateChain of alias: " + r11 + " failed, exception: " + e.getMessage());
        r16 = null;
        goto L13
    }

    public String reEncryptFEK(Context r10, String r11, String r12) {
        c.a().getClass();
        if (r10 != null) goto L5;
    L30:
        String r13 = "Invalid input params.";
    L31:
        LogUtils.e("ModelDistributionManagerImpl", r13);
        return null;
    L5:
        if (b.a(r11) == false) goto L30;
        if (r12 == null) goto L30;
        LogUtils.d("ModelDistributionManagerImpl", "reEncryptFEK keyInfo: " + r12);
        e r14 = b.a(r12, ModelDistConst.EPHEMERAL_PUBLIC_KEY);
        if (r14 != null) goto L33;
        r13 = "Parse model key cipher failed!!";
        goto L31
    L33:
        byte[] r15 = ECDHHelper.generateSharedSecret(KeyPairHelper.loadKeyPair(r11).getPrivate(), CryptoUtils.byteArrayToECPublicKey(CryptoUtils.hexStringToByteArray(r14.f1477c)));     // Catch: Exception -> L25 CloudTransException -> L27
        LogUtils.d("ModelDistributionManagerImpl", "sharedSecret.length: " + r15.length);     // Catch: Exception -> L25 CloudTransException -> L27
        byte[] r16 = AES.gcmXcrypt(2, r15, null, r14.f1475a, r14.f1476b);
        if (r16.length == 32) goto L15;
        r13 = "decrypt dataKeyCipher failed or dataKey length invalid";
        goto L31
    L15:
        i r17 = b.a(r10, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
        if (r17 != null) goto L18;
        r13 = "prepareExternalDeviceKey failed.";
        goto L31
    L18:
        byte[] r18 = AES.gcmXcrypt(1, CryptoUtils.hexStringToByteArray(r17.f1493f), null, CryptoUtils.hexStringToByteArray(r17.f1491d), r16);
        if (r18 != null) goto L21;
    L24:
        r13 = "Re-encrypt FEK failed.";
        goto L31
    L21:
        if (r18.length == 0) goto L24;
        return CryptoUtils.byteArrayToHexString(r18);
    L27:
        e = move-exception;
        StringBuilder r19 = new StringBuilder();
        r19.append("loadKeyPair failed, errorCode: ");
        r19.append(e.getErrorCode());
        String r20 = ", message: ";
        Exception r21 = e;
    L29:
        r19.append(r20);
        r19.append(r21.getMessage());
        r13 = r19.toString();
    L25:
        e = move-exception;
        r19 = new StringBuilder();
        r20 = "generateSharedSecret failed, exception: ";
        r21 = e;
        goto L29
    }
}
