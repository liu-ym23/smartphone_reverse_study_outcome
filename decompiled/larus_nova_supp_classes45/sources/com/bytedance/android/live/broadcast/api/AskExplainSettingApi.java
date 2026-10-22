package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.broadcast.api.model.o;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/AskExplainSettingApi;", "", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/broadcast/api/model/o;", "querySetting", "", "settingKey", "requestExplain", "updateSetting", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AskExplainSettingApi {
    @POST("/webcast/room/query_setting/")
    Observable<Response<o>> querySetting();

    @FormUrlEncoded
    @POST("/webcast/room/update_setting/")
    Observable<Response<o>> updateSetting(@Field("setting_key") int r1, @Field("request_explain") int r2);
}
