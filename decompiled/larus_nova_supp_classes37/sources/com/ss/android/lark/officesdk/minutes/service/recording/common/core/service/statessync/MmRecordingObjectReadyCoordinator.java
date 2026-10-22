package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common.CoroutinesSafe;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingObjectReadyCoordinator {
    public final CoroutineScope a;
    public final StateFlowImpl b;
    public final b1 c;
    public final CoroutinesSafe d;

    public final boolean c() {
        Result r0 = (Result) this.b.getValue();
        String r1 = null;
        if (r0 == null) goto L10;
        Object r2 = r0.unbox-impl();
        if (Result.isFailure-impl(r2) == false) goto L7;
        r2 = null;
    L7:
        MmCreateAudioResponse r3 = (MmCreateAudioResponse) r2;
        if (r3 == null) goto L10;
        r1 = r3.getRecordingId();
    L10:
        if (r1 != null) goto L13;
        r1 = "";
    L13:
        return b(r1);
    }

    public MmRecordingObjectReadyCoordinator(CoroutineScope r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
        StateFlowImpl r0 = j1.a(null);
        this.b = r0;
        this.c = kotlinx.coroutines.flow.e.b(r0);
        this.d = new CoroutinesSafe(r2);
    }

    public static boolean b(String r2) {
        if ((!StringsKt.isBlank(r2)) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2, UserInfo.NONE_NAME_CARD_ID) == true) goto L7;
        return true;
    }

    public final Object a(Continuation<? super String> r5) {
        if ((r5 instanceof MmRecordingObjectReadyCoordinator$awaitRecordingIdOrThrow$1) == false) goto L7;
        MmRecordingObjectReadyCoordinator$awaitRecordingIdOrThrow$1 r0 = (MmRecordingObjectReadyCoordinator$awaitRecordingIdOrThrow$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        Object r7 = ((Result) r6).unbox-impl();
        ResultKt.throwOnFailure(r7);
        return ((MmCreateAudioResponse) r7).getRecordingId();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1 r4 = new FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1(this.c);
        r0.label = 1;
        r6 = kotlinx.coroutines.flow.e.s(r4, r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new MmRecordingObjectReadyCoordinator$awaitRecordingIdOrThrow$1(this, r5);
        goto L8
    }
}
