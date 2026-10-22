package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.d;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J;\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\n\u0010\u000bJ2\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u0005H'¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/api/ChooseApi;", "", "", "scene", "roomId", "", "keyword", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/d;", "searchMiniApp", "(JLjava/lang/Long;Ljava/lang/String;)Lio/reactivex/Observable;", "cacheHash", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/b;", "fetchMiniList", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ChooseApi {
    @GET("/webcast/microapp/interact_entrance/")
    Observable<e<b>> fetchMiniList(@Query("scene") long r1, @Query("room_id") long r3, @Query("cache_hash") String r5);

    @GET("/webcast/microapp/search_entrance/")
    Observable<e<d>> searchMiniApp(@Query("scene") long r1, @Query("room_id") Long r3, @Query("key_word") String r4);
}
