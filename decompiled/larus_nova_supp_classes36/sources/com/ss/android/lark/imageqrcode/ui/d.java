package com.ss.android.lark.imageqrcode.ui;

import android.graphics.Bitmap;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.imageqrcode.QRCodeContentInfo;
import com.ss.android.lark.imageqrcode.QRCodeShowParam;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<T> implements RxScheduledExecutor.Consumer {
    public final /* synthetic */ ImageQRCodeSelectActivity a;
    public final /* synthetic */ AppCompatImageView b;
    public final /* synthetic */ QRCodeShowParam c;

    public d(ImageQRCodeSelectActivity r1, AppCompatImageView r2, QRCodeShowParam r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void consume(Object r6) {
        Bitmap r7 = (Bitmap) r6;
        int r0 = com.ss.android.lark.imageqrcode.utils.a.a;
        if (com.ss.android.lark.imageqrcode.utils.a.b(this.a) == true) goto L12;
        if (r7 != null) goto L6;
    L10:
        ImageQRCodeSelectActivity r8 = this.a;
        QRCodeContentInfo r1 = (QRCodeContentInfo) CollectionsKt.first(this.c.getContentList());
        QRCodeShowParam r2 = ImageQRCodeSelectActivity.d;
        r8.z1(r1, "decode bg failed");
        return;
    L6:
        if (com.ss.android.lark.imageqrcode.utils.a.c(r7) == true) goto L10;
        this.b.setImageBitmap(r7);
        ImageQRCodeSelectActivity r3 = this.a;
        QRCodeShowParam r4 = this.c;
        QRCodeShowParam r5 = ImageQRCodeSelectActivity.d;
        FrameLayout r9 = (FrameLayout) r3.findViewById(2131383511);
        if (r9 == null) goto L13;
        r9.getViewTreeObserver().addOnGlobalLayoutListener(new e(r9, r7, r4, r3));
        return;
    L13:
        return;
    }
}
