package okio;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0003J\r\u0010\u000e\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000fJ\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokio/DeflaterSink;", "Lokio/Sink;", "sink", "deflater", "Ljava/util/zip/Deflater;", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "closed", "", IslandSession.REOPEN_VALUE_CLOSE, "", "deflate", "syncFlush", "finishDeflate", "finishDeflate$jvm", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "toString", "", "write", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Buffer;", "byteCount", "", "jvm"}, k = 1, mv = {1, 1, 11})
public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(BufferedSink r3, Deflater r4) {
        BufferedSink r5 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "sink");
        Intrinsics.checkParameterIsNotNull(r4, "deflater");
        this.sink = r5;
        this.deflater = r4;
    }

    public DeflaterSink(Sink r3, Deflater r4) {
        Sink r5 = (Sink) ZeusTransformUtils.wrapperContextForParams(r3, Sink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "sink");
        Intrinsics.checkParameterIsNotNull(r4, "deflater");
        this(Okio.buffer(r5), r4);
    }

    private final void deflate(boolean r8) {
        Buffer r0 = this.sink.getBuffer();
    L3:
        Segment r1 = r0.writableSegment$jvm(1);
        Deflater r2 = this.deflater;
        byte[] r3 = r1.data;
        int r4 = r1.limit;
        int r5 = 8192 - r1.limit;
        if (r8 == false) goto L6;
        int r6 = r2.deflate(r3, r4, r5, 2);
    L7:
        if (r6 > 0) goto L8;
        if (this.deflater.needsInput() == false) goto L3;
        if (r1.pos != r1.limit) goto L21;
        r0.head = r1.pop();
        SegmentPool.recycle(r1);
        return;
    L21:
        return;
    L8:
        r1.limit += r6;
        r0.setSize$jvm(r0.size() + ((long) r6));
        this.sink.emitCompleteSegments();
        goto L3
    L6:
        r6 = r2.deflate(r3, r4, r5);
        goto L7
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed == false) goto L5;
        return;
    L5:
        Throwable th = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin");
        finishDeflate$jvm();     // Catch: Throwable -> L8
    L27:
        this.deflater.end();     // Catch: Throwable -> L11
    L25:
        this.sink.close();     // Catch: Throwable -> L16
    L19:
        this.closed = true;
        if (th != null) goto L22;
        return;
    L22:
        throw th;
    L16:
        th = move-exception;
        if (th != null) goto L19;
        th = th;
    L11:
        th = move-exception;
        if (th != null) goto L25;
        th = th;
    L8:
        th = th;
        goto L27
    }

    public final void finishDeflate$jvm() {
        this.deflater.finish();
        deflate(false);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        deflate(true);
        this.sink.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    @Override // okio.Sink
    public void write(Buffer r8, long r9) {
        Intrinsics.checkParameterIsNotNull(r8, AILabCheckPermissionTask.KEY_SOURCE);
        Util.checkOffsetAndCount(r8.size(), 0, r9);
    L4:
        if (r9 <= 0) goto L12;
        Segment r0 = r8.head;
        if (r0 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        int r1 = (int) Math.min(r9, r0.limit - r0.pos);
        this.deflater.setInput(r0.data, r0.pos, r1);
        deflate(false);
        long r4 = r1;
        r8.setSize$jvm(r8.size() - r4);
        r0.pos += r1;
        if (r0.pos != r0.limit) goto L11;
        r8.head = r0.pop();
        SegmentPool.recycle(r0);
    L11:
        r9 = r9 - r4;
        goto L4
    }
}
