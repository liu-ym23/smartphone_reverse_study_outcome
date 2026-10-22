package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PreviewLaunchTaskInjectorV1_Factory implements Factory<j> {

    public static final class a {
        public static final PreviewLaunchTaskInjectorV1_Factory a = null;

        static {
            a = new PreviewLaunchTaskInjectorV1_Factory();
        }
    }

    public PreviewLaunchTaskInjectorV1_Factory() {
    }

    public static j newInstance() {
        return new j();
    }

    public j get() {
        return newInstance();
    }

    public static PreviewLaunchTaskInjectorV1_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m141get() {
        return get();
    }
}
