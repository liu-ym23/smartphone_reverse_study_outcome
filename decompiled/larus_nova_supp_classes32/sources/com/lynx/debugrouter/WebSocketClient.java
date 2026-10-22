package com.lynx.debugrouter;

import android.text.TextUtils;
import com.lynx.debugrouter.base.MessageTransceiver;
import com.lynx.debugrouter.base.MessageTransceiverStateListener;
import com.lynx.debugrouter.log.LLog;
import com.obric.aivoice.core.data.NameKeys;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class WebSocketClient extends WebSocketListener implements MessageTransceiver {
    private static final int MAX_LOG_LENGTH = 10240;
    private static final String TAG = "WebSocketClient";
    private OkHttpClient mClient;
    private MessageTransceiverStateListener mStateListener;
    private volatile WebSocket mWebSocket;

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public void disconnect() {
        if (this.mWebSocket == null) goto L6;
        this.mWebSocket.close(1000, null);
        this.mWebSocket = null;
        return;
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public long queueSize() {
        if (this.mWebSocket != null) goto L7;
        return 0;
    L7:
        return this.mWebSocket.queueSize();
    }

    public WebSocketClient() {
        OkHttpClient.Builder r0 = new OkHttpClient.Builder();
        TimeUnit r1 = TimeUnit.SECONDS;
        this.mClient = r0.pingInterval(5, r1).connectTimeout(5, r1).readTimeout(30, r1).writeTimeout(30, r1).build();
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public boolean connect(String r6) {
        LLog.d(TAG, "connect " + r6);
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
        int r1 = 80;
        URI r2 = new URI(r6);     // Catch: URISyntaxException -> L12
        r0 = r2.getHost();     // Catch: URISyntaxException -> L12
        int r3 = r2.getPort();     // Catch: URISyntaxException -> L12
        if (r3 == (-1)) goto L19;
    L15:
        this.mWebSocket = this.mClient.newWebSocket(new Request.Builder().url(r6).addHeader("Upgrade", "WebSocket").addHeader("Connection", "Upgrade").addHeader("Sec-WebSocket-Key", "J4axdrB5EVmab8YnJ4z3bw==").addHeader("Sec-WebSocket-Version", "13").addHeader("Host", r0 + ":" + r3).build(), this);
        return true;
    L19:
        if (TextUtils.equals(r2.getScheme().toLowerCase(Locale.US), "wss") == false) goto L9;
        r1 = 443;
    L9:
        r3 = r1;
    L10:
        URISyntaxException e = e;
    L14:
        e.printStackTrace();
    L12:
        e = move-exception;
        e = e;
        r3 = 80;
        goto L14
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public void removeStateListener(MessageTransceiverStateListener r1) {
        this.mStateListener = null;
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public void send(String r5) {
        if (this.mWebSocket == null) goto L15;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.length() >= MAX_LOG_LENGTH) goto L8;
        LLog.d(TAG, "send: ".concat(r5));
    L13:
        this.mWebSocket.send(r5);
        return;
    L8:
        int r0 = r5.indexOf(",");
        StringBuilder r1 = new StringBuilder("send: ");
        if (r0 > 0) goto L12;
        r0 = 200;
    L12:
        r1.append(r5.substring(0, r0));
        r1.append("...");
        LLog.d(TAG, r1.toString());
        goto L13
    }

    @Override // com.lynx.debugrouter.base.MessageTransceiver
    public void setStateListener(MessageTransceiverStateListener r1) {
        this.mStateListener = r1;
    }

    public void onMessage(WebSocket r4, String r5) {
        super.onMessage(r4, r5);
        if (r5.length() >= MAX_LOG_LENGTH) goto L5;
        LLog.d(TAG, "onMessage: ".concat(r5));
    L10:
        MessageTransceiverStateListener r6 = this.mStateListener;
        if (r6 == null) goto L14;
        r6.onMessage(this, r5);
        return;
    L14:
        return;
    L5:
        int r7 = r5.indexOf(",");
        StringBuilder r0 = new StringBuilder("onMessage: ");
        if (r7 > 0) goto L9;
        r7 = 200;
    L9:
        r0.append(r5.substring(0, r7));
        r0.append("...");
        LLog.d(TAG, r0.toString());
        goto L10
    }

    public void onOpen(WebSocket r1, Response r2) {
        super.onOpen(r1, r2);
        LLog.i(TAG, "onOpen");
        MessageTransceiverStateListener r3 = this.mStateListener;
        if (r3 == null) goto L6;
        r3.onOpen(this);
        return;
    }

    public void onMessage(WebSocket r1, ByteString r2) {
        super.onMessage(r1, r2);
    }

    public void onClosed(WebSocket r2, int r3, String r4) {
        super.onClosed(r2, r3, r4);
        LLog.i(TAG, "onClosed, code: " + r3 + ", reason: " + r4);
        MessageTransceiverStateListener r5 = this.mStateListener;
        if (r5 == null) goto L6;
        r5.onClose(this, r3, r4);
        return;
    }

    public void onClosing(WebSocket r1, int r2, String r3) {
        super.onClosing(r1, r2, r3);
        LLog.i(TAG, "onClosing");
    }

    public void onFailure(WebSocket r1, Throwable r2, Response r3) {
        super.onFailure(r1, r2, r3);
        LLog.i(TAG, "onError: " + r2.toString());
        MessageTransceiverStateListener r4 = this.mStateListener;
        if (r4 == null) goto L6;
        r4.onError(this, r2);
        return;
    }
}
