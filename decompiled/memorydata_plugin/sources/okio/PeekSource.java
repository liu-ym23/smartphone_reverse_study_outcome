package okio;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokio/PeekSource;", "Lokio/Source;", "upstream", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", "closed", "", "expectedPos", "", "expectedSegment", "Lokio/Segment;", "pos", "", IslandSession.REOPEN_VALUE_CLOSE, "", "read", "sink", "byteCount", LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "jvm"}, k = 1, mv = {1, 1, 11})
public final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource r3) {
        BufferedSource r4 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSource.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "upstream");
        this.upstream = r4;
        Buffer r5 = r4.getBuffer();
        this.buffer = r5;
        this.expectedSegment = r5.head;
        Segment r6 = r5.head;
        if (r6 == null) goto L5;
        int r7 = r6.pos;
    L6:
        this.expectedPos = r7;
        return;
    L5:
        r7 = -1;
        goto L6
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    @Override // okio.Source
    public long read(Buffer r9, long r10) {
        Intrinsics.checkParameterIsNotNull(r9, "sink");
        boolean r1 = true;
        if ((!this.closed) == false) goto L33;
        Segment r0 = this.expectedSegment;
        if (r0 != null) goto L7;
    L15:
        if (r1 == false) goto L31;
        this.upstream.request(this.pos + r10);
        if (this.expectedSegment == null) goto L19;
    L24:
        long r11 = Math.min(r10, this.buffer.size() - this.pos);
        if (r11 > 0) goto L28;
        return -1;
    L28:
        this.buffer.copyTo(r9, this.pos, r11);
        this.pos += r11;
        return r11;
    L19:
        if (this.buffer.head == null) goto L24;
        this.expectedSegment = this.buffer.head;
        Segment r2 = this.buffer.head;
        if (r2 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        this.expectedPos = r2.pos;
        goto L24
    L31:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Peek source is invalid because upstream source was used".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L7:
        if (r0 != this.buffer.head) goto L14;
        int r3 = this.expectedPos;
        Segment r4 = this.buffer.head;
        if (r4 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        if (r3 == r4.pos) goto L15;
    L14:
        r1 = false;
        goto L15
    L33:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.upstream.timeout();
    }
}
