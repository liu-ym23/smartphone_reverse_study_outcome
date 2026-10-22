package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fJ$\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\f\u0010\u0016\u001a\u00020\u0004*\u00020\u0004H\u0002J\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/Throttler;", "", "()V", "allocatedUntil", "", "(J)V", "bytesPerSecond", "maxByteCount", "waitByteCount", "byteCountOrWaitNanos", "now", "byteCount", "byteCountOrWaitNanos$jvm", "", "sink", "Lokio/Sink;", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Source;", "take", "take$jvm", "waitNanos", "nanosToWait", "bytesToNanos", "nanosToBytes", "jvm"}, k = 1, mv = {1, 1, 11})
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler() {
        this(System.nanoTime());
    }

    public Throttler(long r1) {
        this.allocatedUntil = r1;
        this.waitByteCount = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        this.maxByteCount = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler r7, long r8, long r10, long r12, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r10 = r7.waitByteCount;
    L5:
        long r3 = r10;
        if ((r14 & 4) == 0) goto L8;
        r12 = r7.maxByteCount;
    L8:
        r7.bytesPerSecond(r8, r3, r12);
    }

    private final long bytesToNanos(long r3) {
        return (r3 * 1000000000) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long r3) {
        return (r3 * this.bytesPerSecond) / 1000000000;
    }

    private final void waitNanos(long r5) {
        long r2 = r5 / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        long r6 = r5 - (TimeUtils.NANOSECONDS_PER_MILLISECOND * r2);
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").wait(r2, (int) r6);
    }

    public final long byteCountOrWaitNanos$jvm(long r10, long r12) {
        if (this.bytesPerSecond != 0) goto L5;
        return r12;
    L5:
        long r0 = Math.max(this.allocatedUntil - r10, 0);
        long r4 = this.maxByteCount - nanosToBytes(r0);
        if (r4 < r12) goto L10;
        r10 = r10 + r0;
        long r1 = bytesToNanos(r12);
    L8:
        this.allocatedUntil = r10 + r1;
        return r12;
    L10:
        long r6 = this.waitByteCount;
        if (r4 < r6) goto L14;
        this.allocatedUntil = r10 + bytesToNanos(this.maxByteCount);
        return r4;
    L14:
        r12 = Math.min(r6, r12);
        long r2 = r0 + bytesToNanos(r12 - this.maxByteCount);
        if (r2 != 0) goto L18;
        r1 = bytesToNanos(this.maxByteCount);
        goto L8
    L18:
        return -r2;
    }

    public final void bytesPerSecond(long r10) {
        bytesPerSecond$default(this, r10, 0, 0, 6, null);
    }

    public final void bytesPerSecond(long r10, long r12) {
        bytesPerSecond$default(this, r10, r12, 0, 4, null);
    }

    public final void bytesPerSecond(long r6, long r8, long r10) {
        monitor-enter(this);
        boolean r3 = true;
        if (r6 < 0) goto L6;
        boolean r2 = true;
    L30:
        if (r2 == false) goto L26;
        if (r8 <= 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L24;
        if (r10 >= r8) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L22;
        this.bytesPerSecond = r6;     // Catch: Throwable -> L27
        this.waitByteCount = r8;     // Catch: Throwable -> L27
        this.maxByteCount = r10;     // Catch: Throwable -> L27
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L27
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L22:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
    L24:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
    L11:
        r0 = false;
        goto L12
    L26:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L6:
        r2 = false;
        goto L30
    }

    public final Sink sink(Sink r3) {
        final Sink r4 = (Sink) ZeusTransformUtils.wrapperContextForParams(r3, Sink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "sink");
        return (Sink) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r4, r4), Sink.class, "com.obric.memorydata.plugin");
    }

    public final Source source(Source r3) {
        final Source r4 = (Source) ZeusTransformUtils.wrapperContextForParams(r3, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, AILabCheckPermissionTask.KEY_SOURCE);
        return (Source) ZeusTransformUtils.preCheckCast(new C12921(this, r4, r4), Source.class, "com.obric.memorydata.plugin");
    }

    public final long take$jvm(long r6) {
        if (r6 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L20;
        monitor-enter(this);
    L21:
        long r3 = byteCountOrWaitNanos$jvm(System.nanoTime(), r6);     // Catch: Throwable -> L16
        if (r3 >= 0) goto L11;
        waitNanos(-r3);     // Catch: Throwable -> L16
        goto L21
    L11:
        monitor-exit(this);
        return r3;
    L16:
        th = move-exception;
        throw th;
    L20:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r2 = false;
        goto L6
    }
}
