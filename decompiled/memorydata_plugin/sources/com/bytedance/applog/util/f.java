package com.bytedance.applog.util;

import android.text.TextUtils;
import com.bytedance.applog.log.q;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.bdinstall.Api;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.rpc.internal.RpcUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f1883a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f1884b = null;
    private static final List<String> c = null;
    private static final String[] d = null;
    private final com.bytedance.applog.b e;

    static {
        c = Collections.singletonList("EncryptUtils");
        d = new String[]{"aid", "app_version", "tt_data", "device_id"};
        f1883a = new String[]{"aid", "version_code", Api.KEY_AB_VERSION, "iid", "device_platform", "device_id", "app_log_priority"};
        f1884b = new String[]{"tt_data", "device_platform"};
    }

    public f(com.bytedance.applog.b r1) {
        this.e = r1;
    }

    public static boolean a(String[] r3) {
        if (r3 != null) goto L5;
    L16:
        return false;
    L5:
        if (r3.length != 2) goto L16;
        if (TextUtils.isEmpty(r3[0]) == true) goto L16;
        if (r3[0].length() != 32) goto L16;
        if (TextUtils.isEmpty(r3[1]) == true) goto L16;
        if (r3[1].length() != 16) goto L16;
        return true;
    }

    public static byte[] a(byte[] r6) {
        if (r6 == null) goto L5;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r2 = null;
        GZIPOutputStream r3 = new GZIPOutputStream(r1);     // Catch: Throwable -> L13
        r3.write(r6);     // Catch: Throwable -> L11
        r3.close();     // Catch: IOException -> L23
    L29:
    L11:
        th = th;
        r2 = r3;
    L25:
        q.a().a(c, "gzip write failed", th, new Object[0]);     // Catch: Throwable -> L19
        if (r2 == null) goto L18;
        r2.close();     // Catch: IOException -> L23
    L19:
        th = move-exception;
        if (r2 != null) goto L33;
    L22:
        throw th;
    L33:
        r2.close();     // Catch: IOException -> L24
    L13:
        th = th;
    L18:
        return r1.toByteArray();
    L5:
        return new byte[0];
    }

    public static byte[] a(byte[] r3, String r4, String r5) {
        Cipher r0 = Cipher.getInstance("AES/CBC/PKCS7PADDING");     // Catch: Throwable -> L4
        r0.init(2, new SecretKeySpec(b(r4), CryptoConst.ALGORITHM_AES), new IvParameterSpec(b(r5)));     // Catch: Throwable -> L4
        return r0.doFinal(r3);
    L4:
        th = move-exception;
        q.a().a(c, "Cannot decrypt aes cbc", th, new Object[0]);
        return null;
    }

    public static String[] a() {
        KeyGenerator r1 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L8
        SecureRandom r2 = new SecureRandom();     // Catch: Throwable -> L8
        r1.init(128, r2);     // Catch: Throwable -> L8
        byte[] r3 = new byte[8];     // Catch: Throwable -> L8
        r2.nextBytes(r3);     // Catch: Throwable -> L8
        String[] r0 = {d(r1.generateKey().getEncoded()), d(r3)};     // Catch: Throwable -> L8
        if (a(r0) == false) goto L6;
        return r0;
    L6:
        return null;
    L11:
        return null;
    }

    private static byte[] b(String r4) {
        int r0 = r4.length();
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = (byte) r4.charAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static byte[] c(byte[] r6) {
        GZIPInputStream r0 = null;
        if (r6 != null) goto L5;
    L38:
        return null;
    L5:
        if (r6.length <= 0) goto L38;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        ByteArrayInputStream r2 = new ByteArrayInputStream(r6);     // Catch: Throwable -> L24 IOException -> L31
        GZIPInputStream r7 = new GZIPInputStream(r2);     // Catch: Throwable -> L22 IOException -> L43
        goto L32
    L59:
        byte[] r3 = new byte[1024];     // Catch: Throwable -> L19 IOException -> L21
    L12:
        int r4 = r7.read(r3);     // Catch: Throwable -> L19 IOException -> L21
        if (r4 < 0) goto L47;
        r1.write(r3, 0, r4);     // Catch: Throwable -> L19 IOException -> L21
    L47:
        r7.close();     // Catch: IOException -> L39
    L51:
        r2.close();     // Catch: IOException -> L40
    L37:
        return r1.toByteArray();
    L21:
        r0 = r7;
    L19:
        Throwable th = th;
    L26:
        if (r7 != null) goto L53;
    L28:
        if (r2 == null) goto L62;
        r2.close();     // Catch: IOException -> L42
        throw th;
    L63:
        throw th;
    L62:
        throw th;
    L53:
        r7.close();     // Catch: IOException -> L41
    L22:
        th = move-exception;
        th = th;
        r7 = null;
    L32:
        if (r0 != null) goto L45;
    L34:
        if (r2 == null) goto L37;
    L45:
        r0.close();     // Catch: IOException -> L44
        goto L34
    L31:
        r2 = null;
    L24:
        th = move-exception;
        r2 = null;
        th = th;
        r7 = null;
        goto L26
    }

    private static String d(byte[] r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r5 == null) goto L11;
        if (r1 >= r5.length) goto L11;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() != 1) goto L9;
        r0.append('0');
    L9:
        r0.append(r2);
        r1 = r1 + 1;
    L11:
        return r0.toString();
    }

    public byte[] a(String r5) {
        byte[] r6 = r5.getBytes(RpcUtils.CHARSET_UTF8);     // Catch: UnsupportedEncodingException -> L4
    L7:
        if (this.e.k() == false) goto L10;
        r6 = a(r6);
    L10:
        return b(r6);
    L4:
        e = move-exception;
        this.e.aA().a(c, "get bytes failed", e, new Object[0]);
        r6 = null;
        goto L7
    }

    public byte[] b(byte[] r3) {
        if (r3 != null) goto L6;
        return new byte[0];
    L6:
        if (this.e.k() == true) goto L8;
    L16:
        return r3;
    L8:
        if (this.e.f() == null) goto L10;
        com.bytedance.mpaas.a r0 = this.e.f().m();
    L11:
        if (r0 == null) goto L13;
        r3 = r0.a(r3, r3.length);
    L14:
        if (r3 != null) goto L16;
        this.e.ab().a(StatsCountKeys.ENCRYPT_ERROR_COUNT);
        goto L16
    L13:
        r3 = com.bytedance.frameworks.core.encrypt.b.a(r3, r3.length);
        goto L14
    L10:
        r0 = null;
        goto L11
    }
}
