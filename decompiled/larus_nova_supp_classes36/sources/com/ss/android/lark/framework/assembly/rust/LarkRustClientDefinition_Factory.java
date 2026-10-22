package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LarkRustClientDefinition_Factory implements Factory<n> {
    private final Provider<Set<com.bytedance.lark.rustclient.api.o>> asyncCallbackExecutorGroupsProvider;
    private final Provider<e5c.b> simpleModeProvider;

    public n get() {
        return newInstance((e5c.b) this.simpleModeProvider.get(), (Set) this.asyncCallbackExecutorGroupsProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m680get() {
        return get();
    }

    public LarkRustClientDefinition_Factory(Provider<e5c.b> r1, Provider<Set<com.bytedance.lark.rustclient.api.o>> r2) {
        this.simpleModeProvider = r1;
        this.asyncCallbackExecutorGroupsProvider = r2;
    }

    public static LarkRustClientDefinition_Factory create(Provider<e5c.b> r1, Provider<Set<com.bytedance.lark.rustclient.api.o>> r2) {
        return new LarkRustClientDefinition_Factory(r1, r2);
    }

    public static n newInstance(e5c.b r1, Set<com.bytedance.lark.rustclient.api.o> r2) {
        return new n(r1, r2);
    }
}
