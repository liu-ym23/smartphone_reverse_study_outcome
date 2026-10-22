package com.ss.android.lark.officesdk.ab.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import etb.b;
import ftb.c;
import ftb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKABModule_ProvideOfficeSDKABFactory implements Factory<b> {
    private final c module;

    public b get() {
        return provideOfficeSDKAB(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m9get() {
        return get();
    }

    public OfficeSDKABModule_ProvideOfficeSDKABFactory(c r1) {
        this.module = r1;
    }

    public static OfficeSDKABModule_ProvideOfficeSDKABFactory create(c r1) {
        return new OfficeSDKABModule_ProvideOfficeSDKABFactory(r1);
    }

    public static b provideOfficeSDKAB(c r0) {
        r0.getClass();
        return (b) Preconditions.checkNotNullFromProvides(new d());
    }
}
