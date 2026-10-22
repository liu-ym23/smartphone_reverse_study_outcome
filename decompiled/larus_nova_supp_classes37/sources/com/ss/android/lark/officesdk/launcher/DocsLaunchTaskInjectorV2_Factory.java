package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DocsLaunchTaskInjectorV2_Factory implements Factory<DocsLaunchTaskInjectorV2> {

    public static final class a {
        public static final DocsLaunchTaskInjectorV2_Factory a = null;

        static {
            a = new DocsLaunchTaskInjectorV2_Factory();
        }
    }

    public DocsLaunchTaskInjectorV2_Factory() {
    }

    public static DocsLaunchTaskInjectorV2 newInstance() {
        return new DocsLaunchTaskInjectorV2();
    }

    public DocsLaunchTaskInjectorV2 get() {
        return newInstance();
    }

    public static DocsLaunchTaskInjectorV2_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m126get() {
        return get();
    }
}
