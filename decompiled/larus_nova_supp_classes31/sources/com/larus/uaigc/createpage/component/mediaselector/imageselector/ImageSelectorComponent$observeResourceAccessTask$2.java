package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.uaigc.helper.CreationResourceAccessPerfBridgeKt;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$observeResourceAccessTask$2", f = "ImageSelectorComponent.kt", i = {}, l = {2294}, m = "invokeSuspend", n = {}, s = {})
final class ImageSelectorComponent$observeResourceAccessTask$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ResourceUploadError, Unit> $failedCallback;
    final /* synthetic */ Function1<com.larus.bmhome.resource.access.j0.b, Unit> $onPreprocessedLocalPathReady;
    final /* synthetic */ String $perfParentScene;
    final /* synthetic */ Function1<mr9.l, Unit> $successCallback;
    final /* synthetic */ com.larus.bmhome.resource.access.b0 $task;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageSelectorComponent$observeResourceAccessTask$2(com.larus.bmhome.resource.access.b0 r1, String r2, Function1<? super com.larus.bmhome.resource.access.j0.b, Unit> r3, Function1<? super mr9.l, Unit> r4, Function1<? super ResourceUploadError, Unit> r5, Continuation<? super ImageSelectorComponent$observeResourceAccessTask$2> r6) {
        this.$task = r1;
        this.$perfParentScene = r2;
        this.$onPreprocessedLocalPathReady = r3;
        this.$successCallback = r4;
        this.$failedCallback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        ImageSelectorComponent$observeResourceAccessTask$2 r7 = new ImageSelectorComponent$observeResourceAccessTask$2(this.$task, this.$perfParentScene, this.$onPreprocessedLocalPathReady, this.$successCallback, this.$failedCallback, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L15
    L13:
        Object r7 = Result.constructor-impl((com.larus.bmhome.resource.access.a0) r6);     // Catch: Throwable -> L15
    L17:
        Function1<mr9.l, Unit> r2 = this.$successCallback;
        Function1<ResourceUploadError, Unit> r3 = this.$failedCallback;
        if (Result.isSuccess-impl(r7) == false) goto L20;
        ICreationResourceAccessServiceKt.c((com.larus.bmhome.resource.access.a0) r7, r2, r3);
    L20:
        com.larus.bmhome.resource.access.b0 r4 = this.$task;
        Function1<ResourceUploadError, Unit> r5 = this.$failedCallback;
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L27;
        FLogger.a.e("ImageSelectorComponent", "[observeResourceAccessTask] observe failed, taskId=" + r4.getTaskId(), r8);
        String r9 = r8.getMessage();
        if (r9 != null) goto L25;
        r9 = "";
    L25:
        r5.invoke(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, r9));
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        final com.larus.bmhome.resource.access.b0 r11 = this.$task;
        String r12 = this.$perfParentScene;
        final Function1<com.larus.bmhome.resource.access.j0.b, Unit> r13 = this.$onPreprocessedLocalPathReady;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L15
        Function1 r15 = new u0(r11, r13);     // Catch: Throwable -> L15
        Function1 r16 = new v0(r11);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r6 = CreationResourceAccessPerfBridgeKt.b(r11, r12, r15, r16, this);     // Catch: Throwable -> L15
        if (r6 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
