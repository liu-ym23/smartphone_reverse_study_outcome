package com.ss.android.lark.officesdk.common.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import itb.e;
import jtb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKCommonModule_ProvideOfficeMediaApiFactory implements Factory<e> {
    private final jtb.e module;

    public e get() {
        return provideOfficeMediaApi(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m25get() {
        return get();
    }

    public OfficeSDKCommonModule_ProvideOfficeMediaApiFactory(jtb.e r1) {
        this.module = r1;
    }

    public static OfficeSDKCommonModule_ProvideOfficeMediaApiFactory create(jtb.e r1) {
        return new OfficeSDKCommonModule_ProvideOfficeMediaApiFactory(r1);
    }

    public static e provideOfficeMediaApi(jtb.e r0) {
        r0.getClass();
        return (e) Preconditions.checkNotNullFromProvides(new d());
    }
}
