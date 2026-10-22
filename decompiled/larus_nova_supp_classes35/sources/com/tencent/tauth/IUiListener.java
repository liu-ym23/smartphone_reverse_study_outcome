package com.tencent.tauth;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IUiListener {
    void onCancel();

    void onComplete(Object r1);

    void onError(UiError r1);

    void onWarning(int r1);
}
