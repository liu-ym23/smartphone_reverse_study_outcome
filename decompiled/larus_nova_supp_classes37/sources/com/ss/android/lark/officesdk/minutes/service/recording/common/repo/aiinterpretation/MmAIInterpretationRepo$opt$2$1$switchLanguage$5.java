package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo$opt$2$1$switchLanguage$5", f = "MmAIInterpretationRepo.kt", i = {}, l = {192, 212, 232}, m = "invokeSuspend", n = {}, s = {})
public final class MmAIInterpretationRepo$opt$2$1$switchLanguage$5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $openResult;
    final /* synthetic */ g $toLanguage;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MmAIInterpretationRepo this$0;
    final /* synthetic */ MmAIInterpretationRepo$opt$2.AnonymousClass1 this$1;

    public MmAIInterpretationRepo$opt$2$1$switchLanguage$5(Object r1, MmAIInterpretationRepo r2, g r3, MmAIInterpretationRepo$opt$2.AnonymousClass1 r4, Continuation<? super MmAIInterpretationRepo$opt$2$1$switchLanguage$5> r5) {
        this.$openResult = r1;
        this.this$0 = r2;
        this.$toLanguage = r3;
        this.this$1 = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new MmAIInterpretationRepo$opt$2$1$switchLanguage$5(this.$openResult, this.this$0, this.$toLanguage, this.this$1, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        MmAIInterpretationRepo r3 = (MmAIInterpretationRepo) this.L$0;
        ResultKt.throwOnFailure(r21);
    L30:
        r3.k.d(false, r3.o, null, false);
        b r4 = r3.k;
        r4.getClass();
        lvb.a.e("MmAIInterpretationAudioController", "[onAIInterpretationStopped]");
        r4.j = false;
        r3.p = null;
    L32:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        MmAIInterpretationRepo r5 = (MmAIInterpretationRepo) this.L$0;
        ResultKt.throwOnFailure(r21);
    L25:
        r5.k.d(false, r5.o, null, false);
        b r6 = r5.k;
        r6.getClass();
        lvb.a.e("MmAIInterpretationAudioController", "[onAIInterpretationStopped]");
        r6.j = false;
        r5.p = null;
        goto L32
    L11:
        g r7 = (g) this.L$1;
        MmAIInterpretationRepo r8 = (MmAIInterpretationRepo) this.L$0;
        ResultKt.throwOnFailure(r21);
    L20:
        r8.k.d(true, r8.o, r7, false);
        goto L32
    L12:
        ResultKt.throwOnFailure(r21);
        Object r9 = this.$openResult;
        MmAIInterpretationRepo r10 = this.this$0;
        g r15 = this.$toLanguage;
        MmAIInterpretationRepo$opt$2.AnonymousClass1 r11 = this.this$1;
        Throwable r12 = Result.exceptionOrNull-impl(r9);
        if (r12 != null) goto L26;
        p r13 = (p) r9;
        if (r13.a() == false) goto L21;
        lvb.a.e(r10.n, "[switchLanguage] success, status=" + r13.b + ", channel=" + r13.a + ", to=" + r15.a);
        MmAIInterpretationRepo.l(r10, r15);
        r10.p = null;
        d r14 = d.a((d) r11.m(), true, null, r15, r15, false, false, null, 98);
        this.L$0 = r10;
        this.L$1 = r15;
        this.label = 1;
        if (r10.b(r14, this) != r1) goto L19;
        return r1;
    L19:
        r7 = r15;
        r8 = r10;
        goto L20
    L21:
        lvb.a.b(r10.n, "[switchLanguage] open failed, status=" + r13.b + ", channel=" + r13.a + ", to=" + r15.a);
        d r16 = d.a((d) r11.m(), false, null, null, null, false, false, "update_failed", 38);
        this.L$0 = r10;
        this.label = 2;
        if (r10.b(r16, this) != r1) goto L24;
        return r1;
    L24:
        r5 = r10;
        goto L25
    L26:
        lvb.a.b(r10.n, "[switchLanguage] open request failed: " + r12);
        d r17 = d.a((d) r11.m(), false, null, null, null, false, false, "update_failed", 38);
        this.L$0 = r10;
        this.label = 3;
        if (r10.b(r17, this) != r1) goto L29;
        return r1;
    L29:
        r3 = r10;
        goto L30
    }
}
