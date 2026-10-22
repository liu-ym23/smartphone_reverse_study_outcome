package com.ss.android.lark.integrator.im.card;

import dagger.internal.Factory;
import omb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UniversalCardJsServiceImpl_Factory implements Factory<g> {

    public static final class a {
        public static final UniversalCardJsServiceImpl_Factory a = null;

        static {
            a = new UniversalCardJsServiceImpl_Factory();
        }
    }

    public UniversalCardJsServiceImpl_Factory() {
    }

    public static g newInstance() {
        return new g();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m892get();
    }

    public static UniversalCardJsServiceImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public g m892get() {
        return newInstance();
    }
}
