package com.ss.android.lark.passport.flow.mfa;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FlowMfaRepository_Factory implements Factory<FlowMfaRepository> {
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;

    public FlowMfaRepository get() {
        return newInstance((com.bytedance.lark.rustclient.api.l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m616get() {
        return get();
    }

    public FlowMfaRepository_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        this.rustClientProvider = r1;
    }

    public static FlowMfaRepository_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        return new FlowMfaRepository_Factory(r1);
    }

    public static FlowMfaRepository newInstance(com.bytedance.lark.rustclient.api.l r1) {
        return new FlowMfaRepository(r1);
    }
}
