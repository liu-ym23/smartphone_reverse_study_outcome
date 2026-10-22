package com.ss.android.lark.officesdk.flow.user;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import rtb.b;
import stb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserOfficeSdkModule_ProvideOfficeSDKUserApiFactory implements Factory<a> {
    private final b module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m73get() {
        return provideOfficeSDKUserApi(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m73get();
    }

    public UserOfficeSdkModule_ProvideOfficeSDKUserApiFactory(b r1) {
        this.module = r1;
    }

    public static UserOfficeSdkModule_ProvideOfficeSDKUserApiFactory create(b r1) {
        return new UserOfficeSdkModule_ProvideOfficeSDKUserApiFactory(r1);
    }

    public static a provideOfficeSDKUserApi(b r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new rtb.a());
    }
}
