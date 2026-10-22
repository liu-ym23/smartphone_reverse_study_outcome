package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.os.Build;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.TlsVersion;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f2464b;
    private static int c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OkHttpClient f2465a;

    public interface a {
        void a(OkHttpClient.Builder r1);
    }

    static {
    }

    public e() {
    }

    private static OkHttpClient.Builder a(OkHttpClient.Builder r5, SSLContext r6) {
        TrustManagerFactory r0 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r0.init((KeyStore) ZeusTransformUtils.preCheckCast(null, KeyStore.class, "com.obric.memorydata.plugin"));
        TrustManager[] r1 = r0.getTrustManagers();
        if (r1.length != 1) goto L9;
        if (ZeusTransformUtils.instanceOf(r1[0], X509TrustManager.class) == false) goto L9;
        r5.sslSocketFactory(new p(r6.getSocketFactory()), (X509TrustManager) ZeusTransformUtils.preCheckCast(r1[0], X509TrustManager.class, "com.obric.memorydata.plugin"));
        return r5;
    L9:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r1));
    }

    private static OkHttpClient a(OkHttpClient r2) {
        int r0 = c;
        if (r0 > 0) goto L5;
        return r2;
    L5:
        if (r0 >= 4) goto L10;
        if (r2 == null) goto L11;
        OkHttpClient.Builder r3 = r2.newBuilder();
        a(r3);
        return r3.build();
    L11:
        return r2;
    L10:
        return r2;
    }

    public static void a(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        if (c != 0) goto L8;
        c = r1;
        return;
    }

    private static void a(OkHttpClient.Builder r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        int r1 = c;
        if (r1 != 1) goto L7;
        Protocol r2 = Protocol.HTTP_2;
    L13:
        r0.add(r2);
    L14:
        c = 4;
        r0.add(Protocol.HTTP_1_1);
        r3.protocols(Collections.unmodifiableList(r0));
        return;
    L7:
        if (r1 != 2) goto L9;
    L11:
        r2 = Protocol.SPDY_3;
        goto L13
    L9:
        if (r1 == 3) goto L14;
        r0.add(Protocol.HTTP_2);
        goto L11
    }

    private static OkHttpClient.Builder b(OkHttpClient.Builder r6) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L15:
        return r6;
    L5:
        if (Build.VERSION.SDK_INT >= 22) goto L15;
        SSLContext r2 = SSLContext.getInstance("TLSv1.2");     // Catch: Exception -> L13
        r2.init(null, null, null);     // Catch: Exception -> L13
        r6.sslSocketFactory(new p(r2.getSocketFactory()));     // Catch: Exception -> L9
    L11:
        ConnectionSpec r3 = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_2}).build();     // Catch: Exception -> L13
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L13
        r4.add(r3);     // Catch: Exception -> L13
        r4.add(ConnectionSpec.COMPATIBLE_TLS);     // Catch: Exception -> L13
        r4.add(ConnectionSpec.CLEARTEXT);     // Catch: Exception -> L13
        r6.connectionSpecs(r4);     // Catch: Exception -> L13
        goto L15
    L9:
        e = move-exception;
        Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", e);     // Catch: Exception -> L13
        r6 = a(r6, r2);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", e);
        goto L15
    }

    public OkHttpClient a(boolean r7) {
        if (r7 == false) goto L5;
        com.bytedance.frameworks.baselib.network.http.f.k();
    L5:
        monitor-enter(com.bytedance.frameworks.baselib.network.http.f.class);
        OkHttpClient r0 = this.f2465a;     // Catch: Throwable -> L22
        if (r0 == null) goto L11;
        a(r0);     // Catch: Throwable -> L22
        OkHttpClient r6 = this.f2465a;     // Catch: Throwable -> L22
        monitor-exit(com.bytedance.frameworks.baselib.network.http.f.class);     // Catch: Throwable -> L22
        return r6;
    L11:
        OkHttpClient.Builder r1 = new OkHttpClient.Builder();     // Catch: Throwable -> L22
        int r2 = c;     // Catch: Throwable -> L22
        if (r2 > 0) goto L14;
    L16:
        r1.connectionPool(new ConnectionPool(15, 180000, TimeUnit.MILLISECONDS));     // Catch: Throwable -> L22
        r1.connectTimeout(com.bytedance.frameworks.baselib.network.http.f.a(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
        r1.readTimeout(com.bytedance.frameworks.baselib.network.http.f.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
        r1.writeTimeout(com.bytedance.frameworks.baselib.network.http.f.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
        r1.addNetworkInterceptor(new AnonymousClass1(this));     // Catch: Throwable -> L22
        r1.ttnetDns(g.a());     // Catch: Throwable -> L22
        r1.cookieJar(CookieJar.NO_COOKIES);     // Catch: Throwable -> L22
        r1.addNetworkInterceptor(new f());     // Catch: Throwable -> L22
        r1.addInterceptor(new k());     // Catch: Throwable -> L22
        r1.addInterceptor(new l());     // Catch: Throwable -> L22
        r1.addNetworkInterceptor(new i());     // Catch: Throwable -> L22
        OkHttpClient.Builder r3 = b(r1);     // Catch: Throwable -> L22
        r3.followRedirects(true);     // Catch: Throwable -> L22
        a r4 = f2464b;     // Catch: Throwable -> L22
        if (r4 == null) goto L19;
        r4.a(r3);     // Catch: Throwable -> L22
    L19:
        OkHttpClient r5 = r3.build();     // Catch: Throwable -> L22
        this.f2465a = r5;     // Catch: Throwable -> L22
        monitor-exit(com.bytedance.frameworks.baselib.network.http.f.class);     // Catch: Throwable -> L22
        return r5;
    L14:
        if (r2 >= 4) goto L16;
        a(r1);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }
}
