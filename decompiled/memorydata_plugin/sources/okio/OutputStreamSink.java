package okio;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokio/OutputStreamSink;", "Lokio/Sink;", "out", "Ljava/io/OutputStream;", LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "(Ljava/io/OutputStream;Lokio/Timeout;)V", IslandSession.REOPEN_VALUE_CLOSE, "", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "toString", "", "write", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Buffer;", "byteCount", "", "jvm"}, k = 1, mv = {1, 1, 11})
final class OutputStreamSink implements Sink {
    private final OutputStream out;
    private final Timeout timeout;

    public OutputStreamSink(OutputStream r2, Timeout r3) {
        Intrinsics.checkParameterIsNotNull(r2, "out");
        Intrinsics.checkParameterIsNotNull(r3, LocationMonitorConst.TIMEOUT);
        this.out = r2;
        this.timeout = r3;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.out.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }

    @Override // okio.Sink
    public void write(Buffer r8, long r9) {
        Intrinsics.checkParameterIsNotNull(r8, AILabCheckPermissionTask.KEY_SOURCE);
        Util.checkOffsetAndCount(r8.size(), 0, r9);
    L4:
        if (r9 <= 0) goto L11;
        this.timeout.throwIfReached();
        Segment r0 = r8.head;
        if (r0 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        int r1 = (int) Math.min(r9, r0.limit - r0.pos);
        this.out.write(r0.data, r0.pos, r1);
        r0.pos += r1;
        long r2 = r1;
        r9 = r9 - r2;
        r8.setSize$jvm(r8.size() - r2);
        if (r0.pos != r0.limit) goto L4;
        r8.head = r0.pop();
        SegmentPool.recycle(r0);
        goto L4
    }
}
