package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LarkRustSDKDefinition_Factory implements Factory<o> {
    private final Provider<Set<te6.b>> observersProvider;
    private final Provider<x> onlineResponseObserverInternalProvider;

    public o get() {
        o r0 = newInstance((Set) this.observersProvider.get());
        r0.c = (x) this.onlineResponseObserverInternalProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m681get() {
        return get();
    }

    public static o newInstance(Set<te6.b> r1) {
        return new o(r1);
    }

    public LarkRustSDKDefinition_Factory(Provider<Set<te6.b>> r1, Provider<x> r2) {
        this.observersProvider = r1;
        this.onlineResponseObserverInternalProvider = r2;
    }

    public static LarkRustSDKDefinition_Factory create(Provider<Set<te6.b>> r1, Provider<x> r2) {
        return new LarkRustSDKDefinition_Factory(r1, r2);
    }
}
