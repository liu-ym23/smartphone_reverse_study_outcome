package com.larus.bmhome.upload.sdk;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mr9.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.ResourceUploadEngine$upload$2$1$onProgress$1", f = "ResourceUploadSdkIntegration.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
public final class ResourceUploadEngine$upload$2$1$onProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Integer, Continuation<? super Unit>, Object> $onProgress;
    final /* synthetic */ k $result;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceUploadEngine$upload$2$1$onProgress$1(Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> r1, k r2, Continuation<? super ResourceUploadEngine$upload$2$1$onProgress$1> r3) {
        this.$onProgress = r1;
        this.$result = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ResourceUploadEngine$upload$2$1$onProgress$1(this.$onProgress, this.$result, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Function2<Integer, Continuation<? super Unit>, Object> r7 = this.$onProgress;
        Long r2 = this.$result.a;
        if (r2 == null) goto L11;
        long r3 = r2.longValue();
    L12:
        Integer r4 = Boxing.boxInt((int) r3);
        this.label = 1;
        if (r7.invoke(r4, this) != r0) goto L16;
        return r0;
    L11:
        r3 = 0;
        goto L12
    }
}
