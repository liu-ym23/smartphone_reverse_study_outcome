package okhttp3.internal.http2;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010 \u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010!\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J(\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lokhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "client", "", "(Lokio/BufferedSource;Z)V", "continuation", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "hpackReader", "Lokhttp3/internal/http2/Hpack$Reader;", IslandSession.REOPEN_VALUE_CLOSE, "", "nextFrame", "requireSettings", "handler", "Lokhttp3/internal/http2/Http2Reader$Handler;", "readConnectionPreface", "readData", XSDatatype.FACET_LENGTH, "", "flags", "streamId", "readGoAway", "readHeaderBlock", "", "Lokhttp3/internal/http2/Header;", "padding", "readHeaders", "readPing", "readPriority", "readPushPromise", "readRstStream", "readSettings", "readWindowUpdate", "Companion", "ContinuationSource", "Handler", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Http2Reader implements Closeable {
    public static final Companion Companion = null;
    private static final Logger logger = null;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final BufferedSource source;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Companion;", "", "()V", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "lengthWithoutPadding", "", XSDatatype.FACET_LENGTH, "flags", "padding", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Logger getLogger() {
            return Http2Reader.access$getLogger$cp();
        }

        public final int lengthWithoutPadding(int r2, int r3, int r4) {
            if ((r3 & 8) == 0) goto L5;
            r2 = r2 - 1;
        L5:
            if (r4 > r2) goto L9;
            return r2 - r4;
        L9:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("PROTOCOL_ERROR padding " + r4 + " > remaining length " + r2), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n¨\u0006!"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lokio/Source;", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "flags", "", "getFlags", "()I", "setFlags", "(I)V", "left", "getLeft", "setLeft", XSDatatype.FACET_LENGTH, "getLength", "setLength", "padding", "getPadding", "setPadding", "streamId", "getStreamId", "setStreamId", IslandSession.REOPEN_VALUE_CLOSE, "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "readContinuationHeader", LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final BufferedSource source;
        private int streamId;

        public ContinuationSource(BufferedSource r3) {
            BufferedSource r4 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSource.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, AILabCheckPermissionTask.KEY_SOURCE);
            this.source = r4;
        }

        private final void readContinuationHeader() {
            int r0 = this.streamId;
            int r1 = Util.readMedium(this.source);
            this.left = r1;
            this.length = r1;
            int r2 = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            if (Http2Reader.Companion.getLogger().isLoggable(Level.FINE) == false) goto L5;
            Http2Reader.Companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, r2, this.flags));
        L5:
            int r3 = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = r3;
            if (r2 != 9) goto L12;
            if (r3 != r0) goto L10;
            return;
        L10:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_CONTINUATION streamId changed"), Throwable.class, "com.obric.memorydata.plugin"));
        L12:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException(r2 + " != TYPE_CONTINUATION"), Throwable.class, "com.obric.memorydata.plugin"));
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // okio.Source
        public long read(Buffer r7, long r8) {
            Intrinsics.checkParameterIsNotNull(r7, "sink");
        L3:
            int r0 = this.left;
            if (r0 != 0) goto L9;
            this.source.skip(this.padding);
            this.padding = 0;
            if ((this.flags & 4) != 0) goto L7;
            readContinuationHeader();
            goto L3
        L7:
            return -1;
        L9:
            long r9 = this.source.read(r7, Math.min(r8, r0));
            if (r9 != (-1)) goto L12;
            return -1;
        L12:
            this.left -= (int) r9;
            return r9;
        }

        public final void setFlags(int r1) {
            this.flags = r1;
        }

        public final void setLeft(int r1) {
            this.left = r1;
        }

        public final void setLength(int r1) {
            this.length = r1;
        }

        public final void setPadding(int r1) {
            this.padding = r1;
        }

        public final void setStreamId(int r1) {
            this.streamId = r1;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J8\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH&J.\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J \u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H&J(\u0010#\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0011H&J&\u0010'\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00112\u0006\u0010+\u001a\u00020-H&J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u000eH&¨\u00060"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Handler;", "", "ackSettings", "", "alternateService", "streamId", "", "origin", "", "protocol", "Lokio/ByteString;", "host", "port", "maxAge", "", "data", "inFinished", "", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", XSDatatype.FACET_LENGTH, "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "settings", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "windowUpdate", "windowSizeIncrement", "okhttp"}, k = 1, mv = {1, 1, 15})
    public interface Handler {
        void ackSettings();

        void alternateService(int r1, String r2, ByteString r3, String r4, int r5, long r6);

        void data(boolean r1, int r2, BufferedSource r3, int r4);

        void goAway(int r1, ErrorCode r2, ByteString r3);

        void headers(boolean r1, int r2, int r3, List<Header> r4);

        void ping(boolean r1, int r2, int r3);

        void priority(int r1, int r2, int r3, boolean r4);

        void pushPromise(int r1, int r2, List<Header> r3);

        void rstStream(int r1, ErrorCode r2);

        void settings(boolean r1, Settings r2);

        void windowUpdate(int r1, long r2);
    }

    static {
        Companion = new Companion(null);
        Logger r0 = Logger.getLogger(Http2.class.getName());
        Intrinsics.checkExpressionValueIsNotNull(r0, "Logger.getLogger(Http2::class.java.name)");
        logger = r0;
    }

    public Http2Reader(BufferedSource r9, boolean r10) {
        BufferedSource r11 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r9, BufferedSource.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r11, AILabCheckPermissionTask.KEY_SOURCE);
        this.source = r11;
        this.client = r10;
        ContinuationSource r12 = new ContinuationSource(r11);
        this.continuation = r12;
        this.hpackReader = new Hpack.Reader((Source) ZeusTransformUtils.preCheckCast(r12, Source.class, "com.obric.memorydata.plugin"), 4096, 0, 4, null);
    }

    public static final /* synthetic */ Logger access$getLogger$cp() {
        return logger;
    }

    private final void readData(Handler r6, int r7, int r8, int r9) {
        Handler r10 = (Handler) ZeusTransformUtils.wrapperContextForParams(r6, Handler.class, "com.obric.memorydata.plugin");
        if (r9 == 0) goto L21;
        int r2 = 0;
        boolean r3 = true;
        if ((r8 & 1) == 0) goto L7;
        boolean r0 = true;
    L9:
        if ((r8 & 32) != 0) goto L12;
        r3 = false;
    L12:
        if (r3 == true) goto L19;
        if ((r8 & 8) == 0) goto L16;
        r2 = Util.and(this.source.readByte(), 255);
    L16:
        r10.data(r0, r9, this.source, Companion.lengthWithoutPadding(r7, r8, r2));
        this.source.skip(r2);
        return;
    L19:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA"), Throwable.class, "com.obric.memorydata.plugin"));
    L7:
        r0 = false;
        goto L9
    L21:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void readGoAway(Handler r3, int r4, int r5, int r6) {
        Handler r7 = (Handler) ZeusTransformUtils.wrapperContextForParams(r3, Handler.class, "com.obric.memorydata.plugin");
        if (r4 < 8) goto L17;
        if (r6 != 0) goto L15;
        int r8 = this.source.readInt();
        int r1 = this.source.readInt();
        int r9 = r4 - 8;
        ErrorCode r10 = ErrorCode.Companion.fromHttp2(r1);
        if (r10 == null) goto L13;
        ByteString r0 = ByteString.EMPTY;
        if (r9 <= 0) goto L10;
        r0 = this.source.readByteString(r9);
    L10:
        r7.goAway(r8, r10, r0);
        return;
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_GOAWAY unexpected error code: " + r1), Throwable.class, "com.obric.memorydata.plugin"));
    L15:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_GOAWAY streamId != 0"), Throwable.class, "com.obric.memorydata.plugin"));
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_GOAWAY length < 8: " + r4), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final List<Header> readHeaderBlock(int r2, int r3, int r4, int r5) {
        this.continuation.setLeft(r2);
        ContinuationSource r6 = this.continuation;
        r6.setLength(r6.getLeft());
        this.continuation.setPadding(r3);
        this.continuation.setFlags(r4);
        this.continuation.setStreamId(r5);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler r4, int r5, int r6, int r7) {
        Handler r8 = (Handler) ZeusTransformUtils.wrapperContextForParams(r4, Handler.class, "com.obric.memorydata.plugin");
        if (r7 == 0) goto L17;
        int r1 = 0;
        if ((r6 & 1) == 0) goto L7;
        boolean r0 = true;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r1 = Util.and(this.source.readByte(), 255);
    L12:
        if ((r6 & 32) == 0) goto L14;
        readPriority(r8, r7);
        r5 = r5 - 5;
    L14:
        r8.headers(r0, r7, -1, readHeaderBlock(Companion.lengthWithoutPadding(r5, r6, r1), r1, r6, r7));
        return;
    L7:
        r0 = false;
        goto L9
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void readPing(Handler r3, int r4, int r5, int r6) {
        Handler r7 = (Handler) ZeusTransformUtils.wrapperContextForParams(r3, Handler.class, "com.obric.memorydata.plugin");
        if (r4 != 8) goto L14;
        if (r6 != 0) goto L12;
        int r8 = this.source.readInt();
        int r2 = this.source.readInt();
        boolean r9 = true;
        if ((r5 & 1) != 0) goto L9;
        r9 = false;
    L9:
        r7.ping(r9, r8, r2);
        return;
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_PING streamId != 0"), Throwable.class, "com.obric.memorydata.plugin"));
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_PING length != 8: " + r4), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void readPriority(Handler r5, int r6) {
        Handler r7 = (Handler) ZeusTransformUtils.wrapperContextForParams(r5, Handler.class, "com.obric.memorydata.plugin");
        int r0 = this.source.readInt();
        if ((((int) 2147483648L) & r0) == 0) goto L5;
        boolean r1 = true;
    L6:
        r7.priority(r6, r0 & Integer.MAX_VALUE, Util.and(this.source.readByte(), 255) + 1, r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final void readPriority(Handler r2, int r3, int r4, int r5) {
        Handler r6 = (Handler) ZeusTransformUtils.wrapperContextForParams(r2, Handler.class, "com.obric.memorydata.plugin");
        if (r3 != 5) goto L10;
        if (r5 == 0) goto L8;
        readPriority(r6, r5);
        return;
    L8:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_PRIORITY streamId == 0"), Throwable.class, "com.obric.memorydata.plugin"));
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_PRIORITY length: " + r3 + " != 5"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void readPushPromise(Handler r4, int r5, int r6, int r7) {
        Handler r8 = (Handler) ZeusTransformUtils.wrapperContextForParams(r4, Handler.class, "com.obric.memorydata.plugin");
        if (r7 == 0) goto L11;
        if ((r6 & 8) == 0) goto L7;
        int r0 = Util.and(this.source.readByte(), 255);
    L8:
        r8.pushPromise(r7, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(r5 - 4, r6, r0), r0, r6, r7));
        return;
    L7:
        r0 = 0;
        goto L8
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void readRstStream(Handler r2, int r3, int r4, int r5) {
        Handler r6 = (Handler) ZeusTransformUtils.wrapperContextForParams(r2, Handler.class, "com.obric.memorydata.plugin");
        if (r3 != 4) goto L14;
        if (r5 == 0) goto L12;
        int r1 = this.source.readInt();
        ErrorCode r7 = ErrorCode.Companion.fromHttp2(r1);
        if (r7 == null) goto L10;
        r6.rstStream(r5, r7);
        return;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_RST_STREAM unexpected error code: " + r1), Throwable.class, "com.obric.memorydata.plugin"));
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_RST_STREAM streamId == 0"), Throwable.class, "com.obric.memorydata.plugin"));
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_RST_STREAM length: " + r3 + " != 4"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void readSettings(Handler r9, int r10, int r11, int r12) {
        Handler r13 = (Handler) ZeusTransformUtils.wrapperContextForParams(r9, Handler.class, "com.obric.memorydata.plugin");
        if (r12 != 0) goto L52;
        if ((r11 & 1) == 0) goto L12;
        if (r10 != 0) goto L10;
        r13.ackSettings();
        return;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("FRAME_SIZE_ERROR ack frame should be empty!"), Throwable.class, "com.obric.memorydata.plugin"));
    L12:
        if ((r10 % 6) != 0) goto L50;
        Settings r14 = new Settings();
        IntProgression r15 = RangesKt.step((IntProgression) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r10), IntProgression.class, "com.obric.memorydata.plugin"), 6);
        int r2 = r15.getFirst();
        int r3 = r15.getLast();
        int r16 = r15.getStep();
        if (r16 < 0) goto L17;
        if (r2 <= r3) goto L18;
    L47:
        r13.settings(false, r14);
        return;
    L18:
        int r4 = Util.and(this.source.readShort(), 65535);
        int r5 = this.source.readInt();
        if (r4 != 2) goto L21;
        if (r5 == 0) goto L44;
        if (r5 == 1) goto L44;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"), Throwable.class, "com.obric.memorydata.plugin"));
    L44:
        r14.set(r4, r5);
        if (r2 == r3) goto L47;
        r2 = r2 + r16;
        goto L18
    L21:
        if (r4 == 3) goto L38;
        if (r4 != 4) goto L24;
        r4 = 7;
        if (r5 >= 0) goto L44;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"), Throwable.class, "com.obric.memorydata.plugin"));
    L24:
        if (r4 != 5) goto L44;
        if (r5 < 16384) goto L32;
        if (r5 <= 16777215) goto L44;
    L32:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + r5), Throwable.class, "com.obric.memorydata.plugin"));
    L38:
        r4 = 4;
        goto L44
    L17:
        if (r2 < r3) goto L47;
    L50:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_SETTINGS length % 6 != 0: " + r10), Throwable.class, "com.obric.memorydata.plugin"));
    L52:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_SETTINGS streamId != 0"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void readWindowUpdate(Handler r4, int r5, int r6, int r7) {
        Handler r8 = (Handler) ZeusTransformUtils.wrapperContextForParams(r4, Handler.class, "com.obric.memorydata.plugin");
        if (r5 != 4) goto L11;
        long r9 = Util.and(this.source.readInt(), 2147483647L);
        if (r9 == 0) goto L9;
        r8.windowUpdate(r7, r9);
        return;
    L9:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("windowSizeIncrement was 0"), Throwable.class, "com.obric.memorydata.plugin"));
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TYPE_WINDOW_UPDATE length !=4: " + r5), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.source.close();
    }

    public final boolean nextFrame(boolean r11, Handler r12) {
        Handler r13 = (Handler) ZeusTransformUtils.wrapperContextForParams(r12, Handler.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r13, "handler");
        this.source.require(9);     // Catch: EOFException -> L31
        int r0 = Util.readMedium(this.source);
        if (r0 > 16384) goto L30;
        int r8 = Util.and(this.source.readByte(), 255);
        if (r11 == true) goto L9;
    L13:
        int r14 = Util.and(this.source.readByte(), 255);
        int r1 = this.source.readInt() & Integer.MAX_VALUE;
        Logger r9 = logger;
        if (r9.isLoggable(Level.FINE) == false) goto L16;
        r9.fine(Http2.INSTANCE.frameLog(true, r1, r0, r8, r14));
    L16:
        switch(r8) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            default: goto L17;
        };
    L17:
        this.source.skip(r0);
        return true;
    L18:
        readWindowUpdate(r13, r0, r14, r1);
        return true;
    L19:
        readGoAway(r13, r0, r14, r1);
        return true;
    L20:
        readPing(r13, r0, r14, r1);
        return true;
    L21:
        readPushPromise(r13, r0, r14, r1);
        return true;
    L22:
        readSettings(r13, r0, r14, r1);
        return true;
    L23:
        readRstStream(r13, r0, r14, r1);
        return true;
    L24:
        readPriority(r13, r0, r14, r1);
        return true;
    L25:
        readHeaders(r13, r0, r14, r1);
        return true;
    L26:
        readData(r13, r0, r14, r1);
        return true;
    L9:
        if (r8 == 4) goto L13;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Expected a SETTINGS frame but was " + r8), Throwable.class, "com.obric.memorydata.plugin"));
    L30:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("FRAME_SIZE_ERROR: " + r0), Throwable.class, "com.obric.memorydata.plugin"));
    L31:
        return false;
    }

    public final void readConnectionPreface(Handler r6) {
        Handler r7 = (Handler) ZeusTransformUtils.wrapperContextForParams(r6, Handler.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r7, "handler");
        if (this.client == true) goto L5;
        ByteString r5 = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
        Logger r8 = logger;
        if (r8.isLoggable(Level.FINE) == false) goto L13;
        r8.fine(Util.format("<< CONNECTION " + r5.hex(), new Object[0]));
    L13:
        if ((!Intrinsics.areEqual(Http2.CONNECTION_PREFACE, r5)) == true) goto L16;
        return;
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Expected a connection header but was " + r5.utf8()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        if (nextFrame(true, r7) == false) goto L8;
        return;
    L8:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Required SETTINGS preface not received"), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
