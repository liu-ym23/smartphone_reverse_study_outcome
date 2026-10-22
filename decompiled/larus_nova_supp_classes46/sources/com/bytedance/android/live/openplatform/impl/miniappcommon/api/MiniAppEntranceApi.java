package com.bytedance.android.live.openplatform.impl.miniappcommon.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;
import tq0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'JP\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u0004H'¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/api/MiniAppEntranceApi;", "", "", "roomId", "", "clientExtra", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Ltq0/a;", "getShelfInfo", "appId", "cardId", "", "type", "ctime", "uid", "visitShelf", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MiniAppEntranceApi {
    @GET("/webcast/microapp/shelf/info/")
    Observable<e<a>> getShelfInfo(@Query("room_id") long r1, @Query("client_extra") String r3);

    @FormUrlEncoded
    @POST("/webcast/microapp/shelf/visit")
    Observable<e<Object>> visitShelf(@Field("room_id") long r1, @Field("app_id") String r3, @Field("card_id") long r4, @Field("type") int r6, @Field("ctime") long r7, @Field("uid") String r9);
}
