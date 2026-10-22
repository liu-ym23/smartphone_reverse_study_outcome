package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ExceedGroupLimitInterceptor_Factory implements Factory<ExceedGroupLimitInterceptor> {

    public static final class a {
        public static final ExceedGroupLimitInterceptor_Factory a = null;

        static {
            a = new ExceedGroupLimitInterceptor_Factory();
        }
    }

    public ExceedGroupLimitInterceptor_Factory() {
    }

    public static ExceedGroupLimitInterceptor newInstance() {
        return new ExceedGroupLimitInterceptor();
    }

    public ExceedGroupLimitInterceptor get() {
        return newInstance();
    }

    public static ExceedGroupLimitInterceptor_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1123get() {
        return get();
    }
}
