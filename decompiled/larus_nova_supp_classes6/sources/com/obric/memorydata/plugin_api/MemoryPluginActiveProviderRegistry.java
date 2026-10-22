package com.obric.memorydata.plugin_api;

import com.obric.aiagent.sharedstate.SharedState;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class MemoryPluginActiveProviderRegistry {
    private static final String KEY_ACTIVE = "memorydata_active_state";
    private final AtomicInteger originActive;
    private final CopyOnWriteArraySet<MemoryPluginActiveProvider> providers;

    public static final class b {
        public static final MemoryPluginActiveProviderRegistry a = null;

        static {
            a = new MemoryPluginActiveProviderRegistry(null);
        }
    }

    public boolean isActiveInProcess() {
        Iterator<MemoryPluginActiveProvider> r0 = this.providers.iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 | r0.next().isActive();
        goto L4
    L6:
        return r1;
    }

    private MemoryPluginActiveProviderRegistry() {
        this.providers = new CopyOnWriteArraySet();
        this.originActive = new AtomicInteger(-1);
    }

    public void onActiveChange() {
        boolean r0 = isActiveInProcess();
        boolean r2 = false;
        if (this.originActive.getAndSet(r0 ? 1 : 0) == r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L12;
        SharedState r3 = SharedState.INSTANCE;
        if (r0 != true) goto L10;
        r2 = true;
    L10:
        r3.putBoolean(KEY_ACTIVE, r2);
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static MemoryPluginActiveProviderRegistry getInstance() {
        return b.a;
    }

    public /* synthetic */ MemoryPluginActiveProviderRegistry(a r1) {
        this();
    }

    public void addProvider(MemoryPluginActiveProvider r2) {
        this.providers.add(r2);
        onActiveChange();
    }
}
