package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MessagingDependencyImpl_Factory implements Factory<i0> {

    public static final class a {
        public static final MessagingDependencyImpl_Factory a = null;

        static {
            a = new MessagingDependencyImpl_Factory();
        }
    }

    public MessagingDependencyImpl_Factory() {
    }

    public static i0 newInstance() {
        return new i0();
    }

    public i0 get() {
        return newInstance();
    }

    public static MessagingDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m868get() {
        return get();
    }
}
