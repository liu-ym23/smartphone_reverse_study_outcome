package com.bytedance.android.live.ktv.common.api;

import com.bytedance.android.live.network.response.a;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.ktvapi.model.mv.b;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JP\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\u000b\u001a\u00020\nH'J6\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\nH'JT\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\n2\b\b\u0001\u0010\u0015\u001a\u00020\n2\b\b\u0003\u0010\u0016\u001a\u00020\u00062\b\b\u0003\u0010\u0017\u001a\u00020\bH'J.\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\r0\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u000e\b\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0019H'¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/ktv/common/api/KtvMvApi;", "", "", "room_id", "min_cursor", "max_cursor", "", "count", "", "teenager_mode", "", "scene", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/a;", "getMVList", "song_id", "singer_id", "singer_open_id", "Lcom/bytedance/android/live/network/response/a;", "startPlayMv", "videoId", "mvType", "needPlay", "chooseMv", "", "mv_id_list", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/b;", "changeMv", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface KtvMvApi {
    @GET("/webcast/ktv_profit/change_mv/")
    Observable<e<b>> changeMv(@Query("room_id") long r1, @Query("mv_id_list") List<String> r3);

    @GET("/webcast/ktv_profit/choose_mv/")
    Observable<a> chooseMv(@Query("room_id") long r1, @Query("song_id") long r3, @Query("singer_id") long r5, @Query("singer_open_id") String r7, @Query("mv_id") String r8, @Query("ktv_mv_type") int r9, @Query("need_play") boolean r11);

    @GET("/webcast/ktv_profit/get_mv_list/")
    Observable<e<com.bytedance.android.livesdk.ktvapi.model.mv.a>> getMVList(@Query("room_id") long r1, @Query("min_cursor") long r3, @Query("max_cursor") long r5, @Query("count") int r7, @Query("teenager_mode") boolean r8, @Query("scene") String r9);

    @GET("/webcast/ktv_profit/play_mv/")
    Observable<a> startPlayMv(@Query("room_id") long r1, @Query("song_id") long r3, @Query("singer_id") long r5, @Query("singer_open_id") String r7);
}
