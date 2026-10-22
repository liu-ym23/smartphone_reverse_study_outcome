package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeLocationDependencyImpl_Factory implements Factory<z0> {

    public static final class a {
        public static final OfficeLocationDependencyImpl_Factory a = null;

        static {
            a = new OfficeLocationDependencyImpl_Factory();
        }
    }

    public OfficeLocationDependencyImpl_Factory() {
    }

    public static z0 newInstance() {
        return new z0();
    }

    public z0 get() {
        return newInstance();
    }

    public static OfficeLocationDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m873get() {
        return get();
    }
}
