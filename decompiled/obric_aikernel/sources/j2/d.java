package j2;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class d implements ThreadFactory {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f9750g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9751c;

    static {
        f9750g = d.class.getSimpleName();
    }

    public d(String r10) {
        this.f9751c = "ttnet-" + r10;
    }

    public static /* synthetic */ void a(d r10, Runnable r11) {
        r10.b(r11);
    }

    private /* synthetic */ void b(Runnable r10) {
        Process.setThreadPriority(10);
        r10.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.e(f9750g, "NetworkThreadFactory error when running in thread " + this.f9751c, th);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable r10) {
        return new Thread(new c(this, r10), this.f9751c);
    }
}
