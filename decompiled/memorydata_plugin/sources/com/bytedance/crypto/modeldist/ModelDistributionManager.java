package com.bytedance.crypto.modeldist;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.a.b;
import com.bytedance.crypto.a.c;
import com.bytedance.crypto.a.d;
import com.bytedance.crypto.a.e;
import com.bytedance.crypto.a.f;
import com.bytedance.crypto.a.l;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.fekwrap.FekWrapErrorCode;
import com.bytedance.crypto.fekwrap.FekWrapResult;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
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

    public int checkModelIntegrity(InputStream r1) {
        return d.a().a(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [byte[]] */
    public FekWrapResult decryptAndWrapFEK(Context r6, String r7, String r8, String r9) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        byte[] r10 = d.a();
        r10.getClass();
        if (r9 != null) goto L5;
    L6:
        r9 = "secure_loader_model_wrap_key";
    L7:
        byte[] r1 = null;
        if (r5 == null) goto L30;
        if (r7 == null) goto L30;
    L28:
        IllegalArgumentException e = e;
        r10 = 0;
    L68:
        LogUtils.e("ModelDistributionManagerImpl", "decryptAndWrapFEK encode failed: " + e.getMessage());     // Catch: Throwable -> L74
        FekWrapResult r11 = d.a(FekWrapErrorCode.SLFK_BLOB_ENCODE_FAILED, r9);     // Catch: Throwable -> L74
        if (r1 == null) goto L71;
        Arrays.fill(r1, (byte) 0);
    L71:
        if (r10 == 0) goto L80;
        Arrays.fill(r10, (byte) 0);
    L80:
        return r11;
    L26:
        Exception e2 = e;
        r10 = 0;
    L63:
        LogUtils.e("ModelDistributionManagerImpl", "decryptAndWrapFEK failed: " + e2.getMessage());     // Catch: Throwable -> L74
        r11 = d.a(-100, r9);     // Catch: Throwable -> L74
        if (r1 == null) goto L66;
        Arrays.fill(r1, (byte) 0);
    L66:
        if (r10 == 0) goto L80;
        Arrays.fill(r10, (byte) 0);
    L24:
        th = th;
        r10 = 0;
    L75:
        if (r1 == null) goto L77;
        Arrays.fill(r1, (byte) 0);
    L77:
        if (r10 == 0) goto L79;
        Arrays.fill(r10, (byte) 0);
    L79:
        throw th;
    L11:
        if (r7.isEmpty() == true) goto L30;
        if (r8 != null) goto L15;
    L23:
        int r3 = -2003;
    L31:
        if (r3 != 0) goto L85;
        d.a r12 = r10.a(r5, r7, r8);     // Catch: Throwable -> L24 Exception -> L26 IllegalArgumentException -> L28
        int r13 = r12.f2208a;     // Catch: Throwable -> L24 Exception -> L26 IllegalArgumentException -> L28
        if (r13 != 0) goto L86;
        byte[] r14 = r12.f2209b;     // Catch: Throwable -> L24 Exception -> L26 IllegalArgumentException -> L28
        if (r14 == null) goto L53;
    L61:
        e = move-exception;
        r1 = r14;
        e = e;
        r10 = 0;
    L59:
        e = move-exception;
        r1 = r14;
        e2 = e;
        r10 = 0;
    L57:
        th = move-exception;
        r1 = r14;
        th = th;
        r10 = 0;
        goto L75
    L39:
        if (r14.length != 32) goto L53;
        byte[] r2 = l.a(2, r9);     // Catch: Throwable -> L57 Exception -> L59 IllegalArgumentException -> L61
        b.a r15 = b.a(r9, r14, r2);     // Catch: Throwable -> L57 Exception -> L59 IllegalArgumentException -> L61
        int r16 = r15.f2204a;     // Catch: Throwable -> L57 Exception -> L59 IllegalArgumentException -> L61
        if (r16 == 0) goto L47;
        FekWrapResult r17 = d.a(r16, r9);     // Catch: Throwable -> L57 Exception -> L59 IllegalArgumentException -> L61
        Arrays.fill(r14, (byte) 0);
        if (r2 == null) goto L88;
        Arrays.fill(r2, (byte) 0);
    L88:
        return r17;
    L47:
        FekWrapResult r18 = new FekWrapResult(0, r9, l.a(2, r15.f2205b, r15.c));     // Catch: Throwable -> L57 Exception -> L59 IllegalArgumentException -> L61
        Arrays.fill(r14, (byte) 0);
        if (r2 == null) goto L87;
        Arrays.fill(r2, (byte) 0);
    L87:
        return r18;
    L53:
        r17 = d.a(FekWrapErrorCode.FEK_RECOVER_INVALID_LENGTH, r9);     // Catch: Throwable -> L57 Exception -> L59 IllegalArgumentException -> L61
        if (r14 == null) goto L88;
        Arrays.fill(r14, (byte) 0);
        goto L88
    L86:
        return d.a(r13, r9);
    L85:
        return d.a(r3, r9);
    L15:
        if (r8.isEmpty() == true) goto L23;
        if (c.a(r8) == false) goto L30;
        if (c.a(r9) == false) goto L30;
        r3 = 0;
    L30:
        r3 = -2;
    L74:
        th = th;
        goto L75
    L5:
        if (r9.isEmpty() == false) goto L7;
        goto L6
    }

    public int decryptModelFile(Context r9, InputStream r10, OutputStream r11, String r12, String r13) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        d.a().getClass();
        if (r8 == null) goto L40;
        if (r10 == null) goto L40;
        if (r11 == null) goto L40;
        if (c.a(r12) == false) goto L40;
        if (r13 == null) goto L40;
        DataInputStream r1 = new DataInputStream(r10);     // Catch: IOException -> L38
        e r2 = c.a(r1);     // Catch: Throwable -> L32
        int r3 = -8;
        if (r2 != null) goto L15;
        String r14 = "Parse model file header information failed.";
    L14:
        LogUtils.e("ModelDistributionManagerImpl", r14);     // Catch: Throwable -> L32
    L30:
        r1.close();     // Catch: IOException -> L38
        return r3;
    L15:
        f r15 = c.a(r13, ModelDistConst.EPHEMERAL_PUBLIC_KEY);     // Catch: Throwable -> L32
        if (r15 != null) goto L18;
        r14 = "Parse model key cipher failed.";
        goto L14
    L18:
        Bundle r4 = new Bundle();     // Catch: Throwable -> L32
        r4.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());     // Catch: Throwable -> L32
        r4.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);     // Catch: Throwable -> L32
        FrameworkSecurityCompat.KmResult r16 = FrameworkSecurityCompat.keyAgreement(r8, r12, CryptoUtils.hexStringToByteArray(r15.c), r4);     // Catch: Throwable -> L32
        if (r16.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L21;
        LogUtils.e("ModelDistributionManagerImpl", "keyAgreement failed, system errorCode: " + r16.getResultCode());     // Catch: Throwable -> L32
        r3 = -100;
        goto L30
    L21:
        byte[] r17 = AES.gcmXcrypt(2, r16.getOutData(), null, r15.f2212a, r15.f2213b);     // Catch: Throwable -> L32
        if (r17.length == 32) goto L24;
        LogUtils.e("ModelDistributionManagerImpl", "decrypt dataKeyCipher failed or dataKey length invalid");     // Catch: Throwable -> L32
        r3 = -4;
        goto L30
    L24:
        SecretKeySpec r18 = new SecretKeySpec(r17, CryptoConst.ALGORITHM_CHACHA20);     // Catch: Throwable -> L32
        int r5 = r1.readInt();     // Catch: Throwable -> L32
        LogUtils.d("ModelDistributionManagerImpl", "cipherLength: " + r5);     // Catch: Throwable -> L32
        int r19 = ChaCha20.decryptStreamWithPoly1305(r18, r2.f2210a, r2.f2211b, r5, r10, r11);     // Catch: Throwable -> L32
        if (r19 == 0) goto L29;
        LogUtils.e("ModelDistributionManagerImpl", "decrypt model cipher failed, ret: " + r19);     // Catch: Throwable -> L32
        r1.close();     // Catch: IOException -> L38
        return r19;
    L29:
        r3 = c.a(r10, r1.readLong(), r11);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L35
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

    public int deleteAttestKey(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        d.a().getClass();
        if (r1 != null) goto L5;
    L8:
        return -2;
    L5:
        if (c.a(r3) == false) goto L8;
        return FrameworkSecurityCompat.deleteKey(r1, r3, new Bundle());
    }

    public ModelInitResult initModelRequest(Context r2, String r3, Bundle r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return d.a().a(r1, r3, "", r4);
    }

    public ModelInitResult initModelRequestV2(Context r2, String r3, String r4, Bundle r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return d.a().a(r1, r3, r4, r5);
    }
}
