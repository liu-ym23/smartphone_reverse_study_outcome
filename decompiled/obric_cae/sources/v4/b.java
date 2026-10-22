package v4;

import android.text.TextUtils;
import c4.m;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import i4.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f12720b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f12721c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f12722d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r3.c f12723a;

    static {
        f12720b = Collections.singletonList("EncryptUtils");
        f12721c = new String[]{WsConstants.KEY_APP_ID, "version_code", "ab_version", WsConstants.KEY_INSTALL_ID, "device_platform", "device_id", "app_log_priority"};
        f12722d = new String[]{"tt_data", "device_platform"};
    }

    public b(r3.c r8) {
        this.f12723a = r8;
    }

    public static byte[] a(String r8, byte[] r10, String r11) {
        Cipher r12 = Cipher.getInstance("AES/CBC/PKCS7PADDING");     // Catch: Throwable -> L11
        int r13 = r8.length();     // Catch: Throwable -> L11
        byte[] r14 = new byte[r13];     // Catch: Throwable -> L11
        int r15 = 0;
    L4:
        if (r15 >= r13) goto L6;
        r14[r15] = (byte) r8.charAt(r15);     // Catch: Throwable -> L11
        r15 = r15 + 1;     // Catch: Throwable -> L11
        goto L4
    L6:
        SecretKeySpec r16 = new SecretKeySpec(r14, "AES");     // Catch: Throwable -> L11
        int r17 = r11.length();     // Catch: Throwable -> L11
        byte[] r18 = new byte[r17];     // Catch: Throwable -> L11
        int r19 = 0;
    L7:
        if (r19 >= r17) goto L9;
        r18[r19] = (byte) r11.charAt(r19);     // Catch: Throwable -> L11
        r19 = r19 + 1;     // Catch: Throwable -> L11
        goto L7
    L9:
        r12.init(2, r16, new IvParameterSpec(r18));     // Catch: Throwable -> L11
        return r12.doFinal(r10);
    L11:
        th = move-exception;
        m.u().i(f12720b, "Cannot decrypt aes cbc", th, new Object[0]);
        return null;
    }

    public static byte[] c(byte[] r8) {
        GZIPInputStream r10 = null;
        if (r8.length > 0) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        ByteArrayInputStream r12 = new ByteArrayInputStream(r8);     // Catch: Throwable -> L21 IOException -> L28
        GZIPInputStream r13 = new GZIPInputStream(r12);     // Catch: Throwable -> L19 IOException -> L39
        goto L29
    L51:
        byte[] r14 = new byte[1024];     // Catch: Throwable -> L16 IOException -> L18
    L10:
        int r15 = r13.read(r14);     // Catch: Throwable -> L16 IOException -> L18
        if (r15 < 0) goto L45;
        r11.write(r14, 0, r15);     // Catch: Throwable -> L16 IOException -> L18
    L45:
        r13.close();     // Catch: IOException -> L35
    L43:
        r12.close();     // Catch: IOException -> L36
    L34:
        return r11.toByteArray();
    L18:
        r10 = r13;
    L16:
        Throwable th = th;
        r10 = r13;
    L23:
        if (r10 != null) goto L41;
    L25:
        if (r12 == null) goto L58;
        r12.close();     // Catch: IOException -> L38
        throw th;
    L59:
        throw th;
    L58:
        throw th;
    L41:
        r10.close();     // Catch: IOException -> L37
    L19:
        th = move-exception;
        th = th;
    L29:
        if (r10 != null) goto L47;
    L31:
        if (r12 == null) goto L34;
    L47:
        r10.close();     // Catch: IOException -> L40
        goto L31
    L28:
        r12 = null;
    L21:
        th = move-exception;
        th = th;
        r12 = null;
        goto L23
    }

    public static boolean d(String[] r8) {
        if (r8 != null) goto L5;
    L16:
        return false;
    L5:
        if (r8.length != 2) goto L16;
        if (TextUtils.isEmpty(r8[0]) == true) goto L16;
        if (r8[0].length() != 32) goto L16;
        if (TextUtils.isEmpty(r8[1]) == true) goto L16;
        if (r8[1].length() != 16) goto L16;
        return true;
    }

    public final byte[] b(byte[] r8) {
        if (r8 != null) goto L6;
        return new byte[0];
    L6:
        if (this.f12723a.f11409q == true) goto L8;
    L13:
        return r8;
    L8:
        if (this.f12723a.e() == null) goto L10;
        this.f12723a.e().getClass();
    L10:
        r8 = EncryptorUtil.a(r8.length, r8);
        if (r8 != null) goto L13;
        this.f12723a.f11417y.b(k.Q, 1);
        goto L13
    }

    public final byte[] e(String r8) {
        GZIPOutputStream r10 = null;
        byte[] r11 = r8.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L5
    L8:
        if (this.f12723a.f11409q == false) goto L28;
        if (r11 != null) goto L11;
        r11 = new byte[0];
        goto L28
    L11:
        ByteArrayOutputStream r12 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r13 = new GZIPOutputStream(r12);     // Catch: Throwable -> L18
        r13.write(r11);     // Catch: Throwable -> L16
        r13.close();     // Catch: IOException -> L29
    L41:
    L16:
        th = th;
        r10 = r13;
    L31:
        m.u().i(f12720b, "gzip write failed", th, new Object[0]);     // Catch: Throwable -> L23
        if (r10 == null) goto L22;
        r10.close();     // Catch: IOException -> L29
    L23:
        th = move-exception;
        if (r10 != null) goto L33;
    L26:
        throw th;
    L33:
        r10.close();     // Catch: IOException -> L30
    L18:
        th = th;
    L22:
        r11 = r12.toByteArray();
    L28:
        return b(r11);
    L5:
        e = move-exception;
        this.f12723a.H.i(f12720b, "get bytes failed", e, new Object[0]);
        r11 = null;
        goto L8
    }
}
