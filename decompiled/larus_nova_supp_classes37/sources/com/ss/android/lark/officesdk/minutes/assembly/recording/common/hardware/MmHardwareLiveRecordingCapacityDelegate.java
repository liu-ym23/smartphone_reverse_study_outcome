package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import iub.j;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmHardwareLiveRecordingCapacityDelegate {
    public final hub.a a;

    public static final class a implements iub.a<j, MmRecordingError> {
        public final /* synthetic */ i<Result<j>> a;
        public final /* synthetic */ Function1<j, Unit> b;

        @Override // iub.a
        public final void a(MmRecordingError r5) {
            Intrinsics.checkNotNullParameter(r5, "error");
            if (this.a.isActive() == false) goto L6;
            i<Result<j>> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r5.getErrorCode() + ':' + r5.getErrorMsg()))))));
            return;
        }

        @Override // iub.a
        public final void onSuccess(j r5) {
            final j r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "data");
            i<Result<j>> r0 = this.a;
            Result r1 = Result.box-impl(Result.constructor-impl(r6));
            final Function1<j, Unit> r3 = this.b;
            r0.h(r1, new MmHardwareLiveRecordingCapacityDelegate$awaitResult$2$1$onSuccess$1(r3, r6));
        }

        public a(kotlinx.coroutines.j r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public MmHardwareLiveRecordingCapacityDelegate(hub.a r2) {
        Intrinsics.checkNotNullParameter(r2, "capacity");
        this.a = r2;
    }

    public final Object a(Function1<? super j, Unit> r5, Function1<? super iub.a<j, ? super MmRecordingError>, Unit> r6, Continuation<? super Result<j>> r7) {
        if ((r7 instanceof MmHardwareLiveRecordingCapacityDelegate$awaitResult$1) == false) goto L7;
        MmHardwareLiveRecordingCapacityDelegate$awaitResult$1 r0 = (MmHardwareLiveRecordingCapacityDelegate$awaitResult$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Function1 r9 = (Function1) r0.L$1;
        Function1 r10 = (Function1) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L20:
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.label = 1;
        kotlinx.coroutines.j r11 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r11.C();
        r6.invoke(new a(r11, r5));
        r8 = r11.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L17:
        if (r8 != r2) goto L20;
        return r2;
    L7:
        r0 = new MmHardwareLiveRecordingCapacityDelegate$awaitResult$1(this, r7);
        goto L8
    }
}
