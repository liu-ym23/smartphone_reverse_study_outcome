package b3;

import c2.k;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ExecutorService f3039a;

    public class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            return new Thread(r8, "Apm_Log_Bypass_Store");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f3040a = null;

        static {
            f3040a = new d();
        }
    }

    public d() {
        this.f3039a = Executors.newFixedThreadPool(1, new a());
    }

    public static d a() {
        if (k.f3298b == true) goto L5;
        return null;
    L5:
        return b.f3040a;
    }

    public final void b(Runnable r8) {
        this.f3039a.submit(r8);
    }
}
