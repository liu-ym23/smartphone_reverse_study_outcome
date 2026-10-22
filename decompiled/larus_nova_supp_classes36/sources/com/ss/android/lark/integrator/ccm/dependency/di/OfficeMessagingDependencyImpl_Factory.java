package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeMessagingDependencyImpl_Factory implements Factory<OfficeMessagingDependencyImpl> {

    public static final class a {
        public static final OfficeMessagingDependencyImpl_Factory a = null;

        static {
            a = new OfficeMessagingDependencyImpl_Factory();
        }
    }

    public OfficeMessagingDependencyImpl_Factory() {
    }

    public static OfficeMessagingDependencyImpl newInstance() {
        return new OfficeMessagingDependencyImpl();
    }

    public OfficeMessagingDependencyImpl get() {
        return newInstance();
    }

    public static OfficeMessagingDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m874get() {
        return get();
    }
}
