package q80;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends Scheduler {
    public final Handler a;
    public final boolean b;

    public static final class a extends Scheduler.Worker {
        public final Handler a;
        public final boolean b;
        public volatile boolean c;

        public final void dispose() {
            this.c = true;
            this.a.removeCallbacksAndMessages(this);
        }

        public final boolean isDisposed() {
            return this.c;
        }

        public a(Handler r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Disposable schedule(Runnable r5, long r6, TimeUnit r8) {
            if (r5 == null) goto L23;
            if (r8 == null) goto L21;
            if (this.c == true) goto L7;
            Runnable r7 = RxJavaPlugins.onSchedule(r5);
            Handler r1 = this.a;
            RunnableC0267b r0 = new RunnableC0267b(r1, r7);
            Message r9 = Message.obtain(r1, r0);
            r9.obj = this;
            if (this.b == false) goto L12;
            r9.setAsynchronous(true);
        L12:
            if (r6 > 0) goto L14;
            this.a.sendMessageAtTime(r9, 5);
        L16:
            if (this.c == false) goto L19;
            this.a.removeCallbacks(r0);
            return Disposables.disposed();
        L19:
            return r0;
        L14:
            this.a.sendMessageDelayed(r9, r8.toMillis(r6));
            goto L16
        L7:
            return Disposables.disposed();
        L21:
            throw new NullPointerException("unit == null");
        L23:
            throw new NullPointerException("run == null");
        }
    }

    /* JADX INFO: renamed from: q80.b$b, reason: collision with other inner class name */
    public static final class RunnableC0267b implements Runnable, Disposable {
        public final Handler a;
        public final Runnable b;
        public volatile boolean c;

        public final void dispose() {
            this.a.removeCallbacks(this);
            this.c = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            RxJavaPlugins.onError(th);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public final boolean isDisposed() {
            return this.c;
        }

        public RunnableC0267b(Handler r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final Scheduler.Worker createWorker() {
        return new a(this.a, this.b);
    }

    public b(Handler r1) {
        this.a = r1;
        this.b = false;
    }

    public final Disposable scheduleDirect(Runnable r3, long r4, TimeUnit r6) {
        if (r3 == null) goto L9;
        if (r6 == null) goto L7;
        Runnable r5 = RxJavaPlugins.onSchedule(r3);
        Handler r1 = this.a;
        RunnableC0267b r0 = new RunnableC0267b(r1, r5);
        r1.postDelayed(r0, r6.toMillis(r4));
        return r0;
    L7:
        throw new NullPointerException("unit == null");
    L9:
        throw new NullPointerException("run == null");
    }
}
