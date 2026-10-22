package com.ss.android.lark.passport.auth;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EmptyPassportSessionRotatedObserver_Factory implements Factory<d> {

    public static final class a {
        public static final EmptyPassportSessionRotatedObserver_Factory a = null;

        static {
            a = new EmptyPassportSessionRotatedObserver_Factory();
        }
    }

    public EmptyPassportSessionRotatedObserver_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    public d get() {
        return newInstance();
    }

    public static EmptyPassportSessionRotatedObserver_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m601get() {
        return get();
    }
}
