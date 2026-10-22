package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesLaunchTaskInjector_Factory implements Factory<d> {

    public static final class a {
        public static final MinutesLaunchTaskInjector_Factory a = null;

        static {
            a = new MinutesLaunchTaskInjector_Factory();
        }
    }

    public MinutesLaunchTaskInjector_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    public d get() {
        return newInstance();
    }

    public static MinutesLaunchTaskInjector_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m135get() {
        return get();
    }
}
