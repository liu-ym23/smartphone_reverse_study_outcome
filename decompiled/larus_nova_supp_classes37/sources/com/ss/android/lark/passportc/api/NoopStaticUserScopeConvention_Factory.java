package com.ss.android.lark.passportc.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NoopStaticUserScopeConvention_Factory implements Factory<v> {

    public static final class a {
        public static final NoopStaticUserScopeConvention_Factory a = null;

        static {
            a = new NoopStaticUserScopeConvention_Factory();
        }
    }

    public NoopStaticUserScopeConvention_Factory() {
    }

    public static v newInstance() {
        return new v();
    }

    public v get() {
        return newInstance();
    }

    public static NoopStaticUserScopeConvention_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m693get() {
        return get();
    }
}
