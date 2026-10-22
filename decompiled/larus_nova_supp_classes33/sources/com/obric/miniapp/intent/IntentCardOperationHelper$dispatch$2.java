package com.obric.miniapp.intent;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.intent.IntentCardOperationHelper$dispatch$2", f = "IntentCardOperationHelper.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, s = {})
final class IntentCardOperationHelper$dispatch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<JSONObject, Unit> $callback;
    final /* synthetic */ j $request;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public IntentCardOperationHelper$dispatch$2(j r1, Function1<? super JSONObject, Unit> r2, Continuation<? super IntentCardOperationHelper$dispatch$2> r3) {
        this.$request = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new IntentCardOperationHelper$dispatch$2(this.$request, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        QueryPrivilegedImageOperation.a r6 = (QueryPrivilegedImageOperation.a) r5;
        Function1<JSONObject, Unit> r2 = this.$callback;
        if (r6.a == false) goto L14;
        h r3 = h.a;
        j r4 = this.$request;
        JSONObject r7 = r6.b;
        r3.getClass();
        JSONObject r8 = h.i(r4, r7);
    L15:
        r2.invoke(r8);
        return Unit.INSTANCE;
    L14:
        h r9 = h.a;
        j r10 = this.$request;
        String r11 = r6.c;
        String r12 = r6.d;
        r9.getClass();
        r8 = h.c(r10, r11, r12);
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        QueryPrivilegedImageOperation r13 = QueryPrivilegedImageOperation.a;
        JSONObject r14 = this.$request.d;
        this.label = 1;
        r5 = r13.d(r14, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
