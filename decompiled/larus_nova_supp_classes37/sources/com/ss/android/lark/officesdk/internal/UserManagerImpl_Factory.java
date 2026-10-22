package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.officesdk.api.IOnlineOfflineService;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserManagerImpl_Factory implements Factory<UserManagerImpl> {
    private final Provider<IOfficeSDKLifeCycle> officeSDKLifeCycleProvider;
    private final Provider<IOnlineOfflineService> onlineOfflineServiceProvider;
    private final Provider<IOfficeSDKTokenProvider> tokenProvider;

    public UserManagerImpl get() {
        return newInstance((IOnlineOfflineService) this.onlineOfflineServiceProvider.get(), (IOfficeSDKTokenProvider) this.tokenProvider.get(), (IOfficeSDKLifeCycle) this.officeSDKLifeCycleProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m119get() {
        return get();
    }

    public UserManagerImpl_Factory(Provider<IOnlineOfflineService> r1, Provider<IOfficeSDKTokenProvider> r2, Provider<IOfficeSDKLifeCycle> r3) {
        this.onlineOfflineServiceProvider = r1;
        this.tokenProvider = r2;
        this.officeSDKLifeCycleProvider = r3;
    }

    public static UserManagerImpl_Factory create(Provider<IOnlineOfflineService> r1, Provider<IOfficeSDKTokenProvider> r2, Provider<IOfficeSDKLifeCycle> r3) {
        return new UserManagerImpl_Factory(r1, r2, r3);
    }

    public static UserManagerImpl newInstance(IOnlineOfflineService r1, IOfficeSDKTokenProvider r2, IOfficeSDKLifeCycle r3) {
        return new UserManagerImpl(r1, r2, r3);
    }
}
