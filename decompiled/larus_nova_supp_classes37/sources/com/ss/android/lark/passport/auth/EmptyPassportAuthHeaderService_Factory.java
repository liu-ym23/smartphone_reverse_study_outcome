package com.ss.android.lark.passport.auth;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EmptyPassportAuthHeaderService_Factory implements Factory<c> {

    public static final class a {
        public static final EmptyPassportAuthHeaderService_Factory a = null;

        static {
            a = new EmptyPassportAuthHeaderService_Factory();
        }
    }

    public EmptyPassportAuthHeaderService_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    public c get() {
        return newInstance();
    }

    public static EmptyPassportAuthHeaderService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m600get() {
        return get();
    }
}
