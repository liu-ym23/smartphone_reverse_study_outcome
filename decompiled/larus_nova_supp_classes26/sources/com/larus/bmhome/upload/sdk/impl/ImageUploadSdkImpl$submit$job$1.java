package com.larus.bmhome.upload.sdk.impl;

import com.larus.bmhome.upload.sdk.impl.core.UploadOrchestrator;
import com.larus.bmhome.upload.sdk.impl.core.d;
import com.larus.bmhome.upload.sdk.impl.core.e;
import is8.g;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.impl.ImageUploadSdkImpl$submit$job$1", f = "ImageUploadSdkImpl.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
final class ImageUploadSdkImpl$submit$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $record;
    final /* synthetic */ g $request;
    int label;
    final /* synthetic */ c this$0;

    public ImageUploadSdkImpl$submit$job$1(c r1, d r2, g r3, Continuation<? super ImageUploadSdkImpl$submit$job$1> r4) {
        this.this$0 = r1;
        this.$record = r2;
        this.$request = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageUploadSdkImpl$submit$job$1(this.this$0, this.$record, this.$request, r5);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        c r7 = this.this$0;
        UploadOrchestrator r2 = r7.c;
        String r3 = this.$record.a;
        g r4 = this.$request;
        e r8 = r7.b;
        this.label = 1;
        if (r2.b(r3, r4, r8, this) != r0) goto L12;
        return r0;
    }
}
