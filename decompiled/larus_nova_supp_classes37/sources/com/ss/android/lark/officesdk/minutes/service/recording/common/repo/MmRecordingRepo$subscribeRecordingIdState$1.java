package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeRecordingIdState$1", f = "MmRecordingRepo.kt", i = {}, l = {278}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingRepo$subscribeRecordingIdState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingRepo this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingRepo a;

        public a(MmRecordingRepo r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            Result r9 = (Result) r7;
            if (r9 == null) goto L30;
            Object r10 = r9.unbox-impl();
            MmRecordingRepo r11 = this.a;
            if (Result.isSuccess-impl(r10) == false) goto L28;
            MmCreateAudioResponse r0 = (MmCreateAudioResponse) r10;
            if (StringsKt.isBlank(r0.getRecordingId()) == false) goto L10;
            lvb.a.h(r11.c, "[subscribeRecordingIdState] skip empty recordingId");
            return Unit.INSTANCE;
        L10:
            if (Intrinsics.areEqual(r11.u, r0.getRecordingId()) == false) goto L12;
            lvb.a.e(r11.c, "[subscribeRecordingIdState] skip same recordingId: " + r11.u);
            return Unit.INSTANCE;
        L12:
            r11.u = r0.getRecordingId();
            lvb.a.e(r11.c, "[onRecordingIdReady] recordingId=" + r0.getRecordingId() + ", meetingId=" + r0.getMeetingId() + ", finalAudioType=" + r0.getFinalAudioType() + ", topicLength=" + r0.getTopic().length());
            String r1 = r11.a.w.a;
            if (StringsKt.isBlank(r1) == false) goto L15;
            String r2 = r0.getMeetingId();
        L17:
            if ((!StringsKt.isBlank(r1)) == true) goto L19;
        L23:
            r11.t = r11.t.withRecordingIdReady(r0.getRecordingId(), r2);
            r11.b.N().k(r11.a, r11.t);
            r11.w().l().f(r0);
            r11.s().m().f(r0);
            MmRecordingLocationRepo r12 = r11.v();
            if (r12 == null) goto L28;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a r13 = r12.m();
            if (r13 == null) goto L28;
            r13.u0(r0.getRecordingId());
            goto L28
        L19:
            if ((!StringsKt.isBlank(r0.getMeetingId())) == false) goto L23;
            if (Intrinsics.areEqual(r1, r0.getMeetingId()) == true) goto L23;
            lvb.a.h(r11.c, "[onRecordingIdReady] meetingId mismatch: session=" + r1 + ", response=" + r0.getMeetingId() + ", use=" + r2);
            goto L23
        L15:
            r2 = r1;
        L28:
            Result.box-impl(r10);
        L30:
            return Unit.INSTANCE;
        }
    }

    public MmRecordingRepo$subscribeRecordingIdState$1(MmRecordingRepo r1, Continuation<? super MmRecordingRepo$subscribeRecordingIdState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingRepo$subscribeRecordingIdState$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        b1 r6 = this.this$0.a.i().p;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
