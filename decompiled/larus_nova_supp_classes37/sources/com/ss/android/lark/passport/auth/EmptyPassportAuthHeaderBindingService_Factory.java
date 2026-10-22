package com.ss.android.lark.passport.auth;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EmptyPassportAuthHeaderBindingService_Factory implements Factory<b> {

    public static final class a {
        public static final EmptyPassportAuthHeaderBindingService_Factory a = null;

        static {
            a = new EmptyPassportAuthHeaderBindingService_Factory();
        }
    }

    public EmptyPassportAuthHeaderBindingService_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public b get() {
        return newInstance();
    }

    public static EmptyPassportAuthHeaderBindingService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m599get() {
        return get();
    }
}
