package com.bytedance.android.live.openplatform.impl.miniappanchor.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.request.b;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.k;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.o;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J@\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\u000b\u001a\u00020\n2\b\b\u0003\u0010\f\u001a\u00020\n2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\bH'J2\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u00042\b\b\u0003\u0010\u000b\u001a\u00020\n2\b\b\u0003\u0010\u000f\u001a\u00020\n2\b\b\u0003\u0010\u0010\u001a\u00020\nH'¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/ShelfApi;", "", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/request/b;", "body", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/k;", "modifyShelf", "", "appId", "", "roomId", "startId", "openExtra", "removeShelf", "cardId", "status", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/o;", "updateShelfCardStatus", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ShelfApi {
    @Headers({"Content-Type: application/json"})
    @POST("/webcast/microapp/shelf/modify/")
    Observable<e<k>> modifyShelf(@Body b r1);

    @FormUrlEncoded
    @POST("/webcast/microapp/shelf/remove/")
    Observable<e<Object>> removeShelf(@Field("app_id") String r1, @Field("room_id") long r2, @Field("start_id") long r4, @Field("open_extra") String r6);

    @FormUrlEncoded
    @POST("/webcast/microapp/shelf_card/status/update/")
    Observable<e<o>> updateShelfCardStatus(@Field("room_id") long r1, @Field("card_id") long r3, @Field("status") long r5);
}
