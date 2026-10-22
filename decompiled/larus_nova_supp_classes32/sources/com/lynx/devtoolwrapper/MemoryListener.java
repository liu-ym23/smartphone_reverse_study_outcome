package com.lynx.devtoolwrapper;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class MemoryListener {
    private CopyOnWriteArrayList<MemoryReporter> mMemoryReporters;

    /* JADX INFO: renamed from: com.lynx.devtoolwrapper.MemoryListener$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class MemoryListenerLoader {
        private static final MemoryListener INSTANCE = null;

        private MemoryListenerLoader() {
        }

        static {
            INSTANCE = new MemoryListener(null);
        }

        public static /* synthetic */ MemoryListener access$100() {
            return INSTANCE;
        }
    }

    public interface MemoryReporter {
        void uploadImageInfo(JSONObject r1);
    }

    public boolean hasAvailableReporter() {
        return !this.mMemoryReporters.isEmpty();
    }

    private MemoryListener() {
        this.mMemoryReporters = new CopyOnWriteArrayList();
    }

    public static MemoryListener getInstance() {
        return MemoryListenerLoader.access$100();
    }

    public /* synthetic */ MemoryListener(AnonymousClass1 r1) {
        this();
    }

    public void addMemoryReporter(MemoryReporter r2) {
        this.mMemoryReporters.add(r2);
    }

    public void removeMemoryReporter(MemoryReporter r2) {
        this.mMemoryReporters.remove(r2);
    }

    public void uploadImageInfo(JSONObject r3) {
        Iterator<MemoryReporter> r0 = this.mMemoryReporters.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().uploadImageInfo(r3);
        goto L4
    }
}
