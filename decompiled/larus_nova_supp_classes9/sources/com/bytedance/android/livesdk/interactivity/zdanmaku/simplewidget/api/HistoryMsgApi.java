package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.api;

import com.bytedance.android.live.base.UplinkService;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.b;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/simplewidget/api/HistoryMsgApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "liveId", "roomId", BuildConfig.FLAVOR, "tenant", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/b;", "getHistoryMsg", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface HistoryMsgApi {
    @FormUrlEncoded
    @UplinkService(30001)
    @Headers({"response-format: protobuf"})
    @POST("/webcast/im/fetch/preview_history/")
    Observable<Response<b>> getHistoryMsg(@Field("live_id") long r1, @Field("room_id") long r3, @Field("tenant") String r5);
}
