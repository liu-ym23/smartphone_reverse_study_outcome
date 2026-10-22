package com.ss.android.lark.qrcode.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ QRCodeScanView a;

    public x(QRCodeScanView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.a.c(r2);
    }
}
