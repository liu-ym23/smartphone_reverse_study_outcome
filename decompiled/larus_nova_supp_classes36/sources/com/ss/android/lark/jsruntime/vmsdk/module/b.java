package com.ss.android.lark.jsruntime.vmsdk.module;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.WebSocket;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements com.ss.android.lark.jsruntime.vmsdk.d {
    public final Map<Integer, WebSocket> a;
    public tnb.b b;

    public b() {
        this.a = new ConcurrentHashMap();
    }

    public final void a(int r3, String r4) {
        rnb.c.b("JSRuntimeWebSocketDelegate", "notifyWebSocketFailed() called with: id = [" + r3 + "], message = [" + r4 + "]");
        HashMap r0 = new HashMap();
        r0.put("id", Integer.valueOf(r3));
        r0.put(INotificationHitPoint.NoticeType.MESSAGE, r4);
        b("websocketFailed", r0);
    }

    public final void b(String r3, Map<String, Object> r4) {
        rnb.c.c("JSRuntimeWebSocketDelegate", "sendEvent() called with: eventName = [" + r3 + "]");
        tnb.b r0 = this.b;
        if (r0 == null) goto L6;
        r0.sendEvent(r3, r4);
        return;
    }
}
