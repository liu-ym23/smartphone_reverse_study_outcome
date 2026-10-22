package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.m;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$recordingLanguageData$2$invoke$$inlined$flatMapLatest$1", f = "MmRecordingCapacityImpl.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingCapacityImpl$recordingLanguageData$2$invoke$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super m>, String, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public MmRecordingCapacityImpl$recordingLanguageData$2$invoke$$inlined$flatMapLatest$1(Continuation r1, MmRecordingCapacityImpl r2) {
        this.this$0 = r2;
        super(3, r1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((FlowCollector) r1, r2, (Continuation) r3);
    }

    public final Object invoke(FlowCollector<? super m> r3, String r4, Continuation<? super Unit> r5) {
        MmRecordingCapacityImpl$recordingLanguageData$2$invoke$$inlined$flatMapLatest$1 r0 = new MmRecordingCapacityImpl$recordingLanguageData$2$invoke$$inlined$flatMapLatest$1(r5, this.this$0);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FlowCollector r8 = (FlowCollector) this.L$0;
        final String r2 = (String) this.L$1;
        final i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f> r4 = null;
        if (StringsKt.isBlank(r2) == false) goto L11;
        MmRecordingSession r3 = null;
    L12:
        if (r3 == null) goto L20;
        MmRecordingRepo r5 = r3.f();
        if (r5 == null) goto L20;
        MmRecordingLanguageRepo r6 = r5.l();
        if (r6 == null) goto L20;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r9 = r6.l();
        if (r9 == null) goto L20;
        r4 = r9.b();
    L20:
        if (r4 == null) goto L22;
        Flow<m> r10 = new MmRecordingCapacityImpl$recordingLanguageData$2$invoke$lambda$2$$inlined$map$1(r4, r2);
    L23:
        this.label = 1;
        if (kotlinx.coroutines.flow.e.r(r8, r10, this) != r0) goto L27;
        return r0;
    L22:
        r10 = new n(new m(0));
        goto L23
    L11:
        MmRecordingCapacityImpl r11 = this.this$0;
        int r12 = MmRecordingCapacityImpl.n;
        MmRecordingSessionManager r13 = r11.h();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        r3 = r13.m(r2);
        goto L12
    }
}
