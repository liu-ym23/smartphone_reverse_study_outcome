package com.bytedance.android.livesdk.interactivity.service.uplink;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fH'JN\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/uplink/IUplinkApi;", BuildConfig.FLAVOR, "doGetAsync", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/SsResponse;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "url", BuildConfig.FLAVOR, "headers", BuildConfig.FLAVOR, "Lcom/bytedance/retrofit2/client/Header;", "query", BuildConfig.FLAVOR, "doPostAsync", "data", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUplinkApi {
    @GET
    Observable<SsResponse<TypedInput>> doGetAsync(@Url String r1, @HeaderList List<Header> r2, @QueryMap Map<String, String> r3);

    @POST
    Observable<SsResponse<TypedInput>> doPostAsync(@Url String r1, @HeaderList List<Header> r2, @QueryMap Map<String, String> r3, @Body TypedOutput r4);
}
