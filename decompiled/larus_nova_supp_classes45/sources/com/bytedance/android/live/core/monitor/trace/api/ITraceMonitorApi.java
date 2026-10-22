package com.bytedance.android.live.core.monitor.trace.api;

import com.bytedance.android.live.base.UplinkService;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.internal.LinkedTreeMap;
import io.reactivex.Observable;
import kotlin.Metadata;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH'J8\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0005H'J$\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/core/monitor/trace/api/ITraceMonitorApi;", "", "postTraceMonitor", "Lio/reactivex/Observable;", "Lcom/google/gson/internal/LinkedTreeMap;", "", "compressType", "requestBody", "Lokhttp3/RequestBody;", "requestTag", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ITraceMonitorApi {
    @Headers({"Content-Type: application/octet-stream; charset=utf-8"})
    @POST("/webcast/trace/report/")
    Observable<LinkedTreeMap<String, String>> postTraceMonitor(@Query("compress_type") String r1, @Body RequestBody r2);

    @UplinkService(20001)
    @Headers({"Content-Type: application/octet-stream; charset=utf-8"})
    @POST("/webcast/trace/report/")
    Observable<LinkedTreeMap<String, String>> postTraceMonitor(@Query("compress_type") String r1, @Body RequestBody r2, @Header("x-tt-request-tag") String r3);

    @Headers({"Content-Type: application/octet-stream; charset=utf-8"})
    @POST("/webcast/trace/report/")
    Observable<LinkedTreeMap<String, String>> postTraceMonitor(@Body RequestBody r1);
}
