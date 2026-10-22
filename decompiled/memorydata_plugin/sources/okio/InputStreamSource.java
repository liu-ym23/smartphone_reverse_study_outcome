package okio;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokio/InputStreamSource;", "Lokio/Source;", "input", "Ljava/io/InputStream;", LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "(Ljava/io/InputStream;Lokio/Timeout;)V", IslandSession.REOPEN_VALUE_CLOSE, "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "toString", "", "jvm"}, k = 1, mv = {1, 1, 11})
final class InputStreamSource implements Source {
    private final InputStream input;
    private final Timeout timeout;

    public InputStreamSource(InputStream r2, Timeout r3) {
        Intrinsics.checkParameterIsNotNull(r2, "input");
        Intrinsics.checkParameterIsNotNull(r3, LocationMonitorConst.TIMEOUT);
        this.input = r2;
        this.timeout = r3;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.input.close();
    }

    @Override // okio.Source
    public long read(Buffer r6, long r7) {
        Intrinsics.checkParameterIsNotNull(r6, "sink");
        if (r7 != 0) goto L6;
        return 0;
    L6:
        if (r7 < 0) goto L8;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L25;
        this.timeout.throwIfReached();     // Catch: AssertionError -> L17
        Segment r0 = r6.writableSegment$jvm(1);     // Catch: AssertionError -> L17
        int r5 = this.input.read(r0.data, r0.limit, (int) Math.min(r7, 8192 - r0.limit));     // Catch: AssertionError -> L17
        if (r5 != (-1)) goto L15;
        return -1;
    L15:
        r0.limit += r5;     // Catch: AssertionError -> L17
        long r2 = r5;
        r6.setSize$jvm(r6.size() + r2);     // Catch: AssertionError -> L17
        return r2;
    L17:
        e = move-exception;
        if (Okio.isAndroidGetsocknameError(e) == false) goto L23;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L23:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L25:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount < 0: " + r7).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L8:
        r1 = false;
        goto L10
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "source(" + this.input + ')';
    }
}
