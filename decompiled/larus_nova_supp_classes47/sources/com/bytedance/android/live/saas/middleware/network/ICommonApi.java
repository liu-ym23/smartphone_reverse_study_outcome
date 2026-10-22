package com.bytedance.android.live.saas.middleware.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface ICommonApi {
    @GET
    Call<String> get(@MaxLength int r1, @Url String r2, @HeaderList List<Header> r3, @AddCommonParam boolean r4);

    @GET
    Call<TypedInput> getRawPb(@AddCommonParam boolean r1, @MaxLength int r2, @Url String r3, @QueryMap(encode = true) Map<String, String> r4, @HeaderList List<Header> r5, @ExtraInfo Object r6);

    @GET
    @Streaming
    Call<TypedInput> getStream(@AddCommonParam boolean r1, @MaxLength int r2, @Url String r3, @QueryMap(encode = true) Map<String, String> r4, @HeaderList List<Header> r5, @ExtraInfo Object r6);

    @POST
    Call<String> postData(@MaxLength int r1, @Url String r2, @Body TypedOutput r3, @HeaderList List<Header> r4, @AddCommonParam boolean r5);

    @FormUrlEncoded
    @POST
    Call<String> postForm(@MaxLength int r1, @Url String r2, @FieldMap Map<String, String> r3, @HeaderList List<Header> r4, @AddCommonParam boolean r5);

    @POST
    @Streaming
    Call<TypedInput> postPbData(@MaxLength int r1, @Url String r2, @Body TypedOutput r3, @HeaderList List<Header> r4, @AddCommonParam boolean r5);

    @POST
    Call<TypedInput> postPbDataNoStream(@MaxLength int r1, @Url String r2, @Body TypedOutput r3, @HeaderList List<Header> r4, @AddCommonParam boolean r5);

    @FormUrlEncoded
    @POST
    Call<TypedInput> postRawPb(@MaxLength int r1, @Url String r2, @QueryMap Map<String, String> r3, @FieldMap(encode = true) Map<String, String> r4, @HeaderList List<Header> r5, @ExtraInfo Object r6);

    @FormUrlEncoded
    @POST
    @Streaming
    Call<TypedInput> postStream(@MaxLength int r1, @Url String r2, @QueryMap Map<String, String> r3, @FieldMap(encode = true) Map<String, String> r4, @HeaderList List<Header> r5, @ExtraInfo Object r6);
}
