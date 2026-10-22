package com.bytedance.crypto.modeldist;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.obfuscated.b;
import com.bytedance.crypto.obfuscated.c;
import com.bytedance.crypto.obfuscated.d;
import com.bytedance.crypto.obfuscated.e;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class ModelDistributionManager {
    private static final String TAG = "ModelDistributionManager";
    private static volatile ModelDistributionManager modelDistributionManager;

    private ModelDistributionManager() {
    }

    public static ModelDistributionManager getInstance() {
        if (modelDistributionManager != null) goto L15;
        monitor-enter(ModelDistributionManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (modelDistributionManager != null) goto L9;
        modelDistributionManager = new ModelDistributionManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ModelDistributionManager.class);     // Catch: Throwable -> L11
    L15:
        return modelDistributionManager;
    }

    public int checkModelIntegrity(InputStream r10) {
        return c.a().a(r10);
    }

    public int decryptModelFile(Context r10, InputStream r11, OutputStream r12, String r13, String r14) {
        c.a().getClass();
        if (r10 == null) goto L40;
        if (r11 == null) goto L40;
        if (r12 == null) goto L40;
        if (b.a(r13) == false) goto L40;
        if (r14 == null) goto L40;
        DataInputStream r15 = new DataInputStream(r11);     // Catch: IOException -> L38
        d r16 = b.a(r15);     // Catch: Throwable -> L32
        int r17 = -8;
        if (r16 != null) goto L15;
        String r18 = "Parse model file header information failed.";
    L14:
        LogUtils.e("ModelDistributionManagerImpl", r18);     // Catch: Throwable -> L32
    L30:
        r15.close();     // Catch: IOException -> L38
        return r17;
    L15:
        e r19 = b.a(r14, ModelDistConst.EPHEMERAL_PUBLIC_KEY);     // Catch: Throwable -> L32
        if (r19 != null) goto L18;
        r18 = "Parse model key cipher failed.";
        goto L14
    L18:
        Bundle r20 = new Bundle();     // Catch: Throwable -> L32
        r20.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());     // Catch: Throwable -> L32
        r20.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);     // Catch: Throwable -> L32
        FrameworkSecurityCompat.KmResult r21 = FrameworkSecurityCompat.keyAgreement(r10, r13, CryptoUtils.hexStringToByteArray(r19.f1477c), r20);     // Catch: Throwable -> L32
        if (r21.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L21;
        LogUtils.e("ModelDistributionManagerImpl", "keyAgreement failed, system errorCode: " + r21.getResultCode());     // Catch: Throwable -> L32
        r17 = -100;
        goto L30
    L21:
        byte[] r22 = AES.gcmXcrypt(2, r21.getOutData(), null, r19.f1475a, r19.f1476b);     // Catch: Throwable -> L32
        if (r22.length == 32) goto L24;
        LogUtils.e("ModelDistributionManagerImpl", "decrypt dataKeyCipher failed or dataKey length invalid");     // Catch: Throwable -> L32
        r17 = -4;
        goto L30
    L24:
        SecretKeySpec r110 = new SecretKeySpec(r22, CryptoConst.ALGORITHM_CHACHA20);     // Catch: Throwable -> L32
        int r23 = r15.readInt();     // Catch: Throwable -> L32
        LogUtils.d("ModelDistributionManagerImpl", "cipherLength: " + r23);     // Catch: Throwable -> L32
        int r24 = ChaCha20.decryptStreamWithPoly1305(r110, r16.f1473a, r16.f1474b, r23, r11, r12);     // Catch: Throwable -> L32
        if (r24 == 0) goto L29;
        LogUtils.e("ModelDistributionManagerImpl", "decrypt model cipher failed, ret: " + r24);     // Catch: Throwable -> L32
        r15.close();     // Catch: IOException -> L38
        return r24;
    L29:
        r17 = b.a(r11, r15.readLong(), r12);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L35
    L37:
        throw th;     // Catch: IOException -> L38
    L35:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L38
    L38:
        e = move-exception;
        LogUtils.e("ModelDistributionManagerImpl", "decryptModelFile failed, exception: " + e.getMessage());
        return -100;
    L40:
        LogUtils.e("ModelDistributionManagerImpl", "Input params is invalid.");
        return -2;
    }

    public int deleteAttestKey(Context r10, String r11) {
        c.a().getClass();
        if (r10 != null) goto L5;
    L8:
        return -2;
    L5:
        if (b.a(r11) == false) goto L8;
        return FrameworkSecurityCompat.deleteKey(r10, r11, new Bundle());
    }

    public ModelInitResult initModelRequest(Context r10, String r11, Bundle r12) {
        return c.a().a(r10, r11, "", r12);
    }

    public ModelInitResult initModelRequestV2(Context r10, String r11, String r12, Bundle r13) {
        return c.a().a(r10, r11, r12, r13);
    }
}
