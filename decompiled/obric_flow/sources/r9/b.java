package r9;

import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest$Priority;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements WeakHandler.IHandler {
    public static final AtomicInteger e = null;
    public static final b f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHandler f21701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ThreadPoolExecutor f21702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ThreadPoolExecutor f21703c;
    public ThreadPoolExecutor d;

    static {
        e = new AtomicInteger();
        b r5 = new b();
        r5.f21701a = new WeakHandler(Looper.getMainLooper(), r5);
        f = r5;
    }

    public final void a(a r5) {
        if (r5.f21698a.get() == false) goto L5;
        return;
    L5:
        r5.f21700c = e.incrementAndGet();
        if (r5.e != IRequest$Priority.IMMEDIATE) goto L8;
        d().execute(r5);
        return;
    L8:
        long r10 = r5.f21699b;
        if (r10 <= 0) goto L11;
        Message r11 = Message.obtain();
        r11.what = 0;
        r11.obj = r5;
        this.f21701a.sendMessageDelayed(r11, r10);
        return;
    L11:
        c().execute(r5);
    }

    public final void b(a r11) {
        if (r11.f21698a.get() == false) goto L5;
        return;
    L5:
        r11.f21700c = e.incrementAndGet();
        if (r11.e != IRequest$Priority.IMMEDIATE) goto L8;
        d().execute(r11);
        return;
    L8:
        long r5 = r11.f21699b;
        if (r5 <= 0) goto L11;
        Message r10 = Message.obtain();
        r10.what = 1;
        r10.obj = r11;
        this.f21701a.sendMessageDelayed(r10, r5);
        return;
    L11:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L13:
        if (this.d != null) goto L17;
        c.i().getClass();     // Catch: Throwable -> L15
        this.d = null;     // Catch: Throwable -> L15
        ThreadPoolExecutor r12 = new ThreadPoolExecutor(c.i().d, c.i().f21708b, c.i().f, TimeUnit.SECONDS, new PriorityBlockingQueue(), new com.bytedance.ies.bullet.prefetchv2.d("NetDownload", 1));     // Catch: Throwable -> L15
        this.d = r12;     // Catch: Throwable -> L15
        r12.allowCoreThreadTimeOut(c.i().f21710h);     // Catch: Throwable -> L15
    L17:
        ThreadPoolExecutor r13 = this.d;     // Catch: Throwable -> L15
        monitor-exit(this);
        r13.execute(r11);
    }

    public final synchronized ThreadPoolExecutor c() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f21703c != null) goto L8;
        c.i().getClass();     // Catch: Throwable -> L6
        this.f21703c = null;     // Catch: Throwable -> L6
        ThreadPoolExecutor r5 = new ThreadPoolExecutor(c.i().f21709c, c.i().f21707a, c.i().e, TimeUnit.SECONDS, new PriorityBlockingQueue(), new com.bytedance.ies.bullet.prefetchv2.d("NetNormal", 1));     // Catch: Throwable -> L6
        this.f21703c = r5;     // Catch: Throwable -> L6
        r5.allowCoreThreadTimeOut(c.i().f21710h);     // Catch: Throwable -> L6
    L8:
        ThreadPoolExecutor r10 = this.f21703c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    public final synchronized ThreadPoolExecutor d() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f21702b != null) goto L8;
        c.i().getClass();     // Catch: Throwable -> L6
        this.f21702b = null;     // Catch: Throwable -> L6
        this.f21702b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, c.i().g, TimeUnit.SECONDS, new SynchronousQueue(), new com.bytedance.ies.bullet.prefetchv2.d("NetImmediate", 1));     // Catch: Throwable -> L6
    L8:
        ThreadPoolExecutor r5 = this.f21702b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if ((r5.obj instanceof Runnable) == false) goto L23;
        int r10 = r5.what;     // Catch: Throwable -> L12
        if (r10 != 0) goto L9;
        c().execute((Runnable) r5.obj);     // Catch: Throwable -> L12
    L18:
        return;
    L9:
        if (r10 != 1) goto L18;
        d().execute((Runnable) r5.obj);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
