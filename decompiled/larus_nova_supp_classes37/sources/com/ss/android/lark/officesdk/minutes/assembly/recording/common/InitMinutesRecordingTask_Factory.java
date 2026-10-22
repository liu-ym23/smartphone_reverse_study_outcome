package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class InitMinutesRecordingTask_Factory implements Factory<InitMinutesRecordingTask> {
    private final Provider<com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> componentContextProvider;

    public static InitMinutesRecordingTask newInstance() {
        return new InitMinutesRecordingTask();
    }

    public InitMinutesRecordingTask get() {
        InitMinutesRecordingTask r0 = newInstance();
        r0.a = (com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a) this.componentContextProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m161get() {
        return get();
    }

    public InitMinutesRecordingTask_Factory(Provider<com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> r1) {
        this.componentContextProvider = r1;
    }

    public static InitMinutesRecordingTask_Factory create(Provider<com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> r1) {
        return new InitMinutesRecordingTask_Factory(r1);
    }
}
