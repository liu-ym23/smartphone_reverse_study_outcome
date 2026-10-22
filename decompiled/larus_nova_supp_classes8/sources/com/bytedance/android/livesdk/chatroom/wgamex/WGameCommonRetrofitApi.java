package com.bytedance.android.livesdk.chatroom.wgamex;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import zr1.a;
import zr1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface WGameCommonRetrofitApi {
    @FormUrlEncoded
    @PbRequest("live_game")
    @POST("/webcast/game/permission/authorize/")
    Observable<Response> authorize(@Field("auth_kind") int r1, @Field("game_id") long r2);

    @FormUrlEncoded
    @PbRequest("live_game")
    @POST("/webcast/game/permission/check/")
    Observable<Response<a>> checkPermission(@Field("game_id") long r1, @Field("auth_kind") int r3);

    @FormUrlEncoded
    @PbRequest("live_game")
    @POST("/webcast/game/resource/config/")
    Observable<e<b>> fetchConfigExtra(@Field("room_id") long r1, @Field("game_id") long r3, @Field("play_kind") long r5);
}
