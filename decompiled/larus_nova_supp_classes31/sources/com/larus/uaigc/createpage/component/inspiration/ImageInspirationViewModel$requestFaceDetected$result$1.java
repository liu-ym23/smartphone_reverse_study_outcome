package com.larus.uaigc.createpage.component.inspiration;

import com.larus.network.bean.BizResponse;
import com.larus.uaigc.api.ReviewUgcImageApi;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/api/ReviewUgcImageApi$ReviewUgcImageData;", "Lcom/larus/uaigc/api/ReviewUgcImageApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.inspiration.ImageInspirationViewModel$requestFaceDetected$result$1", f = "ImageInspirationViewModel.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
public final class ImageInspirationViewModel$requestFaceDetected$result$1 extends SuspendLambda implements Function2<ReviewUgcImageApi, Continuation<? super BizResponse<ReviewUgcImageApi.c>>, Object> {
    final /* synthetic */ String $imageUri;
    private /* synthetic */ Object L$0;
    int label;

    public ImageInspirationViewModel$requestFaceDetected$result$1(String r1, Continuation<? super ImageInspirationViewModel$requestFaceDetected$result$1> r2) {
        this.$imageUri = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ImageInspirationViewModel$requestFaceDetected$result$1 r0 = new ImageInspirationViewModel$requestFaceDetected$result$1(this.$imageUri, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ReviewUgcImageApi r1, Continuation<? super BizResponse<ReviewUgcImageApi.c>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ReviewUgcImageApi) r1, (Continuation) r2);
    }

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
        ReviewUgcImageApi r8 = (ReviewUgcImageApi) this.L$0;
        ReviewUgcImageApi.d r2 = new ReviewUgcImageApi.d(this.$imageUri, Boxing.boxBoolean(false), Boxing.boxBoolean(true));
        this.label = 1;
        r7 = r8.reviewUgcImage(r2, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
