package com.bytedance.android.live.core.feed;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface AsrApi {
    @POST
    Observable<Response> report(@Url String r1, @Body JSONObject r2);
}
