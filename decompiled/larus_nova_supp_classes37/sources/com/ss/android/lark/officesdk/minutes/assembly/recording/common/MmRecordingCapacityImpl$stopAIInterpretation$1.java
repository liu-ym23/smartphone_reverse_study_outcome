package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmAIInterpretationEventType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.p;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$stopAIInterpretation$1", f = "MmRecordingCapacityImpl.kt", i = {0, 0}, l = {663}, m = "invokeSuspend", n = {"context", PickerReporterConstants.KEY.TARGET}, s = {"L$0", "L$1"})
final class MmRecordingCapacityImpl$stopAIInterpretation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recordingId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public MmRecordingCapacityImpl$stopAIInterpretation$1(MmRecordingCapacityImpl r1, String r2, Continuation<? super MmRecordingCapacityImpl$stopAIInterpretation$1> r3) {
        this.this$0 = r1;
        this.$recordingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingCapacityImpl$stopAIInterpretation$1(this.this$0, this.$recordingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r2 = 0;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r4 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g) this.L$1;
        a r5 = (a) this.L$0;
        ResultKt.throwOnFailure(r7);
    L23:
        p r8 = (p) r7;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.d r6 = r5.a.m();
        if (r8 != null) goto L26;
    L28:
        boolean r9 = false;
    L29:
        if (r9 == true) goto L31;
    L33:
        r3 = false;
    L34:
        MmRecordingCapacityImpl r10 = this.this$0;
        if (r3 == false) goto L37;
        MmAIInterpretationEventType r11 = MmAIInterpretationEventType.STOP_SUCCESS;
    L38:
        String r12 = r6.g;
        if (r12 != null) goto L41;
        r12 = "";
    L41:
        if (r8 == null) goto L43;
        r2 = r8.b;
    L43:
        int r13 = MmRecordingCapacityImpl.n;
        r10.l(r11, r4, r12, r2);
        return Unit.INSTANCE;
    L37:
        r11 = MmAIInterpretationEventType.STOP_FAILED;
        goto L38
    L31:
        if (r6.a == true) goto L33;
    L26:
        if (r8.a() != true) goto L28;
        r9 = true;
        goto L29
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        r5 = MmRecordingCapacityImpl.c(this.this$0, this.$recordingId);
        if (r5 == null) goto L11;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.d r14 = r5.a.m();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r15 = r14.d;
        if (r15 != null) goto L15;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r16 = r14.c;
    L16:
        if (r16 != null) goto L19;
        MmRecordingCapacityImpl.m(this.this$0, MmAIInterpretationEventType.NO_TARGET_LANGUAGE, null, null, 14);
        return Unit.INSTANCE;
    L19:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r17 = r5.a;
        String r18 = r5.c;
        this.L$0 = r5;
        this.L$1 = r16;
        this.label = 1;
        Object r19 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a.C0039a.a(r17, r18, false, r16, this);
        if (r19 != r0) goto L22;
        return r0;
    L22:
        r4 = r16;
        r7 = r19;
        goto L23
    L15:
        r16 = r15;
        goto L16
    L11:
        return Unit.INSTANCE;
    }
}
