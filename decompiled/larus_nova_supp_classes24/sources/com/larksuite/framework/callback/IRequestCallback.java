package com.larksuite.framework.callback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface IRequestCallback<S, E> extends ICallback {
    void onError(E r1);

    void onSuccess(S r1);
}
