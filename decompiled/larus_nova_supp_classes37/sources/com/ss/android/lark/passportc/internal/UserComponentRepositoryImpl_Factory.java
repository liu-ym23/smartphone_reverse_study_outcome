package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserComponentRepositoryImpl_Factory implements Factory<c0> {

    public static final class a {
        public static final UserComponentRepositoryImpl_Factory a = null;

        static {
            a = new UserComponentRepositoryImpl_Factory();
        }
    }

    public UserComponentRepositoryImpl_Factory() {
    }

    public static c0 newInstance() {
        return new c0();
    }

    public c0 get() {
        return newInstance();
    }

    public static UserComponentRepositoryImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m743get() {
        return get();
    }
}
