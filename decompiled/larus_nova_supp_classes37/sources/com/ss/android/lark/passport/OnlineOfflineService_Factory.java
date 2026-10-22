package com.ss.android.lark.passport;

import com.ss.android.lark.active.user.api.IGlobalActiveUserManager;
import com.ss.android.lark.passport_user.api.IUserListService;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OnlineOfflineService_Factory implements Factory<OnlineOfflineService> {
    private final Provider<IGlobalActiveUserManager> globalActiveUserManagerProvider;
    private final Provider<com.ss.android.lark.passport.dpop.b> tokenServiceProvider;
    private final Provider<d> userListFetcherTriggerProvider;
    private final Provider<IUserListService> userListServiceProvider;

    public OnlineOfflineService get() {
        return newInstance(DoubleCheck.lazy(this.globalActiveUserManagerProvider), (IUserListService) this.userListServiceProvider.get(), (com.ss.android.lark.passport.dpop.b) this.tokenServiceProvider.get(), (d) this.userListFetcherTriggerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m583get() {
        return get();
    }

    public OnlineOfflineService_Factory(Provider<IGlobalActiveUserManager> r1, Provider<IUserListService> r2, Provider<com.ss.android.lark.passport.dpop.b> r3, Provider<d> r4) {
        this.globalActiveUserManagerProvider = r1;
        this.userListServiceProvider = r2;
        this.tokenServiceProvider = r3;
        this.userListFetcherTriggerProvider = r4;
    }

    public static OnlineOfflineService_Factory create(Provider<IGlobalActiveUserManager> r1, Provider<IUserListService> r2, Provider<com.ss.android.lark.passport.dpop.b> r3, Provider<d> r4) {
        return new OnlineOfflineService_Factory(r1, r2, r3, r4);
    }

    public static OnlineOfflineService newInstance(Lazy<IGlobalActiveUserManager> r1, IUserListService r2, com.ss.android.lark.passport.dpop.b r3, d r4) {
        return new OnlineOfflineService(r1, r2, r3, r4);
    }
}
