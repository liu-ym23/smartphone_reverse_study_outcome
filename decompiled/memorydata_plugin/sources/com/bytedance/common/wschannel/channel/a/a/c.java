package com.bytedance.common.wschannel.channel.a.a;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.h;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.l;
import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.server.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.k;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.squareup.wire.Wire;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionSpec;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okhttp3.WebSocket;
import okio.ByteString;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
class c implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f2049b;
    private com.bytedance.common.wschannel.channel.a.a.d c;
    private OkHttpClient d;
    private int e;
    private Request f;
    private boolean g;
    private Map<String, Object> h;
    private Handler i;
    private com.bytedance.common.wschannel.channel.a.a.b.c j;
    private d k;
    private com.bytedance.common.wschannel.channel.a.a.b.a l;
    private boolean m;
    private com.bytedance.common.wschannel.heartbeat.a n;
    private com.bytedance.common.wschannel.heartbeat.b o;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f2059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f2060b;
        private OkHttpClient c;
        private com.bytedance.common.wschannel.channel.a.a.a.b d;
        private com.bytedance.common.wschannel.heartbeat.a e;

        a(Context r3) {
            this.f2059a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        a a(com.bytedance.common.wschannel.channel.a.a.a.b r3) {
            this.d = (com.bytedance.common.wschannel.channel.a.a.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.channel.a.a.a.b.class, "com.obric.memorydata.plugin");
            return this;
        }

        a a(com.bytedance.common.wschannel.heartbeat.a r1) {
            if (r1 == null) goto L4;
            this.e = r1;
        L4:
            return this;
        }

        public c a() {
            return new c(new b(this.f2059a, this.f2060b, this.c, this.d, this.e), null);
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f2061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f2062b;
        private OkHttpClient c;
        private com.bytedance.common.wschannel.channel.a.a.a.b d;
        private com.bytedance.common.wschannel.heartbeat.a e;

        b(Context r3, List<String> r4, OkHttpClient r5, com.bytedance.common.wschannel.channel.a.a.a.b r6, com.bytedance.common.wschannel.heartbeat.a r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            com.bytedance.common.wschannel.channel.a.a.a.b r10 = (com.bytedance.common.wschannel.channel.a.a.a.b) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.common.wschannel.channel.a.a.a.b.class, "com.obric.memorydata.plugin");
            this.f2061a = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
            this.f2062b = r9;
            this.c = r5;
            this.d = r10;
            this.e = r7;
        }

        static /* synthetic */ Context a(b r0) {
            return r0.f2061a;
        }

        static /* synthetic */ List a(b r2, List r3) {
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            r2.f2062b = r4;
            return r4;
        }

        static /* synthetic */ OkHttpClient b(b r0) {
            return r0.c;
        }

        static /* synthetic */ com.bytedance.common.wschannel.heartbeat.a c(b r0) {
            return r0.e;
        }

        static /* synthetic */ List d(b r0) {
            return r0.f2062b;
        }

        static /* synthetic */ com.bytedance.common.wschannel.channel.a.a.a.b e(b r0) {
            return r0.d;
        }

        public String toString() {
            return "Config{mHeartBeatPolicy=" + this.e + ", mContext=" + this.f2061a + ", wsUrls=" + this.f2062b + ", mOkHttpClient=" + this.c + ", mRetryPolicy=" + this.d + '}';
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.channel.a.a.c$c, reason: collision with other inner class name */
    private class C0114c extends com.bytedance.common.wschannel.channel.a.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f2063a;

        private C0114c(c r1) {
            this.f2063a = r1;
        }

        /* synthetic */ C0114c(c r1, AnonymousClass1 r2) {
            this(r1);
        }

        private boolean a(int r1) {
            if (r1 > 0) goto L4;
        L13:
            return true;
        L4:
            if (r1 == 414) goto L13;
            if (r1 == 511) goto L13;
            if (r1 == 512) goto L13;
            if (r1 == 513) goto L13;
            return false;
        }

        static /* synthetic */ boolean a(C0114c r0, int r1) {
            return r0.a(r1);
        }

        @Override // com.bytedance.common.wschannel.channel.a.a.b.c
        public void a(com.bytedance.common.wschannel.channel.a.a.b.b r3, int r4, String r5) {
            super.a((com.bytedance.common.wschannel.channel.a.a.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.channel.a.a.b.b.class, "com.obric.memorydata.plugin"), r4, r5);
            c.a(this.f2063a, new AnonymousClass4(this));
        }

        @Override // com.bytedance.common.wschannel.channel.a.a.b.c
        public void a(com.bytedance.common.wschannel.channel.a.a.b.b r3, final String r4) {
            com.bytedance.common.wschannel.channel.a.a.b.b r5 = (com.bytedance.common.wschannel.channel.a.a.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.channel.a.a.b.b.class, "com.obric.memorydata.plugin");
            c.a(this.f2063a, new AnonymousClass3(this, r4));
        }

        @Override // com.bytedance.common.wschannel.channel.a.a.b.c
        public void a(com.bytedance.common.wschannel.channel.a.a.b.b r8, Throwable r9, Response r10) {
            final com.bytedance.common.wschannel.channel.a.a.b.b r5 = (com.bytedance.common.wschannel.channel.a.a.b.b) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.common.wschannel.channel.a.a.b.b.class, "com.obric.memorydata.plugin");
            final String r2 = c.a(this.f2063a, r5);
            final int r3 = c.a(this.f2063a, r10);
            String r11 = c.b(this.f2063a, r3);
            if (h.a(r11) == true) goto L5;
        L8:
            final String r4 = r11;
            final Pair<String, Long> r6 = c.j(this.f2063a).a(r10);
            c.a(this.f2063a, r10);
            c.a(this.f2063a, new AnonymousClass6(this, r2, r3, r4, r5, r6));
            return;
        L5:
            if (h.a(r9.getMessage()) == false) goto L7;
            r11 = Log.getStackTraceString(r9);
            goto L8
        L7:
            r11 = r9.getMessage();
            goto L8
        }

        @Override // com.bytedance.common.wschannel.channel.a.a.b.c
        public void a(com.bytedance.common.wschannel.channel.a.a.b.b r3, final Response r4) {
            final com.bytedance.common.wschannel.channel.a.a.b.b r5 = (com.bytedance.common.wschannel.channel.a.a.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.channel.a.a.b.b.class, "com.obric.memorydata.plugin");
            Runnable r0 = new AnonymousClass1(this, r5, r4);
            c.a(this.f2063a, r0);
        }

        @Override // com.bytedance.common.wschannel.channel.a.a.b.c
        public void a(com.bytedance.common.wschannel.channel.a.a.b.b r3, final ByteString r4) {
            com.bytedance.common.wschannel.channel.a.a.b.b r5 = (com.bytedance.common.wschannel.channel.a.a.b.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.common.wschannel.channel.a.a.b.b.class, "com.obric.memorydata.plugin");
            c.a(this.f2063a, new AnonymousClass2(this, r4));
        }

        @Override // com.bytedance.common.wschannel.channel.a.a.b.c
        public void b(com.bytedance.common.wschannel.channel.a.a.b.b r8, final int r9, final String r10) {
            final com.bytedance.common.wschannel.channel.a.a.b.b r2 = (com.bytedance.common.wschannel.channel.a.a.b.b) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.common.wschannel.channel.a.a.b.b.class, "com.obric.memorydata.plugin");
            final String r3 = c.a(this.f2063a, r2);
            c.a(this.f2063a, new AnonymousClass5(this, r2, r3, r9, r10));
        }

        @Override // com.bytedance.common.wschannel.channel.a.a.b.c
        public void b(com.bytedance.common.wschannel.channel.a.a.b.b r2, ByteString r3) {
            final com.bytedance.common.wschannel.channel.a.a.b.b r4 = (com.bytedance.common.wschannel.channel.a.a.b.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.common.wschannel.channel.a.a.b.b.class, "com.obric.memorydata.plugin");
            c.a(this.f2063a, new AnonymousClass7(this, r4));
        }
    }

    interface d {
        void a(String r1);

        void a(String r1, int r2, String r3);

        void a(Response r1);

        void a(ByteString r1);

        void b(String r1);

        void b(String r1, int r2, String r3);
    }

    private c(b r4) {
        this.e = 3;
        this.h = new ConcurrentHashMap();
        this.i = new WeakHandler(Looper.myLooper(), this);
        this.j = new C0114c(this, null);
        this.f2049b = r4;
        this.f2048a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.a(r4), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.d = b.b(r4);
        com.bytedance.common.wschannel.heartbeat.a r5 = b.c(r4);
        this.n = r5;
        if (r5 != null) goto L5;
        this.n = new com.bytedance.common.wschannel.heartbeat.b.b(new com.bytedance.common.wschannel.heartbeat.b.a().c());
    L5:
        this.n.a(new AnonymousClass1(this), this.i);
        this.o = new com.bytedance.common.wschannel.heartbeat.b(new AnonymousClass2(this), this.i);
    }

    /* synthetic */ c(b r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ int a(c r0, Response r1) {
        return r0.a(r1);
    }

    private int a(Response r1) {
        if (r1 != null) goto L9;
        return -1;
    L9:
        return Integer.parseInt(r1.header("Handshake-Status"));
    L11:
        return -1;
    }

    static /* synthetic */ com.bytedance.common.wschannel.channel.a.a.b.a a(c r0, com.bytedance.common.wschannel.channel.a.a.b.a r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ String a(c r2, WebSocket r3) {
        return r2.a((WebSocket) ZeusTransformUtils.wrapperContextForParams(r3, WebSocket.class, "com.obric.memorydata.plugin"));
    }

    private String a(String r10, Map<String, Object> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r10) == true) goto L44;
        if (r12 == null) goto L44;
        String r0 = com.bytedance.common.wschannel.c.c.a(String.valueOf(r12.get(WsConstants.KEY_FPID)) + String.valueOf(r12.get(WsConstants.KEY_APP_KEY)) + String.valueOf(r12.get("device_id")) + WsConstants.SALT).toLowerCase();
        Uri.Builder r13 = Uri.parse(r10).buildUpon();
        Iterator r4 = r12.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L29;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L8;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r5.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L8;
        if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(r5.getKey(), CharSequence.class, "com.obric.memorydata.plugin"), WsConstants.KEY_HEADERS) == true) goto L8;
        if (r5.getValue() != null) goto L20;
        String r7 = "";
    L21:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");
        if (h.a(WsConstants.KEY_APP_KEY, r6) == true) goto L8;
        if (h.a(r6, WsConstants.KEY_EXTRA) == true) goto L8;
        if (h.a("app_version", r6) == false) goto L28;
        r6 = "version_code";
    L28:
        r13.appendQueryParameter(r6, r7);
        goto L8
    L20:
        r7 = r5.getValue().toString();
        goto L21
    L29:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r12.get(WsConstants.KEY_EXTRA), String.class, "com.obric.memorydata.plugin");
        if (h.a(r14) == true) goto L39;
        String[] r15 = r14.split("&");
        int r1 = r15.length;
        int r3 = 0;
    L32:
        if (r3 >= r1) goto L39;
        String r8 = r15[r3];
        if (TextUtils.isEmpty(r8) == true) goto L38;
        String[] r9 = r8.split("=");
        if (r9.length != 2) goto L38;
        r13.appendQueryParameter(r9[0], Uri.decode(r9[1]));
    L38:
        r3 = r3 + 1;
    L39:
        r13.appendQueryParameter("access_key", r0);
        r13.appendQueryParameter("ne", String.valueOf(i()));
        String r16 = r13.build().toString();
        Logger.d("WsChannelSdk_ok", "origin url: " + r16);
        String r17 = c(r16);     // Catch: Exception -> L42
        Logger.d("WsChannelSdk_ok", "Dispatch final url: " + r17);     // Catch: Exception -> L42
        return r17;
    L42:
        e = move-exception;
        throw e;
    L44:
        return "";
    }

    private String a(WebSocket r2) {
        WebSocket r1 = (WebSocket) ZeusTransformUtils.wrapperContextForParams(r2, WebSocket.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L10;
        Request r3 = r1.request();
        if (r3 == null) goto L12;
        HttpUrl r4 = r3.url();
        if (r4 != null) goto L9;
        return "";
    L9:
        return r4.toString();
    L12:
        return "";
    L10:
        return "";
    }

    private static OkHttpClient.Builder a(OkHttpClient.Builder r5) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L15:
        return r5;
    L5:
        if (Build.VERSION.SDK_INT >= 22) goto L15;
        SSLContext r1 = SSLContext.getInstance("TLSv1.2");     // Catch: Exception -> L13
        r1.init(null, null, null);     // Catch: Exception -> L13
        r5 = a(r5, r1);     // Catch: Exception -> L9
    L11:
        ConnectionSpec r2 = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(new TlsVersion[]{TlsVersion.TLS_1_2}).build();     // Catch: Exception -> L13
        ArrayList r3 = new ArrayList();     // Catch: Exception -> L13
        r3.add(r2);     // Catch: Exception -> L13
        r3.add(ConnectionSpec.COMPATIBLE_TLS);     // Catch: Exception -> L13
        r3.add(ConnectionSpec.CLEARTEXT);     // Catch: Exception -> L13
        r5.connectionSpecs(r3);     // Catch: Exception -> L13
        goto L15
    L9:
        e = move-exception;
        Log.e("WsChannelSdk_ok", "Error while setting TLS 1.2 with two parameter func", e);     // Catch: Exception -> L13
        r5.sslSocketFactory(new com.bytedance.common.wschannel.channel.a.a.b(r1.getSocketFactory()));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e("WsChannelSdk_ok", "Error while setting TLS 1.2", e);
        goto L15
    }

    private static OkHttpClient.Builder a(OkHttpClient.Builder r5, SSLContext r6) {
        TrustManagerFactory r0 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r0.init((KeyStore) ZeusTransformUtils.preCheckCast(null, KeyStore.class, "com.obric.memorydata.plugin"));
        TrustManager[] r1 = r0.getTrustManagers();
        if (r1.length != 1) goto L9;
        if (ZeusTransformUtils.instanceOf(r1[0], X509TrustManager.class) == false) goto L9;
        r5.sslSocketFactory(new com.bytedance.common.wschannel.channel.a.a.b(r6.getSocketFactory()), (X509TrustManager) ZeusTransformUtils.preCheckCast(r1[0], X509TrustManager.class, "com.obric.memorydata.plugin"));
        return r5;
    L9:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r1));
    }

    private void a(long r6, String r8, boolean r9) {
        this.i.removeMessages(1);
        if (a(this.f2048a) == true) goto L7;
        a(r8, 1, "network error", r9);
        Logger.d("WsChannelSdk_ok", "network not available，cancel retry");
        return;
    L7:
        if (this.g == false) goto L11;
        Logger.d("WsChannelSdk_ok", "close manually");
        return;
    L11:
        if (r6 != (-1)) goto L13;
    L16:
        Logger.d("WsChannelSdk_ok", "retry finished ---> interval: " + r6 + " , url :" + r8);
        Logger.d("WsChannelSdk_ok", "retry finished，waiting the next time to reconnect");
        Bundle r0 = new Bundle();
        r0.putString("method", "tryReconnect");
        r0.putLong("interval", r6);
        a(r8, 2, "retry failed", r9);
        r8 = this.c.c();
    L17:
        Logger.d("WsChannelSdk_ok", "the next time to reconnect is " + com.bytedance.common.wschannel.c.c.a(System.currentTimeMillis() + r6));
        Message r10 = new Message();
        r10.what = 1;
        r10.obj = r8;
        this.i.sendMessageDelayed(r10, r6);
        return;
    L13:
        if (h.a(r8) == true) goto L16;
        b(5);
        goto L17
    }

    static /* synthetic */ void a(c r0) {
        r0.k();
    }

    static /* synthetic */ void a(c r0, int r1) {
        r0.b(r1);
    }

    static /* synthetic */ void a(c r0, long r1, String r3, boolean r4) {
        r0.a(r1, r3, r4);
    }

    static /* synthetic */ void a(c r2, Closeable r3) {
        r2.a((Closeable) ZeusTransformUtils.wrapperContextForParams(r3, Closeable.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(c r2, Runnable r3) {
        r2.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(c r0, String r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(c r0, byte[] r1) {
        r0.b(r1);
    }

    private void a(Closeable r2) {
        Closeable r1 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        r1.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    private void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.i.post(r4);
    }

    private void a(String r6) {
        if (a(this.f2048a) == true) goto L6;
        a(r6, 1, "network error", true);
        return;
    L6:
        int r0 = b();
        if (r0 == 4) goto L24;
        if (r0 == 1) goto L25;
        b(r6);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        if (this.k == null) goto L16;
        this.k.a(r6, 4, Log.getStackTraceString(th));
    L16:
        if (WsConstants.TTNET_TRAFFIC_CONTROL_DROP.equals(th.getMessage()) == false) goto L26;
        String r2 = this.c.a();
        if (TextUtils.isEmpty(r2) == true) goto L20;
        Logger.d("WsChannelSdk_ok", th.getMessage() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r6 + ", try next url:" + r2);
        a(0, r2, true);
        return;
    L20:
        Logger.d("WsChannelSdk_ok", "All urls are dropped, stop retry.");
        this.c.b();
        return;
    L26:
        return;
    L25:
        return;
    }

    private void a(String r2, int r3, String r4, boolean r5) {
        b(2);
        h();
        d r1 = this.k;
        if (r1 == null) goto L7;
        if (r5 == false) goto L8;
        r1.a(r2, r3, r4);
        return;
    L8:
        return;
    }

    private boolean a(Context r2) {
        return NetworkUtils.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ boolean a(c r0, boolean r1) {
        r0.g = r1;
        return r1;
    }

    private boolean a(Object r3) {
        Logger.d("WsChannelSdk_ok", "send msg : " + r3);
        if (this.l != null) goto L5;
    L12:
        return false;
    L5:
        if (c() == false) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L10;
        return this.l.send((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    L10:
        if (ZeusTransformUtils.instanceOf(r3, ByteString.class) == false) goto L12;
        return this.l.send((ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
    }

    private boolean a(ByteString r1) {
        return a(r1);
    }

    static /* synthetic */ String b(c r0, int r1) {
        return r0.c(r1);
    }

    private synchronized void b(int r4) {
        monitor-enter(this);
        this.e = r4;     // Catch: Throwable -> L24
        String r0 = "";
        if (r4 != 1) goto L7;
        r0 = "connecting";
    L21:
        Logger.d("WsChannelSdk_ok", "current status is :" + r0);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L7:
        if (r4 != 2) goto L10;
        r0 = "connect failed";
        goto L21
    L10:
        if (r4 != 3) goto L13;
        r0 = "connection close ";
        goto L21
    L13:
        if (r4 != 4) goto L16;
        r0 = "connected";
        goto L21
    L16:
        if (r4 != 5) goto L19;
        r0 = "retry...";
        goto L21
    L19:
        if (r4 != 6) goto L21;
        r0 = "half-close status";
    L24:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void b(c r0) {
        r0.l();
    }

    private void b(String r7) {
        if (this.d != null) goto L5;
        OkHttpClient.Builder r0 = new OkHttpClient.Builder();
        r0.protocols(Collections.singletonList(Protocol.HTTP_1_1));
        this.d = a(r0).build();
    L5:
        Map<String, Object> r1 = this.h;
        String r8 = a(r7, r1);
        if (r1 == null) goto L8;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(r1.get(WsConstants.KEY_HEADERS), Map.class, "com.obric.memorydata.plugin");
    L10:
        if (h.a(r8) == false) goto L13;
        Logger.e("WsChannelSdk_ok", "url is empty,cancel connect");
        return;
    L13:
        j();
        Logger.d("WsChannelSdk_ok", "try tu open socket:" + r8);
        Request r3 = this.f;
        if (r3 != null) goto L16;
    L17:
        Request.Builder r4 = new Request.Builder().addHeader("Sec-Websocket-Protocol", "pbbp").addHeader("x-support-ack", "1").url(r8);
        if (r2 == null) goto L23;
        Iterator r5 = r2.entrySet().iterator();
    L21:
        if (r5.hasNext() == false) goto L23;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.addHeader((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin"));
    L23:
        this.f = r4.build();
    L24:
        b(1);
        com.bytedance.common.wschannel.channel.a.a.b.a r9 = com.bytedance.common.wschannel.channel.a.a.b.a.a(this.f, l.a(this.f2048a).f(), this.j);
        this.l = r9;
        r9.a(this.d);
        this.o.a(this.l);
        d r10 = this.k;
        if (r10 == null) goto L29;
        r10.a(r8);
        return;
    L29:
        return;
    L16:
        if (r8.equals(r3.url().toString()) == true) goto L24;
    L8:
        r2 = null;
        goto L10
    }

    private void b(byte[] r10) {
        Logger.d("WsChannelSdk_ok", "enter sendMessageAckIfNeeded");
        Frame r11 = (Frame) ZeusTransformUtils.preCheckCast(Frame.ADAPTER.decode(r10), Frame.class, "com.obric.memorydata.plugin");
        List r0 = (List) ZeusTransformUtils.preCheckCast(Wire.get(r11.headers, Collections.emptyList()), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L41;
        boolean r2 = false;
        String r3 = null;
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L23;
        Frame.ExtendedEntry r4 = (Frame.ExtendedEntry) ZeusTransformUtils.preCheckCast(r1.next(), Frame.ExtendedEntry.class, "com.obric.memorydata.plugin");
        if (r4.key.equals(WsConstants.KEY_NEED_ACK) == false) goto L16;
        if (r4.value.equals("1") == false) goto L16;
        r2 = true;
    L16:
        if (r4.key.equals(WsConstants.KEY_FRONTIER_MSGID) == true) goto L18;
    L20:
        if (r2 == false) goto L9;
        if (TextUtils.isEmpty(r3) == true) goto L9;
    L18:
        if (TextUtils.isEmpty(r4.value) == true) goto L20;
        r3 = r4.value;
    L23:
        if (r2 == true) goto L25;
        return;
    L25:
        ArrayList r5 = new ArrayList();
        r5.add(new Frame.ExtendedEntry.a().a(WsConstants.KEY_IS_ACK).b("1").a());
        r5.add(new Frame.ExtendedEntry.a().a(WsConstants.KEY_ACK_ID).b((String) ZeusTransformUtils.preCheckCast(Wire.get(r11.logidnew, ""), String.class, "com.obric.memorydata.plugin")).a());
        r5.add(new Frame.ExtendedEntry.a().a(WsConstants.KEY_ACK_CODE).b("0").a());
        if (TextUtils.isEmpty(r3) == true) goto L28;
        r5.add(new Frame.ExtendedEntry.a().a(WsConstants.KEY_FRONTIER_MSGID).b(r3).a());
    L28:
        Frame.a r12 = new Frame.a().a((Long) ZeusTransformUtils.preCheckCast(Wire.get(r11.seqid, Frame.DEFAULT_SEQID), Long.class, "com.obric.memorydata.plugin")).b((Long) ZeusTransformUtils.preCheckCast(Wire.get(r11.logid, Frame.DEFAULT_LOGID), Long.class, "com.obric.memorydata.plugin")).a((Integer) ZeusTransformUtils.preCheckCast(Wire.get(r11.service, Frame.DEFAULT_SERVICE), Integer.class, "com.obric.memorydata.plugin")).b((Integer) ZeusTransformUtils.preCheckCast(Wire.get(r11.method, Frame.DEFAULT_METHOD), Integer.class, "com.obric.memorydata.plugin")).c((String) ZeusTransformUtils.preCheckCast(Wire.get(r11.logidnew, ""), String.class, "com.obric.memorydata.plugin")).a(r5);
        a(Frame.ADAPTER.encode(r12.a()));
        return;
    }

    static /* synthetic */ boolean b(c r0, boolean r1) {
        r0.m = r1;
        return r1;
    }

    private String c(int r1) {
        if (r1 != 0) goto L5;
        return "success";
    L5:
        if (r1 != 404) goto L8;
        return "uri not found";
    L8:
        if (r1 != 409) goto L11;
        return "fpid not registered";
    L11:
        if (r1 != 410) goto L14;
        return "invalid device id";
    L14:
        if (r1 != 411) goto L17;
        return "appid not registered";
    L17:
        if (r1 != 412) goto L20;
        return "websocket protocol not support";
    L20:
        if (r1 != 413) goto L23;
        return "the device already connected";
    L23:
        if (r1 != 414) goto L26;
        return "server can't accept more connection,try again later";
    L26:
        if (r1 != 415) goto L29;
        return "device was blocked";
    L29:
        if (r1 != 416) goto L32;
        return "parameter error";
    L32:
        if (r1 != 417) goto L35;
        return "authentication failed";
    L35:
        if (r1 != 510) goto L38;
        return "server internal error";
    L38:
        if (r1 != 511) goto L41;
        return "server is busy，try again later";
    L41:
        if (r1 != 512) goto L44;
        return "server is shutting down";
    L44:
        if (r1 != 513) goto L47;
        return "auth server is error";
    L47:
        if (r1 != 514) goto L49;
        return "auth return error";
    L49:
        return "";
    }

    private String c(String r2) {
        if (j.a().b() == true) goto L19;
        k r1 = new k(r2, HttpMethodContrants.GET);
        com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.d r3 = j.a().a(r1);
        if (r3 != null) goto L7;
    L24:
        return r2;
    L7:
        if (r2.equals(r3.f2516a) == true) goto L24;
        if (r3.f2516a.isEmpty() == false) goto L16;
        if (r3.f2517b.isEmpty() == true) goto L16;
        throw new Exception(WsConstants.TTNET_TRAFFIC_CONTROL_DROP);
    L16:
        if (com.bytedance.frameworks.baselib.network.http.util.k.b(r3.f2516a) == false) goto L24;
        return r3.f2516a;
    L19:
        Logger.d("WsChannelSdk_ok", "fallback to host replace map");
        String r4 = j.a().b(r2);
        if (r2.equals(r4) == true) goto L24;
        if (com.bytedance.frameworks.baselib.network.http.util.k.b(r4) == false) goto L24;
        return r4;
    }

    static /* synthetic */ void c(c r0) {
        r0.e();
    }

    static /* synthetic */ Handler d(c r0) {
        return r0.i;
    }

    static /* synthetic */ com.bytedance.common.wschannel.channel.a.a.b.a e(c r0) {
        return r0.l;
    }

    private void e() {
        this.i.removeMessages(2);
        this.i.removeMessages(1);
        this.i.removeMessages(3);
        this.i.removeMessages(5);
        f();
        g();
    }

    static /* synthetic */ com.bytedance.common.wschannel.heartbeat.a f(c r0) {
        return r0.n;
    }

    private void f() {
        h();
        this.i.removeMessages(1);
    }

    static /* synthetic */ void g(c r0) {
        r0.f();
    }

    private boolean g() {
        int r0 = b();
        if (r0 != 3) goto L5;
        return true;
    L5:
        if (r0 != 2) goto L7;
        return true;
    L7:
        if (r0 == 5) goto L23;
        this.n.c();
        com.bytedance.common.wschannel.channel.a.a.b.a r3 = this.l;
        if (r3 == null) goto L22;
        Message r4 = this.i.obtainMessage(6, r3);
        this.i.sendMessageDelayed(r4, 1000);
        if (r0 != 4) goto L15;
        this.l.close(1000, "normal close");
        b(6);
        return false;
    L15:
        this.l.cancel();
        b(3);
        if (r0 == 1) goto L19;
        return true;
    L19:
        return false;
    L22:
        return true;
    L23:
        return true;
    }

    static /* synthetic */ d h(c r0) {
        return r0.k;
    }

    private void h() {
        com.bytedance.common.wschannel.channel.a.a.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    private int i() {
        NetworkUtils.NetworkType r2 = NetworkUtils.b(this.f2048a);
        if (r2 != null) goto L6;
        return 0;
    L6:
        if (r2 != NetworkUtils.NetworkType.NONE) goto L9;
        return 0;
    L9:
        if (r2 != NetworkUtils.NetworkType.WIFI) goto L13;
        return 1;
    L13:
        if (r2 != NetworkUtils.NetworkType.MOBILE_2G) goto L17;
        return 2;
    L17:
        if (r2 != NetworkUtils.NetworkType.MOBILE_3G) goto L20;
        return 3;
    L20:
        return 4;
    }

    static /* synthetic */ boolean i(c r0) {
        return r0.m;
    }

    static /* synthetic */ com.bytedance.common.wschannel.channel.a.a.d j(c r0) {
        return r0.c;
    }

    private void j() {
        com.bytedance.common.wschannel.channel.a.a.b.a r2 = this.l;
        if (r2 == null) goto L6;
        r2.b(1000, "normal close");
        return;
    }

    private void k() {
        Request r0 = this.f;
        if (r0 == null) goto L7;
        d r1 = this.k;
        if (r1 == null) goto L7;
        r1.a(r0.url().toString(), 3, "heatbeat timeout");
    L7:
        Pair<String, Long> r2 = this.c.a(null);
        e();
        j();
        a(0, (String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.memorydata.plugin"), true);
    }

    static /* synthetic */ boolean k(c r0) {
        return r0.g;
    }

    private void l() {
        this.i.post(new AnonymousClass6(this));
    }

    static /* synthetic */ void l(c r0) {
        r0.h();
    }

    static /* synthetic */ com.bytedance.common.wschannel.heartbeat.b m(c r0) {
        return r0.o;
    }

    void a() {
        a(new AnonymousClass3(this));
    }

    void a(int r2) {
        this.i.obtainMessage(3, Integer.valueOf(r2)).sendToTarget();
    }

    void a(d r3) {
        this.k = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
    }

    void a(Map<String, Object> r3) {
        Map<? extends String, ? extends Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        r4.remove(WsConstants.KEY_CHANNEL_ID);
        this.h.putAll(r4);
    }

    void a(Map<String, Object> r3, List<String> r4) {
        final Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == false) goto L6;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L6:
        a(new AnonymousClass4(this, r5, r6));
    }

    void a(boolean r2) {
        this.i.obtainMessage(5, Boolean.valueOf(r2)).sendToTarget();
    }

    boolean a(byte[] r1) {
        return a(ByteString.of(r1));
    }

    synchronized int b() {
        monitor-enter(this);
        int r0 = this.e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    void b(Map<String, Object> r3, List<String> r4) {
        final Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == false) goto L6;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L6:
        a(new AnonymousClass7(this, r5, r6));
    }

    boolean c() {
        if (b() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    void d() {
        this.i.removeMessages(2);
        this.i.removeMessages(1);
        this.i.removeMessages(3);
        this.i.removeMessages(5);
        a(new AnonymousClass5(this));
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        int r0 = r7.what;
        if (r0 != 1) goto L47;
        if (c() == false) goto L9;
        return;
    L9:
        this.i.removeMessages(1);
        this.i.removeMessages(2);
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.obj, String.class, "com.obric.memorydata.plugin");
    L10:
        a(r8);
        return;
    L47:
        if (r0 != 2) goto L18;
        this.i.removeMessages(2);     // Catch: Throwable -> L15
        this.i.removeMessages(1);     // Catch: Throwable -> L15
        b.a(this.f2049b, (List) ZeusTransformUtils.preCheckCast(r7.obj, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        this.g = false;     // Catch: Throwable -> L15
        this.c = new com.bytedance.common.wschannel.channel.a.a.d(b.d(this.f2049b), b.e(this.f2049b));     // Catch: Throwable -> L15
        f();     // Catch: Throwable -> L15
        a(this.c.c());     // Catch: Throwable -> L15
    L46:
        return;
    L18:
        if (r0 != 3) goto L33;
        this.i.removeMessages(2);
        this.i.removeMessages(1);
        if (c() == false) goto L22;
        return;
    L22:
        f();
        if (a(this.f2048a) == true) goto L25;
        Logger.d("WsChannelSdk_ok", "network changed! but the network is not available，do not retry");
        return;
    L25:
        if (g() == false) goto L30;
        com.bytedance.common.wschannel.channel.a.a.d r9 = this.c;
        if (r9 != null) goto L29;
        return;
    L29:
        r8 = r9.c();
        goto L10
    L30:
        this.m = true;
        return;
    L33:
        if (r0 != 5) goto L40;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.obj, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L37;
        AppState r10 = AppState.STATE_FOREGROUND;
    L38:
        this.o.a(r10);
        this.n.a(r10);
        return;
    L37:
        r10 = AppState.STATE_BACKGROUND;
        goto L38
    L40:
        if (r0 != 7) goto L54;
        this.i.removeMessages(2);     // Catch: Throwable -> L15
        this.i.removeMessages(1);     // Catch: Throwable -> L15
        b.a(this.f2049b, (List) ZeusTransformUtils.preCheckCast(r7.obj, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        this.g = false;     // Catch: Throwable -> L15
        this.c = new com.bytedance.common.wschannel.channel.a.a.d(b.d(this.f2049b), b.e(this.f2049b));     // Catch: Throwable -> L15
        f();     // Catch: Throwable -> L15
        if (g() == false) goto L44;
        a(this.c.c());     // Catch: Throwable -> L15
        goto L46
    L44:
        this.m = true;     // Catch: Throwable -> L15
        goto L46
    L54:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
    }
}
