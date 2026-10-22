package u7;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12509f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f12510g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerThreadC0173d f12511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f12512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue f12513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Handler f12514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f12515e;

    public static class a implements v7.a.InterfaceC0180a<e, Runnable> {
        @Override // v7.a.InterfaceC0180a
        public final boolean equals(e r8, Runnable r10) {
            e r11 = r8;
            Runnable r12 = r10;
            if (r12 != null) goto L10;
            if (r11 == null) goto L15;
            Message r13 = r11.f12518a;
            if (r13 == null) goto L15;
            if (r13.getCallback() == null) goto L15;
        L16:
            return false;
        L15:
            return true;
        L10:
            if (r11 == null) goto L16;
            Message r14 = r11.f12518a;
            if (r14 == null) goto L16;
            if (r12.equals(r14.getCallback()) == false) goto L16;
            goto L15
        }
    }

    public static class b implements v7.a.InterfaceC0180a<Message, Runnable> {
        @Override // v7.a.InterfaceC0180a
        public final boolean equals(Message r8, Runnable r10) {
            Message r11 = r8;
            Runnable r12 = r10;
            if (r12 != null) goto L8;
            if (r11 != null) goto L6;
        L11:
            return true;
        L6:
            if (r11.getCallback() == null) goto L11;
        L12:
            return false;
        L8:
            if (r11 == null) goto L12;
            if (r12.equals(r11.getCallback()) == false) goto L12;
            goto L11
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f12516a;

        public c(d r8) {
            this.f12516a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L2:
            d r8 = this.f12516a;
            if (d.c(r8).isEmpty() == true) goto L8;
            if (d.a(r8) == null) goto L2;
            d.a(r8).sendMessageAtFrontOfQueue((Message) d.c(r8).poll());
        L8:
            if (d.b(r8).isEmpty() == true) goto L12;
            e r10 = (e) d.b(r8).poll();
            if (d.a(r8) == null) goto L8;
            d.a(r8).sendMessageAtTime(r10.f12518a, r10.f12519b);
            goto L8
        }
    }

    /* JADX INFO: renamed from: u7.d$d, reason: collision with other inner class name */
    public class HandlerThreadC0173d extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f12517a;

        public HandlerThreadC0173d(d r8, String r10) {
            this.f12517a = r8;
            super(r10);
        }

        /* JADX INFO: Infinite loop detected, blocks: 7, insns: 0 */
        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            Object r8 = this.f12517a.f12515e;
            monitor-enter(r8);
            d r10 = this.f12517a;     // Catch: Throwable -> L9
            r10.f12514d = new Handler();     // Catch: Throwable -> L9
            monitor-exit(r8);     // Catch: Throwable -> L9
            this.f12517a.f12514d.post(new c(this.f12517a));
        L13:
            Looper.loop();     // Catch: Throwable -> L12
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Message f12518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f12519b;

        public e(Message r8, long r10) {
            this.f12518a = r8;
            this.f12519b = r10;
        }
    }

    static {
        f12509f = new a();
        f12510g = new b();
    }

    public d(String r8) {
        this.f12512b = new ConcurrentLinkedQueue();
        this.f12513c = new ConcurrentLinkedQueue();
        this.f12515e = new Object();
        this.f12511a = new HandlerThreadC0173d(this, r8);
    }

    public static /* synthetic */ Handler a(d r8) {
        return r8.f12514d;
    }

    public static /* synthetic */ ConcurrentLinkedQueue b(d r8) {
        return r8.f12512b;
    }

    public static /* synthetic */ ConcurrentLinkedQueue c(d r8) {
        return r8.f12513c;
    }

    public final void d(Runnable r8) {
        if (this.f12512b.isEmpty() == true) goto L5;
    L6:
        v7.a.a(this.f12512b, r8, f12509f);
        v7.a.a(this.f12513c, r8, f12510g);
    L8:
        if (this.f12514d == null) goto L11;
        this.f12514d.removeCallbacks(r8);
        return;
    L11:
        return;
    L5:
        if (this.f12513c.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean e(Message r8, long r10) {
        if (r10 >= 0) goto L5;
        r10 = 0;
    L5:
        long r11 = SystemClock.uptimeMillis() + r10;
        if (this.f12514d != null) goto L20;
        Object r12 = this.f12515e;
        monitor-enter(r12);
    L16:
        th = move-exception;
        throw th;
    L10:
        if (this.f12514d != null) goto L14;
        this.f12512b.add(new e(r8, r11));     // Catch: Throwable -> L16
        monitor-exit(r12);     // Catch: Throwable -> L16
        return true;
    L14:
        monitor-exit(r12);     // Catch: Throwable -> L16
    L20:
        return this.f12514d.sendMessageAtTime(r8, r11);
    }
}
