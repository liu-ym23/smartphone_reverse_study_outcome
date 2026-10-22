package com.bytedance.android.live.effect.beauty.feedback;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H'¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/feedback/FeedbackApi;", "", "", "feedbackId", "roomId", "", "userID", "scene", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/base/model/feedback/a$a;", "getLiveRoomFeedbackCard", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface FeedbackApi {
    @GET("/webcast/distribution/get_feedback_card/")
    Observable<e<com.bytedance.android.live.base.model.feedback.a.C0010a>> getLiveRoomFeedbackCard(@Query("feedback_id") long r1, @Query("room_id") long r3, @Query("user_id") String r5, @Query("scene") String r6);
}
