package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class TraceInterceptor_Factory implements Factory<e0> {

    public static final class a {
        public static final TraceInterceptor_Factory a = null;

        static {
            a = new TraceInterceptor_Factory();
        }
    }

    public TraceInterceptor_Factory() {
    }

    public static e0 newInstance() {
        return new e0();
    }

    public e0 get() {
        return newInstance();
    }

    public static TraceInterceptor_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m689get() {
        return get();
    }
}
