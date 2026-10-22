package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeEmailDependencyImpl_Factory implements Factory<v0> {

    public static final class a {
        public static final OfficeEmailDependencyImpl_Factory a = null;

        static {
            a = new OfficeEmailDependencyImpl_Factory();
        }
    }

    public OfficeEmailDependencyImpl_Factory() {
    }

    public static v0 newInstance() {
        return new v0();
    }

    public v0 get() {
        return newInstance();
    }

    public static OfficeEmailDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m870get() {
        return get();
    }
}
