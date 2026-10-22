package g0;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class n implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7534b;

    public static class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7535a;

        public a(Runnable r8, String r10, int r11) {
            super(r8, r10);
            this.f7535a = r11;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(this.f7535a);
            super.run();
        }
    }

    public n() {
        this.f7533a = "fonts-androidx";
        this.f7534b = 10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r8) {
        return new a(r8, this.f7533a, this.f7534b);
    }
}
