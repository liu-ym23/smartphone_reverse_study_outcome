package com.obric.memorydata.memory.ui.list.contextawareness;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessSettingsNavigationPolicy;", "", "<init>", "()V", "resolve", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessSettingsNavigationTarget;", "hasContextAwarenessEntry", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f11274a = null;

    static {
        f11274a = new j();
    }

    private j() {
    }

    public final ContextAwarenessSettingsNavigationTarget a(boolean r1) {
        if (r1 == false) goto L5;
        return ContextAwarenessSettingsNavigationTarget.CONTEXT_AWARENESS_SETTINGS;
    L5:
        return ContextAwarenessSettingsNavigationTarget.GLOBAL_MEMORY_SETTINGS;
    }
}
