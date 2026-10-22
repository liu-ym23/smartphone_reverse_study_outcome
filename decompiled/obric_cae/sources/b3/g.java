package b3;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import c2.l;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue f3043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f3044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Handler f3045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3046d;

    public static class a {
    }

    public static class b {
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f3047a;

        public c(g r8) {
            this.f3047a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L3:
            if (g.c(this.f3047a).isEmpty() == true) goto L15;
            Object r8 = g.a(this.f3047a);
            monitor-enter(r8);
            if (this.f3047a.f3045c == null) goto L9;
            this.f3047a.f3045c.sendMessageAtFrontOfQueue((Message) g.c(this.f3047a).poll());     // Catch: Throwable -> L11
        L9:
            monitor-exit(r8);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        L15:
            if (g.b(this.f3047a).isEmpty() == true) goto L26;
            Object r10 = g.a(this.f3047a);
            monitor-enter(r10);
            e r11 = (e) g.b(this.f3047a).poll();     // Catch: Throwable -> L23
            if (this.f3047a.f3045c == null) goto L21;
            Handler r12 = this.f3047a.f3045c;     // Catch: Throwable -> L23
            r11.getClass();     // Catch: Throwable -> L23
            r11.getClass();     // Catch: Throwable -> L23
            r12.sendMessageAtTime(null, 0);     // Catch: Throwable -> L23
        L21:
            monitor-exit(r10);     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            throw th;
        }
    }

    public class d extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f3048a;

        public d(g r8, String r10) {
            this.f3048a = r8;
            super(r10);
        }

        /* JADX INFO: Infinite loop detected, blocks: 9, insns: 0 */
        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            Object r8 = this.f3048a.f3046d;
            monitor-enter(r8);
            g r10 = this.f3048a;     // Catch: Throwable -> L11
            r10.f3045c = new Handler();     // Catch: Throwable -> L11
            monitor-exit(r8);     // Catch: Throwable -> L11
            this.f3048a.f3045c.post(new c(this.f3048a));
        L14:
            Looper.loop();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            l.a.f3306a.getClass();
            l.a(th);
        L11:
            th = move-exception;
            throw th;
        }
    }

    public static class e {
    }

    static {
        new a();
        new b();
    }

    public g(String r8) {
        this.f3043a = new ConcurrentLinkedQueue();
        this.f3044b = new ConcurrentLinkedQueue();
        this.f3046d = new Object();
        new d(this, r8);
    }

    public static /* synthetic */ Object a(g r8) {
        return r8.f3046d;
    }

    public static /* synthetic */ ConcurrentLinkedQueue b(g r8) {
        return r8.f3043a;
    }

    public static /* synthetic */ ConcurrentLinkedQueue c(g r8) {
        return r8.f3044b;
    }
}
