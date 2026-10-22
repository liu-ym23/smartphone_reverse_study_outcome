package com.bytedance.android.live.liveinteract.api;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.rank.model.g;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JO\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0014\b\u0001\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000fH'¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/FeedbackApi;", "", "", "roomId", "channelId", "", "scene", "", "thirdPartyScene", "playMode", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/rank/model/g;", "getFeedbackType", "(JJILjava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "", "map", "Lcom/bytedance/android/live/network/response/a;", "feedback", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface FeedbackApi {

    public static final class a {
        public static /* synthetic */ Observable a(FeedbackApi r8, long r9, long r11, int r13, String r14) {
            return r8.getFeedbackType(r9, r11, r13, r14, null);
        }
    }

    @FormUrlEncoded
    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @POST("/webcast/linkmic_audience/feedback/")
    Observable<com.bytedance.android.live.network.response.a> feedback(@FieldMap Map<String, Object> r1);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/get_feedback_type/")
    Observable<e<g>> getFeedbackType(@Query("room_id") long r1, @Query("channel_id") long r3, @Query("scene") int r5, @Query("third_party_scene") String r6, @Query("play_mode") Integer r7);
}
