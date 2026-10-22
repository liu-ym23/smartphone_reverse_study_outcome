package q0;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.apm.k;
import com.bytedance.apm.util.j;
import com.bytedance.apm6.util.constant.CommonConsts;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final j.a<C0279e, Runnable> f12441f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final j.a<Message, Runnable> f12442g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandlerThread f12443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Queue<C0279e> f12444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue<Message> f12445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Handler f12446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f12447e;

    static class a implements j.a<C0279e, Runnable> {
        a() {
        }

        public boolean a(C0279e r10, Runnable r11) {
            if (r11 != null) goto L12;
            if (r10 == null) goto L20;
            Message r12 = r10.f12450a;
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
            Message r13 = r10.f12450a;
            if (r13 == null) goto L19;
            if (r11.equals(r13.getCallback()) == false) goto L19;
            return true;
        L19:
            return false;
        }

        @Override // com.bytedance.apm.util.j.a
        public /* bridge */ /* synthetic */ boolean equals(C0279e r10, Runnable r11) {
            return a(r10, r11);
        }
    }

    static class b implements j.a<Message, Runnable> {
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

        @Override // com.bytedance.apm.util.j.a
        public /* bridge */ /* synthetic */ boolean equals(Message r10, Runnable r11) {
            return a(r10, r11);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f12448c;

        c(e r10) {
            this.f12448c = r10;
        }

        void a() {
        L3:
            if (e.c(this.f12448c).isEmpty() == true) goto L14;
            Object r10 = e.a(this.f12448c);
            monitor-enter(r10);
            if (this.f12448c.f12446d == null) goto L9;
            this.f12448c.f12446d.sendMessageAtFrontOfQueue((Message) e.c(this.f12448c).poll());     // Catch: Throwable -> L11
        L9:
            monitor-exit(r10);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        void b() {
        L3:
            if (e.b(this.f12448c).isEmpty() == true) goto L14;
            Object r10 = e.a(this.f12448c);
            monitor-enter(r10);
            C0279e r11 = (C0279e) e.b(this.f12448c).poll();     // Catch: Throwable -> L11
            if (this.f12448c.f12446d == null) goto L9;
            this.f12448c.f12446d.sendMessageAtTime(r11.f12450a, r11.f12451b);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r10);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            b();
        }
    }

    class d extends HandlerThread {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f12449c;

        d(e r10, String r11) {
            this.f12449c = r10;
            super(r11);
        }

        /* JADX INFO: Infinite loop detected, blocks: 9, insns: 0 */
        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Object r10 = e.a(this.f12449c);
            monitor-enter(r10);
            e r11 = this.f12449c;     // Catch: Throwable -> L11
            r11.f12446d = new Handler();     // Catch: Throwable -> L11
            monitor-exit(r10);     // Catch: Throwable -> L11
            this.f12449c.f12446d.post(new c(this.f12449c));
        L16:
            Looper.loop();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            k.e().b(th, CommonConsts.APM_INNER_ERROR);
        L11:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: q0.e$e, reason: collision with other inner class name */
    static class C0279e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Message f12450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f12451b;

        C0279e(Message r10, long r11) {
            this.f12450a = r10;
            this.f12451b = r11;
        }
    }

    static {
        f12441f = new a();
        f12442g = new b();
    }

    public e(String r10) {
        this.f12444b = new ConcurrentLinkedQueue();
        this.f12445c = new ConcurrentLinkedQueue();
        this.f12447e = new Object();
        this.f12443a = new d(this, r10);
    }

    static /* synthetic */ Object a(e r10) {
        return r10.f12447e;
    }

    static /* synthetic */ Queue b(e r10) {
        return r10.f12444b;
    }

    static /* synthetic */ Queue c(e r10) {
        return r10.f12445c;
    }

    public Message d(Runnable r10) {
        return Message.obtain(this.f12446d, r10);
    }

    public boolean e() {
        if (this.f12446d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean f(Runnable r10) {
        return j(d(r10), 0);
    }

    public final boolean g(Runnable r10, long r11) {
        return j(d(r10), r11);
    }

    public final void h(Runnable r10) {
        if (this.f12444b.isEmpty() == true) goto L5;
    L6:
        j.d(this.f12444b, r10, f12441f);
        j.d(this.f12445c, r10, f12442g);
    L8:
        if (this.f12446d == null) goto L11;
        this.f12446d.removeCallbacks(r10);
        return;
    L11:
        return;
    L5:
        if (this.f12445c.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean i(Message r10, long r11) {
        if (this.f12446d != null) goto L17;
        Object r12 = this.f12447e;
        monitor-enter(r12);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f12446d != null) goto L11;
        this.f12444b.add(new C0279e(r10, r11));     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L13
    L17:
        return this.f12446d.sendMessageAtTime(r10, r11);
    }

    public final boolean j(Message r10, long r11) {
        if (r11 >= 0) goto L6;
        r11 = 0;
    L6:
        return i(r10, SystemClock.uptimeMillis() + r11);
    }

    public void k() {
        this.f12443a.start();
    }
}
