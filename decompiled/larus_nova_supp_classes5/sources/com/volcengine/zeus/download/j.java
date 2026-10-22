package com.volcengine.zeus.download;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.log.ZeusLogger;
import dqc.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class j {
    public static volatile j d;
    public final Handler a;
    public final Map<String, Runnable> b;
    public final Map<String, com.volcengine.zeus.download.a> c;

    public class a implements Runnable {
        public final /* synthetic */ c a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r1) {
            this.a = r1;
        }
    }

    public static j b() {
        if (d != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public j() {
        this.a = new Handler(Looper.getMainLooper());
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
    }

    public final void c(String r4) {
        Runnable r0 = (Runnable) ((ConcurrentHashMap) this.b).get(r4);
        if (r0 == null) goto L5;
        this.a.removeCallbacks(r0);
    L5:
        Runnable r1 = new b(this, r4);
        ((ConcurrentHashMap) this.b).put(r4, r1);
        this.a.postDelayed(r1, 1800000);
    }

    public final synchronized void a(String r4, boolean r5) {
        monitor-enter(this);
        ZeusLogger.d("Zeus/download_zeus", "start asyncFetchPlugins:" + r4);     // Catch: Throwable -> L11
        if (((ConcurrentHashMap) this.c).containsKey(r4) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        c r0 = new c(this, r5, r4);     // Catch: Throwable -> L11
        ((ConcurrentHashMap) this.c).put(r4, r0);     // Catch: Throwable -> L11
        e.b(new a(r0));     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
