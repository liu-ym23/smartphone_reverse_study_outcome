package com.ss.android.lark.officesdk.internal;

import com.bytedance.lark.sdk.refactor.n;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKUserApiImpl_Factory implements Factory<h> {
    private final Provider<OfficeSDKUserComponentManager> componentManagerProvider;
    private final Provider<n> rustSDKProvider;
    private final Provider<String> userIdProvider;

    public h get() {
        return newInstance((String) this.userIdProvider.get(), (OfficeSDKUserComponentManager) this.componentManagerProvider.get(), (n) this.rustSDKProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m113get() {
        return get();
    }

    public OfficeSDKUserApiImpl_Factory(Provider<String> r1, Provider<OfficeSDKUserComponentManager> r2, Provider<n> r3) {
        this.userIdProvider = r1;
        this.componentManagerProvider = r2;
        this.rustSDKProvider = r3;
    }

    public static OfficeSDKUserApiImpl_Factory create(Provider<String> r1, Provider<OfficeSDKUserComponentManager> r2, Provider<n> r3) {
        return new OfficeSDKUserApiImpl_Factory(r1, r2, r3);
    }

    public static h newInstance(String r1, OfficeSDKUserComponentManager r2, n r3) {
        return new h(r1, r2, r3);
    }
}
