package com.ss.android.lark.passport.cookie;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EmptyPassportCookieSyncService_Factory implements Factory<com.ss.android.lark.passport.cookie.a> {

    public static final class a {
        public static final EmptyPassportCookieSyncService_Factory a = null;

        static {
            a = new EmptyPassportCookieSyncService_Factory();
        }
    }

    public EmptyPassportCookieSyncService_Factory() {
    }

    public static com.ss.android.lark.passport.cookie.a newInstance() {
        return new com.ss.android.lark.passport.cookie.a();
    }

    public com.ss.android.lark.passport.cookie.a get() {
        return newInstance();
    }

    public static EmptyPassportCookieSyncService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m602get() {
        return get();
    }
}
