package okhttp3.internal.ws;

import ai.j0;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.event.MessageIndication;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import nu.k;
import nu.l;
import nu.m;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.l0;
import okhttp3.n0;
import okhttp3.s0;
import okhttp3.u;
import okhttp3.w;
import okhttp3.z0;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 \u0081\u00012\u00020\u00012\u00020\u0002:\n\u0082\u0001\u0081\u0001\u0083\u0001\u0084\u0001\u0085\u0001BA\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010#\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0004\b!\u0010\"J\u001d\u0010(\u001a\u00020\u00162\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0016¢\u0006\u0004\b*\u0010\u0018J\r\u0010,\u001a\u00020+¢\u0006\u0004\b,\u0010-J\u001d\u00101\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0016¢\u0006\u0004\b3\u0010\u0018J\r\u00105\u001a\u000204¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u000204¢\u0006\u0004\b7\u00106J\r\u00108\u001a\u000204¢\u0006\u0004\b8\u00106J\u0017\u0010:\u001a\u00020\u00162\u0006\u00109\u001a\u00020$H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010:\u001a\u00020\u00162\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b:\u0010>J\u0017\u0010@\u001a\u00020\u00162\u0006\u0010?\u001a\u00020<H\u0016¢\u0006\u0004\b@\u0010>J\u0017\u0010A\u001a\u00020\u00162\u0006\u0010?\u001a\u00020<H\u0016¢\u0006\u0004\bA\u0010>J\u001f\u0010D\u001a\u00020\u00162\u0006\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020$H\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020+2\u0006\u00109\u001a\u00020$H\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010F\u001a\u00020+2\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\bF\u0010HJ\u0015\u0010I\u001a\u00020+2\u0006\u0010?\u001a\u00020<¢\u0006\u0004\bI\u0010HJ!\u0010J\u001a\u00020+2\u0006\u0010B\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\bJ\u0010KJ'\u0010J\u001a\u00020+2\u0006\u0010B\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010$2\u0006\u0010L\u001a\u00020\u000b¢\u0006\u0004\bJ\u0010MJ\u000f\u0010O\u001a\u00020+H\u0000¢\u0006\u0004\bN\u0010-J\u000f\u0010Q\u001a\u00020\u0016H\u0000¢\u0006\u0004\bP\u0010\u0018J#\u0010U\u001a\u00020\u00162\n\u0010T\u001a\u00060Rj\u0002`S2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\bU\u0010VJ\u0013\u0010W\u001a\u00020+*\u00020\rH\u0002¢\u0006\u0004\bW\u0010XJ\u001f\u0010F\u001a\u00020+2\u0006\u0010Y\u001a\u00020<2\u0006\u0010Z\u001a\u000204H\u0002¢\u0006\u0004\bF\u0010[J\u000f\u0010\\\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\\\u0010\u0018R\u0014\u0010]\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010`\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010c\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010l\u001a\u00020k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010^R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010nR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020<0o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00010o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010qR\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010sR\u0016\u0010t\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010v\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010x\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010^R\u0016\u0010y\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010uR\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010wR\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010wR\u0016\u00108\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010wR\u0016\u0010z\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010uR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010{R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010|\u001a\u0004\b}\u0010~R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u007fR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010sR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u000e\u0010\u0080\u0001R\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010s¨\u0006\u0086\u0001"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lokhttp3/Request;", "originalRequest", "Lokhttp3/z0;", "listener", "Ljava/util/Random;", "random", "", "pingIntervalMillis", "Lokhttp3/internal/ws/WebSocketExtensions;", "extensions", "minimumDeflateSize", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/z0;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "request", "()Lokhttp3/Request;", "queueSize", "()J", "", "cancel", "()V", "Lokhttp3/OkHttpClient;", "client", "connect", "(Lokhttp3/OkHttpClient;)V", "Lokhttp3/s0;", "response", "Lokhttp3/internal/connection/Exchange;", "exchange", "checkUpgradeSuccess$okhttp", "(Lokhttp3/s0;Lokhttp3/internal/connection/Exchange;)V", "checkUpgradeSuccess", "", "name", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "streams", "initReaderAndWriter", "(Ljava/lang/String;Lokhttp3/internal/ws/RealWebSocket$Streams;)V", "loopReader", "", "processNextFrame", "()Z", "timeout", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "awaitTermination", "(JLjava/util/concurrent/TimeUnit;)V", "tearDown", "", "sentPingCount", "()I", "receivedPingCount", "receivedPongCount", MessageIndication.CONTENT_TYPE_TEXT, "onReadMessage", "(Ljava/lang/String;)V", "Lokio/ByteString;", "bytes", "(Lokio/ByteString;)V", "payload", "onReadPing", "onReadPong", "code", "reason", "onReadClose", "(ILjava/lang/String;)V", "send", "(Ljava/lang/String;)Z", "(Lokio/ByteString;)Z", "pong", "close", "(ILjava/lang/String;)Z", "cancelAfterCloseMillis", "(ILjava/lang/String;J)Z", "writeOneFrame$okhttp", "writeOneFrame", "writePingFrame$okhttp", "writePingFrame", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "failWebSocket", "(Ljava/lang/Exception;Lokhttp3/s0;)V", "isValid", "(Lokhttp3/internal/ws/WebSocketExtensions;)Z", "data", "formatOpcode", "(Lokio/ByteString;I)Z", "runWriter", STGroup.DICT_KEY, "Ljava/lang/String;", "Lokhttp3/Call;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "Lokhttp3/internal/concurrent/Task;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "Lokhttp3/internal/ws/WebSocketReader;", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "Lokhttp3/internal/ws/WebSocketWriter;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "Lokhttp3/internal/concurrent/TaskQueue;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/util/ArrayDeque;", "pongQueue", "Ljava/util/ArrayDeque;", "messageAndCloseQueue", "J", "enqueuedClose", "Z", "receivedCloseCode", "I", "receivedCloseReason", MessageIndication.STATUS_FAILED, "awaitingPong", "Lokhttp3/Request;", "Lokhttp3/z0;", "getListener$okhttp", "()Lokhttp3/z0;", "Ljava/util/Random;", "Lokhttp3/internal/ws/WebSocketExtensions;", "Companion", "Close", "Message", "Streams", "WriterTask", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealWebSocket implements WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final Companion Companion = null;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = null;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final z0 listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;
    private String name;
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
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "code", "", "reason", "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int r5, ByteString r10, long r11) {
            this.code = r5;
            this.reason = r10;
            this.cancelAfterCloseMillis = r11;
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Companion;", "", "()V", "CANCEL_AFTER_CLOSE_MILLIS", "", "DEFAULT_MINIMUM_DEFLATE_SIZE", "MAX_QUEUE_SIZE", "ONLY_HTTP1", "", "Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int r5, ByteString r10) {
            Intrinsics.checkNotNullParameter(r10, "data");
            this.formatOpcode = r5;
            this.data = r10;
        }

        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "", "client", "Lnu/l;", "source", "Lnu/k;", "sink", "<init>", "(ZLnu/l;Lnu/k;)V", "Z", "getClient", "()Z", "Lnu/l;", "getSource", "()Lnu/l;", "Lnu/k;", "getSink", "()Lnu/k;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final k sink;
        private final l source;

        public Streams(boolean r5, l r10, k r11) {
            Intrinsics.checkNotNullParameter(r10, "source");
            Intrinsics.checkNotNullParameter(r11, "sink");
            this.client = r5;
            this.source = r10;
            this.sink = r11;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final k getSink() {
            return this.sink;
        }

        public final l getSource() {
            return this.source;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class WriterTask extends Task {
        final /* synthetic */ RealWebSocket this$0;

        public WriterTask(RealWebSocket r5) {
            this.this$0 = r5;
            super(RealWebSocket.access$getName$p(r5) + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            if (this.this$0.writeOneFrame$okhttp() == false) goto L12;
            return 0;
        L12:
            return -1;
        L6:
            e = move-exception;
            this.this$0.failWebSocket(e, null);
            return -1;
        }
    }

    static {
        Companion = new Companion(null);
        ONLY_HTTP1 = CollectionsKt.listOf(Protocol.HTTP_1_1);
    }

    public RealWebSocket(TaskRunner r5, Request r10, z0 r11, Random r12, long r13, WebSocketExtensions r14, long r15) {
        Intrinsics.checkNotNullParameter(r5, "taskRunner");
        Intrinsics.checkNotNullParameter(r10, "originalRequest");
        Intrinsics.checkNotNullParameter(r11, "listener");
        Intrinsics.checkNotNullParameter(r12, "random");
        this.originalRequest = r10;
        this.random = r12;
        this.pingIntervalMillis = r13;
        this.extensions = r14;
        this.minimumDeflateSize = r15;
        this.taskQueue = r5.newQueue();
        this.pongQueue = new ArrayDeque();
        this.messageAndCloseQueue = new ArrayDeque();
        this.receivedCloseCode = -1;
        if (Intrinsics.areEqual("GET", r10.method()) == false) goto L7;
        m r16 = ByteString.Companion;
        byte[] r17 = new byte[16];
        r12.nextBytes(r17);
        Unit r18 = Unit.INSTANCE;
        this.key = m.d(r16, r17).base64();
        return;
    L7:
        throw new IllegalArgumentException(("Request must be GET: " + r10.method()).toString());
    }

    public static final /* synthetic */ WebSocketExtensions access$getExtensions$p(RealWebSocket r5) {
        return r5.extensions;
    }

    public static final /* synthetic */ ArrayDeque access$getMessageAndCloseQueue$p(RealWebSocket r5) {
        return r5.messageAndCloseQueue;
    }

    public static final /* synthetic */ String access$getName$p(RealWebSocket r5) {
        return r5.name;
    }

    public static final /* synthetic */ boolean access$isValid(RealWebSocket r5, WebSocketExtensions r10) {
        return r5.isValid(r10);
    }

    public static final /* synthetic */ void access$setExtensions$p(RealWebSocket r5, WebSocketExtensions r10) {
        r5.extensions = r10;
    }

    public static final /* synthetic */ void access$setName$p(RealWebSocket r5, String r10) {
        r5.name = r10;
    }

    private final boolean isValid(WebSocketExtensions r5) {
        if (r5.unknownValues == false) goto L6;
        return false;
    L6:
        if (r5.clientMaxWindowBits == null) goto L8;
        return false;
    L8:
        Integer r10 = r5.serverMaxWindowBits;
        if (r10 == null) goto L15;
        int r11 = r10.intValue();
        if (8 <= r11) goto L13;
    L14:
        return false;
    L13:
        if (15 < r11) goto L14;
        return true;
    L15:
        return true;
    }

    private final void runWriter() {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        Task r5 = this.writerTask;
        if (r5 == null) goto L13;
        TaskQueue.schedule$default(this.taskQueue, r5, 0, 2, null);
        return;
    L13:
        return;
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final void awaitTermination(long r5, TimeUnit r10) throws InterruptedException {
        Intrinsics.checkNotNullParameter(r10, "timeUnit");
        this.taskQueue.idleLatch().await(r5, r10);
    }

    public void cancel() {
        Call r5 = this.call;
        Intrinsics.checkNotNull(r5);
        r5.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(s0 r10, Exchange r11) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "response");
        if (r10.e != 101) goto L20;
        String r5 = r10.d("Connection", null);
        if (StringsKt.l(Constant.UPDATE_PATH, r5) == false) goto L19;
        String r12 = r10.d(Constant.UPDATE_PATH, null);
        if (StringsKt.l("websocket", r12) == false) goto L17;
        String r13 = r10.d("Sec-WebSocket-Accept", null);
        m r14 = ByteString.Companion;
        String r15 = this.key + WebSocketProtocol.ACCEPT_MAGIC;
        r14.getClass();
        String r16 = m.c(r15).sha1().base64();
        if (Intrinsics.areEqual(r16, r13) == false) goto L15;
        if (r11 == null) goto L13;
        return;
    L13:
        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
    L15:
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r16 + "' but was '" + r13 + '\'');
    L17:
        throw new ProtocolException(a.p("Expected 'Upgrade' header value 'websocket' but was '", '\'', r12));
    L19:
        throw new ProtocolException(a.p("Expected 'Connection' header value 'Upgrade' but was '", '\'', r5));
    L20:
        StringBuilder r17 = new StringBuilder("Expected HTTP 101 response but was '");
        r17.append(r10.e);
        r17.append(' ');
        throw new ProtocolException(j0.p(r17, r10.d, '\''));
    }

    public boolean close(int r5, String r10) {
        return close(r5, r10, CANCEL_AFTER_CLOSE_MILLIS);
    }

    public final void connect(OkHttpClient r5) {
        Intrinsics.checkNotNullParameter(r5, "client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") == null) goto L6;
        failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
        return;
    L6:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r5, "okHttpClient");
        l0 r10 = new l0();
        r10.f20676a = r5.f20587a;
        r10.f20677b = r5.f20588b;
        CollectionsKt.a(r10.f20678c, r5.f20589c);
        CollectionsKt.a(r10.d, r5.d);
        r10.e = r5.e;
        r10.f = r5.f;
        r10.g = r5.g;
        r10.f20679h = r5.f20590h;
        r10.f20680i = r5.f20591i;
        r10.f20681j = r5.f20592j;
        r10.f20682k = r5.f20593k;
        r10.f20683l = r5.f20594l;
        r10.f20684m = r5.f20595m;
        r10.f20685n = r5.f20596n;
        r10.f20686o = r5.f20597o;
        r10.f20687p = r5.f20598p;
        r10.f20688q = r5.f20599q;
        r10.f20689r = r5.f20600r;
        r10.s = r5.s;
        r10.f20690t = r5.f20601t;
        r10.f20691u = r5.f20602u;
        r10.f20692v = r5.f20603v;
        r10.f20693w = r5.f20604w;
        r10.f20694x = r5.f20605x;
        r10.f20695y = r5.f20606y;
        r10.f20696z = r5.f20607z;
        r10.A = r5.A;
        r10.B = r5.B;
        u r11 = w.f20761a;
        Intrinsics.checkNotNullParameter(r11, "eventListener");
        r10.e = Util.asFactory(r11);
        r10.b(ONLY_HTTP1);
        OkHttpClient r12 = new OkHttpClient(r10);
        n0 r13 = this.originalRequest.newBuilder();
        r13.c(Constant.UPDATE_PATH, "websocket");
        r13.c("Connection", Constant.UPDATE_PATH);
        r13.c("Sec-WebSocket-Key", this.key);
        r13.c("Sec-WebSocket-Version", "13");
        r13.c("Sec-WebSocket-Extensions", "permessage-deflate");
        final Request r14 = r13.b();
        RealCall r15 = new RealCall(r12, r14, true);
        this.call = r15;
        Intrinsics.checkNotNull(r15);
        r15.enqueue(new AnonymousClass1(this, r14));
    }

    public final void failWebSocket(Exception r5, s0 r10) {
        Intrinsics.checkNotNullParameter(r5, "e");
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.failed == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.failed = true;     // Catch: Throwable -> L20
        Streams r11 = this.streams;     // Catch: Throwable -> L20
        this.streams = null;     // Catch: Throwable -> L20
        WebSocketReader r12 = this.reader;     // Catch: Throwable -> L20
        this.reader = null;     // Catch: Throwable -> L20
        WebSocketWriter r13 = this.writer;     // Catch: Throwable -> L20
        this.writer = null;     // Catch: Throwable -> L20
        this.taskQueue.shutdown();     // Catch: Throwable -> L20
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        throw null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (r11 == null) goto L15;
        Util.closeQuietly(r11);
    L15:
        if (r12 == null) goto L17;
        Util.closeQuietly(r12);
    L17:
        if (r13 == null) goto L19;
        Util.closeQuietly(r13);
    L19:
        throw th;
    }

    public final z0 getListener$okhttp() {
        return null;
    }

    public final void initReaderAndWriter(final String r17, final Streams r18) throws IOException {
        Intrinsics.checkNotNullParameter(r17, "name");
        Intrinsics.checkNotNullParameter(r18, "streams");
        final WebSocketExtensions r12 = this.extensions;
        Intrinsics.checkNotNull(r12);
        monitor-enter(this);
        this.name = r17;     // Catch: Throwable -> L7
        this.streams = r18;     // Catch: Throwable -> L7
        this.writer = new WebSocketWriter(r18.getClient(), r18.getSink(), this.random, r12.perMessageDeflate, r12.noContextTakeover(r18.getClient()), this.minimumDeflateSize);     // Catch: Throwable -> L7
        this.writerTask = new WriterTask(this);     // Catch: Throwable -> L7
        long r5 = this.pingIntervalMillis;     // Catch: Throwable -> L7
        if (r5 == 0) goto L10;
        final long r13 = TimeUnit.MILLISECONDS.toNanos(r5);     // Catch: Throwable -> L7
        final String r10 = r17 + " ping";     // Catch: Throwable -> L7
        this.taskQueue.schedule(new RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1(r10, r10, r13, this, r17, r18, r12), r13);     // Catch: Throwable -> L7
    L10:
        if (this.messageAndCloseQueue.isEmpty() == true) goto L12;
        runWriter();     // Catch: Throwable -> L7
    L12:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(this);
        this.reader = new WebSocketReader(r18.getClient(), r18.getSource(), this, r12.perMessageDeflate, r12.noContextTakeover(!r18.getClient()));
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void loopReader() throws IOException {
    L3:
        if (this.receivedCloseCode != (-1)) goto L5;
        WebSocketReader r5 = this.reader;
        Intrinsics.checkNotNull(r5);
        r5.processNextFrame();
        goto L3
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        boolean r11 = false;
        if (r5 == (-1)) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L36;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (this.receivedCloseCode != (-1)) goto L11;
        r11 = true;
    L11:
        if (r11 == false) goto L32;
        this.receivedCloseCode = r5;     // Catch: Throwable -> L17
        this.receivedCloseReason = r10;     // Catch: Throwable -> L17
        if (this.enqueuedClose == true) goto L15;
    L19:
        Streams r13 = null;
        WebSocketReader r14 = null;
        WebSocketWriter r15 = null;
    L20:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        throw null;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r13 == null) goto L26;
        Util.closeQuietly(r13);
    L26:
        if (r14 == null) goto L28;
        Util.closeQuietly(r14);
    L28:
        if (r15 == null) goto L30;
        Util.closeQuietly(r15);
    L30:
        throw th;
    L15:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L19;
        r13 = this.streams;     // Catch: Throwable -> L17
        this.streams = null;     // Catch: Throwable -> L17
        r14 = this.reader;     // Catch: Throwable -> L17
        this.reader = null;     // Catch: Throwable -> L17
        r15 = this.writer;     // Catch: Throwable -> L17
        this.writer = null;     // Catch: Throwable -> L17
        this.taskQueue.shutdown();     // Catch: Throwable -> L17
        goto L20
    L32:
        throw new IllegalStateException("already closed");     // Catch: Throwable -> L17
    L36:
        throw new IllegalArgumentException("Failed requirement.");
    L5:
        r12 = false;
        goto L6
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        throw null;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "payload");     // Catch: Throwable -> L10
        if (this.failed == false) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.enqueuedClose == true) goto L8;
    L12:
        this.pongQueue.add(r5);     // Catch: Throwable -> L10
        runWriter();     // Catch: Throwable -> L10
        this.receivedPingCount++;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L8:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L12;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "payload");     // Catch: Throwable -> L6
        this.receivedPongCount++;     // Catch: Throwable -> L6
        this.awaitingPong = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean pong(ByteString r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "payload");     // Catch: Throwable -> L10
        if (this.failed == false) goto L6;
    L16:
        monitor-exit(this);
        return false;
    L6:
        if (this.enqueuedClose == true) goto L8;
    L12:
        this.pongQueue.add(r5);     // Catch: Throwable -> L10
        runWriter();     // Catch: Throwable -> L10
        monitor-exit(this);
        return true;
    L8:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L12;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean processNextFrame() throws IOException {
        WebSocketReader r5 = this.reader;     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r5);     // Catch: Exception -> L7
        r5.processNextFrame();     // Catch: Exception -> L7
        if (this.receivedCloseCode != (-1)) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        failWebSocket(e, null);
        return false;
    }

    public synchronized long queueSize() {
        monitor-enter(this);
        long r5 = this.queueSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int receivedPingCount() {
        monitor-enter(this);
        int r5 = this.receivedPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int receivedPongCount() {
        monitor-enter(this);
        int r5 = this.receivedPongCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public Request request() {
        return this.originalRequest;
    }

    public boolean send(String r5) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        ByteString.Companion.getClass();
        return send(m.c(r5), 1);
    }

    public final synchronized int sentPingCount() {
        monitor-enter(this);
        int r5 = this.sentPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10, TimeUnit.SECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v26, types: [T, okhttp3.internal.ws.RealWebSocket$Streams] */
    /* JADX WARN: Type inference failed for: r1v27, types: [T, okhttp3.internal.ws.WebSocketReader] */
    /* JADX WARN: Type inference failed for: r1v28, types: [T, okhttp3.internal.ws.WebSocketWriter] */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v16, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r3v7 */
    public final boolean writeOneFrame$okhttp() throws IOException {
        final Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = null;
        final Ref.IntRef r10 = new Ref.IntRef();
        r10.element = -1;
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = null;
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = null;
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = null;
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = null;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        ?? r15 = 0;
        ?? r16 = 0;
        if (this.failed == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        final WebSocketWriter r17 = this.writer;     // Catch: Throwable -> L17
        ByteString r18 = this.pongQueue.poll();     // Catch: Throwable -> L17
        if (r18 != null) goto L16;
        ?? r19 = this.messageAndCloseQueue.poll();     // Catch: Throwable -> L17
        r5.element = r19;     // Catch: Throwable -> L17
        if ((r19 instanceof Close) == false) goto L24;
        int r20 = this.receivedCloseCode;     // Catch: Throwable -> L17
        r10.element = r20;     // Catch: Throwable -> L17
        ?? r21 = this.receivedCloseReason;     // Catch: Throwable -> L17
        r13.element = r21;     // Catch: Throwable -> L17
        if (r20 == (-1)) goto L19;
        r12.element = this.streams;     // Catch: Throwable -> L17
        this.streams = null;     // Catch: Throwable -> L17
        r11.element = this.reader;     // Catch: Throwable -> L17
        this.reader = null;     // Catch: Throwable -> L17
        r14.element = this.writer;     // Catch: Throwable -> L17
        this.writer = null;     // Catch: Throwable -> L17
        this.taskQueue.shutdown();     // Catch: Throwable -> L17
        r15 = r21;
        goto L16
    L19:
        Object r22 = r5.element;     // Catch: Throwable -> L17
        if (r22 == null) goto L23;
        long r23 = ((Close) r22).getCancelAfterCloseMillis();     // Catch: Throwable -> L17
        TaskQueue r24 = this.taskQueue;     // Catch: Throwable -> L17
        final String r25 = this.name + " cancel";     // Catch: Throwable -> L17
        final boolean r110 = true;
        final boolean r26 = true;
        final ByteString r111 = r18;
        final Ref.ObjectRef r27 = r14;
        final Ref.ObjectRef r28 = r11;
        r24.schedule(new RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1(r25, r26, r25, r110, this, r17, r111, r5, r10, r13, r12, r28, r27), TimeUnit.MILLISECONDS.toNanos(r23));     // Catch: Throwable -> L17
        r16 = r26;
    L28:
        Unit r29 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        ByteString r30 = r111;
        if (r30 == null) goto L36;
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L34
        r17.writePong(r30);     // Catch: Throwable -> L34
    L33:
        Ref.ObjectRef r31 = r12;
    L56:
        Streams r32 = (Streams) r31.element;
        if (r32 == null) goto L59;
        Util.closeQuietly(r32);
    L59:
        WebSocketReader r33 = (WebSocketReader) r28.element;
        if (r33 == null) goto L62;
        Util.closeQuietly(r33);
    L62:
        WebSocketWriter r34 = (WebSocketWriter) r27.element;
        if (r34 == null) goto L97;
        Util.closeQuietly(r34);
        return true;
    L97:
        return true;
    L36:
        WebSocketWriter r35 = r17;
        Object r36 = r5.element;     // Catch: Throwable -> L34
        if ((r36 instanceof Message) == false) goto L49;
        if (r36 == null) goto L48;
        Message r37 = (Message) r36;     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r35);     // Catch: Throwable -> L34
        r35.writeMessageFrame(r37.getFormatOpcode(), r37.getData());     // Catch: Throwable -> L34
        monitor-enter(this);     // Catch: Throwable -> L34
        this.queueSize -= (long) r37.getData().size();     // Catch: Throwable -> L44
        monitor-exit(this);     // Catch: Throwable -> L34
        goto L33
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L48:
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");     // Catch: Throwable -> L34
    L49:
        boolean r38 = r36 instanceof Close;     // Catch: Throwable -> L34
        if (r38 == false) goto L77;
        if (r36 == null) goto L75;
        Close r39 = (Close) r36;     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r35);     // Catch: Throwable -> L34
        r35.writeClose(r39.getCode(), r39.getReason());     // Catch: Throwable -> L34
        Ref.ObjectRef r40 = r12;
        Streams r41 = (Streams) r40.element;     // Catch: Throwable -> L72
        r31 = r40;
        if (r41 == null) goto L56;
        Intrinsics.checkNotNull((String) r13.element);     // Catch: Throwable -> L70
        throw 0;     // Catch: Throwable -> L70
    L72:
        th = th;
        ?? r42 = r27;
        ?? r43 = r28;
        ?? r44 = r40;
    L78:
        Streams r45 = (Streams) r44.element;
        if (r45 == null) goto L81;
        Util.closeQuietly(r45);
    L81:
        WebSocketReader r46 = (WebSocketReader) r43.element;
        if (r46 == null) goto L84;
        Util.closeQuietly(r46);
    L84:
        WebSocketWriter r47 = (WebSocketWriter) r42.element;
        if (r47 == null) goto L87;
        Util.closeQuietly(r47);
    L87:
        throw th;
    L75:
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");     // Catch: Throwable -> L70
    L77:
        throw new AssertionError();     // Catch: Throwable -> L70
    L70:
        th = th;
        r44 = r35;
        r43 = r38;
        r42 = r16;
    L34:
        th = th;
        r42 = r27;
        r43 = r28;
        r44 = r12;
        goto L78
    L23:
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");     // Catch: Throwable -> L17
    L24:
        r111 = r18;
        r27 = r14;
        r28 = r11;
        if (r19 != 0) goto L28;
        monitor-exit(this);
        return false;
    L16:
        r111 = r18;
        r27 = r14;
        r28 = r11;
        r16 = r15;
        goto L28
    }

    public final void writePingFrame$okhttp() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        WebSocketWriter r5 = this.writer;     // Catch: Throwable -> L12
        if (r5 != null) goto L10;
        monitor-exit(this);
        return;
    L10:
        if (this.awaitingPong == false) goto L14;
        int r10 = this.sentPingCount;     // Catch: Throwable -> L12
    L15:
        this.sentPingCount++;     // Catch: Throwable -> L12
        this.awaitingPong = true;     // Catch: Throwable -> L12
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        if (r10 == (-1)) goto L32;
        StringBuilder r12 = new StringBuilder("sent ping but didn't receive pong within ");
        r12.append(this.pingIntervalMillis);
        r12.append("ms (after ");
        failWebSocket(new SocketTimeoutException(androidx.constraintlayout.motion.widget.a.s(r12, r10 - 1, " successful ping/pongs)")), null);
        return;
    L32:
        r5.writePing(ByteString.EMPTY);     // Catch: IOException -> L23
        return;
    L23:
        e = move-exception;
        failWebSocket(e, null);
        return;
    L14:
        r10 = -1;
        goto L15
    }

    public final synchronized boolean close(int r10, String r11, long r12) {
        monitor-enter(this);
        WebSocketProtocol.INSTANCE.validateCloseCode(r10);     // Catch: Throwable -> L11
        if (r11 == null) goto L13;
        ByteString.Companion.getClass();     // Catch: Throwable -> L11
        ByteString r5 = m.c(r11);     // Catch: Throwable -> L11
        if (r5.size() > 123) goto L10;
    L15:
        if (this.failed == false) goto L17;
    L22:
        monitor-exit(this);
        return false;
    L17:
        if (this.enqueuedClose == true) goto L22;
        this.enqueuedClose = true;     // Catch: Throwable -> L11
        this.messageAndCloseQueue.add(new Close(r10, r5, r12));     // Catch: Throwable -> L11
        runWriter();     // Catch: Throwable -> L11
        monitor-exit(this);
        return true;
    L10:
        throw new IllegalArgumentException("reason.size() > 123: ".concat(r11).toString());     // Catch: Throwable -> L11
    L13:
        r5 = null;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "bytes");
        throw null;
    }

    public boolean send(ByteString r5) {
        Intrinsics.checkNotNullParameter(r5, "bytes");
        return send(r5, 2);
    }

    private final synchronized boolean send(ByteString r10, int r11) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L6;
    L19:
        monitor-exit(this);
        return false;
    L6:
        if (this.enqueuedClose == true) goto L19;
        if ((this.queueSize + ((long) r10.size())) <= MAX_QUEUE_SIZE) goto L15;
        close(1001, null);     // Catch: Throwable -> L13
        monitor-exit(this);
        return false;
    L15:
        this.queueSize += (long) r10.size();     // Catch: Throwable -> L13
        this.messageAndCloseQueue.add(new Message(r11, r10));     // Catch: Throwable -> L13
        runWriter();     // Catch: Throwable -> L13
        monitor-exit(this);
        return true;
    }
}
