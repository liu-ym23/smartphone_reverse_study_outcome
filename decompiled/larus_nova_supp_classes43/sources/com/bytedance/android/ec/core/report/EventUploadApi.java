package com.bytedance.android.ec.core.report;

import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0003\u0010\u0007\u001a\u00020\u0006H'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/report/EventUploadApi;", "", "", "scene", "eventType", "action", "", "eventTime", "Lio/reactivex/Observable;", "post", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface EventUploadApi {
    @FormUrlEncoded
    @POST("/aweme/v2/baselink/event_upload")
    Observable<Object> post(@Field("scene") String r1, @Field("event_type") String r10, @Field("action") String r11, @Field("event_time") long r12);
}
