package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeResourceImpl_Factory implements Factory<i1> {

    public static final class a {
        public static final OfficeResourceImpl_Factory a = null;

        static {
            a = new OfficeResourceImpl_Factory();
        }
    }

    public OfficeResourceImpl_Factory() {
    }

    public static i1 newInstance() {
        return new i1();
    }

    public i1 get() {
        return newInstance();
    }

    public static OfficeResourceImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m881get() {
        return get();
    }
}
