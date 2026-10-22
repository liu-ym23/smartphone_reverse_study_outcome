package com.bytedance.android.live.anchorlink.network;

import com.bytedance.android.live.anchorlink.network.model.MultiChannelData;
import com.bytedance.android.live.anchorlink.network.model.c;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.interact.model.e;
import com.bytedance.android.livesdk.chatroom.interact.model.m0;
import com.bytedance.android.livesdk.message.linker.a;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface LinkCrossRoomApi {

    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchSubType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RivalsTypeEnum {
    }

    @PbRequest("multi_link")
    @GET("/webcast/linkmic/get_settings/")
    Single<Response<e>> getAnchorLinkSetting(@Query("room_id") long r1, @Query("sec_user_id") String r3);

    @PbRequest("multi_link")
    @GET("/webcast/linkmic/get_cross_room_rtc_info/")
    Observable<Response<MultiChannelData>> getCrossRoomRtcInfo(@Query("channel_id") long r1, @Query("room_id") long r3, @Query("request_source") int r5);

    @PbRequest("pk_or_multi")
    @GET("/webcast/linkmic/list/")
    Single<Response<a>> getLinkAnchorList(@Query("channel_id") long r1, @Query("link_status") long r3, @Query("offset") long r5, @Query("count") long r7, @Query("scene") int r9, @Query("use_local_cache") boolean r11, @Query("request_source") String r12, @Query("room_id") long r13);

    @GET("/webcast/linkmic/silence/")
    Single<com.bytedance.android.live.network.response.a> mute(@Query("room_id") long r1, @Query("scene") int r3, @Query("to_user_id") long r4, @Query("channel_id") long r6);

    @GET("/webcast/linkmic/silence/")
    Single<com.bytedance.android.live.network.response.a> mute(@Query("room_id") long r1, @Query("scene") int r3, @Query("to_user_id") long r4, @Query("channel_id") long r6, @Query("to_room_id") long r8, @Query("silence_action") int r11);

    @PbRequest("multi_link")
    @GET("/webcast/linkmic/rivals/")
    Observable<BaseResponse<m0, c>> rivalsList(@Query("rivals_type") int r1, @Query("use_last_recommend_result") boolean r2);

    @GET("/webcast/linkmic/send_signal/")
    Observable<com.bytedance.android.live.network.response.a> sendSignalV3(@Query("channel_id") long r1, @Query("content") String r3, @Query("to_user_ids") long[] r4, @Query("scene") int r5);

    @PbRequest("multi_link")
    @GET("/webcast/linkmic/update_anchor_layout/")
    Single<com.bytedance.android.live.network.response.a> updateAnchorLayout(@Query("update_anchor_layout_type") int r1, @Query("room_id") long r2, @Query("channel_id") long r4, @Query("to_user_id") long r6);

    @GET("/webcast/linkmic/update_settings/")
    Single<Response<Void>> updateAnchorLinkSetting(@Query("room_id") long r1, @Query("sec_user_id") String r3, @Query("effective_field") int r4, @QueryMap Map<String, Object> r5);

    @GET("/webcast/linkmic/update_cross_room_info/")
    Single<com.bytedance.android.live.network.response.a> updateCrossRoomInfo(@Query("channel_id") long r1, @Query("room_id") long r3, @Query("to_room_id") long r5, @Query("scene") int r7, @Query("effective_fields") String r8, @Query("room_linker_silence_status") int r9, @Query("room_linker_is_background") int r11);

    @PbRequest("multi_link")
    @GET("/webcast/linkmic/update_linkmic_config/")
    Single<com.bytedance.android.live.network.response.a> updateLinkMicConfig(@Query("channel_id") long r1, @Query("room_id") long r3, @Query("effective_fields") String r5, @Query("forbid_invite_by_general") boolean r6, @Query("forbid_apply_from_other") boolean r7);
}
