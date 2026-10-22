package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.k;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmStandaloneAIInterpretationStateHandler$createSimultaneousRecording$1", f = "MmStandaloneAIInterpretationStateHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationStateHandler$createSimultaneousRecording$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $recordingId;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationStateHandler this$0;

    public MmStandaloneAIInterpretationStateHandler$createSimultaneousRecording$1(MmStandaloneAIInterpretationStateHandler r1, String r2, String r3, Continuation<? super MmStandaloneAIInterpretationStateHandler$createSimultaneousRecording$1> r4) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$recordingId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmStandaloneAIInterpretationStateHandler$createSimultaneousRecording$1(this.this$0, this.$meetingId, this.$recordingId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r7);
        String r8 = this.this$0.b;
        StringBuilder r0 = new StringBuilder("[createSimultaneousRecording] start, meetingId=");
        r0.append(lvb.a.d(this.$meetingId));
        r0.append(", recordingId=");
        r0.append(lvb.a.d(this.$recordingId));
        r0.append(", source=");
        k r1 = this.this$0.a.f;
        if (r1 == null) goto L7;
        MmRecordingSource r2 = r1.a;
    L8:
        r0.append(r2);
        lvb.a.e(r8, r0.toString());
        MmStandaloneAIInterpretationStateHandler r9 = this.this$0;
        MmRecordingStatesSyncService r3 = r9.e;
        String r4 = this.$meetingId;
        int r5 = r9.c.getSettingsService().h.getMinutesTokenRetryMaxTimes();
        final MmStandaloneAIInterpretationStateHandler r10 = this.this$0;
        r3.i(r4, r5, new AnonymousClass1(r10), this.this$0.a.c(), this.$recordingId);
        return Unit.INSTANCE;
    L7:
        r2 = null;
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
