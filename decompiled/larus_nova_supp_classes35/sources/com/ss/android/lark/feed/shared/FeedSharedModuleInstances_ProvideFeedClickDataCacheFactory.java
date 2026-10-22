package com.ss.android.lark.feed.shared;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import heb.b;
import javax.inject.Provider;
import jeb.c;
import jeb.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedSharedModuleInstances_ProvideFeedClickDataCacheFactory implements Factory<d> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public d m1191get() {
        return provideFeedClickDataCache((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1191get();
    }

    public FeedSharedModuleInstances_ProvideFeedClickDataCacheFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static FeedSharedModuleInstances_ProvideFeedClickDataCacheFactory create(Provider<j> r1, Provider<v> r2) {
        return new FeedSharedModuleInstances_ProvideFeedClickDataCacheFactory(r1, r2);
    }

    public static d provideFeedClickDataCache(j r1, v r2) {
        int r0 = b.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        c r3 = new c(r1, r2);
        h.a(r3);
        return (d) Preconditions.checkNotNullFromProvides(r3);
    }
}
