package com.ss.android.lark.chat.preview.service.impl;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.url.v1.GetTempPreviewResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import h6b.g;
import j6b.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "response", "Lcom/bytedance/lark/pb/url/v1/GetTempPreviewResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.preview.service.impl.UrlPreviewService$getTempPreview$1", f = "UrlPreviewService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UrlPreviewService$getTempPreview$1 extends SuspendLambda implements Function2<GetTempPreviewResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<UrlCardPreviewEntity> $callback;
    /* synthetic */ Object L$0;
    int label;

    public UrlPreviewService$getTempPreview$1(IGetDataCallback<UrlCardPreviewEntity> r1, Continuation<? super UrlPreviewService$getTempPreview$1> r2) {
        this.$callback = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        UrlPreviewService$getTempPreview$1 r0 = new UrlPreviewService$getTempPreview$1(this.$callback, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(GetTempPreviewResponse r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((GetTempPreviewResponse) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r5);
        UrlPreviewEntity r6 = ((GetTempPreviewResponse) this.L$0).preview_entity;
        if (r6 == null) goto L7;
        UrlCardPreviewEntity r7 = d.d(r6, false);
        g r0 = g.b;
        UrlInlinePreviewEntity r1 = r7.getInlineEntity();
        r0.getClass();
        Intrinsics.checkNotNullParameter("[URLPreview] GetTempPreviewRequest", "tag");
        r0.a.getClass();
        k6b.a.b(r1, "[URLPreview] GetTempPreviewRequest", "edit box url inline preview");
        this.$callback.onSuccess(r7);
    L9:
        return Unit.INSTANCE;
    L7:
        this.$callback.onSuccess(null);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
