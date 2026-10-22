package com.obric.aikernel.res.metadata.controller;

import com.obric.aikernel.res.metadata.data.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.metadata.controller.MetadataController$flushPackageUsage$1", f = "MetadataController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MetadataController$flushPackageUsage$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ a this$0;

    MetadataController$flushPackageUsage$1(a r3, Continuation<? super MetadataController$flushPackageUsage$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    private static final void invokeSuspend$lambda$0(Function2 r2, Object r3, Object r4) {
        ((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")).invoke(r3, r4);
    }

    public static /* synthetic */ void lambda$EuxOU2gAp0yCUI_z3DuuNNiNkHk(Function2 r0, Object r1, Object r2) {
        invokeSuspend$lambda$0(r0, r1, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MetadataController$flushPackageUsage$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MetadataController$flushPackageUsage$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MetadataController$flushPackageUsage$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        a.c r2 = (a.c) ZeusTransformUtils.preCheckCast(this.this$0.b().a().get("package"), a.c.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        Map<String, Map<String, d>> r4 = r2.a();
        if (r4 == null) goto L10;
        final Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function2.class, "com.obric.memorydata.plugin");
        r4.forEach(new $$Lambda$MetadataController$flushPackageUsage$1$EuxOU2gAp0yCUI_z3DuuNNiNkHk(r5));
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
