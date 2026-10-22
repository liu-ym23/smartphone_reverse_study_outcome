package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeIMChatDependencyImpl_Factory implements Factory<w0> {

    public static final class a {
        public static final OfficeIMChatDependencyImpl_Factory a = null;

        static {
            a = new OfficeIMChatDependencyImpl_Factory();
        }
    }

    public OfficeIMChatDependencyImpl_Factory() {
    }

    public static w0 newInstance() {
        return new w0();
    }

    public w0 get() {
        return newInstance();
    }

    public static OfficeIMChatDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m871get() {
        return get();
    }
}
