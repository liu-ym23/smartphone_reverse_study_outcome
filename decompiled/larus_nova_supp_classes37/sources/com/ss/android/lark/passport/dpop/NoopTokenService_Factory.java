package com.ss.android.lark.passport.dpop;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NoopTokenService_Factory implements Factory<d> {

    public static final class a {
        public static final NoopTokenService_Factory a = null;

        static {
            a = new NoopTokenService_Factory();
        }
    }

    public NoopTokenService_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    public d get() {
        return newInstance();
    }

    public static NoopTokenService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m605get() {
        return get();
    }
}
