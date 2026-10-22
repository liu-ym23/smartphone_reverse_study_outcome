package d8;

import android.os.Process;
import c8.d;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f6954b;

    /* JADX INFO: renamed from: d8.a$a, reason: collision with other inner class name */
    public class RunnableC0060a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f6955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f6956b;

        public RunnableC0060a(a r8, Runnable r10) {
            this.f6956b = r8;
            this.f6955a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);
            a r8 = this.f6956b;
            b r10 = r8.f6954b;
            if (r10 == null) goto L11;
            r10.a(Thread.currentThread().getId());
        L11:
            Runnable r11 = this.f6955a;     // Catch: Throwable -> L9
            if (r11 == null) goto L13;
            r11.run();     // Catch: Throwable -> L9
            return;
        L13:
            return;
        L9:
            Object r12 = d.f3410e;
            d.a.f3417a.getClass();
            r8.getClass();
        }
    }

    public interface b {
        void a(long r8);
    }

    public a(String r8) {
        this.f6953a = "APM_".concat(r8);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r8) {
        return new Thread(new RunnableC0060a(this, r8), this.f6953a);
    }
}
