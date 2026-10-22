package com.ss.android.lark.passportc.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EmptyUserComponentProviders_Factory implements Factory<l> {

    public static final class a {
        public static final EmptyUserComponentProviders_Factory a = null;

        static {
            a = new EmptyUserComponentProviders_Factory();
        }
    }

    public EmptyUserComponentProviders_Factory() {
    }

    public static l newInstance() {
        return new l();
    }

    public l get() {
        return newInstance();
    }

    public static EmptyUserComponentProviders_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m722get() {
        return get();
    }
}
