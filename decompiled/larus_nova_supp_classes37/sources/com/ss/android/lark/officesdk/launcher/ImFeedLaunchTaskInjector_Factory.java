package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImFeedLaunchTaskInjector_Factory implements Factory<ImFeedLaunchTaskInjector> {

    public static final class a {
        public static final ImFeedLaunchTaskInjector_Factory a = null;

        static {
            a = new ImFeedLaunchTaskInjector_Factory();
        }
    }

    public ImFeedLaunchTaskInjector_Factory() {
    }

    public static ImFeedLaunchTaskInjector newInstance() {
        return new ImFeedLaunchTaskInjector();
    }

    public ImFeedLaunchTaskInjector get() {
        return newInstance();
    }

    public static ImFeedLaunchTaskInjector_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m129get() {
        return get();
    }
}
