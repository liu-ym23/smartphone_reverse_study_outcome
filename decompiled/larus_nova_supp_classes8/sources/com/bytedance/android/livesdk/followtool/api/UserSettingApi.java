package com.bytedance.android.livesdk.followtool.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J \u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00040\u00032\b\b\u0003\u0010\n\u001a\u00020\u0007H'J \u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00040\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH'J,\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\u0014\b\u0001\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0011H'¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/followtool/api/UserSettingApi;", "", "getUserRelationSyncSwitch", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/followtool/api/RelationSyncSwitch;", "userOpenId", "", "getUserSetting", "Lcom/bytedance/android/livesdk/followtool/api/UserSetting;", "fields", "getUserStockOfFollowRelations", "Lcom/bytedance/android/livesdk/followtool/api/RelationSyncHostFollow;", "roomId", "", "updateUserSetting", "setting", "", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public interface UserSettingApi {
    @GET("/webcast/openapi/user/relation/sync_switch/")
    Observable<Response<RelationSyncSwitch>> getUserRelationSyncSwitch(@Query("user_open_id") String r1);

    @GET("/webcast/openapi/user/setting/")
    Observable<Response<UserSetting>> getUserSetting(@Query("fields") String r1);

    @GET("/webcast/openapi/user/relation/sync_host_follow/query/")
    Observable<Response<RelationSyncHostFollow>> getUserStockOfFollowRelations(@Query("room_id") long r1);

    @FormUrlEncoded
    @POST("/webcast/openapi/user/setting/update/")
    Observable<Response<Object>> updateUserSetting(@FieldMap Map<String, String> r1);
}
