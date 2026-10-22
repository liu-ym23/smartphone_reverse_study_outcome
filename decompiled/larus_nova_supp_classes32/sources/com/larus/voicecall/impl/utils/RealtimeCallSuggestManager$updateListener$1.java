package com.larus.voicecall.impl.utils;

import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "<unused var>", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeCallSuggestManager$updateListener$1", f = "RealtimeCallSuggestManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallSuggestManager$updateListener$1 extends SuspendLambda implements Function3<List<? extends String>, String, Continuation<? super Unit>, Object> {
    int label;

    public RealtimeCallSuggestManager$updateListener$1(Continuation<? super RealtimeCallSuggestManager$updateListener$1> r2) {
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((List) r1, (String) r2, (Continuation) r3);
    }

    public final Object invoke(List<String> r1, String r2, Continuation<? super Unit> r3) {
        return new RealtimeCallSuggestManager$updateListener$1(r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
