package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImLaunchTaskInjectorV1_Factory implements Factory<ImLaunchTaskInjectorV1> {

    public static final class a {
        public static final ImLaunchTaskInjectorV1_Factory a = null;

        static {
            a = new ImLaunchTaskInjectorV1_Factory();
        }
    }

    public ImLaunchTaskInjectorV1_Factory() {
    }

    public static ImLaunchTaskInjectorV1 newInstance() {
        return new ImLaunchTaskInjectorV1();
    }

    public ImLaunchTaskInjectorV1 get() {
        return newInstance();
    }

    public static ImLaunchTaskInjectorV1_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m131get() {
        return get();
    }
}
