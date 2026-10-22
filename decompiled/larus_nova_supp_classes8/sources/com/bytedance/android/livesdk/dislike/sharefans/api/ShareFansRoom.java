package com.bytedance.android.livesdk.dislike.sharefans.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JP\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\tH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/sharefans/api/ShareFansRoom;", "", "", "anchorId", "secAnchorId", "", "roomId", "enterFromMerge", "enterMethod", "", "actionType", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/dislike/sharefans/api/ShareRoomResponse;", "shareFansRoom", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ShareFansRoom {
    @FormUrlEncoded
    @POST("/webcast/distribution/share_room/")
    Observable<e<ShareRoomResponse>> shareFansRoom(@Field("owner_uid") String r1, @Field("sec_owner_uid") String r2, @Field("room_id") long r3, @Field("enter_from_merge") String r5, @Field("enter_method") String r6, @Field("action_type") int r7);
}
