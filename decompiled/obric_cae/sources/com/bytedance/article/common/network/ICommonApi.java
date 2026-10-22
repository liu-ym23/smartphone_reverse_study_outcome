package com.bytedance.article.common.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ICommonApi {
    @GET
    Call<String> get(@MaxLength int r8, @Url String r10, @HeaderList List<Header> r11, @AddCommonParam boolean r12);

    @POST
    Call<String> postData(@MaxLength int r8, @Url String r10, @Body TypedOutput r11, @HeaderList List<Header> r12, @AddCommonParam boolean r13);

    @FormUrlEncoded
    @POST
    Call<String> postForm(@MaxLength int r8, @Url String r10, @FieldMap(encode = true) Map<String, String> r11, @HeaderList List<Header> r12, @AddCommonParam boolean r13);
}
