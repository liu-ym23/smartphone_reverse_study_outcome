package com.ss.android.lark.framework.assembly.sp;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InitUniStoreTask_Factory implements Factory<InitUniStoreTask> {

    public static final class a {
        public static final InitUniStoreTask_Factory a = null;

        static {
            a = new InitUniStoreTask_Factory();
        }
    }

    public InitUniStoreTask_Factory() {
    }

    public static InitUniStoreTask newInstance() {
        return new InitUniStoreTask();
    }

    public InitUniStoreTask get() {
        return newInstance();
    }

    public static InitUniStoreTask_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m699get() {
        return get();
    }
}
