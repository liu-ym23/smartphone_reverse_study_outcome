package com.larus.canvas.feature.component.logic;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$startConsumer$1", f = "GenImagePlannerComponent.kt", i = {1}, l = {857, 859, 862, 864}, m = "invokeSuspend", n = {"taskId"}, s = {"L$1"})
public final class GenImagePlannerComponent$startConsumer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$startConsumer$1(GenImagePlannerComponent r1, Continuation<? super GenImagePlannerComponent$startConsumer$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImagePlannerComponent$startConsumer$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d8 -> B:16:0x0051). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 == 4) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ChannelIterator r2 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r14);
    L15:
        GenImagePlannerComponent$startConsumer$1 r15 = this;
    L16:
        r15.L$0 = r2;
        r15.L$1 = null;
        r15.label = 1;
        Object r8 = r2.hasNext(r15);
        if (r8 != r0) goto L19;
        return r0;
    L19:
        Object r12 = r0;
        GenImagePlannerComponent$startConsumer$1 r3 = r15;
        r14 = r8;
        ChannelIterator r9 = r2;
        Object r4 = r12;
    L21:
        if (((Boolean) r14).booleanValue() == false) goto L39;
        String r16 = (String) r9.next();
        FLogger.a.i("GenImagePlannerComponent", "consume new task, taskId = " + r16);
        GenImagePlannerComponent r10 = r3.this$0;
        r3.L$0 = r9;
        r3.L$1 = r16;
        r3.label = 2;
        Object r11 = GenImagePlannerComponent.h3(r10, r16, r3);
        if (r11 != r4) goto L25;
        return r4;
    L25:
        ChannelIterator r13 = r9;
        String r17 = r16;
        r14 = r11;
        ChannelIterator r18 = r13;
    L27:
        if (((Boolean) r14).booleanValue() == true) goto L29;
        FLogger.a.i("GenImagePlannerComponent", "consume task failed, pendingMirror not find taskId = " + r17);
    L37:
        r15 = r3;
        r0 = r4;
        r2 = r18;
        goto L16
    L29:
        if (Intrinsics.areEqual(r17, "origin") == false) goto L33;
        GenImagePlannerComponent r19 = r3.this$0;
        r3.L$0 = r18;
        r3.L$1 = null;
        r3.label = 3;
        if (GenImagePlannerComponent.D3(r19, r3) != r4) goto L37;
        return r4;
    L33:
        GenImagePlannerComponent r110 = r3.this$0;
        r3.L$0 = r18;
        r3.L$1 = null;
        r3.label = 4;
        if (GenImagePlannerComponent.B3(r110, r17, r3) != r4) goto L37;
        return r4;
    L39:
        return Unit.INSTANCE;
    L12:
        String r5 = (String) this.L$1;
        ChannelIterator r20 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r14);
        r18 = r20;
        r17 = r5;
        r4 = r0;
        r3 = this;
        goto L27
    L13:
        ChannelIterator r6 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r14);
        r9 = r6;
        r4 = r0;
        r3 = this;
        goto L21
    L14:
        ResultKt.throwOnFailure(r14);
        r2 = this.this$0.K.iterator();
        goto L15
    }
}
