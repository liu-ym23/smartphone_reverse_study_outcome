package com.privacy.azerothprivacy.userAuthToken;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.crypto.tink.internal.c;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.privacy.azerothprivacy.AzerothPrivacy;
import com.privacy.azerothprivacy.exception.AzerothException;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import dpa.d;
import fpa.f;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final Gson a = null;
    public static final b b = null;

    public final synchronized void a() {
        monitor-enter(this);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L70
        boolean r2 = false;
        int r3 = 1;
        String r5 = null;
    L36:
        e = move-exception;
        String r7 = e.getClass().getName();     // Catch: Throwable -> L53
        String r8 = e.getMessage();     // Catch: Throwable -> L50
        xoa.a.a(e, "checkForUpdate exception", null);     // Catch: Throwable -> L48
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L70
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L70
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L70
        r4.put("duration", System.currentTimeMillis() - r0);     // Catch: JSONException -> L43 Throwable -> L70
        r9.put("exceptionType", r7);     // Catch: JSONException -> L43 Throwable -> L70
        r6.put("errInfo", r8);     // Catch: JSONException -> L43 Throwable -> L70
    L45:
        bpa.a.c("ukms_akexg", 2, r9, r4, r6);     // Catch: Throwable -> L70
    L46:
        monitor-exit(this);
        return;
    L43:
        e = move-exception;
        apa.a.c("DeviceSignKeyManager", "json", e);     // Catch: Throwable -> L70
    L48:
        th = move-exception;
        th = th;
    L52:
        r5 = r7;
    L55:
        Throwable r10 = th;
        r2 = true;
        String r11 = r5;
        boolean r12 = false;
    L56:
        if (r2 == false) goto L90;
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L70
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L70
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L70
        r13.put("duration", System.currentTimeMillis() - r0);     // Catch: JSONException -> L62 Throwable -> L70
        if (r12 == true) goto L65;
        r15.put("exceptionType", r11);     // Catch: JSONException -> L62 Throwable -> L70
        r14.put("errInfo", r8);     // Catch: JSONException -> L62 Throwable -> L70
    L65:
        if (r12 == true) goto L68;
        r3 = 2;
    L68:
        bpa.a.c("ukms_akexg", r3, r15, r13, r14);     // Catch: Throwable -> L70
        throw r10;     // Catch: Throwable -> L70
    L62:
        e = move-exception;
        apa.a.c("DeviceSignKeyManager", "json", e);     // Catch: Throwable -> L70
        goto L65
    L90:
        throw r10;     // Catch: Throwable -> L70
    L50:
        th = th;
        r8 = null;
    L53:
        th = th;
        r8 = null;
    L34:
        th = th;
    L35:
        r8 = null;
        r10 = th;
        r11 = null;
        r12 = true;
        goto L56
    L6:
        if (d.a().aKexgSetting.downgrade == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        if (AzerothPrivacy.getAppInfo().a() == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        if (NetworkUtils.isNetworkAvailable(AzerothPrivacy.getAppContext()) == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        a r16 = c();     // Catch: Throwable -> L34 Exception -> L36
        if (r16 == null) goto L82;
        if (r16.c <= (r0 / 1000)) goto L82;
        monitor-exit(this);
        return;
    L82:
        update();     // Catch: Throwable -> L32 Exception -> L36
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L70
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L70
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L70
        r17.put("duration", System.currentTimeMillis() - r0);     // Catch: JSONException -> L28 Throwable -> L70
    L30:
        bpa.a.c("ukms_akexg", 1, r19, r17, r18);     // Catch: Throwable -> L70
        goto L46
    L28:
        e = move-exception;
        apa.a.c("DeviceSignKeyManager", "json", e);     // Catch: Throwable -> L70
        goto L30
    L32:
        th = move-exception;
        th = th;
        r2 = true;
    L70:
        th = move-exception;
        throw th;
    }

    static {
        a = new Gson();
        b = new b();
    }

    public static a c() {
        if (AzerothPrivacy.getAppInfo().a() == false) goto L5;
        return null;
    L5:
        String r0 = AzerothPrivacy.getAppInfo().e;
        epa.a r2 = epa.a.b(AzerothPrivacy.getAppContext());
        String r3 = b(r0, "device_sign_key_version");
        r2.getClass();
        long r6 = epa.a.c(r3);
        if (r6 != 0) goto L9;
        return null;
    L9:
        if (zoa.a.c != null) goto L11;
        zoa.a.a();
    L11:
        zoa.a.C0035a r4 = zoa.a.c.a;
        String r5 = b(r0, "device_sign_key");
        r4.getClass();
        if (Build.VERSION.SDK_INT >= 23) goto L14;
    L16:
        boolean r7 = false;
    L18:
        if (r7 == true) goto L48;
    L25:
        r4.a.getClass();
        String r8 = AzerothPrivacy.getAppContext().getSharedPreferences("security_flow_azerothkeystore_key_sp", 0).getString(r5, null);
        if (TextUtils.isEmpty(r8) == false) goto L44;
    L39:
        PrivateKey r9 = null;
    L40:
        if (r9 != null) goto L42;
        return null;
    L42:
        epa.a r1 = epa.a.b(AzerothPrivacy.getAppContext());
        String r10 = b(r0, "device_sign_key_expire_time");
        r1.getClass();
        return new a(r9, r6, epa.a.c(r10));
    L44:
        r9 = KeyFactory.getInstance("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(Base64.decode(r8, 2)), c.a));     // Catch: Exception -> L32
    L32:
        e = move-exception;
        xoa.b r11 = xoa.a.a;
        xoa.a.a(e, "restore private key error", fpa.a.a());
    L34:
        e = move-exception;
        bpa.b r12 = new bpa.b("AzerothKeyStore.ECP256KeyManager.getPrivateKey", 2, e);
        if (r12.e != null) goto L38;
        r12.e = new HashMap();
    L38:
        ((HashMap) r12.e).put("keyBase64", r8);
        bpa.a.f(r12);
        goto L39
    L48:
        Key r13 = zoa.a.b.getKey(r5, null);     // Catch: Exception -> L23
        if (r13 == null) goto L25;
        r9 = (PrivateKey) r13;     // Catch: Exception -> L23
    L23:
        e = move-exception;
        bpa.a.f(new bpa.b("AzerothKeyStore.ECP256KeyManager.getPrivateKey", 1, e));
        goto L25
    L14:
        if (zoa.a.b == null) goto L16;
        r7 = true;
        goto L18
    }

    private void update() throws Exception {
        String r0 = AzerothPrivacy.getAppInfo().e;
        apa.a.a("DeviceSignKeyManager", "update start");
        if (zoa.a.c != null) goto L5;
        zoa.a.a();
    L5:
        zoa.a.C0035a r2 = zoa.a.c.a;
        String r3 = b(r0, "device_sign_key");
        r2.getClass();
        if (Build.VERSION.SDK_INT >= 23) goto L8;
    L10:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L68;
    L64:
        ECParameterSpec r5 = EllipticCurves.c(EllipticCurves.CurveType.NIST_P256);     // Catch: GeneralSecurityException -> L59
        KeyPairGenerator r6 = (KeyPairGenerator) lv7.b.c.a("EC");     // Catch: GeneralSecurityException -> L59
        r6.initialize(r5);     // Catch: GeneralSecurityException -> L59
        KeyPair r7 = r6.generateKeyPair();     // Catch: GeneralSecurityException -> L59
        r2.a.getClass();
        AzerothPrivacy.getAppContext().getSharedPreferences("security_flow_azerothkeystore_key_sp", 0).edit().putString(r3, Base64.encodeToString(((ECPrivateKey) r7.getPrivate()).getS().toByteArray(), 2)).apply();
        KeyPair r8 = r7;
    L19:
        epa.a r9 = epa.a.b(AzerothPrivacy.getAppContext());
        String r10 = b(r0, "device_sign_key_version");
        r9.getClass();
        epa.a.c.remove(r10);
        epa.a.c.commit();
        epa.a r11 = epa.a.b(AzerothPrivacy.getAppContext());
        String r12 = b(r0, "device_sign_key_expire_time");
        r11.getClass();
        epa.a.c.remove(r12);
        epa.a.c.commit();
        ECPublicKey r13 = (ECPublicKey) r8.getPublic();
        byte[] r14 = r13.getW().getAffineX().toByteArray();
        byte[] r15 = r13.getW().getAffineY().toByteArray();
        byte[] r16 = new byte[64];
        if (r14.length <= 32) goto L22;
        int r17 = r14.length - 32;
    L24:
        if (r14.length >= 32) goto L26;
        int r18 = 32 - r14.length;
    L27:
        System.arraycopy(r14, r17, r16, r18, Math.min(r14.length, 32));
        if (r15.length <= 32) goto L30;
        int r19 = r15.length - 32;
    L32:
        if (r15.length >= 32) goto L34;
        int r110 = 32 - r15.length;
    L35:
        System.arraycopy(r15, r19, r16, r110 + 32, Math.min(r15.length, 32));
        ByteBuffer r20 = ByteBuffer.allocate(80).order(ByteOrder.LITTLE_ENDIAN);
        r20.put(r16);
        r20.putLong(CastLongProtector.parseLong(r0));
        r20.putLong(CastLongProtector.parseLong(AzerothPrivacy.getAppInfo().d));
        Signature r21 = Signature.getInstance("SHA256withECDSA");
        r21.initSign(r8.getPrivate());
        r21.update(r20.array());
        byte[] r22 = r21.sign();
        HashMap r23 = new HashMap();
        r23.put("UID", Long.valueOf(CastLongProtector.parseLong(r0)));
        r23.put("DeviceID", Long.valueOf(CastLongProtector.parseLong(AzerothPrivacy.getAppInfo().d)));
        r23.put("ProtoVersion", 20241009);
        r23.put("ClientPK", Base64.encodeToString(r16, 2));
        r23.put("ClientSignature", Base64.encodeToString(r22, 2));
        r23.put("PriorCertVersion", Long.valueOf(uoa.c.a(AzerothPrivacy.getAppContext()).getSerialNumber().longValue()));
        HashMap r24 = new HashMap();
        r24.put(DownloadHelper.CONTENT_TYPE, "application/json");
        if (cpa.a.a != null) goto L38;
        Pair r25 = null;
    L39:
        if (r25 == null) goto L41;
        r24.put(r25.first, r25.second);
    L41:
        NetworkClient.ReqContext r26 = new NetworkClient.ReqContext();
        r26.addCommonParams = true;
        StringBuilder r27 = new StringBuilder("update device sign key req, headers: ");
        Gson r111 = a;
        r27.append(GsonProtectorUtils.toJson(r111, r24));
        r27.append(", body");
        r27.append(GsonProtectorUtils.toJson(r111, r23));
        apa.a.a("DeviceSignKeyManager", r27.toString());
        NetworkClient r28 = fpa.d.a;
        if (r28 != null) goto L45;
        r28 = NetworkClient.getDefault();
    L45:
        String r29 = r28.post(AzerothPrivacy.getSdkConfig().b.b, GsonProtectorUtils.toJson(r111, r23).getBytes(StandardCharsets.UTF_8), r24, r26);
        apa.a.a("DeviceSignKeyManager", "update device sign key resp: " + r29);
        a r30 = (a) GsonProtectorUtils.fromJson(r111, r29, a.class);     // Catch: JsonSyntaxException -> L56
        if (d(r30) == false) goto L52;
        epa.a r31 = epa.a.b(AzerothPrivacy.getAppContext());
        String r32 = b(r0, "device_sign_key_expire_time");
        long r33 = r30.expectExpiryTime;
        r31.getClass();
        epa.a.d(r32, r33);
        epa.a r34 = epa.a.b(AzerothPrivacy.getAppContext());
        String r1 = b(r0, "device_sign_key_version");
        long r35 = r30.keyVersion;
        r34.getClass();
        epa.a.d(r1, r35);
        apa.a.a("DeviceSignKeyManager", "update success");
        return;
    L52:
        throw new AzerothException("invalid resp sign", new f[]{new f(r29)});
    L53:
        e = move-exception;
        throw new AzerothException("verify resp sign", e, new f[]{new f(r29)});
    L56:
        e = move-exception;
        throw new AzerothException("json format", e, new f[]{new f(r29)});
    L38:
        r25 = cpa.a.a.getRequestTagHeader();
        goto L39
    L34:
        r110 = 0;
        goto L35
    L30:
        r19 = 0;
        goto L32
    L26:
        r18 = 0;
        goto L27
    L22:
        r17 = 0;
    L59:
        e = move-exception;
        bpa.a.f(new bpa.b("AzerothKeyStore.ECP256KeyManager.generateKeyPair", 2, e));
        throw e;
    L68:
        KeyPairGenerator r36 = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");     // Catch: Exception -> L15
        r36.initialize(new KeyGenParameterSpec.Builder(r3, 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests(new String[]{"SHA-256"}).build());     // Catch: Exception -> L15
        r8 = r36.generateKeyPair();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        bpa.a.f(new bpa.b("AzerothKeyStore.ECP256KeyManager.generateKeyPair", 1, e));
        goto L64
    L8:
        if (zoa.a.b == null) goto L10;
        r4 = true;
        goto L12
    }

    public b() {
    }

    public static boolean d(a r6) throws GeneralSecurityException {
        byte[] r0 = Base64.decode(r6.serverCert, 0);
        X509Certificate r2 = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r0));     // Catch: CertificateException -> L6
        r2.verify(uoa.c.a(AzerothPrivacy.getAppContext()).getPublicKey());
        ByteBuffer r3 = ByteBuffer.allocate((r0.length + 8) + 8).order(ByteOrder.LITTLE_ENDIAN);
        r3.put(r0);
        r3.putLong(r6.keyVersion);
        r3.putLong(r6.expectExpiryTime);
        byte[] r7 = Base64.decode(r6.serverSignature, 0);
        byte[] r1 = r3.array();
        Signature r4 = Signature.getInstance("SHA256withECDSA");
        r4.initVerify(r2.getPublicKey());
        r4.update(r1);
        return r4.verify(r7);
    L6:
        return false;
    }

    public static String b(String r1, String r2) {
        return r1 + "-" + r2;
    }
}
