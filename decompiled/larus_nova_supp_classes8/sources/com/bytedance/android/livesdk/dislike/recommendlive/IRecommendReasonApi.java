package com.bytedance.android.livesdk.dislike.recommendlive;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/recommendlive/IRecommendReasonApi;", "", "", "roomId", "", "reason", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "recommendReason", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRecommendReasonApi {
    @FormUrlEncoded
    @POST("/webcast/recommend/reason/")
    Single<e<Object>> recommendReason(@Field("room_id") long r1, @Field("reason") String r3);
}
