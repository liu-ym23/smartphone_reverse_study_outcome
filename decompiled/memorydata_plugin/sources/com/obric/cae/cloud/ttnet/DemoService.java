package com.obric.cae.cloud.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.mime.TypedInput;
import com.google.gson.JsonObject;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface DemoService {
    @Headers({"Content-Type: application/json"})
    @POST("/")
    Call<TypedInput> postCall(@Body JsonObject r1);

    @Headers({"Content-Type: application/json"})
    @POST("/")
    Call<TypedInput> postCall(@Body a r1);

    @Headers({"Content-Type: application/json", "Authorization: Bearer your-access-token"})
    @POST("/")
    Call<TypedInput> postCall(@Body String r1);

    @Headers({"Content-Type: application/json", "Authorization: Bearer your-access-token"})
    @POST("/")
    Call<TypedInput> postCall(@HeaderList List<Header> r1, @Body String r2);

    @POST("/")
    @Streaming
    Call<TypedInput> streamingPostCall(@Body String r1, @HeaderList List<Header> r2);
}
