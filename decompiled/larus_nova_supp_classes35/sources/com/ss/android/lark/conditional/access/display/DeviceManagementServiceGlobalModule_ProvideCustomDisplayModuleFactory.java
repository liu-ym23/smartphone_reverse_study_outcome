package com.ss.android.lark.conditional.access.display;

import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DeviceManagementServiceGlobalModule_ProvideCustomDisplayModuleFactory implements Factory<g> {
    private final Provider<v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    public g get() {
        return provideCustomDisplayModule((com.ss.android.lark.passportc.api.j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m969get() {
        return get();
    }

    public DeviceManagementServiceGlobalModule_ProvideCustomDisplayModuleFactory(Provider<com.ss.android.lark.passportc.api.j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static DeviceManagementServiceGlobalModule_ProvideCustomDisplayModuleFactory create(Provider<com.ss.android.lark.passportc.api.j> r1, Provider<v> r2) {
        return new DeviceManagementServiceGlobalModule_ProvideCustomDisplayModuleFactory(r1, r2);
    }

    public static g provideCustomDisplayModule(com.ss.android.lark.passportc.api.j r1, v r2) {
        int r0 = f.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        return (g) Preconditions.checkNotNullFromProvides(new c(r1, r2));
    }
}
