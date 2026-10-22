package com.ss.android.lark.officesdk.common.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import itb.c;
import jtb.b;
import jtb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKCommonModule_ProvideOfficeExposureApiFactory implements Factory<c> {
    private final e module;

    public c get() {
        return provideOfficeExposureApi(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m24get() {
        return get();
    }

    public OfficeSDKCommonModule_ProvideOfficeExposureApiFactory(e r1) {
        this.module = r1;
    }

    public static OfficeSDKCommonModule_ProvideOfficeExposureApiFactory create(e r1) {
        return new OfficeSDKCommonModule_ProvideOfficeExposureApiFactory(r1);
    }

    public static c provideOfficeExposureApi(e r0) {
        r0.getClass();
        return (c) Preconditions.checkNotNullFromProvides(new b());
    }
}
