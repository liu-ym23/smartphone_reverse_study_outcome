package com.bytedance.android.live.profit.taskcenter.preload;

import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\bH'¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/taskcenter/preload/ITaskCenterApi;", "", "getTaskCenterData", "Lio/reactivex/Observable;", "Lcom/google/gson/JsonObject;", "roomId", "", "anchorId", "", "reqFrom", "", "bizExtra", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ITaskCenterApi {
    @GET("/webcast/growth/task_center/")
    Observable<JsonObject> getTaskCenterData(@Query("room_id") long r1, @Query("anchor_id") String r3, @Query("req_from") int r4, @Query("biz_extra") String r5);
}
