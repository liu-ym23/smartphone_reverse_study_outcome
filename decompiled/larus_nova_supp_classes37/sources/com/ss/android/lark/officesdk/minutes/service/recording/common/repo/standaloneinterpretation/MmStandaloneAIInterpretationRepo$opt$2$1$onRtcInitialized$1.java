package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$onRtcInitialized$1", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmStandaloneAIInterpretationRepo$opt$2$1$onRtcInitialized$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    public MmStandaloneAIInterpretationRepo$opt$2$1$onRtcInitialized$1(MmStandaloneAIInterpretationRepo r1, Continuation<? super MmStandaloneAIInterpretationRepo$opt$2$1$onRtcInitialized$1> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new MmStandaloneAIInterpretationRepo$opt$2$1$onRtcInitialized$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
        MmStandaloneAIInterpretationRepo r6 = this.this$0;
        MmStandaloneAIInterpretationRepo.Companion r0 = MmStandaloneAIInterpretationRepo.t;
        e r7 = r6.u();
        r7.getClass();
        Intrinsics.checkNotNullParameter("standalone_rtc_initialized", "source");
        r7.k = ((Boolean) r7.a.invoke()).booleanValue();
        boolean r1 = r7.f;
        boolean r2 = true;
        r7.f = true;
        if (r1 == true) goto L7;
        r7.j = null;
    L7:
        boolean r3 = r7.a("standalone_rtc_initialized");
        if (r7.h == null) goto L10;
        boolean r4 = true;
    L11:
        boolean r8 = r7.b(r4);
        if (r3 == true) goto L16;
        if (r8 == true) goto L16;
        r2 = false;
    L16:
        lvb.a.e(this.this$0.l, "[onRtcInitialized] applied=" + r2);
        return Unit.INSTANCE;
    L10:
        r4 = false;
        goto L11
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
