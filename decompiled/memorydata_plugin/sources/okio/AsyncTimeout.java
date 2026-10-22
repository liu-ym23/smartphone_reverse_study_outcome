package okio;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0004J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\rJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\rJ\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", "next", "timeoutAt", "", "enter", "", "exit", "Ljava/io/IOException;", "cause", "exit$jvm", "throwOnTimeout", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Source;", "timedOut", "Companion", "Watchdog", "jvm"}, k = 1, mv = {1, 1, 11})
public class AsyncTimeout extends Timeout {
    public static final Companion Companion = null;
    private static final long IDLE_TIMEOUT_MILLIS = 0;
    private static final long IDLE_TIMEOUT_NANOS = 0;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "TIMEOUT_WRITE_SIZE", "", "head", "Lokio/AsyncTimeout;", "awaitTimeout", "awaitTimeout$jvm", "cancelScheduledTimeout", "", "node", "scheduleTimeout", "", "timeoutNanos", "hasDeadline", "jvm"}, k = 1, mv = {1, 1, 11})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ boolean access$cancelScheduledTimeout(Companion r0, AsyncTimeout r1) {
            return r0.cancelScheduledTimeout(r1);
        }

        public static final /* synthetic */ void access$scheduleTimeout(Companion r0, AsyncTimeout r1, long r2, boolean r4) {
            r0.scheduleTimeout(r1, r2, r4);
        }

        private final boolean cancelScheduledTimeout(AsyncTimeout r4) {
            monitor-enter(AsyncTimeout.class);
            AsyncTimeout r0 = AsyncTimeout.access$getHead$cp();     // Catch: Throwable -> L15
        L5:
            if (r0 == null) goto L14;
            if (AsyncTimeout.access$getNext$p(r0) == r4) goto L8;
            r0 = AsyncTimeout.access$getNext$p(r0);     // Catch: Throwable -> L15
            goto L5
        L8:
            AsyncTimeout.access$setNext$p(r0, AsyncTimeout.access$getNext$p(r4));     // Catch: Throwable -> L15
            AsyncTimeout.access$setNext$p(r4, (AsyncTimeout) ZeusTransformUtils.preCheckCast(null, AsyncTimeout.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
            boolean r5 = false;
        L10:
            monitor-exit(AsyncTimeout.class);
            return r5;
        L14:
            r5 = true;
        L15:
            th = move-exception;
            throw th;
        }

        private final void scheduleTimeout(AsyncTimeout r5, long r6, boolean r8) {
            monitor-enter(AsyncTimeout.class);
        L38:
            th = move-exception;
            throw th;
        L5:
            if (AsyncTimeout.access$getHead$cp() != null) goto L7;
            AsyncTimeout.access$setHead$cp(new AsyncTimeout());     // Catch: Throwable -> L38
            new Watchdog().start();     // Catch: Throwable -> L38
        L7:
            long r0 = System.nanoTime();     // Catch: Throwable -> L38
            if (r6 == 0) goto L12;
            if (r8 == false) goto L12;
            r6 = Math.min(r6, r5.deadlineNanoTime() - r0);     // Catch: Throwable -> L38
        L11:
            AsyncTimeout.access$setTimeoutAt$p(r5, r6 + r0);     // Catch: Throwable -> L38
        L16:
            long r7 = AsyncTimeout.access$remainingNanos(r5, r0);     // Catch: Throwable -> L38
            AsyncTimeout r9 = AsyncTimeout.access$getHead$cp();     // Catch: Throwable -> L38
            if (r9 != null) goto L20;
            Intrinsics.throwNpe();     // Catch: Throwable -> L38
        L20:
            if (AsyncTimeout.access$getNext$p(r9) == null) goto L30;
            AsyncTimeout r2 = AsyncTimeout.access$getNext$p(r9);     // Catch: Throwable -> L38
            if (r2 != null) goto L25;
            Intrinsics.throwNpe();     // Catch: Throwable -> L38
        L25:
            if (r7 < AsyncTimeout.access$remainingNanos(r2, r0)) goto L30;
            r9 = AsyncTimeout.access$getNext$p(r9);     // Catch: Throwable -> L38
            if (r9 != null) goto L20;
            Intrinsics.throwNpe();     // Catch: Throwable -> L38
        L30:
            AsyncTimeout.access$setNext$p(r5, AsyncTimeout.access$getNext$p(r9));     // Catch: Throwable -> L38
            AsyncTimeout.access$setNext$p(r9, r5);     // Catch: Throwable -> L38
            if (r9 != AsyncTimeout.access$getHead$cp()) goto L33;
            ZeusTransformUtils.preCheckCast(AsyncTimeout.class, Object.class, "com.obric.memorydata.plugin").notify();     // Catch: Throwable -> L38
        L33:
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L38
            monitor-exit(AsyncTimeout.class);
            return;
        L12:
            if (r6 != 0) goto L11;
            if (r8 == false) goto L37;
            AsyncTimeout.access$setTimeoutAt$p(r5, r5.deadlineNanoTime());     // Catch: Throwable -> L38
            goto L16
        L37:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError(), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L38
        }

        public final AsyncTimeout awaitTimeout$jvm() {
            AsyncTimeout r8 = AsyncTimeout.access$getHead$cp();
            if (r8 != null) goto L5;
            Intrinsics.throwNpe();
        L5:
            AsyncTimeout r9 = AsyncTimeout.access$getNext$p(r8);
            long r2 = System.nanoTime();
            if (r9 != null) goto L16;
            ZeusTransformUtils.preCheckCast(AsyncTimeout.class, Object.class, "com.obric.memorydata.plugin").wait(AsyncTimeout.access$getIDLE_TIMEOUT_MILLIS$cp());
            AsyncTimeout r10 = AsyncTimeout.access$getHead$cp();
            if (r10 != null) goto L11;
            Intrinsics.throwNpe();
        L11:
            if (AsyncTimeout.access$getNext$p(r10) == null) goto L13;
            return null;
        L13:
            if ((System.nanoTime() - r2) >= AsyncTimeout.access$getIDLE_TIMEOUT_NANOS$cp()) goto L15;
            return null;
        L15:
            return AsyncTimeout.access$getHead$cp();
        L16:
            long r3 = AsyncTimeout.access$remainingNanos(r9, r2);
            if (r3 <= 0) goto L20;
            long r6 = r3 / TimeUtils.NANOSECONDS_PER_MILLISECOND;
            long r4 = r3 - (TimeUtils.NANOSECONDS_PER_MILLISECOND * r6);
            ZeusTransformUtils.preCheckCast(AsyncTimeout.class, Object.class, "com.obric.memorydata.plugin").wait(r6, (int) r4);
            return null;
        L20:
            AsyncTimeout r5 = AsyncTimeout.access$getHead$cp();
            if (r5 != null) goto L23;
            Intrinsics.throwNpe();
        L23:
            AsyncTimeout.access$setNext$p(r5, AsyncTimeout.access$getNext$p(r9));
            AsyncTimeout.access$setNext$p(r9, (AsyncTimeout) ZeusTransformUtils.preCheckCast(null, AsyncTimeout.class, "com.obric.memorydata.plugin"));
            return r9;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "jvm"}, k = 1, mv = {1, 1, 11})
    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L19:
            AsyncTimeout r3 = (AsyncTimeout) ZeusTransformUtils.preCheckCast(null, AsyncTimeout.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L16
            monitor-enter(AsyncTimeout.class);     // Catch: InterruptedException -> L16
            AsyncTimeout r0 = AsyncTimeout.Companion.awaitTimeout$jvm();     // Catch: Throwable -> L13
            if (r0 != AsyncTimeout.access$getHead$cp()) goto L9;
            AsyncTimeout.access$setHead$cp((AsyncTimeout) ZeusTransformUtils.preCheckCast(null, AsyncTimeout.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
            goto L19
        L7:
            monitor-exit(AsyncTimeout.class);     // Catch: InterruptedException -> L16
            return;
        L9:
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(AsyncTimeout.class);     // Catch: InterruptedException -> L16
            if (r0 == null) goto L19;
            r0.timedOut();     // Catch: InterruptedException -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L16
        }
    }

    static {
        Companion = new Companion(null);
        long r0 = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = r0;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(r0);
    }

    public AsyncTimeout() {
    }

    public static final /* synthetic */ AsyncTimeout access$getHead$cp() {
        return head;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_MILLIS$cp() {
        return IDLE_TIMEOUT_MILLIS;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_NANOS$cp() {
        return IDLE_TIMEOUT_NANOS;
    }

    public static final /* synthetic */ AsyncTimeout access$getNext$p(AsyncTimeout r0) {
        return r0.next;
    }

    public static final /* synthetic */ long access$getTimeoutAt$p(AsyncTimeout r2) {
        return r2.timeoutAt;
    }

    public static final /* synthetic */ long access$remainingNanos(AsyncTimeout r0, long r1) {
        return r0.remainingNanos(r1);
    }

    public static final /* synthetic */ void access$setHead$cp(AsyncTimeout r0) {
        head = r0;
    }

    public static final /* synthetic */ void access$setNext$p(AsyncTimeout r0, AsyncTimeout r1) {
        r0.next = r1;
    }

    public static final /* synthetic */ void access$setTimeoutAt$p(AsyncTimeout r0, long r1) {
        r0.timeoutAt = r1;
    }

    private final long remainingNanos(long r3) {
        return this.timeoutAt - r3;
    }

    public final void enter() {
        if ((!this.inQueue) == false) goto L11;
        long r2 = timeoutNanos();
        boolean r0 = hasDeadline();
        if (r2 != 0) goto L8;
        if (r0 == true) goto L8;
        return;
    L8:
        this.inQueue = true;
        Companion.access$scheduleTimeout(Companion, this, r2, r0);
        return;
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Unbalanced enter/exit".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final boolean exit() {
        if (this.inQueue == true) goto L5;
        return false;
    L5:
        this.inQueue = false;
        return Companion.access$cancelScheduledTimeout(Companion, this);
    }

    public final IOException exit$jvm(IOException r2) {
        Intrinsics.checkParameterIsNotNull(r2, "cause");
        if (exit() == true) goto L6;
        return r2;
    L6:
        return newTimeoutException(r2);
    }

    public final void exit$jvm(boolean r2) {
        if (exit() == false) goto L8;
        if (r2 == true) goto L7;
        return;
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(newTimeoutException(null), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public IOException newTimeoutException(IOException r3) {
        InterruptedIOException r2 = new InterruptedIOException(LocationMonitorConst.TIMEOUT);
        if (r3 == null) goto L6;
        r2.initCause((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
    L6:
        return (IOException) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.memorydata.plugin");
    }

    public final Sink sink(Sink r3) {
        final Sink r4 = (Sink) ZeusTransformUtils.wrapperContextForParams(r3, Sink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "sink");
        return (Sink) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r4), Sink.class, "com.obric.memorydata.plugin");
    }

    public final Source source(Source r3) {
        final Source r4 = (Source) ZeusTransformUtils.wrapperContextForParams(r3, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, AILabCheckPermissionTask.KEY_SOURCE);
        return (Source) ZeusTransformUtils.preCheckCast(new C12891(this, r4), Source.class, "com.obric.memorydata.plugin");
    }

    public void timedOut() {
    }
}
