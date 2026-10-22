package com.bytedance.android.live.core.feed;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/feed/RealtimeFeatureApi;", "", "submitFeatureRequest", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "featureSequence", "", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface RealtimeFeatureApi {
    @FormUrlEncoded
    @POST("/webcast/distribution/submit_feature/")
    Observable<Response<Object>> submitFeatureRequest(@Field("real_time_feature_sequence") String r1);
}
