package com.larus.browsertakeover.transport;

import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends WebSocketListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ int b;
    public final /* synthetic */ BrowserTransport.a c;

    public final void onMessage(WebSocket r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "webSocket");
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        if (this.a.c.get() == this.b) goto L5;
        return;
    L5:
        if (this.a.f == true) goto L9;
        this.c.onMessage(r3);
        return;
    }

    public final void onOpen(WebSocket r2, Response r3) {
        Intrinsics.checkNotNullParameter(r2, "webSocket");
        Intrinsics.checkNotNullParameter(r3, "response");
        if (this.a.c.get() == this.b) goto L5;
    L9:
        r2.close(GuidePriority.COMMERCE_CREDIT_PRIORITY, "stale connection");
        return;
    L5:
        if (this.a.f == true) goto L9;
        this.a.e = r2;
        this.c.onConnected();
    }

    public e(d r1, int r2, com.larus.browsertakeover.cdp.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onClosed(WebSocket r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "webSocket");
        Intrinsics.checkNotNullParameter(r3, "reason");
        if (this.a.c.get() == this.b) goto L5;
        return;
    L5:
        if (this.a.f == true) goto L10;
        this.a.e = null;
        this.c.onDisconnected();
        return;
    }

    public final void onClosing(WebSocket r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "webSocket");
        Intrinsics.checkNotNullParameter(r3, "reason");
        r1.close(GuidePriority.COMMERCE_CREDIT_PRIORITY, "peer closing");
    }

    public final void onFailure(WebSocket r4, Throwable r5, Response r6) {
        Intrinsics.checkNotNullParameter(r4, "webSocket");
        Intrinsics.checkNotNullParameter(r5, "throwable");
        if (this.a.c.get() == this.b) goto L5;
        return;
    L5:
        if (this.a.f == true) goto L13;
        Integer r0 = null;
        this.a.e = null;
        FLogger r7 = FLogger.a;
        StringBuilder r1 = new StringBuilder("Websocket failed, type=");
        r1.append(r5.getClass().getSimpleName());
        r1.append(", status=");
        if (r6 == null) goto L10;
        r0 = Integer.valueOf(r6.code());
    L10:
        r1.append(r0);
        r7.e("CloudWebSocketTransport", r1.toString());
        this.c.onError();
        return;
    }
}
