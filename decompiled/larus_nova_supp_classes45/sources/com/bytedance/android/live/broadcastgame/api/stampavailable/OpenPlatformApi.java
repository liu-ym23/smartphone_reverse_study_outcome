package com.bytedance.android.live.broadcastgame.api.stampavailable;

import com.bytedance.android.live.broadcastgame.api.model.OpenFeatureScene;
import com.bytedance.android.live.broadcastgame.api.model.l0;
import com.bytedance.android.live.broadcastgame.api.model.m0;
import com.bytedance.android.live.broadcastgame.api.model.p;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.broadcastgame.api.model.response.b;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u0002H'JO\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00030\u00022\b\b\u0001\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u000f\u001a\u00020\u000bH'¢\u0006\u0004\b\u0011\u0010\u0012JY\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00030\u00022\b\b\u0001\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0013\u001a\u00020\bH'¢\u0006\u0004\b\u0014\u0010\u0015JP\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00030\u00022\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\u0016\u001a\u00020\r2\b\b\u0001\u0010\u000f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0017\u001a\u00020\u000bH'Jd\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00030\u00022\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\u0016\u001a\u00020\r2\b\b\u0001\u0010\u000f\u001a\u00020\u000b2\b\b\u0001\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0013\u001a\u00020\bH'J(\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00030\u00022\b\b\u0001\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\u000bH'¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/stampavailable/OpenPlatformApi;", "", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/api/model/response/MiniAppEntrancePermissionResponse;", "requestEntrancePermission", "Lcom/bytedance/android/live/broadcastgame/api/model/response/b;", "requestIntroPanelFinished", "", "scene", "roomId", "", "keyWord", "", "liveScene", "effectSdkVersion", "Lcom/bytedance/android/live/broadcastgame/api/model/m0;", "searchEntrance", "(JLjava/lang/Long;Ljava/lang/String;ILjava/lang/String;)Lio/reactivex/Observable;", "version", "searchEntranceV3", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;IJ)Lio/reactivex/Observable;", "visibilityRange", "cacheHash", "Lcom/bytedance/android/live/broadcastgame/api/model/p;", "fetchFeatureList", "clickSource", "fetchFeatureListV3", "Lcom/bytedance/android/live/broadcastgame/api/model/l0;", "fetchFeatureAllItemList", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OpenPlatformApi {
    @GET("/webcast/room/interact_panel/")
    Observable<e<l0>> fetchFeatureAllItemList(@Query("room_id") long r1, @Query("effect_sdk_version") String r3);

    @GET("/webcast/stamp/interact_entrance/")
    Observable<e<p>> fetchFeatureList(@OpenFeatureScene @Query("scene") long r1, @Query("room_id") long r3, @Query("visibility_range") int r5, @Query("effect_sdk_version") String r6, @Query("live_scene") int r7, @Query("cache_hash") String r8);

    @GET("/webcast/stamp/interact_entrance/")
    Observable<e<p>> fetchFeatureListV3(@OpenFeatureScene @Query("scene") long r1, @Query("room_id") long r3, @Query("visibility_range") int r5, @Query("effect_sdk_version") String r6, @Query("cache_hash") String r7, @Query("click_source") String r8, @Query("live_scene") int r9, @Query("version") long r11);

    @GET("/webcast/stamp/micro_app_entrance_permission")
    Observable<e<MiniAppEntrancePermissionResponse>> requestEntrancePermission();

    @POST("/webcast/stamp/intro_panel_finished")
    Observable<e<b>> requestIntroPanelFinished();

    @GET("/webcast/stamp/search_entrance/")
    Observable<e<m0>> searchEntrance(@OpenFeatureScene @Query("scene") long r1, @Query("room_id") Long r3, @Query("key_word") String r4, @Query("live_scene") int r5, @Query("effect_sdk_version") String r6);

    @GET("/webcast/stamp/search_entrance/")
    Observable<e<m0>> searchEntranceV3(@OpenFeatureScene @Query("scene") long r1, @Query("room_id") Long r3, @Query("key_word") String r4, @Query("effect_sdk_version") String r5, @Query("live_scene") int r6, @Query("version") long r7);
}
