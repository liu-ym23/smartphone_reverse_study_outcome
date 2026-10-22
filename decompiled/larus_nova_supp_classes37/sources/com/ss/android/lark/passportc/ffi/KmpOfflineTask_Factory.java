package com.ss.android.lark.passportc.ffi;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class KmpOfflineTask_Factory implements Factory<KmpOfflineTask> {

    public static final class a {
        public static final KmpOfflineTask_Factory a = null;

        static {
            a = new KmpOfflineTask_Factory();
        }
    }

    public KmpOfflineTask_Factory() {
    }

    public static KmpOfflineTask newInstance() {
        return new KmpOfflineTask();
    }

    public KmpOfflineTask get() {
        return newInstance();
    }

    public static KmpOfflineTask_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m702get() {
        return get();
    }
}
