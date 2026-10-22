package com.ss.android.lark.passport.flow.mfa;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FlowMfaEngine_Factory implements Factory<FlowMfaEngine> {
    private final Provider<h> flowRegistryProvider;
    private final Provider<FlowMfaRepository> repositoryProvider;
    private final Provider<String> userIdProvider;

    public FlowMfaEngine get() {
        return newInstance((String) this.userIdProvider.get(), (FlowMfaRepository) this.repositoryProvider.get(), (h) this.flowRegistryProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m614get() {
        return get();
    }

    public FlowMfaEngine_Factory(Provider<String> r1, Provider<FlowMfaRepository> r2, Provider<h> r3) {
        this.userIdProvider = r1;
        this.repositoryProvider = r2;
        this.flowRegistryProvider = r3;
    }

    public static FlowMfaEngine_Factory create(Provider<String> r1, Provider<FlowMfaRepository> r2, Provider<h> r3) {
        return new FlowMfaEngine_Factory(r1, r2, r3);
    }

    public static FlowMfaEngine newInstance(String r1, FlowMfaRepository r2, h r3) {
        return new FlowMfaEngine(r1, r2, r3);
    }
}
