package a4;

import android.os.Process;
import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import z3.e;

/* JADX INFO: loaded from: classes.dex */
public class a implements ThreadFactory {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f81c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f82g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f83h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b f84i;

    /* JADX INFO: renamed from: a4.a$a, reason: collision with other inner class name */
    class RunnableC0001a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Runnable f85c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f86g;

        RunnableC0001a(a r10, Runnable r11) {
            this.f86g = r10;
            this.f85c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            if (a.a(this.f86g) == null) goto L14;
            a.a(this.f86g).a(Thread.currentThread().getId());
        L14:
            Runnable r10 = this.f85c;     // Catch: Throwable -> L9
            if (r10 == null) goto L16;
            r10.run();     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L9:
            th = move-exception;
            z3.b.a().a(th, "APM_INNER_ERROR_async_task");
            if (a.b(this.f86g) == null) goto L17;
            a.b(this.f86g).a(this.f86g.f81c, th.getMessage());
            return;
        }
    }

    public interface b {
        void a(long r10);
    }

    public a(@NonNull String r10) {
        this.f81c = a.class.getSimpleName();
        this.f82g = "APM_" + r10;
    }

    static /* synthetic */ b a(a r10) {
        return r10.f84i;
    }

    static /* synthetic */ e b(a r10) {
        return r10.f83h;
    }

    public void c(e r10) {
        this.f83h = r10;
    }

    public void d(b r10) {
        this.f84i = r10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r10) {
        return new Thread(new RunnableC0001a(this, r10), this.f82g);
    }
}
