package com.ss.android.lark.framework.assembly.logger;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DefaultLogMuffler_Factory implements Factory<com.ss.android.lark.framework.assembly.logger.a> {

    public static final class a {
        public static final DefaultLogMuffler_Factory a = null;

        static {
            a = new DefaultLogMuffler_Factory();
        }
    }

    public DefaultLogMuffler_Factory() {
    }

    public static com.ss.android.lark.framework.assembly.logger.a newInstance() {
        return new com.ss.android.lark.framework.assembly.logger.a();
    }

    public com.ss.android.lark.framework.assembly.logger.a get() {
        return newInstance();
    }

    public static DefaultLogMuffler_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m664get() {
        return get();
    }
}
