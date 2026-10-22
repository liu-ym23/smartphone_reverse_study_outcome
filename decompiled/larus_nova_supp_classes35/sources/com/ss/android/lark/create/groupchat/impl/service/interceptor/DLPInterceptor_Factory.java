package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DLPInterceptor_Factory implements Factory<b> {

    public static final class a {
        public static final DLPInterceptor_Factory a = null;

        static {
            a = new DLPInterceptor_Factory();
        }
    }

    public DLPInterceptor_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public b get() {
        return newInstance();
    }

    public static DLPInterceptor_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1120get() {
        return get();
    }
}
