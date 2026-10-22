package com.ss.android.lark.officesdk.initor;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DevRustInitIntercept_Factory implements Factory<a> {
    private final Provider<IOfficeSDKConfigProvider> officeSDKConfigProvider;

    public a get() {
        return newInstance((IOfficeSDKConfigProvider) this.officeSDKConfigProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m74get() {
        return get();
    }

    public DevRustInitIntercept_Factory(Provider<IOfficeSDKConfigProvider> r1) {
        this.officeSDKConfigProvider = r1;
    }

    public static DevRustInitIntercept_Factory create(Provider<IOfficeSDKConfigProvider> r1) {
        return new DevRustInitIntercept_Factory(r1);
    }

    public static a newInstance(IOfficeSDKConfigProvider r1) {
        return new a(r1);
    }
}
