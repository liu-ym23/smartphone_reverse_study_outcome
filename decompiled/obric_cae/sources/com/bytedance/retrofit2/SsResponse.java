package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SsResponse<T> {
    private final T body;
    private final TypedInput errorBody;
    private final Response rawResponse;
    private RetrofitMetrics retrofitMetrics;

    private SsResponse(Response r8, T r10, TypedInput r11) {
        this.rawResponse = r8;
        this.body = r10;
        this.errorBody = r11;
    }

    public static <T> SsResponse<T> error(TypedInput r8, Response r10) {
        if (r8 == null) goto L13;
        if (r10 == null) goto L11;
        if (r10.isSuccessful() == true) goto L9;
        return new SsResponse(r10, null, r8);
    L9:
        throw new IllegalArgumentException("rawResponse should not be successful response");
    L11:
        throw new NullPointerException("rawResponse == null");
    L13:
        throw new NullPointerException("body == null");
    }

    public static <T> SsResponse<T> success(T r8, Response r10) {
        if (r10 == null) goto L10;
        if (r10.isSuccessful() == false) goto L8;
        return new SsResponse(r10, r8, null);
    L8:
        throw new IllegalArgumentException("rawResponse must be successful response");
    L10:
        throw new NullPointerException("rawResponse == null");
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

    public Response raw() {
        return this.rawResponse;
    }

    public void setRetrofitMetrics(RetrofitMetrics r8) {
        this.retrofitMetrics = r8;
    }
}
