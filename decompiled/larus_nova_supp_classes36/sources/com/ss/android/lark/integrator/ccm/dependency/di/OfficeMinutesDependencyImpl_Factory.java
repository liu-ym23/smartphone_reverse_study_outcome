package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeMinutesDependencyImpl_Factory implements Factory<c1> {

    public static final class a {
        public static final OfficeMinutesDependencyImpl_Factory a = null;

        static {
            a = new OfficeMinutesDependencyImpl_Factory();
        }
    }

    public OfficeMinutesDependencyImpl_Factory() {
    }

    public static c1 newInstance() {
        return new c1();
    }

    public c1 get() {
        return newInstance();
    }

    public static OfficeMinutesDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m875get() {
        return get();
    }
}
