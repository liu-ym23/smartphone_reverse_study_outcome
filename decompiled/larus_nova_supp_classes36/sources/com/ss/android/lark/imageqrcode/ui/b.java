package com.ss.android.lark.imageqrcode.ui;

import android.view.View;
import com.ss.android.lark.imageqrcode.QRCodeShowParam;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ ImageQRCodeSelectActivity a;

    public b(ImageQRCodeSelectActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        StringBuilder r5 = new StringBuilder("cancel scan,");
        QRCodeShowParam r0 = ImageQRCodeSelectActivity.d;
        QRCodeShowParam r1 = ImageQRCodeSelectActivity.d;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getFrom();
    L6:
        r5.append(r3);
        r5.append(',');
        QRCodeShowParam r6 = ImageQRCodeSelectActivity.d;
        if (r6 == null) goto L9;
        String r7 = r6.getScanType();
    L10:
        r5.append(r7);
        Log.i("ImageQRCodeSelectActivity", r5.toString());
        JSONObject r8 = new JSONObject();
        QRCodeShowParam r9 = ImageQRCodeSelectActivity.d;
        if (r9 == null) goto L13;
        String r10 = r9.getFrom();
    L14:
        JSONObject r11 = r8.put("from", r10);
        QRCodeShowParam r12 = ImageQRCodeSelectActivity.d;
        if (r12 == null) goto L17;
        r2 = r12.getScanType();
    L17:
        Statistics.sendEvent("scan_qrcode_multicode_select_cancel", r11.put("ve_scan_type", r2));
        this.a.finish();
        return;
    L13:
        r10 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
