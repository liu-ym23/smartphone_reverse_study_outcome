package com.bytedance.crypto.obfuscated;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.utils.CommonUtils;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile g f1481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static byte[] f1482c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f1483a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1485b;

        public a(String r10, String r11) {
            this.f1484a = r10;
            this.f1485b = r11;
        }
    }

    public g() {
        this.f1483a = Arrays.asList(new a[]{new a(IAIKernelManager.PACKAGE_NAME_AIK, "0cdc978ba742397606daefeba9d508fffbfbdb229900648056b7a2a3607678e9")});
    }

    public static g a() {
        if (f1481b != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1481b != null) goto L9;
        f1481b = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f1481b;
    }

    public final int a(Context r10) {
        String r11 = r10.getPackageName();
        LogUtils.d("PlatKeyManagerImpl", "packageName: " + r11);
        List<byte[]> r12 = CommonUtils.getContextSignature(r10);
        if (r12 != null) goto L6;
        LogUtils.e("PlatKeyManagerImpl", "getContextSignature failed.");
        return -100;
    L6:
        LogUtils.d("PlatKeyManagerImpl", "signatureList.size(): " + r12.size());
        Iterator<byte[]> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L18;
        String r14 = CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(r13.next(), CryptoConst.ALGORITHM_SHA256));
        LogUtils.d("PlatKeyManagerImpl", "signHashHex: " + r14);
        Iterator<a> r15 = this.f1483a.iterator();
    L11:
        if (r15.hasNext() == false) goto L8;
        a r16 = r15.next();
        if (r16.f1484a.equals(r11) == false) goto L11;
        if (r16.f1485b.equals(r14) == false) goto L11;
        LogUtils.d("PlatKeyManagerImpl", "Found in APP_WHITE_LISTS");
        return 0;
    L18:
        LogUtils.d("PlatKeyManagerImpl", "Not found in APP_WHITE_LISTS");
        return -1;
    }

    public String a(Context r10, String r11, int r12, String r13) {
        if (r10 == null) goto L39;
        if (r11 == null) goto L39;
        if (r11.isEmpty() == true) goto L39;
        if (r13 == null) goto L39;
        if (r13.isEmpty() == true) goto L39;
        LogUtils.d("PlatKeyManagerImpl", "reEncryptFEK keyInfo: " + r11);
        LogUtils.i("PlatKeyManagerImpl", "reEncryptFEK keyAlias: " + r13);
        e r14 = b.a(r11, ModelDistConst.PLATFORM_BUSINESS_PUBLIC_KEY);
        if (r14 != null) goto L16;
        LogUtils.e("PlatKeyManagerImpl", "Parse model key cipher failed!!");
        return null;
    L16:
        if (r14.f1475a.length == FrameworkSecurityCompat.PlatformKeyConst.IV_LEN()) goto L18;
        LogUtils.e("PlatKeyManagerImpl", "Invalid modelKeyCipher data");
        byte[] r15 = null;
    L19:
        byte[] r16 = FrameworkSecurityCompat.platformKeyDecrypt(r10, r12, r15, CryptoUtils.convertPEMToUncompressedECPubKey(r14.f1477c), new Bundle());
        if (r16 != null) goto L22;
    L37:
        LogUtils.e("PlatKeyManagerImpl", "decrypt dataKeyCipher failed or dataKey length invalid");
        return null;
    L22:
        if (r16.length != 32) goto L37;
        i r17 = b.a(r10, r13);
        if (r17 != null) goto L28;
        LogUtils.e("PlatKeyManagerImpl", "prepareExternalDeviceKey failed.");
        return null;
    L28:
        byte[] r18 = AES.gcmXcrypt(1, CryptoUtils.hexStringToByteArray(r17.f1493f), null, CryptoUtils.hexStringToByteArray(r17.f1491d), r16);
        if (r18 != null) goto L31;
    L35:
        LogUtils.e("PlatKeyManagerImpl", "Re-encrypt FEK failed.");
        return null;
    L31:
        if (r18.length == 0) goto L35;
        LogUtils.d("PlatKeyManagerImpl", "reEncFEKCipher: " + CryptoUtils.byteArrayToHexString(r18));
        return CryptoUtils.byteArrayToHexString(r18);
    L18:
        r15 = new byte[((FrameworkSecurityCompat.PlatformKeyConst.MAGIC_NUM_LEN() + FrameworkSecurityCompat.PlatformKeyConst.PLATFORM_VER_LEN()) + r14.f1475a.length) + r14.f1476b.length];
        ByteBuffer r19 = ByteBuffer.wrap(r15);
        r19.putInt(-65536);
        r19.putInt(r12);
        r19.put(r14.f1475a);
        r19.put(r14.f1476b);
    L39:
        LogUtils.e("PlatKeyManagerImpl", "Input params is null!!");
        return null;
    }
}
