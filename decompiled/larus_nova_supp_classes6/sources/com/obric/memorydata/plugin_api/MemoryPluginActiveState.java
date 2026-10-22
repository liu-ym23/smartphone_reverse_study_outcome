package com.obric.memorydata.plugin_api;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class MemoryPluginActiveState implements MemoryPluginActiveProvider {
    private static final String TAG = "MemoryPluginActiveState";
    private static final AtomicInteger inUseCount = null;
    private static final AtomicBoolean inited = null;

    public class a implements IntUnaryOperator {
        public a() {
        }

        @Override // java.util.function.IntUnaryOperator
        public final int applyAsInt(int r2) {
            if (r2 > 1) goto L7;
            return 0;
        L7:
            return r2 - 1;
        }
    }

    static {
        inUseCount = new AtomicInteger(0);
        inited = new AtomicBoolean(false);
    }

    public static void init() {
        if (inited.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        MemoryPluginActiveProviderRegistry.getInstance().addProvider(new MemoryPluginActiveState());
    }

    public static boolean isActiveInProcess() {
        if (inUseCount.get() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void onEnter() {
        inUseCount.incrementAndGet();
        MemoryPluginActiveProviderRegistry.getInstance().onActiveChange();
    }

    public static void onExit() {
        inUseCount.updateAndGet(new a());
        MemoryPluginActiveProviderRegistry.getInstance().onActiveChange();
    }

    @Override // com.obric.memorydata.plugin_api.MemoryPluginActiveProvider
    public boolean isActive() {
        return isActiveInProcess();
    }

    private MemoryPluginActiveState() {
    }
}
