package com.bytedance.android.live.openplatform.impl.miniappanchor.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.g;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.h;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.i;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.j;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JF\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0004H'J(\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\rH'J\u001e\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\n0\t2\b\b\u0001\u0010\u0011\u001a\u00020\rH'J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\tH'¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/MiniAppMemoryApi;", "", "", "roomId", "", "rememberMiniApp", "rememberCard", "showLiveData", "showImportantCard", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/j;", "updateMemoryAbility", "", "appId", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/h;", "getMemoryAbility", "cache_data", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/i;", "setMemoryData", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/g;", "getMemoryData", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MiniAppMemoryApi {
    @GET("/webcast/stamp/memory_ability/status/")
    Observable<e<h>> getMemoryAbility(@Query("room_id") long r1, @Query("app_id") String r3);

    @GET("/webcast/stamp/memory_ability/get_memory")
    Observable<e<g>> getMemoryData();

    @FormUrlEncoded
    @POST("/webcast/stamp/memory_ability/set_memory/")
    Observable<e<i>> setMemoryData(@Field("cache_data") String r1);

    @POST("/webcast/stamp/memory_ability/update_status/")
    Observable<e<j>> updateMemoryAbility(@Query("room_id") long r1, @Query("remember_start") int r3, @Query("remember_card") int r4, @Query("show_live_data") int r5, @Query("show_important_card") int r6);
}
