package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class StrangerInterceptor_Factory implements Factory<g> {

    public static final class a {
        public static final StrangerInterceptor_Factory a = null;

        static {
            a = new StrangerInterceptor_Factory();
        }
    }

    public StrangerInterceptor_Factory() {
    }

    public static g newInstance() {
        return new g();
    }

    public g get() {
        return newInstance();
    }

    public static StrangerInterceptor_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1126get() {
        return get();
    }
}
