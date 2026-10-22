package com.suite.lark.platform.component.storage.clean;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class BuildInCleanModule_Factory implements Factory<a> {
    private final Provider<Set<l>> eraserProvider;

    public a get() {
        return newInstance(this.eraserProvider);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1736get() {
        return get();
    }

    public BuildInCleanModule_Factory(Provider<Set<l>> r1) {
        this.eraserProvider = r1;
    }

    public static BuildInCleanModule_Factory create(Provider<Set<l>> r1) {
        return new BuildInCleanModule_Factory(r1);
    }

    public static a newInstance(Provider<Set<l>> r1) {
        return new a(r1);
    }
}
