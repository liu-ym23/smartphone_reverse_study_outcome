package com.ss.android.lark.passport.dpop;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NoopDPoPService_Factory implements Factory<c> {

    public static final class a {
        public static final NoopDPoPService_Factory a = null;

        static {
            a = new NoopDPoPService_Factory();
        }
    }

    public NoopDPoPService_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    public c get() {
        return newInstance();
    }

    public static NoopDPoPService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m604get() {
        return get();
    }
}
