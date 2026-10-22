package com.bytedance.android.livesdk.dynamicstrategy.impl.source;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.x;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.y;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.z;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H'JL\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0003\u0010\u000f\u001a\u00020\u000eH'¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/source/DynamicStrategyApi;", "", "", "requestScene", "", "strategyVersionKey", "requestTag", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/z;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/x;", "fetchStrategy", "verificationKey", "featureKeys", "", "responseRawData", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/y;", "getFeature", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface DynamicStrategyApi {
    @GET("/webcast/strategy/rule")
    Observable<BaseResponse<z, x>> fetchStrategy(@Query("request_scene") int r1, @Query("verification_key") String r2, @Header("x-tt-request-tag") String r3);

    @PbRequest("dynamic_strategy")
    @GET("/webcast/strategy/feature/")
    Observable<BaseResponse<y, x>> getFeature(@Query("request_scene") int r1, @Query("verification_key") String r2, @Query("feature_keys") String r3, @Header("x-tt-request-tag") String r4, @Query("raw_data") boolean r5);
}
