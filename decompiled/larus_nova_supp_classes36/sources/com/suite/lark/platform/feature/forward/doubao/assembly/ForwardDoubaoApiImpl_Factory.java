package com.suite.lark.platform.feature.forward.doubao.assembly;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardDoubaoApiImpl_Factory implements Factory<ForwardDoubaoApiImpl> {

    public static final class a {
        public static final ForwardDoubaoApiImpl_Factory a = null;

        static {
            a = new ForwardDoubaoApiImpl_Factory();
        }
    }

    public ForwardDoubaoApiImpl_Factory() {
    }

    public static ForwardDoubaoApiImpl newInstance() {
        return new ForwardDoubaoApiImpl();
    }

    public ForwardDoubaoApiImpl get() {
        return newInstance();
    }

    public static ForwardDoubaoApiImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1819get() {
        return get();
    }
}
