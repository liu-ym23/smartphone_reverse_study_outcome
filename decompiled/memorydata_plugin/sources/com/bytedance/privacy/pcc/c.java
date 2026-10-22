package com.bytedance.privacy.pcc;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.ttnet.TTNetInit;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.capabilitykit.common.ErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3076a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f3077b = null;

    static {
        f3077b = new EvidenceTokenVerifier$1();
    }

    private c() {
    }

    private static PublicKey a(String r3) {
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(Base64.decode(r3.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replace("\n", "").replace("\r", "").trim(), 0)));
    L5:
        e = move-exception;
        com.bytedance.privacy.e.c.d(f3076a, "pemStringToPublicKey failed: " + e.getMessage());
        return null;
    }

    public static boolean a(String r16, String r17, String r18, String r19, String r20, com.bytedance.privacy.pcc.b.a.c.d r21) {
        if (com.bytedance.privacy.c.b.a().b() == false) goto L5;
        String r2 = TTNetInit.DOMAIN_BOE_KEY;
    L6:
        String r3 = f3076a;
        com.bytedance.privacy.e.c.a(r3, "verify: start V2 JWT evidence token verification (env=" + r2 + ")");
        String[] r4 = r16.split("\\.");
        if (r4.length != 3) goto L163;
        String r7 = r4[0];
        String r9 = r4[1];
        String r5 = r4[2];
        JsonObject r11 = JsonParser.parseString(new String(Base64.decode(r7, 11), StandardCharsets.UTF_8)).getAsJsonObject();
        String r14 = "";
        if (r11.has("typ") == false) goto L11;
        String r12 = r11.get("typ").getAsString();
    L13:
        if ("JWT".equals(r12) == false) goto L161;
        if (r11.has("alg") == false) goto L18;
        r14 = r11.get("alg").getAsString();
    L18:
        if ("ES256".equals(r14) == false) goto L159;
        if (r11.has("ver") == false) goto L22;
        int r13 = r11.get("ver").getAsInt();
    L24:
        if (r13 != 1100) goto L157;
        if (r11.has("kid") == false) goto L155;
        String r15 = r11.get("kid").getAsString();
        com.bytedance.privacy.e.c.a(r3, "verify: header parsed");
        JsonObject r110 = JsonParser.parseString(new String(Base64.decode(r9, 11), StandardCharsets.UTF_8)).getAsJsonObject();
        com.bytedance.privacy.e.c.a(r3, "verify: payload parsed successfully");
        if (r110.has("iss") == false) goto L153;
        String r111 = r110.get("iss").getAsString();
        com.bytedance.privacy.e.c.b(r3, "verify: issuer parsed");
        if ("TKMS-Auth-Center-TEE".equals(r111) == false) goto L32;
    L36:
        String r6 = r2 + "_" + r111 + "_" + r15;
        com.bytedance.privacy.e.c.a(r3, "verify: looking up verification key");
        Map<String, String> r8 = f3077b;
        if (r8.containsKey(r6) == false) goto L151;
        PublicKey r10 = a((String) ZeusTransformUtils.preCheckCast(r8.get(r6), String.class, "com.obric.memorydata.plugin"));
        if (r10 == null) goto L149;
        com.bytedance.privacy.e.c.a(r3, "verify: public key obtained");
        byte[] r22 = a(Base64.decode(r5, 11));
        byte[] r23 = (r7 + "." + r9).getBytes(StandardCharsets.UTF_8);
        Signature r24 = Signature.getInstance("SHA256withECDSA");
        r24.initVerify(r10);
        r24.update(r23);
        if (r24.verify(r22) == false) goto L147;
        com.bytedance.privacy.e.c.a(r3, "verify: JWT signature valid");
        long r25 = System.currentTimeMillis() / 1000;
        if (r110.has("nbf") == false) goto L50;
        long r112 = r110.get("nbf").getAsLong();
        if (r25 >= r112) goto L50;
        throw new Exception("JWT not yet valid: nbf=" + r112 + " now=" + r25);
    L50:
        if (r110.has("exp") == false) goto L56;
        long r113 = r110.get("exp").getAsLong();
        if (r25 <= r113) goto L56;
        throw new Exception("JWT expired: exp=" + r113 + " now=" + r25);
    L56:
        com.bytedance.privacy.e.c.a(r3, "verify: time validation OK (now=" + r25 + ")");
        if (r110.has("service_id") == false) goto L145;
        String r26 = r110.get("service_id").getAsString();
        if (r26.equals(r18) == true) goto L61;
        com.bytedance.privacy.e.c.c(r3, "service_id mismatch: expected=" + r18 + " got=" + r26);
        com.bytedance.privacy.e.c.c(r3, "verify: service_id validation skipped (known issue in current server implementation)");
    L61:
        com.bytedance.privacy.e.c.b(r3, "verify: service_id=" + r26 + " (expected appSvcId=" + r18 + ")");
        String r27 = a.a(a.a(a(r17, r18, r19, r20, r21)).getBytes(StandardCharsets.UTF_8));
        if ("TKMS-Auth-Center".equals(r111) == false) goto L94;
        com.bytedance.privacy.e.c.b(r3, "verify: Non-TEE cluster, verifying extra fields");
        if (r110.has(WsConstants.KEY_EXTRA) == false) goto L92;
        JsonObject r28 = r110.getAsJsonObject(WsConstants.KEY_EXTRA);
        if (r28.has("app_id") == false) goto L90;
        String r29 = r28.get("app_id").getAsString();
        com.bytedance.privacy.e.c.a(r3, "verify: extra.app_id=" + r29 + " (expected=" + r17 + ")");
        if (r29.equals(r17) == false) goto L88;
        com.bytedance.privacy.e.c.b(r3, "verify: extra.app_id match OK");
        if (r28.has("svc_id") == false) goto L86;
        String r0 = r28.get("svc_id").getAsString();
        com.bytedance.privacy.e.c.a(r3, "verify: extra.svc_id=" + r0 + " (expected=" + r18 + ")");
        if (r0.equals(r18) == false) goto L84;
        com.bytedance.privacy.e.c.b(r3, "verify: extra.svc_id match OK");
        if (r28.has("user_data") == false) goto L82;
        if (TextUtils.equals(r27, r28.get("user_data").getAsString()) == false) goto L80;
        String r1 = "verify: extra.user_data match OK";
    L78:
        com.bytedance.privacy.e.c.b(r3, r1);
    L142:
        com.bytedance.privacy.e.c.b(r3, "verify: V2 JWT evidence token verification completed successfully");
        return true;
    L80:
        throw new Exception("extra.user_data mismatch");
    L82:
        throw new Exception("JWT extra missing 'user_data' field");
    L84:
        throw new Exception("extra.svc_id mismatch");
    L86:
        throw new Exception("JWT extra missing 'svc_id' field");
    L88:
        throw new Exception("extra.app_id mismatch");
    L90:
        throw new Exception("JWT extra missing 'app_id' field");
    L92:
        throw new Exception("JWT payload missing 'extra' field for Non-TEE issuer");
    L94:
        if ("TKMS-Auth-Center-TEE".equals(r111) == false) goto L142;
        com.bytedance.privacy.e.c.b(r3, "verify: TEE cluster, verifying tdx fields");
        if (r110.has("tdx") == false) goto L141;
        JsonObject r30 = r110.getAsJsonObject("tdx");
        String r31 = null;
        String r32 = null;
        if (r30.has("quote") == false) goto L115;
        JsonObject r33 = r30.getAsJsonObject("quote");
        if (r33 == null) goto L115;
        if (r33.isJsonNull() == true) goto L115;
        if (r33.has("body") == false) goto L115;
        JsonObject r34 = r33.getAsJsonObject("body");
        if (r34 == null) goto L115;
        if (r34.isJsonNull() == true) goto L115;
        if (r34.has("reportdata") == false) goto L113;
        r31 = r34.get("reportdata").getAsString();
        r32 = "tdx.quote.body.reportdata";
        goto L115
    L113:
        if (r34.has("report_data") == false) goto L115;
        r31 = r34.get("report_data").getAsString();
        r32 = "tdx.quote.body.report_data";
    L115:
        if (r31 == null) goto L117;
    L119:
        StringBuilder r35 = new StringBuilder().append("verify: report_data source=").append(r32).append(" (len=");
        if (r31 == null) goto L122;
        int r36 = r31.length();
    L123:
        com.bytedance.privacy.e.c.b(r3, r35.append(r36).append(")").toString());
        if (r31 != null) goto L126;
    L135:
        if (r31 != null) goto L137;
        String r37 = "field is null";
    L139:
        throw new Exception("JWT tdx.report_data missing or empty (" + r37 + ") for TEE issuer");
    L137:
        r37 = "field is empty string";
        goto L139
    L126:
        if (r31.isEmpty() == true) goto L135;
        if (TextUtils.equals(r27, r31) == false) goto L134;
        com.bytedance.privacy.e.c.b(r3, "verify: tdx.report_data match OK");
        if (r30.has("dcap_verify_result") == false) goto L142;
        r1 = "verify: tdx.dcap_verify_result=" + r30.get("dcap_verify_result").getAsString();
        goto L78
    L134:
        throw new Exception("tdx.report_data mismatch");
    L122:
        r36 = 0;
        goto L123
    L117:
        if (r30.has("report_data") == false) goto L119;
        r31 = r30.get("report_data").getAsString();
        r32 = "tdx.report_data";
        goto L119
    L141:
        throw new Exception("JWT payload missing 'tdx' field for TEE issuer");
    L145:
        throw new Exception("JWT payload missing 'service_id' field");
    L147:
        throw new Exception("JWT ECDSA signature verification failed");
    L149:
        throw new Exception("failed to parse public key for: " + r6);
    L151:
        throw new Exception("public key not found for evidence token");
    L32:
        if ("TKMS-Auth-Center".equals(r111) == true) goto L36;
        throw new Exception("unknown issuer: '" + r111 + "', expected TKMS-Auth-Center-TEE or TKMS-Auth-Center");
    L153:
        throw new Exception("JWT payload missing 'iss' field");
    L155:
        throw new Exception("JWT header missing 'kid' field");
    L157:
        throw new Exception("unsupported JWT ver: " + r13 + ", expected " + ErrorCode.Contacts.PHONE_NO_PAGE_ERROR);
    L22:
        r13 = 0;
        goto L24
    L159:
        throw new Exception("unsupported JWT alg: '" + r14 + "', expected ES256");
    L161:
        throw new Exception("invalid JWT typ: '" + r12 + "', expected JWT");
    L11:
        r12 = "";
        goto L13
    L163:
        throw new Exception("invalid JWT format: expected 3 parts, got " + r4.length);
    L5:
        r2 = "prod";
        goto L6
    }

    private static byte[] a(String r2, String r3, String r4, String r5, com.bytedance.privacy.pcc.b.a.c.d r6) {
        MessageDigest r0 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        r0.update(r2.getBytes(StandardCharsets.UTF_8));
        r0.update(r3.getBytes(StandardCharsets.UTF_8));
        r0.update(r4.getBytes(StandardCharsets.UTF_8));
        r0.update(r5.getBytes(StandardCharsets.UTF_8));
        if (r6 == null) goto L14;
        if (r6.b() == null) goto L8;
        r0.update(r6.b().getBytes(StandardCharsets.UTF_8));
    L8:
        if (r6.c() == null) goto L11;
        r0.update(r6.c().getBytes(StandardCharsets.UTF_8));
    L11:
        if (r6.d() == null) goto L14;
        r0.update(r6.d().getBytes(StandardCharsets.UTF_8));
    L14:
        return r0.digest();
    }

    private static byte[] a(byte[] r6) {
        int r0 = r6.length / 2;
        byte[] r3 = b(Arrays.copyOfRange(r6, 0, r0));
        byte[] r7 = b(Arrays.copyOfRange(r6, r0, r6.length));
        int r1 = ((r3.length + 2) + 2) + r7.length;
        byte[] r4 = new byte[r1 + 2];
        r4[0] = 48;
        r4[1] = (byte) r1;
        r4[2] = 2;
        r4[3] = (byte) r3.length;
        System.arraycopy(r3, 0, r4, 4, r3.length);
        int r5 = 4 + r3.length;
        int r2 = r5 + 1;
        r4[r5] = 2;
        r4[r2] = (byte) r7.length;
        System.arraycopy(r7, 0, r4, r2 + 1, r7.length);
        return r4;
    }

    private static byte[] b(byte[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= (r4.length - 1)) goto L9;
        if (r4[r0] != 0) goto L9;
        r0 = r0 + 1;
    L9:
        if ((r4[r0] & 128) == 0) goto L13;
        byte[] r1 = new byte[(r4.length - r0) + 1];
        System.arraycopy(r4, r0, r1, 1, r4.length - r0);
        return r1;
    L13:
        return Arrays.copyOfRange(r4, r0, r4.length);
    }
}
