package com.bytedance.android.ec.common.impl.entranceinfo;

import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0004\u001a\u00020\u0002H'¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/common/impl/entranceinfo/RealApi;", "", "", "reportContent", "reportType", "Lio/reactivex/Observable;", "post", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface RealApi {
    @FormUrlEncoded
    @POST("/aweme/v2/shop/track/statistics/")
    Observable<Object> post(@Field("report_content") String r1, @Field("report_type") String r10);
}
