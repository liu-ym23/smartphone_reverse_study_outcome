package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MockLarkDeviceIdApiImpl_Factory implements Factory<MockLarkDeviceIdApiImpl> {

    public static final class a {
        public static final MockLarkDeviceIdApiImpl_Factory a = null;

        static {
            a = new MockLarkDeviceIdApiImpl_Factory();
        }
    }

    public MockLarkDeviceIdApiImpl_Factory() {
    }

    public static MockLarkDeviceIdApiImpl newInstance() {
        return new MockLarkDeviceIdApiImpl();
    }

    public MockLarkDeviceIdApiImpl get() {
        return newInstance();
    }

    public static MockLarkDeviceIdApiImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m59get() {
        return get();
    }
}
