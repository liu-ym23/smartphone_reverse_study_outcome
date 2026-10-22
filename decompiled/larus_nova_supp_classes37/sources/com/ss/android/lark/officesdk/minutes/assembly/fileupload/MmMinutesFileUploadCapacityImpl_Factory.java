package com.ss.android.lark.officesdk.minutes.assembly.fileupload;

import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmMinutesFileUploadCapacityImpl_Factory implements Factory<MmMinutesFileUploadCapacityImpl> {
    private final Provider<a> userComponentApiProvider;

    public static MmMinutesFileUploadCapacityImpl newInstance() {
        return new MmMinutesFileUploadCapacityImpl();
    }

    public MmMinutesFileUploadCapacityImpl get() {
        MmMinutesFileUploadCapacityImpl r0 = newInstance();
        r0.a = (a) this.userComponentApiProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m158get() {
        return get();
    }

    public MmMinutesFileUploadCapacityImpl_Factory(Provider<a> r1) {
        this.userComponentApiProvider = r1;
    }

    public static MmMinutesFileUploadCapacityImpl_Factory create(Provider<a> r1) {
        return new MmMinutesFileUploadCapacityImpl_Factory(r1);
    }
}
