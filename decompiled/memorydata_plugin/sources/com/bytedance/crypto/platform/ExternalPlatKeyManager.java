package com.bytedance.crypto.platform;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.crypto.a.c;
import com.bytedance.crypto.a.d;
import com.bytedance.crypto.a.f;
import com.bytedance.crypto.a.h;
import com.bytedance.crypto.a.j;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.security.platformlib.PlatformLib;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
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

    public int decryptModelFile(Context r2, InputStream r3, OutputStream r4, String r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        h.a().getClass();
        return d.a().a(r1, r3, r4, r5);
    }

    public int init(Context r18, String r19) {
        String r1 = "";
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        h r4 = h.a();
        r4.getClass();
        if (r2 == null) goto L27;
        if (r19 == null) goto L27;
        if (r19.isEmpty() == true) goto L27;
        int r5 = r4.a(r2);
        if (r5 == 0) goto L11;
        LogUtils.e("PlatKeyManagerImpl", "Permission denied, ret: " + r5);
        return -1;
    L11:
        f r0 = c.a(r19, ModelDistConst.PLATFORM_BUSINESS_PUBLIC_KEY);
        if (r0 != null) goto L14;
        LogUtils.e("PlatKeyManagerImpl", "Parse model key cipher failed!!");
        return -8;
    L14:
        PlatformLib r7 = new PlatformLib();
        String r11 = r0.c;
        Bundle r12 = new Bundle();
        r12.putString("pkg_name", r2.getOpPackageName());
        r12.putString(PlatformConst.BUNDLE_KEY_BRAND, Build.BRAND);
        int r3 = Build.VERSION.SDK_INT;
        if (r3 < 31) goto L17;
        r12.putString(PlatformConst.BUNDLE_KEY_SOC_MODEL, Build.SOC_MODEL);
    L23:
        LogUtils.d("PlatKeyManagerImpl", "Build.MANUFACTURER: " + Build.MANUFACTURER);
        LogUtils.d("PlatKeyManagerImpl", "DeviceInfo bundle: " + r12.toString());
        byte[] r6 = r7.init(1, 1, "bdc5afe786f38d4533628da5ea01364dd4a91ae36bb898125f25bde25cd991f2", r11, r12);
        h.f2217b = r6;
        if (r6 == null) goto L26;
        LogUtils.d("PlatKeyManagerImpl", "sharedKeyHash: " + CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(r6, CryptoConst.ALGORITHM_SHA256)));
        return 0;
    L26:
        LogUtils.e("PlatKeyManagerImpl", "init failed");
        return -14;
    L17:
        LogUtils.d("PlatKeyManagerImpl", "Current sdk version: " + r3);
        Class r8 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin");     // Catch: Exception -> L20
        r1 = (String) ZeusTransformUtils.preCheckCast(r8.getMethod("get", new Class[]{String.class, String.class}).invoke(r8, new Object[]{PlatformConst.PROP_SOC_MODEL, ""}), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
    L22:
        r12.putString(PlatformConst.BUNDLE_KEY_SOC_MODEL, r1);
    L20:
        e = move-exception;
        LogUtils.e("PlatKeyManagerImpl", "getProperty failed, exception: " + e.getMessage());
    L27:
        LogUtils.e("PlatKeyManagerImpl", "Invalid input params.");
        return -2;
    }

    public String reEncryptFEK(Context r5, String r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        h r7 = h.a();
        r7.getClass();
        if (r4 == null) goto L30;
        if (r6 == null) goto L30;
        if (r6.isEmpty() == true) goto L30;
        LogUtils.d("PlatKeyManagerImpl", "reEncryptFEK keyInfo: " + r6);
        if (h.f2217b != null) goto L11;
        String r8 = "The init method failed to be called or executed";
    L31:
        LogUtils.e("PlatKeyManagerImpl", r8);
        return null;
    L11:
        int r9 = r7.a(r4);
        if (r9 == 0) goto L14;
        r8 = "Permission denied, ret: " + r9;
        goto L31
    L14:
        f r10 = c.a(r6, ModelDistConst.PLATFORM_BUSINESS_PUBLIC_KEY);
        if (r10 != null) goto L17;
        r8 = "Parse model key cipher failed!!";
        goto L31
    L17:
        byte[] r11 = AES.gcmXcrypt(2, h.f2217b, null, r10.f2212a, r10.f2213b);
        if (r11.length == 32) goto L20;
        r8 = "decrypt dataKeyCipher failed or dataKey length invalid";
        goto L31
    L20:
        j r12 = c.b(r4, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
        if (r12 != null) goto L23;
        r8 = "prepareExternalDeviceKey failed.";
        goto L31
    L23:
        byte[] r13 = AES.gcmXcrypt(1, CryptoUtils.hexStringToByteArray(r12.f), null, CryptoUtils.hexStringToByteArray(r12.d), r11);
        if (r13 != null) goto L26;
    L29:
        r8 = "Re-encrypt FEK failed.";
        goto L31
    L26:
        if (r13.length == 0) goto L29;
        LogUtils.d("PlatKeyManagerImpl", "reEncrypt FEKCipher: " + CryptoUtils.byteArrayToHexString(r13));
        return CryptoUtils.byteArrayToHexString(r13);
    L30:
        r8 = "Input params is null!!";
        goto L31
    }
}
