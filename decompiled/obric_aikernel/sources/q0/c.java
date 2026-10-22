package q0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile ExecutorService f12436a;

    class a implements ThreadFactory {
        a(c r10) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            return new Thread(r10, "Apm_Log_Bypass_Store");
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f12437a = null;

        static {
            f12437a = new c(null);
        }
    }

    private c() {
        this.f12436a = Executors.newFixedThreadPool(1, new a(this));
    }

    /* synthetic */ c(a r10) {
        this();
    }

    public static c a() {
        if (com.bytedance.apm.d.G() == true) goto L5;
        return null;
    L5:
        return b.f12437a;
    }

    public void b(Runnable r10) {
        this.f12436a.submit(r10);
    }
}
