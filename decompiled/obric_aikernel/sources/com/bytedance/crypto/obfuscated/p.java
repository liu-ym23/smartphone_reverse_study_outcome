package com.bytedance.crypto.obfuscated;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.utils.CryptoConst;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SecretKeySpec f1508a;

    public static SecretKey a() {
        KeyStore r10 = KeyStore.getInstance("AndroidKeyStore");
        r10.load(null);
        if (r10.containsAlias("secret_master_key") == true) goto L7;
        KeyGenerator r11 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, "AndroidKeyStore");
        r11.init(new KeyGenParameterSpec.Builder("secret_master_key", 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setRandomizedEncryptionRequired(false).setKeySize(256).build());
        return r11.generateKey();
    L7:
        return (SecretKey) r10.getKey("secret_master_key", null);
    }

    public static SecretKeySpec a(Context r16, String r17) {
        k r10 = k.a(r16);
        r10.getClass();
        Log.i("a", "queryKey, alias: ".concat(r17));
        Cursor r11 = r10.getReadableDatabase().query("key_item", null, "alias =? ", new String[]{r17}, null, null, null);
        if (r11 != null) goto L7;
        Log.e("a", "queryKey cursor is null");
    L5:
        n r12 = null;
    L13:
        String r13 = r16.getPackageName() + r17;
        if (r12 != null) goto L37;
        Log.i("d", "Generate new key");
        byte[] r14 = new byte[32];
        new SecureRandom().nextBytes(r14);
        byte[] r15 = new byte[12];
        new SecureRandom().nextBytes(r15);
        byte[] r18 = r13.getBytes(StandardCharsets.UTF_8);
        GCMParameterSpec r19 = new GCMParameterSpec(128, r15);     // Catch: Exception -> L23
        Cipher r110 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L23
        r110.init(1, a(), r19);     // Catch: Exception -> L23
        if (r18 != null) goto L19;
    L21:
        byte[] r20 = r110.doFinal(r14);     // Catch: Exception -> L23
    L25:
        if (r20 != null) goto L27;
    L35:
        Log.e("d", "Encrypt data key failed!!");
        return null;
    L27:
        if (r20.length == 0) goto L35;
        String r21 = o.a(r15);
        String r22 = o.a(r20);
        k r111 = k.a(r16);
        r111.getClass();
        Log.i("a", "insertKey, alias: ".concat(r17));
        SQLiteDatabase r23 = r111.getWritableDatabase();
        ContentValues r112 = new ContentValues();
        r112.put("alias", r17);
        r112.put("version", 1);
        r112.put("cipher", r22);
        r112.put("iv", r21);
        r112.put(WsConstants.KEY_EXTRA, "");
        if (r23.insert("key_item", null, r112) != (-1)) goto L34;
        Log.e("d", "Insert key to db failed!!");
        return null;
    L34:
        return new SecretKeySpec(r14, CryptoConst.ALGORITHM_AES);
    L19:
        if (r18.length <= 0) goto L21;
        r110.updateAAD(r18);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        Log.e("d", "xcryptByKeyStore failed, error:" + e.getMessage());
        e.printStackTrace();
        r20 = new byte[0];
        goto L25
    L37:
        Log.i("d", "Get key from db");
        byte[] r24 = o.a(r12.f1507b);
        byte[] r25 = o.a(r12.f1506a);
        byte[] r26 = r13.getBytes(StandardCharsets.UTF_8);
        GCMParameterSpec r27 = new GCMParameterSpec(128, r24);     // Catch: Exception -> L45
        Cipher r28 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L45
        r28.init(2, a(), r27);     // Catch: Exception -> L45
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
        return new SecretKeySpec(r29, CryptoConst.ALGORITHM_AES);
    L41:
        if (r26.length <= 0) goto L43;
        r28.updateAAD(r26);     // Catch: Exception -> L45
    L45:
        e = move-exception;
        Log.e("d", "xcryptByKeyStore failed, error:" + e.getMessage());
        e.printStackTrace();
        r29 = new byte[0];
        goto L47
    L7:
        if (r11.getCount() != 0) goto L9;
        Log.e("a", "queryKey cursor count is 0");
        r11.close();
        goto L5
    L9:
        r12 = new n();
        if (r11.moveToFirst() == false) goto L12;
        r11.getInt(r11.getColumnIndex("version"));
        r12.f1507b = r11.getString(r11.getColumnIndex("iv"));
        r12.f1506a = r11.getString(r11.getColumnIndex("cipher"));
        r11.getString(r11.getColumnIndex(WsConstants.KEY_EXTRA));
    L12:
        r11.close();
        goto L13
    }
}
