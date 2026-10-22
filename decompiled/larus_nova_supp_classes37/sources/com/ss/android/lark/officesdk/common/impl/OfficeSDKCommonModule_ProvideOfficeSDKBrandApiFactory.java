package com.ss.android.lark.officesdk.common.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import itb.a;
import jtb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKCommonModule_ProvideOfficeSDKBrandApiFactory implements Factory<a> {
    private final e module;

    public a get() {
        return provideOfficeSDKBrandApi(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m26get() {
        return get();
    }

    public OfficeSDKCommonModule_ProvideOfficeSDKBrandApiFactory(e r1) {
        this.module = r1;
    }

    public static OfficeSDKCommonModule_ProvideOfficeSDKBrandApiFactory create(e r1) {
        return new OfficeSDKCommonModule_ProvideOfficeSDKBrandApiFactory(r1);
    }

    public static a provideOfficeSDKBrandApi(e r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new jtb.a());
    }
}
