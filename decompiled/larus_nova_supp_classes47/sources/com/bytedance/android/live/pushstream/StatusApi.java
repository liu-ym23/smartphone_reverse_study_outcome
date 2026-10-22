package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Observable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface StatusApi {
    @GET("/webcast/room/ping/anchor/")
    Observable<Response<Void>> sendStatus(@Query("room_id") long r1, @Query("status") int r3, @Query("stream_id") long r4, @Query("reason_no") int r6, @Query("source") String r7, @Query("prop_id") Long r8);

    @GET("/webcast/room/ping/anchor/")
    Observable<BaseResponse<Void, uv0.b>> sendStatusWithExtra(@Query("room_id") long r1, @Query("status") int r3, @Query("stream_id") long r4, @Query("reason_no") int r6, @Query("source") String r7, @Query("prop_id") Long r8, @QueryMap Map<String, Object> r9);
}
