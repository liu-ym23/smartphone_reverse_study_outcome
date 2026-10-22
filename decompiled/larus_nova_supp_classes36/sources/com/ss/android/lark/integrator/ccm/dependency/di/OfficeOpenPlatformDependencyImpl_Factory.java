package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeOpenPlatformDependencyImpl_Factory implements Factory<f1> {

    public static final class a {
        public static final OfficeOpenPlatformDependencyImpl_Factory a = null;

        static {
            a = new OfficeOpenPlatformDependencyImpl_Factory();
        }
    }

    public OfficeOpenPlatformDependencyImpl_Factory() {
    }

    public static f1 newInstance() {
        return new f1();
    }

    public f1 get() {
        return newInstance();
    }

    public static OfficeOpenPlatformDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m878get() {
        return get();
    }
}
