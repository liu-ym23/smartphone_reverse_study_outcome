package com.larus.community.impl.api;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.Gson;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/larus/community/impl/api/CreationRecommendApi;", "", "getCreationDetail", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/community/impl/api/CreationDetailResponse;", "request", "Lcom/larus/community/impl/api/CreationDetailRequest;", "(Lcom/larus/community/impl/api/CreationDetailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleCreationLikeAction", "Lcom/larus/community/impl/api/CreationLikeActionRequest;", "(Lcom/larus/community/impl/api/CreationLikeActionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "publishCreation", "Lcom/larus/community/impl/api/CreationPublishResponse;", "Lcom/larus/community/impl/api/CreationPublishRequest;", "(Lcom/larus/community/impl/api/CreationPublishRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireProfileOverview", "Lcom/larus/community/impl/api/CommunityProfileOverviewResponse;", "Lcom/larus/community/impl/api/ProfileOverviewRequest;", "(Lcom/larus/community/impl/api/ProfileOverviewRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CreationRecommendApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static Object c(Function2 r10, Continuation r11) {
            FlowHttpConnection r0 = FlowHttpConnection.a;
            return FlowHttpConnection.g("Social", CreationRecommendApi.class, r10, true, null, null, null, r11, BaiduNaviStatus.NO_PERMISSION);
        }

        public static Object a(n r11, String r12, Continuation r13) {
            FlowDowngradeServiceDelegate r0 = FlowDowngradeServiceDelegate.INSTANCE;
            Gson r4 = new Gson();
            Intrinsics.checkNotNullParameter(r11, "<this>");
            Intrinsics.checkNotNullParameter(r4, "gson");
            JSONObject r5 = new JSONObject(GsonProtectorUtils.toJson(r4, r11));
            if (r12 == null) goto L5;
            Map r14 = MapsKt.mapOf(TuplesKt.to("source", r12));
        L7:
            return IFlowDowngradeService.a.b(r0, "Social", o.class, "/creativity/community/creation/tab_list", r5, null, true, null, r14, r13, 944);
        L5:
            r14 = null;
            goto L7
        }

        public static Object b(q r11, String r12, Continuation r13) {
            FlowDowngradeServiceDelegate r0 = FlowDowngradeServiceDelegate.INSTANCE;
            Gson r4 = new Gson();
            Intrinsics.checkNotNullParameter(r11, "<this>");
            Intrinsics.checkNotNullParameter(r4, "gson");
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
            Object r14 = Result.constructor-impl(new JSONObject(r4.toJson(r11)));     // Catch: Throwable -> L5
        L8:
            if (Result.isFailure-impl(r14) == false) goto L10;
            r14 = null;
        L10:
            JSONObject r15 = (JSONObject) r14;
            if (r15 != null) goto L14;
            r15 = new JSONObject();
        L14:
            return IFlowDowngradeService.a.b(r0, "Social", c.class, "/alice/profile/overview", r15, null, true, null, MapsKt.mapOf(TuplesKt.to("source", r12)), r13, 944);
        L5:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L8
        }
    }

    static {
        a = a.a;
    }

    @POST("/creativity/community/creation/mget")
    Object getCreationDetail(@Body d r1, Continuation<? super BizResponse<e>> r2);

    @POST("/creativity/community/creation/like_action")
    Object handleCreationLikeAction(@Body f r1, Continuation<? super BizResponse<Object>> r2);

    @POST("/creativity/community/creation/publish")
    Object publishCreation(@Body g r1, Continuation<? super BizResponse<i>> r2);

    @POST("/alice/profile/overview")
    Object requireProfileOverview(@Body q r1, Continuation<? super BizResponse<c>> r2);
}
