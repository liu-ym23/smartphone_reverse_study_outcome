package com.bytedance.ai.bridge.method.net.core;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.DELETE;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001Jh\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0010\b\u0001\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0001H'J\u0080\u0001\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0010\b\u0001\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0016\b\u0001\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0001H'Jt\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0010\b\u0001\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0001H'J\\\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0001\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0001H'JP\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0001\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0001H'Jh\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0010\b\u0001\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0001H'Jt\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0010\b\u0001\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/core/IHostNetworkRuntimeApi;", "", "get", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "addCommonPara", "", "maxLength", "", "relativePath", "", "queryMap", "", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "extraInfo", "post", "fieldMap", "body", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "put", "delete", "streamGet", "streamPost", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IHostNetworkRuntimeApi {
    @DELETE
    Call<TypedInput> delete(@AddCommonParam boolean r1, @MaxLength int r10, @Url String r11, @HeaderList List<Header> r12, @ExtraInfo Object r13);

    @GET
    Call<TypedInput> get(@AddCommonParam boolean r1, @MaxLength int r10, @Url String r11, @QueryMap(encode = true) Map<String, String> r12, @HeaderList List<Header> r13, @ExtraInfo Object r14);

    @POST
    Call<TypedInput> post(@AddCommonParam boolean r1, @MaxLength int r10, @Url String r11, @QueryMap Map<String, String> r12, @HeaderList List<Header> r13, @Body TypedOutput r14, @ExtraInfo Object r15);

    @FormUrlEncoded
    @POST
    Call<TypedInput> post(@AddCommonParam boolean r1, @MaxLength int r10, @Url String r11, @QueryMap Map<String, String> r12, @HeaderList List<Header> r13, @FieldMap(encode = true) Map<String, String> r14, @ExtraInfo Object r15);

    @PUT
    Call<TypedInput> put(@AddCommonParam boolean r1, @MaxLength int r10, @Url String r11, @HeaderList List<Header> r12, @Body TypedOutput r13, @ExtraInfo Object r14);

    @GET
    @Streaming
    Call<TypedInput> streamGet(@AddCommonParam boolean r1, @MaxLength int r10, @Url String r11, @QueryMap(encode = true) Map<String, String> r12, @HeaderList List<Header> r13, @ExtraInfo Object r14);

    @POST
    @Streaming
    Call<TypedInput> streamPost(@AddCommonParam boolean r1, @MaxLength int r10, @Url String r11, @QueryMap Map<String, String> r12, @HeaderList List<Header> r13, @Body TypedOutput r14, @ExtraInfo Object r15);
}
