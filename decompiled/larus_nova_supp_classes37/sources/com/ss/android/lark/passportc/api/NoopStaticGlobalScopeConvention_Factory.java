package com.ss.android.lark.passportc.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NoopStaticGlobalScopeConvention_Factory implements Factory<u> {

    public static final class a {
        public static final NoopStaticGlobalScopeConvention_Factory a = null;

        static {
            a = new NoopStaticGlobalScopeConvention_Factory();
        }
    }

    public NoopStaticGlobalScopeConvention_Factory() {
    }

    public static u newInstance() {
        return new u();
    }

    public u get() {
        return newInstance();
    }

    public static NoopStaticGlobalScopeConvention_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m692get() {
        return get();
    }
}
