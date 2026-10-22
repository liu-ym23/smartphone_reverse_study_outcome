package com.bytedance.android.livesdk.interactivity.medialink.network;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Single;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface LinkCrossRoomApiCompat {
    @GET("/webcast/linkmic/update_settings/")
    Single<Response<Void>> updateAnchorLinkSetting(@Query("room_id") long r1, @Query("sec_user_id") String r3, @Query("effective_field") int r4, @QueryMap Map<String, Object> r5);
}
