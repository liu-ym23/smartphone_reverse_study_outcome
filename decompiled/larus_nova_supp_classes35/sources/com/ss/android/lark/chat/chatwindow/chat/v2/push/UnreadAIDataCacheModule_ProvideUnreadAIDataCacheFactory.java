package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UnreadAIDataCacheModule_ProvideUnreadAIDataCacheFactory implements Factory<z> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    public z get() {
        return provideUnreadAIDataCache((com.ss.android.lark.passportc.api.j) this.passportProvider.get(), (com.ss.android.lark.passportc.internal.v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m488get() {
        return get();
    }

    public UnreadAIDataCacheModule_ProvideUnreadAIDataCacheFactory(Provider<com.ss.android.lark.passportc.api.j> r1, Provider<com.ss.android.lark.passportc.internal.v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static UnreadAIDataCacheModule_ProvideUnreadAIDataCacheFactory create(Provider<com.ss.android.lark.passportc.api.j> r1, Provider<com.ss.android.lark.passportc.internal.v> r2) {
        return new UnreadAIDataCacheModule_ProvideUnreadAIDataCacheFactory(r1, r2);
    }

    public static z provideUnreadAIDataCache(com.ss.android.lark.passportc.api.j r1, com.ss.android.lark.passportc.internal.v r2) {
        int r0 = o0.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        p0 r3 = new p0(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (z) Preconditions.checkNotNullFromProvides(r3);
    }
}
