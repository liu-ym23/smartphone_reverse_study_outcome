package bolts;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public class d implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f98a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f99b;
    private Runnable c;
    private boolean d;

    d(e r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        this.f98a = new Object();
        this.f99b = r3;
        this.c = r5;
    }

    private void b() {
        if (this.d == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Object already closed");
    }

    void a() {
        Object r0 = this.f98a;
        monitor-enter(r0);
        b();     // Catch: Throwable -> L7
        this.c.run();     // Catch: Throwable -> L7
        close();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Object r0 = this.f98a;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.d == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.d = true;     // Catch: Throwable -> L11
        this.f99b.a(this);     // Catch: Throwable -> L11
        this.f99b = null;     // Catch: Throwable -> L11
        this.c = null;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }
}
