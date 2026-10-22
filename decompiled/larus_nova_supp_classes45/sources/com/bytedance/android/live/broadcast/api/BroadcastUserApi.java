package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.base.model.user.CoverImageModel;
import com.bytedance.android.live.broadcast.api.model.PermissionResult;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Map;
import u00.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface BroadcastUserApi {
    @GET("/webcast/user/permission/")
    Observable<Response<PermissionResult>> getUserPermission();

    @GET("/webcast/user/permission/")
    Observable<Response<PermissionResult>> getUserPermissionWithId(@Query("sec_anchor_id") String r1, @Query("micro_app_entrance_visibility") String r2);

    @GET("/frisbee/task/get_task_list/")
    Observable<ListResponse<a>> getUserTasks(@QueryMap Map<String, String> r1);

    @POST("/webcast/room/upload/image/")
    Single<Response<CoverImageModel>> uploadAvatar(@Body TypedOutput r1);
}
