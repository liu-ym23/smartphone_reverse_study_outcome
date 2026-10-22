package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MockGlobalDeviceServiceImpl_Factory implements Factory<e> {
    private final Provider<epb.a> mLarkDeviceIdApiProvider;

    public static e newInstance() {
        return new e();
    }

    public e get() {
        e r0 = newInstance();
        r0.a = (epb.a) this.mLarkDeviceIdApiProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m58get() {
        return get();
    }

    public MockGlobalDeviceServiceImpl_Factory(Provider<epb.a> r1) {
        this.mLarkDeviceIdApiProvider = r1;
    }

    public static MockGlobalDeviceServiceImpl_Factory create(Provider<epb.a> r1) {
        return new MockGlobalDeviceServiceImpl_Factory(r1);
    }
}
