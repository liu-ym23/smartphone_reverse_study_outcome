package com.ss.android.lark.officesdk.integrator.mock;

import com.ss.android.lark.chatwindow.launcher.starter.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ytb.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSdkStarterMockModule_ProvideMyAiStarterFactory implements Factory<a> {
    private final Provider<ytb.a> mockProvider;

    public a get() {
        return provideMyAiStarter((ytb.a) this.mockProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m106get() {
        return get();
    }

    public OfficeSdkStarterMockModule_ProvideMyAiStarterFactory(Provider<ytb.a> r1) {
        this.mockProvider = r1;
    }

    public static OfficeSdkStarterMockModule_ProvideMyAiStarterFactory create(Provider<ytb.a> r1) {
        return new OfficeSdkStarterMockModule_ProvideMyAiStarterFactory(r1);
    }

    public static a provideMyAiStarter(ytb.a r1) {
        int r0 = q.a;
        Intrinsics.checkNotNullParameter(r1, "mock");
        return (a) Preconditions.checkNotNullFromProvides(r1);
    }
}
