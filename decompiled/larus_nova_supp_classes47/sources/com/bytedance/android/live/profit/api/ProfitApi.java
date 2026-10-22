package com.bytedance.android.live.profit.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.profit.vip.model.b;
import com.bytedance.android.live.profit.vip.model.f;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\bH'¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profit/api/ProfitApi;", "", "", "scale", "", "authorId", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "typedOutput", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/profit/vip/model/b;", "uploadSubscribeCustomEmoji", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/profit/vip/model/f;", "getVipEmojiTemplateData", "liveprofit-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ProfitApi {
    @POST("/webcast/privilege/subscribe/emoji/template/get/")
    Observable<Response<f>> getVipEmojiTemplateData();

    @POST("/webcast/privilege/subscribe/emoji/add/")
    Observable<e<b>> uploadSubscribeCustomEmoji(@Query("emoji_scale") int r1, @Query("author_id") String r2, @Body TypedOutput r3);
}
