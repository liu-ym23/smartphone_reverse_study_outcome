package com.bytedance.android.live.cloudgrouplive.api;

import com.bytedance.android.live.cloudgrouplive.model.a;
import com.bytedance.android.live.cloudgrouplive.model.d;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J<\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0002H'J@\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u000bH'J\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0002H'J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0002H'J\u001e\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\b0\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'J\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0002H'¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/api/CloudGroupLiveApi;", "", "", "inviterUserId", "collaborateRoomId", "inviteId", "userRoomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/cloudgrouplive/model/a;", "acceptCloudGroupLive", "", "reason", "Lcom/bytedance/android/live/network/response/a;", "rejectCloudGroupLive", "joinCloudGroupLive", "toUserId", "toUserRoomId", "leaveCloudGroupLive", "Lcom/bytedance/android/live/cloudgrouplive/model/d;", "getCloudGroupLiveInfo", "cloudGroupLivePing", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface CloudGroupLiveApi {
    @POST("/webcast/anchor/group_live/accept_cloud_collaborate/")
    Observable<e<a>> acceptCloudGroupLive(@Query("inviter_user_id") long r1, @Query("collaborate_room_id") long r3, @Query("invite_id") long r5, @Query("user_room_id") long r7);

    @POST("/webcast/anchor/group_live/cloud_collaborate_ping/")
    Observable<com.bytedance.android.live.network.response.a> cloudGroupLivePing(@Query("colalborate_room_id") long r1, @Query("user_room_id") long r3);

    @POST("/webcast/anchor/group_live/get_cloud_collaborate_info/")
    Observable<e<d>> getCloudGroupLiveInfo(@Query("collaborate_room_id") long r1);

    @POST("/webcast/anchor/group_live/join_cloud_collaborate/")
    Observable<com.bytedance.android.live.network.response.a> joinCloudGroupLive(@Query("collaborate_room_id") long r1, @Query("user_room_id") long r3);

    @POST("/webcast/anchor/group_live/leave_cloud_collaborate")
    Observable<com.bytedance.android.live.network.response.a> leaveCloudGroupLive(@Query("collaborate_room_id") long r1, @Query("to_user_id") long r3, @Query("to_user_room_id") long r5);

    @POST("/webcast/anchor/group_live/reject_cloud_collaborate/")
    Observable<com.bytedance.android.live.network.response.a> rejectCloudGroupLive(@Query("inviter_user_id") long r1, @Query("collaborate_room_id") long r3, @Query("invite_id") long r5, @Query("user_room_id") long r7, @Query("reason") String r9);
}
