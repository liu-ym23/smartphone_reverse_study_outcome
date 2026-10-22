package com.ss.android.lark.integrator.im.extension;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ExtensionDependencyImpl_Factory implements Factory<com.ss.android.lark.integrator.im.extension.a> {

    public static final class a {
        public static final ExtensionDependencyImpl_Factory a = null;

        static {
            a = new ExtensionDependencyImpl_Factory();
        }
    }

    public ExtensionDependencyImpl_Factory() {
    }

    public static com.ss.android.lark.integrator.im.extension.a newInstance() {
        return new com.ss.android.lark.integrator.im.extension.a();
    }

    public com.ss.android.lark.integrator.im.extension.a get() {
        return newInstance();
    }

    public static ExtensionDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m893get() {
        return get();
    }
}
