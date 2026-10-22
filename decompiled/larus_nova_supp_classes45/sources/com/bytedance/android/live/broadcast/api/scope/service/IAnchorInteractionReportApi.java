package com.bytedance.android.live.broadcast.api.scope.service;

import com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0002H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/scope/service/IAnchorInteractionReportApi;", "", "", "roomId", "", "runApp", "timestamp", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "reportRunAppNew", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAnchorInteractionReportApi {
    @FormUrlEncoded
    @POST("/webcast/interact/report_interaction_data")
    Observable<com.bytedance.android.live.network.response.e<BaseResponse>> reportRunAppNew(@Field("room_id") long r1, @Field("interaction_data") String r3, @Field("report_timestamp") long r4);
}
