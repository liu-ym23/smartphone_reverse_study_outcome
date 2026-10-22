package com.bytedance.android.live.liveinteract.plantform.api;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.b;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.interact.f2;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.t1;
import com.bytedance.android.livesdk.chatroom.model.interact.v;
import com.bytedance.android.livesdk.chatroom.model.interact.x1;
import com.bytedance.android.livesdk.chatroom.model.interact.y2;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Single;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface LinkProfitApi {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkmicTeamFightType {
    }

    @GET("/webcast/linkmic_profit/create_teamfight/")
    Single<e<x1>> createTeamFight(@Query("room_id") long r1, @Query("duration") long r3, @Query("option") int r5, @Query("need_switch_scene") boolean r6, @Query("select_user_ids") String r7);

    @GET("/webcast/linkmic_profit/get_teamfight_conf/")
    Single<e<y2>> fetchTeamFightConfig();

    @GET("/webcast/linkmic_profit/get_teamfight_conf/")
    Single<e<y2>> fetchTeamFightConfig(@Query("type") int r1);

    @GET("/webcast/linkmic_profit/finish_teamfight/")
    Single<e<v>> finishTeamFight(@Query("room_id") long r1, @Query("reason") int r3, @Query("teamfight_id") long r4, @Query("need_switch_scene") boolean r6);

    @GET("/webcast/linkmic_profit/get_play_mode_announce/")
    Single<e<b>> getPlayModeAnnounce(@Query("play_mode") long r1, @Query("room_id") long r3);

    @GET("/webcast/linkmic_audience/get_play_mode_info/")
    Single<e<k1>> getPlayModeInfo(@Query("room_id") long r1, @Query("use_play_mode_info") boolean r3);

    @GET("/webcast/linkmic_profit/read_play_mode_announce/")
    Single<e<Object>> readPlayModeAnnounce(@Query("room_id") long r1, @Query("announce_ids") String r3);

    @GET("/webcast/linkmic_profit/start_teamfight/")
    Single<e<t1>> startTeamFight(@Query("room_id") long r1, @Query("duration") int r3);

    @GET("/webcast/linkmic_profit/update_team_battle_team/")
    Single<e<f2>> updateTeamFightPlayerTeam(@Query("room_id") long r1, @Query("teamfight_id") long r3, @Query("update_type") int r5, @Query("guest_id") long r6, @Query("guest_open_id") String r8, @Query("position") long r9, @Query("target_team") int r11);
}
