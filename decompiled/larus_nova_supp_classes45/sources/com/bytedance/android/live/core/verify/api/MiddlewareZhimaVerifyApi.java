package com.bytedance.android.live.core.verify.api;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import w80.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0003\u0010\u0003\u001a\u00020\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H'J\b\u0010\n\u001a\u00020\u0002H\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/verify/api/MiddlewareZhimaVerifyApi;", "", "", LiveSlardarConstants.EXTRA_KEY_URL, "", "map", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lw80/a;", "getCertificationSubmit", "getCertificationSubmitUrl", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MiddlewareZhimaVerifyApi {
    @FormUrlEncoded
    Observable<Response<a>> getCertificationSubmit(@Url String r1, @FieldMap Map<String, String> r2);
}
