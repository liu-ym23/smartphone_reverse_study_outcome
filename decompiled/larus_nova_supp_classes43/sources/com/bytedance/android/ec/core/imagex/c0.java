package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.core.imagex.opt.ECImageMultiSizeReuseOpt;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c0 extends BaseRequestListener {
    public final /* synthetic */ com.bytedance.android.shopping.api.image.q a;
    public final /* synthetic */ r b;

    public c0(com.bytedance.android.shopping.api.image.q r1, r r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void onRequestSuccess(ImageRequest r10, String r11, boolean r12) {
        super.onRequestSuccess(r10, r11, r12);
        if (r12 == true) goto L5;
        return;
    L5:
        if (this.a == null) goto L12;
        ECImageMultiSizeReuseOpt r13 = ECImageMultiSizeReuseOpt.e;
        r r14 = this.b;
        if ((r14 instanceof u) == true) goto L9;
        r14 = null;
    L9:
        r13.getClass();
        ECImageMultiSizeReuseOpt.n((u) r14, r10);
        return;
    }

    public final void onRequestFailure(ImageRequest r1, String r10, Throwable r11, boolean r12) {
        if (this.a != null) goto L5;
        return;
    L5:
        if (ImageExtensionsKt.q(r1) == false) goto L14;
        r r13 = this.b;
        if ((r13 instanceof u) == true) goto L9;
        r13 = null;
    L9:
        u r14 = (u) r13;
        if (r14 == null) goto L15;
        r14.F = true;
        return;
    L15:
        return;
    }
}
