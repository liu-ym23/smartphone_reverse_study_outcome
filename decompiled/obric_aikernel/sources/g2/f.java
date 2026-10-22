package g2;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class f implements ThreadFactory {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f8953g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8954c;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Runnable f8955c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f8956g;

        a(f r10, Runnable r11) {
            this.f8956g = r10;
            this.f8955c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            this.f8955c.run();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Logger.e(f.a(), "WsThreadFactory error when running in thread " + f.b(this.f8956g), th);
        }
    }

    static {
        f8953g = f.class.getSimpleName();
    }

    public f(String r10) {
        this.f8954c = "WsChannel-" + r10;
    }

    static /* synthetic */ String a() {
        return f8953g;
    }

    static /* synthetic */ String b(f r10) {
        return r10.f8954c;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f8953g, "creating newThread " + this.f8954c);
    L6:
        return new Thread(new a(this, r10), this.f8954c);
    }
}
