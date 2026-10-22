package com.ss.android.lark.officesdk.feed.impl;

import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.sdk.refactor.n;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FeedOfficeSdkServiceImpl_Factory implements Factory<FeedOfficeSdkServiceImpl> {
    private final Provider<l> rustClientProvider;
    private final Provider<n> rustSdkProvider;
    private final Provider<String> userIdProvider;

    public FeedOfficeSdkServiceImpl get() {
        return newInstance((String) this.userIdProvider.get(), (n) this.rustSdkProvider.get(), (l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m72get() {
        return get();
    }

    public FeedOfficeSdkServiceImpl_Factory(Provider<String> r1, Provider<n> r2, Provider<l> r3) {
        this.userIdProvider = r1;
        this.rustSdkProvider = r2;
        this.rustClientProvider = r3;
    }

    public static FeedOfficeSdkServiceImpl_Factory create(Provider<String> r1, Provider<n> r2, Provider<l> r3) {
        return new FeedOfficeSdkServiceImpl_Factory(r1, r2, r3);
    }

    public static FeedOfficeSdkServiceImpl newInstance(String r1, n r2, l r3) {
        return new FeedOfficeSdkServiceImpl(r1, r2, r3);
    }
}
