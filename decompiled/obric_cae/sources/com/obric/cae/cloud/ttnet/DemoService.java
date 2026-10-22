package com.obric.cae.cloud.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.mime.TypedInput;
import ha.s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface DemoService {
    @Headers({"Content-Type: application/json"})
    @POST("/")
    Call<TypedInput> postCall(@Body ComplexRequestClass r8);

    @Headers({"Content-Type: application/json"})
    @POST("/")
    Call<TypedInput> postCall(@Body s r8);

    @Headers({"Content-Type: application/json", "Authorization: Bearer your-access-token"})
    @POST("/")
    Call<TypedInput> postCall(@Body String r8);

    @Headers({"Content-Type: application/json", "Authorization: Bearer your-access-token"})
    @POST("/")
    Call<TypedInput> postCall(@HeaderList List<Header> r8, @Body String r10);

    @POST("/")
    @Streaming
    Call<TypedInput> streamingPostCall(@Body String r8, @HeaderList List<Header> r10);
}
