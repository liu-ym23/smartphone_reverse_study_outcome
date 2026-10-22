package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserComponentManagerDelegateImpl_Factory implements Factory<a0> {
    private final Provider<y> userComponentManagerProvider;

    public a0 get() {
        return newInstance((y) this.userComponentManagerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m739get() {
        return get();
    }

    public UserComponentManagerDelegateImpl_Factory(Provider<y> r1) {
        this.userComponentManagerProvider = r1;
    }

    public static UserComponentManagerDelegateImpl_Factory create(Provider<y> r1) {
        return new UserComponentManagerDelegateImpl_Factory(r1);
    }

    public static a0 newInstance(y r1) {
        return new a0(r1);
    }
}
