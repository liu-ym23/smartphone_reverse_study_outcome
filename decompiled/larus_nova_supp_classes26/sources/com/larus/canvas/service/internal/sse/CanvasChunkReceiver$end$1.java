package com.larus.canvas.service.internal.sse;

import com.larus.canvas.service.bean.CanvasBlock;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.service.internal.sse.CanvasChunkReceiver$end$1", f = "CanvasChunkReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasChunkReceiver$end$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f $data;
    int label;
    final /* synthetic */ CanvasChunkReceiver this$0;

    public CanvasChunkReceiver$end$1(CanvasChunkReceiver r1, f r2, Continuation<? super CanvasChunkReceiver$end$1> r3) {
        this.this$0 = r1;
        this.$data = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CanvasChunkReceiver$end$1(this.this$0, this.$data, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r13);
        CanvasChunkReceiver r14 = this.this$0;
        ny8.c r0 = r14.a;
        List<CanvasBlock> r15 = r14.d;
        f r1 = this.$data;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
    L6:
        if (r16.hasNext() == false) goto L8;
        r2.add(CanvasBlock.copy$default((CanvasBlock) r16.next(), null, null, null, false, r1.b, 15, null));
        goto L6
    L8:
        r0.b(r2);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
