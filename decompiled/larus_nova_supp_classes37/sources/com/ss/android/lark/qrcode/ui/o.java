package com.ss.android.lark.qrcode.ui;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.qrcode.zxing.BarcodeFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o implements c.a {
    public final /* synthetic */ p a;

    @Override // com.ss.android.lark.qrcode.ui.c.a
    public final BarcodeFormat[] getFormats() {
        return ((b) this.a.getModel()).getFormats();
    }

    public o(p r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.qrcode.ui.c.a
    public final void E4(String r3) {
        Log.i("QRCodeScanPresenter", "scan qr code success, result: *");
        this.a.getClass();
        p.H8(this.a, r3, 1);
    }
}
