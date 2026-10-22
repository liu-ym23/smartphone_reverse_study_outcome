package android.support.v4.media;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Path;
import android.graphics.Typeface;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.room.h;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.R;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import defpackage.b;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import jf.g;
import org.json.JSONObject;
import r6.c;
import v9.d;
import we.a0;
import x4.j0;
import x4.r;
import x4.z;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SecretKeySpec f404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static pa.a.C0135a f405b;

    public a() {
    }

    public a(View r8) {
        Context r10 = r8.getContext();
        d.d(r10, R.attr.motionEasingStandardDecelerateInterpolator, l0.a.b(0.0f, 0.0f, 0.0f, 1.0f));
        d.c(r10, R.attr.motionDurationMedium2, 300);
        d.c(r10, R.attr.motionDurationShort3, AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD);
        d.c(r10, R.attr.motionDurationShort2, 100);
    }

    public static String a(byte[] r8) {
        StringBuilder r10 = new StringBuilder();
        int r11 = r8.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.append(String.format("%02x", new Object[]{Byte.valueOf(r8[r12])}));
        r12 = r12 + 1;
        goto L3
    L6:
        return r10.toString();
    }

    public static SecretKey b() {
        KeyStore r8 = KeyStore.getInstance("AndroidKeyStore");
        r8.load(null);
        if (r8.containsAlias("secret_master_key") == true) goto L7;
        KeyGenerator r10 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        r10.init(new KeyGenParameterSpec.Builder("secret_master_key", 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setRandomizedEncryptionRequired(false).setKeySize(256).build());
        return r10.generateKey();
    L7:
        return (SecretKey) r8.getKey("secret_master_key", null);
    }

    public static SecretKeySpec c(Context r16, String r17) {
        c r8 = c.i(r16);
        r8.getClass();
        Log.i("a", "queryKey, alias: ".concat(r17));
        Cursor r10 = r8.getReadableDatabase().query("key_item", null, "alias =? ", new String[]{r17}, null, null, null);
        if (r10 != null) goto L6;
        Log.e("a", "queryKey cursor is null");
    L8:
        h r11 = null;
    L13:
        String r12 = r16.getPackageName() + r17;
        if (r11 != null) goto L37;
        Log.i("d", "Generate new key");
        byte[] r13 = new byte[32];
        new SecureRandom().nextBytes(r13);
        byte[] r15 = new byte[12];
        new SecureRandom().nextBytes(r15);
        byte[] r14 = r12.getBytes(StandardCharsets.UTF_8);
        GCMParameterSpec r18 = new GCMParameterSpec(128, r15);     // Catch: Exception -> L23
        Cipher r19 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L23
        r19.init(1, b(), r18);     // Catch: Exception -> L23
        if (r14 != null) goto L19;
    L21:
        byte[] r20 = r19.doFinal(r13);     // Catch: Exception -> L23
    L25:
        if (r20 != null) goto L27;
    L35:
        Log.e("d", "Encrypt data key failed!!");
        return null;
    L27:
        if (r20.length == 0) goto L35;
        String r21 = a(r15);
        String r22 = a(r20);
        c r110 = c.i(r16);
        r110.getClass();
        Log.i("a", "insertKey, alias: ".concat(r17));
        SQLiteDatabase r23 = r110.getWritableDatabase();
        ContentValues r111 = new ContentValues();
        r111.put("alias", r17);
        r111.put("version", 1);
        r111.put("cipher", r22);
        r111.put("iv", r21);
        r111.put(WsConstants.KEY_EXTRA, "");
        if (r23.insert("key_item", null, r111) != (-1)) goto L34;
        Log.e("d", "Insert key to db failed!!");
        return null;
    L34:
        return new SecretKeySpec(r13, "AES");
    L19:
        if (r14.length <= 0) goto L21;
        r19.updateAAD(r14);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        Log.e("d", "xcryptByKeyStore failed, error:" + e.getMessage());
        e.printStackTrace();
        r20 = new byte[0];
        goto L25
    L37:
        Log.i("d", "Get key from db");
        byte[] r24 = f((String) r11.f2621b);
        byte[] r25 = f((String) r11.f2620a);
        byte[] r26 = r12.getBytes(StandardCharsets.UTF_8);
        GCMParameterSpec r27 = new GCMParameterSpec(128, r24);     // Catch: Exception -> L45
        Cipher r28 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L45
        r28.init(2, b(), r27);     // Catch: Exception -> L45
        if (r26 != null) goto L41;
    L43:
        byte[] r29 = r28.doFinal(r25);     // Catch: Exception -> L45
    L47:
        if (r29 != null) goto L49;
    L53:
        Log.e("d", "Decrypt data key failed!!");
        return null;
    L49:
        if (r29.length == 0) goto L53;
        return new SecretKeySpec(r29, "AES");
    L41:
        if (r26.length <= 0) goto L43;
        r28.updateAAD(r26);     // Catch: Exception -> L45
    L45:
        e = move-exception;
        Log.e("d", "xcryptByKeyStore failed, error:" + e.getMessage());
        e.printStackTrace();
        r29 = new byte[0];
        goto L47
    L6:
        if (r10.getCount() != 0) goto L9;
        Log.e("a", "queryKey cursor count is 0");
        r10.close();
        goto L8
    L9:
        r11 = new h();
        if (r10.moveToFirst() == false) goto L12;
        r10.getInt(r10.getColumnIndex("version"));
        r11.f2621b = r10.getString(r10.getColumnIndex("iv"));
        r11.f2620a = r10.getString(r10.getColumnIndex("cipher"));
        r10.getString(r10.getColumnIndex(WsConstants.KEY_EXTRA));
    L12:
        r10.close();
        goto L13
    }

    public static byte[] d(int r8, SecretKeySpec r10, byte[] r11, byte[] r12, byte[] r13) {
        Log.i("c", "aesGcmXcrypt enter, mode:" + r8);
        Log.i("c", "aesGcmXcrypt enter, aad:".concat(new String(r11, StandardCharsets.UTF_8)));
        byte[] r14 = new byte[0];
        Cipher r15 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L10
        r15.init(r8, r10, new GCMParameterSpec(128, r12));     // Catch: Exception -> L10
        if (r11 != null) goto L6;
    L8:
        return r15.doFinal(r13);
    L6:
        if (r11.length <= 0) goto L8;
        r15.updateAAD(r11);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        StringBuilder r16 = b.f("AES-GCM xcrypt failed, mode:", r8, " error:");
        r16.append(e.getMessage());
        Log.e("c", r16.toString());
        return r14;
    }

    public static byte[] e(Context r12, SecretKeySpec r13, int r14, byte[] r15) {
        if (r12 != null) goto L5;
        String r8 = "Context is null!!";
    L14:
        Log.e("a", r8);
        byte r10 = -2;
    L15:
        if (r10 == 0) goto L19;
        Log.e("a", "Input param is invalid!!");
        return new byte[0];
    L19:
        if (r14 != 1) goto L28;
        byte[] r11 = new byte[12];
        new SecureRandom().nextBytes(r11);
        byte[] r16 = d(r14, r13, r12.getPackageName().getBytes(StandardCharsets.UTF_8), r11, r15);
        if (r16 != null) goto L23;
    L26:
        Log.e("a", "AES GCM encrypt failed!!");
        return new byte[0];
    L23:
        if (r16.length == 0) goto L26;
        byte[] r17 = new byte[r16.length + 17];
        byte r18 = (byte) 18;
        byte r19 = (byte) 205;
        System.arraycopy(new byte[]{r18, r19, r18, r19}, 0, r17, 0, 4);
        r17[4] = 1;
        System.arraycopy(r11, 0, r17, 5, 12);
        System.arraycopy(r16, 0, r17, 17, r16.length);
        return r17;
    L28:
        byte[] r20 = new byte[4];
        if (r15.length >= 4) goto L31;
        StringBuilder r110 = new StringBuilder("Input data len is too short! len:");
    L47:
        r110.append(r15.length);
    L48:
        String r111 = r110.toString();
    L54:
        Log.e("a", r111);
        return new byte[0];
    L31:
        System.arraycopy(r15, 0, r20, 0, 4);
        int r21 = (((r20[2] & 255) << 8) | (((r20[0] & 255) << 24) | ((r20[1] & 255) << 16))) | (r20[3] & 255);
        if (r21 == 315429581) goto L35;
        r110 = new StringBuilder("Cannot parse input cipher data! magic:");
    L40:
        r110.append(r21);
        goto L48
    L35:
        if (r15.length >= 5) goto L37;
        r110 = new StringBuilder("Input data len is too short!! len:");
        goto L47
    L37:
        r21 = Byte.toUnsignedInt(r15[4]);
        if (r21 == 1) goto L42;
        r110 = new StringBuilder("Input cipher data version is wrong! version:");
        goto L40
    L42:
        if (r15.length >= 17) goto L44;
        r110 = new StringBuilder("Input data len is too short for iv! len:");
        goto L47
    L44:
        byte[] r22 = new byte[12];
        System.arraycopy(r15, 5, r22, 0, 12);
        if (r15.length >= 33) goto L49;
        r110 = new StringBuilder("Input data len is too short for data cipher! len:");
        goto L47
    L49:
        int r23 = r15.length - 17;
        byte[] r24 = new byte[r23];
        System.arraycopy(r15, 17, r24, 0, r23);
        byte[] r112 = d(r14, r13, r12.getPackageName().getBytes(StandardCharsets.UTF_8), r22, r24);
        if (r112 != null) goto L52;
    L53:
        r111 = "AES GCM decrypt failed!!";
        goto L54
    L52:
        if (r112.length == 0) goto L53;
        return r112;
    L5:
        if (r15 != null) goto L7;
    L13:
        r8 = "Input data is empty!!";
        goto L14
    L7:
        if (r15.length == 0) goto L13;
        if (r14 == 1) goto L12;
        if (r14 == 2) goto L12;
        r8 = defpackage.a.d("Input mode is invalid!! mode:", r14);
    L12:
        StringBuilder r25 = b.f("Byte xcrypt params check ok, mode:", r14, ", data len:");
        r25.append(r15.length);
        Log.i("a", r25.toString());
        r10 = 0;
        goto L15
    }

    public static byte[] f(String r8) {
        if ((r8.length() % 2) == 0) goto L7;
        StringBuilder r10 = new StringBuilder("Invalid hex string length:");
        r10.append(r8.length());
    L5:
        Log.e("c", r10.toString());
        return new byte[0];
    L7:
        int r11 = r8.length() / 2;
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L14;
        int r14 = r13 * 2;
        r12[r13] = (byte) Integer.parseInt(r8.substring(r14, r14 + 2), 16);     // Catch: Exception -> L12
        r13 = r13 + 1;
    L12:
        e = move-exception;
        r10 = new StringBuilder("Hex string to byte array failed, error:");
        r10.append(e.getMessage());
        goto L5
    L14:
        return r12;
    }

    public static float h(float r8, float r10, float r11) {
        return 1.0f - ((r8 - r11) / (r10 - r11));
    }

    public abstract List g(String r8, List r10);

    public abstract JSONObject i();

    public abstract Path j(float r8, float r10, float r11, float r12);

    public abstract float k(Object r8);

    public abstract void l(b6.c r8, int r10, String r11);

    public void m() {
    }

    public void n(j0 r8, String r10) {
        JSONObject r11 = i();
        z r12 = r8.B;
        if (r12 == null) goto L11;
        r12.a();
        if (TextUtils.isEmpty(r10) == true) goto L7;
        Objects.toString(r11);
        int r13 = r.f13543a;
    L7:
        w();
        if (TextUtils.isEmpty(r10) == true) goto L12;
        int r14 = r.f13543a;
        return;
    L12:
        return;
    }

    public abstract void o(b6.d r8, Throwable r10, a0 r11);

    public abstract com.google.android.material.carousel.b p(m9.b r8, View r10);

    public abstract void q(int r8);

    public abstract void r(Typeface r8, boolean r10);

    public abstract void s(String r8);

    public abstract void t(g r8);

    public abstract void u(b6.c r8, a0 r10);

    public abstract void v(b6.c r8);

    public abstract void w();

    public abstract void x(Object r8, float r10);

    public abstract boolean y(m9.b r8, int r10);
}
