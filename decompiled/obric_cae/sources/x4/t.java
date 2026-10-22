package x4;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f13549a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f13550b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f13551c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f13552d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f13553e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f13554f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f13555g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f13556h = null;

    public static class a extends k5.l<Executor> {
        @Override // k5.l
        @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
        public final Executor a(Object[] r8) {
            return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue());
        }
    }

    public static class b extends k5.l<ExecutorService> {
        @Override // k5.l
        @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
        public final ExecutorService a(Object[] r8) {
            return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5, TimeUnit.SECONDS, new SynchronousQueue());
        }
    }

    public static class c extends k5.l<Looper> {
        @Override // k5.l
        public final Looper a(Object[] r8) {
            HandlerThread r10 = new HandlerThread("bd_install");     // Catch: Exception -> L4
            r10.start();     // Catch: Exception -> L4
            return r10.getLooper();
        L5:
            return Looper.getMainLooper();
        }
    }

    public static class d extends k5.l<Handler> {
        @Override // k5.l
        public final Handler a(Object[] r8) {
            return new Handler(t.f13555g.b(new Object[0]));
        }
    }

    static {
        f13549a = new ConcurrentHashMap(4);
        f13550b = new ConcurrentHashMap(4);
        f13551c = new ConcurrentHashMap(4);
        f13552d = new ConcurrentHashMap(4);
        f13553e = new a();
        f13554f = new b();
        f13555g = new c();
        f13556h = new d();
    }

    public static String a(ConcurrentHashMap r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.size() == 0) goto L16;
        Set r10 = r8.keySet();
        if (r10 != null) goto L9;
        return null;
    L9:
        if (r10.size() > 0) goto L11;
        return null;
    L11:
        return (String) r10.iterator().next();
    L16:
        return null;
    }

    public static Handler b(String r8) {
        if (r8 != null) goto L5;
        d r10 = f13556h;
        return r10.b(new Object[0]);
    L5:
        ConcurrentHashMap r11 = f13552d;
        Handler r12 = (Handler) r11.get(r8);
        if (r12 != null) goto L12;
        Looper r13 = d(r8);
        if (r13 == null) goto L10;
        Handler r14 = new Handler(r13);
        r11.put(r8, r14);
        return r14;
    L10:
        int r15 = r.f13543a;
        return r12;
    L12:
        return r12;
    }

    public static ExecutorService c(String r8) {
        b r10 = f13554f;
        if (r8 != null) goto L5;
        ExecutorService r11 = r10.b(new Object[0]);
    L9:
        return r11;
    L5:
        ExecutorService r12 = (ExecutorService) f13550b.get(r8);
        if (r12 != null) goto L10;
        r11 = r10.b(new Object[0]);
        goto L9
    L10:
        return r12;
    }

    public static Looper d(String r8) {
        c r10 = f13555g;
        if (r8 != null) goto L5;
        Looper r11 = r10.b(new Object[0]);
    L9:
        return r11;
    L5:
        Looper r12 = (Looper) f13551c.get(r8);
        if (r12 != null) goto L10;
        r11 = r10.b(new Object[0]);
        goto L9
    L10:
        return r12;
    }

    public static void e(Runnable r8, String r10) {
        if (Looper.myLooper() != d(r10)) goto L5;
        r8.run();
        return;
    L5:
        Handler r11 = b(r10);
        if (r11 != null) goto L8;
        d r12 = f13556h;
        r11 = r12.b(new Object[0]);
    L8:
        r11.post(r8);
    }

    public static void f(Runnable r8, String r10) {
        c(r10).execute(r8);
    }

    public static void g(Runnable r8, String r10) {
        a r11 = f13553e;
        if (r10 != null) goto L5;
        Executor r12 = r11.b(new Object[0]);
    L8:
        Executor r13 = r12;
    L9:
        r13.execute(r8);
        return;
    L5:
        r13 = (Executor) f13549a.get(r10);
        if (r13 != null) goto L9;
        r12 = r11.b(new Object[0]);
        goto L8
    }
}
