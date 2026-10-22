package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.tencent.open.log.SLog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a {
    private KeyStore a;
    private SharedPreferences b;

    private void a() throws Exception {
        byte[] r0 = new byte[16];
        SecureRandom r1 = new SecureRandom();
        r1.nextBytes(r0);
        c(Base64.encodeToString(r1.generateSeed(12), 0));
        PublicKey r2 = this.a.getCertificate("KEYSTORE_AES").getPublicKey();
        Cipher r3 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r3.init(1, r2);
        d(Base64.encodeToString(r3.doFinal(r0), 0));
    }

    private byte[] b() {
        return Base64.decode(this.b.getString("PREF_KEY_IV", BuildConfig.FLAVOR), 0);
    }

    private SecretKeySpec c() throws Exception {
        String r0 = this.b.getString("PREF_KEY_AES", BuildConfig.FLAVOR);
        PrivateKey r1 = (PrivateKey) this.a.getKey("KEYSTORE_AES", null);
        Cipher r2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r2.init(2, r1);
        return new SecretKeySpec(r2.doFinal(Base64.decode(r0, 0)), "AES/GCM/NoPadding");
    }

    public a(Context r3) {
        this.b = r3.getSharedPreferences("KEYSTORE_SETTING", 0);     // Catch: Exception -> L7
        KeyStore r0 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L7
        this.a = r0;     // Catch: Exception -> L7
        r0.load(null);     // Catch: Exception -> L7
        if (this.a.containsAlias("KEYSTORE_AES") == true) goto L12;
        c(BuildConfig.FLAVOR);     // Catch: Exception -> L7
        a(r3);     // Catch: Exception -> L7
        a();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        SLog.d("KEYSTORE", "Exception", e);
    }

    private void a(Context r7) throws Exception {
        StringBuilder r0 = new StringBuilder("Build.VERSION.SDK_INT=");
        int r1 = Build.VERSION.SDK_INT;
        r0.append(r1);
        SLog.d("KEYSTORE", r0.toString());
        if (r1 < 23) goto L5;
        KeyPairGenerator r8 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        r8.initialize(new KeyGenParameterSpec.Builder("KEYSTORE_AES", 3).setDigests(new String[]{"SHA-256", "SHA-512"}).setEncryptionPaddings(new String[]{"PKCS1Padding"}).build());
        r8.generateKeyPair();
        return;
    L5:
        KeyPairGenerator r2 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        Calendar r3 = Calendar.getInstance();
        Calendar r4 = Calendar.getInstance();
        r4.add(1, 30);
        r2.initialize(new KeyPairGeneratorSpec.Builder(r7).setAlias("KEYSTORE_AES").setSubject(new X500Principal("CN=KEYSTORE_AES")).setSerialNumber(BigInteger.TEN).setStartDate(r3.getTime()).setEndDate(r4.getTime()).build());
        r2.generateKeyPair();
    }

    private void c(String r3) {
        this.b.edit().putString("PREF_KEY_IV", r3).apply();
    }

    private void d(String r3) {
        this.b.edit().putString("PREF_KEY_AES", r3).apply();
    }

    public String b(String r5) {
        byte[] r6 = Base64.decode(r5.getBytes(), 0);     // Catch: Exception -> L4
        Cipher r0 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L4
        r0.init(2, c(), new IvParameterSpec(b()));     // Catch: Exception -> L4
        return new String(r0.doFinal(r6));
    L4:
        e = move-exception;
        SLog.e("KEYSTORE", "Exception", e);
        return BuildConfig.FLAVOR;
    }

    public String a(String r5) {
        Cipher r0 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L4
        r0.init(1, c(), new IvParameterSpec(b()));     // Catch: Exception -> L4
        return Base64.encodeToString(r0.doFinal(r5.getBytes()), 0);
    L4:
        e = move-exception;
        SLog.e("KEYSTORE", "Exception", e);
        return BuildConfig.FLAVOR;
    }
}
