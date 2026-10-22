package com.ss.android.lark.officesdk.applog.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AppLogModule_ProvideOfficeSDKAppLogFactory implements Factory<gtb.a> {
    private final a module;

    public gtb.a get() {
        return provideOfficeSDKAppLog(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m17get() {
        return get();
    }

    public AppLogModule_ProvideOfficeSDKAppLogFactory(a r1) {
        this.module = r1;
    }

    public static AppLogModule_ProvideOfficeSDKAppLogFactory create(a r1) {
        return new AppLogModule_ProvideOfficeSDKAppLogFactory(r1);
    }

    public static gtb.a provideOfficeSDKAppLog(a r0) {
        r0.getClass();
        return (gtb.a) Preconditions.checkNotNullFromProvides(new b());
    }
}
