package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficePassportDependencyImpl_Factory implements Factory<g1> {

    public static final class a {
        public static final OfficePassportDependencyImpl_Factory a = null;

        static {
            a = new OfficePassportDependencyImpl_Factory();
        }
    }

    public OfficePassportDependencyImpl_Factory() {
    }

    public static g1 newInstance() {
        return new g1();
    }

    public g1 get() {
        return newInstance();
    }

    public static OfficePassportDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m879get() {
        return get();
    }
}
