package com.ss.android.lark.officesdk.container;

import android.app.Application;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKUserComponentManagerImpl_Factory implements Factory<OfficeSDKUserComponentManagerImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<OfficeSDKUserComponentBuilder> builderProvider;
    private final Provider<UserSession> userSessionProvider;

    public OfficeSDKUserComponentManagerImpl get() {
        return newInstance((Application) this.applicationProvider.get(), (UserSession) this.userSessionProvider.get(), (OfficeSDKUserComponentBuilder) this.builderProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m42get() {
        return get();
    }

    public OfficeSDKUserComponentManagerImpl_Factory(Provider<Application> r1, Provider<UserSession> r2, Provider<OfficeSDKUserComponentBuilder> r3) {
        this.applicationProvider = r1;
        this.userSessionProvider = r2;
        this.builderProvider = r3;
    }

    public static OfficeSDKUserComponentManagerImpl_Factory create(Provider<Application> r1, Provider<UserSession> r2, Provider<OfficeSDKUserComponentBuilder> r3) {
        return new OfficeSDKUserComponentManagerImpl_Factory(r1, r2, r3);
    }

    public static OfficeSDKUserComponentManagerImpl newInstance(Application r1, UserSession r2, OfficeSDKUserComponentBuilder r3) {
        return new OfficeSDKUserComponentManagerImpl(r1, r2, r3);
    }
}
