package i;

import android.os.Handler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class d extends android.support.v4.media.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f8075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f8076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Handler f8077e;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f8078a;

        public a() {
            this.f8078a = new AtomicInteger(0);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            Thread r10 = new Thread(r8);
            r10.setName("arch_disk_io_" + this.f8078a.getAndIncrement());
            return r10;
        }
    }

    public d() {
        this.f8075c = new Object();
        this.f8076d = Executors.newFixedThreadPool(4, new a());
    }

    public final void z(Runnable r8) {
        this.f8076d.execute(r8);
    }
}
