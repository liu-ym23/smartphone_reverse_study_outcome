package com.obric.memorydata.datatransport.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "input", "Ljava/io/InputStream;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.datatransport.utils.AttachmentInputStreamOpener$open$privilegedStatus$1", f = "AttachmentInputStreamOpener.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
final class AttachmentInputStreamOpener$open$privilegedStatus$1 extends SuspendLambda implements Function2<InputStream, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<InputStream, Continuation<? super Unit>, Object> $consume;
    final /* synthetic */ Ref.BooleanRef $consumerCompleted;
    final /* synthetic */ Ref.ObjectRef<Throwable> $consumerError;
    /* synthetic */ Object L$0;
    int label;

    AttachmentInputStreamOpener$open$privilegedStatus$1(Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r3, Ref.BooleanRef r4, Ref.ObjectRef<Throwable> r5, Continuation<? super AttachmentInputStreamOpener$open$privilegedStatus$1> r6) {
        Function2<InputStream, Continuation<? super Unit>, Object> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$consume = r7;
        this.$consumerCompleted = r4;
        this.$consumerError = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        AttachmentInputStreamOpener$open$privilegedStatus$1 r0 = new AttachmentInputStreamOpener$open$privilegedStatus$1(this.$consume, this.$consumerCompleted, this.$consumerError, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InputStream r3, Continuation<? super Unit> r4) {
        return ((AttachmentInputStreamOpener$open$privilegedStatus$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AttachmentInputStreamOpener$open$privilegedStatus$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(InputStream r3, Continuation<? super Unit> r4) {
        return invoke2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Throwable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L7
    L15:
        this.$consumerCompleted.element = true;     // Catch: Throwable -> L7
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r5);
        InputStream r6 = (InputStream) ZeusTransformUtils.preCheckCast(this.L$0, InputStream.class, "com.obric.memorydata.plugin");
        Function2<InputStream, Continuation<? super Unit>, Object> r2 = this.$consume;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r2.invoke(r6, this) != r0) goto L15;
        return r0;
    L7:
        th = move-exception;
        this.$consumerError.element = th;
        throw th;
    }
}
