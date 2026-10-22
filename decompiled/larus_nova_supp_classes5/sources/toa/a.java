package toa;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.privacy.azerothprivacy.AzerothPrivacy;
import com.privacy.azerothprivacy.alarm.receiver.KeyAgreementUpdater;
import com.privacy.azerothprivacy.crypto.KeyAgeementException;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import qoa.b;
import uoa.c;
import uoa.f;
import uoa.g;
import uoa.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final String a = null;
    public static byte[] b;
    public static final Map<String, Long> c = null;
    public static final Map<String, Long> d = null;
    public static final Map<String, Long> e = null;

    static {
        a = AzerothPrivacy.getSdkConfig().b.a;
        b = new byte[0];
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
    }

    public static synchronized void f(String r2) {
        monitor-enter(a.class);
        ((ConcurrentHashMap) c).remove(r2);     // Catch: Throwable -> L6 Exception -> L11
        ((ConcurrentHashMap) d).remove(r2);     // Catch: Throwable -> L6 Exception -> L11
        ((ConcurrentHashMap) e).remove(r2);     // Catch: Throwable -> L6 Exception -> L11
    L6:
        th = move-exception;
        throw th;
    L9:
        monitor-exit(a.class);
    }

    public static int h(EllipticCurveType r3) throws GeneralSecurityException {
        int r0 = a.a[r3.ordinal()];
        if (r0 != 1) goto L5;
        return 20241022;
    L5:
        if (r0 != 2) goto L9;
        return 20240308;
    L9:
        throw new GeneralSecurityException("Unable to parse EllipticCurveType: " + r3.getNumber());
    }

    public static g a(Context r6, String r7) {
        g r1 = new g(r7, 0, new byte[0]);
        r1 = d(r6, r7);     // Catch: Exception -> L17
        byte[] r8 = r1.c;     // Catch: Exception -> L17
        if (r8 == null) goto L20;
        if (r8.length != 0) goto L20;
        ((ConcurrentHashMap) c).remove(r7);     // Catch: Exception -> L17
    L14:
        apa.a.a("CRYPTO", "key hash is " + Arrays.toString(r1.c));     // Catch: Exception -> L17
    L19:
        return r1;
    L20:
        boolean r9 = MessageDigest.isEqual(MessageDigest.getInstance("SHA-256").digest(r8), b);     // Catch: NoSuchAlgorithmException -> L12 Exception -> L17
    L13:
        if (r9 == true) goto L14;
        apa.a.a("CRYPTO", "两者的密钥不相同");     // Catch: Exception -> L17
        ((ConcurrentHashMap) c).remove(r7);     // Catch: Exception -> L17
        r1.c = new byte[0];     // Catch: Exception -> L17
        throw new KeyAgeementException("hash is different with remote hash");     // Catch: Exception -> L17
    L12:
        r9 = false;
    L17:
        e = move-exception;
        xoa.a.a(e, "GetSharedSecret exception", null);
        goto L19
    }

    public static synchronized long b(Context r8, String r9) throws KeyAgeementException {
        monitor-enter(a.class);
        if (r9 == null) goto L20;
        Map<String, Long> r2 = d;     // Catch: Throwable -> L10
        if (((ConcurrentHashMap) r2).get(r9) != null) goto L12;
        epa.a r10 = epa.a.b(r8);     // Catch: Throwable -> L10
        String r0 = "AES_KEY_PRE_VERSION".concat(r9);     // Catch: Throwable -> L10
        r10.getClass();     // Catch: Throwable -> L10
        long r6 = epa.a.c(r0);     // Catch: Throwable -> L10
        if (r6 == 0) goto L14;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;     // Catch: Throwable -> L10
        r3.put(r9, Long.valueOf(r6));     // Catch: Throwable -> L10
    L14:
        if (r6 == 0) goto L18;
        monitor-exit(a.class);
        return r6;
    L18:
        throw new KeyAgeementException("key version is not exist");     // Catch: Throwable -> L10
    L12:
        r6 = ((Long) ((ConcurrentHashMap) r2).get(r9)).longValue();     // Catch: Throwable -> L10
        goto L14
    L20:
        throw new KeyAgeementException("input null uid");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized long c(Context r9, String r10) throws KeyAgeementException {
        monitor-enter(a.class);
        if (r10 == null) goto L21;
        Map<String, Long> r3 = c;     // Catch: Exception -> L17 Throwable -> L22
        if (((ConcurrentHashMap) r3).get(r10) != null) goto L10;
        epa.a r11 = epa.a.b(r9);     // Catch: Exception -> L17 Throwable -> L22
        String r0 = "AES_KEY_VERSION".concat(r10);     // Catch: Exception -> L17 Throwable -> L22
        r11.getClass();     // Catch: Exception -> L17 Throwable -> L22
        long r7 = epa.a.c(r0);     // Catch: Exception -> L17 Throwable -> L22
        if (r7 == 0) goto L12;
        ((ConcurrentHashMap) r3).put(r10, Long.valueOf(r7));     // Catch: Exception -> L17 Throwable -> L22
    L12:
        if (r7 == 0) goto L16;
        monitor-exit(a.class);
        return r7;
    L16:
        throw new KeyAgeementException("key version is not exist");     // Catch: Throwable -> L22
    L10:
        r7 = ((Long) ((ConcurrentHashMap) r3).get(r10)).longValue();     // Catch: Exception -> L17 Throwable -> L22
    L17:
        e = move-exception;
        throw new KeyAgeementException("getAzerothKeyVersionInternal exception" + e);     // Catch: Throwable -> L22
    L21:
        throw new KeyAgeementException("input null uid");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public static g d(Context r18, String r19) throws Exception {
        r19 = r19;
        h r4 = new h();     // Catch: Exception -> L5
    L7:
        EllipticCurveType r5 = r4.c();
        byte[] r6 = r4.a();
        String r7 = "key_version";
        JSONObject r13 = new JSONObject();
        String r8 = Base64.encodeToString(r6, 2);     // Catch: GeneralSecurityException -> L145 KeyAgeementException -> L149 IOException -> L151 JSONException -> L153 CommonHttpException -> L157
        long r14 = c.a(r18).getSerialNumber().longValue();     // Catch: KeyAgeementException -> L135 IOException -> L137 JSONException -> L139 CommonHttpException -> L142 GeneralSecurityException -> L145
        h r16 = r4;
        String r9 = AzerothPrivacy.getAppInfo().d;     // Catch: GeneralSecurityException -> L121 KeyAgeementException -> L124 IOException -> L128 JSONException -> L130 CommonHttpException -> L132
        Object r17 = "shared_preference";
        r13.put("UID", CastLongProtector.parseLong(r19));     // Catch: CommonHttpException -> L96 GeneralSecurityException -> L98 KeyAgeementException -> L100 IOException -> L102 JSONException -> L104
        r7 = "key_version";
        r13.put("DeviceID", CastLongProtector.parseLong(r9));     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r13.put("ProtoVersion", h(r5));     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r13.put("ClientPK", r8);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r13.put("RequestType", 0);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r13.put("PriorCertVersion", r14);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        apa.a.a("CRYPTO", "req body is " + r13);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        StringBuilder r1 = new StringBuilder("req url is ");     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        String r10 = a;     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r1.append(r10);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        apa.a.a("CRYPTO", r1.toString());     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        HashMap r2 = new HashMap();     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r2.put(DownloadHelper.CONTENT_TYPE, "application/json");     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        if (cpa.a.a != null) goto L175;
        Pair r11 = null;
    L21:
        if (r11 != null) goto L178;
    L35:
        NetworkClient.ReqContext r12 = new NetworkClient.ReqContext();     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r12.addCommonParams = true;     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        NetworkClient r15 = fpa.d.a;     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        if (r15 != null) goto L39;
        r15 = NetworkClient.getDefault();     // Catch: GeneralSecurityException -> L75 KeyAgeementException -> L78 IOException -> L81 JSONException -> L83 CommonHttpException -> L96
    L78:
        e = e;
    L80:
        KeyAgeementException r3 = e;
        long r20 = 0;
    L107:
        Object r21 = r17;
    L156:
        HashMap r22 = new HashMap();
        r22.put(r7, String.valueOf(r20));
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r22.put(r21, epa.a.a().toString());
        xoa.a.a(r3, "KeyExchange Json exception", r22);
        g r23 = new g(r19, r20, new byte[0]);
    L162:
        return new g(r19, r23.a, r16.b(r23.c));
    L81:
        e = e;
    L75:
        e = e;
        r19 = r19;
    L77:
        GeneralSecurityException r24 = e;
        r20 = 0;
    L148:
        HashMap r25 = new HashMap();
        r25.put(r7, String.valueOf(r20));
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r25.put(r17, epa.a.a().toString());
        xoa.a.a(r24, "KeyExchange general security exception", r25);
        r23 = new g(r19, r20, new byte[0]);
    L83:
        e = e;
    L39:
        String r26 = r15.post(r10, r13.toString().getBytes(StandardCharsets.UTF_8), r2, r12);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        apa.a.a("CRYPTO", "resbody is " + r26);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        JSONObject r27 = new JSONObject(r26);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r20 = JSONObjectProtectorUtils.getLong(r27, "KeyVersion");     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
    L180:
        long r28 = JSONObjectProtectorUtils.getLong(r27, "ExpectExpiryTime");     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        String r29 = (String) r27.get("SharedKeyHash");     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        String r30 = (String) r27.get("ServerPK");     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        String r110 = (String) r27.get("ServerCert");     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r19 = (String) r27.get("Signature");     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        if (r20 == 0) goto L54;
        if (c.b(r110) == false) goto L52;
        ByteArrayOutputStream r31 = new ByteArrayOutputStream();     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r31.write(Base64.decode(r110, 0));     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r31.write(Base64.decode(r30, 0));     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r31.write(Base64.decode(r29, 0));     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        ByteBuffer r111 = ByteBuffer.allocate(8);     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r111.order(ByteOrder.LITTLE_ENDIAN);     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r111.putLong(r20);     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r31.write(r111.array());     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r111.clear();     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r111.putLong(r28);     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r31.write(r111.array());     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        apa.a.a("crypto", Base64.encodeToString(r31.toByteArray(), 0));     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        if (c.c(r19, r31.toByteArray()) == false) goto L50;
        b = Base64.decode(r29, 0);     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r19 = r19;
        g(r18, r20, r19, false);     // Catch: GeneralSecurityException -> L55 KeyAgeementException -> L57 IOException -> L59 JSONException -> L61 CommonHttpException -> L63
        e(r18, r28, r19);     // Catch: GeneralSecurityException -> L55 KeyAgeementException -> L57 IOException -> L59 JSONException -> L61 CommonHttpException -> L63
        r23 = new g(r19, r20, Base64.decode(r30, 0));     // Catch: GeneralSecurityException -> L55 KeyAgeementException -> L57 IOException -> L59 JSONException -> L61 CommonHttpException -> L63
        goto L162
    L50:
        throw new GeneralSecurityException("body signature verification failed");     // Catch: GeneralSecurityException -> L55 KeyAgeementException -> L57 IOException -> L59 JSONException -> L61 CommonHttpException -> L63
    L52:
        throw new GeneralSecurityException("server cert verification failed");     // Catch: GeneralSecurityException -> L55 KeyAgeementException -> L57 IOException -> L59 JSONException -> L61 CommonHttpException -> L63
    L54:
        throw new GeneralSecurityException("invalid key version returned" + r20);     // Catch: GeneralSecurityException -> L55 KeyAgeementException -> L57 IOException -> L59 JSONException -> L61 CommonHttpException -> L63
    L61:
        e = e;
    L58:
        r3 = e;
    L57:
        e = e;
    L59:
        e = e;
    L55:
        e = e;
    L56:
        r24 = e;
    L63:
        e = e;
    L64:
        CommonHttpException r32 = e;
    L109:
        Object r33 = r17;
    L160:
        HashMap r34 = new HashMap();
        r34.put("exception_status_code", String.valueOf(r32.getResponseCode()));
        r34.put("http_request_body", r13.toString());
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r34.put(r33, epa.a.a().toString());
        r34.put("errMsg", r32.toString());
        bpa.a.g(r34);
        r23 = new g(r19, r20, new byte[0]);
    L65:
        e = e;
        r19 = r19;
    L73:
        e = e;
        r19 = r19;
    L69:
        e = e;
    L68:
        r19 = r19;
    L71:
        e = e;
    L67:
        e = e;
        goto L68
    L178:
        r2.put(r11.first, r11.second);     // Catch: GeneralSecurityException -> L24 KeyAgeementException -> L26 IOException -> L28 JSONException -> L30 CommonHttpException -> L33
    L28:
        e = e;
    L27:
        r3 = e;
        r19 = r19;
        r21 = r17;
        r20 = 0;
    L33:
        e = move-exception;
        r32 = e;
        r19 = r19;
        r33 = r17;
        r20 = 0;
    L30:
        e = e;
    L26:
        e = e;
    L24:
        e = move-exception;
        r24 = e;
        r19 = r19;
        r20 = 0;
        goto L148
    L175:
        r11 = cpa.a.a.getRequestTagHeader();     // Catch: GeneralSecurityException -> L75 KeyAgeementException -> L78 IOException -> L81 JSONException -> L83 CommonHttpException -> L96
    L92:
        e = e;
    L86:
        e = e;
        r19 = r19;
    L94:
        e = e;
    L89:
        e = e;
        goto L80
    L96:
        e = move-exception;
        r19 = r19;
        r32 = e;
        r20 = 0;
    L102:
        e = e;
    L101:
        r7 = "key_version";
    L98:
        e = e;
        r19 = r19;
        r7 = "key_version";
    L104:
        e = e;
    L100:
        e = e;
        goto L101
    L128:
        e = e;
    L126:
        long r112 = 0;
        r3 = e;
        r21 = "shared_preference";
    L155:
        r20 = r112;
    L130:
        e = e;
    L124:
        e = e;
    L121:
        e = e;
    L123:
        r7 = "key_version";
        r17 = "shared_preference";
    L132:
        e = e;
    L134:
        long r113 = 0;
        r32 = e;
        r33 = "shared_preference";
    L159:
        r20 = r113;
        goto L160
    L137:
        e = e;
    L136:
        r16 = r4;
    L139:
        e = e;
    L135:
        e = e;
    L142:
        e = e;
        r16 = r4;
        goto L134
    L145:
        e = e;
        r16 = r4;
    L149:
        e = e;
    L154:
        r19 = r19;
        r16 = r4;
        r21 = "shared_preference";
        r112 = 0;
        r3 = e;
    L151:
        e = e;
    L153:
        e = e;
    L157:
        e = move-exception;
        r19 = r19;
        r16 = r4;
        r33 = "shared_preference";
        r113 = 0;
        r32 = e;
    L5:
        e = move-exception;
        apa.a.a("CRYPTO", "x25519 initialize failed " + e);
        r4 = new f();
        goto L7
    }

    public static void e(Context r3, long r4, String r6) {
        epa.a.b(r3).getClass();
        epa.a.d("KeyExpireTimeInUnixSeconds" + r6, r4);
        b.b(r3, new KeyAgreementUpdater());
    }

    public static synchronized void g(Context r6, long r7, String r9, boolean r10) throws KeyAgeementException {
        monitor-enter(a.class);
        if (r7 != 0) goto L30;
        monitor-exit(a.class);
        return;
    L30:
        if (r10 == false) goto L26;
        epa.a.b(r6).getClass();     // Catch: Throwable -> L15
        epa.a.d("AES_KEY_VERSION" + r9, r7);     // Catch: Throwable -> L15
        Long r8 = (Long) ((ConcurrentHashMap) d).get(r9);     // Catch: Throwable -> L15
        if (r8 != null) goto L13;
        monitor-exit(a.class);
        return;
    L13:
        epa.a.d("AES_KEY_PRE_VERSION" + r9, r8.longValue());     // Catch: Throwable -> L15
    L20:
        monitor-exit(a.class);
        return;
    L26:
        ((ConcurrentHashMap) e).put(r9, Long.valueOf(b(r6, r9)));     // Catch: Throwable -> L15 Exception -> L24
    L28:
        ((ConcurrentHashMap) d).put(r9, Long.valueOf(c(r6, r9)));     // Catch: Throwable -> L15 Exception -> L25
    L19:
        ((ConcurrentHashMap) c).put(r9, Long.valueOf(r7));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
