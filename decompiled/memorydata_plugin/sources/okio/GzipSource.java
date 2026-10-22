package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lokio/GzipSource;", "Lokio/Source;", AILabCheckPermissionTask.KEY_SOURCE, "(Lokio/Source;)V", "crc", "Ljava/util/zip/CRC32;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "section", "", "Lokio/RealBufferedSource;", "checkEqual", "", ActivityLifecycle.NAME, "", "expected", "", "actual", IslandSession.REOPEN_VALUE_CLOSE, "consumeHeader", "consumeTrailer", "read", "", "sink", "Lokio/Buffer;", "byteCount", LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "updateCrc", "buffer", TypedValues.CycleType.S_WAVE_OFFSET, "jvm"}, k = 1, mv = {1, 1, 11})
public final class GzipSource implements Source {
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(Source r5) {
        Source r6 = (Source) ZeusTransformUtils.wrapperContextForParams(r5, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, AILabCheckPermissionTask.KEY_SOURCE);
        RealBufferedSource r0 = new RealBufferedSource(r6);
        this.source = r0;
        Inflater r7 = new Inflater(true);
        this.inflater = r7;
        this.inflaterSource = new InflaterSource((BufferedSource) ZeusTransformUtils.preCheckCast(r0, BufferedSource.class, "com.obric.memorydata.plugin"), r7);
        this.crc = new CRC32();
    }

    private final void checkEqual(String r4, int r5, int r6) {
        if (r6 != r5) goto L4;
        return;
    L4:
        String r7 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{r4, Integer.valueOf(r6), Integer.valueOf(r5)}, 3));
        Intrinsics.checkExpressionValueIsNotNull(r7, "java.lang.String.format(this, *args)");
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException(r7), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void consumeHeader() {
        this.source.require(10);
        byte r7 = this.source.bufferField.getByte(3);
        boolean r8 = true;
        if (((r7 >> 1) & 1) != 1) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        updateCrc(this.source.bufferField, 0, 10);
    L8:
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8);
        if (((r7 >> 2) & 1) != 1) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L21;
        this.source.require(2);
        if (r10 == false) goto L16;
        updateCrc(this.source.bufferField, 0, 2);
    L16:
        long r11 = this.source.bufferField.readShortLe();
        this.source.require(r11);
        if (r10 == false) goto L19;
        updateCrc(this.source.bufferField, 0, r11);
    L19:
        this.source.skip(r11);
    L21:
        if (((r7 >> 3) & 1) != 1) goto L23;
        boolean r1 = true;
    L25:
        if (r1 == false) goto L34;
        long r16 = this.source.indexOf((byte) 0);
        if (r16 == (-1)) goto L32;
        if (r10 == false) goto L30;
        updateCrc(this.source.bufferField, 0, r16 + 1);
    L30:
        this.source.skip(r16 + 1);
        goto L34
    L32:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    L34:
        if (((r7 >> 4) & 1) == 1) goto L37;
        r8 = false;
    L37:
        if (r8 == false) goto L45;
        long r9 = this.source.indexOf((byte) 0);
        if (r9 == (-1)) goto L44;
        if (r10 == false) goto L42;
        updateCrc(this.source.bufferField, 0, r9 + 1);
    L42:
        this.source.skip(r9 + 1);
        goto L45
    L44:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    L45:
        if (r10 == false) goto L48;
        checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
        this.crc.reset();
        return;
    L48:
        return;
    L23:
        r1 = false;
        goto L25
    L11:
        r0 = false;
        goto L12
    L5:
        r10 = false;
        goto L6
    }

    private final void consumeTrailer() {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private final void updateCrc(Buffer r5, long r6, long r8) {
        Segment r7 = r5.head;
        if (r7 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (r6 < (r7.limit - r7.pos)) goto L12;
        r6 = r6 - ((long) (r7.limit - r7.pos));
        r7 = r7.next;
        if (r7 != null) goto L6;
        Intrinsics.throwNpe();
    L12:
        if (r8 <= 0) goto L17;
        int r9 = (int) (((long) r7.pos) + r6);
        int r10 = (int) Math.min(r7.limit - r9, r8);
        this.crc.update(r7.data, r9, r10);
        r8 = r8 - ((long) r10);
        r7 = r7.next;
        if (r7 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        r6 = 0;
        goto L12
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public long read(Buffer r13, long r14) {
        Intrinsics.checkParameterIsNotNull(r13, "sink");
        if (r14 < 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L29;
        if (r14 != 0) goto L11;
        return 0;
    L11:
        if (this.section != 0) goto L14;
        consumeHeader();
        this.section = 1;
    L14:
        if (this.section != 1) goto L21;
        long r8 = r13.size();
        long r15 = this.inflaterSource.read(r13, r14);
        if (r15 == (-1)) goto L19;
        updateCrc(r13, r8, r15);
        return r15;
    L19:
        this.section = 2;
    L21:
        if (this.section != 2) goto L27;
        consumeTrailer();
        this.section = 3;
        if (this.source.exhausted() == true) goto L27;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("gzip finished without exhausting source"), Throwable.class, "com.obric.memorydata.plugin"));
    L27:
        return -1;
    L29:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount < 0: " + r14).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r4 = false;
        goto L7
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }
}
