package com.ss.android.lark.monitor.callback;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class MemoryCallbackManager {
    private static volatile MemoryCallbackManager mMemoryCallback;
    private final List<a> javaMemoryUsageCallbacks;
    private List<MemoryCallback> mMemoryCallbacks;

    public interface MemoryCallback {
        void onJavaMemoryReachTop();

        void onTrimMemory(int r1, int r2, int r3, int r4);
    }

    public interface a {
        void a();
    }

    public static MemoryCallbackManager getInstance() {
        if (mMemoryCallback != null) goto L15;
        monitor-enter(MemoryCallbackManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mMemoryCallback != null) goto L9;
        mMemoryCallback = new MemoryCallbackManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MemoryCallbackManager.class);     // Catch: Throwable -> L11
    L15:
        return mMemoryCallback;
    }

    public void notifyMemoryReachTop() {
        Iterator<MemoryCallback> r0 = this.mMemoryCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onJavaMemoryReachTop();
        goto L4
    }

    private MemoryCallbackManager() {
        this.mMemoryCallbacks = new CopyOnWriteArrayList();
        this.javaMemoryUsageCallbacks = new CopyOnWriteArrayList();
    }

    public void notifyJavaMemoryUsedRate(float r2) {
        Iterator<a> r3 = this.javaMemoryUsageCallbacks.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().a();
        goto L4
    }

    public void registerJavaMemoryUsageCallback(a r2) {
        if (this.javaMemoryUsageCallbacks.contains(r2) == true) goto L6;
        this.javaMemoryUsageCallbacks.add(r2);
        return;
    }

    public void registerMemoryCallback(MemoryCallback r2) {
        if (this.mMemoryCallbacks.contains(r2) == true) goto L6;
        this.mMemoryCallbacks.add(r2);
        return;
    }

    public void unRegisterJavaMemoryUsageCallback(a r2) {
        this.javaMemoryUsageCallbacks.remove(r2);
    }

    public void unRegisterMemoryCallback(MemoryCallback r2) {
        if (this.mMemoryCallbacks.contains(r2) == false) goto L6;
        this.mMemoryCallbacks.remove(r2);
        return;
    }

    public void trimMemory(int r3, int r4, int r5, int r6) {
        Iterator<MemoryCallback> r0 = this.mMemoryCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onTrimMemory(r3, r4, r5, r6);
        goto L4
    }
}
