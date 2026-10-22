package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Priority;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H'JD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H'JN\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\b\b\u0001\u0010\f\u001a\u00020\rH'JN\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\b\b\u0001\u0010\f\u001a\u00020\rH'¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/NativePrefetchApi;", "", "prefetchForGet", "Lio/reactivex/Observable;", "", com.bytedance.android.ec.core.event.a.KEY_URL, "queryMap", "", "headerMap", "prefetchForGetV2", "Lcom/bytedance/android/ec/core/hybrid/prefetch/NativePrefetchResponse;", "prefetchForPost", "body", "Lcom/google/gson/JsonObject;", "prefetchForPostV2", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface NativePrefetchApi {
    @GET
    Observable<String> prefetchForGet(@Url String r1, @QueryMap Map<String, String> r10, @HeaderMap Map<String, String> r11);

    @NaPrefetch
    @GET
    @Priority(2)
    Observable<NativePrefetchResponse> prefetchForGetV2(@Url String r1, @QueryMap Map<String, String> r10, @HeaderMap Map<String, String> r11);

    @POST
    Observable<String> prefetchForPost(@Url String r1, @QueryMap Map<String, String> r10, @HeaderMap Map<String, String> r11, @Body JsonObject r12);

    @POST
    @NaPrefetch
    @Priority(2)
    Observable<NativePrefetchResponse> prefetchForPostV2(@Url String r1, @QueryMap Map<String, String> r10, @HeaderMap Map<String, String> r11, @Body JsonObject r12);
}
