package com.larus.uaigc.helper;

import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationResourceAccessUploader$submitPipelineUpload$1", f = "CreationResourceAccessUploader.kt", i = {}, l = {381}, m = "invokeSuspend", n = {}, s = {})
final class CreationResourceAccessUploader$submitPipelineUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.resource.access.w $request;
    final /* synthetic */ com.larus.bmhome.resource.access.b0 $task;
    int label;

    public CreationResourceAccessUploader$submitPipelineUpload$1(com.larus.bmhome.resource.access.b0 r1, com.larus.bmhome.resource.access.w r2, Continuation<? super CreationResourceAccessUploader$submitPipelineUpload$1> r3) {
        this.$task = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationResourceAccessUploader$submitPipelineUpload$1(this.$task, this.$request, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        com.larus.bmhome.resource.access.a0.d r5 = (com.larus.bmhome.resource.access.a0) r4;
        if ((r5 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L15;
        CreationResourceAccessUploader r2 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.b(this.$request.d.a, r5.a);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        com.larus.bmhome.resource.access.b0 r6 = this.$task;
        this.label = 1;
        r4 = ICreationResourceAccessServiceKt.b(r6, null, this, 3);
        if (r4 != r0) goto L11;
        return r0;
    }
}
