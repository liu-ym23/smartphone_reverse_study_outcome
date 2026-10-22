package com.ss.android.lark.framework.assembly.appcontext;

import com.ss.android.lark.appcontext.applifecycle.z;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InitAppLifecycleTask_Factory implements Factory<InitAppLifecycleTask> {
    private final Provider<z> dependencyProvider;

    public InitAppLifecycleTask get() {
        return newInstance((z) this.dependencyProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m652get() {
        return get();
    }

    public InitAppLifecycleTask_Factory(Provider<z> r1) {
        this.dependencyProvider = r1;
    }

    public static InitAppLifecycleTask_Factory create(Provider<z> r1) {
        return new InitAppLifecycleTask_Factory(r1);
    }

    public static InitAppLifecycleTask newInstance(z r1) {
        return new InitAppLifecycleTask(r1);
    }
}
