package l9;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class u {
    public static final f9.a f = null;
    public static final ib.d g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f19594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f19595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue f19596c;
    public volatile Handler d;
    public final Object e;

    static {
        f = new f9.a(12);
        g = new ib.d(12);
    }

    public u() {
        this.f19595b = new ConcurrentLinkedQueue();
        this.f19596c = new ConcurrentLinkedQueue();
        this.e = new Object();
        this.f19594a = new s(this);
    }

    public static void d(ConcurrentLinkedQueue r5, Runnable r10, r r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L21;
        Iterator r12 = r5.iterator();     // Catch: Throwable -> L13
    L7:
        if (r12.hasNext() == false) goto L23;
        if (r11.c(r12.next(), r10) == false) goto L7;
        r12.remove();     // Catch: Throwable -> L13
    L23:
        return;
    L22:
        return;
    }

    public final void a(Message r5, long r10) {
        if (r10 >= 0) goto L5;
        r10 = 0;
    L5:
        long r11 = SystemClock.uptimeMillis() + r10;
        if (this.d != null) goto L24;
        Object r12 = this.e;
        monitor-enter(r12);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (this.d != null) goto L16;
        this.f19595b.add(new t(r5, r11));     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        return;
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L14
    L24:
        this.d.sendMessageAtTime(r5, r11);     // Catch: Throwable -> L22
        return;
    }

    public final void b(Runnable r5) {
        a(Message.obtain(this.d, r5), 0);
    }

    public final void c(Runnable r5, long r10) {
        a(Message.obtain(this.d, r5), r10);
    }
}
