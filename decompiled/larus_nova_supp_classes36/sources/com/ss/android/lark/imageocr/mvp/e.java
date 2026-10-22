package com.ss.android.lark.imageocr.mvp;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.imageocr.view.OCRScanView;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements LargeImageView.c {
    public final /* synthetic */ d a;

    @Override // com.ss.android.lark.imagewidget.largeimage.LargeImageView.c
    public final void a() {
    }

    @Override // com.ss.android.lark.imagewidget.largeimage.LargeImageView.c
    public final void b() {
        this.a.c.setVisibility(0);
        d r0 = this.a;
        if (r0.j != null) goto L6;
        OCRScanView r1 = r0.g;
        r1.getClass();
        Log.i("OCRScanView", "start");
        r1.setVisibility(0);
        r1.c();
        return;
    }

    public e(d r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.imagewidget.largeimage.LargeImageView.c
    public final void c(int r3, ErrorResult r4) {
        this.a.k(new ErrorResult(r3, "preview local image failed"));
    }
}
