package com.obric.memorydata.middleware.impl.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.google.gson.JsonObject;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JU\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0016\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0001H§\u0002J^\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0016\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u0001H'JT\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0016\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0001H'J^\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0016\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u0001H'¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/RetrofitApi;", "", "get", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "addCommonParams", "", "relativePath", "", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "queryMap", "", "extraInfo", CozeCloudExt.API_KEY_HTTP_POST_METHOD, "body", "Lcom/google/gson/JsonObject;", "getWithStreaming", "postWithStreaming", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface RetrofitApi {
    @GET
    Call<TypedInput> get(@AddCommonParam boolean r1, @Url String r2, @HeaderList List<Header> r3, @QueryMap(encode = true) Map<String, String> r4, @ExtraInfo Object r5);

    @GET
    @Streaming
    Call<TypedInput> getWithStreaming(@AddCommonParam boolean r1, @Url String r2, @HeaderList List<Header> r3, @QueryMap(encode = true) Map<String, String> r4, @ExtraInfo Object r5);

    @POST
    Call<TypedInput> post(@AddCommonParam boolean r1, @Url String r2, @HeaderList List<Header> r3, @QueryMap(encode = true) Map<String, String> r4, @Body JsonObject r5, @ExtraInfo Object r6);

    @POST
    @Streaming
    Call<TypedInput> postWithStreaming(@AddCommonParam boolean r1, @Url String r2, @HeaderList List<Header> r3, @QueryMap(encode = true) Map<String, String> r4, @Body JsonObject r5, @ExtraInfo Object r6);
}
