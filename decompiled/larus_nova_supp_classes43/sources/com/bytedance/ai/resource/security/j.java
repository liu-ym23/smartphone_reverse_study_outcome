package com.bytedance.ai.resource.security;

import android.util.Base64;
import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptCryptoRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptCryptoResponse;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptResponseData;
import com.bytedance.ai.resource.core.bean.OpenPlatformPublicKeyListData;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final j a = null;
    public static final ConcurrentHashMap<String, b> b = null;
    public static final CoroutineScope c = null;

    public static final class a {
        public final String a;
        public final String b;
        public final byte[] c;
        public final PrivateKey d;
        public final byte[] e;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Arrays.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Arrays.hashCode(this.e);
        }

        public final String toString() {
            return "DebugDekDecryptRequestContext(requestId=" + this.a + ", requestJson=" + this.b + ", clientPublicKey=" + Arrays.toString(this.c) + ", privateKey=" + this.d + ", salt=" + Arrays.toString(this.e) + ')';
        }

        public a(String r10, String r11, byte[] r12, PrivateKey r13, byte[] r14) {
            Intrinsics.checkNotNullParameter(r10, "requestId");
            Intrinsics.checkNotNullParameter(r11, "requestJson");
            Intrinsics.checkNotNullParameter(r12, "clientPublicKey");
            Intrinsics.checkNotNullParameter(r13, "privateKey");
            Intrinsics.checkNotNullParameter(r14, "salt");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
        }
    }

    public static final class b {
        public final String a;
        public final long b;
        public final a c;
        public final Function0<Unit> d;
        public final Function1<Throwable, Unit> e;
        public final Job f;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r11.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            int r10 = (((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
            Job r11 = this.f;
            if (r11 != null) goto L5;
            int r12 = 0;
        L7:
            return r10 + r12;
        L5:
            r12 = r11.hashCode();
            goto L7
        }

        public final String toString() {
            return "PendingDebugDekRequest(packageName=" + this.a + ", versionCode=" + this.b + ", requestContext=" + this.c + ", resolve=" + this.d + ", reject=" + this.e + ", timeoutJob=" + this.f + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r10, long r11, a r12, Function0<Unit> r13, Function1<? super Throwable, Unit> r14, Job r15) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r12, "requestContext");
            Intrinsics.checkNotNullParameter(r13, "resolve");
            Intrinsics.checkNotNullParameter(r14, "reject");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
        }
    }

    public j() {
    }

    static {
        a = new j();
        b = new ConcurrentHashMap();
        c = CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static a a(byte[] r20) {
        KeyPairGenerator r0 = KeyPairGenerator.getInstance("EC");
        r0.initialize(new ECGenParameterSpec("secp256r1"));
        KeyPair r1 = r0.generateKeyPair();
        byte[] r10 = g(r1);
        String r11 = UUID.randomUUID().toString();
        byte[] r12 = new byte[16];
        new SecureRandom().nextBytes(r12);
        byte[] r13 = new byte[16];
        new SecureRandom().nextBytes(r13);
        long r16 = System.currentTimeMillis() / 1000;
        OpenPlatformDekDecryptCryptoRequest r14 = new OpenPlatformDekDecryptCryptoRequest(null, Base64.encodeToString(r10, 2), Base64.encodeToString(r12, 2), Base64.encodeToString(r13, 2), r16, 1, null);
        JSONObject r15 = new JSONObject().put(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ID, r11).put("wrapped_dek", Base64.encodeToString(r20, 2)).put("crypto", new JSONObject(com.bytedance.ai.applet.base.gson.e.c(r14)));
        return new a(r11, new JSONObject().put("method", "Applet_DecryptDEK").put("params", r15).toString(), r10, r1.getPrivate(), r12);
    }

    public static Pair e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appKey");
        Lazy r1 = o5.b.a;
        Intrinsics.checkNotNullParameter(r10, "appKey");
        OpenPlatformBaseResponse<OpenPlatformPublicKeyListData> r11 = o5.b.a().getSignPublicKeys(r10);
        boolean r12 = true;
        if (r11.getCode() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L34;
        OpenPlatformPublicKeyListData r13 = r11.getData();
        if (r13 == null) goto L32;
        Map<String, String> r14 = r13.getKeys();
        String r15 = r13.getVersion();
        if (r14 != null) goto L12;
    L15:
        boolean r16 = true;
    L16:
        if (r16 == true) goto L30;
        if (r15 != null) goto L19;
    L22:
        if (r12 == true) goto L30;
        LinkedHashMap r17 = new LinkedHashMap(r14.size());
        Iterator<Map.Entry<String, String>> r18 = r14.entrySet().iterator();
    L25:
        if (r18.hasNext() == false) goto L28;
        Map.Entry<String, String> r19 = r18.next();
        String r20 = r19.getKey();
        String r21 = r19.getValue();
        a.getClass();
        long r22 = CastLongProtector.parseLong(StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.trim(r20).toString(), "0x"), "0X"), CharsKt.checkRadix(16));
        r17.put(Long.valueOf(r22), KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(r21, 0))));
        goto L25
    L28:
        return new Pair(r15, r17);
    L19:
        if (r15.length() == 0) goto L22;
        r12 = false;
    L30:
        throw new IllegalStateException("fetch sign public keys failed: INVALID results");
    L12:
        if (r14.isEmpty() == true) goto L15;
        r16 = false;
        goto L16
    L32:
        throw new IllegalStateException("fetch sign public keys failed: data is NULL");
    L34:
        throw new IllegalStateException("fetch sign public keys failed: " + r11.getCode() + ' ' + r11.getMessage());
    L5:
        r0 = false;
        goto L6
    }

    public static byte[] f(byte[] r10) {
        if (r10.length != 32) goto L5;
        return r10;
    L5:
        byte[] r0 = new byte[32];
        if (r10.length <= 32) goto L8;
        System.arraycopy(r10, r10.length - 32, r0, 0, 32);
    L9:
        return r0;
    L8:
        System.arraycopy(r10, 0, r0, 32 - r10.length, r10.length);
        goto L9
    }

    public static byte[] g(KeyPair r10) {
        PublicKey r11 = r10.getPublic();
        if ((r11 instanceof ECPublicKey) == false) goto L5;
        ECPublicKey r12 = (ECPublicKey) r11;
    L6:
        if (r12 == null) goto L10;
        ECPoint r13 = r12.getW();
        byte[] r0 = f(r13.getAffineX().toByteArray());
        byte[] r14 = f(r13.getAffineY().toByteArray());
        byte[] r1 = new byte[65];
        r1[0] = 4;
        System.arraycopy(r0, 0, r1, 1, 32);
        System.arraycopy(r14, 0, r1, 33, 32);
        return r1;
    L10:
        throw new IllegalArgumentException("not ec public key");
    L5:
        r12 = null;
        goto L6
    }

    public static byte[] b(a r10, JSONObject r11) {
        if (r11.optBoolean("success", false) == false) goto L44;
        JSONObject r0 = r11.optJSONObject("crypto");
        if (r0 == null) goto L42;
        String r12 = r0.optString("server_pub");
        boolean r13 = true;
        if (r12 != null) goto L9;
    L12:
        boolean r14 = true;
    L13:
        if (r14 == true) goto L40;
        String r1 = r0.optString("srv_iv");
        if (r1 != null) goto L17;
    L20:
        boolean r15 = true;
    L21:
        if (r15 == true) goto L38;
        String r16 = r11.optString("dek_cipher");
        if (r16 != null) goto L25;
    L28:
        if (r13 == true) goto L36;
        byte[] r17 = Base64.decode(r12, 0);
        byte[] r18 = Base64.decode(r1, 0);
        byte[] r19 = Base64.decode(r16, 0);
        if (r18.length != 12) goto L34;
        PrivateKey r20 = r10.d;
        byte[] r21 = r10.c;
        byte[] r22 = r10.e;
        Intrinsics.checkNotNull(r17);
        Intrinsics.checkNotNull(r18);
        Intrinsics.checkNotNull(r19);
        return d(r20, r21, r22, r17, r18, r19);
    L34:
        throw new IllegalArgumentException("srv_iv must be 12 bytes");
    L36:
        throw new IllegalStateException("missing dek_cipher in response");
    L25:
        if (StringsKt.isBlank(r16) == true) goto L28;
        r13 = false;
        goto L28
    L38:
        throw new IllegalStateException("missing srv_iv in response");
    L17:
        if (StringsKt.isBlank(r1) == true) goto L20;
        r15 = false;
        goto L21
    L40:
        throw new IllegalStateException("missing server_pub in response");
    L9:
        if (StringsKt.isBlank(r12) == true) goto L12;
        r14 = false;
        goto L13
    L42:
        throw new IllegalArgumentException("crypto is empty");
    L44:
        throw new IllegalStateException(r11.optString(com.bytedance.android.ec.core.event.a.KEY_MSG, "debug DEK decrypt failed"));
    }

    public static byte[] c(String r20, byte[] r21) {
        Intrinsics.checkNotNullParameter(r20, "appKey");
        Intrinsics.checkNotNullParameter(r21, "wrappedDekBytes");
        KeyPairGenerator r10 = KeyPairGenerator.getInstance("EC");
        r10.initialize(new ECGenParameterSpec("secp256r1"));
        KeyPair r11 = r10.generateKeyPair();
        byte[] r12 = g(r11);
        byte[] r13 = new byte[16];
        new SecureRandom().nextBytes(r13);
        byte[] r14 = new byte[16];
        new SecureRandom().nextBytes(r14);
        OpenPlatformDekDecryptRequest r15 = new OpenPlatformDekDecryptRequest(Base64.encodeToString(r21, 2), new OpenPlatformDekDecryptCryptoRequest(null, Base64.encodeToString(r12, 2), Base64.encodeToString(r13, 2), Base64.encodeToString(r14, 2), System.currentTimeMillis() / 1000, 1, null));
        Lazy r1 = o5.b.a;
        Intrinsics.checkNotNullParameter(r20, "appKey");
        Intrinsics.checkNotNullParameter(r15, "request");
        OpenPlatformBaseResponse<OpenPlatformDekDecryptResponseData> r0 = o5.b.a().decryptDek(r20, r15);
        if (r0.getCode() != 0) goto L5;
        boolean r16 = true;
    L6:
        if (r16 == false) goto L34;
        OpenPlatformDekDecryptResponseData r17 = r0.getData();
        if (r17 == null) goto L32;
        OpenPlatformDekDecryptCryptoResponse r18 = r17.getCrypto();
        if (r18 == null) goto L30;
        String r19 = r18.getServerPub();
        if (r19 == null) goto L28;
        String r22 = r18.getSrvIv();
        if (r22 == null) goto L26;
        String r23 = r17.getDekCipher();
        if (r23 == null) goto L24;
        byte[] r24 = Base64.decode(r19, 0);
        byte[] r25 = Base64.decode(r22, 0);
        byte[] r26 = Base64.decode(r23, 0);
        if (r25.length != 12) goto L22;
        PrivateKey r27 = r11.getPrivate();
        Intrinsics.checkNotNull(r24);
        Intrinsics.checkNotNull(r25);
        Intrinsics.checkNotNull(r26);
        return d(r27, r12, r13, r24, r25, r26);
    L22:
        throw new IllegalArgumentException("srv_iv must be 12 bytes");
    L24:
        throw new IllegalStateException("missing dek_cipher in response");
    L26:
        throw new IllegalStateException("missing srv_iv in response");
    L28:
        throw new IllegalStateException("missing server_pub in response");
    L30:
        throw new IllegalStateException("missing crypto in response");
    L32:
        throw new IllegalStateException("empty data");
    L34:
        throw new IllegalStateException("decrypt dek failed: " + r0.getCode() + ' ' + r0.getMessage());
    L5:
        r16 = false;
        goto L6
    }

    public static byte[] d(PrivateKey r10, byte[] r11, byte[] r12, byte[] r13, byte[] r14, byte[] r15) {
        if (r13.length != 65) goto L18;
        int r0 = 0;
        if (r13[0] != 4) goto L18;
        ECPoint r1 = new ECPoint(new BigInteger(1, ArraysKt.copyOfRange(r13, 1, 33)), new BigInteger(1, ArraysKt.copyOfRange(r13, 33, 65)));
        KeyPairGenerator r16 = KeyPairGenerator.getInstance("EC");
        r16.initialize(new ECGenParameterSpec("secp256r1"));
        PublicKey r17 = r16.generateKeyPair().getPublic();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        PublicKey r18 = KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(r1, ((ECPublicKey) r17).getParams()));
        KeyAgreement r19 = KeyAgreement.getInstance("ECDH");
        r19.init(r10);
        r19.doPhase(r18, true);
        byte[] r20 = r19.generateSecret();
        Intrinsics.checkNotNull(r20);
        byte[] r21 = f(r20);
        int r110 = com.bytedance.ai.resource.security.a.a;
        Intrinsics.checkNotNullParameter("pwd-transfer-v1|resp|", "s");
        byte[][] r22 = {"pwd-transfer-v1|resp|".getBytes(StandardCharsets.UTF_8), r11};
        Intrinsics.checkNotNullParameter(r22, "parts");
        ByteArrayOutputStream r23 = new ByteArrayOutputStream();
        int r24 = 0;
    L7:
        if (r24 >= 2) goto L9;
        r23.write(r22[r24]);
        r24 = r24 + 1;
        goto L7
    L9:
        byte[] r25 = r23.toByteArray();
        Intrinsics.checkNotNullParameter(r12, "salt");
        Intrinsics.checkNotNullParameter(r21, "ikm");
        Intrinsics.checkNotNullParameter(r25, "info");
        Mac r26 = Mac.getInstance("HmacSHA256");
        r26.init(new SecretKeySpec(r12, "HmacSHA256"));
        byte[] r27 = r26.doFinal(r21);
        ByteArrayOutputStream r111 = new ByteArrayOutputStream(32);
        byte[][] r28 = {new byte[0], r25, new byte[]{(byte) 1}};
        Intrinsics.checkNotNullParameter(r28, "parts");
        ByteArrayOutputStream r29 = new ByteArrayOutputStream();
    L10:
        if (r0 >= 3) goto L12;
        r29.write(r28[r0]);
        r0 = r0 + 1;
        goto L10
    L12:
        byte[] r30 = r29.toByteArray();
        Mac r31 = Mac.getInstance("HmacSHA256");
        r31.init(new SecretKeySpec(r27, "HmacSHA256"));
        r111.write(r31.doFinal(r30));
        byte[] r32 = r111.toByteArray();
        Intrinsics.checkNotNull(r32);
        byte[] r33 = Arrays.copyOf(r32, 32);
        Cipher r34 = Cipher.getInstance("AES/GCM/NoPadding");
        r34.init(2, new SecretKeySpec(r33, "AES"), new GCMParameterSpec(128, r14));
        byte[] r35 = r34.doFinal(r15);
        if (r35.length != 32) goto L16;
        return r35;
    L16:
        throw new IllegalArgumentException("DEK must be 32 bytes, got " + r35.length);
    L18:
        throw new IllegalArgumentException("pub must be 65-byte uncompressed: 0x04||X||Y");
    }
}
