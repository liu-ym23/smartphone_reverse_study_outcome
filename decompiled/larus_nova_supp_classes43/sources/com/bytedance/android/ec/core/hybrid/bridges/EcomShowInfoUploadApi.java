package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Flowable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/EcomShowInfoUploadApi;", "", "requestWithParams", "Lio/reactivex/Flowable;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "params", "", "", "retry", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface EcomShowInfoUploadApi {
    @GET("aweme/sdk/report")
    Flowable<CommerceBaseResponse> requestWithParams(@QueryMap(encode = true) Map<String, String> r1, @Query("retry") int r10);
}
