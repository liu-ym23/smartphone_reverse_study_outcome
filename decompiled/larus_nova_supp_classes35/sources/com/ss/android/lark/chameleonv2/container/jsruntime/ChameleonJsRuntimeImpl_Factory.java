package com.ss.android.lark.chameleonv2.container.jsruntime;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChameleonJsRuntimeImpl_Factory implements Factory<m0b.a> {

    public static final class a {
        public static final ChameleonJsRuntimeImpl_Factory a = null;

        static {
            a = new ChameleonJsRuntimeImpl_Factory();
        }
    }

    public ChameleonJsRuntimeImpl_Factory() {
    }

    public static m0b.a newInstance() {
        return new m0b.a();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m48get();
    }

    public static ChameleonJsRuntimeImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public m0b.a m48get() {
        return newInstance();
    }
}
