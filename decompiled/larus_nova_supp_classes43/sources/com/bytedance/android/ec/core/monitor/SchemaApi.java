package com.bytedance.android.ec.core.monitor;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/SchemaApi;", "", "Lcom/bytedance/android/ec/core/monitor/p;", "logData", "Lio/reactivex/Observable;", "", "uploadSchema", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface SchemaApi {
    @POST("https://cloudapi.bytedance.net/faas/services/ttjuyr/invoke/monitor/")
    Observable<String> uploadSchema(@Body p r1);
}
