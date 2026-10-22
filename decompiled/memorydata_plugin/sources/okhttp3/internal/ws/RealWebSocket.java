package okhttp3.internal.ws;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.RealCall;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0006[\\]^_`B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020#2\u0006\u00101\u001a\u000202J\b\u00103\u001a\u00020/H\u0016J\u001f\u00104\u001a\u00020/2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0000¢\u0006\u0002\b9J\u001a\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020#2\b\u0010<\u001a\u0004\u0018\u00010\u0017H\u0016J \u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020#2\b\u0010<\u001a\u0004\u0018\u00010\u00172\u0006\u0010=\u001a\u00020\nJ\u000e\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020@J\u001c\u0010A\u001a\u00020/2\n\u0010B\u001a\u00060Cj\u0002`D2\b\u00105\u001a\u0004\u0018\u000106J\u0016\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)J\u0006\u0010G\u001a\u00020/J\u0018\u0010H\u001a\u00020/2\u0006\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020\u0017H\u0016J\u0010\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020\u0017H\u0016J\u0010\u0010I\u001a\u00020/2\u0006\u0010K\u001a\u00020\u001eH\u0016J\u0010\u0010L\u001a\u00020/2\u0006\u0010M\u001a\u00020\u001eH\u0016J\u0010\u0010N\u001a\u00020/2\u0006\u0010M\u001a\u00020\u001eH\u0016J\u000e\u0010O\u001a\u00020\r2\u0006\u0010M\u001a\u00020\u001eJ\u0006\u0010P\u001a\u00020\rJ\b\u0010\u001f\u001a\u00020\nH\u0016J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020#J\b\u0010Q\u001a\u00020\u0004H\u0016J\b\u0010R\u001a\u00020/H\u0002J\u0010\u0010S\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u0017H\u0016J\u0010\u0010S\u001a\u00020\r2\u0006\u0010K\u001a\u00020\u001eH\u0016J\u0018\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020#H\u0002J\u0006\u0010'\u001a\u00020#J\u0006\u0010V\u001a\u00020/J\r\u0010W\u001a\u00020\rH\u0000¢\u0006\u0002\bXJ\r\u0010Y\u001a\u00020/H\u0000¢\u0006\u0002\bZR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "originalRequest", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "random", "Ljava/util/Random;", "pingIntervalMillis", "", "(Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;J)V", "awaitingPong", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "cancelFuture", "Ljava/util/concurrent/ScheduledFuture;", "enqueuedClose", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "failed", "key", "", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "messageAndCloseQueue", "Ljava/util/ArrayDeque;", "", "pongQueue", "Lokio/ByteString;", "queueSize", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseCode", "", "receivedCloseReason", "receivedPingCount", "receivedPongCount", "sentPingCount", "streams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "writerRunnable", "Ljava/lang/Runnable;", "awaitTermination", "", LocationMonitorConst.TIMEOUT, "timeUnit", "Ljava/util/concurrent/TimeUnit;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "checkUpgradeSuccess", ChatMessage.TYPE_RESPONSE, "Lokhttp3/Response;", "exchange", "Lokhttp3/internal/connection/Exchange;", "checkUpgradeSuccess$okhttp", IslandSession.REOPEN_VALUE_CLOSE, "code", InfoRequestQPSOptTraceLogger.REASON, "cancelAfterCloseMillis", "connect", "client", "Lokhttp3/OkHttpClient;", "failWebSocket", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "initReaderAndWriter", ActivityLifecycle.NAME, "loopReader", "onReadClose", "onReadMessage", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "bytes", "onReadPing", "payload", "onReadPong", "pong", "processNextFrame", Ext.KEY_REQUEST, "runWriter", "send", "data", "formatOpcode", "tearDown", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", "CancelRunnable", "Close", "Companion", "Message", "PingRunnable", "Streams", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final Companion Companion = null;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = null;
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$CancelRunnable;", "Ljava/lang/Runnable;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "run", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public final class CancelRunnable implements Runnable {
        final /* synthetic */ RealWebSocket this$0;

        public CancelRunnable(RealWebSocket r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.cancel();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "code", "", InfoRequestQPSOptTraceLogger.REASON, "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int r1, ByteString r2, long r3) {
            this.code = r1;
            this.reason = r2;
            this.cancelAfterCloseMillis = r3;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Companion;", "", "()V", "CANCEL_AFTER_CLOSE_MILLIS", "", "MAX_QUEUE_SIZE", "ONLY_HTTP1", "", "Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int r2, ByteString r3) {
            Intrinsics.checkParameterIsNotNull(r3, "data");
            this.formatOpcode = r2;
            this.data = r3;
        }

        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$PingRunnable;", "Ljava/lang/Runnable;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "run", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    private final class PingRunnable implements Runnable {
        final /* synthetic */ RealWebSocket this$0;

        public PingRunnable(RealWebSocket r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.writePingFrame$okhttp();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "client", "", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final BufferedSink sink;
        private final BufferedSource source;

        public Streams(boolean r3, BufferedSource r4, BufferedSink r5) {
            BufferedSource r6 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r4, BufferedSource.class, "com.obric.memorydata.plugin");
            BufferedSink r7 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r5, BufferedSink.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r6, AILabCheckPermissionTask.KEY_SOURCE);
            Intrinsics.checkParameterIsNotNull(r7, "sink");
            this.client = r3;
            this.source = r6;
            this.sink = r7;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final BufferedSink getSink() {
            return this.sink;
        }

        public final BufferedSource getSource() {
            return this.source;
        }
    }

    static {
        Companion = new Companion(null);
        ONLY_HTTP1 = CollectionsKt.listOf(Protocol.HTTP_1_1);
    }

    public RealWebSocket(Request r7, WebSocketListener r8, Random r9, long r10) {
        Intrinsics.checkParameterIsNotNull(r7, "originalRequest");
        Intrinsics.checkParameterIsNotNull(r8, "listener");
        Intrinsics.checkParameterIsNotNull(r9, "random");
        this.originalRequest = r7;
        this.listener = r8;
        this.random = r9;
        this.pingIntervalMillis = r10;
        this.pongQueue = new ArrayDeque();
        this.messageAndCloseQueue = new ArrayDeque();
        this.receivedCloseCode = -1;
        if (Intrinsics.areEqual(HttpMethodContrants.GET, r7.method()) == false) goto L7;
        ByteString.Companion r0 = ByteString.Companion;
        byte[] r1 = new byte[16];
        r9.nextBytes(r1);
        this.key = ByteString.Companion.of$default(r0, r1, 0, 0, 3, null).base64();
        this.writerRunnable = (Runnable) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this), Runnable.class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("Request must be GET: " + r7.method()).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void runWriter() {
        Thread.holdsLock(this);
        ScheduledExecutorService r0 = this.executor;
        if (r0 == null) goto L6;
        r0.execute(this.writerRunnable);
        return;
    }

    private final synchronized boolean send(ByteString r7, int r8) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L6;
    L17:
        monitor-exit(this);
        return false;
    L6:
        if (this.enqueuedClose == true) goto L17;
        if ((this.queueSize + ((long) r7.size())) <= MAX_QUEUE_SIZE) goto L13;
        close(1001, null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L13:
        this.queueSize += (long) r7.size();     // Catch: Throwable -> L19
        this.messageAndCloseQueue.add(new Message(r8, r7));     // Catch: Throwable -> L19
        runWriter();     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    }

    public final void awaitTermination(int r3, TimeUnit r4) {
        Intrinsics.checkParameterIsNotNull(r4, "timeUnit");
        ScheduledExecutorService r2 = this.executor;
        if (r2 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r2.awaitTermination(r3, r4);
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call r0 = this.call;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r0.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(Response r9, Exchange r10) {
        Intrinsics.checkParameterIsNotNull(r9, ChatMessage.TYPE_RESPONSE);
        if (r9.code() != 101) goto L21;
        String r0 = Response.header$default(r9, "Connection", null, 2, null);
        if (StringsKt.equals("Upgrade", r0, true) == false) goto L19;
        String r1 = Response.header$default(r9, "Upgrade", null, 2, null);
        if (StringsKt.equals("websocket", r1, true) == false) goto L17;
        String r11 = Response.header$default(r9, "Sec-WebSocket-Accept", null, 2, null);
        String r8 = ByteString.Companion.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
        if ((!Intrinsics.areEqual(r8, r11)) == true) goto L15;
        if (r10 == null) goto L13;
        return;
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Web Socket exchange missing: bad interceptor?"), Throwable.class, "com.obric.memorydata.plugin"));
    L15:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r8 + "' but was '" + r11 + '\''), Throwable.class, "com.obric.memorydata.plugin"));
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + r1 + '\''), Throwable.class, "com.obric.memorydata.plugin"));
    L19:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + r0 + '\''), Throwable.class, "com.obric.memorydata.plugin"));
    L21:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Expected HTTP 101 response but was '" + r9.code() + ' ' + r9.message() + '\''), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okhttp3.WebSocket
    public boolean close(int r3, String r4) {
        return close(r3, r4, 60000);
    }

    public final synchronized boolean close(int r8, String r9, long r10) {
        monitor-enter(this);
        WebSocketProtocol.INSTANCE.validateCloseCode(r8);     // Catch: Throwable -> L23
        ByteString r0 = (ByteString) ZeusTransformUtils.preCheckCast(null, ByteString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r9 == null) goto L14;
        r0 = ByteString.Companion.encodeUtf8(r9);     // Catch: Throwable -> L23
        if (r0.size() > 123) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L14;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("reason.size() > 123: " + r9).toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
    L8:
        r3 = false;
    L14:
        if (this.failed == false) goto L16;
    L21:
        monitor-exit(this);
        return false;
    L16:
        if (this.enqueuedClose == true) goto L21;
        this.enqueuedClose = true;     // Catch: Throwable -> L23
        this.messageAndCloseQueue.add(new Close(r8, r0, r10));     // Catch: Throwable -> L23
        runWriter();     // Catch: Throwable -> L23
        monitor-exit(this);
        return true;
    L23:
        th = move-exception;
        throw th;
    }

    public final void connect(OkHttpClient r4) {
        Intrinsics.checkParameterIsNotNull(r4, "client");
        OkHttpClient r5 = r4.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request r0 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        Call r6 = (Call) ZeusTransformUtils.preCheckCast(RealCall.Companion.newRealCall(r5, r0, true), Call.class, "com.obric.memorydata.plugin");
        this.call = r6;
        if (r6 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r6.enqueue((Callback) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r0), Callback.class, "com.obric.memorydata.plugin"));
    }

    public final void failWebSocket(Exception r5, Response r6) {
        Intrinsics.checkParameterIsNotNull(r5, "e");
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.failed == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.failed = true;     // Catch: Throwable -> L24
        Streams r0 = this.streams;     // Catch: Throwable -> L24
        this.streams = (Streams) ZeusTransformUtils.preCheckCast(null, Streams.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        ScheduledFuture<?> r1 = this.cancelFuture;     // Catch: Throwable -> L24
        if (r1 == null) goto L12;
        r1.cancel(false);     // Catch: Throwable -> L24
    L12:
        ScheduledExecutorService r2 = this.executor;     // Catch: Throwable -> L24
        if (r2 == null) goto L15;
        r2.shutdown();     // Catch: Throwable -> L24
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L15:
        monitor-exit(this);
        this.listener.onFailure((WebSocket) ZeusTransformUtils.preCheckCast(this, WebSocket.class, "com.obric.memorydata.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.memorydata.plugin"), r6);     // Catch: Throwable -> L20
        if (r0 == null) goto L31;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin"));
        return;
    L31:
        return;
    L20:
        th = move-exception;
        if (r0 == null) goto L23;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin"));
    L23:
        throw th;
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(String r10, Streams r11) {
        Intrinsics.checkParameterIsNotNull(r10, ActivityLifecycle.NAME);
        Intrinsics.checkParameterIsNotNull(r11, "streams");
        monitor-enter(this);
        this.streams = r11;     // Catch: Throwable -> L16
        this.writer = new WebSocketWriter(r11.getClient(), r11.getSink(), this.random);     // Catch: Throwable -> L16
        ScheduledExecutorService r2 = (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(new ScheduledThreadPoolExecutor(1, Util.threadFactory(r10, false)), ScheduledExecutorService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        this.executor = r2;     // Catch: Throwable -> L16
        if (this.pingIntervalMillis == 0) goto L10;
        if (r2 != null) goto L8;
        Intrinsics.throwNpe();     // Catch: Throwable -> L16
    L8:
        Runnable r3 = (Runnable) ZeusTransformUtils.preCheckCast(new PingRunnable(this), Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        long r6 = this.pingIntervalMillis;     // Catch: Throwable -> L16
        r2.scheduleAtFixedRate(r3, r6, r6, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L16
    L10:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.messageAndCloseQueue, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L12;
        runWriter();     // Catch: Throwable -> L16
    L12:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        this.reader = new WebSocketReader(r11.getClient(), r11.getSource(), (WebSocketReader.FrameCallback) ZeusTransformUtils.preCheckCast(this, WebSocketReader.FrameCallback.class, "com.obric.memorydata.plugin"));
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void loopReader() {
    L3:
        if (this.receivedCloseCode != (-1)) goto L8;
        WebSocketReader r0 = this.reader;
        if (r0 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r0.processNextFrame();
        goto L3
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int r7, String r8) {
        Intrinsics.checkParameterIsNotNull(r8, InfoRequestQPSOptTraceLogger.REASON);
        boolean r0 = true;
        if (r7 == (-1)) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L45;
        Streams r4 = (Streams) ZeusTransformUtils.preCheckCast(null, Streams.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
    L41:
        th = move-exception;
        throw th;
    L10:
        if (this.receivedCloseCode == (-1)) goto L13;
        r0 = false;
    L13:
        if (r0 == false) goto L40;
        this.receivedCloseCode = r7;     // Catch: Throwable -> L41
        this.receivedCloseReason = r8;     // Catch: Throwable -> L41
        if (this.enqueuedClose == true) goto L17;
    L27:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(this);
        this.listener.onClosing((WebSocket) ZeusTransformUtils.preCheckCast(this, WebSocket.class, "com.obric.memorydata.plugin"), r7, r8);     // Catch: Throwable -> L35
        if (r4 == null) goto L32;
        this.listener.onClosed((WebSocket) ZeusTransformUtils.preCheckCast(this, WebSocket.class, "com.obric.memorydata.plugin"), r7, r8);     // Catch: Throwable -> L35
    L32:
        if (r4 == null) goto L49;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.memorydata.plugin"));
        return;
    L49:
        return;
    L35:
        th = move-exception;
        if (r4 == null) goto L38;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.memorydata.plugin"));
    L38:
        throw th;
    L17:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L27;
        r4 = this.streams;     // Catch: Throwable -> L41
        this.streams = (Streams) ZeusTransformUtils.preCheckCast(null, Streams.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        ScheduledFuture<?> r2 = this.cancelFuture;     // Catch: Throwable -> L41
        if (r2 == null) goto L23;
        if (r2 != null) goto L22;
        Intrinsics.throwNpe();     // Catch: Throwable -> L41
    L22:
        r2.cancel(false);     // Catch: Throwable -> L41
    L23:
        ScheduledExecutorService r5 = this.executor;     // Catch: Throwable -> L41
        if (r5 != null) goto L26;
        Intrinsics.throwNpe();     // Catch: Throwable -> L41
    L26:
        r5.shutdown();     // Catch: Throwable -> L41
        goto L27
    L40:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("already closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
    L45:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r3 = false;
        goto L6
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String r4) {
        Intrinsics.checkParameterIsNotNull(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.listener.onMessage((WebSocket) ZeusTransformUtils.preCheckCast(this, WebSocket.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString r4) {
        Intrinsics.checkParameterIsNotNull(r4, "bytes");
        this.listener.onMessage((WebSocket) ZeusTransformUtils.preCheckCast(this, WebSocket.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString r2) {
        monitor-enter(this);
        Intrinsics.checkParameterIsNotNull(r2, "payload");     // Catch: Throwable -> L15
        if (this.failed == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.enqueuedClose == true) goto L8;
    L10:
        this.pongQueue.add(r2);     // Catch: Throwable -> L15
        runWriter();     // Catch: Throwable -> L15
        this.receivedPingCount++;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L8:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L10;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString r2) {
        monitor-enter(this);
        Intrinsics.checkParameterIsNotNull(r2, "payload");     // Catch: Throwable -> L6
        this.receivedPongCount++;     // Catch: Throwable -> L6
        this.awaitingPong = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean pong(ByteString r2) {
        monitor-enter(this);
        Intrinsics.checkParameterIsNotNull(r2, "payload");     // Catch: Throwable -> L15
        if (this.failed == false) goto L6;
    L14:
        boolean r3 = false;
    L12:
        monitor-exit(this);
        return r3;
    L6:
        if (this.enqueuedClose == true) goto L8;
    L10:
        this.pongQueue.add(r2);     // Catch: Throwable -> L15
        runWriter();     // Catch: Throwable -> L15
        r3 = true;
        goto L12
    L8:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L10;
    L15:
        th = move-exception;
        throw th;
    }

    public final boolean processNextFrame() {
        WebSocketReader r1 = this.reader;     // Catch: Exception -> L10
        if (r1 != null) goto L6;
        Intrinsics.throwNpe();     // Catch: Exception -> L10
    L6:
        r1.processNextFrame();     // Catch: Exception -> L10
        if (this.receivedCloseCode == (-1)) goto L16;
        return false;
    L16:
        return true;
    L10:
        e = move-exception;
        failWebSocket(e, null);
        return false;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        monitor-enter(this);
        long r0 = this.queueSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int receivedPingCount() {
        monitor-enter(this);
        int r0 = this.receivedPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int receivedPongCount() {
        monitor-enter(this);
        int r0 = this.receivedPongCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return send(ByteString.Companion.encodeUtf8(r2), 1);
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "bytes");
        return send(r2, 2);
    }

    public final synchronized int sentPingCount() {
        monitor-enter(this);
        int r0 = this.sentPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void tearDown() {
        ScheduledFuture<?> r0 = this.cancelFuture;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        r0.cancel(false);
    L7:
        ScheduledExecutorService r1 = this.executor;
        if (r1 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        r1.shutdown();
        ScheduledExecutorService r3 = this.executor;
        if (r3 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        r3.awaitTermination(10, TimeUnit.SECONDS);
    }

    public final boolean writeOneFrame$okhttp() {
        Object r2 = null;
        String r0 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
        Streams r1 = (Streams) ZeusTransformUtils.preCheckCast(null, Streams.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
    L69:
        th = move-exception;
        throw th;
    L6:
        if (this.failed == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        WebSocketWriter r3 = this.writer;     // Catch: Throwable -> L69
        ByteString r5 = (ByteString) ZeusTransformUtils.preCheckCast(this.pongQueue.poll(), ByteString.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
        int r6 = -1;
        if (r5 != null) goto L29;
        Object r7 = this.messageAndCloseQueue.poll();     // Catch: Throwable -> L69
        if (ZeusTransformUtils.instanceOf(r7, Close.class) == false) goto L25;
        int r4 = this.receivedCloseCode;     // Catch: Throwable -> L69
        String r8 = this.receivedCloseReason;     // Catch: Throwable -> L69
        if (r4 == (-1)) goto L20;
        r1 = this.streams;     // Catch: Throwable -> L69
        this.streams = (Streams) ZeusTransformUtils.preCheckCast(null, Streams.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
        ScheduledExecutorService r9 = this.executor;     // Catch: Throwable -> L69
        if (r9 != null) goto L18;
        Intrinsics.throwNpe();     // Catch: Throwable -> L69
    L18:
        r9.shutdown();     // Catch: Throwable -> L69
    L19:
        r6 = r4;
        r0 = r8;
    L28:
        r2 = r7;
        goto L29
    L20:
        ScheduledExecutorService r10 = this.executor;     // Catch: Throwable -> L69
        if (r10 != null) goto L23;
        Intrinsics.throwNpe();     // Catch: Throwable -> L69
    L23:
        this.cancelFuture = r10.schedule((Runnable) ZeusTransformUtils.preCheckCast(new CancelRunnable(this), Runnable.class, "com.obric.memorydata.plugin"), ((Close) ZeusTransformUtils.preCheckCast(r7, Close.class, "com.obric.memorydata.plugin")).getCancelAfterCloseMillis(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L69
        goto L19
    L25:
        if (r7 != null) goto L28;
        monitor-exit(this);
        return false;
    L29:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L69
        monitor-exit(this);
        if (r5 == null) goto L36;
        if (r3 != null) goto L34;
        Intrinsics.throwNpe();     // Catch: Throwable -> L65
    L34:
        r3.writePong(r5);     // Catch: Throwable -> L65
    L60:
        if (r1 == null) goto L62;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.memorydata.plugin"));
    L62:
        return true;
    L36:
        if (ZeusTransformUtils.instanceOf(r2, Message.class) == false) goto L49;
        ByteString r12 = ((Message) ZeusTransformUtils.preCheckCast(r2, Message.class, "com.obric.memorydata.plugin")).getData();     // Catch: Throwable -> L65
        if (r3 != null) goto L40;
        Intrinsics.throwNpe();     // Catch: Throwable -> L65
    L40:
        BufferedSink r13 = Okio.buffer(r3.newMessageSink(((Message) ZeusTransformUtils.preCheckCast(r2, Message.class, "com.obric.memorydata.plugin")).getFormatOpcode(), r12.size()));     // Catch: Throwable -> L65
        r13.write(r12);     // Catch: Throwable -> L65
        r13.close();     // Catch: Throwable -> L65
        monitor-enter(this);     // Catch: Throwable -> L65
        this.queueSize -= (long) r12.size();     // Catch: Throwable -> L45
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(this);     // Catch: Throwable -> L65
        goto L60
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L65
    L49:
        if (ZeusTransformUtils.instanceOf(r2, Close.class) == false) goto L64;
        Close r15 = (Close) ZeusTransformUtils.preCheckCast(r2, Close.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L65
        if (r3 != null) goto L53;
        Intrinsics.throwNpe();     // Catch: Throwable -> L65
    L53:
        r3.writeClose(r15.getCode(), r15.getReason());     // Catch: Throwable -> L65
        if (r1 == null) goto L60;
        WebSocketListener r16 = this.listener;     // Catch: Throwable -> L65
        WebSocket r17 = (WebSocket) ZeusTransformUtils.preCheckCast(this, WebSocket.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L65
        if (r0 != null) goto L58;
        Intrinsics.throwNpe();     // Catch: Throwable -> L65
    L58:
        r16.onClosed(r17, r6, r0);     // Catch: Throwable -> L65
        goto L60
    L64:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError(), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        if (r1 == null) goto L68;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.memorydata.plugin"));
    L68:
        throw th;
    }

    public final void writePingFrame$okhttp() {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        WebSocketWriter r0 = this.writer;     // Catch: Throwable -> L24
        if (this.awaitingPong == false) goto L10;
        int r1 = this.sentPingCount;     // Catch: Throwable -> L24
    L11:
        this.sentPingCount++;     // Catch: Throwable -> L24
        this.awaitingPong = true;     // Catch: Throwable -> L24
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(this);
        if (r1 == (-1)) goto L17;
        failWebSocket((Exception) ZeusTransformUtils.preCheckCast(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (r1 - 1) + " successful ping/pongs)"), Exception.class, "com.obric.memorydata.plugin"), null);
        return;
    L17:
        if (r0 == null) goto L29;
    L19:
        r0.writePing(ByteString.EMPTY);     // Catch: IOException -> L21
        return;
    L21:
        e = move-exception;
        failWebSocket((Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin"), null);
        return;
    L29:
        Intrinsics.throwNpe();     // Catch: IOException -> L21
        goto L19
    L10:
        r1 = -1;
        goto L11
    }
}
