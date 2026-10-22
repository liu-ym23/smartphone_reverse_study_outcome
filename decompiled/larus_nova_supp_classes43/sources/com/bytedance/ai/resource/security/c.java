package com.bytedance.ai.resource.security;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.bytedance.keva.Keva;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.security.auth.x500.X500Principal;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final c a = null;
    public static final Lazy b = null;

    public static final class a {
        static {
        }

        public static SecretKey a() {
            KeyStore r1 = KeyStore.getInstance("AndroidKeyStore");
            SecretKey r10 = null;
            r1.load(null);
            KeyStore.Entry r11 = r1.getEntry("AISDK_DEK_MASTER_AES", null);
            if ((r11 instanceof KeyStore.SecretKeyEntry) == false) goto L5;
            KeyStore.SecretKeyEntry r12 = (KeyStore.SecretKeyEntry) r11;
        L6:
            if (r12 == null) goto L8;
            r10 = r12.getSecretKey();
        L8:
            if (r10 == null) goto L10;
            return r10;
        L10:
            KeyGenerator r0 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            r0.init(new KeyGenParameterSpec.Builder("AISDK_DEK_MASTER_AES", 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).build());
            return r0.generateKey();
        L5:
            r12 = null;
            goto L6
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = LazyKt.lazy(new b());
    }

    public static KeyPair a(Context r10) {
        KeyStore r1 = KeyStore.getInstance("AndroidKeyStore");
        r1.load(null);
        KeyStore.Entry r11 = r1.getEntry("AISDK_DEK_MASTER_RSA", null);
        if ((r11 instanceof KeyStore.PrivateKeyEntry) == false) goto L6;
        KeyStore.PrivateKeyEntry r12 = (KeyStore.PrivateKeyEntry) r11;
        return new KeyPair(r12.getCertificate().getPublicKey(), r12.getPrivateKey());
    L6:
        Calendar r13 = Calendar.getInstance();
        Calendar r14 = Calendar.getInstance();
        r14.add(1, 30);
        KeyPairGeneratorSpec r15 = new KeyPairGeneratorSpec.Builder(r10).setAlias("AISDK_DEK_MASTER_RSA").setSubject(new X500Principal("CN=AISDK_DEK_WRAP")).setSerialNumber(BigInteger.ONE).setStartDate(r13.getTime()).setEndDate(r14.getTime()).build();
        KeyPairGenerator r0 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        r0.initialize(r15);
        return r0.generateKeyPair();
    }

    public static String b(String r10, long r11) {
        return "dek_" + r10 + '_' + r11;
    }

    public static byte[] c(Context r12, String r13, long r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "packageName");
        String r0 = ((Keva) b.getValue()).getString(b(r13, r14), null);
        if (r0 != null) goto L6;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "loadDek32 failed: no blob in store. package=" + r13 + " version=" + r14);
        return null;
    L6:
        byte[] r1 = Base64.decode(r0, 2);
        Intrinsics.checkNotNull(r1);
        if (r1.length != 0) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == false) goto L13;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "loadDek32 failed: blob is empty after Base64 decode. package=" + r13 + " version=" + r14);
        return null;
    L13:
        byte r11 = r1[0];
        if (r11 != 65) goto L33;
        int r15 = Build.VERSION.SDK_INT;
        if (r15 >= 23) goto L18;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "loadDek32 failed: V_AES_GCM blob but SDK < M (" + r15 + "). package=" + r13 + " version=" + r14);
    L71:
        byte[] r16 = null;
    L72:
        if (r16 != null) goto L75;
        return null;
    L75:
        if (r16.length == 32) goto L78;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "loadDek32 failed: decrypted DEK size is " + r16.length + ", expected 32. package=" + r13 + " version=" + r14);
        return null;
    L78:
        return r16;
    L18:
        if (r1.length >= 29) goto L20;
        r16 = null;
    L29:
        if (r16 != null) goto L72;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "loadDek32 failed: AES-GCM decryption returned null. package=" + r13 + " version=" + r14);
        goto L72
    L20:
        byte[] r17 = ArraysKt.copyOfRange(r1, 1, 13);
        byte[] r18 = ArraysKt.copyOfRange(r1, 13, r1.length);
        SecretKey r19 = a.a();
        Cipher r20 = Cipher.getInstance("AES/GCM/NoPadding");
        r20.init(2, r19, new GCMParameterSpec(128, r17));
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L23
        Object r110 = Result.constructor-impl(r20.doFinal(r18));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r110) == false) goto L28;
        r110 = null;
    L28:
        r16 = (byte[]) r110;
    L23:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L33:
        if (r11 != 97) goto L58;
        int r111 = Build.VERSION.SDK_INT;
        if (r111 >= 23) goto L37;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "loadDek32 failed: V_AES_GCM_V2 blob but SDK < M (" + r111 + "). package=" + r13 + " version=" + r14);
        goto L71
    L37:
        if (r1.length < 19) goto L44;
        int r112 = r1[1] & 255;
        if (r112 <= 0) goto L44;
        int r113 = r112 + 2;
        if (r1.length < (r113 + 16)) goto L44;
        byte[] r23 = ArraysKt.copyOfRange(r1, 2, r113);
        byte[] r114 = ArraysKt.copyOfRange(r1, r113, r1.length);
        SecretKey r24 = a.a();
        Cipher r25 = Cipher.getInstance("AES/GCM/NoPadding");
        r25.init(2, r24, new GCMParameterSpec(128, r23));
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L48
        Object r115 = Result.constructor-impl(r25.doFinal(r114));     // Catch: Throwable -> L48
    L51:
        if (Result.isFailure-impl(r115) == false) goto L53;
        r115 = null;
    L53:
        r16 = (byte[]) r115;
    L54:
        if (r16 != null) goto L72;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "loadDek32 failed: AES-GCM-V2 decryption returned null. package=" + r13 + " version=" + r14);
    L48:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r115 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        r16 = null;
        goto L54
    L58:
        if (r11 != 82) goto L70;
        PrivateKey r116 = a(r12).getPrivate();
        byte[] r28 = ArraysKt.copyOfRange(r1, 1, r1.length);
        Cipher r29 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r29.init(2, r116);
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L62
        Object r118 = Result.constructor-impl(r29.doFinal(r28));     // Catch: Throwable -> L62
    L65:
        if (Result.isFailure-impl(r118) == false) goto L67;
        r118 = null;
    L67:
        r16 = (byte[]) r118;
        if (r16 != null) goto L72;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "loadDek32 failed: RSA decryption returned null. package=" + r13 + " version=" + r14);
    L62:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r118 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L65
    L70:
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "loadDek32 failed: unknown version byte 0x" + Integer.toString(r11, CharsKt.checkRadix(16)) + ". package=" + r13 + " version=" + r14);
        goto L71
    L9:
        r10 = false;
        goto L10
    }

    public static void d(Context r10, String r11, long r12, byte[] r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "packageName");
        Intrinsics.checkNotNullParameter(r13, "dek32");
        boolean r14 = false;
        if (r13.length != 32) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L29;
        if (Build.VERSION.SDK_INT < 23) goto L25;
        SecretKey r15 = a.a();
        Cipher r1 = Cipher.getInstance("AES/GCM/NoPadding");
        r1.init(1, r15);
        byte[] r16 = r1.getIV();
        if (r16 == null) goto L24;
        byte[] r17 = r1.doFinal(r13);
        if (r16.length != 12) goto L14;
        ByteArrayOutputStream r18 = new ByteArrayOutputStream(r17.length + 13);
        r18.write(65);
        r18.write(r16);
        r18.write(r17);
        byte[] r19 = r18.toByteArray();
        Intrinsics.checkNotNull(r19);
    L26:
        ((Keva) b.getValue()).storeString(b(r11, r12), Base64.encodeToString(r19, 2));
        return;
    L14:
        int r20 = r16.length;
        if (1 <= r20) goto L17;
    L19:
        if (r14 == false) goto L22;
        ByteArrayOutputStream r21 = new ByteArrayOutputStream((r16.length + 2) + r17.length);
        r21.write(97);
        r21.write(r16.length);
        r21.write(r16);
        r21.write(r17);
        r19 = r21.toByteArray();
        Intrinsics.checkNotNull(r19);
        goto L26
    L22:
        throw new IllegalArgumentException(("Unsupported GCM IV length: " + r16.length).toString());
    L17:
        if (r20 >= 256) goto L19;
        r14 = true;
        goto L19
    L24:
        throw new IllegalStateException("GCM IV is null");
    L25:
        PublicKey r22 = a(r10).getPublic();
        Cipher r23 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r23.init(1, r22);
        byte[] r24 = r23.doFinal(r13);
        ByteArrayOutputStream r25 = new ByteArrayOutputStream(r24.length + 1);
        r25.write(82);
        r25.write(r24);
        r19 = r25.toByteArray();
        goto L26
    L29:
        throw new IllegalArgumentException("DEK must be 32 bytes".toString());
    L5:
        r0 = false;
        goto L6
    }
}
