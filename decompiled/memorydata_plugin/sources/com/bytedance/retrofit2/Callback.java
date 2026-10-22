package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes2.dex */
public interface Callback<T> {
    void onFailure(Call<T> r1, Throwable r2);

    void onResponse(Call<T> r1, SsResponse<T> r2);
}
