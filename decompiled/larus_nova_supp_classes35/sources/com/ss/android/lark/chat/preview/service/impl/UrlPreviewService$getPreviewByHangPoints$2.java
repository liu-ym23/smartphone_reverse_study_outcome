package com.ss.android.lark.chat.preview.service.impl;

import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.url.v1.GetPreviewByHangPointsRequest;
import com.bytedance.lark.pb.url.v1.GetPreviewByHangPointsResponse;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.base.b;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import h6b.g;
import j6b.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;", "Lkotlin/collections/HashMap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.preview.service.impl.UrlPreviewService$getPreviewByHangPoints$2", f = "UrlPreviewService.kt", i = {0}, l = {327}, m = "invokeSuspend", n = {ChameleonOpenTracker.ParamKey.RESULT}, s = {"L$0"})
public final class UrlPreviewService$getPreviewByHangPoints$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HashMap<String, UrlCardPreviewEntity>>, Object> {
    final /* synthetic */ List<PreviewHangPoint> $hangPoints;
    Object L$0;
    int label;
    final /* synthetic */ UrlPreviewService this$0;

    public UrlPreviewService$getPreviewByHangPoints$2(List<PreviewHangPoint> r1, UrlPreviewService r2, Continuation<? super UrlPreviewService$getPreviewByHangPoints$2> r3) {
        this.$hangPoints = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UrlPreviewService$getPreviewByHangPoints$2(this.$hangPoints, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super HashMap<String, UrlCardPreviewEntity>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        HashMap r2 = (HashMap) this.L$0;
        ResultKt.throwOnFailure(r6);
    L15:
        b r7 = (b) r6;
        r7.getClass();
        if ((r7 instanceof b.b) == false) goto L18;
        return r2;
    L18:
        GetPreviewByHangPointsResponse r8 = (GetPreviewByHangPointsResponse) r7.b();
        if (r8 == null) goto L26;
        Map r9 = r8.preview_entity_map;
        if (r9 == null) goto L26;
        Iterator r10 = r9.entrySet().iterator();
    L24:
        if (r10.hasNext() == false) goto L26;
        Map.Entry r3 = (Map.Entry) r10.next();
        UrlCardPreviewEntity r4 = d.d((UrlPreviewEntity) r3.getValue(), false);
        r2.put(r3.getKey(), r4);
        g.b.b(r4, "[URLPreview] GetPreviewsByHangPointsRequestend");
    L26:
        return r2;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        HashMap r11 = new HashMap();
        if (this.$hangPoints.isEmpty() == false) goto L11;
        return r11;
    L11:
        Log.i("[URLPreview] GetPreviewsByHangPointsRequest", "start");
        GetPreviewByHangPointsRequest.Builder r5 = new GetPreviewByHangPointsRequest.Builder().preview_hang_points(this.$hangPoints);
        RucketJob<GetPreviewByHangPointsResponse> r12 = ((a) b38.b.a.create(a.class)).getPreviewByHangPoints(r5.build());
        this.L$0 = r11;
        this.label = 1;
        Object r13 = r12.awaitGet(this);
        if (r13 != r0) goto L14;
        return r0;
    L14:
        r2 = r11;
        r6 = r13;
        goto L15
    }
}
