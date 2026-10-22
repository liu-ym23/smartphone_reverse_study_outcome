package o1;

import android.text.TextUtils;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import com.bytedance.bdinstall.Api;
import com.bytedance.crypto.utils.CryptoConst;
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
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f11380b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f11381c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f11382d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.c f11383a;

    static {
        f11380b = Collections.singletonList("EncryptUtils");
        f11381c = new String[]{"aid", "version_code", Api.KEY_AB_VERSION, "iid", "device_platform", "device_id"};
        f11382d = new String[]{"tt_data", "device_platform"};
    }

    public g(com.bytedance.applog.c r10) {
        this.f11383a = r10;
    }

    private static String a(byte[] r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L3:
        if (r10 == null) goto L11;
        if (r12 >= r10.length) goto L11;
        String r13 = Integer.toHexString(r10[r12] & 255);
        if (r13.length() != 1) goto L9;
        r11.append('0');
    L9:
        r11.append(r13);
        r12 = r12 + 1;
    L11:
        return r11.toString();
    }

    public static byte[] b(byte[] r10, String r11, String r12) {
        Cipher r13 = Cipher.getInstance("AES/CBC/PKCS7PADDING");     // Catch: Throwable -> L4
        r13.init(2, new SecretKeySpec(h(r11), CryptoConst.ALGORITHM_AES), new IvParameterSpec(h(r12)));     // Catch: Throwable -> L4
        return r13.doFinal(r10);
    L4:
        th = move-exception;
        f1.n.B().u(f11380b, "Cannot decrypt aes cbc", th, new Object[0]);
        return null;
    }

    public static String[] d() {
        KeyGenerator r10 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L8
        SecureRandom r11 = new SecureRandom();     // Catch: Throwable -> L8
        r10.init(128, r11);     // Catch: Throwable -> L8
        byte[] r12 = new byte[8];     // Catch: Throwable -> L8
        r11.nextBytes(r12);     // Catch: Throwable -> L8
        String[] r13 = {a(r10.generateKey().getEncoded()), a(r12)};     // Catch: Throwable -> L8
        if (g(r13) == false) goto L6;
        return r13;
    L6:
        return null;
    L11:
        return null;
    }

    public static byte[] e(byte[] r10) {
        if (r10 == null) goto L5;
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r12 = null;
        GZIPOutputStream r13 = new GZIPOutputStream(r11);     // Catch: Throwable -> L13
        r13.write(r10);     // Catch: Throwable -> L11
        r13.close();     // Catch: IOException -> L23
    L29:
    L11:
        th = th;
        r12 = r13;
    L25:
        f1.n.B().u(f11380b, "gzip write failed", th, new Object[0]);     // Catch: Throwable -> L19
        if (r12 == null) goto L18;
        r12.close();     // Catch: IOException -> L23
    L19:
        th = move-exception;
        if (r12 != null) goto L33;
    L22:
        throw th;
    L33:
        r12.close();     // Catch: IOException -> L24
    L13:
        th = th;
    L18:
        return r11.toByteArray();
    L5:
        return new byte[0];
    }

    public static byte[] f(byte[] r10) {
        GZIPInputStream r11 = null;
        if (r10 != null) goto L5;
    L38:
        return null;
    L5:
        if (r10.length <= 0) goto L38;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        ByteArrayInputStream r13 = new ByteArrayInputStream(r10);     // Catch: Throwable -> L24 IOException -> L31
        GZIPInputStream r14 = new GZIPInputStream(r13);     // Catch: Throwable -> L22 IOException -> L43
        goto L32
    L59:
        byte[] r15 = new byte[1024];     // Catch: Throwable -> L19 IOException -> L21
    L12:
        int r16 = r14.read(r15);     // Catch: Throwable -> L19 IOException -> L21
        if (r16 < 0) goto L47;
        r12.write(r15, 0, r16);     // Catch: Throwable -> L19 IOException -> L21
    L47:
        r14.close();     // Catch: IOException -> L39
    L51:
        r13.close();     // Catch: IOException -> L40
    L37:
        return r12.toByteArray();
    L21:
        r11 = r14;
    L19:
        Throwable th = th;
    L26:
        if (r14 != null) goto L53;
    L28:
        if (r13 == null) goto L62;
        r13.close();     // Catch: IOException -> L42
        throw th;
    L63:
        throw th;
    L62:
        throw th;
    L53:
        r14.close();     // Catch: IOException -> L41
    L22:
        th = move-exception;
        th = th;
        r14 = null;
    L32:
        if (r11 != null) goto L45;
    L34:
        if (r13 == null) goto L37;
    L45:
        r11.close();     // Catch: IOException -> L44
        goto L34
    L31:
        r13 = null;
    L24:
        th = move-exception;
        r13 = null;
        th = th;
        r14 = null;
        goto L26
    }

    public static boolean g(String[] r10) {
        if (r10 != null) goto L5;
    L16:
        return false;
    L5:
        if (r10.length != 2) goto L16;
        if (TextUtils.isEmpty(r10[0]) == true) goto L16;
        if (r10[0].length() != 32) goto L16;
        if (TextUtils.isEmpty(r10[1]) == true) goto L16;
        if (r10[1].length() != 16) goto L16;
        return true;
    }

    private static byte[] h(String r10) {
        int r11 = r10.length();
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = (byte) r10.charAt(r13);
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    public byte[] c(byte[] r10) {
        if (r10 != null) goto L6;
        return new byte[0];
    L6:
        if (this.f11383a.E() == true) goto L8;
    L16:
        return r10;
    L8:
        if (this.f11383a.K() == null) goto L10;
        b4.a r11 = this.f11383a.K().o();
    L11:
        if (r11 == null) goto L13;
        r10 = r11.encrypt(r10, r10.length);
    L14:
        if (r10 != null) goto L16;
        this.f11383a.R().h(MonitorKey.pack, MonitorState.f_to_bytes_encrypt);
        goto L16
    L13:
        r10 = g3.b.a(r10, r10.length);
        goto L14
    L10:
        r11 = null;
        goto L11
    }

    public byte[] i(String r10) {
        byte[] r11 = r10.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L4
    L7:
        if (this.f11383a.E() == false) goto L10;
        r11 = e(r11);
    L10:
        return c(r11);
    L4:
        e = move-exception;
        this.f11383a.P().u(f11380b, "get bytes failed", e, new Object[0]);
        r11 = null;
        goto L7
    }
}
