package com.bytedance.android.livesdk.feed.preview.roomdetector;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.ping.PingResult;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface RoomRetrofitApi {
    @GET("/webcast/openapi/room/ping/audience/")
    Observable<Response<PingResult>> sendPlayingPing(@Query("room_id") long r1, @Query("only_status") int r3);
}
