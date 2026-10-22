package com.google.common.util.concurrent;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o extends gl.a implements w0 {
    public static final boolean d = false;
    public static final Logger e = null;
    public static final p0 f = null;
    public static final Object g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f9424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile c f9425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile n f9426c;

    static {
        boolean r5 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));     // Catch: SecurityException -> L5
    L6:
        d = r5;
        e = Logger.getLogger(o.class.getName());
        Throwable r10 = null;
        p0 r11 = new m();     // Catch: Throwable -> L9
        th = null;
    L14:
        f = r11;
        if (r10 == null) goto L17;
        Logger r12 = e;
        Level r13 = Level.SEVERE;
        r12.log(r13, "UnsafeAtomicHelper is broken!", th);
        r12.log(r13, "SafeAtomicHelper is broken!", r10);
    L17:
        g = new Object();
        return;
    L9:
        th = th;
        r11 = new d(AtomicReferenceFieldUpdater.newUpdater(n.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(n.class, n.class, "b"), AtomicReferenceFieldUpdater.newUpdater(o.class, n.class, "c"), AtomicReferenceFieldUpdater.newUpdater(o.class, c.class, "b"), AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "a"));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r10 = th;
        r11 = new f();
    L5:
        r5 = false;
        goto L6
    }

    public static void d(o r10) {
        c r5 = null;
    L3:
        r10.getClass();
        n r11 = f.f(r10);
    L4:
        if (r11 == null) goto L9;
        Thread r12 = r11.f9422a;
        if (r12 == null) goto L8;
        r11.f9422a = null;
        LockSupport.unpark(r12);
    L8:
        r11 = r11.f9423b;
        goto L4
    L9:
        r10.b();
        c r13 = r5;
        c r14 = f.e(r10);
        c r15 = r13;
    L10:
        if (r14 == null) goto L12;
        c r16 = r14.f9405c;
        r14.f9405c = r15;
        r15 = r14;
        r14 = r16;
    L12:
        if (r15 == null) goto L22;
        r5 = r15.f9405c;
        Runnable r17 = r15.f9403a;
        Objects.requireNonNull(r17);
        if ((r17 instanceof e) == false) goto L20;
        e r18 = (e) r17;
        r10 = r18.f9409a;
        if (r10.f9424a != r18) goto L21;
        if (f.b(r10, r18, g(r18.f9410b)) == true) goto L3;
    L21:
        r15 = r5;
        goto L12
    L20:
        Executor r19 = r15.f9404b;
        Objects.requireNonNull(r19);
        e(r17, r19);
        goto L21
    }

    public static void e(Runnable r5, Executor r10) {
        r10.execute(r5);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        Level r11 = Level.SEVERE;
        String r12 = String.valueOf(r5);
        String r13 = String.valueOf(r10);
        int r14 = r12.length() + 57;
        StringBuilder r15 = new StringBuilder(r13.length() + r14);
        r15.append("RuntimeException while executing runnable ");
        r15.append(r12);
        r15.append(" with executor ");
        r15.append(r13);
        String r16 = r15.toString();
        e.log(r11, r16, e);
    }

    public static Object f(Object r5) {
        if ((r5 instanceof a) == false) goto L5;
        RuntimeException r10 = ((a) r5).f9400b;
        CancellationException r11 = new CancellationException("Task was cancelled.");
        r11.initCause(r10);
        throw r11;
    L5:
        if ((r5 instanceof b) == true) goto L11;
        if (r5 != g) goto L14;
        return null;
    L14:
        return r5;
    L11:
        throw new ExecutionException(((b) r5).f9402a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object g(w0 r10) {
        if ((r10 instanceof g) == false) goto L15;
        Object r11 = ((o) r10).f9424a;
        if ((r11 instanceof a) == false) goto L12;
        a r5 = (a) r11;
        if (r5.f9399a == false) goto L12;
        if (r5.f9400b == null) goto L11;
        r11 = new a(false, r5.f9400b);
        goto L12
    L11:
        r11 = a.d;
    L12:
        Objects.requireNonNull(r11);
        return r11;
    L15:
        if ((r10 instanceof gl.a) == false) goto L25;
        o r12 = (o) ((gl.a) r10);
        r12.getClass();
        if ((r12 instanceof g) == false) goto L21;
        Object r13 = r12.f9424a;
        if ((r13 instanceof b) == false) goto L21;
        Throwable r14 = ((b) r13).f9402a;
    L22:
        if (r14 == null) goto L25;
        return new b(r14);
    L21:
        r14 = null;
    L25:
        boolean r15 = r10.isCancelled();
        if (((!d) & r15) == false) goto L54;
        a r16 = a.d;
        Objects.requireNonNull(r16);
        return r16;
    L54:
        Object r17 = h(r10);     // Catch: Throwable -> L33 CancellationException -> L35 ExecutionException -> L37
        if (r15 == false) goto L39;
        String r18 = String.valueOf(r10);     // Catch: Throwable -> L33 CancellationException -> L35 ExecutionException -> L37
        StringBuilder r19 = new StringBuilder(r18.length() + 84);     // Catch: Throwable -> L33 CancellationException -> L35 ExecutionException -> L37
        r19.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");     // Catch: Throwable -> L33 CancellationException -> L35 ExecutionException -> L37
        r19.append(r18);     // Catch: Throwable -> L33 CancellationException -> L35 ExecutionException -> L37
        return new a(false, new IllegalArgumentException(r19.toString()));
    L39:
        if (r17 == null) goto L41;
        return r17;
    L41:
        return g;
    L35:
        e = move-exception;
        if (r15 == true) goto L48;
        String r20 = String.valueOf(r10);
        return new b(new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.l(r20.length() + 77, "get() threw CancellationException, despite reporting isCancelled() == false: ", r20), e));
    L48:
        return new a(false, e);
    L37:
        e = move-exception;
        if (r15 == false) goto L53;
        String r21 = String.valueOf(r10);
        return new a(false, new IllegalArgumentException(androidx.room.jarjarred.org.antlr.runtime.a.l(r21.length() + 84, "get() did not throw CancellationException, despite reporting isCancelled() == true: ", r21), e));
    L53:
        return new b(e.getCause());
    L33:
        th = move-exception;
        return new b(th);
    }

    public static Object h(w0 r5) {
        boolean r10 = false;
    L12:
        Object r11 = r5.get();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r10 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r11;
    L11:
        r10 = true;
    L7:
        th = move-exception;
        if (r10 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    public final void a(StringBuilder r5) {
        Object r10 = h(this);     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r5.append("SUCCESS, result=[");     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        c(r5, r10);     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r5.append("]");     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
    L17:
        return;
    L10:
        r5.append("CANCELLED");
        return;
    L5:
        e = move-exception;
        r5.append("UNKNOWN, cause=[");
        r5.append(e.getClass());
        r5.append(" thrown from get()]");
        return;
    L7:
        e = move-exception;
        r5.append("FAILURE, cause=[");
        r5.append(e.getCause());
        r5.append("]");
    }

    @Override // com.google.common.util.concurrent.w0
    public void addListener(Runnable r5, Executor r10) {
        com.google.common.base.b0.n(r10, "Executor was null.");
        if (isDone() == true) goto L12;
        c r11 = this.f9425b;
        c r12 = c.d;
        if (r11 == r12) goto L12;
        c r13 = new c(r5, r10);
    L7:
        r13.f9405c = r11;
        if (f.a(this, r11, r13) == true) goto L9;
        r11 = this.f9425b;
        if (r11 != r12) goto L7;
    L9:
        return;
    L12:
        e(r5, r10);
    }

    public void b() {
    }

    public final void c(StringBuilder r5, Object r10) {
        if (r10 != null) goto L4;
        r5.append("null");
        return;
    L4:
        if (r10 != this) goto L6;
        r5.append("this future");
        return;
    L6:
        r5.append(r10.getClass().getName());
        r5.append("@");
        r5.append(Integer.toHexString(System.identityHashCode(r10)));
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r10) {
        Object r5 = this.f9424a;
        if (r5 != null) goto L5;
        boolean r11 = true;
    L7:
        if ((r11 | (r5 instanceof e)) == false) goto L34;
        if (d == false) goto L11;
        a r12 = new a(r10, new CancellationException("Future.cancel() was called."));
    L15:
        boolean r13 = false;
    L17:
        if (f.b(this, r5, r12) == true) goto L18;
        r5 = this.f9424a;
        if ((r5 instanceof e) == true) goto L17;
        return r13;
    L18:
        d(this);
        if ((r5 instanceof e) == false) goto L46;
        w0 r14 = ((e) r5).f9410b;
        if ((r14 instanceof g) == false) goto L29;
        o this = (o) r14;
        r5 = this.f9424a;
        if (r5 != null) goto L25;
        boolean r15 = true;
    L27:
        if ((r15 | (r5 instanceof e)) == false) goto L47;
        r13 = true;
        goto L17
    L47:
        return true;
    L25:
        r15 = false;
        goto L27
    L29:
        r14.cancel(r10);
        return true;
    L46:
        return true;
    L11:
        if (r10 == false) goto L13;
        r12 = a.f9398c;
    L14:
        Objects.requireNonNull(r12);
        goto L15
    L13:
        r12 = a.d;
        goto L14
    L34:
        return false;
    L5:
        r11 = false;
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00b4 -> B:36:0x007d). Please report as a decompilation issue!!! */
    @Override // java.util.concurrent.Future
    public Object get(long r20, TimeUnit r22) {
        long r5 = r22.toNanos(r20);
        if (Thread.interrupted() == true) goto L83;
        Object r10 = this.f9424a;
        if (r10 == null) goto L7;
        boolean r11 = true;
    L9:
        if ((r11 & (!(r10 instanceof e))) == false) goto L13;
        return f(r10);
    L13:
        if (r5 <= 0) goto L15;
        long r12 = System.nanoTime() + r5;
    L17:
        if (r5 < 1000) goto L43;
        n r13 = this.f9426c;
        n r15 = n.f9421c;
        if (r13 == r15) goto L41;
        n r14 = new n();
    L21:
        p0 r16 = f;
        r16.i(r14, r13);
        if (r16.c(this, r13, r14) == true) goto L23;
        r13 = this.f9426c;
        if (r13 != r15) goto L21;
    L23:
        LockSupport.parkNanos(this, Math.min(r5, 2147483647999999999L));
        if (Thread.interrupted() == true) goto L37;
        Object r17 = this.f9424a;
        if (r17 == null) goto L28;
        boolean r18 = true;
    L30:
        if ((r18 & (!(r17 instanceof e))) == true) goto L32;
        r5 = r12 - System.nanoTime();
        if (r5 >= 1000) goto L23;
        j(r14);
    L36:
        long r19 = 0;
    L45:
        if (r5 <= r19) goto L59;
        Object r21 = this.f9424a;
        if (r21 == null) goto L49;
        boolean r23 = true;
    L51:
        if ((r23 & (!(r21 instanceof e))) == false) goto L55;
        return f(r21);
    L55:
        if (Thread.interrupted() == true) goto L58;
        r5 = r12 - System.nanoTime();
        goto L36
    L58:
        throw new InterruptedException();
    L49:
        r23 = false;
        goto L51
    L59:
        String r24 = toString();
        String r25 = r22.toString();
        Locale r26 = Locale.ROOT;
        String r27 = r25.toLowerCase(r26);
        String r28 = r22.toString().toLowerCase(r26);
        StringBuilder r110 = new StringBuilder(androidx.room.jarjarred.org.antlr.runtime.a.g(28, r28));
        r110.append("Waited ");
        r110.append(r20);
        r110.append(" ");
        r110.append(r28);
        String r29 = r110.toString();
        if ((r5 + 1000) >= 0) goto L77;
        String r30 = String.valueOf(r29).concat(" (plus ");
        long r31 = -r5;
        long r32 = r22.convert(r31, TimeUnit.NANOSECONDS);
        long r33 = r31 - r22.toNanos(r32);
        if (r32 != 0) goto L64;
    L67:
        boolean r111 = true;
    L68:
        if (r32 <= 0) goto L73;
        String r34 = String.valueOf(r30);
        StringBuilder r35 = new StringBuilder(androidx.room.jarjarred.org.antlr.runtime.a.g(r34.length() + 21, r27));
        r35.append(r34);
        r35.append(r32);
        r35.append(" ");
        r35.append(r27);
        String r36 = r35.toString();
        if (r111 == false) goto L72;
        r36 = String.valueOf(r36).concat(",");
    L72:
        r30 = String.valueOf(r36).concat(" ");
    L73:
        if (r111 == false) goto L75;
        String r37 = String.valueOf(r30);
        StringBuilder r38 = new StringBuilder(r37.length() + 33);
        r38.append(r37);
        r38.append(r33);
        r38.append(" nanoseconds ");
        r30 = r38.toString();
    L75:
        r29 = String.valueOf(r30).concat("delay)");
        goto L77
    L64:
        if (r33 > 1000) goto L67;
        r111 = false;
    L77:
        if (isDone() == false) goto L81;
        throw new TimeoutException(String.valueOf(r29).concat(" but future completed as timeout expired"));
    L81:
        throw new TimeoutException(androidx.room.jarjarred.org.antlr.runtime.a.m(androidx.room.jarjarred.org.antlr.runtime.a.g(androidx.room.jarjarred.org.antlr.runtime.a.g(5, r29), r24), r29, " for ", r24));
    L32:
        return f(r17);
    L28:
        r18 = false;
        goto L30
    L37:
        j(r14);
        throw new InterruptedException();
    L41:
        Object r39 = this.f9424a;
        Objects.requireNonNull(r39);
        return f(r39);
    L43:
        r19 = 0;
        goto L45
    L15:
        r12 = 0;
        goto L17
    L7:
        r11 = false;
        goto L9
    L83:
        throw new InterruptedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String i() {
        if ((this instanceof ScheduledFuture) == false) goto L6;
        long r5 = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder r10 = new StringBuilder(41);
        r10.append("remaining delay=[");
        r10.append(r5);
        r10.append(" ms]");
        return r10.toString();
    L6:
        return null;
    }

    public boolean isCancelled() {
        return this.f9424a instanceof a;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object r5 = this.f9424a;
        if (r5 == null) goto L5;
        boolean r10 = true;
    L7:
        return (!(r5 instanceof e)) & r10;
    L5:
        r10 = false;
        goto L7
    }

    public final void j(n r5) {
        r5.f9422a = null;
    L3:
        n r10 = this.f9426c;
        if (r10 == n.f9421c) goto L5;
        n r11 = null;
    L7:
        if (r10 == null) goto L19;
        n r12 = r10.f9423b;
        if (r10.f9422a == null) goto L11;
        r11 = r10;
    L18:
        r10 = r12;
        goto L7
    L11:
        if (r11 == null) goto L16;
        r11.f9423b = r12;
        if (r11.f9422a != null) goto L18;
    L16:
        if (f.c(this, r10, r12) == true) goto L18;
    L19:
        return;
    }

    public boolean k(Throwable r5) {
        r5.getClass();
        b r10 = new b(r5);
        if (f.b(this, null, r10) == false) goto L6;
        d(this);
        return true;
    L6:
        return false;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.") == false) goto L5;
        r5.append(getClass().getSimpleName());
    L6:
        r5.append('@');
        r5.append(Integer.toHexString(System.identityHashCode(this)));
        r5.append("[status=");
        if (isCancelled() == false) goto L10;
        r5.append("CANCELLED");
    L39:
        r5.append("]");
        return r5.toString();
    L10:
        if (isDone() == false) goto L12;
        a(r5);
        goto L39
    L12:
        int r10 = r5.length();
        r5.append("PENDING");
        Object r11 = this.f9424a;
        if ((r11 instanceof e) == false) goto L41;
        r5.append(", setFuture=[");
        w0 r12 = ((e) r11).f9410b;
        if (r12 != this) goto L19;
        r5.append("this future");     // Catch: Throwable -> L17
    L43:
    L22:
        r5.append("]");
    L37:
        if (isDone() == false) goto L39;
        r5.delete(r10, r5.length());
        a(r5);
        goto L39
    L19:
        r5.append(r12);     // Catch: Throwable -> L17
    L17:
        e = move-exception;
        r5.append("Exception thrown from implementation: ");
        r5.append(e.getClass());
        goto L22
    L41:
        String r13 = i();     // Catch: Throwable -> L32
        com.bytedance.sdk.xbridge.cn.auth.g r14 = com.google.common.base.y.f8677a;     // Catch: Throwable -> L32
        if (r13 == null) goto L29;
        if (r13.isEmpty() == true) goto L29;
        boolean r15 = false;
    L30:
        if (r15 == false) goto L34;
        r13 = null;
    L34:
        if (r13 == null) goto L37;
        r5.append(", info=[");
        r5.append(r13);
        r5.append("]");
    L29:
        r15 = true;
    L32:
        e = move-exception;
        String r16 = String.valueOf(e.getClass());
        r13 = androidx.room.jarjarred.org.antlr.runtime.a.l(r16.length() + 38, "Exception thrown from implementation: ", r16);
        goto L34
    L5:
        r5.append(getClass().getName());
        goto L6
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        if (Thread.interrupted() == true) goto L34;
        Object r5 = this.f9424a;
        if (r5 == null) goto L7;
        boolean r10 = true;
    L9:
        if ((r10 & (!(r5 instanceof e))) == true) goto L11;
        n r11 = this.f9426c;
        n r12 = n.f9421c;
        if (r11 == r12) goto L31;
        n r13 = new n();
    L15:
        p0 r14 = f;
        r14.i(r13, r11);
        if (r14.c(this, r11, r13) == true) goto L17;
        r11 = this.f9426c;
        if (r11 != r12) goto L15;
    L17:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L27;
        Object r15 = this.f9424a;
        if (r15 == null) goto L22;
        boolean r16 = true;
    L24:
        if ((r16 & (!(r15 instanceof e))) == false) goto L17;
        return f(r15);
    L22:
        r16 = false;
        goto L24
    L27:
        j(r13);
        throw new InterruptedException();
    L31:
        Object r17 = this.f9424a;
        Objects.requireNonNull(r17);
        return f(r17);
    L11:
        return f(r5);
    L7:
        r10 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }
}
