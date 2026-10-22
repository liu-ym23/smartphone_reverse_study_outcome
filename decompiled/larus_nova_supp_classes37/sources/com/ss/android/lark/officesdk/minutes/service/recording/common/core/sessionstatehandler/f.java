package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import iub.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class f {
    public final MmRecordingSession a;

    public abstract void a(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r2);

    public f(MmRecordingSession r2) {
        Intrinsics.checkNotNullParameter(r2, "recordingSession");
        this.a = r2;
    }

    public void b(String r1, iub.a<j, ? super MmRecordingError> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        r2.a(MmRecordingError.TypeDisMatch.INSTANCE);
    }
}
