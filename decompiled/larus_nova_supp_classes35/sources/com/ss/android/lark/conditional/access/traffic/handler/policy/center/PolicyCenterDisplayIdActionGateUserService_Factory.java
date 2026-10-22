package com.ss.android.lark.conditional.access.traffic.handler.policy.center;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PolicyCenterDisplayIdActionGateUserService_Factory implements Factory<d> {
    private final Provider<String> userIdProvider;

    public d get() {
        return newInstance((String) this.userIdProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m999get() {
        return get();
    }

    public PolicyCenterDisplayIdActionGateUserService_Factory(Provider<String> r1) {
        this.userIdProvider = r1;
    }

    public static PolicyCenterDisplayIdActionGateUserService_Factory create(Provider<String> r1) {
        return new PolicyCenterDisplayIdActionGateUserService_Factory(r1);
    }

    public static d newInstance(String r1) {
        return new d(r1);
    }
}
