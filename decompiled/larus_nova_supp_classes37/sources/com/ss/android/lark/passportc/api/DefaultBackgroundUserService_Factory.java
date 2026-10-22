package com.ss.android.lark.passportc.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DefaultBackgroundUserService_Factory implements Factory<c> {

    public static final class a {
        public static final DefaultBackgroundUserService_Factory a = null;

        static {
            a = new DefaultBackgroundUserService_Factory();
        }
    }

    public DefaultBackgroundUserService_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    public c get() {
        return newInstance();
    }

    public static DefaultBackgroundUserService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m690get() {
        return get();
    }
}
