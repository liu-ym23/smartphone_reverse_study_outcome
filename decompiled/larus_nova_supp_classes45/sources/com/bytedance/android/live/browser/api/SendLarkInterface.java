package com.bytedance.android.live.browser.api;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import kotlin.Metadata;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\b\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u0018\u00010\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/browser/api/SendLarkInterface;", "", "", LiveSlardarConstants.EXTRA_KEY_URL, "Lokhttp3/RequestBody;", "body", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "postLarkMessage", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface SendLarkInterface {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST
    Observable<Response<Object>> postLarkMessage(@Url String r1, @Body RequestBody r2);
}
