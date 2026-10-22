package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DefaultErrorInterceptor_Factory implements Factory<DefaultErrorInterceptor> {

    public static final class a {
        public static final DefaultErrorInterceptor_Factory a = null;

        static {
            a = new DefaultErrorInterceptor_Factory();
        }
    }

    public DefaultErrorInterceptor_Factory() {
    }

    public static DefaultErrorInterceptor newInstance() {
        return new DefaultErrorInterceptor();
    }

    public DefaultErrorInterceptor get() {
        return newInstance();
    }

    public static DefaultErrorInterceptor_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1121get() {
        return get();
    }
}
