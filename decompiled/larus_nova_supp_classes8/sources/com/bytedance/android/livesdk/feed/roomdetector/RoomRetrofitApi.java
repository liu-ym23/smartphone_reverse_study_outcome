package com.bytedance.android.livesdk.feed.roomdetector;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.ping.PingResult;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Observable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface RoomRetrofitApi {
    @GET("/webcast/room/info/")
    Observable<Response<Room>> fetchRoom(@QueryMap HashMap<String, String> r1);

    @GET("/webcast/room/ping/audience/")
    Observable<Response<PingResult>> sendPlayingPing(@Query("room_id") long r1, @Query("only_status") int r3);
}
