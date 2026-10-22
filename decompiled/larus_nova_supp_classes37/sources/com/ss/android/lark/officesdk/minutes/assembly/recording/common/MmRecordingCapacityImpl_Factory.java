package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingCapacityImpl_Factory implements Factory<MmRecordingCapacityImpl> {
    private final Provider<com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> userComponentApiProvider;

    public static MmRecordingCapacityImpl newInstance() {
        return new MmRecordingCapacityImpl();
    }

    public MmRecordingCapacityImpl get() {
        MmRecordingCapacityImpl r0 = newInstance();
        r0.a = (com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a) this.userComponentApiProvider.get();
        r0.g();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m171get() {
        return get();
    }

    public MmRecordingCapacityImpl_Factory(Provider<com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> r1) {
        this.userComponentApiProvider = r1;
    }

    public static MmRecordingCapacityImpl_Factory create(Provider<com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> r1) {
        return new MmRecordingCapacityImpl_Factory(r1);
    }
}
