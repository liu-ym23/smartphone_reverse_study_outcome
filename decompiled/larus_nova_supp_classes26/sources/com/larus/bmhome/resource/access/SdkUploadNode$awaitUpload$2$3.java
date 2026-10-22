package com.larus.bmhome.resource.access;

import com.larus.bmhome.upload.ResourceUploader;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.SdkUploadNode$awaitUpload$2$3", f = "SdkUploadNode.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
public final class SdkUploadNode$awaitUpload$2$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.i<f0> $continuation;
    final /* synthetic */ AtomicBoolean $resumed;
    final /* synthetic */ mr9.j $uploadParam;
    int label;
    final /* synthetic */ SdkUploadNode this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public SdkUploadNode$awaitUpload$2$3(kotlinx.coroutines.i<? super f0> r1, AtomicBoolean r2, mr9.j r3, SdkUploadNode r4, Continuation<? super SdkUploadNode$awaitUpload$2$3> r5) {
        this.$continuation = r1;
        this.$resumed = r2;
        this.$uploadParam = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SdkUploadNode$awaitUpload$2$3(this.$continuation, this.$resumed, this.$uploadParam, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L7
    L31:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r7);
        if (this.$continuation.isActive() == false) goto L21;
        if (this.$resumed.get() == true) goto L21;
        ResourceUploader r8 = ResourceUploader.a;     // Catch: Throwable -> L7
        mr9.j r2 = this.$uploadParam;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r8.j(r2, this) != r0) goto L31;
        return r0;
    L21:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        if (this.$continuation.isActive() == false) goto L31;
        if (this.$resumed.compareAndSet(false, true) == false) goto L31;
        kotlinx.coroutines.i<f0> r3 = this.$continuation;
        Result.Companion r4 = Result.Companion;
        this.this$0.getClass();
        String r5 = th.getMessage();
        if (r5 != null) goto L29;
        r5 = "";
    L29:
        r3.resumeWith(Result.constructor-impl(ResultKt.createFailure(new SdkUploadNode.ResourceAccessErrorException(new r("sdk_upload", "upload_exception", r5, th)))));
        goto L31
    }
}
