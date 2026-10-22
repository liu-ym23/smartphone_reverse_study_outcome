package v6;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class d implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AtomicInteger f12741o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f12742p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHandler f12743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ThreadPoolExecutor f12744b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ThreadPoolExecutor f12745m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ThreadPoolExecutor f12746n;

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f12747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f12748b;

        /* JADX INFO: renamed from: v6.d$a$a, reason: collision with other inner class name */
        public class C0179a extends Thread {
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        public a(String r8) {
            this.f12747a = new AtomicInteger(1);
            this.f12748b = "ApiExecutor";
            if (TextUtils.isEmpty(r8) == true) goto L6;
            this.f12748b = r8;
            return;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            C0179a r10 = new C0179a(r8, this.f12748b + "#" + this.f12747a.getAndIncrement());
            r10.setDaemon(false);
            return r10;
        }
    }

    static {
        f12741o = new AtomicInteger();
        f12742p = new d();
    }

    public d() {
        this.f12743a = new WeakHandler(Looper.getMainLooper(), this);
    }

    public final void a(v6.a r8) {
        if (r8.d() == true) goto L15;
        r8.e(f12741o.incrementAndGet());
        if (r8.b() != c.a.f12739n) goto L8;
        ThreadPoolExecutor r10 = d();
    L12:
        r10.execute(r8);
        return;
    L8:
        long r11 = r8.c();
        if (r11 <= 0) goto L11;
        Message r12 = Message.obtain();
        r12.what = 0;
        r12.obj = r8;
        this.f12743a.sendMessageDelayed(r12, r11);
        return;
    L11:
        r10 = c();
        goto L12
    }

    public final void b(v6.a r10) {
        if (r10.d() == false) goto L5;
        return;
    L5:
        r10.e(f12741o.incrementAndGet());
        if (r10.b() != c.a.f12739n) goto L8;
        d().execute(r10);
        return;
    L8:
        long r8 = r10.c();
        if (r8 <= 0) goto L11;
        Message r11 = Message.obtain();
        r11.what = 1;
        r11.obj = r10;
        this.f12743a.sendMessageDelayed(r11, r8);
        return;
    L11:
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L13:
        if (this.f12746n != null) goto L15;
        ThreadPoolExecutor r12 = new ThreadPoolExecutor(e.a().f12755d, e.a().f12753b, e.a().f12757f, TimeUnit.SECONDS, new PriorityBlockingQueue(), new a("NetDownload"));     // Catch: Throwable -> L19
        this.f12746n = r12;     // Catch: Throwable -> L19
        r12.allowCoreThreadTimeOut(e.a().f12759h);     // Catch: Throwable -> L19
    L15:
        ThreadPoolExecutor r13 = this.f12746n;     // Catch: Throwable -> L19
        monitor-exit(this);
        r13.execute(r10);
    }

    public final synchronized ThreadPoolExecutor c() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f12745m != null) goto L6;
        ThreadPoolExecutor r8 = new ThreadPoolExecutor(e.a().f12754c, e.a().f12752a, e.a().f12756e, TimeUnit.SECONDS, new PriorityBlockingQueue(), new a("NetNormal"));     // Catch: Throwable -> L9
        this.f12745m = r8;     // Catch: Throwable -> L9
        r8.allowCoreThreadTimeOut(e.a().f12759h);     // Catch: Throwable -> L9
    L6:
        ThreadPoolExecutor r10 = this.f12745m;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r10;
    }

    public final synchronized ThreadPoolExecutor d() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f12744b != null) goto L6;
        e.a().getClass();     // Catch: Throwable -> L9
        this.f12744b = null;     // Catch: Throwable -> L9
        this.f12744b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, e.a().f12758g, TimeUnit.SECONDS, new SynchronousQueue(), new a("NetImmediate"));     // Catch: Throwable -> L9
    L6:
        ThreadPoolExecutor r8 = this.f12744b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r8;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if ((r8.obj instanceof Runnable) == false) goto L23;
        int r10 = r8.what;     // Catch: Throwable -> L16
        if (r10 != 0) goto L9;
        ThreadPoolExecutor r11 = c();     // Catch: Throwable -> L16
        Object r12 = r8.obj;     // Catch: Throwable -> L16
    L14:
        r11.execute((Runnable) r12);     // Catch: Throwable -> L16
        return;
    L9:
        if (r10 != 1) goto L22;
        r11 = d();     // Catch: Throwable -> L16
        r12 = r8.obj;     // Catch: Throwable -> L16
        goto L14
    L22:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
