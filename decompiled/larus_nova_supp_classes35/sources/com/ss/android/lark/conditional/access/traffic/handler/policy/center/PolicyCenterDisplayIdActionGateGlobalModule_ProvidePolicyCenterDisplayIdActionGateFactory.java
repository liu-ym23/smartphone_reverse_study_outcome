package com.ss.android.lark.conditional.access.traffic.handler.policy.center;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PolicyCenterDisplayIdActionGateGlobalModule_ProvidePolicyCenterDisplayIdActionGateFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public a get() {
        return providePolicyCenterDisplayIdActionGate((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m998get() {
        return get();
    }

    public PolicyCenterDisplayIdActionGateGlobalModule_ProvidePolicyCenterDisplayIdActionGateFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static PolicyCenterDisplayIdActionGateGlobalModule_ProvidePolicyCenterDisplayIdActionGateFactory create(Provider<j> r1, Provider<v> r2) {
        return new PolicyCenterDisplayIdActionGateGlobalModule_ProvidePolicyCenterDisplayIdActionGateFactory(r1, r2);
    }

    public static a providePolicyCenterDisplayIdActionGate(j r1, v r2) {
        int r0 = b.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        return (a) Preconditions.checkNotNullFromProvides(new c(r1, r2));
    }
}
