package okhttp3.internal.http2;

import ai.j0;
import com.bytedance.common.wschannel.WsConstants;
import f4.b;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import nu.j;
import nu.k;
import nu.l;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0007\u0018\u0000 º\u00012\u00020\u0001:\b»\u0001º\u0001¼\u0001½\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001e\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010$\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001a2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0000¢\u0006\u0004\b\"\u0010#J/\u0010(\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u0010¢\u0006\u0004\b(\u0010)J\u001f\u0010.\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\b,\u0010-J\u001f\u00101\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010/\u001a\u00020*H\u0000¢\u0006\u0004\b0\u0010-J\u001f\u00105\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0010H\u0000¢\u0006\u0004\b3\u00104J%\u00109\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u0012¢\u0006\u0004\b;\u0010<J\r\u00109\u001a\u00020\u0012¢\u0006\u0004\b9\u0010<J\r\u0010=\u001a\u00020\u0012¢\u0006\u0004\b=\u0010<J\r\u0010>\u001a\u00020\u0012¢\u0006\u0004\b>\u0010<J\u0015\u0010?\u001a\u00020\u00122\u0006\u0010/\u001a\u00020*¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0012H\u0016¢\u0006\u0004\bA\u0010<J)\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020*2\b\u0010E\u001a\u0004\u0018\u00010DH\u0000¢\u0006\u0004\bF\u0010GJ#\u0010K\u001a\u00020\u00122\b\b\u0002\u0010H\u001a\u00020\u001a2\b\b\u0002\u0010J\u001a\u00020IH\u0007¢\u0006\u0004\bK\u0010LJ\u0015\u0010O\u001a\u00020\u00122\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bO\u0010PJ\u0015\u0010R\u001a\u00020\u001a2\u0006\u0010Q\u001a\u00020\u0010¢\u0006\u0004\bR\u0010SJ\u000f\u0010U\u001a\u00020\u0012H\u0000¢\u0006\u0004\bT\u0010<J\u0017\u0010X\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u0006H\u0000¢\u0006\u0004\bV\u0010WJ%\u0010[\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0000¢\u0006\u0004\bY\u0010ZJ-\u0010_\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\\\u001a\u00020\u001aH\u0000¢\u0006\u0004\b]\u0010^J/\u0010d\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010a\u001a\u00020`2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\u001aH\u0000¢\u0006\u0004\bb\u0010cJ\u001f\u0010f\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\be\u0010-J-\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u0019\u0010h\u001a\u00020\u00122\b\u0010g\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0004\bh\u0010iR\u001a\u0010j\u001a\u00020\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u001a\u0010o\u001a\u00020n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR&\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0s8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR\u001a\u0010y\u001a\u00020x8\u0000X\u0080\u0004¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R$\u0010}\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\b}\u0010~\u001a\u0004\b\u007f\u0010\b\"\u0006\b\u0080\u0001\u0010\u0081\u0001R'\u0010\u0082\u0001\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\b\u0082\u0001\u0010~\u001a\u0005\b\u0083\u0001\u0010\b\"\u0006\b\u0084\u0001\u0010\u0081\u0001R\u0018\u0010\u0085\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010kR\u0015\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bJ\u0010\u0086\u0001R\u0018\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0089\u0001R\u0018\u0010\u008b\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0089\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0019\u0010\u008f\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0090\u0001R\u0019\u0010\u0092\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0090\u0001R\u0019\u0010\u0093\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0090\u0001R\u0019\u0010\u0094\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0090\u0001R\u0019\u0010\u0095\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0090\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0090\u0001R\u001c\u0010\u0097\u0001\u001a\u00020M8\u0006¢\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R(\u0010\u009b\u0001\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u009b\u0001\u0010\u0098\u0001\u001a\u0006\b\u009c\u0001\u0010\u009a\u0001\"\u0005\b\u009d\u0001\u0010PR*\u0010\u009f\u0001\u001a\u00020\u00102\u0007\u0010\u009e\u0001\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u009f\u0001\u0010\u0090\u0001\u001a\u0006\b \u0001\u0010¡\u0001R*\u0010¢\u0001\u001a\u00020\u00102\u0007\u0010\u009e\u0001\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b¢\u0001\u0010\u0090\u0001\u001a\u0006\b£\u0001\u0010¡\u0001R*\u0010¤\u0001\u001a\u00020\u00102\u0007\u0010\u009e\u0001\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b¤\u0001\u0010\u0090\u0001\u001a\u0006\b¥\u0001\u0010¡\u0001R*\u0010¦\u0001\u001a\u00020\u00102\u0007\u0010\u009e\u0001\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b¦\u0001\u0010\u0090\u0001\u001a\u0006\b§\u0001\u0010¡\u0001R \u0010©\u0001\u001a\u00030¨\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001R\u001d\u0010®\u0001\u001a\u00030\u00ad\u00018\u0006¢\u0006\u0010\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001R!\u0010³\u0001\u001a\u00070²\u0001R\u00020\u00008\u0006¢\u0006\u0010\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001R\u001e\u0010¸\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060·\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001¨\u0006¾\u0001"}, d2 = {"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "Lokhttp3/internal/http2/Http2Connection$Builder;", "builder", "<init>", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "", "openStreamCount", "()I", "id", "Lokhttp3/internal/http2/Http2Stream;", "getStream", "(I)Lokhttp3/internal/http2/Http2Stream;", "streamId", "removeStream$okhttp", "removeStream", "", "read", "", "updateConnectionFlowControl$okhttp", "(J)V", "updateConnectionFlowControl", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "", "out", "pushStream", "(ILjava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "newStream", "(Ljava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "outFinished", "alternating", "writeHeaders$okhttp", "(IZLjava/util/List;)V", "writeHeaders", "Lnu/j;", "buffer", "byteCount", "writeData", "(IZLnu/j;J)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "writeSynResetLater$okhttp", "(ILokhttp3/internal/http2/ErrorCode;)V", "writeSynResetLater", "statusCode", "writeSynReset$okhttp", "writeSynReset", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "(IJ)V", "writeWindowUpdateLater", "reply", "payload1", "payload2", "writePing", "(ZII)V", "writePingAndAwaitPong", "()V", "awaitPong", "flush", "shutdown", "(Lokhttp3/internal/http2/ErrorCode;)V", "close", "connectionCode", "streamCode", "Ljava/io/IOException;", "cause", "close$okhttp", "(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "sendConnectionPreface", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "start", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "Lokhttp3/internal/http2/Settings;", "settings", "setSettings", "(Lokhttp3/internal/http2/Settings;)V", "nowNs", "isHealthy", "(J)Z", "sendDegradedPingLater$okhttp", "sendDegradedPingLater", "pushedStream$okhttp", "(I)Z", "pushedStream", "pushRequestLater$okhttp", "(ILjava/util/List;)V", "pushRequestLater", "inFinished", "pushHeadersLater$okhttp", "(ILjava/util/List;Z)V", "pushHeadersLater", "Lnu/l;", "source", "pushDataLater$okhttp", "(ILnu/l;IZ)V", "pushDataLater", "pushResetLater$okhttp", "pushResetLater", "e", "failConnection", "(Ljava/io/IOException;)V", "client", "Z", "getClient$okhttp", "()Z", "Lokhttp3/internal/http2/Http2Connection$Listener;", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "", "streams", "Ljava/util/Map;", "getStreams$okhttp", "()Ljava/util/Map;", "", "connectionName", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "lastGoodStreamId", "I", "getLastGoodStreamId$okhttp", "setLastGoodStreamId$okhttp", "(I)V", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "isShutdown", "Lokhttp3/internal/concurrent/TaskRunner;", "Lokhttp3/internal/concurrent/TaskQueue;", "writerQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "pushQueue", "settingsListenerQueue", "Lokhttp3/internal/http2/PushObserver;", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "intervalPingsSent", "J", "intervalPongsReceived", "degradedPingsSent", "degradedPongsReceived", "awaitPingsSent", "awaitPongsReceived", "degradedPongDeadlineNs", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "<set-?>", "readBytesTotal", "getReadBytesTotal", "()J", "readBytesAcknowledged", "getReadBytesAcknowledged", "writeBytesTotal", "getWriteBytesTotal", "writeBytesMaximum", "getWriteBytesMaximum", "Ljava/net/Socket;", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "Lokhttp3/internal/http2/Http2Writer;", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "", "currentPushRequests", "Ljava/util/Set;", "Companion", "Builder", "Listener", "ReaderRunnable", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = null;
    private static final Settings DEFAULT_SETTINGS = null;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b/\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\t\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\n8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\r\u001a\u00020\f8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\r\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u000f\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u0018\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010F\u001a\u0004\bG\u0010H¨\u0006I"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "", "client", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "Ljava/net/Socket;", "socket", "", "peerName", "Lnu/l;", "source", "Lnu/k;", "sink", "(Ljava/net/Socket;Ljava/lang/String;Lnu/l;Lnu/k;)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "listener", "(Lokhttp3/internal/http2/Http2Connection$Listener;)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/PushObserver;", "pushObserver", "(Lokhttp3/internal/http2/PushObserver;)Lokhttp3/internal/http2/Http2Connection$Builder;", "", "pingIntervalMillis", "(I)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/Http2Connection;", "build", "()Lokhttp3/internal/http2/Http2Connection;", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "connectionName", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "Lnu/l;", "getSource$okhttp", "()Lnu/l;", "setSource$okhttp", "(Lnu/l;)V", "Lnu/k;", "getSink$okhttp", "()Lnu/k;", "setSink$okhttp", "(Lnu/k;)V", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "I", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "Z", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {
        private boolean client;
        public String connectionName;
        private Listener listener;
        private int pingIntervalMillis;
        private PushObserver pushObserver;
        public k sink;
        public Socket socket;
        public l source;
        private final TaskRunner taskRunner;

        public Builder(boolean r5, TaskRunner r10) {
            Intrinsics.checkNotNullParameter(r10, "taskRunner");
            this.client = r5;
            this.taskRunner = r10;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public static /* synthetic */ Builder socket$default(Builder r5, Socket r10, String r11, l r12, k r13, int r14, Object r15) throws IOException {
            if ((r14 & 2) == 0) goto L6;
            r11 = Util.peerName(r10);
        L6:
            if ((r14 & 4) == 0) goto L9;
            r12 = b.e(b.q(r10));
        L9:
            if ((r14 & 8) == 0) goto L12;
            r13 = b.d(b.o(r10));
        L12:
            return r5.socket(r10, r11, r12, r13);
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final String getConnectionName$okhttp() {
            String r5 = this.connectionName;
            if (r5 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
        L5:
            return r5;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final k getSink$okhttp() {
            k r5 = this.sink;
            if (r5 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("sink");
        L5:
            return r5;
        }

        public final Socket getSocket$okhttp() {
            Socket r5 = this.socket;
            if (r5 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("socket");
        L5:
            return r5;
        }

        public final l getSource$okhttp() {
            l r5 = this.source;
            if (r5 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("source");
        L5:
            return r5;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final Builder listener(Listener r5) {
            Intrinsics.checkNotNullParameter(r5, "listener");
            this.listener = r5;
            return this;
        }

        public final Builder pingIntervalMillis(int r5) {
            this.pingIntervalMillis = r5;
            return this;
        }

        public final Builder pushObserver(PushObserver r5) {
            Intrinsics.checkNotNullParameter(r5, "pushObserver");
            this.pushObserver = r5;
            return this;
        }

        public final void setClient$okhttp(boolean r5) {
            this.client = r5;
        }

        public final void setConnectionName$okhttp(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.connectionName = r5;
        }

        public final void setListener$okhttp(Listener r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.listener = r5;
        }

        public final void setPingIntervalMillis$okhttp(int r5) {
            this.pingIntervalMillis = r5;
        }

        public final void setPushObserver$okhttp(PushObserver r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.pushObserver = r5;
        }

        public final void setSink$okhttp(k r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.sink = r5;
        }

        public final void setSocket$okhttp(Socket r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.socket = r5;
        }

        public final void setSource$okhttp(l r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.source = r5;
        }

        @JvmOverloads
        public final Builder socket(Socket r10) throws IOException {
            return socket$default(this, r10, null, null, null, 14, null);
        }

        @JvmOverloads
        public final Builder socket(Socket r10, String r11) throws IOException {
            return socket$default(this, r10, r11, null, null, 12, null);
        }

        @JvmOverloads
        public final Builder socket(Socket r10, String r11, l r12) throws IOException {
            return socket$default(this, r10, r11, r12, null, 8, null);
        }

        @JvmOverloads
        public final Builder socket(Socket r5, String r10, l r11, k r12) throws IOException {
            Intrinsics.checkNotNullParameter(r5, "socket");
            Intrinsics.checkNotNullParameter(r10, "peerName");
            Intrinsics.checkNotNullParameter(r11, "source");
            Intrinsics.checkNotNullParameter(r12, "sink");
            this.socket = r5;
            if (this.client == false) goto L5;
            String r13 = Util.okHttpName + ' ' + r10;
        L6:
            this.connectionName = r13;
            this.source = r11;
            this.sink = r12;
            return this;
        L5:
            r13 = j0.C("MockWebServer ", r10);
            goto L6
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "()V", "AWAIT_PING", "", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.access$getDEFAULT_SETTINGS$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "()V", "onSettings", "", WsConstants.KEY_CONNECTION, "Lokhttp3/internal/http2/Http2Connection;", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", "stream", "Lokhttp3/internal/http2/Http2Stream;", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static abstract class Listener {
        public static final Companion Companion = null;

        @JvmField
        public static final Listener REFUSE_INCOMING_STREAMS = null;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener$Companion;", "", "()V", "REFUSE_INCOMING_STREAMS", "Lokhttp3/internal/http2/Http2Connection$Listener;", "okhttp"}, k = 1, mv = {1, 4, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
            REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();
        }

        public Listener() {
        }

        public void onSettings(Http2Connection r5, Settings r10) {
            Intrinsics.checkNotNullParameter(r5, WsConstants.KEY_CONNECTION);
            Intrinsics.checkNotNullParameter(r10, "settings");
        }

        public abstract void onStream(Http2Stream r5) throws IOException;
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\tJ'\u0010&\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010'J'\u0010+\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010/\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J/\u00104\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\nH\u0016¢\u0006\u0004\b4\u00105J-\u00108\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b8\u00109J?\u0010@\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020-H\u0016¢\u0006\u0004\b@\u0010AR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010B\u001a\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "", "Lokhttp3/internal/http2/Http2Reader;", "reader", "<init>", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "invoke", "()V", "", "inFinished", "", "streamId", "Lnu/l;", "source", "length", "data", "(ZILnu/l;I)V", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "headerBlock", "headers", "(ZIILjava/util/List;)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "settings", "(ZLokhttp3/internal/http2/Settings;)V", "applyAndAckSettings", "ackSettings", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "Lokio/ByteString;", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;Lokio/ByteString;)V", "", "windowSizeIncrement", "windowUpdate", "(IJ)V", "streamDependency", "weight", "exclusive", "priority", "(IIIZ)V", "promisedStreamId", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "", "origin", "protocol", "host", "port", "maxAge", "alternateService", "(ILjava/lang/String;Lokio/ByteString;Ljava/lang/String;IJ)V", "Lokhttp3/internal/http2/Http2Reader;", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<Unit> {
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(Http2Connection r5, Http2Reader r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            this.this$0 = r5;
            this.reader = r10;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int r5, String r10, ByteString r11, String r12, int r13, long r14) {
            Intrinsics.checkNotNullParameter(r10, "origin");
            Intrinsics.checkNotNullParameter(r11, "protocol");
            Intrinsics.checkNotNullParameter(r12, "host");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, okhttp3.internal.http2.Settings] */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        public final void applyAndAckSettings(final boolean r22, final Settings r23) {
            Intrinsics.checkNotNullParameter(r23, "settings");
            final Ref.LongRef r13 = new Ref.LongRef();
            final Ref.ObjectRef r14 = new Ref.ObjectRef();
            final Ref.ObjectRef r15 = new Ref.ObjectRef();
            Http2Writer r16 = this.this$0.getWriter();
            monitor-enter(r16);
            Http2Connection r11 = this.this$0;     // Catch: Throwable -> L29
            monitor-enter(r11);     // Catch: Throwable -> L29
            Settings r5 = this.this$0.getPeerSettings();     // Catch: Throwable -> L18
            if (r22 == false) goto L9;
            ?? r10 = r23;
        L10:
            r15.element = r10;     // Catch: Throwable -> L18
            long r12 = ((long) r10.getInitialWindowSize()) - ((long) r5.getInitialWindowSize());     // Catch: Throwable -> L18
            r13.element = r12;     // Catch: Throwable -> L18
            if (r12 != 0) goto L13;
        L22:
            T r17 = 0;
        L23:
            r14.element = r17;     // Catch: Throwable -> L18
            this.this$0.setPeerSettings((Settings) r15.element);     // Catch: Throwable -> L18
            TaskQueue r18 = Http2Connection.access$getSettingsListenerQueue$p(this.this$0);     // Catch: Throwable -> L18
            final String r19 = this.this$0.getConnectionName$okhttp() + " onSettings";     // Catch: Throwable -> L18
            final boolean r20 = true;
            Http2Connection r21 = r11;
            r18.schedule(new Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1(r19, r20, r19, r20, this, r15, r22, r23, r13, r14), 0);     // Catch: Throwable -> L48
            Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L48
            monitor-exit(r21);     // Catch: Throwable -> L29
            this.this$0.getWriter().applyAndAckSettings((Settings) r15.element);     // Catch: Throwable -> L29 IOException -> L31
        L33:
            Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L29
            monitor-exit(r16);
            T r26 = r14.element;
            if (((Http2Stream[]) r26) == null) goto L47;
            Http2Stream[] r27 = (Http2Stream[]) r26;
            Intrinsics.checkNotNull(r27);
            int r28 = r27.length;
            int r29 = 0;
        L38:
            if (r29 >= r28) goto L62;
            Http2Stream r30 = r27[r29];
            monitor-enter(r30);
            r30.addBytesToWriteWindow(r13.element);     // Catch: Throwable -> L44
            Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L44
            monitor-exit(r30);
            r29 = r29 + 1;
        L44:
            th = move-exception;
            throw th;
        L62:
            return;
        L47:
            return;
        L31:
            e = move-exception;
            Http2Connection.access$failConnection(this.this$0, e);     // Catch: Throwable -> L29
        L48:
            th = th;
        L49:
            monitor-exit(r21);     // Catch: Throwable -> L29
            throw th;     // Catch: Throwable -> L29
        L13:
            if (this.this$0.getStreams$okhttp().isEmpty() == true) goto L22;
            Object[] r32 = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);     // Catch: Throwable -> L18
            if (r32 == null) goto L21;
            r17 = (Http2Stream[]) r32;     // Catch: Throwable -> L18
            goto L23
        L21:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L18
        L9:
            Settings r33 = new Settings();     // Catch: Throwable -> L18
            r33.merge(r5);     // Catch: Throwable -> L18
            r33.merge(r23);     // Catch: Throwable -> L18
            Unit r34 = Unit.INSTANCE;     // Catch: Throwable -> L18
            r10 = r33;
        L18:
            th = th;
            r21 = r11;
        L29:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean r5, int r10, l r11, int r12) throws IOException {
            Intrinsics.checkNotNullParameter(r11, "source");
            if (this.this$0.pushedStream$okhttp(r10) == false) goto L6;
            this.this$0.pushDataLater$okhttp(r10, r11, r12, r5);
            return;
        L6:
            Http2Stream r13 = this.this$0.getStream(r10);
            if (r13 != null) goto L10;
            this.this$0.writeSynResetLater$okhttp(r10, ErrorCode.PROTOCOL_ERROR);
            long r14 = r12;
            this.this$0.updateConnectionFlowControl$okhttp(r14);
            r11.skip(r14);
            return;
        L10:
            r13.receiveData(r11, r12);
            if (r5 == false) goto L14;
            r13.receiveHeaders(Util.EMPTY_HEADERS, true);
            return;
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int r5, ErrorCode r10, ByteString r11) {
            Intrinsics.checkNotNullParameter(r10, "errorCode");
            Intrinsics.checkNotNullParameter(r11, "debugData");
            r11.size();
            Http2Connection r12 = this.this$0;
            monitor-enter(r12);
            int r13 = 0;
            Object[] r14 = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);     // Catch: Throwable -> L17
            if (r14 == null) goto L20;
            Http2Stream[] r15 = (Http2Stream[]) r14;     // Catch: Throwable -> L17
            Http2Connection.access$setShutdown$p(this.this$0, true);     // Catch: Throwable -> L17
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L17
            monitor-exit(r12);
            int r17 = r15.length;
        L9:
            if (r13 >= r17) goto L16;
            Http2Stream r18 = r15[r13];
            if (r18.getId() <= r5) goto L15;
            if (r18.isLocallyInitiated() == false) goto L15;
            r18.receiveRstStream(ErrorCode.REFUSED_STREAM);
            this.this$0.removeStream$okhttp(r18.getId());
        L15:
            r13 = r13 + 1;
            goto L9
        L16:
            return;
        L20:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(final boolean r16, final int r17, int r18, final List<Header> r19) {
            Intrinsics.checkNotNullParameter(r19, "headerBlock");
            if (this.this$0.pushedStream$okhttp(r17) == false) goto L6;
            this.this$0.pushHeadersLater$okhttp(r17, r19, r16);
            return;
        L6:
            Http2Connection r12 = this.this$0;
            monitor-enter(r12);
            final Http2Stream r10 = this.this$0.getStream(r17);     // Catch: Throwable -> L25
            if (r10 == null) goto L11;
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L25
            monitor-exit(r12);
            r10.receiveHeaders(Util.toHeaders(r19), r16);
            return;
        L11:
            if (Http2Connection.access$isShutdown$p(this.this$0) == false) goto L15;
            monitor-exit(r12);
            return;
        L15:
            if (r17 > this.this$0.getLastGoodStreamId$okhttp()) goto L19;
            monitor-exit(r12);
            return;
        L19:
            if ((r17 % 2) != (this.this$0.getNextStreamId$okhttp() % 2)) goto L22;
            monitor-exit(r12);
            return;
        L22:
            final Http2Stream r11 = new Http2Stream(r17, this.this$0, false, r16, Util.toHeaders(r19));     // Catch: Throwable -> L25
            this.this$0.setLastGoodStreamId$okhttp(r17);     // Catch: Throwable -> L25
            this.this$0.getStreams$okhttp().put(Integer.valueOf(r17), r11);     // Catch: Throwable -> L25
            TaskQueue r13 = Http2Connection.access$getTaskRunner$p(this.this$0).newQueue();     // Catch: Throwable -> L25
            final String r14 = this.this$0.getConnectionName$okhttp() + '[' + r17 + "] onStream";     // Catch: Throwable -> L25
            final boolean r15 = true;
            r13.schedule(new Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1(r14, r15, r14, r15, r11, this, r10, r17, r19, r16), 0);     // Catch: Throwable -> L25
            monitor-exit(r12);
            return;
        L25:
            th = move-exception;
            throw th;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean r11, final int r12, final int r13) {
            if (r11 == false) goto L25;
            Http2Connection r14 = this.this$0;
            monitor-enter(r14);
            if (r12 != 1) goto L8;
            Http2Connection r10 = this.this$0;     // Catch: Throwable -> L12
            Http2Connection.access$setIntervalPongsReceived$p(r10, Http2Connection.access$getIntervalPongsReceived$p(r10) + 1);     // Catch: Throwable -> L12
        L21:
            monitor-exit(r14);
            return;
        L8:
            if (r12 != 2) goto L10;
            Http2Connection r15 = this.this$0;     // Catch: Throwable -> L12
            Http2Connection.access$setDegradedPongsReceived$p(r15, Http2Connection.access$getDegradedPongsReceived$p(r15) + 1);     // Catch: Throwable -> L12
            goto L21
        L10:
            if (r12 == 3) goto L14;
        L11:
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L12
            goto L21
        L14:
            Http2Connection r17 = this.this$0;     // Catch: Throwable -> L12
            Http2Connection.access$setAwaitPongsReceived$p(r17, Http2Connection.access$getAwaitPongsReceived$p(r17) + 1);     // Catch: Throwable -> L12
            Http2Connection r18 = this.this$0;     // Catch: Throwable -> L12
            if (r18 == null) goto L18;
            r18.notifyAll();     // Catch: Throwable -> L12
            goto L11
        L18:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L25:
            TaskQueue r19 = Http2Connection.access$getWriterQueue$p(this.this$0);
            final String r5 = this.this$0.getConnectionName$okhttp() + " ping";
            final boolean r20 = true;
            r19.schedule(new Http2Connection$ReaderRunnable$ping$$inlined$execute$1(r5, r20, r5, r20, this, r12, r13), 0);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int r5, int r10, int r11, boolean r12) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int r5, int r10, List<Header> r11) {
            Intrinsics.checkNotNullParameter(r11, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(r10, r11);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int r5, ErrorCode r10) {
            Intrinsics.checkNotNullParameter(r10, "errorCode");
            if (this.this$0.pushedStream$okhttp(r5) == false) goto L6;
            this.this$0.pushResetLater$okhttp(r5, r10);
            return;
        L6:
            Http2Stream r11 = this.this$0.removeStream$okhttp(r5);
            if (r11 == null) goto L10;
            r11.receiveRstStream(r10);
            return;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean r12, final Settings r13) {
            Intrinsics.checkNotNullParameter(r13, "settings");
            TaskQueue r5 = Http2Connection.access$getWriterQueue$p(this.this$0);
            final String r10 = this.this$0.getConnectionName$okhttp() + " applyAndAckSettings";
            final boolean r11 = true;
            r5.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$1(r10, r11, r10, r11, this, r12, r13), 0);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int r5, long r10) {
            if (r5 != 0) goto L16;
            Http2Connection r11 = this.this$0;
            monitor-enter(r11);
            Http2Connection r12 = this.this$0;     // Catch: Throwable -> L10
            Http2Connection.access$setWriteBytesMaximum$p(r12, r12.getWriteBytesMaximum() + r10);     // Catch: Throwable -> L10
            Http2Connection r13 = this.this$0;     // Catch: Throwable -> L10
            if (r13 == null) goto L13;
            r13.notifyAll();     // Catch: Throwable -> L10
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r11);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        L16:
            Http2Stream r15 = this.this$0.getStream(r5);
            if (r15 == null) goto L25;
            monitor-enter(r15);
            r15.addBytesToWriteWindow(r10);     // Catch: Throwable -> L22
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L22
            monitor-exit(r15);
            return;
        L22:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable, okhttp3.internal.http2.Http2Reader] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2() {
            ErrorCode r5 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            this.reader.readConnectionPreface(this);     // Catch: Throwable -> L15 IOException -> L17
        L5:
            if (this.reader.nextFrame(false, this) == true) goto L5;
            ErrorCode r10 = ErrorCode.NO_ERROR;     // Catch: Throwable -> L15 IOException -> L17
            r5 = ErrorCode.CANCEL;     // Catch: Throwable -> L11 IOException -> L13
            this.this$0.close$okhttp(r10, r5, null);
            ErrorCode r11 = r10;
        L10:
            ReaderRunnable this = this.reader;
            Util.closeQuietly(this);
            return;
        L13:
            e = e;
        L19:
            r5 = ErrorCode.PROTOCOL_ERROR;     // Catch: Throwable -> L11
            Http2Connection r12 = this.this$0;
            r12.close$okhttp(r5, r5, e);
            r11 = r12;
            goto L10
        L11:
            th = th;
        L22:
            this.this$0.close$okhttp(r11, r5, e);
            Util.closeQuietly(this.reader);
            throw th;
        L17:
            e = e;
        L15:
            th = th;
            r11 = r5;
            goto L22
        }
    }

    static {
        Companion = new Companion(null);
        Settings r5 = new Settings();
        r5.set(7, 65535);
        r5.set(5, 16384);
        DEFAULT_SETTINGS = r5;
    }

    public Http2Connection(Builder r13) {
        Intrinsics.checkNotNullParameter(r13, "builder");
        boolean r5 = r13.getClient$okhttp();
        this.client = r5;
        this.listener = r13.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String r10 = r13.getConnectionName$okhttp();
        this.connectionName = r10;
        if (r13.getClient$okhttp() == false) goto L5;
        int r11 = 3;
    L6:
        this.nextStreamId = r11;
        TaskRunner r12 = r13.getTaskRunner$okhttp();
        this.taskRunner = r12;
        TaskQueue r14 = r12.newQueue();
        this.writerQueue = r14;
        this.pushQueue = r12.newQueue();
        this.settingsListenerQueue = r12.newQueue();
        this.pushObserver = r13.getPushObserver$okhttp();
        Settings r15 = new Settings();
        if (r13.getClient$okhttp() == false) goto L9;
        r15.set(7, 16777216);
    L9:
        Unit r16 = Unit.INSTANCE;
        this.okHttpSettings = r15;
        Settings r17 = DEFAULT_SETTINGS;
        this.peerSettings = r17;
        this.writeBytesMaximum = r17.getInitialWindowSize();
        this.socket = r13.getSocket$okhttp();
        this.writer = new Http2Writer(r13.getSink$okhttp(), r5);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(r13.getSource$okhttp(), r5));
        this.currentPushRequests = new LinkedHashSet();
        if (r13.getPingIntervalMillis$okhttp() == 0) goto L13;
        final long r18 = TimeUnit.MILLISECONDS.toNanos(r13.getPingIntervalMillis$okhttp());
        final String r19 = j0.j(r10, " ping");
        r14.schedule(new Http2Connection$$special$$inlined$schedule$1(r19, r19, this, r18), r18);
        return;
    L13:
        return;
    L5:
        r11 = 2;
        goto L6
    }

    public static final /* synthetic */ void access$failConnection(Http2Connection r5, IOException r10) {
        r5.failConnection(r10);
    }

    public static final /* synthetic */ long access$getAwaitPongsReceived$p(Http2Connection r5) {
        return r5.awaitPongsReceived;
    }

    public static final /* synthetic */ Set access$getCurrentPushRequests$p(Http2Connection r5) {
        return r5.currentPushRequests;
    }

    public static final /* synthetic */ Settings access$getDEFAULT_SETTINGS$cp() {
        return DEFAULT_SETTINGS;
    }

    public static final /* synthetic */ long access$getDegradedPongsReceived$p(Http2Connection r5) {
        return r5.degradedPongsReceived;
    }

    public static final /* synthetic */ long access$getIntervalPingsSent$p(Http2Connection r5) {
        return r5.intervalPingsSent;
    }

    public static final /* synthetic */ long access$getIntervalPongsReceived$p(Http2Connection r5) {
        return r5.intervalPongsReceived;
    }

    public static final /* synthetic */ PushObserver access$getPushObserver$p(Http2Connection r5) {
        return r5.pushObserver;
    }

    public static final /* synthetic */ TaskQueue access$getSettingsListenerQueue$p(Http2Connection r5) {
        return r5.settingsListenerQueue;
    }

    public static final /* synthetic */ TaskRunner access$getTaskRunner$p(Http2Connection r5) {
        return r5.taskRunner;
    }

    public static final /* synthetic */ long access$getWriteBytesMaximum$p(Http2Connection r5) {
        return r5.writeBytesMaximum;
    }

    public static final /* synthetic */ TaskQueue access$getWriterQueue$p(Http2Connection r5) {
        return r5.writerQueue;
    }

    public static final /* synthetic */ boolean access$isShutdown$p(Http2Connection r5) {
        return r5.isShutdown;
    }

    public static final /* synthetic */ void access$setAwaitPongsReceived$p(Http2Connection r5, long r10) {
        r5.awaitPongsReceived = r10;
    }

    public static final /* synthetic */ void access$setDegradedPongsReceived$p(Http2Connection r5, long r10) {
        r5.degradedPongsReceived = r10;
    }

    public static final /* synthetic */ void access$setIntervalPingsSent$p(Http2Connection r5, long r10) {
        r5.intervalPingsSent = r10;
    }

    public static final /* synthetic */ void access$setIntervalPongsReceived$p(Http2Connection r5, long r10) {
        r5.intervalPongsReceived = r10;
    }

    public static final /* synthetic */ void access$setShutdown$p(Http2Connection r5, boolean r10) {
        r5.isShutdown = r10;
    }

    public static final /* synthetic */ void access$setWriteBytesMaximum$p(Http2Connection r5, long r10) {
        r5.writeBytesMaximum = r10;
    }

    private final void failConnection(IOException r5) {
        ErrorCode r10 = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(r10, r10, r5);
    }

    public static /* synthetic */ void start$default(Http2Connection r5, boolean r10, TaskRunner r11, int r12, Object r13) throws IOException {
        if ((r12 & 1) == 0) goto L6;
        r10 = true;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = TaskRunner.INSTANCE;
    L8:
        r5.start(r10, r11);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        monitor-enter(this);
    L13:
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.awaitPongsReceived >= this.awaitPingsSent) goto L9;
        wait();     // Catch: Throwable -> L7
        goto L13
    L9:
        monitor-exit(this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode r5, ErrorCode r10, IOException r11) {
        Intrinsics.checkNotNullParameter(r5, "connectionCode");
        Intrinsics.checkNotNullParameter(r10, "streamCode");
        if (Util.assertionsEnabled == true) goto L5;
    L45:
        shutdown(r5);     // Catch: IOException -> L35
    L10:
        monitor-enter(this);
        int r12 = 0;
        if (this.streams.isEmpty() == true) goto L20;
        Object[] r13 = this.streams.values().toArray(new Http2Stream[0]);     // Catch: Throwable -> L16
        if (r13 == null) goto L19;
        Http2Stream[] r14 = (Http2Stream[]) r13;     // Catch: Throwable -> L16
        this.streams.clear();     // Catch: Throwable -> L16
    L21:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        if (r14 == null) goto L43;
        int r16 = r14.length;
    L25:
        if (r12 >= r16) goto L43;
        r14[r12].close(r10, r11);     // Catch: IOException -> L36
    L28:
        r12 = r12 + 1;
    L43:
        this.writer.close();     // Catch: IOException -> L37
    L41:
        this.socket.close();     // Catch: IOException -> L38
    L31:
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L16
    L20:
        r14 = null;
    L16:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L45;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final synchronized Http2Stream getStream(int r5) {
        monitor-enter(this);
        Http2Stream r10 = this.streams.get(Integer.valueOf(r5));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isHealthy(long r10) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.isShutdown == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.degradedPongsReceived >= this.degradedPingsSent) goto L17;
        if (r10 < this.degradedPongDeadlineNs) goto L17;
        monitor-exit(this);
        return false;
    L17:
        monitor-exit(this);
        return true;
    }

    public final Http2Stream newStream(List<Header> r5, boolean r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "requestHeaders");
        return newStream(0, r5, r10);
    }

    public final synchronized int openStreamCount() {
        monitor-enter(this);
        int r5 = this.streams.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final void pushDataLater$okhttp(final int r12, l r13, final int r14, final boolean r15) throws IOException {
        Intrinsics.checkNotNullParameter(r13, "source");
        final j r10 = new j();
        long r5 = r14;
        r13.s(r5);
        r13.read(r10, r5);
        TaskQueue r16 = this.pushQueue;
        final String r11 = this.connectionName + '[' + r12 + "] onData";
        final boolean r17 = true;
        r16.schedule(new Http2Connection$pushDataLater$$inlined$execute$1(r11, r17, r11, r17, this, r12, r10, r14, r15), 0);
    }

    public final void pushHeadersLater$okhttp(final int r13, final List<Header> r14, final boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "requestHeaders");
        TaskQueue r5 = this.pushQueue;
        final String r10 = this.connectionName + '[' + r13 + "] onHeaders";
        final boolean r11 = true;
        r5.schedule(new Http2Connection$pushHeadersLater$$inlined$execute$1(r10, r11, r10, r11, this, r13, r14, r15), 0);
    }

    public final void pushRequestLater$okhttp(final int r12, final List<Header> r13) {
        Intrinsics.checkNotNullParameter(r13, "requestHeaders");
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.currentPushRequests.contains(Integer.valueOf(r12)) == false) goto L11;
        writeSynResetLater$okhttp(r12, ErrorCode.PROTOCOL_ERROR);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L11:
        this.currentPushRequests.add(Integer.valueOf(r12));     // Catch: Throwable -> L9
        monitor-exit(this);
        TaskQueue r5 = this.pushQueue;
        final String r10 = this.connectionName + '[' + r12 + "] onRequest";
        final boolean r11 = true;
        r5.schedule(new Http2Connection$pushRequestLater$$inlined$execute$1(r10, r11, r10, r11, this, r12, r13), 0);
    }

    public final void pushResetLater$okhttp(final int r12, final ErrorCode r13) {
        Intrinsics.checkNotNullParameter(r13, "errorCode");
        TaskQueue r5 = this.pushQueue;
        final String r10 = this.connectionName + '[' + r12 + "] onReset";
        final boolean r11 = true;
        r5.schedule(new Http2Connection$pushResetLater$$inlined$execute$1(r10, r11, r10, r11, this, r12, r13), 0);
    }

    public final Http2Stream pushStream(int r5, List<Header> r10, boolean r11) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "requestHeaders");
        if (this.client == true) goto L7;
        return newStream(r5, r10, r11);
    L7:
        throw new IllegalStateException("Client cannot push requests.");
    }

    public final boolean pushedStream$okhttp(int r5) {
        if (r5 != 0) goto L4;
    L6:
        return false;
    L4:
        if ((r5 & 1) != 0) goto L6;
        return true;
    }

    public final synchronized Http2Stream removeStream$okhttp(int r5) {
        monitor-enter(this);
        Http2Stream r10 = this.streams.remove(Integer.valueOf(r5));     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final void sendDegradedPingLater$okhttp() {
        monitor-enter(this);
        long r5 = this.degradedPongsReceived;     // Catch: Throwable -> L13
        long r10 = this.degradedPingsSent;     // Catch: Throwable -> L13
        if (r5 >= r10) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.degradedPingsSent = r10 + 1;     // Catch: Throwable -> L13
        this.degradedPongDeadlineNs = System.nanoTime() + ((long) DEGRADED_PONG_TIMEOUT_NS);     // Catch: Throwable -> L13
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        TaskQueue r12 = this.writerQueue;
        final String r13 = j0.q(new StringBuilder(), this.connectionName, " ping");
        final boolean r14 = true;
        r12.schedule(new Http2Connection$sendDegradedPingLater$$inlined$execute$1(r13, r14, r13, r14, this), 0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void setLastGoodStreamId$okhttp(int r5) {
        this.lastGoodStreamId = r5;
    }

    public final void setNextStreamId$okhttp(int r5) {
        this.nextStreamId = r5;
    }

    public final void setPeerSettings(Settings r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.peerSettings = r5;
    }

    public final void setSettings(Settings r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "settings");
        Http2Writer r10 = this.writer;
        monitor-enter(r10);
        monitor-enter(this);     // Catch: Throwable -> L12
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L6:
        if (this.isShutdown == true) goto L17;
        this.okHttpSettings.merge(r5);     // Catch: Throwable -> L14
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L12
        this.writer.settings(r5);     // Catch: Throwable -> L12
        monitor-exit(r10);
        return;
    L17:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L14
    L12:
        th = move-exception;
        throw th;
    }

    public final void shutdown(ErrorCode r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "statusCode");
        Http2Writer r10 = this.writer;
        monitor-enter(r10);
        monitor-enter(this);     // Catch: Throwable -> L10
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L6:
        if (this.isShutdown == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L10
        monitor-exit(r10);
        return;
    L13:
        this.isShutdown = true;     // Catch: Throwable -> L18
        int r11 = this.lastGoodStreamId;     // Catch: Throwable -> L18
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L10
        this.writer.goAway(r11, r5, Util.EMPTY_BYTE_ARRAY);     // Catch: Throwable -> L10
        monitor-exit(r10);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @JvmOverloads
    public final void start() throws IOException {
        start$default(this, false, null, 3, null);
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long r5) {
        monitor-enter(this);
        long r10 = this.readBytesTotal + r5;     // Catch: Throwable -> L7
        this.readBytesTotal = r10;     // Catch: Throwable -> L7
        long r11 = r10 - this.readBytesAcknowledged;     // Catch: Throwable -> L7
        if (r11 < (this.okHttpSettings.getInitialWindowSize() / 2)) goto L9;
        writeWindowUpdateLater$okhttp(0, r11);     // Catch: Throwable -> L7
        this.readBytesAcknowledged += r11;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void writeData(int r10, boolean r11, j r12, long r13) throws IOException {
        if (r13 != 0) goto L7;
        this.writer.data(r11, r10, r12, 0);
        return;
    L7:
        if (r13 <= 0) goto L32;
        monitor-enter(this);
    L33:
        long r5 = this.writeBytesTotal;     // Catch: Throwable -> L14 InterruptedException -> L28
        long r14 = this.writeBytesMaximum;     // Catch: Throwable -> L14 InterruptedException -> L28
        if (r5 < r14) goto L19;
        if (this.streams.containsKey(Integer.valueOf(r10)) == false) goto L17;
        wait();     // Catch: Throwable -> L14 InterruptedException -> L28
        goto L33
    L17:
        throw new IOException("stream closed");     // Catch: Throwable -> L14 InterruptedException -> L28
    L19:
        int r15 = Math.min((int) Math.min(r13, r14 - r5), this.writer.maxDataLength());     // Catch: Throwable -> L14
        long r16 = r15;
        this.writeBytesTotal += r16;     // Catch: Throwable -> L14
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        r13 = r13 - r16;
        Http2Writer r18 = this.writer;
        if (r11 == true) goto L24;
    L26:
        boolean r19 = false;
    L27:
        r18.data(r19, r10, r12, r15);
        goto L7
    L24:
        if (r13 != 0) goto L26;
        r19 = true;
    L28:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L14
        throw new InterruptedIOException();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final void writeHeaders$okhttp(int r5, boolean r10, List<Header> r11) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "alternating");
        this.writer.headers(r10, r5, r11);
    }

    public final void writePing(boolean r5, int r10, int r11) {
        this.writer.ping(r5, r10, r11);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        failConnection(e);
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int r5, ErrorCode r10) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "statusCode");
        this.writer.rstStream(r5, r10);
    }

    public final void writeSynResetLater$okhttp(final int r12, final ErrorCode r13) {
        Intrinsics.checkNotNullParameter(r13, "errorCode");
        TaskQueue r5 = this.writerQueue;
        final String r10 = this.connectionName + '[' + r12 + "] writeSynReset";
        final boolean r11 = true;
        r5.schedule(new Http2Connection$writeSynResetLater$$inlined$execute$1(r10, r11, r10, r11, this, r12, r13), 0);
    }

    public final void writeWindowUpdateLater$okhttp(final int r13, final long r14) {
        TaskQueue r5 = this.writerQueue;
        final String r10 = this.connectionName + '[' + r13 + "] windowUpdate";
        final boolean r11 = true;
        r5.schedule(new Http2Connection$writeWindowUpdateLater$$inlined$execute$1(r10, r11, r10, r11, this, r13, r14), 0);
    }

    private final Http2Stream newStream(int r12, List<Header> r13, boolean r14) throws IOException {
        boolean r5 = true;
        boolean r10 = !r14;
        Http2Writer r11 = this.writer;
        monitor-enter(r11);
        monitor-enter(this);     // Catch: Throwable -> L27
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L6:
        if (this.nextStreamId <= 1073741823) goto L11;
        shutdown(ErrorCode.REFUSED_STREAM);     // Catch: Throwable -> L8
    L11:
        if (this.isShutdown == true) goto L39;
        int r15 = this.nextStreamId;     // Catch: Throwable -> L8
        this.nextStreamId = r15 + 2;     // Catch: Throwable -> L8
        Http2Stream r16 = new Http2Stream(r15, this, r10, false, null);     // Catch: Throwable -> L8
        if (r14 == false) goto L21;
        if (this.writeBytesTotal >= this.writeBytesMaximum) goto L21;
        if (r16.getWriteBytesTotal() >= r16.getWriteBytesMaximum()) goto L21;
        r5 = false;
    L21:
        if (r16.isOpen() == false) goto L23;
        this.streams.put(Integer.valueOf(r15), r16);     // Catch: Throwable -> L8
    L23:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L27
        if (r12 != 0) goto L30;
        this.writer.headers(r10, r15, r13);     // Catch: Throwable -> L27
    L32:
        monitor-exit(r11);
        if (r5 == false) goto L35;
        this.writer.flush();
    L35:
        return r16;
    L30:
        if (this.client == true) goto L37;
        this.writer.pushPromise(r12, r15, r13);     // Catch: Throwable -> L27
        goto L32
    L37:
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");     // Catch: Throwable -> L27
    L39:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L8
    L27:
        th = move-exception;
        throw th;
    }

    @JvmOverloads
    public final void start(boolean r5) throws IOException {
        start$default(this, r5, null, 2, null);
    }

    @JvmOverloads
    public final void start(boolean r10, TaskRunner r11) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "taskRunner");
        if (r10 == false) goto L7;
        this.writer.connectionPreface();
        this.writer.settings(this.okHttpSettings);
        int r12 = this.okHttpSettings.getInitialWindowSize();
        if (r12 == 65535) goto L7;
        this.writer.windowUpdate(0, r12 - 65535);
    L7:
        TaskQueue r13 = r11.newQueue();
        String r5 = this.connectionName;
        r13.schedule(new TaskQueue.AnonymousClass1(this.readerRunnable, r5, true, r5, true), 0);
    }

    public final void writePing() throws InterruptedException {
        monitor-enter(this);
        this.awaitPingsSent++;     // Catch: Throwable -> L7
        monitor-exit(this);
        writePing(false, 3, 1330343787);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
