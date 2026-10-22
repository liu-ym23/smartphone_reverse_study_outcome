package z3;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class b {

    static class a implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f13796c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ AsyncTaskType f13797g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Runnable f13798h;

        a(String r10, AsyncTaskType r11, Runnable r12) {
            this.f13796c = r10;
            this.f13797g = r11;
            this.f13798h = r12;
        }

        @Override // z3.d
        public AsyncTaskType J() {
            return this.f13797g;
        }

        @Override // z3.d
        public String P() {
            return this.f13796c;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable r10 = this.f13798h;     // Catch: Throwable -> L12
            if (r10 == null) goto L17;
            r10.run();     // Catch: Throwable -> L12
            c r11 = b.a();     // Catch: Throwable -> L12
            if (r11 != null) goto L7;
            return;
        L7:
            if (r11.j() != null) goto L9;
            return;
        L9:
            if (r11.j().isDebug() == false) goto L20;
            b.c(r11.j(), "AsyncTaskUtil", "task execute: " + this.f13797g + "  /  " + this.f13796c);     // Catch: Throwable -> L12
            return;
        L20:
            return;
        L17:
            return;
        L12:
            th = move-exception;
            b.a().a(th, "APM_INNER_ERROR_async_task");
        }
    }

    public static c a() {
        return z3.a.n();
    }

    public static String b(d r10) {
        if (r10 != null) goto L6;
        return "null";
    L6:
        return r10.P() + ", " + r10.J();
    }

    public static void c(e r10, String r11, String r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isDebug() == false) goto L8;
        String r13 = Thread.currentThread().getName();
        r10.onLog(r11, String.format(Locale.CHINA, "[callerThread: %s] \n %s", new Object[]{r13, r12}));
        return;
    }

    public static d d(String r10, Runnable r11) {
        return f(AsyncTaskType.IO, r10, r11);
    }

    public static d e(String r10, Runnable r11) {
        return f(AsyncTaskType.LIGHT_WEIGHT, r10, r11);
    }

    public static d f(AsyncTaskType r10, String r11, Runnable r12) {
        return new a(r11, r10, r12);
    }
}
