package com.ss.android.lark.passportc.ffi;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class KmpOnlineTask_Factory implements Factory<KmpOnlineTask> {

    public static final class a {
        public static final KmpOnlineTask_Factory a = null;

        static {
            a = new KmpOnlineTask_Factory();
        }
    }

    public KmpOnlineTask_Factory() {
    }

    public static KmpOnlineTask newInstance() {
        return new KmpOnlineTask();
    }

    public KmpOnlineTask get() {
        return newInstance();
    }

    public static KmpOnlineTask_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m703get() {
        return get();
    }
}
