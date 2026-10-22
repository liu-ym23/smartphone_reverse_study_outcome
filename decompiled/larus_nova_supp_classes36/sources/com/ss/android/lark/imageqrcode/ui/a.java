package com.ss.android.lark.imageqrcode.ui;

import android.view.View;
import com.ss.android.lark.imageqrcode.QRCodeContentInfo;
import com.ss.android.lark.imageqrcode.QRCodeShowParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ ImageQRCodeSelectActivity a;
    public final /* synthetic */ QRCodeContentInfo b;

    public a(ImageQRCodeSelectActivity r1, QRCodeContentInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ImageQRCodeSelectActivity r4 = this.a;
        QRCodeContentInfo r0 = this.b;
        QRCodeShowParam r1 = ImageQRCodeSelectActivity.d;
        r4.z1(r0, "click");
    }
}
