package com.bytedance.awemeopen.infra.plugs.ttnet;

import com.bytedance.bmmt.BuildConfig;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HEAD;
import com.bytedance.retrofit2.http.HTTP;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.OPTIONS;
import com.bytedance.retrofit2.http.PATCH;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface AoTTNetRetrofitApi {
    @HTTP(hasBody = BuildConfig.DEBUG, method = "CONNECT")
    Call<TypedInput> connect(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @HeaderList List<Header> r4, @ExtraInfo Object r5, @AddCommonParam boolean r6);

    @HTTP(hasBody = true, method = "DELETE")
    Call<TypedInput> delete(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @Body TypedOutput r4, @HeaderList List<Header> r5, @ExtraInfo Object r6, @AddCommonParam boolean r7);

    @GET
    Call<TypedInput> get(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @HeaderList List<Header> r4, @ExtraInfo Object r5, @AddCommonParam boolean r6);

    @GET
    @Streaming
    Call<TypedInput> getStream(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @HeaderList List<Header> r4, @ExtraInfo Object r5, @AddCommonParam boolean r6);

    @HEAD
    Call<Void> head(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @HeaderList List<Header> r4, @ExtraInfo Object r5, @AddCommonParam boolean r6);

    @OPTIONS
    Call<TypedInput> options(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @HeaderList List<Header> r4, @ExtraInfo Object r5, @AddCommonParam boolean r6);

    @PATCH
    Call<TypedInput> patch(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @Body TypedOutput r4, @HeaderList List<Header> r5, @ExtraInfo Object r6, @AddCommonParam boolean r7);

    @POST
    Call<TypedInput> post(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @Body TypedOutput r4, @HeaderList List<Header> r5, @ExtraInfo Object r6, @AddCommonParam boolean r7);

    @POST
    @Streaming
    Call<TypedInput> postStream(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @Body TypedOutput r4, @HeaderList List<Header> r5, @ExtraInfo Object r6, @AddCommonParam boolean r7);

    @PUT
    Call<TypedInput> put(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @Body TypedOutput r4, @HeaderList List<Header> r5, @ExtraInfo Object r6, @AddCommonParam boolean r7);

    @PUT
    @Streaming
    Call<TypedInput> putStream(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @Body TypedOutput r4, @HeaderList List<Header> r5, @ExtraInfo Object r6, @AddCommonParam boolean r7);

    @HTTP(hasBody = BuildConfig.DEBUG, method = "TRACE")
    Call<TypedInput> trace(@MaxLength int r1, @Url String r2, @QueryMap(encode = true) Map<String, String> r3, @HeaderList List<Header> r4, @ExtraInfo Object r5, @AddCommonParam boolean r6);
}
