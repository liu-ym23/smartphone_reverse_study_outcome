package com.bytedance.android.live.room.api.messagewindow.api;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import f71.c;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J:\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H'¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/api/CommonCardInfoRetrofitApi;", "", "", "roomId", "", "enterSource", "params", "", "actionSource", "Lio/reactivex/Observable;", "Lf71/c;", "queryCommonCardInfo", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface CommonCardInfoRetrofitApi {
    @GET("/webcast/room/common_card/")
    Observable<c> queryCommonCardInfo(@Query("room_id") long r1, @Query("enter_source") String r3, @Query("enter_schema_params") String r4, @Query("action_source") int r5);
}
