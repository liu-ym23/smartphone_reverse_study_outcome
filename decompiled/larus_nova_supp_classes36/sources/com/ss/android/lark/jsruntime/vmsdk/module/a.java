package com.ss.android.lark.jsruntime.vmsdk.module;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends WebSocketListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ b b;

    public a(b r1, int r2) {
        this.b = r1;
        this.a = r2;
    }

    public final void onMessage(WebSocket r3, ByteString r4) {
        HashMap r5 = new HashMap();
        r5.put("id", Integer.valueOf(this.a));
        r5.put("type", "binary");
        r5.put("data", r4.base64());
        rnb.c.c("JSRuntimeWebSocketDelegate", "onMessage: binary id = " + this.a);
        this.b.b("websocketMessage", r5);
    }

    public final void onOpen(WebSocket r3, Response r4) {
        Map<Integer, WebSocket> r0 = this.b.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.put(Integer.valueOf(this.a), r3);
        HashMap r5 = new HashMap();
        r5.put("id", Integer.valueOf(this.a));
        r5.put("protocol", r4.header("Sec-WebSocket-Protocol", ""));
        this.b.b("websocketOpen", r5);
    }

    public final void onMessage(WebSocket r3, String r4) {
        HashMap r5 = new HashMap();
        r5.put("id", Integer.valueOf(this.a));
        r5.put("type", "text");
        r5.put("data", r4);
        rnb.c.c("JSRuntimeWebSocketDelegate", "onMessage: binary id = " + this.a);
        this.b.b("websocketMessage", r5);
    }

    public final void onClosed(WebSocket r3, int r4, String r5) {
        HashMap r6 = new HashMap();
        r6.put("id", Integer.valueOf(this.a));
        r6.put("code", Integer.valueOf(r4));
        r6.put("reason", r5);
        this.b.b("websocketClosed", r6);
        ((ConcurrentHashMap) this.b.a).remove(Integer.valueOf(this.a));
        rnb.c.d("JSRuntimeWebSocketDelegate", "onClosed: id:" + this.a);
    }

    public final void onClosing(WebSocket r3, int r4, String r5) {
        rnb.c.d("JSRuntimeWebSocketDelegate", "onClosing() called with: websocket = [" + r3 + "], code = [" + r4 + "], reason = [" + r5 + "]");
        r3.close(r4, r5);
    }

    public final void onFailure(WebSocket r1, Throwable r2, Response r3) {
        this.b.a(this.a, r2.getMessage());
        ((ConcurrentHashMap) this.b.a).remove(Integer.valueOf(this.a));
        rnb.c.d("JSRuntimeWebSocketDelegate", "onFailure: id:" + this.a);
    }
}
