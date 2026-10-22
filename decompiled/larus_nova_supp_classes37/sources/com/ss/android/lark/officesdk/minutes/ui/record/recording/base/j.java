package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j {
    public static final MMRecordingState a(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L6;
        return MMRecordingState.IDLE;
    L6:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C0037c.c) == false) goto L9;
        return MMRecordingState.INIT;
    L9:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L12;
        return MMRecordingState.PAUSED;
    L12:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.c) == false) goto L15;
        return MMRecordingState.IDLE;
    L15:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.c) == false) goto L18;
        return MMRecordingState.RECORDING;
    L18:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.d.c) == false) goto L21;
        return MMRecordingState.RECORDING;
    L21:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.c) == false) goto L24;
        return MMRecordingState.RECORDING;
    L24:
        if ((r1 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == false) goto L27;
        return MMRecordingState.IDLE;
    L27:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == false) goto L30;
        return MMRecordingState.IDLE;
    L30:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.e.c) == false) goto L33;
        return MMRecordingState.RECORDING;
    L33:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.f.c) == false) goto L36;
        return MMRecordingState.RECORDING;
    L36:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.g.c) == false) goto L39;
        return MMRecordingState.RECORDING;
    L39:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.j.c) == false) goto L43;
        return MMRecordingState.RECORDING;
    L43:
        throw new NoWhenBranchMatchedException();
    }
}
