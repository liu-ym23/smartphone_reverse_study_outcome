package com.bytedance.android.live.liveinteract.plantform.api;

import com.bytedance.android.live.base.UplinkService;
import com.bytedance.android.live.liveinteract.api.data.GalileoResponse;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.SyncStreamInfoReqBean;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdk.chatroom.model.interact.k2;
import com.bytedance.android.livesdk.chatroom.model.s1;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface LinkApis {
    @GET("/webcast/linkmic_audience/degrade_alert/")
    Observable<String> degradeAlertRequest(@Query("room_id") long r1, @Query("degrade_alert_content") String r3);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/galileo/")
    Observable<e<GalileoResponse>> galileoParamsRequest();

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/init/v2/")
    Single<e<j0>> initV2(@Query("room_id") long r1, @Query("linkmic_vendor") int r3, @Query("linkmic_layout") int r4, @Query("passive_start") boolean r5, @Query("scene") int r6, @Query("supported_scenes") String r7, @Query("source") int r8);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/init/v2/")
    Single<e<j0>> initV2(@Query("room_id") long r1, @Query("linkmic_vendor") int r3, @Query("linkmic_layout") int r4, @Query("passive_start") boolean r5, @Query("scene") int r6, @Query("supported_scenes") String r7, @Query("source") int r8, @Query("ui_layout") int r9, @Query("init_type") int r10);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/init/v2/")
    Single<e<j0>> initV2(@Query("room_id") long r1, @Query("linkmic_vendor") int r3, @Query("passive_start") boolean r4, @Query("scene") int r5, @Query("supported_scenes") String r6);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/init_rtc/")
    Single<e<k2>> preInitRtc(@Query("room_id") long r1);

    @UplinkService(10003)
    @POST("/webcast/im/send_sync_stream_info/")
    Observable<Response<s1>> sendSyncStreamInfoRequest(@Body SyncStreamInfoReqBean r1);
}
