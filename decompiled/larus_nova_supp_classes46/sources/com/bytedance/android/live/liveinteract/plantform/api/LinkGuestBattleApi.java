package com.bytedance.android.live.liveinteract.plantform.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.interact.b0;
import com.bytedance.android.livesdk.chatroom.model.interact.e0;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.y;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface LinkGuestBattleApi {
    @GET("/webcast/linkmic_audience/get_guest_battle_conf/")
    Single<e<y>> fetchGuestBattleConfig(@Query("room_id") long r1);

    @GET("/webcast/linkmic_audience/finish_guest_battle/")
    Single<e<b0>> finishBattle(@Query("room_id") long r1, @Query("reason") int r3);

    @GET("/webcast/linkmic_audience/get_play_mode_info/")
    Single<e<k1>> getPlayModeInfo(@Query("room_id") long r1, @Query("use_play_mode_info") boolean r3);

    @GET("/webcast/linkmic_audience/open_guest_battle/")
    Single<e<b0>> openBattle(@Query("room_id") long r1, @Query("duration") int r3, @Query("is_anchor_involved") boolean r4, @Query("loser_num") long r5, @Query("score_type") int r7);

    @GET("/webcast/linkmic_audience/open_guest_battle/")
    Single<e<b0>> openBattle(@Query("room_id") long r1, @Query("duration") int r3, @Query("is_anchor_involved") boolean r4, @Query("loser_num") long r5, @Query("score_type") int r7, @Query("ui_type") long r8);

    @GET("/webcast/linkmic_audience/pause_guest_battle/")
    Single<e<b0>> pauseBattle(@Query("room_id") long r1);

    @GET("/webcast/linkmic_audience/resume_guest_battle/")
    Single<e<b0>> resumeBattle(@Query("room_id") long r1, @Query("remain_duration") int r3);

    @GET("/webcast/linkmic_profit/update_guest_battle_settings/")
    Single<e<e0>> updateGuestBattleSettings(@Query("room_id") long r1, @Query("config_content") String r3, @Query("update_fields") String r4);
}
