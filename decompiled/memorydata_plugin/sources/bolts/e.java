package bolts;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes.dex */
public class e implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f101b;
    private ScheduledFuture<?> c;
    private boolean d;
    private boolean e;

    private void b() {
        if (this.e == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Object already closed");
    }

    private void c() {
        ScheduledFuture<?> r0 = this.c;
        if (r0 == null) goto L6;
        r0.cancel(true);
        this.c = null;
        return;
    }

    d a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Object r0 = this.f100a;
        monitor-enter(r0);
        b();     // Catch: Throwable -> L10
        d r1 = new d(this, r4);     // Catch: Throwable -> L10
        if (this.d == false) goto L7;
        r1.a();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        this.f101b.add(r1);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    void a(d r2) {
        Object r0 = this.f100a;
        monitor-enter(r0);
        b();     // Catch: Throwable -> L7
        this.f101b.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean a() {
        Object r0 = this.f100a;
        monitor-enter(r0);
        b();     // Catch: Throwable -> L7
        boolean r1 = this.d;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Object r0 = this.f100a;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.e == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        c();     // Catch: Throwable -> L15
        Iterator<d> r1 = this.f101b.iterator();     // Catch: Throwable -> L15
    L10:
        if (r1.hasNext() == false) goto L12;
        ((d) ZeusTransformUtils.preCheckCast(r1.next(), d.class, "com.obric.memorydata.plugin")).close();     // Catch: Throwable -> L15
        goto L10
    L12:
        this.f101b.clear();     // Catch: Throwable -> L15
        this.e = true;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(a())});
    }
}
