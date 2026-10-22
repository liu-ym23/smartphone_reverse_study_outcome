package com.bytedance.android.live.room.discovery.drawer;

import com.bytedance.android.livesdk.message.model.hg;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J<\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H'JF\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\b\b\u0003\u0010\r\u001a\u00020\u0006H'J\\\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\b\b\u0003\u0010\r\u001a\u00020\u00062\u0014\b\u0001\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0011H'¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/room/discovery/drawer/DrawerEntranceApi;", "", "", "type", "", "roomId", "", "authorId", "extra", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/message/model/hg;", "getEntranceData", "enterFrom", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/android/live/base/model/moreliveentrance/a;", "getMoreEntranceData", "", "extraQueryMap", "getMoreEntranceDataNew", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface DrawerEntranceApi {
    @GET("/webcast/distribution/more_live_entrance/")
    Observable<com.bytedance.android.live.network.response.e<hg>> getEntranceData(@Query("type") int r1, @Query("room_id") long r2, @Query("author_id") String r4, @Query("extra") String r5);

    @GET("/webcast/distribution/more_live_entrance/")
    Call<com.bytedance.android.live.network.response.e<com.bytedance.android.live.base.model.moreliveentrance.a>> getMoreEntranceData(@Query("type") int r1, @Query("room_id") long r2, @Query("author_id") String r4, @Query("extra") String r5, @Query("enter_from") String r6);

    @GET("/webcast/distribution/more_live_guide/")
    Call<com.bytedance.android.live.network.response.e<com.bytedance.android.live.base.model.moreliveentrance.a>> getMoreEntranceDataNew(@Query("type") int r1, @Query("room_id") long r2, @Query("author_id") String r4, @Query("extra") String r5, @Query("enter_from") String r6, @QueryMap Map<String, Object> r7);
}
