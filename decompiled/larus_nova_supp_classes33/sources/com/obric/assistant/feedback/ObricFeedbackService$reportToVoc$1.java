package com.obric.assistant.feedback;

import com.obric.assistant.feedback.voc.VocApiKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.feedback.ObricFeedbackService$reportToVoc$1", f = "ObricFeedbackService.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
final class ObricFeedbackService$reportToVoc$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IObricFeedbackService$c $param;
    int label;

    public ObricFeedbackService$reportToVoc$1(IObricFeedbackService$c r1, Continuation<? super ObricFeedbackService$reportToVoc$1> r2) {
        this.$param = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricFeedbackService$reportToVoc$1(this.$param, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        IObricFeedbackService$c r15 = this.$param;
        String r2 = r15.b;
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        String r3 = r2;
        List<String> r16 = r15.c;
        if (r16 == null) goto L15;
        String r17 = CollectionsKt.joinToString$default(r16, ",", null, null, 0, null, null, 62, null);
        if (r17 == null) goto L15;
    L16:
        this.label = 1;
        if (VocApiKt.a(r3, r17, 1, "{\"is_private_video\":1}", "{\"os\":\"android\"}", this) != r0) goto L20;
        return r0;
    L15:
        r17 = "[]";
        goto L16
    }
}
