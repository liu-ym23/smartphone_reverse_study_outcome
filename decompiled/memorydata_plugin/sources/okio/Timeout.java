package okio;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.dumper.Scraps;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0000H\u0016J\b\u0010\t\u001a\u00020\u0000H\u0016J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001f\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0086\bJ\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/Timeout;", "", "()V", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "clearDeadline", "clearTimeout", "deadline", "duration", Scraps.INNER_UNIT, "Ljava/util/concurrent/TimeUnit;", "intersectWith", "", "other", "block", "Lkotlin/Function0;", "throwIfReached", LocationMonitorConst.TIMEOUT, "waitUntilNotified", CommonConsts.LOG_REPORT_TYPE_DEFAULT, "Companion", "jvm"}, k = 1, mv = {1, 1, 11})
public class Timeout {
    public static final Companion Companion = null;
    public static final Timeout NONE = null;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokio/Timeout$Companion;", "", "()V", "NONE", "Lokio/Timeout;", "minTimeout", "", "aNanos", "bNanos", "jvm"}, k = 1, mv = {1, 1, 11})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final long minTimeout(long r3, long r5) {
            if (r3 == 0) goto L12;
            if (r5 != 0) goto L9;
            return r3;
        L9:
            if (r3 >= r5) goto L12;
            return r3;
        L12:
            return r5;
        }
    }

    static {
        Companion = new Companion(null);
        NONE = (Timeout) ZeusTransformUtils.preCheckCast(new Timeout$Companion$NONE$1(), Timeout.class, "com.obric.memorydata.plugin");
    }

    public Timeout() {
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public final Timeout deadline(long r3, TimeUnit r5) {
        Intrinsics.checkParameterIsNotNull(r5, Scraps.INNER_UNIT);
        if (r3 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return deadlineNanoTime(System.nanoTime() + r5.toNanos(r3));
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("duration <= 0: " + r3).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L6
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline == false) goto L7;
        return this.deadlineNanoTime;
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("No deadline".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public Timeout deadlineNanoTime(long r2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = r2;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(Timeout r11, Function0<Unit> r12) {
        Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r11, "other");
        Intrinsics.checkParameterIsNotNull(r13, "block");
        long r0 = timeoutNanos();
        timeout(Companion.minTimeout(r11.timeoutNanos(), timeoutNanos()), TimeUnit.NANOSECONDS);
        if (hasDeadline() == false) goto L18;
        long r4 = deadlineNanoTime();
        if (r11.hasDeadline() == false) goto L32;
        deadlineNanoTime(Math.min(deadlineNanoTime(), r11.deadlineNanoTime()));
    L32:
        r13.invoke();     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        timeout(r0, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L24;
        deadlineNanoTime(r4);
    L24:
        InlineMarker.finallyEnd(1);
        return;
    L11:
        th = move-exception;
        InlineMarker.finallyStart(1);
        timeout(r0, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L15;
        deadlineNanoTime(r4);
    L15:
        InlineMarker.finallyEnd(1);
        throw th;
    L18:
        if (r11.hasDeadline() == false) goto L34;
        deadlineNanoTime(r11.deadlineNanoTime());
    L34:
        r13.invoke();     // Catch: Throwable -> L26
        InlineMarker.finallyStart(1);
        timeout(r0, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L24;
        clearDeadline();
    L26:
        th = move-exception;
        InlineMarker.finallyStart(1);
        timeout(r0, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L30;
        clearDeadline();
    L30:
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public void throwIfReached() {
        if (Thread.interrupted() == false) goto L5;
        Thread.currentThread().interrupt();
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new InterruptedIOException("interrupted"), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        if (this.hasDeadline == true) goto L7;
        return;
    L7:
        if ((this.deadlineNanoTime - System.nanoTime()) <= 0) goto L10;
        return;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new InterruptedIOException("deadline reached"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public Timeout timeout(long r3, TimeUnit r5) {
        Intrinsics.checkParameterIsNotNull(r5, Scraps.INNER_UNIT);
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.timeoutNanos = r5.toNanos(r3);
        return this;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("timeout < 0: " + r3).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L6
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object r11) {
        Intrinsics.checkParameterIsNotNull(r11, CommonConsts.LOG_REPORT_TYPE_DEFAULT);
        boolean r1 = hasDeadline();     // Catch: InterruptedException -> L24
        long r2 = timeoutNanos();     // Catch: InterruptedException -> L24
        long r4 = 0;
        if (r1 == false) goto L6;
    L9:
        long r6 = System.nanoTime();     // Catch: InterruptedException -> L24
        if (r1 == true) goto L12;
    L14:
        if (r1 == false) goto L17;
        r2 = deadlineNanoTime() - r6;     // Catch: InterruptedException -> L24
    L17:
        if (r2 <= 0) goto L20;
        long r8 = r2 / TimeUtils.NANOSECONDS_PER_MILLISECOND;     // Catch: InterruptedException -> L24
        r11.wait(r8, (int) (r2 - (TimeUtils.NANOSECONDS_PER_MILLISECOND * r8)));     // Catch: InterruptedException -> L24
        r4 = System.nanoTime() - r6;     // Catch: InterruptedException -> L24
    L20:
        if (r4 >= r2) goto L23;
        return;
    L23:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new InterruptedIOException(LocationMonitorConst.TIMEOUT), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: InterruptedException -> L24
    L12:
        if (r2 == 0) goto L14;
        r2 = Math.min(r2, deadlineNanoTime() - r6);     // Catch: InterruptedException -> L24
        goto L17
    L6:
        if (r2 != 0) goto L9;
        r11.wait();     // Catch: InterruptedException -> L24
        return;
    L24:
        Thread.currentThread().interrupt();
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new InterruptedIOException("interrupted"), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
