package nb;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f11299g = "b";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile int f11300h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f11301i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile b f11302j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f11303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f11304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f11305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HandlerC0250b f11306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f11307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f11308f;

    public interface a {
        void a();
    }

    /* JADX INFO: renamed from: nb.b$b, reason: collision with other inner class name */
    private class HandlerC0250b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f11309a;

        public HandlerC0250b(b r10, Looper r11) {
            this.f11309a = r10;
            super(r11);
        }

        public void a() {
            sendEmptyMessage(1);
        }

        public void b() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            if (r10.what != 1) goto L7;
            this.f11309a.b();
            sendEmptyMessageDelayed(1, 1000);
            return;
        }
    }

    static {
    }

    private b() {
        this.f11303a = new CopyOnWriteArrayList();
        this.f11308f = 0;
        this.f11304b = j.b();
        this.f11305c = new AtomicInteger();
        this.f11306d = new HandlerC0250b(this, sb.c.b());
    }

    public static long c() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static b d() {
        if (f11302j != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11302j != null) goto L9;
        f11302j = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f11302j;
    }

    public static boolean e() {
        if (f11300h != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean f() {
        if (f11300h == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void k() {
        f11300h = com.ss.android.socialbase.downloader.utils.g.y(com.ss.android.socialbase.downloader.downloader.a.h());
    }

    protected void a() {
        b();
        f11301i = -1;
    }

    protected void b() {
        System.currentTimeMillis();     // Catch: Exception -> L20
        k();     // Catch: Exception -> L20
        if (f() == false) goto L5;
        long r10 = c();     // Catch: Exception -> L20
    L6:
        long r11 = f11301i;     // Catch: Exception -> L20
        long r12 = r10 - r11;     // Catch: Exception -> L20
        if (r11 < 0) goto L15;
        monitor-enter(this);     // Catch: Exception -> L20
        long r13 = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        this.f11304b.a(r12, r13 - this.f11307e);     // Catch: Throwable -> L12
        this.f11307e = r13;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L20
    L15:
        f11301i = r10;     // Catch: Exception -> L20
        Iterator<a> r14 = this.f11303a.iterator();     // Catch: Exception -> L20
    L17:
        if (r14.hasNext() == false) goto L27;
        r14.next().a();     // Catch: Exception -> L20
        goto L17
    L27:
        return;
    L5:
        r10 = TrafficStats.getMobileRxBytes();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    }

    public void g(a r10) {
        this.f11303a.add(r10);
    }

    public void h(a r10) {
        this.f11303a.remove(r10);
    }

    public void i() {
        if (lb.a.a() == false) goto L6;
        lb.a.b(f11299g, "startSampling", "SamplingCounter = " + this.f11305c);     // Catch: Throwable -> L9
    L6:
        if (this.f11305c.getAndIncrement() != 0) goto L12;
        this.f11306d.a();     // Catch: Throwable -> L9
        this.f11307e = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        this.f11308f = System.currentTimeMillis();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public void j() {
        if (lb.a.a() == false) goto L6;
        lb.a.b(f11299g, "stopSampling", "SamplingCounter = " + this.f11305c);     // Catch: Throwable -> L9
    L6:
        if (this.f11305c.decrementAndGet() != 0) goto L12;
        this.f11306d.b();     // Catch: Throwable -> L9
        a();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }
}
