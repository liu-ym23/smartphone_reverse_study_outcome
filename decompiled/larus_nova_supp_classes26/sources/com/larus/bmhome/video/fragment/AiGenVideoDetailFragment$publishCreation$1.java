package com.larus.bmhome.video.fragment;

import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$publishCreation$1", f = "AiGenVideoDetailFragment.kt", i = {}, l = {263, 268, 270}, m = "invokeSuspend", n = {}, s = {})
final class AiGenVideoDetailFragment$publishCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AiGenVideoDetailFragment this$0;

    public AiGenVideoDetailFragment$publishCreation$1(AiGenVideoDetailFragment r1, Continuation<? super AiGenVideoDetailFragment$publishCreation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AiGenVideoDetailFragment$publishCreation$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r6);
    L24:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r6);
    L15:
        String r7 = (String) r6;
        if (o0.d(r7) == false) goto L20;
        AiGenVideoDetailFragment r2 = this.this$0;
        r2.P = r7;
        r2.O = 2;
        this.label = 2;
        if (AiGenVideoDetailFragment.ga0(r2, false, this) != r0) goto L24;
        return r0;
    L20:
        AiGenVideoDetailFragment r8 = this.this$0;
        this.label = 3;
        if (AiGenVideoDetailFragment.ea0(r8, this) != r0) goto L24;
        return r0;
    L12:
        ResultKt.throwOnFailure(r6);
        AiGenVideoDetailFragment r9 = this.this$0;
        int r3 = AiGenVideoDetailFragment.U;
        String r4 = r9.la0();
        this.label = 1;
        r6 = AiGenVideoDetailFragment.fa0(r9, r4, this);
        if (r6 != r0) goto L15;
        return r0;
    }
}
