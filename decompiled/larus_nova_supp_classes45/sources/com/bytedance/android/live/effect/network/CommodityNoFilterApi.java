package com.bytedance.android.live.effect.network;

import com.bytedance.android.live.network.response.a;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/effect/network/CommodityNoFilterApi;", "", "", "settingKey", "commodityNoFilter", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/a;", "updateSetting", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface CommodityNoFilterApi {
    @FormUrlEncoded
    @POST("/webcast/room/update_setting/")
    Observable<a> updateSetting(@Field("setting_key") int r1, @Field("commodity_no_filter") int r2);
}
