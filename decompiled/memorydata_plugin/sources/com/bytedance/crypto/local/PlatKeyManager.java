package com.bytedance.crypto.local;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.a.i;
import com.bytedance.crypto.a.j;
import com.bytedance.crypto.a.k;
import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.crypto.utils.CommonUtils;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PlatKeyManager {
    private static final String PLATFORM_ECC_KEY_ALIAS = "local_platform_ecc_key";
    public static final String TAG = "PlatKeyManager";
    private static volatile PlatKeyManager keyManager;
    private KeyPair eccKeyPair;

    public PlatKeyManager() {
        this.eccKeyPair = null;
    }

    private static KeyPair generateECCKeyPair() {
        KeyPairGenerator r0 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC);
        r0.initialize(new ECGenParameterSpec("secp256r1"));
        return r0.generateKeyPair();
    }

    public static PlatKeyManager getInstance() {
        if (keyManager != null) goto L15;
        monitor-enter(PlatKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (keyManager != null) goto L9;
        keyManager = new PlatKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PlatKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return keyManager;
    }

    private boolean isECCKeyPairExist(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Bundle r5 = new Bundle();
        r5.putInt("query_mode", 0);
        if (k.a().a(r3, PLATFORM_ECC_KEY_ALIAS, r5).f2222a == 0) goto L5;
        return false;
    L5:
        return true;
    }

    private KeyPair loadECCKeyPair(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        boolean r0 = isECCKeyPairExist(r6);
        String r1 = TAG;
        LogUtils.i(r1, "Load ECC keypair result:" + r0);
        if (r0 == true) goto L5;
        KeyPair r2 = generateECCKeyPair();     // Catch: Exception -> L11
        if (saveECCKeyPair(r6, r2) == true) goto L10;
        LogUtils.e(r1, "Save ECC keypair failed, use generated one temporarily!!");
    L10:
        return r2;
    L11:
        e = move-exception;
        LogUtils.e(TAG, "Generate ECC keypair failed!!", e);
        return null;
    L5:
        return queryECCKeyPair(r6);
    }

    private KeyPair queryECCKeyPair(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Bundle r5 = new Bundle();
        r5.putInt("query_mode", 2);
        i r6 = k.a().a(r3, PLATFORM_ECC_KEY_ALIAS, r5);
        if (r6.f2222a == 0) goto L6;
        LogUtils.e(TAG, "Query ECC keypair failed!!");
        return null;
    L6:
        List<j> r7 = r6.f2223b;
        if (r7 != null) goto L9;
    L26:
        LogUtils.e(TAG, "Query ECC keypair result is empty!!");
        return null;
    L9:
        if (r7.isEmpty() == true) goto L26;
        j r8 = (j) ZeusTransformUtils.preCheckCast(r6.f2223b.get(0), j.class, "com.obric.memorydata.plugin");
        byte[] r9 = CryptoUtils.hexStringToByteArray(r8.f);
        byte[] r10 = CryptoUtils.hexStringToByteArray(r8.d);
        if (r9 != null) goto L14;
    L24:
        LogUtils.e(TAG, "ECC keypair data is invalid!!");
        return null;
    L14:
        if (r9.length == 0) goto L24;
        if (r10 == null) goto L24;
        if (r10.length == 0) goto L24;
        KeyFactory r0 = KeyFactory.getInstance(CryptoConst.ALGORITHM_EC);     // Catch: Exception -> L21
        PrivateKey r11 = r0.generatePrivate(new PKCS8EncodedKeySpec(r9));     // Catch: Exception -> L21
        return new KeyPair(r0.generatePublic(new X509EncodedKeySpec(r10)), r11);
    L21:
        e = move-exception;
        LogUtils.e(TAG, "Restore ECC keypair failed!!", e);
        return null;
    }

    private boolean saveECCKeyPair(Context r2, KeyPair r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        j r4 = new j();
        r4.f2224a = PLATFORM_ECC_KEY_ALIAS;
        r4.f2225b = "local_key";
        r4.f = CryptoUtils.byteArrayToHexString(r3.getPrivate().getEncoded());
        r4.d = CryptoUtils.byteArrayToHexString(r3.getPublic().getEncoded());
        if (k.a().a(r1, r4, new Bundle()).f2203a == 0) goto L6;
        LogUtils.e(TAG, "Store ECC keypair failed!!");
        return false;
    L6:
        return true;
    }

    public byte[] decryptByPlatformKey(Context r6, byte[] r7) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (FrameworkSecurityCompat.hasPlatformKeyManager() == true) goto L8;
        String r8 = TAG;
        String r9 = "PlatformKeyManager is unavailable";
    L5:
        LogUtils.e(r8, r9);
    L7:
        return new byte[0];
    L8:
        if (r7 != 0) goto L10;
    L38:
        r8 = TAG;
        r9 = "dataKeyCipher is null or empty";
        goto L5
    L10:
        if (r7.length == 0) goto L38;
        if (1 <= r7.length) goto L15;
    L14:
        LogUtils.e(TAG, "Invalid dataKeyCipher length for productName");
        goto L7
    L15:
        int r10 = r7[0];
        int r3 = r10 + 1;
        if (r3 > r7.length) goto L14;
        if (r10 < 0) goto L14;
        String r1 = new String(r7, 1, r10, StandardCharsets.UTF_8);
        String r11 = TAG;
        LogUtils.i(r11, "productName:" + r1);
        int r2 = r3 + 1;
        if (r2 <= r7.length) goto L23;
        String r12 = "Invalid dataKeyCipher length for pubKeyDataLength";
    L22:
        LogUtils.e(r11, r12);
        goto L7
    L23:
        int r4 = r7[r3];
        int r13 = r2 + r4;
        if (r13 > r7.length) goto L37;
        if (r4 < 0) goto L37;
        byte[] r14 = new byte[r4];
        System.arraycopy(r7, r2, r14, 0, r4);
        if ((r13 + 16) <= r7.length) goto L30;
        r12 = "Invalid dataKeyCipher length for dataKeyCipherBytes";
        goto L22
    L30:
        int r15 = r7.length - r13;
        byte[] r16 = new byte[r15];
        System.arraycopy(r7, r13, r16, 0, r15);
        byte[] r17 = FrameworkSecurityCompat.platformKeyDecrypt(r5, FrameworkSecurityCompat.PlatformKeyConst.PLATFORM_SM8750(), r16, r14, new Bundle());
        if (r17 != null) goto L33;
    L36:
        r12 = "Data key decrypt failed!!";
        goto L22
    L33:
        if (r17.length == 0) goto L36;
        return r17;
    L37:
        r12 = "Invalid dataKeyCipher length for pubKeyData";
        goto L22
    }

    public byte[] encryptByPlatformKey(Context r7, byte[] r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (FrameworkSecurityCompat.hasPlatformKeyManager() == true) goto L8;
        String r6 = TAG;
        String r10 = "PlatformKeyManager is unavailable";
    L5:
        LogUtils.e(r6, r10);
        return new byte[0];
    L8:
        if (this.eccKeyPair != null) goto L10;
        this.eccKeyPair = loadECCKeyPair(r9);
    L10:
        KeyPair r11 = this.eccKeyPair;
        if (r11 != null) goto L13;
        r6 = TAG;
        r10 = "Load ECC keypair failed!!";
        goto L5
    L13:
        byte[] r12 = CryptoUtils.parseECCPublicKey(r11.getPublic().getEncoded());
        byte[] r13 = FrameworkSecurityCompat.platformKeyEncrypt(r9, FrameworkSecurityCompat.PlatformKeyConst.PLATFORM_SM8750(), r8, r12, new Bundle());
        if (r13 != null) goto L16;
    L20:
        r6 = TAG;
        r10 = "Data key encrypt failed!!";
        goto L5
    L16:
        if (r13.length == 0) goto L20;
        String r14 = CommonUtils.getSystemProperty(PlatformConst.PROP_PRODUCT_TYPE);
        int r0 = r14.getBytes(StandardCharsets.UTF_8).length;
        int r2 = r0 + 1;
        int r3 = r2 + 1;
        byte[] r4 = new byte[(r12.length + r3) + r13.length];
        r4[0] = (byte) r0;
        System.arraycopy(r14.getBytes(StandardCharsets.UTF_8), 0, r4, 1, r0);
        r4[r2] = (byte) r12.length;
        System.arraycopy(r12, 0, r4, r3, r12.length);
        System.arraycopy(r13, 0, r4, r3 + r12.length, r13.length);
        return r4;
    }
}
