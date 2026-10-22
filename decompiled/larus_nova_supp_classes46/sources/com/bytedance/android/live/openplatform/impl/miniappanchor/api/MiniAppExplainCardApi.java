package com.bytedance.android.live.openplatform.impl.miniappanchor.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSensitiveResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\t\u0010\nJB\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0003\u0010\u000f\u001a\u00020\u000eH'¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/MiniAppExplainCardApi;", "", "", "businessType", "", "text", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSensitiveResponse;", "checkStamp", "(Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "appId", "schema", "sourcePage", "", "needIconBackground", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/e;", "getPresetCard", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MiniAppExplainCardApi {
    @GET("/webcast/stamp/check/")
    Observable<Response<StampSensitiveResponse>> checkStamp(@Query("type") Integer r1, @Query("text") String r2);

    @GET("/webcast/microapp/get/preset_card/")
    Observable<e<com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.e>> getPresetCard(@Query("app_id") String r1, @Query("schema") String r2, @Query("source_page") String r3, @Query("need_icon_background") boolean r4);
}
