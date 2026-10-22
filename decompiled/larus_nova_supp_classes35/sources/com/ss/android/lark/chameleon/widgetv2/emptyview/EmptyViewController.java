package com.ss.android.lark.chameleon.widgetv2.emptyview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface EmptyViewController {
    void hide();

    void show();

    void showCustomError(int r1, CharSequence r2);

    void showLoadError(Throwable r1);

    void showLoading();

    void showNoContent();

    void showNoFound();

    void showNoNetworkError();

    void showNoPermission();

    void showNoSupport();

    void showTimeout();

    void showWikiDeleted();
}
