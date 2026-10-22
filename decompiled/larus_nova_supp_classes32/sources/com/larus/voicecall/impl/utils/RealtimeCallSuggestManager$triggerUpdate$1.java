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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeCallSuggestManager$triggerUpdate$1", f = "RealtimeCallSuggestManager.kt", i = {}, l = {107, 107}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallSuggestManager$triggerUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RealtimeCallSuggestManager.ShowFrom $showFrom;
    Object L$0;
    int label;
    final /* synthetic */ RealtimeCallSuggestManager this$0;

    public RealtimeCallSuggestManager$triggerUpdate$1(RealtimeCallSuggestManager r1, RealtimeCallSuggestManager.ShowFrom r2, Continuation<? super RealtimeCallSuggestManager$triggerUpdate$1> r3) {
        this.this$0 = r1;
        this.$showFrom = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeCallSuggestManager$triggerUpdate$1(this.this$0, this.$showFrom, r4);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Function3<? super List<String>, ? super String, ? super Continuation<? super Unit>, ? extends Object> r2 = (Function3) this.L$0;
        ResultKt.throwOnFailure(r6);
    L13:
        String r3 = this.$showFrom.getValue();
        this.L$0 = null;
        this.label = 2;
        if (r2.invoke(r6, r3, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        RealtimeCallSuggestManager r7 = this.this$0;
        r2 = r7.f;
        RealtimeCallSuggestManager.Repository r8 = (RealtimeCallSuggestManager.Repository) r7.d.getValue();
        this.L$0 = r2;
        this.label = 1;
        r6 = r8.a(this);
        if (r6 != r0) goto L13;
        return r0;
    }
}
