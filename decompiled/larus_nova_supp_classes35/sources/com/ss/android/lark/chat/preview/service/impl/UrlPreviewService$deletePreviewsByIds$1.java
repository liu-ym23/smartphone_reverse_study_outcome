package com.ss.android.lark.chat.preview.service.impl;

import com.bytedance.lark.pb.url.v1.DeletePreviewsByIdsResponse;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/bytedance/lark/pb/url/v1/DeletePreviewsByIdsResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.preview.service.impl.UrlPreviewService$deletePreviewsByIds$1", f = "UrlPreviewService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UrlPreviewService$deletePreviewsByIds$1 extends SuspendLambda implements Function2<DeletePreviewsByIdsResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $validIds;
    int label;

    public UrlPreviewService$deletePreviewsByIds$1(List<String> r1, Continuation<? super UrlPreviewService$deletePreviewsByIds$1> r2) {
        this.$validIds = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UrlPreviewService$deletePreviewsByIds$1(this.$validIds, r3);
    }

    public final Object invoke(DeletePreviewsByIdsResponse r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DeletePreviewsByIdsResponse) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        Log.i("[URLPreview] DeletePreviewsByIdsRequest", "success, previewIds.size:" + this.$validIds.size());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
