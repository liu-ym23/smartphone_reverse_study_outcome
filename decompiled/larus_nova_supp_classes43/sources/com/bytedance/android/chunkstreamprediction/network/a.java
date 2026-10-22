package com.bytedance.android.chunkstreamprediction.network;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface a<T> {
    void onComplete();

    void onFailed(Throwable r1);

    void onNext(T r1);
}
