package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$sourceAccepted$1", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {180}, m = "invokeSuspend", n = {}, s = {})
public final class MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$sourceAccepted$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ Deferred<Pair<g, g>> $targetDeferred;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    public MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$sourceAccepted$1(Deferred<Pair<g, g>> r1, MmStandaloneAIInterpretationRepo r2, Continuation<? super MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$sourceAccepted$1> r3) {
        this.$targetDeferred = r1;
        this.this$0 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmStandaloneAIInterpretationRepo$opt$2$1$switchFromBidirectionalLanguage$2$1$sourceAccepted$1(this.$targetDeferred, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Boolean> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        Pair r5 = (Pair) r4;
        g r3 = (g) r5.component1();
        g r6 = (g) r5.component2();
        if (r3 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L27;
        if (r6 != null) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == false) goto L27;
        if (this.this$0.j.g().a() == false) goto L27;
    L29:
        return Boxing.boxBoolean(r2);
    L20:
        if (r6.a() != true) goto L22;
        r8 = true;
    L27:
        r2 = false;
        goto L29
    L14:
        if (r3.a() != true) goto L16;
        r7 = true;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Deferred<Pair<g, g>> r9 = this.$targetDeferred;
        this.label = 1;
        r4 = r9.await(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
