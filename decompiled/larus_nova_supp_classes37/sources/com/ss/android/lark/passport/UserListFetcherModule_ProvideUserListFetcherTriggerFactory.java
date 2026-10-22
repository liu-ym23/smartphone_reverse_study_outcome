package com.ss.android.lark.passport;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserListFetcherModule_ProvideUserListFetcherTriggerFactory implements Factory<d> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public d get() {
        return provideUserListFetcherTrigger((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m585get() {
        return get();
    }

    public UserListFetcherModule_ProvideUserListFetcherTriggerFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static UserListFetcherModule_ProvideUserListFetcherTriggerFactory create(Provider<j> r1, Provider<v> r2) {
        return new UserListFetcherModule_ProvideUserListFetcherTriggerFactory(r1, r2);
    }

    public static d provideUserListFetcherTrigger(j r1, v r2) {
        int r0 = c.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        UserListFetcherTriggerImpl r3 = new UserListFetcherTriggerImpl(r1, r2);
        h.a(r3);
        return (d) Preconditions.checkNotNullFromProvides(r3);
    }
}
