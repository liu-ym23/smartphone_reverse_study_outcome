package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DocFeedLaunchTaskInjector_Factory implements Factory<com.ss.android.lark.officesdk.launcher.a> {

    public static final class a {
        public static final DocFeedLaunchTaskInjector_Factory a = null;

        static {
            a = new DocFeedLaunchTaskInjector_Factory();
        }
    }

    public DocFeedLaunchTaskInjector_Factory() {
    }

    public static com.ss.android.lark.officesdk.launcher.a newInstance() {
        return new com.ss.android.lark.officesdk.launcher.a();
    }

    public com.ss.android.lark.officesdk.launcher.a get() {
        return newInstance();
    }

    public static DocFeedLaunchTaskInjector_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m123get() {
        return get();
    }
}
