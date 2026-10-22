package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@FunctionalInterface
public interface Callback<T> {
    Runnable bind(T r1);

    void onResult(T r1);
}
