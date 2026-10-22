package com.lynx.devtool.module;

import com.lynx.jsbridge.Arguments;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.base.LLog;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxWebSocket {
    static final String TAG = "LynxWebSocket";
    private final Map<Integer, ContentHandler> mContentHandlers;
    private final Delegate mDelegate;
    private final Map<Integer, WebSocket> mWebSocketConnections;

    public interface ContentHandler {
        void onMessage(String r1, WritableMap r2);

        void onMessage(ByteString r1, WritableMap r2);
    }

    public interface Delegate {
        void sendEvent(String r1, WritableMap r2);
    }

    public void destroy() {
        Iterator<Map.Entry<Integer, WebSocket>> r0 = this.mWebSocketConnections.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().close(1000, "Destroy");
        goto L4
    }

    public LynxWebSocket(Delegate r2) {
        this.mWebSocketConnections = new ConcurrentHashMap();
        this.mContentHandlers = new ConcurrentHashMap();
        this.mDelegate = r2;
    }

    public static /* synthetic */ Map access$000(LynxWebSocket r0) {
        return r0.mWebSocketConnections;
    }

    public static /* synthetic */ Map access$300(LynxWebSocket r0) {
        return r0.mContentHandlers;
    }

    public void ping(double r2) {
        int r3 = (int) r2;
        WebSocket r4 = this.mWebSocketConnections.get(Integer.valueOf(r3));
        if (r4 != null) goto L11;
        notifyWebSocketFailed(r3, "client is null", true);
        this.mWebSocketConnections.remove(Integer.valueOf(r3));
        this.mContentHandlers.remove(Integer.valueOf(r3));
        return;
    L11:
        r4.send(ByteString.EMPTY);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        notifyWebSocketFailed(r3, e.getMessage());
    }

    private void notifyWebSocketFailed(int r2, String r3) {
        notifyWebSocketFailed(r2, r3, false);
    }

    private void sendEvent(String r2, WritableMap r3) {
        this.mDelegate.sendEvent(r2, r3);
    }

    public void send(String r2, double r3) {
        int r4 = (int) r3;
        WebSocket r5 = this.mWebSocketConnections.get(Integer.valueOf(r4));
        if (r5 != null) goto L11;
        notifyWebSocketFailed(r4, "client is null", true);
        this.mWebSocketConnections.remove(Integer.valueOf(r4));
        this.mContentHandlers.remove(Integer.valueOf(r4));
        return;
    L11:
        r5.send(r2);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        notifyWebSocketFailed(r4, e.getMessage());
    }

    public void setContentHandler(int r2, ContentHandler r3) {
        if (r3 == null) goto L4;
        this.mContentHandlers.put(Integer.valueOf(r2), r3);
        return;
    L4:
        this.mContentHandlers.remove(Integer.valueOf(r2));
    }

    public static /* synthetic */ void access$100(LynxWebSocket r0, String r1, WritableMap r2) {
        r0.sendEvent(r1, r2);
    }

    public static /* synthetic */ void access$200(LynxWebSocket r0, int r1, String r2) {
        r0.notifyWebSocketFailed(r1, r2);
    }

    private void notifyWebSocketFailed(int r4, String r5, boolean r6) {
        WritableMap r0 = Arguments.createMap();
        r0.putInt("id", r4);
        r0.putString("message", r5);
        sendEvent("websocketFailed", r0);
        if (r6 == false) goto L6;
        WritableMap r7 = Arguments.createMap();
        r7.putInt("id", r4);
        r7.putInt(LynxResourceModule.CODE_KEY, 0);
        r7.putString("reason", r5);
        sendEvent("websocketClosed", r7);
        return;
    }

    public void close(double r2, String r4, double r5) {
        int r6 = (int) r5;
        WebSocket r7 = this.mWebSocketConnections.get(Integer.valueOf(r6));
        if (r7 != null) goto L11;
        return;
    L11:
        r7.close((int) r2, r4);     // Catch: Exception -> L8
        this.mWebSocketConnections.remove(Integer.valueOf(r6));     // Catch: Exception -> L8
        this.mContentHandlers.remove(Integer.valueOf(r6));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        LLog.e(TAG, "Could not close WebSocket connection for id " + r6 + e);
    }

    public void connect(String r5, ReadableArray r6, ReadableMap r7, double r8) {
        final int r9 = (int) r8;
        OkHttpClient.Builder r10 = new OkHttpClient.Builder();
        TimeUnit r11 = TimeUnit.SECONDS;
        OkHttpClient r12 = r10.connectTimeout(10, r11).writeTimeout(10, r11).readTimeout(0, TimeUnit.MINUTES).build();
        Request.Builder r13 = new Request.Builder().tag(Integer.valueOf(r9)).url(r5);
        if (r6 != null) goto L5;
    L18:
        r12.newWebSocket(r13.build(), new AnonymousClass1(this, r9));
        r12.dispatcher().executorService().shutdown();
        return;
    L5:
        if (r6.size() <= 0) goto L18;
        StringBuilder r14 = new StringBuilder();
        int r0 = 0;
    L8:
        if (r0 >= r6.size()) goto L16;
        String r1 = r6.getString(r0).trim();
        if (r1.isEmpty() == true) goto L14;
        if (r1.contains(",") == true) goto L14;
        r14.append(r1);
        r14.append(",");
    L14:
        r0 = r0 + 1;
        goto L8
    L16:
        if (r14.length() <= 0) goto L18;
        r14.replace(r14.length() - 1, r14.length(), NameKeys.UnloadStrategy_No_Strategy);
        r13.addHeader("Sec-WebSocket-Protocol", r14.toString());
        goto L18
    }
}
