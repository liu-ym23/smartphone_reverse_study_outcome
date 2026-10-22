package jf;

import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class c extends x {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f8822h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f8823i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public static c f8824j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public c f8826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f8827g;

    public static final class a extends Thread {
        public a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
        L20:
            monitor-enter(c.class);     // Catch: InterruptedException -> L19
            c r8 = c.i();     // Catch: Throwable -> L16
            if (r8 == null) goto L6;
            if (r8 != c.f8824j) goto L13;
            c.f8824j = null;     // Catch: Throwable -> L16
            monitor-exit(c.class);     // Catch: Throwable -> L16
            goto L20
        L12:
            return;
        L13:
            monitor-exit(c.class);     // Catch: Throwable -> L16
            r8.o();     // Catch: InterruptedException -> L19
            goto L20
        L6:
            monitor-exit(c.class);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L19
        }
    }

    static {
        long r8 = TimeUnit.SECONDS.toMillis(60);
        f8822h = r8;
        f8823i = TimeUnit.MILLISECONDS.toNanos(r8);
    }

    public c() {
    }

    @Nullable
    public static c i() {
        c r8 = f8824j.f8826f;
        long r10 = System.nanoTime();
        if (r8 != null) goto L10;
        c.class.wait(f8822h);
        if (f8824j.f8826f == null) goto L7;
        return null;
    L7:
        if ((System.nanoTime() - r10) >= f8823i) goto L9;
        return null;
    L9:
        return f8824j;
    L10:
        long r11 = r8.f8827g - r10;
        if (r11 <= 0) goto L14;
        long r12 = r11 / BwdlDropUtils.DROP_SHOW_MEGABYTES;
        c.class.wait(r12, (int) (r11 - (BwdlDropUtils.DROP_SHOW_MEGABYTES * r12)));
        return null;
    L14:
        c r13 = f8824j;
        r13.f8826f = r8.f8826f;
        r8.f8826f = null;
        return r8;
    }

    public final void j() {
        if (this.f8825e == true) goto L39;
        long r8 = this.f8884c;
        boolean r10 = this.f8882a;
        if (r8 != 0) goto L8;
        if (r10 == true) goto L8;
        return;
    L8:
        this.f8825e = true;
        monitor-enter(c.class);
    L35:
        th = move-exception;
        throw th;
    L11:
        if (f8824j != null) goto L13;
        f8824j = new c();     // Catch: Throwable -> L35
        new a().start();     // Catch: Throwable -> L35
    L13:
        long r11 = System.nanoTime();     // Catch: Throwable -> L35
        if (r8 == 0) goto L17;
        if (r10 == false) goto L17;
        r8 = Math.min(r8, c() - r11);     // Catch: Throwable -> L35
    L18:
        this.f8827g = r8 + r11;     // Catch: Throwable -> L35
    L21:
        long r12 = this.f8827g - r11;     // Catch: Throwable -> L35
        c r13 = f8824j;     // Catch: Throwable -> L35
    L22:
        c r14 = r13.f8826f;     // Catch: Throwable -> L35
        if (r14 == null) goto L28;
        if (r12 < (r14.f8827g - r11)) goto L28;
        r13 = r14;
    L28:
        this.f8826f = r14;     // Catch: Throwable -> L35
        r13.f8826f = this;     // Catch: Throwable -> L35
        if (r13 != f8824j) goto L31;
        c.class.notify();     // Catch: Throwable -> L35
    L31:
        monitor-exit(c.class);
        return;
    L17:
        if (r8 != 0) goto L18;
        if (r10 == false) goto L34;
        this.f8827g = c();     // Catch: Throwable -> L35
        goto L21
    L34:
        throw new AssertionError();     // Catch: Throwable -> L35
    L39:
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final IOException k(IOException r8) {
        if (m() == true) goto L6;
        return r8;
    L6:
        return n(r8);
    }

    public final void l(boolean r8) {
        if (m() == false) goto L8;
        if (r8 == true) goto L7;
        return;
    L7:
        throw n(null);
    }

    public final boolean m() {
        if (this.f8825e == true) goto L5;
        return false;
    L5:
        this.f8825e = false;
        monitor-enter(c.class);
        c r8 = f8824j;     // Catch: Throwable -> L18
    L8:
        if (r8 == null) goto L15;
        c r10 = r8.f8826f;     // Catch: Throwable -> L18
        if (r10 == this) goto L11;
        r8 = r10;
        goto L8
    L11:
        r8.f8826f = this.f8826f;     // Catch: Throwable -> L18
        this.f8826f = null;     // Catch: Throwable -> L18
        monitor-exit(c.class);
        return false;
    L15:
        monitor-exit(c.class);
        return true;
    L18:
        th = move-exception;
        throw th;
    }

    public IOException n(@Nullable IOException r8) {
        InterruptedIOException r10 = new InterruptedIOException("timeout");
        if (r8 == null) goto L5;
        r10.initCause(r8);
    L5:
        return r10;
    }

    public void o() {
    }
}
