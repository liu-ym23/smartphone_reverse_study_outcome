package com.larus.uploader.impl;

import com.larus.bmhome.upload.ResourceUploadTokenProvider;
import com.larus.platform.api.b4;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import com.ss.bduploader.BDImageXInfo;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mr9.j;
import mr9.k;
import mr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uploader.impl.ImageXUploaderImpl$ImageXUploadListener$onNotify$1", f = "ImageXUploaderImpl.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
public final class ImageXUploaderImpl$ImageXUploadListener$onNotify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BDImageXInfo $info;
    final /* synthetic */ long $parameter;
    final /* synthetic */ int $what;
    int label;
    final /* synthetic */ ImageXUploaderImpl this$0;
    final /* synthetic */ ImageXUploaderImpl.ImageXUploadListener this$1;

    public ImageXUploaderImpl$ImageXUploadListener$onNotify$1(long r1, ImageXUploaderImpl r3, int r4, BDImageXInfo r5, ImageXUploaderImpl.ImageXUploadListener r6, Continuation<? super ImageXUploaderImpl$ImageXUploadListener$onNotify$1> r7) {
        this.$parameter = r1;
        this.this$0 = r3;
        this.$what = r4;
        this.$info = r5;
        this.this$1 = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ImageXUploaderImpl$ImageXUploadListener$onNotify$1(this.$parameter, this.this$0, this.$what, this.$info, this.this$1, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L27:
        l r11 = (l) r10;
        b4.a r2 = this.this$0.d;
        if (r2 == null) goto L33;
        r2.c(r11);
    L33:
        this.this$0.c();
    L57:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        long r3 = this.$parameter;
        if (r3 == 0) goto L13;
        b4.a r4 = this.this$0.d;
        if (r4 == null) goto L13;
        r4.b(new k(Boxing.boxLong(r3), false));
    L13:
        int r5 = this.$what;
        String r6 = null;
        if (r5 != 2) goto L16;
    L38:
        ImageXUploaderImpl.ImageXUploadListener r7 = this.this$1;
        BDImageXInfo r8 = this.$info;
        r7.getClass();
        Long[] r9 = {100028L, -39982L};
        if (r8 == null) goto L41;
        Long r12 = Long.valueOf(r8.mErrorCode);
    L43:
        if (ArraysKt.contains(r9, r12) == false) goto L45;
        ResourceUploadTokenProvider r13 = ResourceUploadTokenProvider.a;
        j r14 = r7.a;
        r13.getClass();
        ResourceUploadTokenProvider.b(r14);
    L45:
        StringBuilder r15 = new StringBuilder("upload failed, what:");
        r15.append(r5);
        r15.append(", error code(");
        if (r8 == null) goto L48;
        Long r16 = Long.valueOf(r8.mErrorCode);
    L49:
        r15.append(r16);
        r15.append("), error msg(");
        if (r8 == null) goto L52;
        r6 = r8.mErrorMsg;
    L52:
        r15.append(r6);
        r15.append(')');
        String r17 = r15.toString();
        FLogger.a.e(r7.b.a, "[handleOnUploadFailed] " + r17);
        b4.a r18 = r7.b.d;
        if (r18 == null) goto L55;
        r18.a(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, r17));
    L55:
        this.this$0.c();
        goto L57
    L48:
        r16 = null;
        goto L49
    L41:
        r12 = null;
        goto L43
    L16:
        if (r5 != 3) goto L18;
        b4.a r19 = this.this$0.d;
        if (r19 == null) goto L37;
        r19.a(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, "upload canceled"));
    L37:
        this.this$0.c();
        goto L57
    L18:
        if (r5 == 6) goto L23;
        if (r5 == 7) goto L38;
    L23:
        if (this.$info == null) goto L30;
        CoroutineDispatcher r110 = Dispatchers.getIO();
        ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1 r20 = new ImageXUploaderImpl$ImageXUploadListener$onNotify$1$uploadResult$1(this.this$1, this.$info, null);
        this.label = 1;
        r10 = BuildersKt.withContext(r110, r20, this);
        if (r10 != r0) goto L27;
        return r0;
    L30:
        b4.a r111 = this.this$0.d;
        if (r111 == null) goto L33;
        r111.a(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, "upload response tos key is null"));
        goto L33
    }
}
