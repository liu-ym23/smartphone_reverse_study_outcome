package okio;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0006\u0010\u0013\u001a\u00020\u000bJ\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokio/InflaterSource;", "Lokio/Source;", AILabCheckPermissionTask.KEY_SOURCE, "inflater", "Ljava/util/zip/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lokio/BufferedSource;", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "bufferBytesHeldByInflater", "", "closed", "", IslandSession.REOPEN_VALUE_CLOSE, "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "refill", "releaseInflatedBytes", LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "jvm"}, k = 1, mv = {1, 1, 11})
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(BufferedSource r3, Inflater r4) {
        BufferedSource r5 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSource.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkParameterIsNotNull(r4, "inflater");
        this.source = r5;
        this.inflater = r4;
    }

    public InflaterSource(Source r3, Inflater r4) {
        Source r5 = (Source) ZeusTransformUtils.wrapperContextForParams(r3, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkParameterIsNotNull(r4, "inflater");
        this(Okio.buffer(r5), r4);
    }

    private final void releaseInflatedBytes() {
        int r0 = this.bufferBytesHeldByInflater;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = r0 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= r1;
        this.source.skip(r1);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed == false) goto L5;
        return;
    L5:
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public long read(Buffer r9, long r10) {
        Intrinsics.checkParameterIsNotNull(r9, "sink");
        if (r10 < 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L37;
        if ((!this.closed) == false) goto L35;
        if (r10 != 0) goto L12;
        return 0;
    L12:
        boolean r0 = refill();
        Segment r1 = r9.writableSegment$jvm(1);     // Catch: DataFormatException -> L31
        int r2 = this.inflater.inflate(r1.data, r1.limit, (int) Math.min(r10, 8192 - r1.limit));     // Catch: DataFormatException -> L31
        if (r2 > 0) goto L15;
        if (this.inflater.finished() == true) goto L26;
        if (this.inflater.needsDictionary() == true) goto L26;
        if (r0 == false) goto L12;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException("source exhausted prematurely"), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: DataFormatException -> L31
    L26:
        releaseInflatedBytes();     // Catch: DataFormatException -> L31
        if (r1.pos != r1.limit) goto L43;
        r9.head = r1.pop();     // Catch: DataFormatException -> L31
        SegmentPool.recycle(r1);     // Catch: DataFormatException -> L31
        return -1;
    L43:
        return -1;
    L15:
        r1.limit += r2;     // Catch: DataFormatException -> L31
        long r3 = r2;
        r9.setSize$jvm(r9.size() + r3);     // Catch: DataFormatException -> L31
        return r3;
    L31:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L35:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L37:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount < 0: " + r10).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r4 = false;
        goto L7
    }

    public final boolean refill() {
        if (this.inflater.needsInput() == true) goto L5;
        return false;
    L5:
        releaseInflatedBytes();
        if (this.inflater.getRemaining() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L19;
        if (this.source.exhausted() == false) goto L13;
        return true;
    L13:
        Segment r1 = this.source.getBuffer().head;
        if (r1 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        this.bufferBytesHeldByInflater = r1.limit - r1.pos;
        this.inflater.setInput(r1.data, r1.pos, this.bufferBytesHeldByInflater);
        return false;
    L19:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("?".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L8:
        r0 = false;
        goto L9
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }
}
