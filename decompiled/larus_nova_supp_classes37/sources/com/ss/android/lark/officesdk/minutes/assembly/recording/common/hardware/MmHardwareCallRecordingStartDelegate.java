package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmHardwareCallRecordingStartDelegate {
    public static final /* synthetic */ int g = 0;
    public final hub.a a;
    public final tub.a b;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a c;
    public final String d;
    public final Lazy e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    public final Object a(String r8, Continuation<? super Boolean> r9) {
        if ((r9 instanceof MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1) == false) goto L7;
        MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1 r0 = (MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L21:
        if (r10 == null) goto L24;
        r4 = true;
    L24:
        return Boxing.boxBoolean(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        MmRecordingSessionManager r11 = this.c.A();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r8, "sessionId");
        MmRecordingSession r12 = r11.m(r8);
        if (r12 != null) goto L18;
        lvb.a.b(this.d, "[awaitLocalCaptureReady] session not found, recordingId=".concat(r8));
        return Boxing.boxBoolean(false);
    L18:
        MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$2 r13 = new MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$2(r12, null);
        r0.label = 1;
        r10 = TimeoutKt.c(5000, r13, r0);
        if (r10 != r2) goto L21;
        return r2;
    L7:
        r0 = new MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1(this, r9);
        goto L8
    }

    public MmHardwareCallRecordingStartDelegate(hub.a r2, tub.a r3, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r4) {
        Intrinsics.checkNotNullParameter(r2, "capacity");
        Intrinsics.checkNotNullParameter(r3, "priorityCapacity");
        Intrinsics.checkNotNullParameter(r4, "userContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = "MmHardwareCallRecordingStartDelegate_" + hashCode();
        this.e = LazyKt.lazy(new MmHardwareCallRecordingStartDelegate$floatController$2(this));
        this.f = LazyKt.lazy(new MmHardwareCallRecordingStartDelegate$foregroundRetryController$2(this));
    }
}
