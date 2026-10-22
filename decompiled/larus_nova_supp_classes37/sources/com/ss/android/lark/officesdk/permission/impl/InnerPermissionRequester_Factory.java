package com.ss.android.lark.officesdk.permission.impl;

import com.ss.android.lark.officesdk.permission.api.IPermissionRequester;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class InnerPermissionRequester_Factory implements Factory<InnerPermissionRequester> {
    private final Provider<IPermissionRequester> delegateProvider;

    public InnerPermissionRequester get() {
        return newInstance((IPermissionRequester) this.delegateProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m540get() {
        return get();
    }

    public InnerPermissionRequester_Factory(Provider<IPermissionRequester> r1) {
        this.delegateProvider = r1;
    }

    public static InnerPermissionRequester_Factory create(Provider<IPermissionRequester> r1) {
        return new InnerPermissionRequester_Factory(r1);
    }

    public static InnerPermissionRequester newInstance(IPermissionRequester r1) {
        return new InnerPermissionRequester(r1);
    }
}
