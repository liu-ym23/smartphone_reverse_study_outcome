package com.bytedance.android.live.openplatform.impl.base.api;

import com.bytedance.android.live.base.model.user.CoverImageModel;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.base.api.response.a;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u0004H'J\u001e\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\b\b\u0001\u0010\u000b\u001a\u00020\nH'¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/api/OpenPlatformApi;", "", "", "appId", "", "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/openplatform/impl/base/api/response/a;", "getBootConfig", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "typedOutput", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/base/model/user/CoverImageModel;", "uploadImage", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OpenPlatformApi {
    @GET("/webcast/openapi/bootconfig/")
    Observable<e<a>> getBootConfig(@Query("app_id") String r1, @Query("room_id") long r2);

    @POST("/webcast/room/upload/image/")
    Single<Response<CoverImageModel>> uploadImage(@Body TypedOutput r1);
}
