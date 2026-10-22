package com.obric.assistant.interaction.impl.essentialtask.base;

import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.base.ParallelTaskGroup$internalExecute$2", f = "ParallelTaskGroup.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
public final class ParallelTaskGroup$internalExecute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ParallelTaskGroup this$0;

    public ParallelTaskGroup$internalExecute$2(ParallelTaskGroup r1, Continuation<? super ParallelTaskGroup$internalExecute$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ParallelTaskGroup$internalExecute$2 r0 = new ParallelTaskGroup$internalExecute$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<Unit>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L21:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        List r2 = this.this$0.getTaskList();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        if (((EssentialTask) r5).needExecute() == false) goto L10;
        r3.add(r5);
        goto L10
    L14:
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r9 = r3.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r6.add(BuildersKt.async$default(r12, null, null, new ParallelTaskGroup$internalExecute$2$2$1((EssentialTask) r9.next(), null), 3, null));
        goto L16
    L18:
        this.label = 1;
        r11 = AwaitKt.a(r6, this);
        if (r11 != r0) goto L21;
        return r0;
    }
}
