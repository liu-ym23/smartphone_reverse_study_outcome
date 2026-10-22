package com.bytedance.android.livesdk.interactivity.medialink.network;

import com.bytedance.android.live.anchorlink.network.model.c;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.interact.model.e;
import com.bytedance.android.livesdk.chatroom.interact.model.m0;
import com.bytedance.android.livesdk.message.linker.a;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H'J6\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0004H'Jh\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00140\t2\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u00042\b\b\u0001\u0010\u0010\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u00112\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J*\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00140\t2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0007H'J2\u0010 \u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001d0\u001c2\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u0011H'¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/network/LinkCrossRoomApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "updateLayoutType", BuildConfig.FLAVOR, "roomId", "channelId", BuildConfig.FLAVOR, "toUserId", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/a;", "updateAnchorLayout", "scene", "mute", "linkStatus", "offset", "count", BuildConfig.FLAVOR, "useLocalCache", "reqSrc", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/message/linker/a;", "getLinkAnchorList", "secUserId", "Lcom/bytedance/android/livesdk/chatroom/interact/model/e;", "getAnchorLinkSetting", "rivalsType", "useLastRecommendResult", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/livesdk/chatroom/interact/model/m0;", "Lcom/bytedance/android/live/anchorlink/network/model/c;", "rivalsList", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LinkCrossRoomApi {
    @PbRequest("multi_link")
    @GET("/webcast/linkmic/get_settings/")
    Single<Response<e>> getAnchorLinkSetting(@Query("room_id") long r1, @Query("sec_user_id") String r3);

    @PbRequest("pk_or_multi")
    @GET("/webcast/linkmic/list/")
    Single<Response<a>> getLinkAnchorList(@Query("channel_id") long r1, @Query("link_status") long r3, @Query("offset") long r5, @Query("count") long r7, @Query("scene") int r9, @Query("use_local_cache") boolean r10, @Query("request_source") String r11, @Query("room_id") long r13);

    @GET("/webcast/linkmic/silence/")
    Single<com.bytedance.android.live.network.response.a> mute(@Query("room_id") long r1, @Query("scene") int r3, @Query("to_user_id") String r4, @Query("channel_id") long r5);

    @PbRequest("multi_link")
    @GET("/webcast/linkmic/rivals/")
    Observable<BaseResponse<m0, c>> rivalsList(@Query("rivals_type") int r1, @Query("use_last_recommend_result") boolean r2);

    @PbRequest("multi_link")
    @GET("/webcast/linkmic/update_anchor_layout/")
    Single<com.bytedance.android.live.network.response.a> updateAnchorLayout(@Query("update_anchor_layout_type") int r1, @Query("room_id") long r2, @Query("channel_id") long r4, @Query("to_user_id") String r6);
}
