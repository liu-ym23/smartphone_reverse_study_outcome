package com.bytedance.android.live.openplatform.impl.miniappanchor.api;

import com.bytedance.android.live.network.response.a;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0002H'J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J,\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\u0002H'J\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/AnchorOpenApi;", "", "", "appId", "", "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/a;", "subscribeAudienceFollowAction", "unsubscribeAudienceFollowAction", "keyWords", "subscribeSpecifiedContentComment", "unsubscribeAllSpecifiedContentComment", "openUid", "subscribeSpecifiedUserComment", "unsubscribeAllSpecifiedUserComment", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AnchorOpenApi {
    @POST("/webcast/openapi/follow/subscribe/")
    Observable<a> subscribeAudienceFollowAction(@Query("app_id") String r1, @Query("room_id") long r2);

    @POST("/webcast/openapi/comment/subscribe/keyword/")
    Observable<a> subscribeSpecifiedContentComment(@Query("app_id") String r1, @Query("room_id") long r2, @Query("keywords") String r4);

    @POST("/webcast/openapi/comment/subscribe/spec_user/")
    Observable<a> subscribeSpecifiedUserComment(@Query("app_id") String r1, @Query("room_id") long r2, @Query("openids") String r4);

    @POST("/webcast/openapi/comment/unsubscribe/keyword/")
    Observable<a> unsubscribeAllSpecifiedContentComment(@Query("app_id") String r1, @Query("room_id") long r2);

    @POST("/webcast/openapi/comment/unsubscribe/spec_user/")
    Observable<a> unsubscribeAllSpecifiedUserComment(@Query("app_id") String r1, @Query("room_id") long r2);

    @POST("/webcast/openapi/follow/unsubscribe/")
    Observable<a> unsubscribeAudienceFollowAction(@Query("app_id") String r1, @Query("room_id") long r2);
}
