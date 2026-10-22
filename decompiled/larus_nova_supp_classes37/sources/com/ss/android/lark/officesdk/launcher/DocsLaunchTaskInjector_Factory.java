package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DocsLaunchTaskInjector_Factory implements Factory<DocsLaunchTaskInjector> {

    public static final class a {
        public static final DocsLaunchTaskInjector_Factory a = null;

        static {
            a = new DocsLaunchTaskInjector_Factory();
        }
    }

    public DocsLaunchTaskInjector_Factory() {
    }

    public static DocsLaunchTaskInjector newInstance() {
        return new DocsLaunchTaskInjector();
    }

    public DocsLaunchTaskInjector get() {
        return newInstance();
    }

    public static DocsLaunchTaskInjector_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m127get() {
        return get();
    }
}
