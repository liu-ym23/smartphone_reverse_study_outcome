package com.bytedance.frameworks.baselib.network.http.util;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class h implements ThreadFactory {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f1884g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1885c;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Runnable f1886c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ h f1887g;

        a(h r10, Runnable r11) {
            this.f1887g = r10;
            this.f1886c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            this.f1886c.run();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Logger.e(h.a(), "WsThreadFactory error when running in thread " + h.b(this.f1887g), th);
        }
    }

    static {
        f1884g = h.class.getSimpleName();
    }

    public h(String r10) {
        this.f1885c = r10;
    }

    static /* synthetic */ String a() {
        return f1884g;
    }

    static /* synthetic */ String b(h r10) {
        return r10.f1885c;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f1884g, "creating newThread " + this.f1885c);
    L6:
        return new Thread(new a(this, r10), this.f1885c);
    }
}
