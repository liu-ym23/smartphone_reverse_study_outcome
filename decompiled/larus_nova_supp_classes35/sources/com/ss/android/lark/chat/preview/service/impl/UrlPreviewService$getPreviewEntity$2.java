package com.ss.android.lark.chat.preview.service.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.preview.service.impl.UrlPreviewService$getPreviewEntity$2", f = "UrlPreviewService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UrlPreviewService$getPreviewEntity$2 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<Map<String, UrlCardPreviewEntity>> $callback;
    /* synthetic */ Object L$0;
    int label;

    public UrlPreviewService$getPreviewEntity$2(IGetDataCallback<Map<String, UrlCardPreviewEntity>> r1, Continuation<? super UrlPreviewService$getPreviewEntity$2> r2) {
        this.$callback = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        UrlPreviewService$getPreviewEntity$2 r0 = new UrlPreviewService$getPreviewEntity$2(this.$callback, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ErrorResult r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ErrorResult) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        ErrorResult r3 = (ErrorResult) this.L$0;
        this.$callback.onError(r3);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
