package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeVcApiDependencyImpl_Factory implements Factory<j1> {

    public static final class a {
        public static final OfficeVcApiDependencyImpl_Factory a = null;

        static {
            a = new OfficeVcApiDependencyImpl_Factory();
        }
    }

    public OfficeVcApiDependencyImpl_Factory() {
    }

    public static j1 newInstance() {
        return new j1();
    }

    public j1 get() {
        return newInstance();
    }

    public static OfficeVcApiDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m882get() {
        return get();
    }
}
