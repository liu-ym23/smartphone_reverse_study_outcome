package com.bytedance.ttnet;

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
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PartMap;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface INetworkApi {
    @GET
    Call<String> doGet(@AddCommonParam boolean r8, @MaxLength int r10, @Url String r11, @QueryMap(encode = true) Map<String, String> r12, @HeaderList List<Header> r13, @ExtraInfo Object r14);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@MaxLength int r8, @Url String r10, @QueryMap Map<String, String> r11, @FieldMap(encode = true) Map<String, String> r12, @HeaderList List<Header> r13, @ExtraInfo Object r14);

    @GET
    @Streaming
    Call<TypedInput> downloadFile(@AddCommonParam boolean r8, @MaxLength int r10, @Url String r11, @QueryMap(encode = true) Map<String, String> r12);

    @GET
    @Streaming
    Call<TypedInput> downloadFile(@AddCommonParam boolean r8, @MaxLength int r10, @Url String r11, @QueryMap(encode = true) Map<String, String> r12, @HeaderList List<Header> r13, @ExtraInfo Object r14);

    @POST
    Call<String> postBody(@MaxLength int r8, @Url String r10, @QueryMap(encode = true) Map<String, String> r11, @Body TypedOutput r12, @HeaderList List<Header> r13);

    @Multipart
    @POST
    Call<String> postMultiPart(@MaxLength int r8, @Url String r10, @QueryMap(encode = true) Map<String, String> r11, @PartMap Map<String, TypedOutput> r12, @HeaderList List<Header> r13);
}
