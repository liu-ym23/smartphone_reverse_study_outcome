package com.bytedance.bdlocation.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface INetworkApiInner {
    @GET
    Call<String> doGet(@AddCommonParam boolean r8, @MaxLength int r10, @Url String r11, @QueryMap(encode = true) Map<String, String> r12, @HeaderList List<Header> r13, @ExtraInfo Object r14);

    @FormUrlEncoded
    @POST
    Call<String> doPost(@MaxLength int r8, @Url String r10, @QueryMap Map<String, String> r11, @FieldMap(encode = true) Map<String, String> r12, @HeaderList List<Header> r13, @ExtraInfo Object r14, @AddCommonParam boolean r15);
}
