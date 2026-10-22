package com.ss.android.lark.framework.assembly.diskmanage;

import dagger.internal.Factory;
import ebb.f;
import ebb.h;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DefaultCleanTask_Factory implements Factory<a> {
    private final Provider<Set<f>> cleanFileProvider;
    private final Provider<h> manuDiskCleanTriggerProvider;

    public a get() {
        return newInstance(this.cleanFileProvider, (h) this.manuDiskCleanTriggerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m654get() {
        return get();
    }

    public DefaultCleanTask_Factory(Provider<Set<f>> r1, Provider<h> r2) {
        this.cleanFileProvider = r1;
        this.manuDiskCleanTriggerProvider = r2;
    }

    public static DefaultCleanTask_Factory create(Provider<Set<f>> r1, Provider<h> r2) {
        return new DefaultCleanTask_Factory(r1, r2);
    }

    public static a newInstance(Provider<Set<f>> r1, h r2) {
        return new a(r1, r2);
    }
}
