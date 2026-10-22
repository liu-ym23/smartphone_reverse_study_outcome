package com.ss.android.lark.framework.assembly.logger;

import com.suite.component.logger.Log;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UserScopeLogModule_ProvideLoggerFactory implements Factory<com.ss.android.lark.log.c> {
    private final Provider<String> userIdProvider;

    public com.ss.android.lark.log.c get() {
        return provideLogger((String) this.userIdProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m668get() {
        return get();
    }

    public UserScopeLogModule_ProvideLoggerFactory(Provider<String> r1) {
        this.userIdProvider = r1;
    }

    public static UserScopeLogModule_ProvideLoggerFactory create(Provider<String> r1) {
        return new UserScopeLogModule_ProvideLoggerFactory(r1);
    }

    public static com.ss.android.lark.log.c provideLogger(String r3) {
        int r0 = e.a;
        Intrinsics.checkNotNullParameter(r3, "userId");
        com.suite.component.logger.api.b r1 = Log.a.b();
        d r2 = new d(r3);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        r1.e.add(r2);
        return (com.ss.android.lark.log.c) Preconditions.checkNotNullFromProvides(new com.ss.android.lark.log.d(r1.a()));
    }
}
