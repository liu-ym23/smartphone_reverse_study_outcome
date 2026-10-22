package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeOnBoardingInterfacesImpl_Factory implements Factory<d1> {

    public static final class a {
        public static final OfficeOnBoardingInterfacesImpl_Factory a = null;

        static {
            a = new OfficeOnBoardingInterfacesImpl_Factory();
        }
    }

    public OfficeOnBoardingInterfacesImpl_Factory() {
    }

    public static d1 newInstance() {
        return new d1();
    }

    public d1 get() {
        return newInstance();
    }

    public static OfficeOnBoardingInterfacesImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m876get() {
        return get();
    }
}
