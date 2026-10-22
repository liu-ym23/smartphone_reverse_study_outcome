package com.ss.android.lark.ka.message.api.callback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface Callback<T> {
    void onFail(int r1, String r2);

    void onSuccess(T r1);
}
