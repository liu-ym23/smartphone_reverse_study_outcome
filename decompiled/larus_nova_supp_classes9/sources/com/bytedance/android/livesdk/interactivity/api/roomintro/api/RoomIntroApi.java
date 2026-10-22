package com.bytedance.android.livesdk.interactivity.api.roomintro.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0091\u0001\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u0012\u0010\u0013J?\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/RoomIntroApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", BuildConfig.FLAVOR, "introSwitch", BuildConfig.FLAVOR, "labels", "intro", "liveType", "gameType", "selectedLabels", "poiEnabled", "appointmentEnabled", "anchorLocationPoiId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/b;", "updateRoomIntro", "(Ljava/lang/Long;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lio/reactivex/Observable;", "getRoomIntro", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lio/reactivex/Observable;", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface RoomIntroApi {
    @GET("/webcast/anchor/room_intro/get_room_intro/")
    Observable<Response<b>> getRoomIntro(@Query("room_id") Long r1, @Query("live_type") String r2, @Query("game_type") Long r3);

    @POST("/webcast/anchor/room_intro/update_room_intro/")
    Observable<Response<b>> updateRoomIntro(@Query("room_id") Long r1, @Query("intro_switch") boolean r2, @Query("labels") String r3, @Query("introduction") String r4, @Query("live_type") String r5, @Query("game_type") Long r6, @Query("selected_labels") String r7, @Query("poi_enabled") Boolean r8, @Query("appointment_enabled") Boolean r9, @Query("anchor_location_poi_id") String r10);
}
