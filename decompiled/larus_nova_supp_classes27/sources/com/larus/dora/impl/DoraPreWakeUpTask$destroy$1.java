package com.larus.dora.impl;

import com.mammon.audiosdk.SAMICore;
import g49.d;
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
@DebugMetadata(c = "com.larus.dora.impl.DoraPreWakeUpTask$destroy$1", f = "DoraPreWakeUpTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraPreWakeUpTask$destroy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraPreWakeUpTask this$0;

    public DoraPreWakeUpTask$destroy$1(DoraPreWakeUpTask r1, Continuation<? super DoraPreWakeUpTask$destroy$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraPreWakeUpTask$destroy$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r5);
        DoraPreWakeUpTask r6 = this.this$0;
        long r0 = System.currentTimeMillis();
        SAMICore r7 = r6.a;
        if (r7 == null) goto L7;
        Boxing.boxInt(r7.SAMICoreDestroyHandle());
    L7:
        d.d("DoraPreWakeUpTask", "SAMICoreDestroyHandle consumeTimeMillis: " + (System.currentTimeMillis() - r0));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
