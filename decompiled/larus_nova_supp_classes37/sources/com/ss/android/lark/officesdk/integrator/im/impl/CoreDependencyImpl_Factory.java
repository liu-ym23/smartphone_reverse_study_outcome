package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CoreDependencyImpl_Factory implements Factory<CoreDependencyImpl> {

    public static final class a {
        public static final CoreDependencyImpl_Factory a = null;

        static {
            a = new CoreDependencyImpl_Factory();
        }
    }

    public CoreDependencyImpl_Factory() {
    }

    public static CoreDependencyImpl newInstance() {
        return new CoreDependencyImpl();
    }

    public CoreDependencyImpl get() {
        return newInstance();
    }

    public static CoreDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m79get() {
        return get();
    }
}
