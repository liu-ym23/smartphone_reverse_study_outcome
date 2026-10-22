package com.ss.android.lark.chat.preview.service.impl;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.url.v1.GetPreviewResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import h6b.g;
import j6b.d;
import java.util.HashMap;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "pbResponse", "Lcom/bytedance/lark/pb/url/v1/GetPreviewResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.preview.service.impl.UrlPreviewService$getPreviewEntity$1", f = "UrlPreviewService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UrlPreviewService$getPreviewEntity$1 extends SuspendLambda implements Function2<GetPreviewResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<Map<String, UrlCardPreviewEntity>> $callback;
    /* synthetic */ Object L$0;
    int label;

    public UrlPreviewService$getPreviewEntity$1(IGetDataCallback<Map<String, UrlCardPreviewEntity>> r1, Continuation<? super UrlPreviewService$getPreviewEntity$1> r2) {
        this.$callback = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        UrlPreviewService$getPreviewEntity$1 r0 = new UrlPreviewService$getPreviewEntity$1(this.$callback, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(GetPreviewResponse r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((GetPreviewResponse) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r5);
        GetPreviewResponse r6 = (GetPreviewResponse) this.L$0;
        HashMap r0 = new HashMap();
        Iterator r7 = r6.preview_entity_map.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) r7.next();
        UrlCardPreviewEntity r2 = d.d((UrlPreviewEntity) r1.getValue(), false);
        r0.put(r1.getKey(), r2);
        g.b.b(r2, "[URLPreview] GetMessagePreviewsRequestend");
        goto L6
    L8:
        this.$callback.onSuccess(r0);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
