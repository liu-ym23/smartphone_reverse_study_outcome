package com.suite.lark.platform.component.storage.clean;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CleanModuleProvider_Factory implements Factory<e> {
    private final Provider<Set<j>> cleanModulesProvider;

    public e get() {
        return newInstance((Set) this.cleanModulesProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1738get() {
        return get();
    }

    public CleanModuleProvider_Factory(Provider<Set<j>> r1) {
        this.cleanModulesProvider = r1;
    }

    public static CleanModuleProvider_Factory create(Provider<Set<j>> r1) {
        return new CleanModuleProvider_Factory(r1);
    }

    public static e newInstance(Set<j> r1) {
        return new e(r1);
    }
}
