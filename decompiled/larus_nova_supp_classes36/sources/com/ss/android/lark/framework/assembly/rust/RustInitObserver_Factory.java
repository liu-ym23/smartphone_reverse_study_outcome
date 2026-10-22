package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RustInitObserver_Factory implements Factory<v> {

    public static final class a {
        public static final RustInitObserver_Factory a = null;

        static {
            a = new RustInitObserver_Factory();
        }
    }

    public RustInitObserver_Factory() {
    }

    public static v newInstance() {
        return new v();
    }

    public v get() {
        return newInstance();
    }

    public static RustInitObserver_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m686get() {
        return get();
    }
}
