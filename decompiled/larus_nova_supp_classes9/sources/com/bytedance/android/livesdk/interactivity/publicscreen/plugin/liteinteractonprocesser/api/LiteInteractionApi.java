package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.api;

import com.bytedance.android.live.network.response.a;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J:\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/liteinteractonprocesser/api/LiteInteractionApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", BuildConfig.FLAVOR, "anchorId", BuildConfig.FLAVOR, "map", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/a;", "queryLiteInteraction", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiteInteractionApi {
    @GET("/webcast/interaction/light_interact/")
    Observable<a> queryLiteInteraction(@Query("room_id") long r1, @Query("anchor_id") String r3, @QueryMap Map<String, String> r4);
}
