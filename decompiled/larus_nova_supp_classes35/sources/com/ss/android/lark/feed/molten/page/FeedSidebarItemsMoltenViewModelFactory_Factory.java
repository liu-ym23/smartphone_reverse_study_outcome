package com.ss.android.lark.feed.molten.page;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedSidebarItemsMoltenViewModelFactory_Factory implements Factory<FeedSidebarItemsMoltenViewModelFactory> {
    private final Provider<com.ss.android.lark.feed.molten.cache.b> localCacheProvider;
    private final Provider<m> passportProvider;

    public FeedSidebarItemsMoltenViewModelFactory get() {
        return newInstance((m) this.passportProvider.get(), (com.ss.android.lark.feed.molten.cache.b) this.localCacheProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1190get() {
        return get();
    }

    public FeedSidebarItemsMoltenViewModelFactory_Factory(Provider<m> r1, Provider<com.ss.android.lark.feed.molten.cache.b> r2) {
        this.passportProvider = r1;
        this.localCacheProvider = r2;
    }

    public static FeedSidebarItemsMoltenViewModelFactory_Factory create(Provider<m> r1, Provider<com.ss.android.lark.feed.molten.cache.b> r2) {
        return new FeedSidebarItemsMoltenViewModelFactory_Factory(r1, r2);
    }

    public static FeedSidebarItemsMoltenViewModelFactory newInstance(m r1, com.ss.android.lark.feed.molten.cache.b r2) {
        return new FeedSidebarItemsMoltenViewModelFactory(r1, r2);
    }
}
