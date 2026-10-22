package com.ss.android.lark.qrcode.ui;

import android.view.View;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ QRCodeScanView a;

    public w(QRCodeScanView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        this.a.a.b();
        c2c.a r8 = this.a.k;
        h.c.a.getClass();
        if (h.m() == false) goto L5;
        String r0 = "ve";
    L6:
        boolean r1 = h.l();
        long r2 = System.currentTimeMillis() - this.a.l.longValue();
        r8.getClass();
        c2c.a.a(r0, r1, "myqrcode", r2);
        return;
    L5:
        r0 = PickerReporterConstants.VALUE.SCENE.OTHERS;
        goto L6
    }
}
