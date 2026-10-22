package com.bytedance.android.livesdk.interactivity.common;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/StateReportApi;", BuildConfig.FLAVOR, "roomEventReport", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "itemType", BuildConfig.FLAVOR, "itemId", BuildConfig.FLAVOR, "eventSceneType", "roomId", "liveId", "anchorId", BuildConfig.FLAVOR, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface StateReportApi {
    @FormUrlEncoded
    @POST("/webcast/room/event_report/")
    Observable<Response<Object>> roomEventReport(@Field("item_type") int r1, @Field("item_id") long r2, @Field("event_scene_type") int r4, @Field("room_id") long r5, @Field("live_id") long r7, @Field("anchor_id") String r9);
}
