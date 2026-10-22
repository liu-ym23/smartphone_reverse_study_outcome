package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatAppContainerModule_ProvideUserGroupServiceFactory implements Factory<a2b.o> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final a module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    public a2b.o get() {
        return provideUserGroupService(this.module, (com.ss.android.lark.passportc.api.j) this.passportProvider.get(), (com.ss.android.lark.passportc.internal.v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m478get() {
        return get();
    }

    public ChatAppContainerModule_ProvideUserGroupServiceFactory(a r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        this.module = r1;
        this.passportProvider = r2;
        this.accessorProvider = r3;
    }

    public static ChatAppContainerModule_ProvideUserGroupServiceFactory create(a r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        return new ChatAppContainerModule_ProvideUserGroupServiceFactory(r1, r2, r3);
    }

    public static a2b.o provideUserGroupService(a r0, com.ss.android.lark.passportc.api.j r1, com.ss.android.lark.passportc.internal.v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        com.ss.android.lark.chat.api.service.impl.usergroup.f r3 = new com.ss.android.lark.chat.api.service.impl.usergroup.f(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (a2b.o) Preconditions.checkNotNullFromProvides(r3);
    }
}
