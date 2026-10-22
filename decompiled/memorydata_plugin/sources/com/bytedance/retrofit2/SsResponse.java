package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class SsResponse<T> {
    private final T body;
    private final TypedInput errorBody;
    private final Response rawResponse;
    private RetrofitMetrics retrofitMetrics;

    private SsResponse(Response r3, T r4, TypedInput r5) {
        TypedInput r6 = (TypedInput) ZeusTransformUtils.wrapperContextForParams(r5, TypedInput.class, "com.obric.memorydata.plugin");
        this.rawResponse = r3;
        this.body = r4;
        this.errorBody = r6;
    }

    public static <T> SsResponse<T> error(TypedInput r2, Response r3) {
        TypedInput r4 = (TypedInput) ZeusTransformUtils.wrapperContextForParams(r2, TypedInput.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "body == null");
        Objects.requireNonNull(r3, "rawResponse == null");
        if (r3.isSuccessful() == true) goto L7;
        return new SsResponse(r3, null, r4);
    L7:
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> SsResponse<T> success(T r2, Response r3) {
        Objects.requireNonNull(r3, "rawResponse == null");
        if (r3.isSuccessful() == false) goto L7;
        return new SsResponse(r3, r2, null);
    L7:
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.getStatus();
    }

    public TypedInput errorBody() {
        return this.errorBody;
    }

    public RetrofitMetrics getRetrofitMetrics() {
        return this.retrofitMetrics;
    }

    public List<Header> headers() {
        return this.rawResponse.getHeaders();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public String message() {
        return this.rawResponse.message();
    }

    public Response raw() {
        return this.rawResponse;
    }

    public void setRetrofitMetrics(RetrofitMetrics r1) {
        this.retrofitMetrics = r1;
    }
}
