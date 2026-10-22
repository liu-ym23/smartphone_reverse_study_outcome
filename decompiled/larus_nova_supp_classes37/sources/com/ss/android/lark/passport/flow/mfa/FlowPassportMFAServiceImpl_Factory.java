package com.ss.android.lark.passport.flow.mfa;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FlowPassportMFAServiceImpl_Factory implements Factory<u> {
    private final Provider<FlowMfaEngine> engineProvider;

    public u get() {
        return newInstance((FlowMfaEngine) this.engineProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m617get() {
        return get();
    }

    public FlowPassportMFAServiceImpl_Factory(Provider<FlowMfaEngine> r1) {
        this.engineProvider = r1;
    }

    public static FlowPassportMFAServiceImpl_Factory create(Provider<FlowMfaEngine> r1) {
        return new FlowPassportMFAServiceImpl_Factory(r1);
    }

    public static u newInstance(FlowMfaEngine r1) {
        return new u(r1);
    }
}
