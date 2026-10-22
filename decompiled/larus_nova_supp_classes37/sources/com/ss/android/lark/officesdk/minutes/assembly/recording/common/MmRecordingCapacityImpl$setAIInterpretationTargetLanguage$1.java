package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmAIInterpretationEventType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.p;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$setAIInterpretationTargetLanguage$1", f = "MmRecordingCapacityImpl.kt", i = {0, 3, 4, 4}, l = {565, 572, 577, 582, 602}, m = "invokeSuspend", n = {"context", "context", "context", "closeUpdateResult"}, s = {"L$0", "L$0", "L$0", "L$1"})
final class MmRecordingCapacityImpl$setAIInterpretationTargetLanguage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recordingId;
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g $target;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public MmRecordingCapacityImpl$setAIInterpretationTargetLanguage$1(MmRecordingCapacityImpl r1, String r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r3, Continuation<? super MmRecordingCapacityImpl$setAIInterpretationTargetLanguage$1> r4) {
        this.this$0 = r1;
        this.$recordingId = r2;
        this.$target = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingCapacityImpl$setAIInterpretationTargetLanguage$1(this.this$0, this.$recordingId, this.$target, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r9 = "";
        String r11 = null;
        int r12 = 0;
        boolean r13 = true;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L12;
        if (r0 != 5) goto L11;
        p r1 = (p) this.L$1;
        a r2 = (a) this.L$0;
        ResultKt.throwOnFailure(r17);
        Object r3 = r17;
    L67:
        p r4 = (p) r3;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.d r5 = r2.a.m();
        if (r4 != null) goto L70;
    L72:
        boolean r6 = false;
    L73:
        if (r6 == true) goto L75;
    L82:
        r13 = false;
    L83:
        MmRecordingCapacityImpl r7 = this.this$0;
        if (r13 == false) goto L86;
        MmAIInterpretationEventType r10 = MmAIInterpretationEventType.SWITCH_SUCCESS;
    L87:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r14 = this.$target;
        String r15 = r5.g;
        if (r15 == null) goto L91;
        r9 = r15;
    L91:
        if (r4 == null) goto L93;
        r12 = r4.b;
    L95:
        int r16 = MmRecordingCapacityImpl.n;
        r7.l(r10, r14, r9, r12);
        return Unit.INSTANCE;
    L93:
        if (r1 == null) goto L95;
        r12 = r1.b;
        goto L95
    L86:
        r10 = MmAIInterpretationEventType.SWITCH_FAILED;
        goto L87
    L75:
        if (r5.a == false) goto L82;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r18 = r5.d;
        if (r18 == null) goto L80;
        r11 = r18.a;
    L80:
        if (Intrinsics.areEqual(r11, this.$target.a) == false) goto L82;
    L70:
        if (r4.a() != true) goto L72;
        r6 = true;
        goto L73
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        a r19 = (a) this.L$0;
        ResultKt.throwOnFailure(r17);
        a r110 = r19;
        Object r20 = r17;
    L49:
        r1 = (p) r20;
    L50:
        r2 = r110;
        if (r1 != null) goto L54;
    L56:
        boolean r21 = false;
    L57:
        if (r21 == false) goto L64;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.d r22 = r2.a.m();
        MmRecordingCapacityImpl r23 = this.this$0;
        MmAIInterpretationEventType r24 = MmAIInterpretationEventType.SWITCH_FAILED;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r25 = this.$target;
        String r26 = r22.g;
        if (r26 == null) goto L62;
        r9 = r26;
    L62:
        int r27 = r1.b;
        int r28 = MmRecordingCapacityImpl.n;
        r23.l(r24, r25, r9, r27);
        return Unit.INSTANCE;
    L64:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r29 = r2.a;
        String r30 = r2.c;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r31 = this.$target;
        this.L$0 = r2;
        this.L$1 = r1;
        this.label = 5;
        r3 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a.C0039a.a(r29, r30, true, r31, this);
        if (r3 != r8) goto L67;
        return r8;
    L54:
        if (r1.a() == true) goto L56;
        r21 = true;
        goto L57
    L13:
        ResultKt.throwOnFailure(r17);
    L43:
        MmRecordingCapacityImpl.m(this.this$0, MmAIInterpretationEventType.TARGET_LANGUAGE_SELECTED, this.$target, null, 12);
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r17);
    L36:
        MmRecordingCapacityImpl.m(this.this$0, MmAIInterpretationEventType.TARGET_LANGUAGE_UNCHANGED, this.$target, null, 12);
        return Unit.INSTANCE;
    L15:
        a r32 = (a) this.L$0;
        ResultKt.throwOnFailure(r17);
    L23:
        r110 = r32;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.d r33 = r110.a.m();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r34 = r33.d;
        if (r33.a == false) goto L27;
        this.this$0.e.remove(this.$recordingId);
    L27:
        if (r33.a == false) goto L39;
        if (r34 == null) goto L30;
        String r35 = r34.a;
    L32:
        if (Intrinsics.areEqual(r35, this.$target.a) == false) goto L39;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r36 = r110.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r37 = this.$target;
        this.L$0 = null;
        this.label = 2;
        if (r36.I(r37, this) != r8) goto L36;
        return r8;
    L30:
        r35 = null;
    L39:
        if (r33.a == true) goto L45;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r38 = r110.a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r39 = this.$target;
        this.L$0 = null;
        this.label = 3;
        if (r38.I(r39, this) != r8) goto L43;
        return r8;
    L45:
        if (r34 == null) goto L51;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r40 = r110.a;
        String r41 = r110.c;
        this.L$0 = r110;
        this.label = 4;
        r20 = r40.z(r41, "", false, r34, false, this);
        if (r20 != r8) goto L49;
        return r8;
    L51:
        r1 = null;
        goto L50
    L16:
        ResultKt.throwOnFailure(r17);
        r32 = MmRecordingCapacityImpl.c(this.this$0, this.$recordingId);
        if (r32 == null) goto L19;
        MmRecordingCapacityImpl r42 = this.this$0;
        this.L$0 = r32;
        this.label = 1;
        if (MmRecordingCapacityImpl.b(r42, r32, this) != r8) goto L23;
        return r8;
    L19:
        return Unit.INSTANCE;
    }
}
