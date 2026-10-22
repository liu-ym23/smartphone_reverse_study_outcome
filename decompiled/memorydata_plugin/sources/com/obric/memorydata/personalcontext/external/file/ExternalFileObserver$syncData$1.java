package com.obric.memorydata.personalcontext.external.file;

import com.obric.capabilitykit.entity.app.EntityType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.external.file.ExternalFileObserver$syncData$1", f = "ExternalFileObserver.kt", i = {1}, l = {120, 121}, m = "invokeSuspend", n = {"deleteIds"}, s = {"L$0"})
final class ExternalFileObserver$syncData$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ ar<Set<String>> $getDeleteIdsDeferred;
    final /* synthetic */ ar<List<String>> $getUpdateIdsDeferred;
    final /* synthetic */ long $startTimeStamp;
    Object L$0;
    int label;
    final /* synthetic */ e this$0;

    ExternalFileObserver$syncData$1(ar<? extends Set<String>> r3, ar<? extends List<String>> r4, e r5, long r6, Continuation<? super ExternalFileObserver$syncData$1> r8) {
        ar<Set<String>> r7 = (ar) ZeusTransformUtils.wrapperContextForParams(r3, ar.class, "com.obric.memorydata.plugin");
        ar<List<String>> r9 = (ar) ZeusTransformUtils.wrapperContextForParams(r4, ar.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$getDeleteIdsDeferred = r7;
        this.$getUpdateIdsDeferred = r9;
        this.this$0 = r5;
        this.$startTimeStamp = r6;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ExternalFileObserver$syncData$1(this.$getDeleteIdsDeferred, this.$getUpdateIdsDeferred, this.this$0, this.$startTimeStamp, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ExternalFileObserver$syncData$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ExternalFileObserver$syncData$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Set r2 = (Set) ZeusTransformUtils.preCheckCast(this.L$0, Set.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L17:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        e.b(this.this$0).a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")), EntityType.FILE);
        e.b(this.this$0).b(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), EntityType.FILE);
        com.obric.memorydata.personalcontext.external.c.f12108a.a("ExternalFileObserver", "syncData finish, duration=" + (System.currentTimeMillis() - this.$startTimeStamp) + ",update size=" + r9.size() + ",delete size=" + r2.size());
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        Set r10 = (Set) ZeusTransformUtils.preCheckCast(r8, Set.class, "com.obric.memorydata.plugin");
        ar<List<String>> r3 = this.$getUpdateIdsDeferred;
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
        ar<Set<String>> r11 = this.$getDeleteIdsDeferred;
        Continuation<? super Set<String>> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r8 = r11.a(r6);
        if (r8 != r0) goto L13;
        return r0;
    }
}
