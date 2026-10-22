package b1c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.z0;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements b1c.a {
    public static final z0<b, String> c = null;
    public final m4c.a.a a;
    public final SharedPreferences b;

    public static class a implements z0.a<b> {
        public final String a;
        public final String b;

        public a() {
            this.a = String.valueOf(true);
            this.b = String.valueOf(false);
        }
    }

    public static class b {
        public final String a;
        public final m4c.a.a b;
        public int c;

        public final int hashCode() {
            if (this.c != (-1)) goto L6;
            this.c = Objects.hash(new Object[]{this.a, this.b});
        L6:
            return this.c;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L17:
            return false;
        L8:
            if (b.class != r5.getClass()) goto L17;
            b r6 = (b) r5;
            if (Objects.equals(this.a, r6.a) == true) goto L13;
        L15:
            return false;
        L13:
            if (Objects.equals(this.b, r6.b) == false) goto L15;
            return true;
        }

        public b(String r2, m4c.a.a r3) {
            this.c = -1;
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        c = new z0(new a());
    }

    public static String b(String r3) throws UnsupportedEncodingException, GeneralSecurityException {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return r3;
    L5:
        v8b.a.a().getClass();
        return c(r3, m4c.b.a.a.b());
    L8:
        e = move-exception;
        Log.e("SecurePolicy", "decrypt string fail:".concat(r3), e, true);
        return null;
    }

    public static String e(String r4) throws UnsupportedEncodingException, GeneralSecurityException {
        v8b.a.a().getClass();
        m4c.a.a r0 = m4c.b.a.a.b();     // Catch: GeneralSecurityException -> L5
    L8:
        return f(r4, r0);
    L5:
        e = move-exception;
        Log.e("SecurePolicy", "get aes key failed", e, true);
        r0 = null;
        goto L8
    }

    public static String g(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return r3;
    L10:
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L7
        byte[] r4 = r3.getBytes(StandardCharsets.UTF_8);     // Catch: NoSuchAlgorithmException -> L7
        r0.update(r4, 0, r4.length);     // Catch: NoSuchAlgorithmException -> L7
        return Base64.encodeToString(r0.digest(), 2);
    L7:
        e = move-exception;
        Log.w("SecurePolicy", "Problem generating hash", e);
        return null;
    }

    public final String a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L16;
        return r5;
    L16:
        return c(r5, this.a);
    L10:
        e = move-exception;
        Log.e("SecurePolicy", "decrypt error, $value", e, true);
        return null;
    L8:
        e = move-exception;
        Log.e("SecurePolicy", "decrypt error, $value", e, true);
        return null;
    L12:
        e = move-exception;
        Log.e("SecurePolicy", "decrypt error, $value", e, true);
        return null;
    }

    public final String d(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L13;
        return r4;
    L13:
        return f(r4, this.a);
    L7:
        e = move-exception;
        Log.w("SecurePolicy", "encrypt", e);
        return null;
    L9:
        e = move-exception;
        Log.w("SecurePolicy", "encrypt", e);
        return null;
    }

    public static String c(String r9, m4c.a.a r10) throws UnsupportedEncodingException, GeneralSecurityException {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return r9;
    L5:
        z0<b, String> r0 = c;
        if (r9 != null) goto L8;
        r0.getClass();
        Object r1 = null;
    L9:
        b r2 = (b) r1;
        if (r2 != null) goto L12;
    L15:
        String[] r3 = r9.split(":");
        if (r3.length == 3) goto L23;
        if (r3.length == 2) goto L23;
        throw new IllegalArgumentException("Cannot parse: ".concat(r9));
    L23:
        if (r3.length != 3) goto L25;
        String r4 = r3[0];
        String r5 = r3[2];
    L26:
        int r6 = m4c.a.a;
        Charset r7 = StandardCharsets.UTF_8;
        Cipher r8 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        r8.init(2, r10.a, new IvParameterSpec(Base64.decode(r4, 2)));     // Catch: NullPointerException -> L30
        String r11 = new String(r8.doFinal(Base64.decode(r5, 2)), r7);
        r0.a(new b(r11, r10), r9);
        return r11;
    L30:
        e = move-exception;
        throw new GeneralSecurityException("init cipher npe", e);
    L25:
        r4 = r3[0];
        r5 = r3[1];
        goto L26
    L12:
        if (Objects.equals(r2.b, r10) == false) goto L15;
        return r2.a;
    L8:
        r1 = r0.b.get(r9);
        goto L9
    }

    public static String f(String r5, m4c.a.a r6) throws UnsupportedEncodingException, GeneralSecurityException {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return r5;
    L5:
        b r0 = new b(r5, r6);
        z0<b, String> r1 = c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "key");
        String r2 = (String) r1.c.get(r0);
        if (r2 == null) goto L8;
        return r2;
    L8:
        int r3 = m4c.a.a;
        byte[] r7 = r5.getBytes(StandardCharsets.UTF_8);
        byte[] r4 = new byte[16];
        SecureRandom.getInstance("SHA1PRNG").nextBytes(r4);
        Cipher r8 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        r8.init(1, r6.a, new IvParameterSpec(r4));
        byte[] r9 = r8.getIV();
        byte[] r10 = r8.doFinal(r7);
        String r11 = Base64.encodeToString(r9, 2);
        String r12 = Base64.encodeToString(r10, 2);
        String r13 = r11.concat(":").concat(r12);
        r1.a(r0, r13);
        return r13;
    }

    public c(Context r4, m4c.a.a r5, String r6) {
        if (this.b == null) goto L5;
    L9:
        if (r5 == null) goto L28;
        this.a = r5;
        return;
    L28:
        String r7 = g(r4.getPackageName());     // Catch: GeneralSecurityException -> L25
        if (TextUtils.isEmpty(r7) == false) goto L14;
        r7 = "RTNCQTAxN0Q4N0Y0N0Y4QjA2RTFGMzNGQzhGMjJFNUI=";
    L14:
        String r8 = this.b.getString(r7, null);     // Catch: GeneralSecurityException -> L25
        if (r8 != null) goto L19;
        int r9 = m4c.a.a;     // Catch: GeneralSecurityException -> L25
        KeyGenerator r10 = KeyGenerator.getInstance("AES");     // Catch: GeneralSecurityException -> L25
        r10.init(128);     // Catch: GeneralSecurityException -> L25
        SecretKey r11 = r10.generateKey();     // Catch: GeneralSecurityException -> L25
        byte[] r1 = new byte[32];     // Catch: GeneralSecurityException -> L25
        SecureRandom.getInstance("SHA1PRNG").nextBytes(r1);     // Catch: GeneralSecurityException -> L25
        m4c.a.a r2 = new m4c.a.a(r11, new SecretKeySpec(r1, "HmacSHA256"));     // Catch: GeneralSecurityException -> L25
        this.a = r2;     // Catch: GeneralSecurityException -> L25
        if (this.b.edit().putString(r7, r2.toString()).commit() == true) goto L21;
        Log.w("SecurePolicy", "Key not committed to prefs");     // Catch: GeneralSecurityException -> L25
    L21:
        if (this.a == null) goto L24;
        return;
    L24:
        throw new GeneralSecurityException("Problem generating Key");     // Catch: GeneralSecurityException -> L25
    L19:
        this.a = m4c.a.a(r8);     // Catch: GeneralSecurityException -> L25
    L25:
        e = move-exception;
        Log.e("SecurePolicy", "Error init:" + e.getMessage(), e);
        throw new IllegalStateException(e);
    L5:
        if (TextUtils.isEmpty(r6) == false) goto L7;
        SharedPreferences r12 = PreferenceManager.getDefaultSharedPreferences(r4);
    L8:
        this.b = r12;
        goto L9
    L7:
        r12 = r4.getSharedPreferences(r6, 0);
        goto L8
    }
}
