package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$clearStandaloneAIInterpretationLocalArtifacts$2", f = "MmRecordingStatesSyncService.kt", i = {0, 0, 1}, l = {569, 575}, m = "invokeSuspend", n = {"finalRecordingId", "audioFilePath", "finalRecordingId"}, s = {"L$0", "L$1", "L$0"})
public final class MmRecordingStatesSyncService$clearStandaloneAIInterpretationLocalArtifacts$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $recordingId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MmRecordingStatesSyncService this$0;

    public MmRecordingStatesSyncService$clearStandaloneAIInterpretationLocalArtifacts$2(String r1, MmRecordingStatesSyncService r2, String r3, Continuation<? super MmRecordingStatesSyncService$clearStandaloneAIInterpretationLocalArtifacts$2> r4) {
        this.$recordingId = r1;
        this.this$0 = r2;
        this.$meetingId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingStatesSyncService$clearStandaloneAIInterpretationLocalArtifacts$2(this.$recordingId, this.this$0, this.$meetingId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);
    L23:
        MmRecordingStatesSyncService r9 = this.this$0;
        MmRecordingStatesSyncService.Companion r3 = MmRecordingStatesSyncService.q;
        r9.l().c(this.$meetingId);
        this.this$0.l().c(r2);
        this.this$0.l().d(r2);
        this.this$0.l().e(r2);
        this.this$0.l().g(r2);
        this.this$0.l().f(this.$meetingId);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r4 = (String) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);
        String r10 = r5;
    L19:
        MmRecordFileHelper r6 = MmRecordFileHelper.a;
        this.L$0 = r10;
        this.L$1 = null;
        this.label = 2;
        r6.getClass();
        if (MmRecordFileHelper.b(r4, this) != r0) goto L22;
        return r0;
    L22:
        r2 = r10;
        goto L23
    L10:
        ResultKt.throwOnFailure(r8);
        r10 = this.$recordingId;
        MmRecordingStatesSyncService r7 = this.this$0;
        String r11 = this.$meetingId;
        if (StringsKt.isBlank(r10) == false) goto L13;
        MmRecordingStatesSyncService.Companion r12 = MmRecordingStatesSyncService.q;
        r10 = r7.l().u(r11);
    L13:
        MmRecordingStatesSyncService r13 = this.this$0;
        MmRecordingStatesSyncService.Companion r14 = MmRecordingStatesSyncService.q;
        r4 = r13.l().o(r10);
        MmRecordingStatesSyncService r15 = this.this$0;
        String r16 = this.$meetingId;
        if (StringsKt.isBlank(r4) == false) goto L16;
        r4 = r15.l().o(r16);
    L16:
        lvb.a.e(this.this$0.c, "[standaloneAIInterpretationLocalArtifacts] clear, meetingId:" + this.$meetingId + ", recordingId:" + r10 + ", audioFilePath:" + r4);
        MmRecordFileHelper r17 = MmRecordFileHelper.a;
        String r18 = this.this$0.b.getCurrentUserId();
        String r19 = this.$meetingId;
        r17.getClass();
        String r20 = MmRecordFileHelper.f(r18, r19).getAbsolutePath();
        this.L$0 = r10;
        this.L$1 = r4;
        this.label = 1;
        if (MmRecordFileHelper.b(r20, this) != r0) goto L19;
        return r0;
    }
}
