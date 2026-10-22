package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$dispatchAcceptedEntity$2", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {567}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationRepo$dispatchAcceptedEntity$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ c $targetLanguage;
    final /* synthetic */ g $updateResult;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    public MmStandaloneAIInterpretationRepo$dispatchAcceptedEntity$2(MmStandaloneAIInterpretationRepo r1, boolean r2, g r3, c r4, Continuation<? super MmStandaloneAIInterpretationRepo$dispatchAcceptedEntity$2> r5) {
        this.this$0 = r1;
        this.$enabled = r2;
        this.$updateResult = r3;
        this.$targetLanguage = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new MmStandaloneAIInterpretationRepo$dispatchAcceptedEntity$2(this.this$0, this.$enabled, this.$updateResult, this.$targetLanguage, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        b r3 = (b) this.this$0.h();
        if (this.$enabled == false) goto L11;
        MmStandaloneAIInterpretationRepo.m(this.this$0, this.$updateResult.a, "standalone_update_setting");
    L12:
        MmStandaloneAIInterpretationRepo r4 = this.this$0;
        boolean r5 = this.$enabled;
        g r6 = this.$updateResult;
        List<c> r7 = r6.c;
        List<c> r8 = r6.d;
        Map<String, List<String>> r9 = r6.e;
        Map<String, List<String>> r10 = r6.f;
        c r11 = r6.g;
        if (r11 != null) goto L15;
        r11 = r3.f;
    L15:
        c r12 = this.$targetLanguage;
        if (r12 != null) goto L18;
        c r13 = r3.g;
    L19:
        c r14 = r6.h;
        if (r5 == false) goto L22;
        c r15 = r12;
    L23:
        r3.getClass();
        b r16 = b.a(r5, r7, r8, r9, r10, r11, r13, r14, r15, null);
        this.label = 1;
        if (r4.b(r16, this) != r1) goto L27;
        return r1;
    L22:
        r15 = null;
        goto L23
    L18:
        r13 = r12;
        goto L19
    L11:
        MmStandaloneAIInterpretationRepo.l(this.this$0, "standalone_update_setting");
        goto L12
    }
}
