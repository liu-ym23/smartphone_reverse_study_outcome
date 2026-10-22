package sb;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f12784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue<b> f12785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f12786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f12787d;

    private class a extends HandlerThread {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f12788c;

        a(e r10, String r11) {
            this.f12788c = r10;
            super(r11);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Looper r10 = getLooper();
            Object r11 = e.a(this.f12788c);
            monitor-enter(r11);
            e.c(this.f12788c, new Handler(r10));     // Catch: Throwable -> L12
            monitor-exit(r11);     // Catch: Throwable -> L12
        L7:
            if (e.d(this.f12788c).isEmpty() == true) goto L11;
            b r12 = (b) e.d(this.f12788c).poll();
            if (r12 == null) goto L7;
            e.b(this.f12788c).postDelayed(r12.f12789a, r12.f12790b);
            goto L7
        L11:
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f12789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f12790b;

        public b(e r10, Runnable r11, long r12) {
            this.f12789a = r11;
            this.f12790b = r12;
        }
    }

    public e(String r10) {
        this.f12784a = new Object();
        this.f12785b = new ConcurrentLinkedQueue();
        this.f12786c = new a(this, r10);
    }

    static /* synthetic */ Object a(e r10) {
        return r10.f12784a;
    }

    static /* synthetic */ Handler b(e r10) {
        return r10.f12787d;
    }

    static /* synthetic */ Handler c(e r10, Handler r11) {
        r10.f12787d = r11;
        return r11;
    }

    static /* synthetic */ Queue d(e r10) {
        return r10.f12785b;
    }

    public void e(Runnable r10) {
        f(r10, 0);
    }

    public void f(Runnable r10, long r11) {
        if (this.f12787d != null) goto L16;
        Object r12 = this.f12784a;
        monitor-enter(r12);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f12787d != null) goto L11;
        this.f12785b.add(new b(this, r10, r11));     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L13
    L16:
        this.f12787d.postDelayed(r10, r11);
    }

    public void g() {
        this.f12786c.quit();
    }

    public void h() {
        this.f12786c.start();
    }
}
