package com.ss.android.lark.passportc.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NoopMultiOnlineFG_Factory implements Factory<t> {

    public static final class a {
        public static final NoopMultiOnlineFG_Factory a = null;

        static {
            a = new NoopMultiOnlineFG_Factory();
        }
    }

    public NoopMultiOnlineFG_Factory() {
    }

    public static t newInstance() {
        return new t();
    }

    public t get() {
        return newInstance();
    }

    public static NoopMultiOnlineFG_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m691get() {
        return get();
    }
}
