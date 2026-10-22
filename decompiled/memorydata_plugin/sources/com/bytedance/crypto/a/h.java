package com.bytedance.crypto.a;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.fekwrap.FekWrapResult;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.utils.CommonUtils;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile h f2216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static byte[] f2217b;
    public final List<b> c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f2219b;

        public a(int r1, byte[] r2) {
            this.f2218a = r1;
            this.f2219b = r2;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2221b;

        public b(String r1, String r2) {
            this.f2220a = r1;
            this.f2221b = r2;
        }
    }

    public h() {
        this.c = Arrays.asList(new b[]{new b("com.obric.aikernel", "0cdc978ba742397606daefeba9d508fffbfbdb229900648056b7a2a3607678e9")});
    }

    public static h a() {
        if (f2216a != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2216a != null) goto L9;
        f2216a = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f2216a;
    }

    public static FekWrapResult a(int r2, String r3) {
        return new FekWrapResult(r2, r3, new byte[0]);
    }

    public final int a(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        String r0 = r9.getPackageName();
        LogUtils.d("PlatKeyManagerImpl", "packageName: " + r0);
        List<byte[]> r10 = CommonUtils.getContextSignature(r9);
        if (r10 != null) goto L6;
        LogUtils.e("PlatKeyManagerImpl", "getContextSignature failed.");
        return -100;
    L6:
        LogUtils.d("PlatKeyManagerImpl", "signatureList.size(): " + r10.size());
        Iterator<byte[]> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L18;
        String r2 = CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest((byte[]) ZeusTransformUtils.preCheckCast(r11.next(), byte[].class, "com.obric.memorydata.plugin"), CryptoConst.ALGORITHM_SHA256));
        LogUtils.d("PlatKeyManagerImpl", "signHashHex: " + r2);
        Iterator<b> r4 = this.c.iterator();
    L11:
        if (r4.hasNext() == false) goto L8;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4.next(), b.class, "com.obric.memorydata.plugin");
        if (r5.f2220a.equals(r0) == false) goto L11;
        if (r5.f2221b.equals(r2) == false) goto L11;
        LogUtils.d("PlatKeyManagerImpl", "Found in APP_WHITE_LISTS");
        return 0;
    L18:
        LogUtils.d("PlatKeyManagerImpl", "Not found in APP_WHITE_LISTS");
        return -1;
    }

    public final a a(Context r5, String r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        f r9 = c.a(r6, ModelDistConst.PLATFORM_BUSINESS_PUBLIC_KEY);
        if (r9 != null) goto L6;
        LogUtils.e("PlatKeyManagerImpl", "Parse model key cipher failed!!");
        return new a(-8, null);
    L6:
        byte[] r4 = a(-65536, r7, r9);
        if (r4 == null) goto L9;
        byte[] r10 = CryptoUtils.convertPEMToUncompressedECPubKey(r9.c);
        if (r10 == null) goto L27;
        if (r10.length == 0) goto L27;
        byte[] r11 = FrameworkSecurityCompat.platformKeyDecrypt(r8, r7, r4, r10, new Bundle());
        if (r11 != null) goto L18;
    L22:
        if (r11 == null) goto L24;
        Arrays.fill(r11, (byte) 0);
    L24:
        LogUtils.e("PlatKeyManagerImpl", "decrypt dataKeyCipher failed or dataKey length invalid");
        return new a(-2004, null);
    L18:
        if (r11.length != 32) goto L22;
        return new a(0, r11);
    L27:
        return new a(-8, null);
    L9:
        return new a(-8, null);
    }

    public String a(Context r5, String r6, int r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L33;
        if (r6 == null) goto L33;
        if (r6.isEmpty() == true) goto L33;
        if (r8 == null) goto L33;
        if (r8.isEmpty() == true) goto L33;
        LogUtils.d("PlatKeyManagerImpl", "reEncryptFEK keyInfo: " + r6);
        LogUtils.i("PlatKeyManagerImpl", "reEncryptFEK keyAlias: " + r8);
        f r10 = c.a(r6, ModelDistConst.PLATFORM_BUSINESS_PUBLIC_KEY);
        if (r10 != null) goto L16;
        String r4 = "Parse model key cipher failed!!";
    L14:
        LogUtils.e("PlatKeyManagerImpl", r4);
        return null;
    L16:
        byte[] r11 = FrameworkSecurityCompat.platformKeyDecrypt(r9, r7, a(-65536, r7, r10), CryptoUtils.convertPEMToUncompressedECPubKey(r10.c), new Bundle());
        if (r11 != null) goto L19;
    L32:
        r4 = "decrypt dataKeyCipher failed or dataKey length invalid";
        goto L14
    L19:
        if (r11.length != 32) goto L32;
        j r12 = c.b(r9, r8);
        if (r12 != null) goto L24;
        r4 = "prepareExternalDeviceKey failed.";
        goto L14
    L24:
        byte[] r13 = AES.gcmXcrypt(1, CryptoUtils.hexStringToByteArray(r12.f), null, CryptoUtils.hexStringToByteArray(r12.d), r11);
        if (r13 != null) goto L27;
    L31:
        r4 = "Re-encrypt FEK failed.";
        goto L14
    L27:
        if (r13.length == 0) goto L31;
        LogUtils.d("PlatKeyManagerImpl", "reEncFEKCipher: " + CryptoUtils.byteArrayToHexString(r13));
        return CryptoUtils.byteArrayToHexString(r13);
    L33:
        r4 = "Input params is null!!";
        goto L14
    }

    public final byte[] a(int r2, int r3, f r4) {
        if (r4.f2212a.length == FrameworkSecurityCompat.PlatformKeyConst.IV_LEN()) goto L6;
        LogUtils.e("PlatKeyManagerImpl", "Invalid modelKeyCipher data");
        return null;
    L6:
        byte[] r1 = new byte[((FrameworkSecurityCompat.PlatformKeyConst.MAGIC_NUM_LEN() + FrameworkSecurityCompat.PlatformKeyConst.PLATFORM_VER_LEN()) + r4.f2212a.length) + r4.f2213b.length];
        ByteBuffer r0 = ByteBuffer.wrap(r1);
        r0.putInt(r2);
        r0.putInt(r3);
        r0.put(r4.f2212a);
        r0.put(r4.f2213b);
        return r1;
    }
}
