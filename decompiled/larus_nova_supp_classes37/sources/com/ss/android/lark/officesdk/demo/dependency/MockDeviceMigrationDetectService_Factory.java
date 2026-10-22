package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MockDeviceMigrationDetectService_Factory implements Factory<d> {

    public static final class a {
        public static final MockDeviceMigrationDetectService_Factory a = null;

        static {
            a = new MockDeviceMigrationDetectService_Factory();
        }
    }

    public MockDeviceMigrationDetectService_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    public d get() {
        return newInstance();
    }

    public static MockDeviceMigrationDetectService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m57get() {
        return get();
    }
}
