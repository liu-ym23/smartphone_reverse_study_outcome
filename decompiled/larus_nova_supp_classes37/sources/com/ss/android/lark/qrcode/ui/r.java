package com.ss.android.lark.qrcode.ui;

import android.view.View;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ QRCodeScanView a;

    public r(QRCodeScanView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        QRCodeScanView r8 = this.a;
        if (r8.b == null) goto L10;
        c2c.a r9 = r8.k;
        h.c.a.getClass();
        if (h.m() == false) goto L7;
        String r0 = "ve";
    L8:
        boolean r1 = h.l();
        long r2 = System.currentTimeMillis() - this.a.l.longValue();
        r9.getClass();
        c2c.a.a(r0, r1, "userexit", r2);
        this.a.b.finish();
        return;
    L7:
        r0 = PickerReporterConstants.VALUE.SCENE.OTHERS;
        goto L8
    }
}
