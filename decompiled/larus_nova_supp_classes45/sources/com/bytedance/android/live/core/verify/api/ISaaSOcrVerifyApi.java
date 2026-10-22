package com.bytedance.android.live.core.verify.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jb\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\t\u001a\u00020\n2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0007H'¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/core/verify/api/ISaaSOcrVerifyApi;", "", "queryPollingStatus", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/core/verify/api/VerifyResponBean;", "channel", "", "token", "scene", "", "enterFrom", "byteScene", "skipRecordVerify", "", "certType", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISaaSOcrVerifyApi {
    @GET("/webcast/openapi/certification/query/")
    Observable<Response<VerifyResponBean>> queryPollingStatus(@Query("verify_channel") String r1, @Query("byte_token") String r2, @Query("scene") int r3, @Query("enter_from") String r4, @Query("byte_scene") String r5, @Query("skip_record_verify") boolean r6, @Query("cert_type") String r7);
}
