package com.ss.android.lark.chameleonv2.usercomponent;

import dagger.internal.Factory;
import v1b.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IUserComponentImpl_Factory implements Factory<b> {

    public static final class a {
        public static final IUserComponentImpl_Factory a = null;

        static {
            a = new IUserComponentImpl_Factory();
        }
    }

    public IUserComponentImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m79get();
    }

    public static IUserComponentImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m79get() {
        return newInstance();
    }
}
