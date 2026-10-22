package nu;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class e extends f0 {
    public static final b Companion = null;
    private static final long IDLE_TIMEOUT_MILLIS = 0;
    private static final long IDLE_TIMEOUT_NANOS = 0;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static e head;
    private boolean inQueue;
    private e next;
    private long timeoutAt;

    static {
        Companion = new b();
        long r5 = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = r5;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(r5);
    }

    public static final /* synthetic */ e access$getHead$cp() {
        return head;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_MILLIS$cp() {
        return IDLE_TIMEOUT_MILLIS;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_NANOS$cp() {
        return IDLE_TIMEOUT_NANOS;
    }

    public static final /* synthetic */ e access$getNext$p(e r5) {
        return r5.next;
    }

    public static final /* synthetic */ long access$getTimeoutAt$p(e r5) {
        return r5.timeoutAt;
    }

    public static final long access$remainingNanos(e r5, long r10) {
        return r5.timeoutAt - r10;
    }

    public static final /* synthetic */ void access$setHead$cp(e r5) {
        head = r5;
    }

    public static final /* synthetic */ void access$setNext$p(e r5, e r10) {
        r5.next = r10;
    }

    public static final /* synthetic */ void access$setTimeoutAt$p(e r5, long r10) {
        r5.timeoutAt = r10;
    }

    @PublishedApi
    public final IOException access$newTimeoutException(IOException r5) {
        return newTimeoutException(r5);
    }

    public final void enter() {
        if (this.inQueue == true) goto L41;
        long r5 = timeoutNanos();
        boolean r10 = hasDeadline();
        if (r5 != 0) goto L8;
        if (r10 == true) goto L8;
        return;
    L8:
        this.inQueue = true;
        Companion.getClass();
        monitor-enter(e.class);
    L13:
        th = move-exception;
        throw th;
    L11:
        if (access$getHead$cp() != null) goto L15;
        access$setHead$cp(new e());     // Catch: Throwable -> L13
        am.a r11 = new am.a("Okio Watchdog", 4);     // Catch: Throwable -> L13
        r11.setDaemon(true);     // Catch: Throwable -> L13
        r11.start();     // Catch: Throwable -> L13
    L15:
        long r12 = System.nanoTime();     // Catch: Throwable -> L13
        if (r5 == 0) goto L19;
        if (r10 == false) goto L19;
        access$setTimeoutAt$p(this, Math.min(r5, deadlineNanoTime() - r12) + r12);     // Catch: Throwable -> L13
    L23:
        long r13 = access$remainingNanos(this, r12);     // Catch: Throwable -> L13
        e r14 = access$getHead$cp();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L13
    L25:
        if (access$getNext$p(r14) == null) goto L30;
        e r15 = access$getNext$p(r14);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L13
        if (r13 < access$remainingNanos(r15, r12)) goto L30;
        r14 = access$getNext$p(r14);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L13
    L30:
        access$setNext$p(this, access$getNext$p(r14));     // Catch: Throwable -> L13
        access$setNext$p(r14, this);     // Catch: Throwable -> L13
        if (r14 != access$getHead$cp()) goto L33;
        e.class.notify();     // Catch: Throwable -> L13
    L33:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(e.class);
        return;
    L19:
        if (r5 == 0) goto L21;
        access$setTimeoutAt$p(this, r5 + r12);     // Catch: Throwable -> L13
        goto L23
    L21:
        if (r10 == false) goto L37;
        access$setTimeoutAt$p(this, deadlineNanoTime());     // Catch: Throwable -> L13
        goto L23
    L37:
        throw new AssertionError();     // Catch: Throwable -> L13
    L41:
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean exit() {
        if (this.inQueue == true) goto L5;
        return false;
    L5:
        this.inQueue = false;
        Companion.getClass();
        monitor-enter(e.class);
        e r5 = access$getHead$cp();     // Catch: Throwable -> L14
    L8:
        if (r5 == null) goto L18;
        if (access$getNext$p(r5) == this) goto L11;
        r5 = access$getNext$p(r5);     // Catch: Throwable -> L14
        goto L8
    L11:
        access$setNext$p(r5, access$getNext$p(this));     // Catch: Throwable -> L14
        access$setNext$p(this, null);     // Catch: Throwable -> L14
        monitor-exit(e.class);
        return false;
    L18:
        monitor-exit(e.class);
        return true;
    L14:
        th = move-exception;
        throw th;
    }

    public IOException newTimeoutException(IOException r5) {
        InterruptedIOException r10 = new InterruptedIOException("timeout");
        if (r5 == null) goto L5;
        r10.initCause(r5);
    L5:
        return r10;
    }

    public final a0 sink(a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        return new c(this, r5);
    }

    public final c0 source(c0 r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        return new d(this, r5);
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(Function0<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        enter();
        T r10 = r5.invoke();     // Catch: Throwable -> L10 IOException -> L12
        InlineMarker.finallyStart(1);
        if (exit() == true) goto L9;
        InlineMarker.finallyEnd(1);
        return r10;
    L9:
        throw access$newTimeoutException(null);
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        exit();
        InlineMarker.finallyEnd(1);
        throw th;
    L12:
        e = move-exception;
        if (exit() == true) goto L17;
        throw e;     // Catch: Throwable -> L10
    L17:
        throw access$newTimeoutException(e);     // Catch: Throwable -> L10
    }
}
