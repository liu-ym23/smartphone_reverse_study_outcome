package okhttp3.internal.cache2;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0002:;B3\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u00105\u001a\u0004\u0018\u00010\u0005J \u00106\u001a\u0002032\u0006\u00107\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u0002032\u0006\u00104\u001a\u00020\u0007H\u0002R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006<"}, d2 = {"Lokhttp3/internal/cache2/Relay;", "", "file", "Ljava/io/RandomAccessFile;", "upstream", "Lokio/Source;", "upstreamPos", "", "metadata", "Lokio/ByteString;", "bufferMaxSize", "(Ljava/io/RandomAccessFile;Lokio/Source;JLokio/ByteString;J)V", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "getBufferMaxSize", "()J", "complete", "", "getComplete", "()Z", "setComplete", "(Z)V", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "isClosed", "sourceCount", "", "getSourceCount", "()I", "setSourceCount", "(I)V", "getUpstream", "()Lokio/Source;", "setUpstream", "(Lokio/Source;)V", "upstreamBuffer", "getUpstreamBuffer", "getUpstreamPos", "setUpstreamPos", "(J)V", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "commit", "", "upstreamSize", "newSource", "writeHeader", "prefix", "metadataSize", "writeMetadata", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Relay {
    public static final Companion Companion = null;
    private static final long FILE_HEADER_SIZE = 32;
    public static final ByteString PREFIX_CLEAN = null;
    public static final ByteString PREFIX_DIRTY = null;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    private Source upstream;
    private final Buffer upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "()V", "FILE_HEADER_SIZE", "", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "SOURCE_FILE", "", "SOURCE_UPSTREAM", "edit", "Lokhttp3/internal/cache2/Relay;", "file", "Ljava/io/File;", "upstream", "Lokio/Source;", "metadata", "bufferMaxSize", "read", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Relay edit(File r10, Source r11, ByteString r12, long r13) {
            Source r2 = (Source) ZeusTransformUtils.wrapperContextForParams(r11, Source.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r10, "file");
            Intrinsics.checkParameterIsNotNull(r2, "upstream");
            Intrinsics.checkParameterIsNotNull(r12, "metadata");
            RandomAccessFile r9 = new RandomAccessFile(r10, "rw");
            Relay r14 = new Relay(r9, r2, 0, r12, r13, null);
            r9.setLength(0);
            Relay.access$writeHeader(r14, Relay.PREFIX_DIRTY, -1, -1);
            return r14;
        }

        public final Relay read(File r11) {
            Intrinsics.checkParameterIsNotNull(r11, "file");
            RandomAccessFile r1 = new RandomAccessFile(r11, "rw");
            FileChannel r12 = r1.getChannel();
            Intrinsics.checkExpressionValueIsNotNull(r12, "randomAccessFile.channel");
            FileOperator r10 = new FileOperator(r12);
            Buffer r13 = new Buffer();
            r10.read(0, r13, 32);
            if ((!Intrinsics.areEqual(r13.readByteString(Relay.PREFIX_CLEAN.size()), Relay.PREFIX_CLEAN)) == true) goto L7;
            long r8 = r13.readLong();
            long r6 = r13.readLong();
            Buffer r14 = new Buffer();
            r10.read(r8 + 32, r14, r6);
            return new Relay(r1, null, r8, r14.readByteString(), 0, null);
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("unreadable cache file"), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lokio/Source;", "(Lokhttp3/internal/cache2/Relay;)V", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "", LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", IslandSession.REOPEN_VALUE_CLOSE, "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 1, 15})
    public final class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        final /* synthetic */ Relay this$0;
        private final Timeout timeout;

        public RelaySource(Relay r3) {
            this.this$0 = r3;
            this.timeout = new Timeout();
            RandomAccessFile r4 = r3.getFile();
            if (r4 != null) goto L5;
            Intrinsics.throwNpe();
        L5:
            FileChannel r5 = r4.getChannel();
            Intrinsics.checkExpressionValueIsNotNull(r5, "file!!.channel");
            this.fileOperator = new FileOperator(r5);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.fileOperator != null) goto L5;
            return;
        L5:
            this.fileOperator = (FileOperator) ZeusTransformUtils.preCheckCast(null, FileOperator.class, "com.obric.memorydata.plugin");
            RandomAccessFile r0 = (RandomAccessFile) ZeusTransformUtils.preCheckCast(null, RandomAccessFile.class, "com.obric.memorydata.plugin");
            Relay r1 = this.this$0;
            monitor-enter(r1);
            Relay r3 = this.this$0;     // Catch: Throwable -> L15
            r3.setSourceCount(r3.getSourceCount() - 1);     // Catch: Throwable -> L15
            if (this.this$0.getSourceCount() != 0) goto L10;
            r0 = this.this$0.getFile();     // Catch: Throwable -> L15
            this.this$0.setFile((RandomAccessFile) ZeusTransformUtils.preCheckCast(null, RandomAccessFile.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        L10:
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
            monitor-exit(r1);
            if (r0 == null) goto L20;
            Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin"));
            return;
        L20:
            return;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // okio.Source
        public long read(Buffer r20, long r21) {
            Intrinsics.checkParameterIsNotNull(r20, "sink");
            char r4 = 1;
            if (this.fileOperator == null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L94;
            Relay r8 = this.this$0;
            monitor-enter(r8);
        L99:
        L90:
            th = move-exception;
            throw th;
        L10:
            if (this.sourcePos != this.this$0.getUpstreamPos()) goto L11;
            if (this.this$0.getComplete() == true) goto L19;
            if (this.this$0.getUpstreamReader() == null) goto L24;
            this.timeout.waitUntilNotified(this.this$0);     // Catch: Throwable -> L90
            goto L99
        L24:
            this.this$0.setUpstreamReader(Thread.currentThread());     // Catch: Throwable -> L90
        L25:
            monitor-exit(r8);
            if (r4 != 2) goto L98;
            long r9 = Math.min(r21, this.this$0.getUpstreamPos() - this.sourcePos);
            FileOperator r2 = this.fileOperator;
            if (r2 != null) goto L31;
            Intrinsics.throwNpe();
        L31:
            r2.read(this.sourcePos + 32, r20, r9);
            this.sourcePos += r9;
            return r9;
        L98:
            Source r1 = this.this$0.getUpstream();     // Catch: Throwable -> L77
            if (r1 != null) goto L37;
            Intrinsics.throwNpe();     // Catch: Throwable -> L77
        L37:
            long r14 = r1.read(this.this$0.getUpstreamBuffer(), this.this$0.getBufferMaxSize());     // Catch: Throwable -> L77
            if (r14 != (-1)) goto L52;
            Relay r3 = this.this$0;     // Catch: Throwable -> L77
            r3.commit(r3.getUpstreamPos());     // Catch: Throwable -> L77
            Relay r5 = this.this$0;
            monitor-enter(r5);
            this.this$0.setUpstreamReader((Thread) ZeusTransformUtils.preCheckCast(null, Thread.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L49
            Relay r6 = this.this$0;     // Catch: Throwable -> L49
            if (r6 == null) goto L48;
            ZeusTransformUtils.preCheckCast(r6, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L49
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L49
            monitor-exit(r5);
            return -1;
        L48:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L49
        L49:
            th = move-exception;
            throw th;
        L52:
            long r10 = Math.min(r14, r21);     // Catch: Throwable -> L77
            this.this$0.getUpstreamBuffer().copyTo(r20, 0, r10);     // Catch: Throwable -> L77
            this.sourcePos += r10;     // Catch: Throwable -> L77
            FileOperator r13 = this.fileOperator;     // Catch: Throwable -> L77
            if (r13 != null) goto L55;
            Intrinsics.throwNpe();     // Catch: Throwable -> L77
        L55:
            r13.write(this.this$0.getUpstreamPos() + 32, this.this$0.getUpstreamBuffer().m3049clone(), r14);     // Catch: Throwable -> L77
            Relay r11 = this.this$0;     // Catch: Throwable -> L77
            monitor-enter(r11);     // Catch: Throwable -> L77
            this.this$0.getBuffer().write(this.this$0.getUpstreamBuffer(), r14);     // Catch: Throwable -> L74
            if (this.this$0.getBuffer().size() <= this.this$0.getBufferMaxSize()) goto L60;
            this.this$0.getBuffer().skip(this.this$0.getBuffer().size() - this.this$0.getBufferMaxSize());     // Catch: Throwable -> L74
        L60:
            Relay r12 = this.this$0;     // Catch: Throwable -> L74
            r12.setUpstreamPos(r12.getUpstreamPos() + r14);     // Catch: Throwable -> L74
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L74
            monitor-exit(r11);     // Catch: Throwable -> L77
            Relay r16 = this.this$0;
            monitor-enter(r16);
            this.this$0.setUpstreamReader((Thread) ZeusTransformUtils.preCheckCast(null, Thread.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L71
            Relay r17 = this.this$0;     // Catch: Throwable -> L71
            if (r17 == null) goto L70;
            ZeusTransformUtils.preCheckCast(r17, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L71
            Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L71
            monitor-exit(r16);
            return r10;
        L70:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L71
        L71:
            th = move-exception;
            throw th;
        L74:
            th = move-exception;
            throw th;     // Catch: Throwable -> L77
        L77:
            th = move-exception;
            monitor-enter(this.this$0);
            this.this$0.setUpstreamReader((Thread) ZeusTransformUtils.preCheckCast(null, Thread.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L87
            Relay r19 = this.this$0;     // Catch: Throwable -> L87
            if (r19 == null) goto L83;
            ZeusTransformUtils.preCheckCast(r19, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L87
            Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L87
            throw th;
        L83:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L87
        L87:
            th = move-exception;
            throw th;
        L19:
            monitor-exit(r8);
            return -1;
        L11:
            long r110 = this.this$0.getUpstreamPos() - this.this$0.getBuffer().size();     // Catch: Throwable -> L90
            if (this.sourcePos >= r110) goto L14;
            r4 = 2;
            goto L25
        L14:
            long r23 = Math.min(r21, this.this$0.getUpstreamPos() - this.sourcePos);     // Catch: Throwable -> L90
            this.this$0.getBuffer().copyTo(r20, this.sourcePos - r110, r23);     // Catch: Throwable -> L90
            this.sourcePos += r23;     // Catch: Throwable -> L90
            monitor-exit(r8);
            return r23;
        L94:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Check failed.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r0 = false;
            goto L6
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        Companion = new Companion(null);
        PREFIX_CLEAN = ByteString.Companion.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = ByteString.Companion.encodeUtf8("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile r3, Source r4, long r5, ByteString r7, long r8) {
        Source r6 = (Source) ZeusTransformUtils.wrapperContextForParams(r4, Source.class, "com.obric.memorydata.plugin");
        this.file = r3;
        this.upstream = r6;
        this.upstreamPos = r5;
        this.metadata = r7;
        this.bufferMaxSize = r8;
        this.upstreamBuffer = new Buffer();
        if (this.upstream != null) goto L5;
        boolean r9 = true;
    L6:
        this.complete = r9;
        this.buffer = new Buffer();
        return;
    L5:
        r9 = false;
        goto L6
    }

    public /* synthetic */ Relay(RandomAccessFile r10, Source r11, long r12, ByteString r14, long r15, DefaultConstructorMarker r17) {
        this(r10, (Source) ZeusTransformUtils.wrapperContextForParams(r11, Source.class, "com.obric.memorydata.plugin"), r12, r14, r15);
    }

    public static final /* synthetic */ void access$writeHeader(Relay r0, ByteString r1, long r2, long r4) {
        r0.writeHeader(r1, r2, r4);
    }

    private final void writeHeader(ByteString r2, long r3, long r5) {
        Buffer r0 = new Buffer();
        r0.write(r2);
        r0.writeLong(r3);
        r0.writeLong(r5);
        if (r0.size() != 32) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L13;
        RandomAccessFile r1 = this.file;
        if (r1 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        FileChannel r6 = r1.getChannel();
        Intrinsics.checkExpressionValueIsNotNull(r6, "file!!.channel");
        new FileOperator(r6).write(0, r0, 32);
        return;
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r4 = false;
        goto L6
    }

    private final void writeMetadata(long r7) {
        Buffer r3 = new Buffer();
        r3.write(this.metadata);
        RandomAccessFile r1 = this.file;
        if (r1 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        FileChannel r2 = r1.getChannel();
        Intrinsics.checkExpressionValueIsNotNull(r2, "file!!.channel");
        new FileOperator(r2).write(32 + r7, r3, this.metadata.size());
    }

    public final void commit(long r9) {
        writeMetadata(r9);
        RandomAccessFile r0 = this.file;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r0.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, r9, this.metadata.size());
        RandomAccessFile r10 = this.file;
        if (r10 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        r10.getChannel().force(false);
        monitor-enter(this);
        this.complete = true;     // Catch: Throwable -> L18
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        Source r12 = this.upstream;
        if (r12 == null) goto L16;
        Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin"));
    L16:
        this.upstream = (Source) ZeusTransformUtils.preCheckCast(null, Source.class, "com.obric.memorydata.plugin");
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final Source getUpstream() {
        return this.upstream;
    }

    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        if (this.file != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final Source newSource() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.file == null) goto L6;
        this.sourceCount++;     // Catch: Throwable -> L12
        monitor-exit(this);
        return (Source) ZeusTransformUtils.preCheckCast(new RelaySource(this), Source.class, "com.obric.memorydata.plugin");
    L6:
        monitor-exit(this);
        return null;
    }

    public final void setComplete(boolean r1) {
        this.complete = r1;
    }

    public final void setFile(RandomAccessFile r1) {
        this.file = r1;
    }

    public final void setSourceCount(int r1) {
        this.sourceCount = r1;
    }

    public final void setUpstream(Source r3) {
        this.upstream = (Source) ZeusTransformUtils.wrapperContextForParams(r3, Source.class, "com.obric.memorydata.plugin");
    }

    public final void setUpstreamPos(long r1) {
        this.upstreamPos = r1;
    }

    public final void setUpstreamReader(Thread r1) {
        this.upstreamReader = r1;
    }
}
