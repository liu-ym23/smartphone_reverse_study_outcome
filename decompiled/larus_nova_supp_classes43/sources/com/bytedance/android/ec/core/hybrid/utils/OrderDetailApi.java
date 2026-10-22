package com.bytedance.android.ec.core.hybrid.utils;

import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/utils/OrderDetailApi;", "", "prefetchOrderDetailData2", "Lio/reactivex/Observable;", "", "type", "", "data", "Lorg/json/JSONObject;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OrderDetailApi {
    @FormUrlEncoded
    @POST("order/buyRender")
    Observable<String> prefetchOrderDetailData2(@Query("b_type_new") int r1, @Field("json_form") JSONObject r10);
}
