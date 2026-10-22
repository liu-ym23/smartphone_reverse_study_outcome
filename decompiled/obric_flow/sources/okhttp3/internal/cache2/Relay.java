package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nu.c0;
import nu.f0;
import nu.j;
import nu.m;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u0000 E2\u00020\u0001:\u0002EFB5\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0017\u0010!\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0017\u0010,\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b-\u0010$R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010:\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010=R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010\u0014R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010BR\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010>\u001a\u0004\bC\u0010@R\u0011\u0010D\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\bD\u0010)¨\u0006G"}, d2 = {"Lokhttp3/internal/cache2/Relay;", "", "Ljava/io/RandomAccessFile;", "file", "Lnu/c0;", "upstream", "", "upstreamPos", "Lokio/ByteString;", "metadata", "bufferMaxSize", "<init>", "(Ljava/io/RandomAccessFile;Lnu/c0;JLokio/ByteString;J)V", "prefix", "upstreamSize", "metadataSize", "", "writeHeader", "(Lokio/ByteString;JJ)V", "writeMetadata", "(J)V", "commit", "()Lokio/ByteString;", "newSource", "()Lnu/c0;", "Ljava/lang/Thread;", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "Lnu/j;", "upstreamBuffer", "Lnu/j;", "getUpstreamBuffer", "()Lnu/j;", "", "complete", "Z", "getComplete", "()Z", "setComplete", "(Z)V", "buffer", "getBuffer", "", "sourceCount", "I", "getSourceCount", "()I", "setSourceCount", "(I)V", "Ljava/io/RandomAccessFile;", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "Lnu/c0;", "getUpstream", "setUpstream", "(Lnu/c0;)V", "J", "getUpstreamPos", "()J", "setUpstreamPos", "Lokio/ByteString;", "getBufferMaxSize", "isClosed", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Relay {
    public static final Companion Companion = null;
    private static final long FILE_HEADER_SIZE = 32;

    @JvmField
    public static final ByteString PREFIX_CLEAN = null;

    @JvmField
    public static final ByteString PREFIX_DIRTY = null;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final j buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    private c0 upstream;
    private final j upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "<init>", "()V", "Ljava/io/File;", "file", "Lnu/c0;", "upstream", "Lokio/ByteString;", "metadata", "", "bufferMaxSize", "Lokhttp3/internal/cache2/Relay;", "edit", "(Ljava/io/File;Lnu/c0;Lokio/ByteString;J)Lokhttp3/internal/cache2/Relay;", "read", "(Ljava/io/File;)Lokhttp3/internal/cache2/Relay;", "FILE_HEADER_SIZE", "J", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "", "SOURCE_FILE", "I", "SOURCE_UPSTREAM", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final Relay edit(File r10, c0 r11, ByteString r12, long r13) throws IOException {
            Intrinsics.checkNotNullParameter(r10, "file");
            Intrinsics.checkNotNullParameter(r11, "upstream");
            Intrinsics.checkNotNullParameter(r12, "metadata");
            RandomAccessFile r14 = new RandomAccessFile(r10, "rw");
            Relay r15 = new Relay(r14, r11, 0, r12, r13, null);
            r14.setLength(0);
            Relay.access$writeHeader(r15, Relay.PREFIX_DIRTY, -1, -1);
            return r15;
        }

        public final Relay read(File r11) throws IOException {
            Intrinsics.checkNotNullParameter(r11, "file");
            RandomAccessFile r5 = new RandomAccessFile(r11, "rw");
            FileOperator r10 = new FileOperator(r5.getChannel());
            j r12 = new j();
            r10.read(0, r12, Relay.FILE_HEADER_SIZE);
            ByteString r13 = Relay.PREFIX_CLEAN;
            if (Intrinsics.areEqual(r12.v(r13.size()), r13) == false) goto L7;
            long r14 = r12.readLong();
            long r15 = r12.readLong();
            j r16 = new j();
            r10.read(r14 + Relay.FILE_HEADER_SIZE, r16, r15);
            return new Relay(r5, null, r14, r16.v(r16.f20328b), 0, null);
        L7:
            throw new IOException("unreadable cache file");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lnu/c0;", "<init>", "(Lokhttp3/internal/cache2/Relay;)V", "Lnu/j;", "sink", "", "byteCount", "read", "(Lnu/j;J)J", "Lnu/f0;", "timeout", "()Lnu/f0;", "", "close", "()V", "Lnu/f0;", "Lokhttp3/internal/cache2/FileOperator;", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "J", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class RelaySource implements c0 {
        private FileOperator fileOperator;
        private long sourcePos;
        final /* synthetic */ Relay this$0;
        private final f0 timeout;

        public RelaySource(Relay r5) {
            this.this$0 = r5;
            this.timeout = new f0();
            RandomAccessFile r10 = r5.getFile();
            Intrinsics.checkNotNull(r10);
            this.fileOperator = new FileOperator(r10.getChannel());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator != null) goto L5;
            return;
        L5:
            RandomAccessFile r5 = null;
            this.fileOperator = null;
            Relay r10 = this.this$0;
            monitor-enter(r10);
            Relay r11 = this.this$0;     // Catch: Throwable -> L10
            r11.setSourceCount(r11.getSourceCount() - 1);     // Catch: Throwable -> L10
            if (this.this$0.getSourceCount() != 0) goto L12;
            RandomAccessFile r12 = this.this$0.getFile();     // Catch: Throwable -> L10
            this.this$0.setFile(null);     // Catch: Throwable -> L10
            r5 = r12;
        L12:
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r10);
            if (r5 == null) goto L21;
            Util.closeQuietly(r5);
            return;
        L21:
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // nu.c0
        public long read(j r22, long r23) throws IOException {
            Intrinsics.checkNotNullParameter(r22, "sink");
            if (this.fileOperator == null) goto L89;
            Relay r10 = this.this$0;
            monitor-enter(r10);
        L95:
        L14:
            th = move-exception;
            throw th;
        L7:
            if (this.sourcePos != this.this$0.getUpstreamPos()) goto L8;
            if (this.this$0.getComplete() == true) goto L18;
            if (this.this$0.getUpstreamReader() == null) goto L23;
            this.timeout.waitUntilNotified(this.this$0);     // Catch: Throwable -> L14
            goto L95
        L23:
            this.this$0.setUpstreamReader(Thread.currentThread());     // Catch: Throwable -> L14
            char r5 = 1;
        L25:
            monitor-exit(r10);
            if (r5 != 2) goto L96;
            long r11 = Math.min(r23, this.this$0.getUpstreamPos() - this.sourcePos);
            FileOperator r12 = this.fileOperator;
            Intrinsics.checkNotNull(r12);
            r12.read(this.sourcePos + Relay.FILE_HEADER_SIZE, r22, r11);
            this.sourcePos += r11;
            return r11;
        L96:
            c0 r13 = this.this$0.getUpstream();     // Catch: Throwable -> L47
            Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L47
            long r14 = r13.read(this.this$0.getUpstreamBuffer(), this.this$0.getBufferMaxSize());     // Catch: Throwable -> L47
            if (r14 != (-1)) goto L49;
            Relay r15 = this.this$0;     // Catch: Throwable -> L47
            r15.commit(r15.getUpstreamPos());     // Catch: Throwable -> L47
            Relay r16 = this.this$0;
            monitor-enter(r16);
            this.this$0.setUpstreamReader(null);     // Catch: Throwable -> L41
            Relay r17 = this.this$0;     // Catch: Throwable -> L41
            if (r17 == null) goto L44;
            r17.notifyAll();     // Catch: Throwable -> L41
            Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L41
            monitor-exit(r16);
            return -1;
        L44:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            throw th;
        L49:
            long r19 = Math.min(r14, r23);     // Catch: Throwable -> L47
            this.this$0.getUpstreamBuffer().g(0, r22, r19);     // Catch: Throwable -> L47
            this.sourcePos += r19;     // Catch: Throwable -> L47
            FileOperator r110 = this.fileOperator;     // Catch: Throwable -> L47
            Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L47
            r110.write(this.this$0.getUpstreamPos() + Relay.FILE_HEADER_SIZE, this.this$0.getUpstreamBuffer().e(), r14);     // Catch: Throwable -> L47
            Relay r20 = this.this$0;     // Catch: Throwable -> L47
            monitor-enter(r20);     // Catch: Throwable -> L47
            this.this$0.getBuffer().write(this.this$0.getUpstreamBuffer(), r14);     // Catch: Throwable -> L54
            if (this.this$0.getBuffer().f20328b <= this.this$0.getBufferMaxSize()) goto L56;
            this.this$0.getBuffer().skip(this.this$0.getBuffer().f20328b - this.this$0.getBufferMaxSize());     // Catch: Throwable -> L54
        L56:
            Relay r21 = this.this$0;     // Catch: Throwable -> L54
            r21.setUpstreamPos(r21.getUpstreamPos() + r14);     // Catch: Throwable -> L54
            Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L54
            monitor-exit(r20);     // Catch: Throwable -> L47
            Relay r25 = this.this$0;
            monitor-enter(r25);
            this.this$0.setUpstreamReader(null);     // Catch: Throwable -> L65
            Relay r26 = this.this$0;     // Catch: Throwable -> L65
            if (r26 == null) goto L68;
            r26.notifyAll();     // Catch: Throwable -> L65
            monitor-exit(r25);
            return r19;
        L68:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L65
        L65:
            th = move-exception;
            throw th;
        L54:
            th = move-exception;
            throw th;     // Catch: Throwable -> L47
        L47:
            th = move-exception;
            monitor-enter(this.this$0);
            this.this$0.setUpstreamReader(null);     // Catch: Throwable -> L79
            Relay r27 = this.this$0;     // Catch: Throwable -> L79
            if (r27 == null) goto L78;
            r27.notifyAll();     // Catch: Throwable -> L79
            Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L79
            throw th;
        L78:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L79
        L79:
            th = move-exception;
            throw th;
        L18:
            monitor-exit(r10);
            return -1;
        L8:
            long r29 = this.this$0.getUpstreamPos() - this.this$0.getBuffer().f20328b;     // Catch: Throwable -> L14
            if (this.sourcePos >= r29) goto L11;
            r5 = 2;
            goto L25
        L11:
            long r111 = Math.min(r23, this.this$0.getUpstreamPos() - this.sourcePos);     // Catch: Throwable -> L14
            this.this$0.getBuffer().g(this.sourcePos - r29, r22, r111);     // Catch: Throwable -> L14
            this.sourcePos += r111;     // Catch: Throwable -> L14
            monitor-exit(r10);
            return r111;
        L89:
            throw new IllegalStateException("Check failed.");
        }

        @Override // nu.c0
        public f0 timeout() {
            return this.timeout;
        }
    }

    static {
        Companion = new Companion(null);
        ByteString.Companion.getClass();
        PREFIX_CLEAN = m.c("OkHttp cache v1\n");
        PREFIX_DIRTY = m.c("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile r5, c0 r10, long r11, ByteString r12, long r13) {
        this.file = r5;
        this.upstream = r10;
        this.upstreamPos = r11;
        this.metadata = r12;
        this.bufferMaxSize = r13;
        this.upstreamBuffer = new j();
        if (r10 != null) goto L5;
        boolean r14 = true;
    L6:
        this.complete = r14;
        this.buffer = new j();
        return;
    L5:
        r14 = false;
        goto L6
    }

    public static final /* synthetic */ void access$writeHeader(Relay r5, ByteString r10, long r11, long r12) {
        r5.writeHeader(r10, r11, r12);
    }

    private final void writeHeader(ByteString r5, long r10, long r11) throws IOException {
        j r12 = new j();
        r12.Q(r5);
        r12.X(r10);
        r12.X(r11);
        if (r12.f20328b != FILE_HEADER_SIZE) goto L7;
        RandomAccessFile r13 = this.file;
        Intrinsics.checkNotNull(r13);
        new FileOperator(r13.getChannel()).write(0, r12, FILE_HEADER_SIZE);
        return;
    L7:
        throw new IllegalArgumentException("Failed requirement.");
    }

    private final void writeMetadata(long r10) throws IOException {
        j r5 = new j();
        r5.Q(this.metadata);
        RandomAccessFile r11 = this.file;
        Intrinsics.checkNotNull(r11);
        new FileOperator(r11.getChannel()).write(FILE_HEADER_SIZE + r10, r5, this.metadata.size());
    }

    public final void commit(long r10) throws IOException {
        writeMetadata(r10);
        RandomAccessFile r5 = this.file;
        Intrinsics.checkNotNull(r5);
        r5.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, r10, this.metadata.size());
        RandomAccessFile r11 = this.file;
        Intrinsics.checkNotNull(r11);
        r11.getChannel().force(false);
        monitor-enter(this);
        this.complete = true;     // Catch: Throwable -> L12
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        c0 r13 = this.upstream;
        if (r13 == null) goto L10;
        Util.closeQuietly(r13);
    L10:
        this.upstream = null;
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final j getBuffer() {
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

    public final c0 getUpstream() {
        return this.upstream;
    }

    public final j getUpstreamBuffer() {
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

    public final c0 newSource() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.file != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        this.sourceCount++;     // Catch: Throwable -> L12
        monitor-exit(this);
        return new RelaySource(this);
    }

    public final void setComplete(boolean r5) {
        this.complete = r5;
    }

    public final void setFile(RandomAccessFile r5) {
        this.file = r5;
    }

    public final void setSourceCount(int r5) {
        this.sourceCount = r5;
    }

    public final void setUpstream(c0 r5) {
        this.upstream = r5;
    }

    public final void setUpstreamPos(long r5) {
        this.upstreamPos = r5;
    }

    public final void setUpstreamReader(Thread r5) {
        this.upstreamReader = r5;
    }

    public /* synthetic */ Relay(RandomAccessFile r5, c0 r10, long r11, ByteString r12, long r13, DefaultConstructorMarker r14) {
        this(r5, r10, r11, r12, r13);
    }
}
