package com.ss.android.lark.preload.v2.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DefaultPrimaryTabServiceImpl_Factory implements Factory<f1c.a> {

    public static final class a {
        public static final DefaultPrimaryTabServiceImpl_Factory a = null;

        static {
            a = new DefaultPrimaryTabServiceImpl_Factory();
        }
    }

    public DefaultPrimaryTabServiceImpl_Factory() {
    }

    public static f1c.a newInstance() {
        return new f1c.a();
    }

    public f1c.a get() {
        return newInstance();
    }

    public static DefaultPrimaryTabServiceImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3413get() {
        return get();
    }
}
