package okhttp3.internal.http2;

import ai.j0;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
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
import nu.c0;
import nu.f0;
import nu.j;
import nu.l;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0003./0B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0010J/\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0010J\u001f\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u0010J/\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u0010J/\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u0010J/\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u0010J/\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u0010J/\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u0010J\u0015\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000eH\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010,R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010-¨\u00061"}, d2 = {"Lokhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", "Lnu/l;", "source", "", "client", "<init>", "(Lnu/l;Z)V", "Lokhttp3/internal/http2/Http2Reader$Handler;", "handler", "", "length", "flags", "streamId", "", "readHeaders", "(Lokhttp3/internal/http2/Http2Reader$Handler;III)V", "padding", "", "Lokhttp3/internal/http2/Header;", "readHeaderBlock", "(IIII)Ljava/util/List;", "readData", "readPriority", "(Lokhttp3/internal/http2/Http2Reader$Handler;I)V", "readRstStream", "readSettings", "readPushPromise", "readPing", "readGoAway", "readWindowUpdate", "readConnectionPreface", "(Lokhttp3/internal/http2/Http2Reader$Handler;)V", "requireSettings", "nextFrame", "(ZLokhttp3/internal/http2/Http2Reader$Handler;)Z", "close", "()V", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "continuation", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lokhttp3/internal/http2/Hpack$Reader;", "hpackReader", "Lokhttp3/internal/http2/Hpack$Reader;", "Lnu/l;", "Z", "Companion", "ContinuationSource", "Handler", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2Reader implements Closeable {
    public static final Companion Companion = null;
    private static final Logger logger = null;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final l source;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Companion;", "", "()V", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "lengthWithoutPadding", "", "length", "flags", "padding", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final Logger getLogger() {
            return Http2Reader.access$getLogger$cp();
        }

        public final int lengthWithoutPadding(int r5, int r10, int r11) throws IOException {
            if ((r10 & 8) == 0) goto L5;
            r5 = r5 - 1;
        L5:
            if (r11 > r5) goto L9;
            return r5 - r11;
        L9:
            throw new IOException(j0.f(r11, r5, "PROTOCOL_ERROR padding ", " > remaining length "));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010 \u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\"\u0010#\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010&¨\u0006'"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lnu/c0;", "Lnu/l;", "source", "<init>", "(Lnu/l;)V", "", "readContinuationHeader", "()V", "Lnu/j;", "sink", "", "byteCount", "read", "(Lnu/j;J)J", "Lnu/f0;", "timeout", "()Lnu/f0;", "close", "", "length", "I", "getLength", "()I", "setLength", "(I)V", "flags", "getFlags", "setFlags", "streamId", "getStreamId", "setStreamId", OpenPageMethod.ALIGN_LEFT, "getLeft", "setLeft", "padding", "getPadding", "setPadding", "Lnu/l;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class ContinuationSource implements c0 {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final l source;
        private int streamId;

        public ContinuationSource(l r5) {
            Intrinsics.checkNotNullParameter(r5, "source");
            this.source = r5;
        }

        private final void readContinuationHeader() throws IOException {
            int r5 = this.streamId;
            int r10 = Util.readMedium(this.source);
            this.left = r10;
            this.length = r10;
            int r11 = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            Companion r12 = Http2Reader.Companion;
            if (r12.getLogger().isLoggable(Level.FINE) == false) goto L5;
            r12.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, r11, this.flags));
        L5:
            int r13 = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = r13;
            if (r11 != 9) goto L12;
            if (r13 != r5) goto L10;
            return;
        L10:
            throw new IOException("TYPE_CONTINUATION streamId changed");
        L12:
            throw new IOException(r11 + " != TYPE_CONTINUATION");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
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

        @Override // nu.c0
        public long read(j r10, long r11) throws IOException {
            Intrinsics.checkNotNullParameter(r10, "sink");
        L3:
            int r5 = this.left;
            if (r5 != 0) goto L9;
            this.source.skip(this.padding);
            this.padding = 0;
            if ((this.flags & 4) != 0) goto L7;
            readContinuationHeader();
            goto L3
        L7:
            return -1;
        L9:
            long r12 = this.source.read(r10, Math.min(r11, r5));
            if (r12 != (-1)) goto L12;
            return -1;
        L12:
            this.left -= (int) r12;
            return r12;
        }

        public final void setFlags(int r5) {
            this.flags = r5;
        }

        public final void setLeft(int r5) {
            this.left = r5;
        }

        public final void setLength(int r5) {
            this.length = r5;
        }

        public final void setPadding(int r5) {
            this.padding = r5;
        }

        public final void setStreamId(int r5) {
            this.streamId = r5;
        }

        @Override // nu.c0
        public f0 timeout() {
            return this.source.timeout();
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH&¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001f\u0010 J'\u0010$\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H&¢\u0006\u0004\b(\u0010)J/\u0010-\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0002H&¢\u0006\u0004\b-\u0010.J-\u00101\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b1\u00102J?\u00109\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\"2\u0006\u00106\u001a\u0002032\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020&H&¢\u0006\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Handler;", "", "", "inFinished", "", "streamId", "Lnu/l;", "source", "length", "", "data", "(ZILnu/l;I)V", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "headerBlock", "headers", "(ZIILjava/util/List;)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "settings", "(ZLokhttp3/internal/http2/Settings;)V", "ackSettings", "()V", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "Lokio/ByteString;", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;Lokio/ByteString;)V", "", "windowSizeIncrement", "windowUpdate", "(IJ)V", "streamDependency", "weight", "exclusive", "priority", "(IIIZ)V", "promisedStreamId", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "", "origin", "protocol", "host", "port", "maxAge", "alternateService", "(ILjava/lang/String;Lokio/ByteString;Ljava/lang/String;IJ)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface Handler {
        void ackSettings();

        void alternateService(int r5, String r10, ByteString r11, String r12, int r13, long r14);

        void data(boolean r5, int r10, l r11, int r12) throws IOException;

        void goAway(int r5, ErrorCode r10, ByteString r11);

        void headers(boolean r5, int r10, int r11, List<Header> r12);

        void ping(boolean r5, int r10, int r11);

        void priority(int r5, int r10, int r11, boolean r12);

        void pushPromise(int r5, int r10, List<Header> r11) throws IOException;

        void rstStream(int r5, ErrorCode r10);

        void settings(boolean r5, Settings r10);

        void windowUpdate(int r5, long r10);
    }

    static {
        Companion = new Companion(null);
        logger = Logger.getLogger(Http2.class.getName());
    }

    public Http2Reader(l r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        this.source = r10;
        this.client = r11;
        ContinuationSource r5 = new ContinuationSource(r10);
        this.continuation = r5;
        this.hpackReader = new Hpack.Reader(r5, 4096, 0, 4, null);
    }

    public static final /* synthetic */ Logger access$getLogger$cp() {
        return logger;
    }

    private final void readData(Handler r5, int r10, int r11, int r12) throws IOException {
        if (r12 == 0) goto L17;
        int r13 = 0;
        if ((r11 & 1) == 0) goto L6;
        boolean r14 = true;
    L8:
        if ((r11 & 32) != 0) goto L15;
        if ((r11 & 8) == 0) goto L12;
        r13 = Util.and(this.source.readByte(), 255);
    L12:
        r5.data(r14, r12, this.source, Companion.lengthWithoutPadding(r10, r11, r13));
        this.source.skip(r13);
        return;
    L15:
        throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
    L6:
        r14 = false;
        goto L8
    L17:
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    private final void readGoAway(Handler r5, int r10, int r11, int r12) throws IOException {
        if (r10 < 8) goto L17;
        if (r12 != 0) goto L15;
        int r13 = this.source.readInt();
        int r14 = this.source.readInt();
        int r15 = r10 - 8;
        ErrorCode r16 = ErrorCode.Companion.fromHttp2(r14);
        if (r16 == null) goto L13;
        ByteString r17 = ByteString.EMPTY;
        if (r15 <= 0) goto L10;
        r17 = this.source.v(r15);
    L10:
        r5.goAway(r13, r16, r17);
        return;
    L13:
        throw new IOException(j0.g(r14, "TYPE_GOAWAY unexpected error code: "));
    L15:
        throw new IOException("TYPE_GOAWAY streamId != 0");
    L17:
        throw new IOException(j0.g(r10, "TYPE_GOAWAY length < 8: "));
    }

    private final List<Header> readHeaderBlock(int r5, int r10, int r11, int r12) throws IOException {
        this.continuation.setLeft(r5);
        ContinuationSource r13 = this.continuation;
        r13.setLength(r13.getLeft());
        this.continuation.setPadding(r10);
        this.continuation.setFlags(r11);
        this.continuation.setStreamId(r12);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler r5, int r10, int r11, int r12) throws IOException {
        if (r12 == 0) goto L16;
        int r13 = 0;
        if ((r11 & 1) == 0) goto L6;
        boolean r14 = true;
    L8:
        if ((r11 & 8) == 0) goto L11;
        r13 = Util.and(this.source.readByte(), 255);
    L11:
        if ((r11 & 32) == 0) goto L13;
        readPriority(r5, r12);
        r10 = r10 - 5;
    L13:
        r5.headers(r14, r12, -1, readHeaderBlock(Companion.lengthWithoutPadding(r10, r11, r13), r13, r11, r12));
        return;
    L6:
        r14 = false;
        goto L8
    L16:
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    private final void readPing(Handler r5, int r10, int r11, int r12) throws IOException {
        if (r10 != 8) goto L14;
        if (r12 != 0) goto L12;
        int r13 = this.source.readInt();
        int r14 = this.source.readInt();
        boolean r15 = true;
        if ((r11 & 1) != 0) goto L9;
        r15 = false;
    L9:
        r5.ping(r15, r13, r14);
        return;
    L12:
        throw new IOException("TYPE_PING streamId != 0");
    L14:
        throw new IOException(j0.g(r10, "TYPE_PING length != 8: "));
    }

    private final void readPriority(Handler r5, int r10, int r11, int r12) throws IOException {
        if (r10 != 5) goto L10;
        if (r12 == 0) goto L8;
        readPriority(r5, r12);
        return;
    L8:
        throw new IOException("TYPE_PRIORITY streamId == 0");
    L10:
        throw new IOException(j0.h(r10, "TYPE_PRIORITY length: ", " != 5"));
    }

    private final void readPushPromise(Handler r5, int r10, int r11, int r12) throws IOException {
        if (r12 == 0) goto L10;
        if ((r11 & 8) == 0) goto L6;
        int r13 = Util.and(this.source.readByte(), 255);
    L7:
        r5.pushPromise(r12, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(r10 - 4, r11, r13), r13, r11, r12));
        return;
    L6:
        r13 = 0;
        goto L7
    L10:
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    private final void readRstStream(Handler r5, int r10, int r11, int r12) throws IOException {
        if (r10 != 4) goto L14;
        if (r12 == 0) goto L12;
        int r13 = this.source.readInt();
        ErrorCode r14 = ErrorCode.Companion.fromHttp2(r13);
        if (r14 == null) goto L10;
        r5.rstStream(r12, r14);
        return;
    L10:
        throw new IOException(j0.g(r13, "TYPE_RST_STREAM unexpected error code: "));
    L12:
        throw new IOException("TYPE_RST_STREAM streamId == 0");
    L14:
        throw new IOException(j0.h(r10, "TYPE_RST_STREAM length: ", " != 4"));
    }

    private final void readSettings(Handler r10, int r11, int r12, int r13) throws IOException {
        if (r13 != 0) goto L50;
        if ((r12 & 1) == 0) goto L11;
        if (r11 != 0) goto L9;
        r10.ackSettings();
        return;
    L9:
        throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
    L11:
        if ((r11 % 6) != 0) goto L48;
        Settings r14 = new Settings();
        IntProgression r15 = RangesKt.step(RangesKt.until(0, r11), 6);
        int r5 = r15.getFirst();
        int r16 = r15.getLast();
        int r17 = r15.getStep();
        if (r17 < 0) goto L16;
        if (r5 <= r16) goto L17;
    L45:
        r10.settings(false, r14);
        return;
    L17:
        int r18 = Util.and(this.source.readShort(), 65535);
        int r19 = this.source.readInt();
        if (r18 != 2) goto L20;
        if (r19 == 0) goto L42;
        if (r19 == 1) goto L42;
        throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
    L42:
        r14.set(r18, r19);
        if (r5 == r16) goto L45;
        r5 = r5 + r17;
        goto L17
    L20:
        if (r18 == 3) goto L36;
        if (r18 != 4) goto L23;
        if (r19 < 0) goto L35;
        r18 = 7;
        goto L42
    L35:
        throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
    L23:
        if (r18 != 5) goto L42;
        if (r19 < 16384) goto L31;
        if (r19 <= 16777215) goto L42;
    L31:
        throw new IOException(j0.g(r19, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
    L36:
        r18 = 4;
        goto L42
    L16:
        if (r5 < r16) goto L45;
    L48:
        throw new IOException(j0.g(r11, "TYPE_SETTINGS length % 6 != 0: "));
    L50:
        throw new IOException("TYPE_SETTINGS streamId != 0");
    }

    private final void readWindowUpdate(Handler r5, int r10, int r11, int r12) throws IOException {
        if (r10 != 4) goto L11;
        long r13 = Util.and(this.source.readInt(), 2147483647L);
        if (r13 == 0) goto L9;
        r5.windowUpdate(r12, r13);
        return;
    L9:
        throw new IOException("windowSizeIncrement was 0");
    L11:
        throw new IOException(j0.g(r10, "TYPE_WINDOW_UPDATE length !=4: "));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean r12, Handler r13) throws IOException {
        Intrinsics.checkNotNullParameter(r13, "handler");
        this.source.s(9);     // Catch: EOFException -> L30
        int r5 = Util.readMedium(this.source);
        if (r5 > 16384) goto L29;
        int r10 = Util.and(this.source.readByte(), 255);
        int r11 = Util.and(this.source.readByte(), 255);
        int r14 = this.source.readInt() & Integer.MAX_VALUE;
        Logger r15 = logger;
        if (r15.isLoggable(Level.FINE) == false) goto L9;
        r15.fine(Http2.INSTANCE.frameLog(true, r14, r5, r10, r11));
    L9:
        if (r12 == true) goto L11;
    L15:
        switch(r10) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            default: goto L16;
        };
    L16:
        this.source.skip(r5);
        return true;
    L17:
        readWindowUpdate(r13, r5, r11, r14);
        return true;
    L18:
        readGoAway(r13, r5, r11, r14);
        return true;
    L19:
        readPing(r13, r5, r11, r14);
        return true;
    L20:
        readPushPromise(r13, r5, r11, r14);
        return true;
    L21:
        readSettings(r13, r5, r11, r14);
        return true;
    L22:
        readRstStream(r13, r5, r11, r14);
        return true;
    L23:
        readPriority(r13, r5, r11, r14);
        return true;
    L24:
        readHeaders(r13, r5, r11, r14);
        return true;
    L25:
        readData(r13, r5, r11, r14);
        return true;
    L11:
        if (r10 == 4) goto L15;
        throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(r10));
    L29:
        throw new IOException(j0.g(r5, "FRAME_SIZE_ERROR: "));
    L30:
        return false;
    }

    public final void readConnectionPreface(Handler r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "handler");
        if (this.client == true) goto L5;
        l r10 = this.source;
        ByteString r11 = Http2.CONNECTION_PREFACE;
        ByteString r12 = r10.v(r11.size());
        Logger r13 = logger;
        if (r13.isLoggable(Level.FINE) == false) goto L13;
        r13.fine(Util.format("<< CONNECTION " + r12.hex(), new Object[0]));
    L13:
        if (Intrinsics.areEqual(r11, r12) == false) goto L16;
        return;
    L16:
        throw new IOException("Expected a connection header but was " + r12.utf8());
    L5:
        if (nextFrame(true, r5) == false) goto L8;
        return;
    L8:
        throw new IOException("Required SETTINGS preface not received");
    }

    private final void readPriority(Handler r5, int r10) throws IOException {
        int r11 = this.source.readInt();
        if ((((int) 2147483648L) & r11) == 0) goto L5;
        boolean r12 = true;
    L6:
        r5.priority(r10, r11 & Integer.MAX_VALUE, Util.and(this.source.readByte(), 255) + 1, r12);
        return;
    L5:
        r12 = false;
        goto L6
    }
}
