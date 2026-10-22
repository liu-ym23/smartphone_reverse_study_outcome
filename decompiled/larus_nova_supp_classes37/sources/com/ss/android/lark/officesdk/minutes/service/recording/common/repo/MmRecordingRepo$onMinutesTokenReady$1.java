package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.MmD1204RecordingEventTracker;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import ovb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$onMinutesTokenReady$1", f = "MmRecordingRepo.kt", i = {}, l = {702}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingRepo$onMinutesTokenReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmCreateAudioResponse $info;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingRepo this$0;

    public MmRecordingRepo$onMinutesTokenReady$1(MmRecordingRepo r1, MmCreateAudioResponse r2, Continuation<? super MmRecordingRepo$onMinutesTokenReady$1> r3) {
        this.this$0 = r1;
        this.$info = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmRecordingRepo$onMinutesTokenReady$1 r0 = new MmRecordingRepo$onMinutesTokenReady$1(this.this$0, this.$info, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
    L19:
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        MmRecordingRepo r2 = this.this$0;
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L27;
        lvb.a.b(r2.c, "[audioFeatureStatus] online signal failed, error=" + r14);
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        MmRecordingRepo r16 = this.this$0;
        b r3 = r16.a.w;
        MmCreateAudioResponse r4 = this.$info;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L21
        MmD1204RecordingEventTracker r6 = r16.b.x();     // Catch: Throwable -> L21
        String r7 = r3.g;     // Catch: Throwable -> L21
        if (StringsKt.isBlank(r7) == false) goto L13;
        r7 = r16.a.e();     // Catch: Throwable -> L21
    L13:
        String r8 = r7;
        String r9 = r16.a.e();     // Catch: Throwable -> L21
        String r17 = r3.a;     // Catch: Throwable -> L21
        if (StringsKt.isBlank(r17) == false) goto L16;
        r17 = r4.getMeetingId();     // Catch: Throwable -> L21
    L16:
        String r10 = r4.getObjectToken();     // Catch: Throwable -> L21
        this.label = 1;     // Catch: Throwable -> L21
        if (r6.d(r8, r9, r17, r10, this) != r0) goto L19;
        return r0;
    L21:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
