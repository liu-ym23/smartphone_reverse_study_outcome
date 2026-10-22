package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;
import nwb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImTaskOrderInjector_Factory implements Factory<c> {

    public static final class a {
        public static final ImTaskOrderInjector_Factory a = null;

        static {
            a = new ImTaskOrderInjector_Factory();
        }
    }

    public ImTaskOrderInjector_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m545get();
    }

    public static ImTaskOrderInjector_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m545get() {
        return newInstance();
    }
}
