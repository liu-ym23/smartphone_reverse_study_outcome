package com.ss.android.lark.passport;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserListFetcherTriggerImpl_Factory implements Factory<UserListFetcherTriggerImpl> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public UserListFetcherTriggerImpl get() {
        return newInstance((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m587get() {
        return get();
    }

    public UserListFetcherTriggerImpl_Factory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static UserListFetcherTriggerImpl_Factory create(Provider<j> r1, Provider<v> r2) {
        return new UserListFetcherTriggerImpl_Factory(r1, r2);
    }

    public static UserListFetcherTriggerImpl newInstance(j r1, v r2) {
        return new UserListFetcherTriggerImpl(r1, r2);
    }
}
