package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.os.Build;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.TlsVersion;
import okhttp3.b0;
import okhttp3.t;
import okhttp3.w;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f1685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f1686c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w f1687a;

    class a implements t {
        a(d r10) {
        }

        @Override // okhttp3.t
        public z a(t.a r10) {
            x r11 = r10.a();
            InetSocketAddress r12 = null;
            okhttp3.i r13 = r10.c();     // Catch: Throwable -> L26
            if (r13 == null) goto L6;
            b0 r14 = r13.a();     // Catch: Throwable -> L26
        L7:
            if (r14 == null) goto L10;
            r12 = r14.e();     // Catch: Throwable -> L26
        L10:
            if (Logger.debug() == false) goto L32;
            Logger.d("OkHttp3Builder", "-call- get res -  req: " + r11.hashCode() + " conn: " + r13 + " route: " + r14 + " addr: " + r12);     // Catch: Throwable -> L26
            goto L32
        L6:
            r14 = null;
        L32:
            z r15 = r10.b(r11);     // Catch: IOException -> L16
            if (r12 == null) goto L36;
            z.a r16 = r15.F();     // Catch: Throwable -> L27
            r16.a("x-net-info.remoteaddr", r12.getAddress().getHostAddress());     // Catch: Throwable -> L27
            return r16.c();
        L37:
            return r15;
        L36:
            return r15;
        L16:
            e = move-exception;
            if (r12 != null) goto L30;
        L25:
            throw e;
        L30:
            String r17 = e.getMessage();     // Catch: Throwable -> L23
            StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L23
            r18.append(r12.getAddress().getHostAddress());     // Catch: Throwable -> L23
            r18.append("|");     // Catch: Throwable -> L23
            if (r17 != null) goto L21;
            r17 = "null";
        L21:
            r18.append(r17);     // Catch: Throwable -> L23
            Reflect.on(e).set("detailMessage", r18.toString());     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            th.printStackTrace();
            goto L25
        }
    }

    public interface b {
        void a(w.a r10);
    }

    static {
    }

    public d() {
    }

    private static w b(w r10) {
        int r11 = f1686c;
        if (r11 > 0) goto L5;
        return r10;
    L5:
        if (r11 >= 4) goto L10;
        if (r10 == null) goto L11;
        w.a r12 = r10.z();
        f(r12);
        return r12.c();
    L11:
        return r10;
    L10:
        return r10;
    }

    public static void c(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        if (f1686c != 0) goto L8;
        f1686c = r10;
        return;
    }

    private static w.a d(w.a r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 >= 16) goto L5;
    L15:
        return r10;
    L5:
        if (r11 >= 22) goto L15;
        SSLContext r12 = SSLContext.getInstance("TLSv1.2");     // Catch: Exception -> L13
        r12.init(null, null, null);     // Catch: Exception -> L13
        r10.W(new o(r12.getSocketFactory()));     // Catch: Exception -> L9
    L11:
        okhttp3.k r13 = new okhttp3.k.a(okhttp3.k.f11985g).f(new TlsVersion[]{TlsVersion.TLS_1_2}).a();     // Catch: Exception -> L13
        ArrayList r14 = new ArrayList();     // Catch: Exception -> L13
        r14.add(r13);     // Catch: Exception -> L13
        r14.add(okhttp3.k.f11986h);     // Catch: Exception -> L13
        r14.add(okhttp3.k.f11987i);     // Catch: Exception -> L13
        r10.f(r14);     // Catch: Exception -> L13
        goto L15
    L9:
        e = move-exception;
        Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", e);     // Catch: Exception -> L13
        r10 = e(r10, r12);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", e);
        goto L15
    }

    private static w.a e(w.a r10, SSLContext r11) {
        TrustManagerFactory r12 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r12.init(null);
        TrustManager[] r13 = r12.getTrustManagers();
        if (r13.length != 1) goto L9;
        if ((r13[0] instanceof X509TrustManager) == false) goto L9;
        r10.X(new o(r11.getSocketFactory()), (X509TrustManager) r13[0]);
        return r10;
    L9:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r13));
    }

    private static void f(w.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList r11 = new ArrayList();
        int r12 = f1686c;
        if (r12 != 1) goto L7;
        Protocol r13 = Protocol.HTTP_2;
    L13:
        r11.add(r13);
    L14:
        f1686c = 4;
        r11.add(Protocol.HTTP_1_1);
        r10.S(Collections.unmodifiableList(r11));
        return;
    L7:
        if (r12 != 2) goto L9;
    L11:
        r13 = Protocol.SPDY_3;
        goto L13
    L9:
        if (r12 == 3) goto L14;
        r11.add(Protocol.HTTP_2);
        goto L11
    }

    public w a(boolean r10) {
        if (r10 == false) goto L5;
        o2.f.c0();
    L5:
        monitor-enter(o2.f.class);
        w r11 = this.f1687a;     // Catch: Throwable -> L22
        if (r11 == null) goto L11;
        b(r11);     // Catch: Throwable -> L22
        w r12 = this.f1687a;     // Catch: Throwable -> L22
        monitor-exit(o2.f.class);     // Catch: Throwable -> L22
        return r12;
    L11:
        w.a r13 = new w.a();     // Catch: Throwable -> L22
        int r14 = f1686c;     // Catch: Throwable -> L22
        if (r14 > 0) goto L14;
    L16:
        TimeUnit r15 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L22
        r13.e(new okhttp3.j(15, 180000, r15));     // Catch: Throwable -> L22
        r13.d(15000, r15);     // Catch: Throwable -> L22
        r13.U(15000, r15);     // Catch: Throwable -> L22
        r13.Z(15000, r15);     // Catch: Throwable -> L22
        r13.b(new a(this));     // Catch: Throwable -> L22
        r13.Y(f.b());     // Catch: Throwable -> L22
        r13.g(okhttp3.m.f12010a);     // Catch: Throwable -> L22
        r13.b(new e());     // Catch: Throwable -> L22
        r13.a(new j());     // Catch: Throwable -> L22
        r13.a(new k());     // Catch: Throwable -> L22
        r13.b(new h());     // Catch: Throwable -> L22
        w.a r16 = d(r13);     // Catch: Throwable -> L22
        r16.l(true);     // Catch: Throwable -> L22
        b r17 = f1685b;     // Catch: Throwable -> L22
        if (r17 == null) goto L19;
        r17.a(r16);     // Catch: Throwable -> L22
    L19:
        w r18 = r16.c();     // Catch: Throwable -> L22
        this.f1687a = r18;     // Catch: Throwable -> L22
        monitor-exit(o2.f.class);     // Catch: Throwable -> L22
        return r18;
    L14:
        if (r14 >= 4) goto L16;
        f(r13);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }
}
