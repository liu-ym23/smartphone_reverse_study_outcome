package com.ss.android.lark.framework.assembly.diskmanage;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RustCleanTask_Factory implements Factory<e> {

    public static final class a {
        public static final RustCleanTask_Factory a = null;

        static {
            a = new RustCleanTask_Factory();
        }
    }

    public RustCleanTask_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    public e get() {
        return newInstance();
    }

    public static RustCleanTask_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m657get() {
        return get();
    }
}
