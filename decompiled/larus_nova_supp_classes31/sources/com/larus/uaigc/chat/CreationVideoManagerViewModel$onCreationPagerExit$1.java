package com.larus.uaigc.chat;

import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.CreationVideoManagerViewModel$onCreationPagerExit$1", f = "CreationVideoManagerViewModel.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class CreationVideoManagerViewModel$onCreationPagerExit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CreationVideoManagerViewModel this$0;

    public CreationVideoManagerViewModel$onCreationPagerExit$1(CreationVideoManagerViewModel r1, Continuation<? super CreationVideoManagerViewModel$onCreationPagerExit$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationVideoManagerViewModel$onCreationPagerExit$1(this.this$0, r3);
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
        Iterator<Map.Entry<String, Boolean>> r2 = (Iterator) this.L$1;
        CreationVideoManagerViewModel r3 = (CreationVideoManagerViewModel) this.L$0;
        ResultKt.throwOnFailure(r7);
    L10:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<String, Boolean> r8 = r2.next();
        int r4 = CreationVideoManagerViewModel.j;
        MutableSharedFlow r5 = (MutableSharedFlow) r3.f.getValue();
        Pair r9 = TuplesKt.to(r8.getKey(), r8.getValue());
        this.L$0 = r3;
        this.L$1 = r2;
        this.label = 1;
        if (r5.emit(r9, this) != r0) goto L10;
        return r0;
    L14:
        this.this$0.h.clear();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        r3 = this.this$0;
        r2 = r3.h.entrySet().iterator();
        goto L10
    }
}
