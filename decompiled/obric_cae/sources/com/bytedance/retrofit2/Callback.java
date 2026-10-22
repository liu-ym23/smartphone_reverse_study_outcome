package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes.dex */
public interface Callback<T> {
    void onFailure(Call<T> r8, Throwable r10);

    void onResponse(Call<T> r8, SsResponse<T> r10);
}
