package com.larus.community.impl.detail.comment;

import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.network.http.HttpExtKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/comment/api/CommentHttpApi$ReportReasonsData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.comment.CreationDetailCommentRemoteHttpApi$getCommentReportReasons$2", f = "CreationDetailDataMediator.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
final class CreationDetailCommentRemoteHttpApi$getCommentReportReasons$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends rq9.b>>, Object> {
    int label;

    public CreationDetailCommentRemoteHttpApi$getCommentReportReasons$2(Continuation<? super CreationDetailCommentRemoteHttpApi$getCommentReportReasons$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new CreationDetailCommentRemoteHttpApi$getCommentReportReasons$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<rq9.b>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L15:
        return (com.larus.network.http.a) r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        Pair[] r4 = new Pair[3];
        r4[0] = TuplesKt.to("report_type", "19");
        r4[1] = TuplesKt.to("comment_biz_type", "2");
        String r5 = CreationDetailCommentRemoteHttpApi.b;
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r4[2] = TuplesKt.to("commented_entity_id", r5);
        HashMap r6 = MapsKt.hashMapOf(r4);
        this.label = 1;
        r8 = HttpExtKt.h("Social", rq9.b.class, "/alice/safety/report/reasons", r6, this, BaiduNaviStatus.NO_PERMISSION);
        if (r8 != r0) goto L15;
        return r0;
    }
}
