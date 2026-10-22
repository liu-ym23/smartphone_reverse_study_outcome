package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$recordingAIInterpretationData$2$invoke$$inlined$flatMapLatest$1", f = "MmRecordingCapacityImpl.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingCapacityImpl$recordingAIInterpretationData$2$invoke$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super iub.g>, String, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public MmRecordingCapacityImpl$recordingAIInterpretationData$2$invoke$$inlined$flatMapLatest$1(Continuation r1, MmRecordingCapacityImpl r2) {
        this.this$0 = r2;
        super(3, r1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((FlowCollector) r1, r2, (Continuation) r3);
    }

    public final Object invoke(FlowCollector<? super iub.g> r3, String r4, Continuation<? super Unit> r5) {
        MmRecordingCapacityImpl$recordingAIInterpretationData$2$invoke$$inlined$flatMapLatest$1 r0 = new MmRecordingCapacityImpl$recordingAIInterpretationData$2$invoke$$inlined$flatMapLatest$1(r5, this.this$0);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L47:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        FlowCollector r16 = (FlowCollector) this.L$0;
        final String r2 = (String) this.L$1;
        if (StringsKt.isBlank(r2) == false) goto L11;
        MmRecordingSession r3 = null;
    L12:
        if (r3 == null) goto L14;
        RecordingSessionType r5 = r3.a;
    L16:
        if (r5 != RecordingSessionType.HARDWARE_RECORDING) goto L18;
        n r4 = new n(new iub.g(r2, 30));
    L43:
        this.label = 1;
        if (kotlinx.coroutines.flow.e.r(r16, r4, this) != r0) goto L47;
        return r0;
    L18:
        if (r3 == null) goto L22;
        MmRecordingRepo r6 = r3.f();
        if (r6 == null) goto L22;
        MmAIInterpretationRepo r7 = r6.q();
    L23:
        if (r7 == null) goto L27;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r8 = r7.n();
        if (r8 == null) goto L27;
        final i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.d> r9 = r8.b();
    L28:
        if (r3 == null) goto L32;
        ovb.b r10 = r3.w;
        if (r10 == null) goto L32;
        String r11 = r10.a;
    L33:
        if (r11 != null) goto L35;
        r11 = "";
    L35:
        if (r7 != null) goto L37;
    L39:
        if (r9 == null) goto L41;
        n r12 = new MmRecordingCapacityImpl$recordingAIInterpretationData$2$invoke$lambda$2$$inlined$map$1(r9, r2);
    L42:
        r4 = r12;
        goto L43
    L41:
        r12 = new n(new iub.g(null, 31));
        goto L42
    L37:
        if ((!StringsKt.isBlank(r11)) == false) goto L39;
        BuildersKt.launch$default(this.this$0.b, null, null, new MmRecordingCapacityImpl$recordingAIInterpretationData$2$2$1(r7, r11, null), 3, null);
    L32:
        r11 = null;
    L27:
        r9 = null;
    L22:
        r7 = null;
        goto L23
    L14:
        r5 = null;
        goto L16
    L11:
        MmRecordingCapacityImpl r13 = this.this$0;
        int r14 = MmRecordingCapacityImpl.n;
        MmRecordingSessionManager r17 = r13.h();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        r3 = r17.m(r2);
        goto L12
    }
}
