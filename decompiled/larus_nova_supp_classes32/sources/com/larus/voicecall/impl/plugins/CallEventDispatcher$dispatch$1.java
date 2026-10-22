package com.larus.voicecall.impl.plugins;

import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.plugins.CallEventDispatcher$dispatch$1", f = "CallEventDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CallEventDispatcher$dispatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<com.larus.voicecall.impl.scene.a, Unit> $block;
    int label;
    final /* synthetic */ CallEventDispatcher this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public CallEventDispatcher$dispatch$1(CallEventDispatcher r1, Function1<? super com.larus.voicecall.impl.scene.a, Unit> r2, Continuation<? super CallEventDispatcher$dispatch$1> r3) {
        this.this$0 = r1;
        this.$block = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CallEventDispatcher$dispatch$1(this.this$0, this.$block, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        CopyOnWriteArrayList<com.larus.voicecall.impl.scene.a> r4 = this.this$0.a;
        Function1<com.larus.voicecall.impl.scene.a, Unit> r0 = this.$block;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L9;
        com.larus.voicecall.impl.scene.a r1 = (com.larus.voicecall.impl.scene.a) r5.next();
        Intrinsics.checkNotNull(r1);
        r0.invoke(r1);
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
