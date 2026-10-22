package com.obric.memorydata.memory.inapptrace;

import com.obric.memorydata.middleware.impl.image.ImageXBizType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/middleware/impl/image/ImageXFileUploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.inapptrace.InAppTraceUploadRepository$uploadTos$uploadResult$1$1", f = "InAppTraceUploadRepository.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {})
final class InAppTraceUploadRepository$uploadTos$uploadResult$1$1 extends SuspendLambda implements Function2<al, Continuation<? super com.obric.memorydata.middleware.impl.image.d>, Object> {
    final /* synthetic */ File $file;
    int label;

    InAppTraceUploadRepository$uploadTos$uploadResult$1$1(File r3, Continuation<? super InAppTraceUploadRepository$uploadTos$uploadResult$1$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$file = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new InAppTraceUploadRepository$uploadTos$uploadResult$1$1(this.$file, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super com.obric.memorydata.middleware.impl.image.d> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super com.obric.memorydata.middleware.impl.image.d> r4) {
        return ((InAppTraceUploadRepository$uploadTos$uploadResult$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), InAppTraceUploadRepository$uploadTos$uploadResult$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        com.obric.memorydata.middleware.impl.image.e r8 = com.obric.memorydata.middleware.impl.image.e.f11724a;
        ImageXBizType r2 = ImageXBizType.O_ASSISTANT_FEEDBACK_FILE;
        File r3 = this.$file;
        Continuation<? super com.obric.memorydata.middleware.impl.image.d> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r7 = r8.a(r2, r3, r4);
        if (r7 != r0) goto L11;
        return r0;
    }
}
