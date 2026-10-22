package com.ss.android.lark.framework.assembly.logger;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InitLogTask_Factory implements Factory<InitLogTask> {
    private final Provider<Set<com.ss.android.lark.log.b>> logMufflersProvider;

    public static InitLogTask newInstance() {
        return new InitLogTask();
    }

    public InitLogTask get() {
        InitLogTask r0 = newInstance();
        r0.d = this.logMufflersProvider;
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m666get() {
        return get();
    }

    public InitLogTask_Factory(Provider<Set<com.ss.android.lark.log.b>> r1) {
        this.logMufflersProvider = r1;
    }

    public static InitLogTask_Factory create(Provider<Set<com.ss.android.lark.log.b>> r1) {
        return new InitLogTask_Factory(r1);
    }
}
