package com.ss.android.lark.jsruntime.vmsdk.module;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import com.ss.android.lark.jsruntime.vmsdk.g;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.live.sdk.msg.uplink.UplinkStrategy;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.h;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class VmsdkWebSocketModule extends JSModule {
    public static final String NAME = "VMWebSocket";
    private static final String TAG = "VMSDK_VmsdkWebSocketModule";
    private final com.ss.android.lark.jsruntime.vmsdk.d mWebSocketDelegate;

    public static String name() {
        return NAME;
    }

    private static String getDefaultOrigin(String r11) {
        URI r0 = new URI(r11);     // Catch: URISyntaxException -> L39
        String r1 = r0.getScheme();     // Catch: URISyntaxException -> L39
        int r2 = r1.hashCode();     // Catch: URISyntaxException -> L39
        String r9 = "https";
        if (r2 == 3804) goto L22;
        if (r2 == 118039) goto L19;
        if (r2 == 3213448) goto L16;
        if (r2 == 99617003) goto L13;
    L24:
        byte r3 = -1;
    L25:
        if (r3 == 0) goto L35;
        if (r3 == 1) goto L32;
        r9 = "";
        if (r3 == 2) goto L31;
        if (r3 != 3) goto L35;
    L31:
        r9 = "" + r0.getScheme();     // Catch: URISyntaxException -> L39
        goto L35
    L32:
        r9 = TrafficMetrics.FROM_HTTP;
    L35:
        if (r0.getPort() == (-1)) goto L38;
        return String.format("%s://%s:%s", new Object[]{r9, r0.getHost(), Integer.valueOf(r0.getPort())});
    L38:
        return String.format("%s://%s", new Object[]{r9, r0.getHost()});
    L13:
        if (r1.equals("https") == false) goto L24;
        r3 = 3;
        goto L25
    L16:
        if (r1.equals(TrafficMetrics.FROM_HTTP) == false) goto L24;
        r3 = 2;
        goto L25
    L19:
        if (r1.equals("wss") == false) goto L24;
        r3 = 0;
        goto L25
    L22:
        if (r1.equals(UplinkStrategy.WS) == false) goto L24;
        r3 = 1;
    L39:
        e = move-exception;
        rnb.c.a.e(TAG, "Unable to set " + r11 + " as default origin header", e);
        throw new IllegalArgumentException("Unable to set " + r11 + " as default origin header");
    }

    @JSMethod
    public void ping(int r6) {
        rnb.c.c(TAG, "ping() called with: id = [" + r6 + "]");
        com.ss.android.lark.jsruntime.vmsdk.d r0 = this.mWebSocketDelegate;
        if (r0 == null) goto L11;
        b r1 = (b) r0;
        r1.getClass();
        rnb.c.c("JSRuntimeWebSocketDelegate", "ping() called with: id = [" + r6 + "]");
        WebSocket r2 = (WebSocket) ((ConcurrentHashMap) r1.a).get(Integer.valueOf(r6));
        if (r2 != null) goto L13;
        HashMap r3 = new HashMap();
        r3.put("id", Integer.valueOf(r6));
        r3.put(INotificationHitPoint.NoticeType.MESSAGE, "client is null");
        r1.b("websocketFailed", r3);
        HashMap r4 = new HashMap();
        r4.put("id", Integer.valueOf(r6));
        r4.put("code", 0);
        r4.put("reason", "client is null");
        r1.b("websocketClosed", r4);
        ((ConcurrentHashMap) r1.a).remove(Integer.valueOf(r6));
        return;
    L13:
        r2.send(ByteString.EMPTY);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        r1.a(r6, e.getMessage());
        return;
    L11:
        rnb.c.b(TAG, "mWebSocketDelegate is null");
    }

    public VmsdkWebSocketModule(Context r4, Object r5) {
        super(r4, r5);
        rnb.c.c(TAG, "VmsdkWebSocketModule() called with: context = [" + r4 + "], param = [" + r5 + "]");
        b r0 = new b();
        this.mWebSocketDelegate = r0;
        if (r5 != null) goto L5;
        return;
    L5:
        if ((r5 instanceof tnb.b) == false) goto L9;
        tnb.b r6 = (tnb.b) r5;
        rnb.c.c("JSRuntimeWebSocketDelegate", "setJSRuntimeDataSender() called with: jsRuntimeDataSender = [" + r6 + "]");
        r0.b = r6;
        return;
    }

    @JSMethod
    public void send(String r6, int r7) {
        com.ss.android.lark.jsruntime.vmsdk.d r0 = this.mWebSocketDelegate;
        if (r0 == null) goto L11;
        b r1 = (b) r0;
        r1.getClass();
        rnb.c.c("JSRuntimeWebSocketDelegate", "send() called with id = [" + r7 + "]");
        WebSocket r2 = (WebSocket) ((ConcurrentHashMap) r1.a).get(Integer.valueOf(r7));
        if (r2 != null) goto L13;
        HashMap r8 = new HashMap();
        r8.put("id", Integer.valueOf(r7));
        r8.put(INotificationHitPoint.NoticeType.MESSAGE, "client is null");
        r1.b("websocketFailed", r8);
        HashMap r9 = new HashMap();
        r9.put("id", Integer.valueOf(r7));
        r9.put("code", 0);
        r9.put("reason", "client is null");
        rnb.c.b("JSRuntimeWebSocketDelegate", "send: websocketFailed");
        r1.b("websocketClosed", r9);
        ((ConcurrentHashMap) r1.a).remove(Integer.valueOf(r7));
        return;
    L13:
        r2.send(r6);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        r1.a(r7, e.getMessage());
        return;
    L11:
        rnb.c.b(TAG, "mWebSocketDelegate is null");
    }

    @JSMethod
    public void sendArraybuffer(byte[] r5, int r6) {
        com.ss.android.lark.jsruntime.vmsdk.d r0 = this.mWebSocketDelegate;
        if (r0 == null) goto L11;
        b r1 = (b) r0;
        r1.getClass();
        rnb.c.c("JSRuntimeWebSocketDelegate", "sendArraybuffer() called with:  id = [" + r6 + "]");
        WebSocket r2 = (WebSocket) ((ConcurrentHashMap) r1.a).get(Integer.valueOf(r6));
        if (r2 != null) goto L13;
        HashMap r7 = new HashMap();
        r7.put("id", Integer.valueOf(r6));
        r7.put(INotificationHitPoint.NoticeType.MESSAGE, "client is null");
        r1.b("websocketFailed", r7);
        HashMap r8 = new HashMap();
        r8.put("id", Integer.valueOf(r6));
        r8.put("code", 0);
        r8.put("reason", "client is null");
        r1.b("websocketClosed", r8);
        ((ConcurrentHashMap) r1.a).remove(Integer.valueOf(r6));
        return;
    L13:
        r2.send(ByteString.of(r5));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        r1.a(r6, e.getMessage());
        return;
    L11:
        rnb.c.b(TAG, "mWebSocketDelegate is null");
    }

    @JSMethod
    public void sendBinary(String r5, int r6) {
        com.ss.android.lark.jsruntime.vmsdk.d r0 = this.mWebSocketDelegate;
        if (r0 == null) goto L11;
        b r1 = (b) r0;
        r1.getClass();
        rnb.c.c("JSRuntimeWebSocketDelegate", "sendBinary() called  id = [" + r6 + "]");
        WebSocket r2 = (WebSocket) ((ConcurrentHashMap) r1.a).get(Integer.valueOf(r6));
        if (r2 != null) goto L13;
        HashMap r7 = new HashMap();
        r7.put("id", Integer.valueOf(r6));
        r7.put(INotificationHitPoint.NoticeType.MESSAGE, "client is null");
        r1.b("websocketFailed", r7);
        HashMap r8 = new HashMap();
        r8.put("id", Integer.valueOf(r6));
        r8.put("code", 0);
        r8.put("reason", "client is null");
        r1.b("websocketClosed", r8);
        ((ConcurrentHashMap) r1.a).remove(Integer.valueOf(r6));
        return;
    L13:
        r2.send(ByteString.decodeBase64(r5));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        r1.a(r6, e.getMessage());
        return;
    L11:
        rnb.c.b(TAG, "mWebSocketDelegate is null");
    }

    private List<String> addHeader(List<String> r1, String r2, String r3) {
        r1.add(r2);
        r1.add(r3.trim());
        return r1;
    }

    @JSMethod
    public void close(int r7, String r8, int r9) {
        rnb.c.c(TAG, "close() called with: code = [" + r7 + "], reason = [" + r8 + "], id = [" + r9 + "]");
        com.ss.android.lark.jsruntime.vmsdk.d r0 = this.mWebSocketDelegate;
        if (r0 == null) goto L11;
        b r1 = (b) r0;
        rnb.c.c("JSRuntimeWebSocketDelegate", "close() called with: code = [" + r7 + "], reason = [" + r8 + "], id = [" + r9 + "]");
        WebSocket r2 = (WebSocket) ((ConcurrentHashMap) r1.a).get(Integer.valueOf(r9));
        if (r2 == null) goto L16;
        r2.close(r7, r8);     // Catch: Exception -> L9
        ((ConcurrentHashMap) r1.a).remove(Integer.valueOf(r9));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        rnb.c.a.e("JSRuntimeWebSocketDelegate", "Could not close WebSocket connection for id " + r9, e);
        return;
    L16:
        return;
    L11:
        rnb.c.b(TAG, "mWebSocketDelegate is null");
    }

    @JSMethod
    public void connect(String r11, ReadableArray r12, ReadableMap r13, int r14) {
        rnb.c.c(TAG, "connect() called with: protocols = [" + r12 + "], options = [" + r13 + "], id = [" + r14 + "]");
        ArrayList r0 = new ArrayList();
        if (r13 != null) goto L5;
    L19:
        addHeader(r0, "origin", getDefaultOrigin(r11));
    L20:
        int r15 = 0;
        if (r12 != null) goto L23;
    L36:
        com.ss.android.lark.jsruntime.vmsdk.d r16 = this.mWebSocketDelegate;
        if (r16 == null) goto L46;
        b r17 = (b) r16;
        h.a r3 = g.c;
        rnb.c.c("JSRuntimeWebSocketDelegate", "connect() called with: namesAndValues = [" + r0 + "], id = [" + r14 + "]，cookieJar= [ " + r3 + "]");
        if (r3 != null) goto L41;
        r3 = h.a;
        rnb.c.b("JSRuntimeWebSocketDelegate", "cookieJar is null, fallback to NO_COOKIES");
    L41:
        OkHttpClient.Builder r1 = new OkHttpClient.Builder();
        TimeUnit r2 = TimeUnit.SECONDS;
        OkHttpClient r4 = r1.connectTimeout(10, r2).writeTimeout(10, r2).readTimeout(0, TimeUnit.MINUTES).cookieJar(r3).build();
        Request.Builder r18 = new Request.Builder().tag(Integer.valueOf(r14)).url(r11);
    L43:
        if (r15 >= r0.size()) goto L45;
        r18.addHeader((String) ListProtector.get(r0, r15), (String) ListProtector.get(r0, r15 + 1));
        r15 = r15 + 2;
        goto L43
    L45:
        r4.newWebSocket(r18.build(), new a(r17, r14));
        r4.dispatcher().executorService().shutdown();
        return;
    L46:
        rnb.c.b(TAG, "mWebSocketDelegate is null");
        return;
    L23:
        if (r12.size() <= 0) goto L36;
        StringBuilder r5 = new StringBuilder("");
        int r6 = 0;
    L26:
        if (r6 >= r12.size()) goto L34;
        String r7 = r12.getString(r6).trim();
        if (TextUtils.isEmpty(r7) == true) goto L32;
        if (r7.contains(",") == true) goto L32;
        r5.append(r7);
        r5.append(",");
    L32:
        r6 = r6 + 1;
        goto L26
    L34:
        if (r5.length() <= 0) goto L36;
        r5.replace(r5.length() - 1, r5.length(), "");
        addHeader(r0, "Sec-WebSocket-Protocol", r5.toString());
        goto L36
    L5:
        if (r13.hasKey("headers") == false) goto L19;
        if (r13.getType("headers").equals(ReadableType.Map) == false) goto L19;
        ReadableMap r19 = r13.getMap("headers");
        if (r19 == null) goto L20;
        ReadableMapKeySetIterator r8 = r19.keySetIterator();
        if (r19.hasKey("origin") == true) goto L14;
        addHeader(r0, "origin", getDefaultOrigin(r11));
    L14:
        if (r8.hasNextKey() == false) goto L20;
        String r9 = r8.nextKey();
        if (ReadableType.String.equals(r19.getType(r9)) == true) goto L17;
        rnb.c.d(TAG, "Ignoring: requested " + r9 + ", value not a string");
        goto L14
    L17:
        addHeader(r0, r9, r19.getString(r9));
        goto L14
    }
}
