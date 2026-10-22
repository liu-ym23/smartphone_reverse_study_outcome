package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ExceedGroupLimitAndApplyInterceptor_Factory implements Factory<ExceedGroupLimitAndApplyInterceptor> {

    public static final class a {
        public static final ExceedGroupLimitAndApplyInterceptor_Factory a = null;

        static {
            a = new ExceedGroupLimitAndApplyInterceptor_Factory();
        }
    }

    public ExceedGroupLimitAndApplyInterceptor_Factory() {
    }

    public static ExceedGroupLimitAndApplyInterceptor newInstance() {
        return new ExceedGroupLimitAndApplyInterceptor();
    }

    public ExceedGroupLimitAndApplyInterceptor get() {
        return newInstance();
    }

    public static ExceedGroupLimitAndApplyInterceptor_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1122get() {
        return get();
    }
}
