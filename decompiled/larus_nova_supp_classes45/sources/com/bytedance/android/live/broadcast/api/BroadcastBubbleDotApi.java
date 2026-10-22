package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.broadcast.BubbleDotListData;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/BroadcastBubbleDotApi;", "", "", "showPath", "reqCustom", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/BubbleDotListData;", "getBubbleDotList", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface BroadcastBubbleDotApi {
    @GET("/webcast/room/bubble_dot/list/")
    Observable<Response<BubbleDotListData>> getBubbleDotList(@Query("show_paths") String r1, @Query("req_custom") String r2);
}
