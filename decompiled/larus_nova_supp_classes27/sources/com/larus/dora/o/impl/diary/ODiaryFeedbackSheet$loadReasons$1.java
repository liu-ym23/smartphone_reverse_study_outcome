package com.larus.dora.o.impl.diary;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryFeedbackSheet$loadReasons$1", f = "ODiaryFeedbackSheet.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
final class ODiaryFeedbackSheet$loadReasons$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ i0 this$0;

    public ODiaryFeedbackSheet$loadReasons$1(i0 r1, Continuation<? super ODiaryFeedbackSheet$loadReasons$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ODiaryFeedbackSheet$loadReasons$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        List<String> r5 = (List) ((Map) r4).get(Boxing.boxInt(this.this$0.d));
        List<String> r3 = r5;
        if (r3 != null) goto L14;
    L17:
        if (r2 == true) goto L20;
        this.this$0.c(r5);
    L20:
        return Unit.INSTANCE;
    L14:
        if (r3.isEmpty() == true) goto L17;
        r2 = false;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        DoraODiaryRepo r6 = DoraODiaryRepo.a;
        int r7 = this.this$0.f.a;
        this.label = 1;
        r4 = r6.f(r7, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
