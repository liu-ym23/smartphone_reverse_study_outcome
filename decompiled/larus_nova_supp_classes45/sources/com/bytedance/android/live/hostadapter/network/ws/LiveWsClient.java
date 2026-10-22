package com.bytedance.android.live.hostadapter.network.ws;

import android.content.Context;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdkapi.game_ws.ILiveWsClient;
import com.bytedance.android.livesdkapi.game_ws.ILiveWsListener;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/hostadapter/network/ws/LiveWsClient;", "Lcom/bytedance/android/livesdkapi/game_ws/ILiveWsClient;", "config", "Lcom/bytedance/android/live/hostadapter/network/ws/Config;", "(Lcom/bytedance/android/live/hostadapter/network/ws/Config;)V", "getConfig", "()Lcom/bytedance/android/live/hostadapter/network/ws/Config;", "manualClose", "", "okhttpClient", "Lokhttp3/OkHttpClient;", "retryTimes", "Ljava/util/concurrent/atomic/AtomicInteger;", "status", "Lcom/bytedance/android/live/hostadapter/network/ws/Status;", "webSocket", "Lokhttp3/WebSocket;", "webSocketListener", "Lcom/bytedance/android/live/hostadapter/network/ws/LiveWsClient$WsListenerImpl;", "disconnect", "", "needRetry", "resultCode", "", "send", "content", "", "setStatus", "tryConnect", "Companion", "WsListenerImpl", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public final class LiveWsClient implements ILiveWsClient {
    public static final Companion Companion = null;
    public static final int NORMAL_CLOSE = 1000;
    public static final String TAG = "LiveWsClient";
    private final Config config;
    private boolean manualClose;
    private OkHttpClient okhttpClient;
    private AtomicInteger retryTimes;
    private volatile Status status;
    private WebSocket webSocket;
    private WsListenerImpl webSocketListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JI\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/hostadapter/network/ws/LiveWsClient$Companion;", "", "()V", "NORMAL_CLOSE", "", "TAG", "", "config", "Lcom/bytedance/android/live/hostadapter/network/ws/LiveWsClient;", "context", "Landroid/content/Context;", LiveSlardarConstants.EXTRA_KEY_URL, "listener", "Lcom/bytedance/android/livesdkapi/game_ws/ILiveWsListener;", "pingInterval", "", "retry", "", "retryTimes", "(Landroid/content/Context;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/game_ws/ILiveWsListener;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/bytedance/android/live/hostadapter/network/ws/LiveWsClient;", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final LiveWsClient config(Context r11, String r12, ILiveWsListener r13) {
            return config$default(this, r11, r12, r13, null, null, null, 56, null);
        }

        @JvmStatic
        public final LiveWsClient config(Context r11, String r12, ILiveWsListener r13, Long r14) {
            return config$default(this, r11, r12, r13, r14, null, null, 48, null);
        }

        @JvmStatic
        public final LiveWsClient config(Context r11, String r12, ILiveWsListener r13, Long r14, Boolean r15) {
            return config$default(this, r11, r12, r13, r14, r15, null, 32, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final LiveWsClient config(Context r11, String r12, ILiveWsListener r13, Long r14, Boolean r15, Integer r16) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r12, LiveSlardarConstants.EXTRA_KEY_URL);
            Intrinsics.checkNotNullParameter(r13, "listener");
            if (r14 == null) goto L5;
            long r5 = r14.longValue();
        L6:
            if (r15 == null) goto L8;
            boolean r7 = r15.booleanValue();
        L9:
            if (r16 == null) goto L11;
            int r8 = r16.intValue();
        L13:
            return new LiveWsClient(new Config(r12, r11, r13, r5, r7, r8), null);
        L11:
            r8 = 3;
            goto L13
        L8:
            r7 = true;
            goto L9
        L5:
            r5 = 10;
            goto L6
        }

        public static /* synthetic */ LiveWsClient config$default(Companion r7, Context r8, String r9, ILiveWsListener r11, Long r12, Boolean r13, Integer r14, int r15, Object r16) {
            if ((r15 & 8) == 0) goto L5;
            r12 = 10L;
        L5:
            Long r4 = r12;
            if ((r15 & 16) == 0) goto L8;
            r13 = Boolean.TRUE;
        L8:
            Boolean r5 = r13;
            if ((r15 & 32) == 0) goto L12;
            r14 = 3;
        L12:
            return r7.config(r8, r9, r11, r4, r5, r14);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Status.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[Status.CONNECTED.ordinal()] = 1;
            r0[Status.CONNECTING.ordinal()] = 2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/hostadapter/network/ws/LiveWsClient$WsListenerImpl;", "Lokhttp3/WebSocketListener;", "(Lcom/bytedance/android/live/hostadapter/network/ws/LiveWsClient;)V", "onClosed", "", "webSocket", "Lokhttp3/WebSocket;", "code", "", "reason", "", "onClosing", "onFailure", "t", "", "response", "Lokhttp3/Response;", "onMessage", "msg", "bytes", "Lokio/ByteString;", "onOpen", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
    public final class WsListenerImpl extends WebSocketListener {
        final /* synthetic */ LiveWsClient this$0;

        public void onClosing(WebSocket r1, int r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "webSocket");
            Intrinsics.checkNotNullParameter(r3, "reason");
        }

        public void onMessage(WebSocket r2, ByteString r3) {
            Intrinsics.checkNotNullParameter(r2, "webSocket");
            Intrinsics.checkNotNullParameter(r3, "bytes");
        }

        public WsListenerImpl(LiveWsClient r1) {
            this.this$0 = r1;
        }

        public void onMessage(WebSocket r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "webSocket");
            Intrinsics.checkNotNullParameter(r3, "msg");
            this.this$0.getConfig().getListener().onMessage(r3);
        }

        public void onOpen(WebSocket r2, Response r3) {
            Intrinsics.checkNotNullParameter(r2, "webSocket");
            Intrinsics.checkNotNullParameter(r3, "response");
            LiveWsClient.access$setStatus(this.this$0, Status.CONNECTED);
            this.this$0.getConfig().getListener().onConnect();
        }

        public void onClosed(WebSocket r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "webSocket");
            Intrinsics.checkNotNullParameter(r4, "reason");
            if (LiveWsClient.access$getManualClose$p(this.this$0) == false) goto L6;
            this.this$0.getConfig().getListener().onClosed(LiveWsClient.access$getManualClose$p(this.this$0));
            return;
        L6:
            if (LiveWsClient.access$needRetry(this.this$0, r3) == false) goto L9;
            LiveWsClient.access$tryConnect(this.this$0);
            return;
        L9:
            this.this$0.getConfig().getListener().onClosed(LiveWsClient.access$getManualClose$p(this.this$0));
        }

        public void onFailure(WebSocket r1, Throwable r2, Response r3) {
            Intrinsics.checkNotNullParameter(r1, "webSocket");
            Intrinsics.checkNotNullParameter(r2, "t");
            Objects.toString(r2.getCause());
            LiveWsClient.access$setStatus(this.this$0, Status.FAILED);
            this.this$0.getConfig().getListener().onFailure();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final LiveWsClient config(Context r9, String r11, ILiveWsListener r12) {
        return Companion.config$default(Companion, r9, r11, r12, null, null, null, 56, null);
    }

    @JvmStatic
    public static final LiveWsClient config(Context r9, String r11, ILiveWsListener r12, Long r13) {
        return Companion.config$default(Companion, r9, r11, r12, r13, null, null, 48, null);
    }

    @JvmStatic
    public static final LiveWsClient config(Context r9, String r11, ILiveWsListener r12, Long r13, Boolean r14) {
        return Companion.config$default(Companion, r9, r11, r12, r13, r14, null, 32, null);
    }

    @JvmStatic
    public static final LiveWsClient config(Context r7, String r8, ILiveWsListener r9, Long r11, Boolean r12, Integer r13) {
        return Companion.config(r7, r8, r9, r11, r12, r13);
    }

    private final void tryConnect() {
        monitor-enter(this);
        Status r0 = this.status;     // Catch: Throwable -> L14
        Status r1 = Status.CONNECTING;     // Catch: Throwable -> L14
        if (r0 != r1) goto L6;
    L12:
        monitor-exit(this);
        return;
    L6:
        if (this.status == Status.CONNECTED) goto L12;
        setStatus(r1);     // Catch: Throwable -> L14
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        this.manualClose = false;
        Request r3 = new Request.Builder().url(this.config.getUrl()).build();
        this.webSocket = this.okhttpClient.newWebSocket(r3, this.webSocketListener);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void disconnect() {
        this.manualClose = true;
        this.retryTimes.set(0);
        monitor-enter(this);
        Status r1 = this.status;     // Catch: Throwable -> L20
        int r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];     // Catch: Throwable -> L20
        if (r2 != 1) goto L7;
        WebSocket r0 = this.webSocket;     // Catch: Throwable -> L20
        if (r0 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("webSocket");     // Catch: Throwable -> L20
    L16:
        r0.close(1000, "normal close");     // Catch: Throwable -> L20
    L17:
        setStatus(Status.DISCONNECTED);     // Catch: Throwable -> L20
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L7:
        if (r2 != 2) goto L17;
        WebSocket r4 = this.webSocket;     // Catch: Throwable -> L20
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("webSocket");     // Catch: Throwable -> L20
    L12:
        r4.cancel();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final Config getConfig() {
        return this.config;
    }

    private LiveWsClient(Config r4) {
        this.config = r4;
        this.okhttpClient = new OkHttpClient.Builder().pingInterval(r4.getPingInterval(), TimeUnit.SECONDS).build();
        this.status = Status.DISCONNECTED;
        this.retryTimes = new AtomicInteger(0);
        this.webSocketListener = new WsListenerImpl(this);
        tryConnect();
    }

    public static final /* synthetic */ boolean access$getManualClose$p(LiveWsClient r0) {
        return r0.manualClose;
    }

    public static final /* synthetic */ void access$tryConnect(LiveWsClient r0) {
        r0.tryConnect();
    }

    private final boolean needRetry(int r2) {
        if (this.config.getRetry() == true) goto L5;
    L9:
        return false;
    L5:
        if (r2 == 1000) goto L9;
        if (this.retryTimes.getAndIncrement() >= this.config.getRetryTimes()) goto L9;
        return true;
    }

    private final synchronized void setStatus(Status r1) {
        monitor-enter(this);
        this.status = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void send(String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "content");     // Catch: Throwable -> L11
        if (this.status != Status.CONNECTED) goto L9;
        WebSocket r0 = this.webSocket;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("webSocket");     // Catch: Throwable -> L11
    L8:
        r0.send(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ LiveWsClient(Config r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static final /* synthetic */ boolean access$needRetry(LiveWsClient r0, int r1) {
        return r0.needRetry(r1);
    }

    public static final /* synthetic */ void access$setManualClose$p(LiveWsClient r0, boolean r1) {
        r0.manualClose = r1;
    }

    public static final /* synthetic */ void access$setStatus(LiveWsClient r0, Status r1) {
        r0.setStatus(r1);
    }
}
