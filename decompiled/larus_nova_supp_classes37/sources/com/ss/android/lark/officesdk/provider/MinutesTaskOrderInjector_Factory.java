package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;
import nwb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesTaskOrderInjector_Factory implements Factory<e> {

    public static final class a {
        public static final MinutesTaskOrderInjector_Factory a = null;

        static {
            a = new MinutesTaskOrderInjector_Factory();
        }
    }

    public MinutesTaskOrderInjector_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m547get();
    }

    public static MinutesTaskOrderInjector_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public e m547get() {
        return newInstance();
    }
}
