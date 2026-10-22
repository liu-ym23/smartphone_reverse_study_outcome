package com.ss.android.lark.chat.export.offlineCacheClean;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class OfflineCacheCleanModule_ProvideOfflineCacheCleanFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public a get() {
        return provideOfflineCacheClean((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m534get() {
        return get();
    }

    public OfflineCacheCleanModule_ProvideOfflineCacheCleanFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static OfflineCacheCleanModule_ProvideOfflineCacheCleanFactory create(Provider<j> r1, Provider<v> r2) {
        return new OfflineCacheCleanModule_ProvideOfflineCacheCleanFactory(r1, r2);
    }

    public static a provideOfflineCacheClean(j r1, v r2) {
        int r0 = d.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        e r3 = new e(r1, r2);
        h.a(r3);
        return (a) Preconditions.checkNotNullFromProvides(r3);
    }
}
