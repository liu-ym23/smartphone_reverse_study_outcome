package k3;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final l3.c.a<e, Runnable> f10048f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final l3.c.a<Message, Runnable> f10049g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandlerThread f10050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Queue<e> f10051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue<Message> f10052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Handler f10053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f10054e;

    static class a implements l3.c.a<e, Runnable> {
        a() {
        }

        public boolean a(e r10, Runnable r11) {
            if (r11 != null) goto L12;
            if (r10 == null) goto L20;
            Message r12 = r10.f10057a;
            if (r12 != null) goto L8;
            return true;
        L8:
            if (r12.getCallback() != null) goto L11;
            return true;
        L11:
            return false;
        L20:
            return true;
        L12:
            if (r10 == null) goto L19;
            Message r13 = r10.f10057a;
            if (r13 == null) goto L19;
            if (r11.equals(r13.getCallback()) == false) goto L19;
            return true;
        L19:
            return false;
        }

        @Override // l3.c.a
        public /* bridge */ /* synthetic */ boolean equals(e r10, Runnable r11) {
            return a(r10, r11);
        }
    }

    static class b implements l3.c.a<Message, Runnable> {
        b() {
        }

        public boolean a(Message r10, Runnable r11) {
            if (r11 != null) goto L10;
            if (r10 != null) goto L6;
            return true;
        L6:
            if (r10.getCallback() != null) goto L9;
            return true;
        L9:
            return false;
        L10:
            if (r10 == null) goto L15;
            if (r11.equals(r10.getCallback()) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // l3.c.a
        public /* bridge */ /* synthetic */ boolean equals(Message r10, Runnable r11) {
            return a(r10, r11);
        }
    }

    /* JADX INFO: renamed from: k3.c$c, reason: collision with other inner class name */
    class RunnableC0215c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f10055c;

        RunnableC0215c(c r10) {
            this.f10055c = r10;
        }

        void a() {
        L3:
            if (c.e(this.f10055c).isEmpty() == true) goto L7;
            if (c.b(this.f10055c) == null) goto L3;
            c.b(this.f10055c).sendMessageAtFrontOfQueue((Message) c.e(this.f10055c).poll());
            goto L3
        }

        void b() {
        L3:
            if (c.d(this.f10055c).isEmpty() == true) goto L7;
            e r10 = (e) c.d(this.f10055c).poll();
            if (c.b(this.f10055c) == null) goto L3;
            c.b(this.f10055c).sendMessageAtTime(r10.f10057a, r10.f10058b);
            goto L3
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            b();
        }
    }

    class d extends HandlerThread {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f10056c;

        d(c r10, String r11) {
            this.f10056c = r10;
            super(r11);
        }

        /* JADX INFO: Infinite loop detected, blocks: 7, insns: 0 */
        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Object r10 = c.a(this.f10056c);
            monitor-enter(r10);
            c.c(this.f10056c, new Handler());     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            c.b(this.f10056c).post(new RunnableC0215c(this.f10056c));
        L13:
            Looper.loop();     // Catch: Throwable -> L12
        L9:
            th = move-exception;
            throw th;
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Message f10057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f10058b;

        e(Message r10, long r11) {
            this.f10057a = r10;
            this.f10058b = r11;
        }
    }

    static {
        f10048f = new a();
        f10049g = new b();
    }

    public c(String r10) {
        this.f10051b = new ConcurrentLinkedQueue();
        this.f10052c = new ConcurrentLinkedQueue();
        this.f10054e = new Object();
        this.f10050a = new d(this, r10);
    }

    static /* synthetic */ Object a(c r10) {
        return r10.f10054e;
    }

    static /* synthetic */ Handler b(c r10) {
        return r10.f10053d;
    }

    static /* synthetic */ Handler c(c r10, Handler r11) {
        r10.f10053d = r11;
        return r11;
    }

    static /* synthetic */ Queue d(c r10) {
        return r10.f10051b;
    }

    static /* synthetic */ Queue e(c r10) {
        return r10.f10052c;
    }

    private Message f(Runnable r10) {
        return Message.obtain(this.f10053d, r10);
    }

    public final boolean g(Runnable r10) {
        return k(f(r10), 0);
    }

    public final boolean h(Runnable r10, long r11) {
        return k(f(r10), r11);
    }

    public final void i(Runnable r10) {
        if (this.f10051b.isEmpty() == true) goto L5;
    L6:
        l3.c.f(this.f10051b, r10, f10048f);
        l3.c.f(this.f10052c, r10, f10049g);
    L8:
        if (this.f10053d == null) goto L11;
        this.f10053d.removeCallbacks(r10);
        return;
    L11:
        return;
    L5:
        if (this.f10052c.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean j(Message r10, long r11) {
        if (this.f10053d != null) goto L17;
        Object r12 = this.f10054e;
        monitor-enter(r12);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f10053d != null) goto L11;
        this.f10051b.add(new e(r10, r11));     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L13
    L17:
        return this.f10053d.sendMessageAtTime(r10, r11);
    }

    public final boolean k(Message r10, long r11) {
        if (r11 >= 0) goto L6;
        r11 = 0;
    L6:
        return j(r10, SystemClock.uptimeMillis() + r11);
    }

    public void l() {
        this.f10050a.start();
    }
}
