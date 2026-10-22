package n6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.cae.userAware.datacollection.NetworkClient;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.util.Arrays;
import org.json.JSONObject;
import we.a0;
import we.c0;
import we.t;
import we.v;
import we.x;
import we.y;
import we.z;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f9447i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile b f9448j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f9449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f9452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m6.a f9455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f9456h;

    static {
        f9447i = new Object();
    }

    public b() {
        this.f9449a = null;
        this.f9452d = null;
        this.f9453e = null;
        this.f9454f = null;
        this.f9455g = null;
        this.f9456h = 0;
        boolean r8 = true;
        Class.forName("com.bytedance.security.secretdata.SecretDataManager");     // Catch: ClassNotFoundException -> L5
    L8:
        this.f9450b = r8;
        Log.i("CloudTransCryptoManager", "isBDDevice: " + r8);
        return;
    L5:
        Class.forName("com.obric.security.secretdata.SecretDataManager");     // Catch: ClassNotFoundException -> L7
    L7:
        r8 = false;
        goto L8
    }

    public static b e() {
        if (f9448j != null) goto L15;
        Object r8 = f9447i;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9448j != null) goto L9;
        f9448j = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L11
    L15:
        return f9448j;
    }

    public static String h(byte[] r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        if (r8.length < 1) goto L19;
        int r10 = Byte.toUnsignedInt(r8[0]) + 1;
        if (r10 <= r8.length) goto L10;
        return "";
    L10:
        int r11 = r10 + 1;
        if (r11 <= r8.length) goto L13;
        return "";
    L13:
        int r12 = Byte.toUnsignedInt(r8[r10]) + r11;
        if (r12 <= r8.length) goto L17;
        return "";
    L17:
        return new String(Arrays.copyOfRange(r8, r11, r12), StandardCharsets.UTF_8);
    L19:
        return "";
    }

    public final byte[] a(byte[] r10) {
        if (r10 == null) goto L25;
        if (r10.length == 0) goto L25;
        Object r8 = f9447i;
        monitor-enter(r8);
        d r11 = this.f9449a;     // Catch: Throwable -> L21
        if (r11 == null) goto L20;
        if (r11.f9460c == null) goto L20;
        byte[] r12 = l6.a.C(r10, r11);     // Catch: c -> L14 Throwable -> L21
        monitor-exit(r8);     // Catch: Throwable -> L21
        return r12;
    L14:
        e = move-exception;
        if (e.f9457a != (-22)) goto L18;
        Log.e("CloudTransCryptoManager", "key version mismatch, need to force init!");     // Catch: Throwable -> L21
        f(this.f9452d, this.f9453e, this.f9454f, this.f9455g, true);     // Catch: Throwable -> L21
    L18:
        throw e;     // Catch: Throwable -> L21
    L20:
        throw new c("dataDecrypt failed, not completely initialized.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L25:
        throw new c("dataDecrypt failed, ciphertext is null");
    }

    public final byte[] b(byte[] r8) {
        if (r8 == null) goto L24;
        if (r8.length == 0) goto L24;
        if (r8.length > 10485760) goto L22;
        Object r10 = f9447i;
        monitor-enter(r10);
        d r11 = this.f9449a;     // Catch: Throwable -> L18
        if (r11 == null) goto L17;
        if (r11.f9459b == null) goto L17;
        byte[] r12 = l6.a.D(r8, r11);     // Catch: Throwable -> L18
        monitor-exit(r10);     // Catch: Throwable -> L18
        return r12;
    L17:
        throw new c("dataEncrypt failed, not completely initialized.");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L22:
        throw new c("dataEncrypt failed, plaintext length is too large");
    L24:
        throw new c("dataEncrypt failed, plaintext is null");
    }

    public final a c(o6.a r10, Context r11, String r12, String r13) {
        Log.i("CloudTransCryptoManager", "DSK exchange by cert.");
        String r8 = q6.a.c();
        this.f9451c = Process.myUid() + "_" + r11.getPackageName();
        String r14 = r8 + BdimCategoryConstants.SEPARATOR_COLON + r12 + BdimCategoryConstants.SEPARATOR_COLON + r13;
        byte[] r15 = r12.getBytes(StandardCharsets.UTF_8);
        byte[] r16 = r13.getBytes(StandardCharsets.UTF_8);
        Object r17 = f9447i;
        monitor-enter(r17);
        this.f9449a.f9465h = e.d(new byte[][]{new byte[]{(byte) r15.length}, r15, new byte[]{(byte) r16.length}, r16});     // Catch: IOException -> L38 Throwable -> L41
        monitor-exit(r17);     // Catch: Throwable -> L41
        String r18 = null;
        if (this.f9450b == false) goto L9;
        p6.b.b(r11, this.f9451c);     // Catch: Exception -> L35
        p6.b.c(r11, this.f9451c);     // Catch: Exception -> L35
        Certificate[] r19 = p6.b.e(r11, this.f9451c, r14);     // Catch: Exception -> L35
    L46:
    L32:
        e = move-exception;
        this.f9449a = null;
        throw new c("dsk exchange by cert failed, ", e);
    L15:
        if (this.f9450b == false) goto L17;
        int r110 = r19.length - 1;     // Catch: c -> L32
    L18:
        String r20 = e.b(r19, r110);     // Catch: c -> L32
        z r111 = z.create(t.a("application/json; charset=utf-8"), "{}");     // Catch: Exception -> L29
        y.a r21 = new y.a();     // Catch: Exception -> L29
        r21.e(r10.f9755a);     // Catch: Exception -> L29
        r21.f13347d.a("Content-Type", NetworkClient.UPLOAD_FILE_TYPE_JSON);     // Catch: Exception -> L29
        r21.f13347d.a("x-att-certchain", r20);     // Catch: Exception -> L29
        r21.c(r111, HttpMethodContrants.POST);     // Catch: Exception -> L29
        a0 r22 = x.f(new v(), r21.a(), false).d();     // Catch: Exception -> L29
        if (r22.r() == false) goto L28;
        c0 r23 = r22.f13120q;     // Catch: Exception -> L29
        if (r23 == null) goto L26;
        r18 = r23.n();     // Catch: Exception -> L29
    L26:
        return o6.a.c(r18);
    L28:
        throw new IOException("Unexpected code " + r22);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        throw new c("dskExchange failed, " + e.getMessage());
    L17:
        r110 = r19.length;     // Catch: c -> L32
        goto L18
    L9:
        String r112 = this.f9451c;     // Catch: Exception -> L35
        KeyStore r113 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Throwable -> L12 Exception -> L35
        r113.load(null);     // Catch: Throwable -> L12 Exception -> L35
        r113.deleteEntry(r112);     // Catch: Throwable -> L12 Exception -> L35
    L13:
        p6.b.d(this.f9451c, r14);     // Catch: Exception -> L35
        r19 = p6.b.f(this.f9451c);     // Catch: Exception -> L35
        goto L46
    L12:
        Log.e("KeyPairHelper", "deleteKey failed");     // Catch: Exception -> L35
    L35:
        e = move-exception;
        throw new c("initSensitive failed, ", e);
    L41:
        th = move-exception;
        throw th;
    L38:
        e = move-exception;
        throw new c("initSensitive failed, DID and appId save failed, ", e);     // Catch: Throwable -> L41
    }

    public final void d(Context r8, a r10) {
        PublicKey r11 = e.e(r10.f9440b.f9442a);     // Catch: Exception -> L38
    L35:
        e = move-exception;
        throw new c("generateSharedSecret failed, generate shared secret failed, error:" + e.getMessage());
    L5:
        if (this.f9450b == true) goto L7;
        byte[] r12 = p6.a.b(p6.b.h(this.f9451c).getPrivate(), r11);     // Catch: Exception -> L35
    L43:
    L32:
        e = move-exception;
        throw new c("generateSharedSecret failed, shared key hash is error", e);
    L13:
        if (s6.b.a(e.h(r12)).equals(r10.f9440b.f9443b) == false) goto L31;
        Object r13 = f9447i;
        monitor-enter(r13);
        this.f9449a.g(r12);     // Catch: Throwable -> L27
        this.f9449a.i(r10.f9440b.f9444c);     // Catch: Throwable -> L27
        long r14 = r10.f9440b.f9445d * 1000;     // Catch: Exception -> L24 Throwable -> L27
        if (r14 < System.currentTimeMillis()) goto L22;
        this.f9449a.h(r14);     // Catch: Exception -> L24 Throwable -> L27
        monitor-exit(r13);     // Catch: Throwable -> L27
        return;
    L22:
        l6.a.H("CloudTransCryptoManager", "validityPeriod is error, validityPeriod:" + r14 + " current:" + System.currentTimeMillis());     // Catch: Exception -> L24 Throwable -> L27
        throw new c("generateSharedSecret failed, info time is error, validityPeriod is error");     // Catch: Exception -> L24 Throwable -> L27
    L24:
        e = move-exception;
        throw new c("generateSharedSecret failed, info cannot be converted to time", e);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L31:
        throw new c("generateSharedSecret failed, shared key hash is error");     // Catch: Exception -> L32
    L7:
        if (e.g(r8) == false) goto L10;
        r12 = p6.a.a(r8, this.f9451c, s6.b.c(r11.getEncoded()));     // Catch: Exception -> L35
        goto L43
    L10:
        throw new c("generateSharedSecret failed, device cert not exist!");     // Catch: Exception -> L35
    L39:
        throw new c("generateSharedSecret failed, info information cannot be converted to public key");
    }

    public final void f(Context r22, String r23, String r24, m6.a r25, boolean r26) {
        Object r11 = f9447i;
        monitor-enter(r11);
        if (r22 == null) goto L112;
        if (TextUtils.isEmpty(r23) == true) goto L110;
        if (TextUtils.isEmpty(r24) == true) goto L110;
        if (r25 == null) goto L108;
        this.f9452d = r22;     // Catch: Throwable -> L78
        this.f9453e = r23;     // Catch: Throwable -> L78
        this.f9454f = r24;     // Catch: Throwable -> L78
        this.f9455g = r25;     // Catch: Throwable -> L78
        String r10 = "device_share_key_" + r23;     // Catch: Throwable -> L78
    L104:
        e = move-exception;
        this.f9449a = null;     // Catch: Throwable -> L78
        throw new c("init failed, loadSensitiveDate failed", e);     // Catch: Throwable -> L78
    L13:
        if (this.f9449a != null) goto L15;
    L25:
        d r12 = new d();     // Catch: Throwable -> L78 c -> L104
        this.f9449a = r12;     // Catch: Throwable -> L78 c -> L104
        this.f9456h = 0;     // Catch: Throwable -> L78 c -> L104
        if (r12.f9461d != 0) goto L28;
        r12.f(r22, r10, r23, this.f9450b);     // Catch: Throwable -> L78 c -> L104
        this.f9456h = System.currentTimeMillis();     // Catch: Throwable -> L78 c -> L104
    L28:
    L30:
        if (TextUtils.isEmpty(h(this.f9449a.f9465h)) == false) goto L32;
    L36:
        if (r26 == true) goto L55;
        monitor-enter(r11);     // Catch: Throwable -> L78
        boolean r8 = g(r24);     // Catch: Throwable -> L52
        if (r8 == false) goto L42;
        Log.i("CloudTransCryptoManager", "did changed!");     // Catch: Throwable -> L52
    L42:
        if (this.f9449a.f9461d < System.currentTimeMillis()) goto L46;
        if (r8 == true) goto L46;
        boolean r13 = false;
    L47:
        monitor-exit(r11);     // Catch: Throwable -> L52
        if (r13 == true) goto L55;
        Log.i("CloudTransCryptoManager", "no need to renew");     // Catch: Throwable -> L78
        monitor-exit(r11);     // Catch: Throwable -> L78
        return;
    L46:
        r13 = true;
    L52:
        th = move-exception;
        throw th;     // Catch: Throwable -> L78
    L55:
        q6.b.a().f10170a = r25;     // Catch: Throwable -> L78
        o6.a r14 = new o6.a();     // Catch: Throwable -> L78
        if (e.g(r22) == false) goto L102;
        a r15 = c(r14, r22, r24, r23);     // Catch: Throwable -> L78
        if (r15.f9439a == 200) goto L121;
        Log.e("CloudTransCryptoManager", "code is error, response body: " + r15.f9441c);     // Catch: Throwable -> L78
        this.f9449a = null;     // Catch: Throwable -> L78
        throw new c("init failed, response code is " + r15.f9439a);     // Catch: Throwable -> L78
    L121:
        a.C0118a r16 = r15.f9440b;     // Catch: Throwable -> L78 Exception -> L92
        long r17 = r16.f9445d;     // Catch: Throwable -> L78 Exception -> L92
        long r18 = r15.f9440b.f9444c;     // Catch: Throwable -> L78 Exception -> L92
        ByteBuffer r19 = ByteBuffer.allocate(8);     // Catch: Throwable -> L78 Exception -> L92
        r19.putLong(r18);     // Catch: Throwable -> L78 Exception -> L92
        long r110 = r15.f9440b.f9445d;     // Catch: Throwable -> L78 Exception -> L92
        ByteBuffer r20 = ByteBuffer.allocate(8);     // Catch: Throwable -> L78 Exception -> L92
        r20.putLong(r110);     // Catch: Throwable -> L78 Exception -> L92
        byte[] r21 = e.d(new byte[][]{r16.f9442a.getBytes(), r15.f9440b.f9443b.getBytes(), r19.array(), r20.array()});     // Catch: Throwable -> L78 Exception -> L92
        PublicKey r111 = e.e(r14.f9757c);     // Catch: Throwable -> L78 Exception -> L92
        String r112 = r15.f9440b.f9446e;     // Catch: Throwable -> L78 Exception -> L92
        Signature r113 = Signature.getInstance("SHA256withECDSA");     // Catch: Throwable -> L78 Exception -> L92
        r113.initVerify(r111);     // Catch: Throwable -> L78 Exception -> L92
        r113.update(r21);     // Catch: Throwable -> L78 Exception -> L92
        if (r113.verify(s6.b.b(r112)) == false) goto L91;
        d(r22, r15);     // Catch: Throwable -> L78 c -> L87
        this.f9449a.j(r22, r10, r23);     // Catch: Throwable -> L78 Exception -> L80
    L125:
        String r27 = r14.b(o6.a.a(r15.f9440b.f9444c, 1, r23, r24));     // Catch: Exception -> L71 Throwable -> L78
        int r28 = new JSONObject(r27).getInt("code");     // Catch: Exception -> L71 Throwable -> L78
        if (r28 != 200) goto L69;
        monitor-exit(r11);     // Catch: Throwable -> L78
        return;
    L69:
        Log.e("CloudTransCryptoManager", "code is error, response body: " + r27);     // Catch: Exception -> L71 Throwable -> L78
        throw new c("init failed, web response code is " + r28);     // Catch: Exception -> L71 Throwable -> L78
    L71:
        e = move-exception;
        this.f9449a.d(r22, r10);     // Catch: Throwable -> L78
        this.f9449a = null;     // Catch: Throwable -> L78
        if ((e instanceof c) == false) goto L77;
        throw ((c) e);     // Catch: Throwable -> L78
    L77:
        throw new c("init failed, parse exchange result body failed", e);     // Catch: Throwable -> L78
    L80:
        e = move-exception;
        this.f9449a = null;     // Catch: Throwable -> L78
        r14.b(o6.a.a(r15.f9440b.f9444c, 2, r23, r24));     // Catch: Throwable -> L78
        if ((e instanceof c) == false) goto L86;
        throw ((c) e);     // Catch: Throwable -> L78
    L86:
        throw new c("init failed, update sensitive data failed", e);     // Catch: Throwable -> L78
    L87:
        e = move-exception;
        this.f9449a = null;     // Catch: Throwable -> L78
        r14.b(o6.a.a(r15.f9440b.f9444c, 2, r23, r24));     // Catch: Throwable -> L78
        throw new c("init failed, " + e);     // Catch: Throwable -> L78
    L91:
        throw new c("init failed, verifySignature failed.");     // Catch: Throwable -> L78 Exception -> L92
    L92:
        e = move-exception;
        this.f9449a = null;     // Catch: Throwable -> L78
        if ((e instanceof c) == false) goto L99;
        throw ((c) e);     // Catch: Throwable -> L78
    L99:
        throw new c("init failed, signature is error", e);     // Catch: Throwable -> L78
    L102:
        Log.e("CloudTransCryptoManager", "init failed, device cert not exist! and temp key exchange is not allowed!");     // Catch: Throwable -> L78
        throw new c("init failed, device cert not exist! and temp key exchange is not allowed!");     // Catch: Throwable -> L78
    L32:
        if (TextUtils.equals(r23, h(this.f9449a.f9465h)) == true) goto L36;
        throw new c("init failed, appId is not match!");     // Catch: Throwable -> L78
    L15:
        if ((System.currentTimeMillis() - this.f9456h) <= WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L17;
        boolean r114 = true;
    L18:
        if (r114 == true) goto L25;
        if (g(r24) == true) goto L25;
        if (r26 == true) goto L25;
        monitor-exit(r11);     // Catch: Throwable -> L78
        return;
    L17:
        r114 = false;
        goto L18
    L108:
        throw new c("init failed, bridge is null");     // Catch: Throwable -> L78
    L110:
        throw new c("init failed, appId or did is empty");     // Catch: Throwable -> L78
    L112:
        throw new c("init failed, context is null");     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        throw th;
    }

    public final boolean g(String r8) {
        d r10 = this.f9449a;
        if (r10 != null) goto L5;
        return true;
    L5:
        byte[] r11 = r10.f9465h;
        String r12 = "";
        if (r11 == null) goto L15;
        if (r11.length < 1) goto L15;
        int r13 = Byte.toUnsignedInt(r11[0]) + 1;
        if (r13 > r11.length) goto L15;
        r12 = new String(Arrays.copyOfRange(r11, 1, r13), StandardCharsets.UTF_8);
    L15:
        return !TextUtils.equals(r8, r12);
    }
}
