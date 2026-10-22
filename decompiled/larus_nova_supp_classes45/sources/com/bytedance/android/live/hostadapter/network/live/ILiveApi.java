package com.bytedance.android.live.hostadapter.network.live;

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
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface ILiveApi {
    @FormUrlEncoded
    @POST
    Call<TypedInput> doPost(@Url String r1, @HeaderList List<Header> r2, @FieldMap Map<String, String> r3);

    @GET
    @Streaming
    Call<TypedInput> downloadFile(@AddCommonParam boolean r1, @MaxLength int r2, @Url String r3, @HeaderList List<Header> r4, @ExtraInfo Object r5);

    @GET
    Call<TypedInput> get(@Url String r1, @HeaderList List<Header> r2);

    @POST
    Call<TypedInput> post(@Url String r1, @Body TypedByteArray r2, @HeaderList List<Header> r3);

    @POST
    Call<TypedInput> postMultiPart(@MaxLength int r1, @Url String r2, @HeaderList List<Header> r3, @Body TypedOutput r4);
}
