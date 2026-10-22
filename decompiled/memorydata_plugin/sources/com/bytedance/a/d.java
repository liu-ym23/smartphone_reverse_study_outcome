package com.bytedance.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1000a = "d";

    static {
    }

    public d() {
    }

    public static PackageInfo a(Context r3, String r4) {
        PackageManager r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getPackageManager();     // Catch: Exception -> L9
        if (r5 != null) goto L13;
        b.c(f1000a, "Get PackageManager failed!!");     // Catch: Exception -> L9
        return null;
    L13:
        return r5.getPackageInfo(r4, 0);
    L9:
        e = move-exception;
        b.c(f1000a, "Get PackageInfo failed, error:" + e.getMessage());
        return null;
    }

    public static String a(byte[] r3) {
        MessageDigest r0 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);     // Catch: NoSuchAlgorithmException -> L4
        r0.update(r3);     // Catch: NoSuchAlgorithmException -> L4
        return b(r0.digest());
    L4:
        e = move-exception;
        b.c(f1000a, "Get message digest failed, error:" + e.getMessage());
        return "";
    }

    public static byte[] a(String r6) {
        if ((r6.length() % 2) == 0) goto L7;
        String r0 = f1000a;
        StringBuilder r7 = new StringBuilder().append("Invalid hex string length:").append(r6.length());
    L5:
        b.c(r0, r7.toString());
        return new byte[0];
    L7:
        int r1 = r6.length() / 2;
        byte[] r2 = new byte[r1];
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L14;
        int r4 = r3 * 2;
        r2[r3] = (byte) Integer.parseInt(r6.substring(r4, r4 + 2), 16);     // Catch: Exception -> L12
        r3 = r3 + 1;
    L12:
        e = move-exception;
        r0 = f1000a;
        r7 = new StringBuilder().append("Hex string to byte array failed, error:").append(e.getMessage());
        goto L5
    L14:
        return r2;
    }

    public static String b(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.append(String.format("%02x", new Object[]{Byte.valueOf(r6[r3])}));
        r3 = r3 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public static byte[] b(Context r3, String r4) {
        byte[] r1 = new byte[0];
        PackageManager r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getPackageManager();     // Catch: Exception -> L9
        if (r5 != null) goto L13;
        b.c(f1000a, "Get PackageManager failed!!");     // Catch: Exception -> L9
        return r1;
    L13:
        return r5.getPackageInfo(r4, 64).signatures[0].toByteArray();
    L9:
        e = move-exception;
        b.c(f1000a, "Get signature failed, error:" + e.getMessage());
        return r1;
    }

    public static PublicKey c(byte[] r3) {
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(r3));
    L4:
        e = move-exception;
        b.c(f1000a, "Bytes to EC public key failed, error:" + e.getMessage());
        return null;
    }
}
