package com.bytedance.android.live.recharge.platform.business.api;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.recharge.exchange.model.HSExchangeInfoData;
import com.bytedance.android.live.recharge.exchange.model.a;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/api/ExchangeApi;", "", "", "url", "activityId", "category", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/live/recharge/exchange/model/HSExchangeInfoData;", "Lcom/bytedance/android/live/recharge/exchange/model/a;", "getHSExchangeInfo", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ExchangeApi {
    @GET
    Observable<BaseResponse<HSExchangeInfoData, a>> getHSExchangeInfo(@Url String r1, @Query("activity_id") String r2, @Query("category") String r3);
}
