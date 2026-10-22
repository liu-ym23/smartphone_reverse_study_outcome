package com.larksuite.framework.callback;

import android.os.Handler;
import android.os.Looper;
import androidx.arch.core.util.Function;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class UICallbackExecutor {
    private static a executor;
    private static WeakHashMap<Runnable, WeakReference<Runnable>> runnableMap;
    private static final Handler sHandler = null;

    public UICallbackExecutor() {
    }

    static {
        sHandler = new Handler(Looper.getMainLooper());
        runnableMap = new WeakHashMap();
    }

    private static void initIfNeed() {
        if (executor == null) goto L5;
        return;
    L5:
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (executor != null) goto L9;
        executor = new a(sHandler);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    }

    public static void execute(Runnable r2) {
        initIfNeed();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r2.run();
        return;
    L5:
        executor.a(toTraceable(r2));
    }

    public static void post(Runnable r1) {
        initIfNeed();
        executor.a(toTraceable(r1));
    }

    public static void removeCallbacks(Runnable r2) {
        monitor-enter(UICallbackExecutor.class);
        WeakReference<Runnable> r3 = runnableMap.remove(r2);     // Catch: Throwable -> L18
        if (r3 != null) goto L8;
        monitor-exit(UICallbackExecutor.class);     // Catch: Throwable -> L18
        return;
    L8:
        Runnable r4 = r3.get();     // Catch: Throwable -> L18
        monitor-exit(UICallbackExecutor.class);     // Catch: Throwable -> L18
        if (r4 == null) goto L22;
        a r0 = executor;
        if (r0 == null) goto L24;
        Handler r1 = r0.a;
        if (r1 == null) goto L23;
        r1.removeCallbacks(r4);
        return;
    L23:
        return;
    L24:
        return;
    L22:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private static Runnable toTraceable(Runnable r4) {
        Function<? super Runnable, ? extends Runnable> r0 = b.a;
        if (r0 == null) goto L5;
        Runnable r1 = (Runnable) r0.apply(r4);
    L7:
        monitor-enter(UICallbackExecutor.class);
        runnableMap.put(r4, new WeakReference(r1));     // Catch: Throwable -> L11
        monitor-exit(UICallbackExecutor.class);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L5:
        r1 = r4;
        goto L7
    }

    public static void executeDelayed(Runnable r1, long r2) {
        initIfNeed();
        executor.b(toTraceable(r1), r2);
    }
}
