package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationViewModel$onSetLanguage$3$accepted$1$2$1", f = "MmStandaloneAIInterpretationViewModel.kt", i = {0, 1}, l = {303, 304}, m = "invokeSuspend", n = {"sourceDeferred", "targetAccepted"}, s = {"L$0", "Z$0"})
public final class MmStandaloneAIInterpretationViewModel$onSetLanguage$3$accepted$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ MmRecordingSession $session;
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c $spokenLanguage;
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c $targetLanguage;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationViewModel this$0;

    public MmStandaloneAIInterpretationViewModel$onSetLanguage$3$accepted$1$2$1(MmStandaloneAIInterpretationViewModel r1, MmRecordingSession r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r3, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r4, Continuation<? super MmStandaloneAIInterpretationViewModel$onSetLanguage$3$accepted$1$2$1> r5) {
        this.this$0 = r1;
        this.$session = r2;
        this.$targetLanguage = r3;
        this.$spokenLanguage = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmStandaloneAIInterpretationViewModel$onSetLanguage$3$accepted$1$2$1 r6 = new MmStandaloneAIInterpretationViewModel$onSetLanguage$3$accepted$1$2$1(this.this$0, this.$session, this.$targetLanguage, this.$spokenLanguage, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        boolean r2 = this.Z$0;
        ResultKt.throwOnFailure(r13);
    L18:
        boolean r14 = ((Boolean) r13).booleanValue();
        if (r2 == false) goto L22;
        if (r14 == false) goto L22;
    L24:
        return Boxing.boxBoolean(r4);
    L22:
        r4 = false;
        goto L24
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Deferred r3 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r13);
    L14:
        boolean r15 = ((Boolean) r13).booleanValue();
        this.L$0 = null;
        this.Z$0 = r15;
        this.label = 2;
        Object r5 = r3.await(this);
        if (r5 != r0) goto L17;
        return r0;
    L17:
        r2 = r15;
        r13 = r5;
        goto L18
    L10:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        Deferred r6 = BuildersKt.async$default(r16, null, null, new MmStandaloneAIInterpretationViewModel$onSetLanguage$3$accepted$1$2$1$targetDeferred$1(this.this$0, this.$session, this.$targetLanguage, null), 3, null);
        Deferred r17 = BuildersKt.async$default(r16, null, null, new MmStandaloneAIInterpretationViewModel$onSetLanguage$3$accepted$1$2$1$sourceDeferred$1(this.this$0, this.$session, this.$spokenLanguage, null), 3, null);
        this.L$0 = r17;
        this.label = 1;
        Object r7 = r6.await(this);
        if (r7 != r0) goto L13;
        return r0;
    L13:
        r3 = r17;
        r13 = r7;
        goto L14
    }
}
