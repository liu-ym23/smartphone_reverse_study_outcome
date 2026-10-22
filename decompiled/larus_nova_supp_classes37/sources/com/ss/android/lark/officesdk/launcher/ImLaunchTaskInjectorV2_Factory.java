package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImLaunchTaskInjectorV2_Factory implements Factory<ImLaunchTaskInjectorV2> {

    public static final class a {
        public static final ImLaunchTaskInjectorV2_Factory a = null;

        static {
            a = new ImLaunchTaskInjectorV2_Factory();
        }
    }

    public ImLaunchTaskInjectorV2_Factory() {
    }

    public static ImLaunchTaskInjectorV2 newInstance() {
        return new ImLaunchTaskInjectorV2();
    }

    public ImLaunchTaskInjectorV2 get() {
        return newInstance();
    }

    public static ImLaunchTaskInjectorV2_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m133get() {
        return get();
    }
}
