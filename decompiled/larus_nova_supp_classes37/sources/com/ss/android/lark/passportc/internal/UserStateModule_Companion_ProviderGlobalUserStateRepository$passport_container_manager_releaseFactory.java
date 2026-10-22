package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.passportc.impl.v2.PassportStateManagerImpl2;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserStateModule_Companion_ProviderGlobalUserStateRepository$passport_container_manager_releaseFactory implements Factory<com.ss.android.lark.passportc.api.e> {
    private final Provider<com.ss.android.lark.passportc.api.i> multiOnlineFGProvider;
    private final Provider<PassportStateManagerImpl2> stateManager2Provider;
    private final Provider<PassportStateManagerImpl> stateManagerProvider;

    public com.ss.android.lark.passportc.api.e get() {
        return providerGlobalUserStateRepository$passport_container_manager_release((com.ss.android.lark.passportc.api.i) this.multiOnlineFGProvider.get(), (PassportStateManagerImpl) this.stateManagerProvider.get(), (PassportStateManagerImpl2) this.stateManager2Provider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m749get() {
        return get();
    }

    public UserStateModule_Companion_ProviderGlobalUserStateRepository$passport_container_manager_releaseFactory(Provider<com.ss.android.lark.passportc.api.i> r1, Provider<PassportStateManagerImpl> r2, Provider<PassportStateManagerImpl2> r3) {
        this.multiOnlineFGProvider = r1;
        this.stateManagerProvider = r2;
        this.stateManager2Provider = r3;
    }

    public static UserStateModule_Companion_ProviderGlobalUserStateRepository$passport_container_manager_releaseFactory create(Provider<com.ss.android.lark.passportc.api.i> r1, Provider<PassportStateManagerImpl> r2, Provider<PassportStateManagerImpl2> r3) {
        return new UserStateModule_Companion_ProviderGlobalUserStateRepository$passport_container_manager_releaseFactory(r1, r2, r3);
    }

    public static com.ss.android.lark.passportc.api.e providerGlobalUserStateRepository$passport_container_manager_release(com.ss.android.lark.passportc.api.i r1, PassportStateManagerImpl r2, PassportStateManagerImpl2 r3) {
        int r0 = j0.a;
        Intrinsics.checkNotNullParameter(r1, "multiOnlineFG");
        Intrinsics.checkNotNullParameter(r2, "stateManager");
        Intrinsics.checkNotNullParameter(r3, "stateManager2");
        Object r4 = r2;
        if (r1.c() == false) goto L6;
        r4 = r3;
    L6:
        return (com.ss.android.lark.passportc.api.e) Preconditions.checkNotNullFromProvides(r4);
    }
}
