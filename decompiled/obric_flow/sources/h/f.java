package h;

import ai.y;
import bolts.ExecutorException;
import com.bytedance.android.anniex.scene.core.i;
import com.lynx.tasm.ui.image.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final ExecutorService g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y f17262h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f17263i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f17264j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f f17265k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f f17266l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f17267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17269c;
    public Object d;
    public Exception e;
    public ArrayList f;

    static {
        c r5 = c.d;
        g = r5.f17256a;
        f17262h = r5.f17258c;
        f17263i = b.f17253b.f17255a;
        new f(null);
        f17264j = new f(Boolean.TRUE);
        f17265k = new f(Boolean.FALSE);
        f17266l = new f(0);
    }

    public f() {
        this.f17267a = new Object();
        this.f = new ArrayList();
    }

    public static f b(Callable r5, Executor r10) {
        k6.a r11 = new k6.a(8);
        r10.execute(new v(7, r11, false, r5));     // Catch: Exception -> L5
    L8:
        return (f) r11.f18623a;
    L5:
        e = move-exception;
        r11.h(new ExecutorException(e));
        goto L8
    }

    public final f a(d r10) {
        y r5 = f17262h;
        k6.a r11 = new k6.a(8);
        Object r12 = this.f17267a;
        monitor-enter(r12);
        Object r13 = this.f17267a;     // Catch: Throwable -> L10
        monitor-enter(r13);     // Catch: Throwable -> L10
        boolean r14 = this.f17268b;     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        if (r14 == true) goto L12;
        this.f.add(new e(r11, r10, r5, 0));     // Catch: Throwable -> L10
    L12:
        monitor-exit(r12);     // Catch: Throwable -> L10
        if (r14 == false) goto L19;
        r5.execute(new i(r11, 17, r10, this));     // Catch: Exception -> L16
    L16:
        e = move-exception;
        r11.h(new ExecutorException(e));
    L19:
        return (f) r11.f18623a;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final Exception c() {
        Object r5 = this.f17267a;
        monitor-enter(r5);
        Exception r10 = this.e;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean d(Object r5) {
        Object r10 = this.f17267a;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f17268b == false) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L9
        return false;
    L11:
        this.f17268b = true;     // Catch: Throwable -> L9
        this.d = r5;     // Catch: Throwable -> L9
        this.f17267a.notifyAll();     // Catch: Throwable -> L9
        f();     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return true;
    }

    public final boolean e() {
        Object r5 = this.f17267a;
        monitor-enter(r5);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (c() == null) goto L7;
        boolean r10 = true;
    L8:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return r10;
    L7:
        r10 = false;
        goto L8
    }

    public final void f() {
        Object r5 = this.f17267a;
        monitor-enter(r5);
        Iterator r10 = this.f.iterator();     // Catch: Throwable -> L10
    L6:
        if (r10.hasNext() == false) goto L17;
        ((d) r10.next()).a(this);     // Catch: Throwable -> L10 Exception -> L12 RuntimeException -> L15
    L15:
        e = move-exception;
        throw e;     // Catch: Throwable -> L10
    L12:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L10
    L17:
        this.f = null;     // Catch: Throwable -> L10
        monitor-exit(r5);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean g() {
        Object r5 = this.f17267a;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f17268b == false) goto L11;
        monitor-exit(r5);     // Catch: Throwable -> L9
        return false;
    L11:
        this.f17268b = true;     // Catch: Throwable -> L9
        this.f17269c = true;     // Catch: Throwable -> L9
        this.f17267a.notifyAll();     // Catch: Throwable -> L9
        f();     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return true;
    }

    public f(Boolean r5) {
        this.f17267a = new Object();
        this.f = new ArrayList();
        d(r5);
    }

    public f(int r5) {
        this.f17267a = new Object();
        this.f = new ArrayList();
        g();
    }
}
