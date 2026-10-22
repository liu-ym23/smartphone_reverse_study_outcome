package com.obric.assistant.onelogin;

import com.obric.assistant.login.f0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.onelogin.ObricOneLoginImpl$postQueryOLoginAndOneLogin$1$1", f = "ObricOneLoginImpl.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
final class ObricOneLoginImpl$postQueryOLoginAndOneLogin$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricOneLoginImpl$postQueryOLoginAndOneLogin$1$1(Continuation<? super ObricOneLoginImpl$postQueryOLoginAndOneLogin$1$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricOneLoginImpl$postQueryOLoginAndOneLogin$1$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        if (((Boolean) r7).booleanValue() == false) goto L17;
        if (c0.e() == true) goto L17;
        f0.d(f0.a, "startup_query", null, null, null, 62);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        this.label = 1;
        StateFlowImpl r8 = c0.a;
        r7 = CoroutineScopeKt.coroutineScope(new ObricOneLoginUtilsKt$getOAccountLogin$2(null), this);
        if (r7 != r0) goto L12;
        return r0;
    }
}
