package com.obric.miniapp.intent;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
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
@DebugMetadata(c = "com.obric.miniapp.intent.IntentCardOperationHelper$dispatch$1", f = "IntentCardOperationHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IntentCardOperationHelper$dispatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<JSONObject, Unit> $callback;
    final /* synthetic */ String $packageName;
    final /* synthetic */ j $request;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public IntentCardOperationHelper$dispatch$1(String r1, Function1<? super JSONObject, Unit> r2, j r3, Continuation<? super IntentCardOperationHelper$dispatch$1> r4) {
        this.$packageName = r1;
        this.$callback = r2;
        this.$request = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new IntentCardOperationHelper$dispatch$1(this.$packageName, this.$callback, this.$request, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r6);
        String r7 = com.obric.miniapp.utils.b.a.a(this.$packageName);
        if (r7 != null) goto L7;
        r7 = "";
    L7:
        Function1<JSONObject, Unit> r0 = this.$callback;
        h r1 = h.a;
        j r2 = this.$request;
        JSONObject r8 = new JSONObject().put(WindowEvent.Params.RESULT, r7);
        r1.getClass();
        r0.invoke(h.i(r2, r8));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
