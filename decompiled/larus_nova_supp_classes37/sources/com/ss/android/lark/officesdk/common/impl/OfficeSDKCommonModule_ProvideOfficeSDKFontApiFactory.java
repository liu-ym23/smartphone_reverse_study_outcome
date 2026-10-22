package com.ss.android.lark.officesdk.common.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import itb.d;
import jtb.c;
import jtb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKCommonModule_ProvideOfficeSDKFontApiFactory implements Factory<d> {
    private final e module;

    public d get() {
        return provideOfficeSDKFontApi(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m27get() {
        return get();
    }

    public OfficeSDKCommonModule_ProvideOfficeSDKFontApiFactory(e r1) {
        this.module = r1;
    }

    public static OfficeSDKCommonModule_ProvideOfficeSDKFontApiFactory create(e r1) {
        return new OfficeSDKCommonModule_ProvideOfficeSDKFontApiFactory(r1);
    }

    public static d provideOfficeSDKFontApi(e r0) {
        r0.getClass();
        return (d) Preconditions.checkNotNullFromProvides(new c());
    }
}
