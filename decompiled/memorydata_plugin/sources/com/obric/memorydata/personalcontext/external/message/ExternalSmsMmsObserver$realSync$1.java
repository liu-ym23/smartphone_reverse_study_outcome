package com.obric.memorydata.personalcontext.external.message;

import com.obric.memorydata.personalcontext.external.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
@DebugMetadata(c = "com.obric.memorydata.personalcontext.external.message.ExternalSmsMmsObserver$realSync$1", f = "ExternalSmsMmsObserver.kt", i = {1}, l = {71, 72}, m = "invokeSuspend", n = {"deleteItemIds"}, s = {"L$0"})
final class ExternalSmsMmsObserver$realSync$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $currentTime;
    final /* synthetic */ ar<List<String>> $deleteItemIdsDeferred;
    final /* synthetic */ Long $lastSyncTime;
    final /* synthetic */ ar<List<String>> $updateItemIdsDeferred;
    Object L$0;
    int label;
    final /* synthetic */ c this$0;

    ExternalSmsMmsObserver$realSync$1(ar<? extends List<String>> r3, ar<? extends List<String>> r4, long r5, c r7, Long r8, Continuation<? super ExternalSmsMmsObserver$realSync$1> r9) {
        ar<List<String>> r6 = (ar) ZeusTransformUtils.wrapperContextForParams(r3, ar.class, "com.obric.memorydata.plugin");
        ar<List<String>> r10 = (ar) ZeusTransformUtils.wrapperContextForParams(r4, ar.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$deleteItemIdsDeferred = r6;
        this.$updateItemIdsDeferred = r10;
        this.$currentTime = r5;
        this.this$0 = r7;
        this.$lastSyncTime = r8;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ExternalSmsMmsObserver$realSync$1(this.$deleteItemIdsDeferred, this.$updateItemIdsDeferred, this.$currentTime, this.this$0, this.$lastSyncTime, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ExternalSmsMmsObserver$realSync$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ExternalSmsMmsObserver$realSync$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        List<String> r2 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L17:
        List<String> r9 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.personalcontext.external.c.f12108a.a("ExternalSmsMmsObserver", "handle uri change: duration=" + (System.currentTimeMillis() - this.$currentTime) + ", update ids=" + r9 + ", delete ids=" + r2);
        if (r2.isEmpty() == true) goto L20;
    L29:
        c.b(this.this$0).a(r9, 101);
        c.b(this.this$0).b(r2, 101);
    L28:
        g.f12138a.a("message", this.$currentTime);
    L26:
        return Unit.INSTANCE;
    L20:
        if (r9.isEmpty() == false) goto L29;
        if (this.$lastSyncTime == null) goto L27;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalSmsMmsObserver", "update、delete ids are empty, sync again from beginning, lastSyncTime=" + this.$lastSyncTime);
        c.b(this.this$0, null, this.$currentTime);
        goto L26
    L27:
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalSmsMmsObserver", "update, delete ids are empty in full sync, just update lastSyncTime");
        goto L28
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        List<String> r10 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        ar<List<String>> r3 = this.$updateItemIdsDeferred;
        Continuation<? super List<String>> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r10;
        this.label = 2;
        Object r5 = r3.a(r4);
        if (r5 != r0) goto L16;
        return r0;
    L16:
        r2 = r10;
        r8 = r5;
        goto L17
    L10:
        ResultKt.throwOnFailure(r8);
        ar<List<String>> r11 = this.$deleteItemIdsDeferred;
        Continuation<? super List<String>> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r8 = r11.a(r6);
        if (r8 != r0) goto L13;
        return r0;
    }
}
