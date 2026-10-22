package nu;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class f0 {
    public static final e0 Companion = null;

    @JvmField
    public static final f0 NONE = null;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    static {
        Companion = new e0();
        NONE = new d0();
    }

    public f0 clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public f0 clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public final f0 deadline(long r5, TimeUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        if (r5 <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L10;
        long r12 = System.nanoTime();
        return deadlineNanoTime(r10.toNanos(r5) + r12);
    L10:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r5, "duration <= 0: ").toString());
    L5:
        r11 = false;
        goto L6
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline == false) goto L7;
        return this.deadlineNanoTime;
    L7:
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(f0 r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "other");
        Intrinsics.checkNotNullParameter(r13, "block");
        long r5 = timeoutNanos();
        e0 r10 = Companion;
        long r11 = r12.timeoutNanos();
        long r14 = timeoutNanos();
        r10.getClass();
        if (r11 != 0) goto L6;
    L11:
        r11 = r14;
    L12:
        TimeUnit r15 = TimeUnit.NANOSECONDS;
        timeout(r11, r15);
        if (hasDeadline() == false) goto L29;
        long r16 = deadlineNanoTime();
        if (r12.hasDeadline() == false) goto L45;
        deadlineNanoTime(Math.min(deadlineNanoTime(), r12.deadlineNanoTime()));
    L45:
        r13.invoke();     // Catch: Throwable -> L22
        InlineMarker.finallyStart(1);
        timeout(r5, r15);
        if (r12.hasDeadline() == false) goto L21;
        deadlineNanoTime(r16);
    L21:
        InlineMarker.finallyEnd(1);
        return;
    L22:
        th = move-exception;
        InlineMarker.finallyStart(1);
        timeout(r5, TimeUnit.NANOSECONDS);
        if (r12.hasDeadline() == false) goto L26;
        deadlineNanoTime(r16);
    L26:
        InlineMarker.finallyEnd(1);
        throw th;
    L29:
        if (r12.hasDeadline() == false) goto L43;
        deadlineNanoTime(r12.deadlineNanoTime());
    L43:
        r13.invoke();     // Catch: Throwable -> L37
        InlineMarker.finallyStart(1);
        timeout(r5, r15);
        if (r12.hasDeadline() == false) goto L35;
        clearDeadline();
    L35:
        InlineMarker.finallyEnd(1);
        return;
    L37:
        th = move-exception;
        InlineMarker.finallyStart(1);
        timeout(r5, TimeUnit.NANOSECONDS);
        if (r12.hasDeadline() == false) goto L41;
        clearDeadline();
    L41:
        InlineMarker.finallyEnd(1);
        throw th;
    L6:
        if (r14 == 0) goto L12;
        if (r11 >= r14) goto L11;
        goto L11
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted() == false) goto L5;
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    L5:
        if (this.hasDeadline == true) goto L7;
        return;
    L7:
        if ((this.deadlineNanoTime - System.nanoTime()) <= 0) goto L10;
        return;
    L10:
        throw new InterruptedIOException("deadline reached");
    }

    public f0 timeout(long r5, TimeUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        if (r5 < 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L10;
        this.timeoutNanos = r10.toNanos(r5);
        return this;
    L10:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r5, "timeout < 0: ").toString());
    L5:
        r11 = false;
        goto L6
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object r10) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(r10, "monitor");
        boolean r5 = hasDeadline();     // Catch: InterruptedException -> L24
        long r11 = timeoutNanos();     // Catch: InterruptedException -> L24
        long r12 = 0;
        if (r5 == false) goto L6;
    L9:
        long r13 = System.nanoTime();     // Catch: InterruptedException -> L24
        if (r5 == true) goto L12;
    L14:
        if (r5 == false) goto L17;
        r11 = deadlineNanoTime() - r13;     // Catch: InterruptedException -> L24
    L17:
        if (r11 <= 0) goto L20;
        long r14 = r11 / 1000000;     // Catch: InterruptedException -> L24
        r10.wait(r14, (int) (r11 - (1000000 * r14)));     // Catch: InterruptedException -> L24
        r12 = System.nanoTime() - r13;     // Catch: InterruptedException -> L24
    L20:
        if (r12 >= r11) goto L23;
        return;
    L23:
        throw new InterruptedIOException("timeout");     // Catch: InterruptedException -> L24
    L12:
        if (r11 == 0) goto L14;
        r11 = Math.min(r11, deadlineNanoTime() - r13);     // Catch: InterruptedException -> L24
        goto L17
    L6:
        if (r11 != 0) goto L9;
        r10.wait();     // Catch: InterruptedException -> L24
        return;
    L24:
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    public f0 deadlineNanoTime(long r5) {
        this.hasDeadline = true;
        this.deadlineNanoTime = r5;
        return this;
    }
}
