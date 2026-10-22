package com.larus.uploader.impl;

import com.ss.bduploader.BDImageXInfo;
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
import mr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/platform/model/upload/ResourceUploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uploader.impl.ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1", f = "ImageXUploaderImpl.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
public final class ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super l>, Object> {
    final /* synthetic */ BDImageXInfo $info;
    int label;
    final /* synthetic */ ImageXUploaderImpl.ImageXUploadListener this$0;

    public ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1(ImageXUploaderImpl.ImageXUploadListener r1, BDImageXInfo r2, Continuation<? super ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1> r3) {
        this.this$0 = r1;
        this.$info = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1(this.this$0, this.$info, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super l> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ImageXUploaderImpl.ImageXUploadListener r5 = this.this$0;
        BDImageXInfo r2 = this.$info;
        this.label = 1;
        r4 = ImageXUploaderImpl.ImageXUploadListener.a(r5, r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
