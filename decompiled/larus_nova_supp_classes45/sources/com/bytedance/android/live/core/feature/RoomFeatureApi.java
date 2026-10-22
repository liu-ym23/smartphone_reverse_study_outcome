package com.bytedance.android.live.core.feature;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/core/feature/RoomFeatureApi;", "", "getRoomFeature", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/core/feature/DynamicDataResp;", "requestTag", "", "userInfos", "Lcom/bytedance/android/live/core/feature/FeatureRequestBody;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface RoomFeatureApi {
    @POST("/webcast/experience/feature/")
    Observable<Response<DynamicDataResp>> getRoomFeature(@Header("x-tt-request-tag") String r1, @Body FeatureRequestBody r2);
}
