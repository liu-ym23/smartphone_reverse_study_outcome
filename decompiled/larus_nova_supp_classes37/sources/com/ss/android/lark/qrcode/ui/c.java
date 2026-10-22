package com.ss.android.lark.qrcode.ui;

import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.qrcode.zxing.BarcodeFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface c extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void E4(String r1);

        BarcodeFormat[] getFormats();
    }

    void J4();

    void K4();

    void f();

    void hideLoading();

    void onResume();

    void showToast(String r1);
}
