package com.bytedance.android.live.saas.middleware;

import dagger.MembersInjector;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BDLiveSdkHelper_MembersInjector implements MembersInjector<BDLiveSdkHelper> {
    private final Provider<Set<IBDLiveSdkInit>> providersProvider;

    public BDLiveSdkHelper_MembersInjector(Provider<Set<IBDLiveSdkInit>> r1) {
        this.providersProvider = r1;
    }

    public static MembersInjector<BDLiveSdkHelper> create(Provider<Set<IBDLiveSdkInit>> r1) {
        return new BDLiveSdkHelper_MembersInjector(r1);
    }

    public void injectMembers(BDLiveSdkHelper r2) {
        injectProviders(r2, (Set) this.providersProvider.get());
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object r1) {
        injectMembers((BDLiveSdkHelper) r1);
    }

    public static void injectProviders(BDLiveSdkHelper r0, Set<IBDLiveSdkInit> r1) {
        r0.providers = r1;
    }
}
