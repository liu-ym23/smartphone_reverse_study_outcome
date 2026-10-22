package com.obric.memorydata.personalcontext.external.schedule;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.external.schedule.ExternalScheduleObserver$changeInnerSlow$1", f = "ExternalScheduleObserver.kt", i = {1}, l = {66, 67}, m = "invokeSuspend", n = {"deleteItemIds"}, s = {"L$0"})
final class ExternalScheduleObserver$changeInnerSlow$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ ar<List<String>> $deleteItemIdsDeferred;
    final /* synthetic */ long $startTime;
    final /* synthetic */ ar<List<String>> $updateItemIdsDeferred;
    Object L$0;
    int label;
    final /* synthetic */ d this$0;

    ExternalScheduleObserver$changeInnerSlow$1(ar<? extends List<String>> r3, ar<? extends List<String>> r4, long r5, d r7, Continuation<? super ExternalScheduleObserver$changeInnerSlow$1> r8) {
        ar<List<String>> r6 = (ar) ZeusTransformUtils.wrapperContextForParams(r3, ar.class, "com.obric.memorydata.plugin");
        ar<List<String>> r9 = (ar) ZeusTransformUtils.wrapperContextForParams(r4, ar.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$deleteItemIdsDeferred = r6;
        this.$updateItemIdsDeferred = r9;
        this.$startTime = r5;
        this.this$0 = r7;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ExternalScheduleObserver$changeInnerSlow$1(this.$deleteItemIdsDeferred, this.$updateItemIdsDeferred, this.$startTime, this.this$0, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ExternalScheduleObserver$changeInnerSlow$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ExternalScheduleObserver$changeInnerSlow$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        List<String> r2 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L17:
        List<String> r11 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleObserver", "changeInnerSlow completed: duration=" + (System.currentTimeMillis() - this.$startTime) + "ms, update " + r11.size() + ", delete " + r2.size());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        d.b(this.this$0).a(r11, 402);
    L21:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L24;
        d.b(this.this$0).b(r2, 402);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L13:
        List<String> r12 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        ar<List<String>> r3 = this.$updateItemIdsDeferred;
        Continuation<? super List<String>> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r12;
        this.label = 2;
        Object r4 = r3.a(r5);
        if (r4 != r0) goto L16;
        return r0;
    L16:
        r2 = r12;
        r10 = r4;
        goto L17
    L10:
        ResultKt.throwOnFailure(r10);
        ar<List<String>> r13 = this.$deleteItemIdsDeferred;
        Continuation<? super List<String>> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r10 = r13.a(r6);
        if (r10 != r0) goto L13;
        return r0;
    }
}
