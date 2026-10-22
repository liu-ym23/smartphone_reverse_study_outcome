package com.ss.android.lark.passport;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeTokenServiceImpl_Factory implements Factory<OfficeTokenServiceImpl> {
    private final Provider<IOfficeSDKTokenProvider> tokenProvider;

    public OfficeTokenServiceImpl get() {
        return newInstance((IOfficeSDKTokenProvider) this.tokenProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m582get() {
        return get();
    }

    public OfficeTokenServiceImpl_Factory(Provider<IOfficeSDKTokenProvider> r1) {
        this.tokenProvider = r1;
    }

    public static OfficeTokenServiceImpl_Factory create(Provider<IOfficeSDKTokenProvider> r1) {
        return new OfficeTokenServiceImpl_Factory(r1);
    }

    public static OfficeTokenServiceImpl newInstance(IOfficeSDKTokenProvider r1) {
        return new OfficeTokenServiceImpl(r1);
    }
}
