package com.ss.android.lark.framework.assembly.diskmanage;

import dagger.internal.Factory;
import ebb.g;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DiskCleanTaskCollector_Factory implements Factory<b> {
    private final Provider<Set<g>> cleanTasksProvider;

    public b get() {
        return newInstance(this.cleanTasksProvider);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m655get() {
        return get();
    }

    public DiskCleanTaskCollector_Factory(Provider<Set<g>> r1) {
        this.cleanTasksProvider = r1;
    }

    public static DiskCleanTaskCollector_Factory create(Provider<Set<g>> r1) {
        return new DiskCleanTaskCollector_Factory(r1);
    }

    public static b newInstance(Provider<Set<g>> r1) {
        return new b(r1);
    }
}
