package com.bytedance.privacy.pcc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class PccManager {
    private static final String CLOUD_CERT_BOE = "-----BEGIN CERTIFICATE-----\nMIICNTCCAdqgAwIBAgIUGJmWDf76XK7QEDg7ePQ6Zp5a/QAwCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQwODE4MzVaFw00MTAyMjgwODI4MzRaMGUxEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEuMCwGA1UEAxMlQk9FIEJ5\ndGVEYW5jZSBTbWFydCBTaWduIE9QQ0MgR2F0ZXdheTBZMBMGByqGSM49AgEGCCqG\nSM49AwEHA0IABM25nWwFbu/tBeKoSdmqIEFzkGsiNlVBzp++3/y3PSAl3X5JQ98U\nkN8af1gEabmQWsnQ6rfAu+/3N1eLdaeyAH+jdjB0MAwGA1UdEwEB/wQCMAAwHwYD\nVR0jBBgwFoAUI3ocFBGPZx1O0yRJxLCCPmaMCkwwQwYIKwYBBQUHAQEENzA1MDMG\nCCsGAQUFBzABhidodHRwOi8vbmV4dXMtYm9lLmJ5dGVkYW5jZS5uZXQvcGNhL29j\nc3AwCgYIKoZIzj0EAwIDSQAwRgIhANzuvWkxo2IGpnbJNEWvZRuyp/brvmy9u76P\nRj9AkGSzAiEAuxwuHmrS6OmMWFi5ha9DpqLJijiXzNEKcdVYsJuAFTY=\n-----END CERTIFICATE-----";
    private static final String CLOUD_CERT_ONLINE = "-----BEGIN CERTIFICATE-----\nMIICODCCAd2gAwIBAgIUGJmcpAzL0+i5GIb6FxhoxPQSMtswCgYIKoZIzj0EAwIw\nVzESMBAGA1UEChMJQnl0ZURhbmNlMR8wHQYDVQQLExZCeXRlRGFuY2UgU21hcnQg\nRGV2aWNlMSAwHgYDVQQDExdCeXRlRGFuY2UgU21hcnQgU0lHTiBDQTAeFw0yNjAz\nMDQxMDE5MTZaFw00MTAyMjgxMDI5MTZaMGExEjAQBgNVBAoTCUJ5dGVEYW5jZTEf\nMB0GA1UECxMWQnl0ZURhbmNlIFNtYXJ0IERldmljZTEqMCgGA1UEAxMhQnl0ZURh\nbmNlIFNtYXJ0IFNpZ24gT1BDQyBHYXRld2F5MFkwEwYHKoZIzj0CAQYIKoZIzj0D\nAQcDQgAE1eO/rIuiv0g/zgUMel9/Jyv3msFzoimqEuwjFIRJGKKe51ONP9jMv7zP\ng/IuRK5HFR3IMZYjz507Az0wuT8jIKN9MHswDAYDVR0TAQH/BAIwADAfBgNVHSME\nGDAWgBRgISfbugqIUe075DXEeifDk4vhATBKBggrBgEFBQcBAQQ+MDwwOgYIKwYB\nBQUHMAGGLmh0dHA6Ly9uZXh1cy1wcm9kdWN0aW9uLmJ5dGVkYW5jZS5uZXQvcGNh\nL29jc3AwCgYIKoZIzj0EAwIDSQAwRgIhAM5X3JaXiaAD1sFDDFpRB5rNQS3G7mSc\nGDbtKnvJ3SQ4AiEAwH5JexV4T1BLcNoZctl6iOo5JeUbEwZ11lVi0fzXPI0=\n-----END CERTIFICATE-----";
    private static final int DATA_PROTOCOL_VERSION = 2;
    public static final String HEADER_LANE_TYPE = "rpc-persist-lane-c-ocean-secure";
    private static final int KEY_ENVELOPE_VERSION = 2;
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_LANE_TYPE = "lane_type";

    @Deprecated
    public static final int LANE_TYPE_CPU_NORMAL = 1;

    @Deprecated
    public static final int LANE_TYPE_CPU_TEE = 2;

    @Deprecated
    public static final int LANE_TYPE_GPU_TEE = 3;

    @Deprecated
    public static final int LANE_TYPE_IGNORE = 0;
    private static final int MAX_STRING_LENGTH = 512;
    private static final String PCC_CLIENT_VERSION = "2.0.0";
    private static final String PCC_PROTOCOL_VERSION = "2.0";
    private static final String PCC_SIGN_KEY_ALIAS = "pcc_sign_key";
    private static final String TAG = "PccManager";
    private static volatile PccManager pccManager;
    private Context appContext;
    private com.bytedance.privacy.pcc.a.b channelDb;
    private final Map<String, a> sessionContextCache;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AppInfo f3039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f3040b;
        final String c;
        final KeyPair d;
        final com.bytedance.privacy.pcc.b.a.c.d e;
        final byte[] f;

        a(AppInfo r1, int r2, String r3, KeyPair r4, com.bytedance.privacy.pcc.b.a.c.d r5, byte[] r6) {
            this.f3039a = r1;
            this.f3040b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
    }

    private PccManager() {
        this.sessionContextCache = new ConcurrentHashMap();
    }

    private void attachContext(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.appContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.channelDb = new com.bytedance.privacy.pcc.a.b(this.appContext);
        return;
    }

    private Bundle createResultBundle(int r2, int r3) {
        Bundle r1 = new Bundle();
        r1.putInt("error_code", r2);
        r1.putInt(KEY_LANE_TYPE, r3);
        return r1;
    }

    private Bundle createResultBundle(int r1, LaneType r2) {
        return createResultBundle(r1, r2.getValue());
    }

    public static PccManager getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (pccManager != null) goto L15;
        monitor-enter(PccManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (pccManager != null) goto L9;
        pccManager = new PccManager();     // Catch: Throwable -> L11
        pccManager.attachContext(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(PccManager.class);     // Catch: Throwable -> L11
    L15:
        return pccManager;
    }

    private boolean isChannelExpired(com.bytedance.privacy.pcc.b.a.c r8) {
        String r7 = r8.e();
        if (TextUtils.isEmpty(r7) == false) goto L13;
        return true;
    L13:
        if ((System.currentTimeMillis() / 1000) >= Long.parseLong(r7)) goto L15;
        return false;
    L15:
        return true;
    L11:
        com.bytedance.privacy.e.c.d(TAG, "isChannelExpired: invalid expiry format: " + r7);
        return true;
    }

    private static boolean isValidAppInfo(AppInfo r1) {
        if (r1 != null) goto L4;
    L12:
        return false;
    L4:
        if (isValidString(r1.rpdid) == false) goto L12;
        if (isValidString(r1.rpuid) == false) goto L12;
        if (isValidString(r1.appId) == false) goto L12;
        if (isValidString(r1.appSvcId) == false) goto L12;
        return true;
    }

    private static boolean isValidBytes(byte[] r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length <= 0) goto L6;
        return true;
    }

    private static boolean isValidString(String r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.length() <= 0) goto L8;
        if (r1.length() >= 512) goto L8;
        return true;
    }

    private static int parseKeyVersion(String r4) {
        if (r4 != null) goto L5;
    L10:
        return 0;
    L5:
        if (r4.isEmpty() == true) goto L10;
        return Integer.parseInt(r4);
    L9:
        com.bytedance.privacy.e.c.d(TAG, "parseKeyVersion: non-integer '" + r4 + "', defaulting to 0");
        goto L10
    }

    private com.bytedance.privacy.pcc.b.a.c queryChannelFromDb(AppInfo r4) {
        com.bytedance.privacy.pcc.a.b r3 = this.channelDb;
        if (r3 != null) goto L7;
        com.bytedance.privacy.e.c.d(TAG, "queryChannelFromDb: DB not ready");
        return null;
    L7:
        return r3.query(r4.rpdid, r4.rpuid, r4.appId, r4.appSvcId);
    }

    private boolean verifyCloudSignature(com.bytedance.privacy.pcc.b.a.c r6) {
        boolean r5 = com.bytedance.privacy.c.b.a().b();
        if (r5 == false) goto L5;
        String r0 = CLOUD_CERT_BOE;
    L6:
        String r1 = TAG;
        StringBuilder r2 = new StringBuilder().append("verifyCloudSignature: env=");
        if (r5 == false) goto L9;
        String r7 = "BOE";
    L10:
        com.bytedance.privacy.e.c.a(r1, r2.append(r7).toString());
        if (TextUtils.isEmpty(r6.h()) == false) goto L22;
        com.bytedance.privacy.e.c.d(r1, "verifyCloudSignature: server signature is empty");
        return false;
    L22:
        boolean r8 = com.bytedance.privacy.pcc.a.a(r0, (r6.g() + "|" + r6.f()).getBytes(StandardCharsets.UTF_8), Base64.decode(r6.h(), 8));     // Catch: Exception -> L19
        if (r8 == true) goto L17;
        com.bytedance.privacy.e.c.d(r1, "verifyCloudSignature: ECDSA verification failed");     // Catch: Exception -> L19
    L18:
        return r8;
    L17:
        com.bytedance.privacy.e.c.b(r1, "verifyCloudSignature: signature valid");     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.bytedance.privacy.e.c.d(TAG, "verifyCloudSignature exception: " + e.getMessage());
        return false;
    L9:
        r7 = "Online";
        goto L10
    L5:
        r0 = CLOUD_CERT_ONLINE;
        goto L6
    }

    private boolean verifyEvidenceToken(com.bytedance.privacy.pcc.b.a.c r8, String r9, String r10, AppInfo r11) {
        com.bytedance.privacy.pcc.b.a.c.a r7 = r8.b();
        if (r7 != null) goto L6;
        com.bytedance.privacy.e.c.d(TAG, "verifyEvidenceToken: evidence_info is missing");
        return false;
    L6:
        String r1 = r7.a();
        if (TextUtils.isEmpty(r1) == false) goto L10;
        com.bytedance.privacy.e.c.d(TAG, "verifyEvidenceToken: evidence_token is empty");
        return false;
    L10:
        com.bytedance.privacy.pcc.b.a.c.d r12 = null;
        com.bytedance.privacy.pcc.b.a.c.C0153c r13 = r8.a();
        if (r13 == null) goto L19;
        r12 = r13.a();
    L19:
        boolean r14 = c.a(r1, r11.appId, r11.appSvcId, r9, r10, r12);     // Catch: Exception -> L16
        com.bytedance.privacy.e.c.a(TAG, "verifyEvidenceToken: result=" + r14);     // Catch: Exception -> L16
        return r14;
    L16:
        e = move-exception;
        com.bytedance.privacy.e.c.d(TAG, "verifyEvidenceToken exception: " + Log.getStackTraceString(e));
        return false;
    }

    public int closeSecuritySession(String r5) {
        String r0 = TAG;
        com.bytedance.privacy.e.c.a(r0, "closeSecuritySession called: sessionId=" + r5);
        if (isValidString(r5) == true) goto L7;
        com.bytedance.privacy.e.c.d(r0, "closeSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return -2;
    L7:
        if (((a) ZeusTransformUtils.preCheckCast(this.sessionContextCache.get(r5), a.class, "com.obric.memorydata.plugin")) != null) goto L10;
        com.bytedance.privacy.e.c.d(r0, "closeSecuritySession failed: session not found, sessionId=" + r5);
        return -32;
    L10:
        this.sessionContextCache.remove(r5);
        com.bytedance.privacy.e.c.a(r0, "closeSecuritySession success: sessionId=" + r5);
        return 0;
    }

    public byte[] dataDecrypt(String r3, String r4) {
        if (r4 != null) goto L5;
    L13:
        com.bytedance.privacy.e.c.d(TAG, "dataDecrypt failed: invalid data (null, empty)");
        return null;
    L5:
        if (r4.length() == 0) goto L13;
        return dataDecryptBytes(r3, Base64.decode(r4, 8));
    L10:
        e = move-exception;
        com.bytedance.privacy.e.c.d(TAG, "dataDecrypt failed: invalid Base64 data: " + e.getMessage());
        return null;
    }

    public byte[] dataDecryptBytes(String r5, byte[] r6) {
        String r0 = TAG;
        com.bytedance.privacy.e.c.a(r0, "dataDecryptBytes called: sessionId=" + r5);
        if (isValidString(r5) == true) goto L6;
        com.bytedance.privacy.e.c.d(r0, "dataDecryptBytes failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L6:
        if (r6 != null) goto L8;
    L34:
        com.bytedance.privacy.e.c.d(r0, "dataDecryptBytes failed: invalid data (null, empty)");
        return null;
    L8:
        if (r6.length == 0) goto L34;
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.sessionContextCache.get(r5), a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L36;
        com.bytedance.privacy.e.c.d(r0, "dataDecryptBytes failed: session not found");
        return null;
    L36:
        com.bytedance.privacy.e.c.a(r0, "dataDecryptBytes encodedLen=" + r6.length);     // Catch: Exception -> L31
        b r7 = b.a(r6);     // Catch: Exception -> L31
        EncryptedPayloadTlv r8 = r7.f3047a;     // Catch: Exception -> L31
        byte[] r9 = r7.f3048b;     // Catch: Exception -> L31
        if (r8.c != null) goto L17;
    L29:
        com.bytedance.privacy.e.c.d(r0, "dataDecryptBytes failed: missing ContentInfoMeta or nonce");     // Catch: Exception -> L31
        return null;
    L17:
        if (r8.c.c == null) goto L29;
        if (r8.c.c.f3032a == null) goto L29;
        if (r9 != null) goto L23;
    L27:
        com.bytedance.privacy.e.c.d(r0, "dataDecryptBytes failed: no ciphertext in Body");     // Catch: Exception -> L31
        return null;
    L23:
        if (r9.length == 0) goto L27;
        byte[] r10 = r8.c.c.f3032a;     // Catch: Exception -> L31
        com.bytedance.privacy.e.c.a(r0, "dataDecryptBytes ciphertextLen=" + r9.length);     // Catch: Exception -> L31
        byte[] r11 = com.bytedance.privacy.pcc.a.b(r4.f, r10, r9);     // Catch: Exception -> L31
        com.bytedance.privacy.e.c.a(r0, "dataDecryptBytes success: plaintextLen=" + r11.length);     // Catch: Exception -> L31
        return r11;
    L31:
        e = move-exception;
        com.bytedance.privacy.e.c.d(TAG, "dataDecryptBytes exception: " + e.getMessage());
        return null;
    }

    public String dataEncrypt(String r1, byte[] r2) {
        byte[] r0 = dataEncryptBytes(r1, r2);
        if (r0 != null) goto L6;
        return null;
    L6:
        return Base64.encodeToString(r0, 11);
    }

    public byte[] dataEncryptBytes(String r12, byte[] r13) {
        String r0 = TAG;
        com.bytedance.privacy.e.c.a(r0, "dataEncryptBytes called: sessionId=" + r12);
        if (isValidString(r12) == true) goto L6;
        com.bytedance.privacy.e.c.d(r0, "dataEncryptBytes failed: invalid sessionId (null, empty, or exceeds max length)");
        return null;
    L6:
        if (r13 != null) goto L9;
        com.bytedance.privacy.e.c.d(r0, "dataEncryptBytes failed: data is null");
        return null;
    L9:
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.sessionContextCache.get(r12), a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L38;
        com.bytedance.privacy.e.c.d(r0, "dataEncryptBytes failed: session not found");
        return null;
    L38:
        byte[] r3 = new byte[12];     // Catch: Exception -> L33
        new SecureRandom().nextBytes(r3);     // Catch: Exception -> L33
        com.bytedance.privacy.e.c.a(r0, "dataEncryptBytes plainLen=" + r13.length);     // Catch: Exception -> L33
        byte[] r14 = com.bytedance.privacy.pcc.a.a(r1.f, r3, r13);     // Catch: Exception -> L33
        com.bytedance.privacy.e.c.a(r0, "dataEncryptBytes ciphertextLen=" + r14.length);     // Catch: Exception -> L33
        EncryptedPayloadTlv r4 = new EncryptedPayloadTlv();     // Catch: Exception -> L33
        r4.f3020a = new EncryptedPayloadTlv.e();     // Catch: Exception -> L33
        r4.f3020a.f3030a = 2;     // Catch: Exception -> L33
        r4.f3020a.f3031b = 1;     // Catch: Exception -> L33
        EncryptedPayloadTlv.a r5 = new EncryptedPayloadTlv.a();     // Catch: Exception -> L33
        r5.f3022a = r1.f3039a.appId;     // Catch: Exception -> L33
        r5.f3023b = r1.f3039a.appSvcId;     // Catch: Exception -> L33
        r5.c = r1.f3040b;     // Catch: Exception -> L33
        r5.d = r12.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L33
        if (r1.c == null) goto L17;
        byte[] r15 = r1.c.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L33
    L18:
        r5.e = r15;     // Catch: Exception -> L33
        r4.f3020a.c = r5;     // Catch: Exception -> L33
        byte[] r16 = com.bytedance.privacy.pcc.a.a(r1.d.getPublic());     // Catch: Exception -> L33
        r4.f3021b = new EncryptedPayloadTlv.d();     // Catch: Exception -> L33
        r4.f3021b.f3028a = 2;     // Catch: Exception -> L33
        r4.f3021b.f3029b = 1;     // Catch: Exception -> L33
        r4.f3021b.d = new ArrayList();     // Catch: Exception -> L33
        com.bytedance.privacy.pcc.b.a.c.d r6 = r1.e;     // Catch: Exception -> L33
        byte[] r7 = new byte[16];     // Catch: Exception -> L33
        new SecureRandom().nextBytes(r7);     // Catch: Exception -> L33
        com.bytedance.privacy.e.c.b(r0, "dataEncryptBytes keyId=" + r6.b() + " keyType=" + r6.a() + " keyVer=" + r6.c());     // Catch: Exception -> L33
        if (r6.b() != null) goto L23;
        com.bytedance.privacy.e.c.d(r0, "dataEncryptBytes failed: svcKeyId is null");     // Catch: Exception -> L33
        return null;
    L23:
        if (r6.d() != null) goto L26;
        com.bytedance.privacy.e.c.d(r0, "dataEncryptBytes failed: svcPubKey is null (keyId=" + r6.b() + ")");     // Catch: Exception -> L33
        return null;
    L26:
        byte[] r2 = com.bytedance.privacy.pcc.a.a(r1.d.getPrivate(), r16, r6.d(), r7, r1.f);     // Catch: Exception -> L33
        EncryptedPayloadTlv.c r8 = new EncryptedPayloadTlv.c();     // Catch: Exception -> L33
        r8.f3026a = 1;     // Catch: Exception -> L33
        r8.f3027b = r6.b().getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L33
        r8.c = parseKeyVersion(r6.c());     // Catch: Exception -> L33
        r8.d = 1;     // Catch: Exception -> L33
        r8.e = r16;     // Catch: Exception -> L33
        r8.f = r7;     // Catch: Exception -> L33
        r8.g = r2;     // Catch: Exception -> L33
        r4.f3021b.d.add(r8);     // Catch: Exception -> L33
        r4.f3021b.c = 1;     // Catch: Exception -> L33
        r4.c = new EncryptedPayloadTlv.b();     // Catch: Exception -> L33
        r4.c.f3024a = 1;     // Catch: Exception -> L33
        r4.c.f3025b = 1;     // Catch: Exception -> L33
        EncryptedPayloadTlv.f r17 = new EncryptedPayloadTlv.f();     // Catch: Exception -> L33
        r17.f3032a = r3;     // Catch: Exception -> L33
        r4.c.c = r17;     // Catch: Exception -> L33
        byte[] r11 = d.a(this.appContext, PCC_SIGN_KEY_ALIAS, r4.b());     // Catch: Exception -> L30
        EncryptedPayloadTlv.g r18 = new EncryptedPayloadTlv.g();     // Catch: Exception -> L30
        r18.f3034a = 1;     // Catch: Exception -> L30
        r18.f3035b = r11;     // Catch: Exception -> L30
        r4.d = r18;     // Catch: Exception -> L30
        byte[] r19 = new b(r4, r14).a();     // Catch: Exception -> L33
        com.bytedance.privacy.e.c.a(r0, "dataEncryptBytes success: encodedLen=" + r19.length);     // Catch: Exception -> L33
        return r19;
    L30:
        e = move-exception;
        com.bytedance.privacy.e.c.d(TAG, "dataEncryptBytes failed: sign TLV: " + e.getMessage());     // Catch: Exception -> L33
        return null;
    L17:
        r15 = new byte[0];     // Catch: Exception -> L33
    L33:
        e = move-exception;
        com.bytedance.privacy.e.c.d(TAG, "dataEncryptBytes exception: " + Log.getStackTraceString(e));
        return null;
    }

    public String getVersion() {
        return PCC_PROTOCOL_VERSION;
    }

    public Bundle init(AppInfo r28, Bundle r29) {
        if (this.appContext != null) goto L7;
        com.bytedance.privacy.e.c.d(TAG, "init failed: context not attached");
        return createResultBundle(-31, 1);
    L7:
        if (isValidAppInfo(r28) == true) goto L10;
        com.bytedance.privacy.e.c.d(TAG, "init failed: invalid params (null, empty, or exceeds max length)");
        return createResultBundle(-2, 1);
    L10:
        LaneType r4 = LaneType.CPU_NORMAL;
        if (r29.containsKey(KEY_LANE_TYPE) == false) goto L17;
        int r2 = r29.getInt(KEY_LANE_TYPE, LaneType.CPU_NORMAL.getValue());
        if (LaneType.isValid(r2) == true) goto L16;
        com.bytedance.privacy.e.c.d(TAG, "init failed: invalid lane_type=" + r2 + " (must be 0-3)");
        return createResultBundle(-2, LaneType.CPU_NORMAL);
    L16:
        r4 = LaneType.fromValue(r2);
    L17:
        String r3 = TAG;
        com.bytedance.privacy.e.c.b(r3, "init called: appId=" + r28.appId + ", appSvcId=" + r28.appSvcId + ", rpdid=" + r28.rpdid + ", rpuid=" + r28.rpuid + ", clientLaneType=" + r4);
        com.bytedance.privacy.pcc.b.a.c r5 = queryChannelFromDb(r28);
        if (r5 != null) goto L20;
    L31:
        com.bytedance.privacy.e.c.b(r3, "init: no valid cached channel, proceeding with network flow");
        HashMap r6 = new HashMap();
        r6.put(HEADER_LANE_TYPE, String.valueOf(r4.getValue()));
        String r8 = UUID.randomUUID().toString();
        com.bytedance.privacy.pcc.b.a.a r10 = com.bytedance.privacy.pcc.b.a.a().a(r8, r6);
        if (r10 != null) goto L34;
    L71:
        com.bytedance.privacy.e.c.d(r3, "init failed: get PCC challenge failed");
        return createResultBundle(-31, r4);
    L34:
        if (TextUtils.isEmpty(r10.a()) == true) goto L71;
        String r11 = r10.a();
        LaneType r12 = LaneType.fromValue(r10.getType());
        LaneType r13 = LaneType.negotiate(r4, r12);
        com.bytedance.privacy.e.c.b(r3, "Lane routing decision: client=" + r4 + ", server=" + r12 + ", final=" + r13);
        r6.put(HEADER_LANE_TYPE, String.valueOf(r13.getValue()));
        String r9 = d.a(this.appContext, PCC_SIGN_KEY_ALIAS, r11, r28.rpdid, r28.rpuid);     // Catch: Exception -> L68
        com.bytedance.privacy.e.c.b(r3, "init: cleaned up " + this.channelDb.b(r28.rpdid, r28.rpuid, r28.appId, r28.appSvcId) + " old channel(s) for other rpuids");
        String r7 = String.valueOf(System.currentTimeMillis());
        byte[] r14 = new byte[8];
        new SecureRandom().nextBytes(r14);
        String r15 = com.bytedance.privacy.pcc.a.a(r14);
        String r16 = Base64.encodeToString(new com.bytedance.privacy.pcc.b.a.b.a(PCC_CLIENT_VERSION, r15, r28).a().getBytes(StandardCharsets.UTF_8), 11);
        com.bytedance.privacy.pcc.b.a.c r17 = com.bytedance.privacy.pcc.b.a.a().a(r8, r7, new com.bytedance.privacy.pcc.b.a.b(r9, r16, Base64.encodeToString(d.a(this.appContext, PCC_SIGN_KEY_ALIAS, (r8 + "|" + r7 + "|" + r16).getBytes(StandardCharsets.UTF_8)), 11)).a(), r6);
        if (r17 != null) goto L45;
        com.bytedance.privacy.e.c.d(r3, "init failed: createChannel returned null");
        return createResultBundle(-31, r13);
    L45:
        if (verifyCloudSignature(r17) == true) goto L49;
        com.bytedance.privacy.e.c.d(r3, "init failed: cloud response signature verification failed");
        return createResultBundle(-31, r13);
    L49:
        if (verifyEvidenceToken(r17, r11, r15, r28) == true) goto L53;
        com.bytedance.privacy.e.c.d(r3, "init failed: evidence token verification failed");
        return createResultBundle(-31, r13);
    L53:
        if (this.channelDb.a(r28.rpdid, r28.rpuid, r28.appId, r28.appSvcId, r17, 2, new com.bytedance.privacy.pcc.a.a(r4.getValue(), r12.getValue(), r13.getValue())) == true) goto L56;
        com.bytedance.privacy.e.c.d(r3, "init warning: failed to persist channel data to DB");
    L56:
        if (this.channelDb.a(r28.rpdid, r28.rpuid, r28.appId, r28.appSvcId, r17) == true) goto L58;
        com.bytedance.privacy.e.c.d(r3, "init warning: failed to save key attestation history");
    L58:
        com.bytedance.privacy.e.c.b(r3, "init success, channelId=" + r17.d() + ", finalLaneType=" + r13 + " (value=" + r13.getValue() + ")");
        String r0 = Base64.encodeToString(new com.bytedance.privacy.pcc.b.a.d.a(PCC_CLIENT_VERSION, r28, r17.d(), "0").a().getBytes(StandardCharsets.UTF_8), 11);
        String r18 = String.valueOf(System.currentTimeMillis());
        com.bytedance.privacy.e.c.b(r3, "init: uploadChannelRet logId=" + com.bytedance.privacy.pcc.b.a.a().a(r8, r18, new com.bytedance.privacy.pcc.b.a.d(r0, Base64.encodeToString(d.a(this.appContext, PCC_SIGN_KEY_ALIAS, (r8 + "|" + r18 + "|" + r0).getBytes(StandardCharsets.UTF_8)), 11)).a()));     // Catch: Exception -> L61
    L64:
        return createResultBundle(0, r13);
    L61:
        e = move-exception;
        com.bytedance.privacy.e.c.d(TAG, "init: uploadChannelRet sign failed (non-fatal): " + e.getMessage());
    L65:
        e = move-exception;
        com.bytedance.privacy.e.c.d(TAG, "init failed: sign request: " + e.getMessage());
        return createResultBundle(-31, r13);
    L68:
        e = move-exception;
        com.bytedance.privacy.e.c.d(TAG, "init failed: attestation: " + e.getMessage());
        return createResultBundle(-31, r13);
    L20:
        if (isChannelExpired(r5) == true) goto L31;
        if (r5.i() != 2) goto L31;
        com.bytedance.privacy.pcc.a.a r19 = this.channelDb.a(r28.rpdid, r28.rpuid, r28.appId, r28.appSvcId);
        if (r19 != null) goto L26;
    L28:
        if (r19 == null) goto L31;
        com.bytedance.privacy.e.c.b(r3, "init: using valid cached V2 channel " + r19);
        return createResultBundle(0, LaneType.fromValue(r19.c));
    L26:
        if (r19.f3042a == r4.getValue()) goto L28;
        com.bytedance.privacy.e.c.b(r3, "init: client lane_type changed (cached=" + r19.f3042a + ", requested=" + r4.getValue() + "), deleting old channel and re-negotiating");
        this.channelDb.delete(r28.rpdid, r28.rpuid, r28.appId, r28.appSvcId);
        goto L31
    }

    public Bundle openSecuritySession(String r16, AppInfo r17, Bundle r18) {
        String r9 = TAG;
        com.bytedance.privacy.e.c.a(r9, "openSecuritySession called: sessionId=" + r16);
        if (isValidString(r16) == true) goto L7;
        com.bytedance.privacy.e.c.d(r9, "openSecuritySession failed: invalid sessionId (null, empty, or exceeds max length)");
        return createResultBundle(-2, LaneType.CPU_NORMAL);
    L7:
        if (isValidAppInfo(r17) == true) goto L10;
        com.bytedance.privacy.e.c.d(r9, "openSecuritySession failed: invalid appInfo (null, empty, or exceeds max length)");
        return createResultBundle(-2, LaneType.CPU_NORMAL);
    L10:
        LaneType r4 = LaneType.CPU_NORMAL;
        if (r18.containsKey(KEY_LANE_TYPE) == false) goto L17;
        int r5 = r18.getInt(KEY_LANE_TYPE, LaneType.CPU_NORMAL.getValue());
        if (LaneType.isValid(r5) == true) goto L16;
        com.bytedance.privacy.e.c.d(r9, "openSecuritySession failed: invalid lane_type=" + r5 + " (must be 0-3)");
        return createResultBundle(-2, LaneType.CPU_NORMAL);
    L16:
        r4 = LaneType.fromValue(r5);
    L17:
        com.bytedance.privacy.pcc.b.a.c r6 = queryChannelFromDb(r17);
        boolean r7 = true;
        if (r6 != null) goto L20;
    L31:
        com.bytedance.privacy.e.c.a(r9, "openSecuritySession: channel missing or expired, re-initialising");
    L32:
        LaneType r8 = r4;
    L34:
        if (r7 == false) goto L43;
        Bundle r2 = init(r17, r18);
        int r10 = r2.getInt("error_code", -31);
        if (r10 == 0) goto L39;
        com.bytedance.privacy.e.c.d(r9, "openSecuritySession failed: re-init returned " + r10);
        return r2;
    L39:
        r8 = LaneType.fromValue(r2.getInt(KEY_LANE_TYPE, r4.getValue()));
        r6 = queryChannelFromDb(r17);
        if (r6 != null) goto L43;
        com.bytedance.privacy.e.c.d(r9, "openSecuritySession failed: channel still null after re-init");
        return createResultBundle(-31, r8);
    L43:
        LaneType r12 = r8;
        com.bytedance.privacy.pcc.b.a.c.C0153c r3 = r6.a();
        if (r3 != null) goto L46;
    L54:
        com.bytedance.privacy.e.c.d(r9, "openSecuritySession failed: service key info is empty");
        return createResultBundle(-31, r12);
    L46:
        if (r3.a() == null) goto L54;
        KeyPair r11 = com.bytedance.privacy.pcc.a.a();     // Catch: Exception -> L51
        byte[] r13 = new byte[32];
        new SecureRandom().nextBytes(r13);
        this.sessionContextCache.put(r16, new a(r17, 1, r6.c(), r11, r3.a(), r13));
        com.bytedance.privacy.e.c.a(r9, "openSecuritySession success: sessionId=" + r16 + ", finalLaneType=" + r12.getValue());
        return createResultBundle(0, r12);
    L51:
        e = move-exception;
        com.bytedance.privacy.e.c.d(TAG, "openSecuritySession failed: generate ephemeral key pair: " + e.getMessage());
        return createResultBundle(-31, r12);
    L20:
        if (isChannelExpired(r6) == true) goto L31;
        com.bytedance.privacy.pcc.a.a r14 = this.channelDb.a(r17.rpdid, r17.rpuid, r17.appId, r17.appSvcId);
        if (r14 != null) goto L25;
    L27:
        if (r14 == null) goto L29;
        r8 = LaneType.fromValue(r14.c);
    L30:
        r7 = false;
        goto L34
    L29:
        r8 = r4;
        goto L30
    L25:
        if (r14.f3042a == r4.getValue()) goto L27;
        com.bytedance.privacy.e.c.b(r9, "openSecuritySession: client lane_type changed (cached=" + r14.f3042a + ", requested=" + r4.getValue() + "), re-initialising");
        goto L32
    }
}
