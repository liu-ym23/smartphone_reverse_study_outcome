package com.ss.android.lark.chat.preview.service.impl;

import android.util.ArrayMap;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.url.v1.GetInlinePreviewResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import j6b.d;
import java.util.Iterator;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "response", "Lcom/bytedance/lark/pb/url/v1/GetInlinePreviewResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.preview.service.impl.UrlPreviewService$getInlinePreview$1", f = "UrlPreviewService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UrlPreviewService$getInlinePreview$1 extends SuspendLambda implements Function2<GetInlinePreviewResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<ArrayMap<String, UrlInlinePreviewEntity>> $callback;
    /* synthetic */ Object L$0;
    int label;

    public UrlPreviewService$getInlinePreview$1(IGetDataCallback<ArrayMap<String, UrlInlinePreviewEntity>> r1, Continuation<? super UrlPreviewService$getInlinePreview$1> r2) {
        this.$callback = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        UrlPreviewService$getInlinePreview$1 r0 = new UrlPreviewService$getInlinePreview$1(this.$callback, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(GetInlinePreviewResponse r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((GetInlinePreviewResponse) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        GetInlinePreviewResponse r5 = (GetInlinePreviewResponse) this.L$0;
        if ((!r5.preview_entity_map.isEmpty()) == false) goto L12;
        ArrayMap r0 = new ArrayMap();
        Iterator r6 = r5.preview_entity_map.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r6.next();
        r0.put(r1.getKey(), d.c((UrlPreviewEntity) r1.getValue()));
        goto L8
    L10:
        this.$callback.onSuccess(r0);
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
