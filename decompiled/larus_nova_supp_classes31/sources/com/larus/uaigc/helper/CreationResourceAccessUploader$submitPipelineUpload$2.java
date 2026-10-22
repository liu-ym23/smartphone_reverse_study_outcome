package com.larus.uaigc.helper;

import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationResourceAccessUploader$submitPipelineUpload$2", f = "CreationResourceAccessUploader.kt", i = {}, l = {389}, m = "invokeSuspend", n = {}, s = {})
final class CreationResourceAccessUploader$submitPipelineUpload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ResourceUploadError, Unit> $failedCallback;
    final /* synthetic */ Function1<mr9.k, Unit> $processCallback;
    final /* synthetic */ com.larus.bmhome.resource.access.w $request;
    final /* synthetic */ Function1<mr9.l, Unit> $successCallback;
    final /* synthetic */ com.larus.bmhome.resource.access.b0 $task;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CreationResourceAccessUploader$submitPipelineUpload$2(com.larus.bmhome.resource.access.b0 r1, com.larus.bmhome.resource.access.w r2, Function1<? super mr9.l, Unit> r3, Function1<? super ResourceUploadError, Unit> r4, Function1<? super mr9.k, Unit> r5, Continuation<? super CreationResourceAccessUploader$submitPipelineUpload$2> r6) {
        this.$task = r1;
        this.$request = r2;
        this.$successCallback = r3;
        this.$failedCallback = r4;
        this.$processCallback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CreationResourceAccessUploader$submitPipelineUpload$2(this.$task, this.$request, this.$successCallback, this.$failedCallback, this.$processCallback, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        com.larus.bmhome.resource.access.a0.d r6 = (com.larus.bmhome.resource.access.a0) r5;
        if ((r6 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L14;
        CreationResourceAccessUploader r2 = CreationResourceAccessUploader.a;
        CreationResourceAccessUploader.b(this.$request.d.a, r6.a);
    L14:
        ICreationResourceAccessServiceKt.c(r6, this.$successCallback, this.$failedCallback);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        com.larus.bmhome.resource.access.b0 r7 = this.$task;
        final Function1<mr9.k, Unit> r3 = this.$processCallback;
        Function1 r4 = new z(r3);
        this.label = 1;
        r5 = ICreationResourceAccessServiceKt.b(r7, r4, this, 1);
        if (r5 != r0) goto L11;
        return r0;
    }
}
