package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeCoreDependencyImpl_Factory implements Factory<t0> {

    public static final class a {
        public static final OfficeCoreDependencyImpl_Factory a = null;

        static {
            a = new OfficeCoreDependencyImpl_Factory();
        }
    }

    public OfficeCoreDependencyImpl_Factory() {
    }

    public static t0 newInstance() {
        return new t0();
    }

    public t0 get() {
        return newInstance();
    }

    public static OfficeCoreDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m869get() {
        return get();
    }
}
