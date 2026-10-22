package com.ss.android.lark.officesdk.permission.impl;

import com.ss.android.lark.officesdk.permission.api.IPermissionRequester;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PermissionRequesterModule_ProvidePermissionRequesterFactory implements Factory<IPermissionRequester> {
    private final a module;

    public IPermissionRequester get() {
        return providePermissionRequester(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m541get() {
        return get();
    }

    public PermissionRequesterModule_ProvidePermissionRequesterFactory(a r1) {
        this.module = r1;
    }

    public static PermissionRequesterModule_ProvidePermissionRequesterFactory create(a r1) {
        return new PermissionRequesterModule_ProvidePermissionRequesterFactory(r1);
    }

    public static IPermissionRequester providePermissionRequester(a r0) {
        r0.getClass();
        return (IPermissionRequester) Preconditions.checkNotNullFromProvides(new b());
    }
}
