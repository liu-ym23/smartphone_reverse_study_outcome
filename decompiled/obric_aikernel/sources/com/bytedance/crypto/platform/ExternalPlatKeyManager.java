package com.bytedance.crypto.platform;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.obfuscated.b;
import com.bytedance.crypto.obfuscated.c;
import com.bytedance.crypto.obfuscated.e;
import com.bytedance.crypto.obfuscated.g;
import com.bytedance.crypto.obfuscated.i;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.security.platformlib.PlatformLib;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ExternalPlatKeyManager {
    private static final String TAG = "ExternalPlatKeyManager";
    private static volatile ExternalPlatKeyManager externalPlatKeyManager;

    private ExternalPlatKeyManager() {
    }

    public static ExternalPlatKeyManager getInstance() {
        if (externalPlatKeyManager != null) goto L15;
        monitor-enter(ExternalPlatKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (externalPlatKeyManager != null) goto L9;
        externalPlatKeyManager = new ExternalPlatKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ExternalPlatKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return externalPlatKeyManager;
    }

    public int decryptModelFile(Context r10, InputStream r11, OutputStream r12, String r13) {
        g.a().getClass();
        return c.a().a(r10, r11, r12, r13);
    }

    public int init(Context r14, String r15) {
        String r10 = "";
        g r11 = g.a();
        r11.getClass();
        if (r14 == null) goto L27;
        if (r15 == null) goto L27;
        if (r15.isEmpty() == true) goto L27;
        int r12 = r11.a(r14);
        if (r12 == 0) goto L11;
        LogUtils.e("PlatKeyManagerImpl", "Permission denied, ret: " + r12);
        return -1;
    L11:
        e r16 = b.a(r15, ModelDistConst.PLATFORM_BUSINESS_PUBLIC_KEY);
        if (r16 != null) goto L14;
        LogUtils.e("PlatKeyManagerImpl", "Parse model key cipher failed!!");
        return -8;
    L14:
        PlatformLib r13 = new PlatformLib();
        String r17 = r16.f1477c;
        Bundle r18 = new Bundle();
        r18.putString("pkg_name", r14.getOpPackageName());
        r18.putString(PlatformConst.BUNDLE_KEY_BRAND, Build.BRAND);
        int r19 = Build.VERSION.SDK_INT;
        if (r19 < 31) goto L17;
        r18.putString(PlatformConst.BUNDLE_KEY_SOC_MODEL, Build.SOC_MODEL);
    L23:
        LogUtils.d("PlatKeyManagerImpl", "Build.MANUFACTURER: " + Build.MANUFACTURER);
        LogUtils.d("PlatKeyManagerImpl", "DeviceInfo bundle: " + r18.toString());
        byte[] r110 = r13.init(1, 1, "bdc5afe786f38d4533628da5ea01364dd4a91ae36bb898125f25bde25cd991f2", r17, r18);
        g.f1482c = r110;
        if (r110 == null) goto L26;
        LogUtils.d("PlatKeyManagerImpl", "sharedKeyHash: " + CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(r110, CryptoConst.ALGORITHM_SHA256)));
        return 0;
    L26:
        LogUtils.e("PlatKeyManagerImpl", "init failed");
        return -14;
    L17:
        LogUtils.d("PlatKeyManagerImpl", "Current sdk version: " + r19);
        Class<?> r111 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L20
        r10 = (String) r111.getMethod("get", new Class[]{String.class, String.class}).invoke(r111, new Object[]{PlatformConst.PROP_SOC_MODEL, ""});     // Catch: Exception -> L20
    L22:
        r18.putString(PlatformConst.BUNDLE_KEY_SOC_MODEL, r10);
    L20:
        e = move-exception;
        LogUtils.e("PlatKeyManagerImpl", "getProperty failed, exception: " + e.getMessage());
    L27:
        LogUtils.e("PlatKeyManagerImpl", "Invalid input params.");
        return -2;
    }

    public String reEncryptFEK(Context r10, String r11) {
        g r12 = g.a();
        r12.getClass();
        if (r10 == null) goto L30;
        if (r11 == null) goto L30;
        if (r11.isEmpty() == true) goto L30;
        LogUtils.d("PlatKeyManagerImpl", "reEncryptFEK keyInfo: " + r11);
        if (g.f1482c != null) goto L11;
        String r13 = "The init method failed to be called or executed";
    L31:
        LogUtils.e("PlatKeyManagerImpl", r13);
        return null;
    L11:
        int r14 = r12.a(r10);
        if (r14 == 0) goto L14;
        r13 = "Permission denied, ret: " + r14;
        goto L31
    L14:
        e r15 = b.a(r11, ModelDistConst.PLATFORM_BUSINESS_PUBLIC_KEY);
        if (r15 != null) goto L17;
        r13 = "Parse model key cipher failed!!";
        goto L31
    L17:
        byte[] r16 = AES.gcmXcrypt(2, g.f1482c, null, r15.f1475a, r15.f1476b);
        if (r16.length == 32) goto L20;
        r13 = "decrypt dataKeyCipher failed or dataKey length invalid";
        goto L31
    L20:
        i r17 = b.a(r10, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
        if (r17 != null) goto L23;
        r13 = "prepareExternalDeviceKey failed.";
        goto L31
    L23:
        byte[] r18 = AES.gcmXcrypt(1, CryptoUtils.hexStringToByteArray(r17.f1493f), null, CryptoUtils.hexStringToByteArray(r17.f1491d), r16);
        if (r18 != null) goto L26;
    L29:
        r13 = "Re-encrypt FEK failed.";
        goto L31
    L26:
        if (r18.length == 0) goto L29;
        LogUtils.d("PlatKeyManagerImpl", "reEncrypt FEKCipher: " + CryptoUtils.byteArrayToHexString(r18));
        return CryptoUtils.byteArrayToHexString(r18);
    L30:
        r13 = "Input params is null!!";
        goto L31
    }
}
