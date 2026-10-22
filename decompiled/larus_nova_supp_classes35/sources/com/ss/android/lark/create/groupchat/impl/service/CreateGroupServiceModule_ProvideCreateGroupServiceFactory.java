package com.ss.android.lark.create.groupchat.impl.service;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CreateGroupServiceModule_ProvideCreateGroupServiceFactory implements Factory<h> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public h get() {
        return provideCreateGroupService((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1118get() {
        return get();
    }

    public CreateGroupServiceModule_ProvideCreateGroupServiceFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static CreateGroupServiceModule_ProvideCreateGroupServiceFactory create(Provider<j> r1, Provider<v> r2) {
        return new CreateGroupServiceModule_ProvideCreateGroupServiceFactory(r1, r2);
    }

    public static h provideCreateGroupService(j r1, v r2) {
        int r0 = e.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        f r3 = new f(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (h) Preconditions.checkNotNullFromProvides(r3);
    }
}
