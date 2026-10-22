package okhttp3.internal.http2;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u008e\u00012\u00020\u0001:\b\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010H\u001a\u00020IJ\b\u0010J\u001a\u00020IH\u0016J'\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020L2\b\u0010N\u001a\u0004\u0018\u00010OH\u0000¢\u0006\u0002\bPJ\u0012\u0010Q\u001a\u00020I2\b\u0010R\u001a\u0004\u0018\u00010OH\u0002J\u0006\u0010S\u001a\u00020IJ\u0010\u0010T\u001a\u0004\u0018\u00010;2\u0006\u0010U\u001a\u00020\u0010J\u0006\u0010V\u001a\u00020\u0010J&\u0010W\u001a\u00020;2\u0006\u0010X\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0Z2\u0006\u0010\\\u001a\u00020\u0006H\u0002J\u001c\u0010W\u001a\u00020;2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0Z2\u0006\u0010\\\u001a\u00020\u0006J\u0006\u0010]\u001a\u00020\u0010J-\u0010^\u001a\u00020I2\u0006\u0010_\u001a\u00020\u00102\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u0006H\u0000¢\u0006\u0002\bdJ+\u0010e\u001a\u00020I2\u0006\u0010_\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0Z2\u0006\u0010c\u001a\u00020\u0006H\u0000¢\u0006\u0002\bfJ#\u0010g\u001a\u00020I2\u0006\u0010_\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0ZH\u0000¢\u0006\u0002\bhJ\u001d\u0010i\u001a\u00020I2\u0006\u0010_\u001a\u00020\u00102\u0006\u0010j\u001a\u00020LH\u0000¢\u0006\u0002\bkJ$\u0010l\u001a\u00020;2\u0006\u0010X\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0Z2\u0006\u0010\\\u001a\u00020\u0006J\u0015\u0010m\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\u0010H\u0000¢\u0006\u0002\bnJ\u0017\u0010o\u001a\u0004\u0018\u00010;2\u0006\u0010_\u001a\u00020\u0010H\u0000¢\u0006\u0002\bpJ\u000e\u0010q\u001a\u00020I2\u0006\u0010r\u001a\u00020\"J\u000e\u0010s\u001a\u00020I2\u0006\u0010t\u001a\u00020LJ\u0012\u0010u\u001a\u00020I2\b\b\u0002\u0010v\u001a\u00020\u0006H\u0007J\u0015\u0010w\u001a\u00020I2\u0006\u0010x\u001a\u00020+H\u0000¢\u0006\u0002\byJ(\u0010z\u001a\u00020I2\u0006\u0010_\u001a\u00020\u00102\u0006\u0010{\u001a\u00020\u00062\b\u0010|\u001a\u0004\u0018\u00010}2\u0006\u0010b\u001a\u00020+J,\u0010~\u001a\u00020I2\u0006\u0010_\u001a\u00020\u00102\u0006\u0010{\u001a\u00020\u00062\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020[0ZH\u0000¢\u0006\u0003\b\u0080\u0001J\"\u0010\u0081\u0001\u001a\u00020I2\u0007\u0010\u0082\u0001\u001a\u00020\u00062\u0007\u0010\u0083\u0001\u001a\u00020\u00102\u0007\u0010\u0084\u0001\u001a\u00020\u0010J\u0007\u0010\u0085\u0001\u001a\u00020IJ\u001f\u0010\u0086\u0001\u001a\u00020I2\u0006\u0010_\u001a\u00020\u00102\u0006\u0010t\u001a\u00020LH\u0000¢\u0006\u0003\b\u0087\u0001J\u001f\u0010\u0088\u0001\u001a\u00020I2\u0006\u0010_\u001a\u00020\u00102\u0006\u0010j\u001a\u00020LH\u0000¢\u0006\u0003\b\u0089\u0001J \u0010\u008a\u0001\u001a\u00020I2\u0006\u0010_\u001a\u00020\u00102\u0007\u0010\u008b\u0001\u001a\u00020+H\u0000¢\u0006\u0003\b\u008c\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068F@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0015\u00101\u001a\u000602R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u000206X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020;0:X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001e\u0010>\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010.R\u001e\u0010@\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010.R\u0011\u0010B\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0091\u0001"}, d2 = {"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "builder", "Lokhttp3/internal/http2/Http2Connection$Builder;", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "awaitingPong", "", "client", "getClient$okhttp", "()Z", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "currentPushRequests", "", "", "<set-?>", "isShutdown", "setShutdown$okhttp", "(Z)V", "lastGoodStreamId", "getLastGoodStreamId$okhttp", "()I", "setLastGoodStreamId$okhttp", "(I)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "pushExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "readBytesTotal", "getReadBytesTotal", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "streams", "", "Lokhttp3/internal/http2/Http2Stream;", "getStreams$okhttp", "()Ljava/util/Map;", "writeBytesMaximum", "getWriteBytesMaximum", "writeBytesTotal", "getWriteBytesTotal", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "writerExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "awaitPong", "", IslandSession.REOPEN_VALUE_CLOSE, "connectionCode", "Lokhttp3/internal/http2/ErrorCode;", "streamCode", "cause", "Ljava/io/IOException;", "close$okhttp", "failConnection", "e", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "getStream", OaidModel.KEY_ID, "maxConcurrentStreams", "newStream", "associatedStreamId", "requestHeaders", "", "Lokhttp3/internal/http2/Header;", "out", "openStreamCount", "pushDataLater", "streamId", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "byteCount", "inFinished", "pushDataLater$okhttp", "pushHeadersLater", "pushHeadersLater$okhttp", "pushRequestLater", "pushRequestLater$okhttp", "pushResetLater", "errorCode", "pushResetLater$okhttp", "pushStream", "pushedStream", "pushedStream$okhttp", "removeStream", "removeStream$okhttp", "setSettings", "settings", "shutdown", "statusCode", CommonConsts.APM_INNER_EVENT_COST_START, "sendConnectionPreface", "updateConnectionFlowControl", "read", "updateConnectionFlowControl$okhttp", "writeData", "outFinished", "buffer", "Lokio/Buffer;", "writeHeaders", "alternating", "writeHeaders$okhttp", "writePing", "reply", "payload1", "payload2", "writePingAndAwaitPong", "writeSynReset", "writeSynReset$okhttp", "writeSynResetLater", "writeSynResetLater$okhttp", "writeWindowUpdateLater", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "Builder", "Companion", "Listener", "ReaderRunnable", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Http2Connection implements Closeable {
    public static final Companion Companion = null;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ThreadPoolExecutor listenerExecutor = null;
    private boolean awaitingPong;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private final Settings peerSettings;
    private final ThreadPoolExecutor pushExecutor;
    private final PushObserver pushObserver;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final ReaderRunnable readerRunnable;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    private final ScheduledThreadPoolExecutor writerExecutor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00102\u001a\u000203J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ.\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010 \u001a\u00020!H\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00064"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "client", "", "(Z)V", "getClient$okhttp", "()Z", "setClient$okhttp", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "pingIntervalMillis", "", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "sink", "Lokio/BufferedSink;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "build", "Lokhttp3/internal/http2/Http2Connection;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Builder {
        private boolean client;
        public String connectionName;
        private Listener listener;
        private int pingIntervalMillis;
        private PushObserver pushObserver;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;

        public Builder(boolean r1) {
            this.client = r1;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public static /* synthetic */ Builder socket$default(Builder r1, Socket r2, String r3, BufferedSource r4, BufferedSink r5, int r6, Object r7) {
            BufferedSource r8 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r4, BufferedSource.class, "com.obric.memorydata.plugin");
            BufferedSink r9 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r5, BufferedSink.class, "com.obric.memorydata.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = Util.connectionName(r2);
        L6:
            if ((r6 & 4) == 0) goto L9;
            r8 = Okio.buffer(Okio.source(r2));
        L9:
            if ((r6 & 8) == 0) goto L12;
            r9 = Okio.buffer(Okio.sink(r2));
        L12:
            return r1.socket(r2, r3, r8, r9);
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final String getConnectionName$okhttp() {
            String r1 = this.connectionName;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
        L5:
            return r1;
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

        public final BufferedSink getSink$okhttp() {
            BufferedSink r1 = this.sink;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("sink");
        L5:
            return r1;
        }

        public final Socket getSocket$okhttp() {
            Socket r1 = this.socket;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("socket");
        L5:
            return r1;
        }

        public final BufferedSource getSource$okhttp() {
            BufferedSource r1 = this.source;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException(AILabCheckPermissionTask.KEY_SOURCE);
        L5:
            return r1;
        }

        public final Builder listener(Listener r4) {
            Intrinsics.checkParameterIsNotNull(r4, "listener");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).listener = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder pingIntervalMillis(int r4) {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).pingIntervalMillis = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder pushObserver(PushObserver r4) {
            PushObserver r5 = (PushObserver) ZeusTransformUtils.wrapperContextForParams(r4, PushObserver.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "pushObserver");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).pushObserver = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final void setClient$okhttp(boolean r1) {
            this.client = r1;
        }

        public final void setConnectionName$okhttp(String r2) {
            Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
            this.connectionName = r2;
        }

        public final void setListener$okhttp(Listener r2) {
            Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
            this.listener = r2;
        }

        public final void setPingIntervalMillis$okhttp(int r1) {
            this.pingIntervalMillis = r1;
        }

        public final void setPushObserver$okhttp(PushObserver r3) {
            PushObserver r4 = (PushObserver) ZeusTransformUtils.wrapperContextForParams(r3, PushObserver.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
            this.pushObserver = r4;
        }

        public final void setSink$okhttp(BufferedSink r3) {
            BufferedSink r4 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSink.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
            this.sink = r4;
        }

        public final void setSocket$okhttp(Socket r2) {
            Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
            this.socket = r2;
        }

        public final void setSource$okhttp(BufferedSource r3) {
            BufferedSource r4 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSource.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "<set-?>");
            this.source = r4;
        }

        public final Builder socket(Socket r8) {
            return socket$default(this, r8, null, null, null, 14, null);
        }

        public final Builder socket(Socket r8, String r9) {
            return socket$default(this, r8, r9, null, null, 12, null);
        }

        public final Builder socket(Socket r8, String r9, BufferedSource r10) {
            return socket$default(this, r8, r9, (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r10, BufferedSource.class, "com.obric.memorydata.plugin"), null, 8, null);
        }

        public final Builder socket(Socket r4, String r5, BufferedSource r6, BufferedSink r7) {
            BufferedSource r8 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r6, BufferedSource.class, "com.obric.memorydata.plugin");
            BufferedSink r9 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r7, BufferedSink.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "socket");
            Intrinsics.checkParameterIsNotNull(r5, "connectionName");
            Intrinsics.checkParameterIsNotNull(r8, AILabCheckPermissionTask.KEY_SOURCE);
            Intrinsics.checkParameterIsNotNull(r9, "sink");
            Builder r1 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r1.socket = r4;
            r1.connectionName = r5;
            r1.source = r8;
            r1.sink = r9;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "()V", "OKHTTP_CLIENT_WINDOW_SIZE", "", "listenerExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "()V", "onSettings", "", WsConstants.KEY_CONNECTION, "Lokhttp3/internal/http2/Http2Connection;", "onStream", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "Lokhttp3/internal/http2/Http2Stream;", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static abstract class Listener {
        public static final Companion Companion = null;
        public static final Listener REFUSE_INCOMING_STREAMS = null;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener$Companion;", "", "()V", "REFUSE_INCOMING_STREAMS", "Lokhttp3/internal/http2/Http2Connection$Listener;", "okhttp"}, k = 1, mv = {1, 1, 15})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
            REFUSE_INCOMING_STREAMS = (Listener) ZeusTransformUtils.preCheckCast(new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1(), Listener.class, "com.obric.memorydata.plugin");
        }

        public Listener() {
        }

        public void onSettings(Http2Connection r1) {
            Intrinsics.checkParameterIsNotNull(r1, WsConstants.KEY_CONNECTION);
        }

        public abstract void onStream(Http2Stream r1);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J8\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J(\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0016J \u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0016J.\u0010$\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J \u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fH\u0016J(\u0010-\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\u0017H\u0016J&\u00101\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0018\u00104\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u00105\u001a\u00020\tH\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u00106\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0014H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u00068"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Ljava/lang/Runnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "reader", "Lokhttp3/internal/http2/Http2Reader;", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "ackSettings", "", "alternateService", "streamId", "", "origin", "", "protocol", "Lokio/ByteString;", "host", "port", "maxAge", "", "applyAndAckSettings", "clearPrevious", "", "settings", "Lokhttp3/internal/http2/Settings;", "data", "inFinished", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", XSDatatype.FACET_LENGTH, "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "run", "windowUpdate", "windowSizeIncrement", "okhttp"}, k = 1, mv = {1, 1, 15})
    public final class ReaderRunnable implements Runnable, Http2Reader.Handler {
        private final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(Http2Connection r2, Http2Reader r3) {
            Intrinsics.checkParameterIsNotNull(r3, "reader");
            this.this$0 = r2;
            this.reader = r3;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int r1, String r2, ByteString r3, String r4, int r5, long r6) {
            Intrinsics.checkParameterIsNotNull(r2, "origin");
            Intrinsics.checkParameterIsNotNull(r3, "protocol");
            Intrinsics.checkParameterIsNotNull(r4, "host");
        }

        public final void applyAndAckSettings(boolean r7, Settings r8) {
            Intrinsics.checkParameterIsNotNull(r8, "settings");
            Http2Stream[] r2 = null;
            Http2Stream[] r0 = (Http2Stream[]) ZeusTransformUtils.preCheckCast(null, Http2Stream[].class, "com.obric.memorydata.plugin");
            Http2Writer r1 = this.this$0.getWriter();
            monitor-enter(r1);
            Http2Connection r3 = this.this$0;     // Catch: Throwable -> L47
            monitor-enter(r3);     // Catch: Throwable -> L47
            int r4 = this.this$0.getPeerSettings().getInitialWindowSize();     // Catch: Throwable -> L44
            if (r7 == false) goto L9;
            this.this$0.getPeerSettings().clear();     // Catch: Throwable -> L44
        L9:
            this.this$0.getPeerSettings().merge(r8);     // Catch: Throwable -> L44
            int r9 = this.this$0.getPeerSettings().getInitialWindowSize();     // Catch: Throwable -> L44
            int r5 = 0;
            if (r9 == (-1)) goto L20;
            if (r9 == r4) goto L20;
            long r10 = r9 - r4;     // Catch: Throwable -> L44
            if ((!this.this$0.getStreams$okhttp().isEmpty()) == false) goto L19;
            Object[] r6 = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);     // Catch: Throwable -> L44
            if (r6 == null) goto L18;
            r2 = (Http2Stream[]) ZeusTransformUtils.preCheckCast(r6, Http2Stream[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
            goto L19
        L18:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L44
        L19:
            r0 = r2;
        L21:
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L44
            monitor-exit(r3);     // Catch: Throwable -> L47
            this.this$0.getWriter().applyAndAckSettings(this.this$0.getPeerSettings());     // Catch: IOException -> L25 Throwable -> L47
        L27:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L47
            monitor-exit(r1);
            if (r0 == null) goto L42;
            if (r0 != null) goto L32;
            Intrinsics.throwNpe();
        L32:
            int r13 = r0.length;
        L33:
            if (r5 >= r13) goto L42;
            Http2Stream r14 = r0[r5];
            monitor-enter(r14);
            r14.addBytesToWriteWindow(r10);     // Catch: Throwable -> L39
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L39
            monitor-exit(r14);
            r5 = r5 + 1;
        L39:
            th = move-exception;
            throw th;
        L42:
            Executor r16 = (Executor) ZeusTransformUtils.preCheckCast(Http2Connection.access$getListenerExecutor$cp(), Executor.class, "com.obric.memorydata.plugin");
            final String r17 = "OkHttp " + this.this$0.getConnectionName$okhttp() + " settings";
            r16.execute((Runnable) ZeusTransformUtils.preCheckCast(new Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$execute$1(r17, this), Runnable.class, "com.obric.memorydata.plugin"));
            return;
        L25:
            e = move-exception;
            Http2Connection.access$failConnection(this.this$0, e);     // Catch: Throwable -> L47
        L20:
            r10 = 0;
        L44:
            th = move-exception;
            throw th;     // Catch: Throwable -> L47
        L47:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean r3, int r4, BufferedSource r5, int r6) {
            BufferedSource r7 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r5, BufferedSource.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r7, AILabCheckPermissionTask.KEY_SOURCE);
            if (this.this$0.pushedStream$okhttp(r4) == false) goto L6;
            this.this$0.pushDataLater$okhttp(r4, r7, r6, r3);
            return;
        L6:
            Http2Stream r0 = this.this$0.getStream(r4);
            if (r0 != null) goto L10;
            this.this$0.writeSynResetLater$okhttp(r4, ErrorCode.PROTOCOL_ERROR);
            long r8 = r6;
            this.this$0.updateConnectionFlowControl$okhttp(r8);
            r7.skip(r8);
            return;
        L10:
            r0.receiveData(r7, r6);
            if (r3 == false) goto L14;
            r0.receiveHeaders(Util.EMPTY_HEADERS, true);
            return;
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int r4, ErrorCode r5, ByteString r6) {
            Intrinsics.checkParameterIsNotNull(r5, "errorCode");
            Intrinsics.checkParameterIsNotNull(r6, "debugData");
            r6.size();
            Http2Connection r7 = this.this$0;
            monitor-enter(r7);
            int r0 = 0;
            Object[] r8 = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);     // Catch: Throwable -> L19
            if (r8 == null) goto L18;
            Http2Stream[] r9 = (Http2Stream[]) ZeusTransformUtils.preCheckCast(r8, Http2Stream[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            this.this$0.setShutdown$okhttp(true);     // Catch: Throwable -> L19
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L19
            monitor-exit(r7);
            int r10 = r9.length;
        L9:
            if (r0 >= r10) goto L16;
            Http2Stream r2 = r9[r0];
            if (r2.getId() <= r4) goto L15;
            if (r2.isLocallyInitiated() == false) goto L15;
            r2.receiveRstStream(ErrorCode.REFUSED_STREAM);
            this.this$0.removeStream$okhttp(r2.getId());
        L15:
            r0 = r0 + 1;
            goto L9
        L16:
            return;
        L18:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(final boolean r16, final int r17, int r18, List<Header> r19) {
            final List<Header> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r9, "headerBlock");
            if (this.this$0.pushedStream$okhttp(r17) == false) goto L6;
            this.this$0.pushHeadersLater$okhttp(r17, r9, r16);
            return;
        L6:
            Http2Connection r10 = this.this$0;
            monitor-enter(r10);
            final Http2Stream r11 = this.this$0.getStream(r17);     // Catch: Throwable -> L29
            if (r11 == null) goto L11;
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L29
            monitor-exit(r10);
            r11.receiveHeaders(Util.toHeaders(r9), r16);
            return;
        L11:
            if (this.this$0.isShutdown() == false) goto L15;
            monitor-exit(r10);
            return;
        L15:
            if (r17 > this.this$0.getLastGoodStreamId$okhttp()) goto L19;
            monitor-exit(r10);
            return;
        L19:
            if ((r17 % 2) != (this.this$0.getNextStreamId$okhttp() % 2)) goto L22;
            monitor-exit(r10);
            return;
        L22:
            final Http2Stream r12 = new Http2Stream(r17, this.this$0, false, r16, Util.toHeaders(r9));     // Catch: Throwable -> L29
            this.this$0.setLastGoodStreamId$okhttp(r17);     // Catch: Throwable -> L29
            this.this$0.getStreams$okhttp().put(Integer.valueOf(r17), r12);     // Catch: Throwable -> L29
            Executor r13 = (Executor) ZeusTransformUtils.preCheckCast(Http2Connection.access$getListenerExecutor$cp(), Executor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
            final String r2 = "OkHttp " + this.this$0.getConnectionName$okhttp() + " stream " + r17;     // Catch: Throwable -> L29
            r13.execute((Runnable) ZeusTransformUtils.preCheckCast(new Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1(r2, r12, this, r11, r17, r9, r16), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L29
            monitor-exit(r10);
            return;
        L29:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean r3, final int r4, final int r5) {
            if (r3 == false) goto L15;
            Http2Connection r6 = this.this$0;
            monitor-enter(r6);
            Http2Connection.access$setAwaitingPong$p(this.this$0, false);     // Catch: Throwable -> L12
            Http2Connection r2 = this.this$0;     // Catch: Throwable -> L12
            if (r2 == null) goto L11;
            ZeusTransformUtils.preCheckCast(r2, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L12
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r6);
            return;
        L11:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L15:
            Executor r8 = (Executor) ZeusTransformUtils.preCheckCast(Http2Connection.access$getWriterExecutor$p(this.this$0), Executor.class, "com.obric.memorydata.plugin");
            final String r0 = "OkHttp " + this.this$0.getConnectionName$okhttp() + " ping";
            r8.execute((Runnable) ZeusTransformUtils.preCheckCast(new Http2Connection$ReaderRunnable$ping$$inlined$tryExecute$1(r0, this, r4, r5), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: RejectedExecutionException -> L18
            return;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int r1, int r2, int r3, boolean r4) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int r2, int r3, List<Header> r4) {
            List<Header> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(r3, r5);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int r2, ErrorCode r3) {
            Intrinsics.checkParameterIsNotNull(r3, "errorCode");
            boolean r0 = this.this$0.pushedStream$okhttp(r2);
            Http2Connection r1 = this.this$0;
            if (r0 == false) goto L6;
            r1.pushResetLater$okhttp(r2, r3);
            return;
        L6:
            Http2Stream r4 = r1.removeStream$okhttp(r2);
            if (r4 == null) goto L10;
            r4.receiveRstStream(r3);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Class, java.lang.Class<java.io.Closeable>] */
        /* JADX WARN: Type inference failed for: r0v6, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r7v7, types: [java.io.Closeable] */
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
        @Override // java.lang.Runnable
        public void run() {
            ErrorCode r0 = ErrorCode.INTERNAL_ERROR;
            ErrorCode r1 = ErrorCode.INTERNAL_ERROR;
            IOException e = (IOException) ZeusTransformUtils.preCheckCast(null, IOException.class, "com.obric.memorydata.plugin");
            this.reader.readConnectionPreface((Http2Reader.Handler) ZeusTransformUtils.preCheckCast(this, Http2Reader.Handler.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9 IOException -> L11
        L5:
            if (this.reader.nextFrame(false, (Http2Reader.Handler) ZeusTransformUtils.preCheckCast(this, Http2Reader.Handler.class, "com.obric.memorydata.plugin")) == true) goto L5;
            r0 = ErrorCode.NO_ERROR;     // Catch: Throwable -> L9 IOException -> L11
            r1 = ErrorCode.CANCEL;     // Catch: Throwable -> L9 IOException -> L11
            ErrorCode r2 = r0;
        L13:
            this.this$0.close$okhttp(r2, r1, e);
            r0 = Closeable.class;
            ReaderRunnable this = (Closeable) ZeusTransformUtils.preCheckCast(this.reader, r0, "com.obric.memorydata.plugin");
            Util.closeQuietly(this);
            return;
        L9:
            th = move-exception;
            this.this$0.close$okhttp(r0, r1, e);
            Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(this.reader, Closeable.class, "com.obric.memorydata.plugin"));
            throw th;
        L11:
            e = e;
            ErrorCode r3 = ErrorCode.PROTOCOL_ERROR;     // Catch: Throwable -> L9
            r1 = ErrorCode.PROTOCOL_ERROR;     // Catch: Throwable -> L9
            r2 = r3;
            goto L13
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean r5, final Settings r6) {
            Intrinsics.checkParameterIsNotNull(r6, "settings");
            Executor r0 = (Executor) ZeusTransformUtils.preCheckCast(Http2Connection.access$getWriterExecutor$p(this.this$0), Executor.class, "com.obric.memorydata.plugin");
            final String r1 = "OkHttp " + this.this$0.getConnectionName$okhttp() + " ACK Settings";
            r0.execute((Runnable) ZeusTransformUtils.preCheckCast(new Http2Connection$ReaderRunnable$settings$$inlined$tryExecute$1(r1, this, r5, r6), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: RejectedExecutionException -> L5
            return;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int r4, long r5) {
            if (r4 != 0) goto L15;
            Http2Connection r6 = this.this$0;
            monitor-enter(r6);
            Http2Connection r0 = this.this$0;     // Catch: Throwable -> L12
            Http2Connection.access$setWriteBytesMaximum$p(r0, r0.getWriteBytesMaximum() + r5);     // Catch: Throwable -> L12
            Http2Connection r3 = this.this$0;     // Catch: Throwable -> L12
            if (r3 == null) goto L11;
            ZeusTransformUtils.preCheckCast(r3, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L12
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r6);
            return;
        L11:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L15:
            Http2Stream r8 = this.this$0.getStream(r4);
            if (r8 == null) goto L24;
            monitor-enter(r8);
            r8.addBytesToWriteWindow(r5);     // Catch: Throwable -> L21
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r8);
            return;
        L21:
            th = move-exception;
            throw th;
        }
    }

    static {
        Companion = new Companion(null);
        listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new SynchronousQueue(), BlockingQueue.class, "com.obric.memorydata.plugin"), Util.threadFactory("OkHttp Http2Connection", true));
    }

    public Http2Connection(Builder r18) {
        Intrinsics.checkParameterIsNotNull(r18, "builder");
        boolean r1 = r18.getClient$okhttp();
        this.client = r1;
        this.listener = r18.getListener$okhttp();
        this.streams = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        String r3 = r18.getConnectionName$okhttp();
        this.connectionName = r3;
        if (r18.getClient$okhttp() == false) goto L5;
        int r4 = 3;
    L6:
        this.nextStreamId = r4;
        ScheduledThreadPoolExecutor r6 = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", new Object[]{r3}), false));
        this.writerExecutor = r6;
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new LinkedBlockingQueue(), BlockingQueue.class, "com.obric.memorydata.plugin"), Util.threadFactory(Util.format("OkHttp %s Push Observer", new Object[]{r3}), true));
        this.pushObserver = r18.getPushObserver$okhttp();
        Settings r5 = new Settings();
        if (r18.getClient$okhttp() == false) goto L9;
        r5.set(7, 16777216);
    L9:
        this.okHttpSettings = r5;
        Settings r7 = new Settings();
        r7.set(7, 65535);
        r7.set(5, 16384);
        this.peerSettings = r7;
        this.writeBytesMaximum = r7.getInitialWindowSize();
        this.socket = r18.getSocket$okhttp();
        this.writer = new Http2Writer(r18.getSink$okhttp(), r1);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(r18.getSource$okhttp(), r1));
        this.currentPushRequests = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (r18.getPingIntervalMillis$okhttp() == 0) goto L13;
        r6.scheduleAtFixedRate((Runnable) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Runnable.class, "com.obric.memorydata.plugin"), r18.getPingIntervalMillis$okhttp(), r18.getPingIntervalMillis$okhttp(), TimeUnit.MILLISECONDS);
        return;
    L13:
        return;
    L5:
        r4 = 2;
        goto L6
    }

    public static final /* synthetic */ void access$failConnection(Http2Connection r0, IOException r1) {
        r0.failConnection(r1);
    }

    public static final /* synthetic */ boolean access$getAwaitingPong$p(Http2Connection r0) {
        return r0.awaitingPong;
    }

    public static final /* synthetic */ Set access$getCurrentPushRequests$p(Http2Connection r0) {
        return r0.currentPushRequests;
    }

    public static final /* synthetic */ ThreadPoolExecutor access$getListenerExecutor$cp() {
        return listenerExecutor;
    }

    public static final /* synthetic */ PushObserver access$getPushObserver$p(Http2Connection r0) {
        return r0.pushObserver;
    }

    public static final /* synthetic */ long access$getWriteBytesMaximum$p(Http2Connection r2) {
        return r2.writeBytesMaximum;
    }

    public static final /* synthetic */ ScheduledThreadPoolExecutor access$getWriterExecutor$p(Http2Connection r0) {
        return r0.writerExecutor;
    }

    public static final /* synthetic */ void access$setAwaitingPong$p(Http2Connection r0, boolean r1) {
        r0.awaitingPong = r1;
    }

    public static final /* synthetic */ void access$setWriteBytesMaximum$p(Http2Connection r0, long r1) {
        r0.writeBytesMaximum = r1;
    }

    private final void failConnection(IOException r3) {
        close$okhttp(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, r3);
    }

    private final Http2Stream newStream(int r11, List<Header> r12, boolean r13) {
        List<Header> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        boolean r6 = !r13;
        Http2Writer r7 = this.writer;
        monitor-enter(r7);
        monitor-enter(this);     // Catch: Throwable -> L41
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L6:
        if (this.nextStreamId <= 1073741823) goto L9;
        shutdown(ErrorCode.REFUSED_STREAM);     // Catch: Throwable -> L38
    L9:
        if (this.isShutdown == true) goto L37;
        int r8 = this.nextStreamId;     // Catch: Throwable -> L38
        this.nextStreamId = r8 + 2;     // Catch: Throwable -> L38
        Http2Stream r9 = new Http2Stream(r8, this, r6, false, null);     // Catch: Throwable -> L38
        if (r13 == true) goto L13;
    L18:
        boolean r15 = true;
    L20:
        if (r9.isOpen() == false) goto L22;
        this.streams.put(Integer.valueOf(r8), r9);     // Catch: Throwable -> L38
    L22:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(this);     // Catch: Throwable -> L41
        if (r11 != 0) goto L27;
        this.writer.headers(r6, r8, r14);     // Catch: Throwable -> L41
    L29:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r7);
        if (r15 == false) goto L33;
        this.writer.flush();
    L33:
        return r9;
    L27:
        if ((true ^ this.client) == false) goto L35;
        this.writer.pushPromise(r11, r8, r14);     // Catch: Throwable -> L41
        goto L29
    L35:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
    L13:
        if (this.writeBytesTotal >= this.writeBytesMaximum) goto L18;
        if (r9.getWriteBytesTotal() >= r9.getWriteBytesMaximum()) goto L18;
        r15 = false;
        goto L20
    L37:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ConnectionShutdownException(), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L38
    L41:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void start$default(Http2Connection r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.start(r1);
    }

    public final synchronized void awaitPong() {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.awaitingPong == false) goto L7;
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").wait();     // Catch: Throwable -> L9
        goto L12
    L7:
        monitor-exit(this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode r4, ErrorCode r5, IOException r6) {
        Intrinsics.checkParameterIsNotNull(r4, "connectionCode");
        Intrinsics.checkParameterIsNotNull(r5, "streamCode");
        Thread.holdsLock(this);
        shutdown(r4);     // Catch: IOException -> L28
    L4:
        Http2Stream[] r7 = (Http2Stream[]) ZeusTransformUtils.preCheckCast(null, Http2Stream[].class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        int r1 = 0;
        if ((!this.streams.isEmpty()) == false) goto L13;
        Object[] r8 = this.streams.values().toArray(new Http2Stream[0]);     // Catch: Throwable -> L25
        if (r8 == null) goto L12;
        r7 = (Http2Stream[]) ZeusTransformUtils.preCheckCast(r8, Http2Stream[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        this.streams.clear();     // Catch: Throwable -> L25
        goto L13
    L12:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L25
    L13:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(this);
        if (r7 == null) goto L37;
        int r2 = r7.length;
    L17:
        if (r1 >= r2) goto L37;
        r7[r1].close(r5, r6);     // Catch: IOException -> L29
    L20:
        r1 = r1 + 1;
    L37:
        this.writer.close();     // Catch: IOException -> L30
    L34:
        this.socket.close();     // Catch: IOException -> L31
    L23:
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public final void flush() {
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

    public final synchronized Http2Stream getStream(int r3) {
        monitor-enter(this);
        Http2Stream r4 = (Http2Stream) ZeusTransformUtils.preCheckCast(this.streams.get(Integer.valueOf(r3)), Http2Stream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
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

    public final synchronized boolean isShutdown() {
        monitor-enter(this);
        boolean r0 = this.isShutdown;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int maxConcurrentStreams() {
        monitor-enter(this);
        int r0 = this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final Http2Stream newStream(List<Header> r3, boolean r4) {
        List<Header> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "requestHeaders");
        return newStream(0, r5, r4);
    }

    public final synchronized int openStreamCount() {
        monitor-enter(this);
        int r0 = this.streams.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void pushDataLater$okhttp(final int r10, BufferedSource r11, final int r12, final boolean r13) {
        BufferedSource r14 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r11, BufferedSource.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r14, AILabCheckPermissionTask.KEY_SOURCE);
        final Buffer r6 = new Buffer();
        long r2 = r12;
        r14.require(r2);
        r14.read(r6, r2);
        if (this.isShutdown == true) goto L6;
        Executor r15 = (Executor) ZeusTransformUtils.preCheckCast(this.pushExecutor, Executor.class, "com.obric.memorydata.plugin");
        final String r3 = "OkHttp " + this.connectionName + " Push Data[" + r10 + ']';
        r15.execute((Runnable) ZeusTransformUtils.preCheckCast(new Http2Connection$pushDataLater$$inlined$execute$1(r3, this, r10, r6, r12, r13), Runnable.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void pushHeadersLater$okhttp(final int r9, List<Header> r10, final boolean r11) {
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "requestHeaders");
        if (this.isShutdown == true) goto L10;
        Executor r12 = (Executor) ZeusTransformUtils.preCheckCast(this.pushExecutor, Executor.class, "com.obric.memorydata.plugin");
        final String r3 = "OkHttp " + this.connectionName + " Push Headers[" + r9 + ']';
        r12.execute((Runnable) ZeusTransformUtils.preCheckCast(new Http2Connection$pushHeadersLater$$inlined$tryExecute$1(r3, this, r9, r6, r11), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: RejectedExecutionException -> L7
        return;
    L11:
        return;
    }

    public final void pushRequestLater$okhttp(final int r4, List<Header> r5) {
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "requestHeaders");
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.currentPushRequests.contains(Integer.valueOf(r4)) == false) goto L9;
        writeSynResetLater$okhttp(r4, ErrorCode.PROTOCOL_ERROR);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L9:
        this.currentPushRequests.add(Integer.valueOf(r4));     // Catch: Throwable -> L16
        monitor-exit(this);
        if (this.isShutdown == true) goto L23;
        Executor r0 = (Executor) ZeusTransformUtils.preCheckCast(this.pushExecutor, Executor.class, "com.obric.memorydata.plugin");
        final String r1 = "OkHttp " + this.connectionName + " Push Request[" + r4 + ']';
        r0.execute((Runnable) ZeusTransformUtils.preCheckCast(new Http2Connection$pushRequestLater$$inlined$tryExecute$1(r1, this, r4, r6), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: RejectedExecutionException -> L19
        return;
    L24:
        return;
    }

    public final void pushResetLater$okhttp(final int r5, final ErrorCode r6) {
        Intrinsics.checkParameterIsNotNull(r6, "errorCode");
        if (this.isShutdown == true) goto L6;
        Executor r0 = (Executor) ZeusTransformUtils.preCheckCast(this.pushExecutor, Executor.class, "com.obric.memorydata.plugin");
        final String r1 = "OkHttp " + this.connectionName + " Push Reset[" + r5 + ']';
        r0.execute((Runnable) ZeusTransformUtils.preCheckCast(new Http2Connection$pushResetLater$$inlined$execute$1(r1, this, r5, r6), Runnable.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final Http2Stream pushStream(int r3, List<Header> r4, boolean r5) {
        List<Header> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "requestHeaders");
        if ((!this.client) == false) goto L7;
        return newStream(r3, r6, r5);
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Client cannot push requests.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final boolean pushedStream$okhttp(int r1) {
        if (r1 != 0) goto L5;
    L7:
        return false;
    L5:
        if ((r1 & 1) != 0) goto L7;
        return true;
    }

    public final synchronized Http2Stream removeStream$okhttp(int r3) {
        monitor-enter(this);
        Http2Stream r4 = (Http2Stream) ZeusTransformUtils.preCheckCast(this.streams.remove(Integer.valueOf(r3)), Http2Stream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public final void setLastGoodStreamId$okhttp(int r1) {
        this.lastGoodStreamId = r1;
    }

    public final void setNextStreamId$okhttp(int r1) {
        this.nextStreamId = r1;
    }

    public final void setSettings(Settings r4) {
        Intrinsics.checkParameterIsNotNull(r4, "settings");
        Http2Writer r0 = this.writer;
        monitor-enter(r0);
        monitor-enter(this);     // Catch: Throwable -> L17
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L6:
        if (this.isShutdown == true) goto L13;
        this.okHttpSettings.merge(r4);     // Catch: Throwable -> L14
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L17
        this.writer.settings(r4);     // Catch: Throwable -> L17
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r0);
        return;
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ConnectionShutdownException(), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L17:
        th = move-exception;
        throw th;
    }

    public final void setShutdown$okhttp(boolean r1) {
        this.isShutdown = r1;
    }

    public final void shutdown(ErrorCode r4) {
        Intrinsics.checkParameterIsNotNull(r4, "statusCode");
        Http2Writer r0 = this.writer;
        monitor-enter(r0);
        monitor-enter(this);     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L6:
        if (this.isShutdown == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L11:
        this.isShutdown = true;     // Catch: Throwable -> L16
        int r1 = this.lastGoodStreamId;     // Catch: Throwable -> L16
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L19
        this.writer.goAway(r1, r4, Util.EMPTY_BYTE_ARRAY);     // Catch: Throwable -> L19
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void start() {
        start$default(this, false, 1, null);
    }

    public final void start(boolean r6) {
        if (r6 == false) goto L6;
        this.writer.connectionPreface();
        this.writer.settings(this.okHttpSettings);
        int r7 = this.okHttpSettings.getInitialWindowSize();
        if (r7 == 65535) goto L6;
        this.writer.windowUpdate(0, r7 - 65535);
    L6:
        new Thread((Runnable) ZeusTransformUtils.preCheckCast(this.readerRunnable, Runnable.class, "com.obric.memorydata.plugin"), "OkHttp " + this.connectionName).start();
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long r3) {
        monitor-enter(this);
        long r0 = this.readBytesTotal + r3;     // Catch: Throwable -> L8
        this.readBytesTotal = r0;     // Catch: Throwable -> L8
        long r1 = r0 - this.readBytesAcknowledged;     // Catch: Throwable -> L8
        if (r1 < (this.okHttpSettings.getInitialWindowSize() / 2)) goto L6;
        writeWindowUpdateLater$okhttp(0, r1);     // Catch: Throwable -> L8
        this.readBytesAcknowledged += r1;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void writeData(int r10, boolean r11, Buffer r12, long r13) {
        if (r13 != 0) goto L7;
        this.writer.data(r11, r10, r12, 0);
        return;
    L7:
        if (r13 <= 0) goto L33;
        Ref.IntRef r2 = new Ref.IntRef();
        monitor-enter(this);
    L34:
        long r4 = this.writeBytesTotal;     // Catch: Throwable -> L27 InterruptedException -> L29
        long r6 = this.writeBytesMaximum;     // Catch: Throwable -> L27 InterruptedException -> L29
        if (r4 < r6) goto L18;
        if (this.streams.containsKey(Integer.valueOf(r10)) == false) goto L16;
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").wait();     // Catch: Throwable -> L27 InterruptedException -> L29
        goto L34
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("stream closed"), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27 InterruptedException -> L29
    L18:
        r2.element = (int) Math.min(r13, r6 - r4);     // Catch: Throwable -> L27
        r2.element = Math.min(r2.element, this.writer.maxDataLength());     // Catch: Throwable -> L27
        this.writeBytesTotal += (long) r2.element;     // Catch: Throwable -> L27
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(this);
        r13 = r13 - ((long) r2.element);
        Http2Writer r7 = this.writer;
        if (r11 == true) goto L23;
    L25:
        boolean r8 = false;
    L26:
        r7.data(r8, r10, r12, r2.element);
        goto L7
    L23:
        if (r13 != 0) goto L25;
        r8 = true;
    L27:
        th = move-exception;
        throw th;
    L29:
        Thread.currentThread().interrupt();     // Catch: Throwable -> L27
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new InterruptedIOException(), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
    }

    public final void writeHeaders$okhttp(int r3, boolean r4, List<Header> r5) {
        List<Header> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "alternating");
        this.writer.headers(r4, r3, r6);
    }

    public final void writePing(boolean r3, int r4, int r5) {
        if (r3 == true) goto L19;
        monitor-enter(this);
        boolean r0 = this.awaitingPong;     // Catch: Throwable -> L9
        this.awaitingPong = true;     // Catch: Throwable -> L9
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(this);
        if (r0 == false) goto L19;
        failConnection(null);
        return;
    L9:
        th = move-exception;
        throw th;
    L19:
        this.writer.ping(r3, r4, r5);     // Catch: IOException -> L14
        return;
    L14:
        e = move-exception;
        failConnection(e);
    }

    public final void writePingAndAwaitPong() {
        writePing(false, 1330343787, -257978967);
        awaitPong();
    }

    public final void writeSynReset$okhttp(int r2, ErrorCode r3) {
        Intrinsics.checkParameterIsNotNull(r3, "statusCode");
        this.writer.rstStream(r2, r3);
    }

    public final void writeSynResetLater$okhttp(final int r5, final ErrorCode r6) {
        Intrinsics.checkParameterIsNotNull(r6, "errorCode");
        Executor r0 = (Executor) ZeusTransformUtils.preCheckCast(this.writerExecutor, Executor.class, "com.obric.memorydata.plugin");
        final String r1 = "OkHttp " + this.connectionName + " stream " + r5;
        r0.execute((Runnable) ZeusTransformUtils.preCheckCast(new Http2Connection$writeSynResetLater$$inlined$tryExecute$1(r1, this, r5, r6), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: RejectedExecutionException -> L5
        return;
    }

    public final void writeWindowUpdateLater$okhttp(final int r10, final long r11) {
        Executor r0 = (Executor) ZeusTransformUtils.preCheckCast(this.writerExecutor, Executor.class, "com.obric.memorydata.plugin");
        final String r4 = "OkHttp Window Update " + this.connectionName + " stream " + r10;
        r0.execute((Runnable) ZeusTransformUtils.preCheckCast(new Http2Connection$writeWindowUpdateLater$$inlined$tryExecute$1(r4, this, r10, r11), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: RejectedExecutionException -> L5
        return;
    }
}
