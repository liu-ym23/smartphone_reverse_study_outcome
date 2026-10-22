package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes.dex */
public interface ExpandCallback<T> extends Callback<T> {
    void onAsyncPreRequest(RequestBuilder r8);

    void onAsyncResponse(Call<T> r8, SsResponse<T> r10);
}
