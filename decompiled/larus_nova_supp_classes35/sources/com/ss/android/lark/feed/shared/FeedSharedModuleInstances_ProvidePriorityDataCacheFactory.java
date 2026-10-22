package com.ss.android.lark.feed.shared;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import heb.b;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import neb.a;
import neb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedSharedModuleInstances_ProvidePriorityDataCacheFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m1192get() {
        return providePriorityDataCache((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1192get();
    }

    public FeedSharedModuleInstances_ProvidePriorityDataCacheFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static FeedSharedModuleInstances_ProvidePriorityDataCacheFactory create(Provider<j> r1, Provider<v> r2) {
        return new FeedSharedModuleInstances_ProvidePriorityDataCacheFactory(r1, r2);
    }

    public static a providePriorityDataCache(j r1, v r2) {
        int r0 = b.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        d r3 = new d(r1, r2);
        h.a(r3);
        return (a) Preconditions.checkNotNullFromProvides(r3);
    }
}
