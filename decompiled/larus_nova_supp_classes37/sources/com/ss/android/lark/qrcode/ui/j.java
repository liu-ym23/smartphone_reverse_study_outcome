package com.ss.android.lark.qrcode.ui;

import android.content.Intent;
import com.ss.android.lark.qrcode.zxing.BarcodeFormat;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j implements b {
    public final a2c.a a;
    public final BarcodeFormat[] b;

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // com.ss.android.lark.qrcode.ui.b
    public final BarcodeFormat[] getFormats() {
        return this.b;
    }

    public j(Intent r6) {
        a2c.a r0 = z1c.a.a;
        this.a = r0;
        r0.otherOpenCamera();
        ArrayList r1 = new ArrayList();
        if (r6 == null) goto L17;
        int[] r7 = r6.getIntArrayExtra("key_code_format");
        if (r7 != null) goto L7;
        r1.add(BarcodeFormat.QR_CODE);
        goto L17
    L7:
        int r2 = 0;
    L9:
        if (r2 >= r7.length) goto L17;
        int r3 = r7[r2];
        if (r3 != 0) goto L14;
        r1.add(BarcodeFormat.QR_CODE);
    L16:
        r2 = r2 + 1;
        goto L9
    L14:
        if (r3 != 1) goto L16;
        r1.add(BarcodeFormat.EAN_8);
        r1.add(BarcodeFormat.EAN_13);
        r1.add(BarcodeFormat.UPC_EAN_EXTENSION);
        r1.add(BarcodeFormat.CODE_39);
        r1.add(BarcodeFormat.CODE_93);
        r1.add(BarcodeFormat.CODE_128);
        r1.add(BarcodeFormat.CODABAR);
    L17:
        this.b = (BarcodeFormat[]) r1.toArray(new BarcodeFormat[0]);
    }
}
