package com.ss.android.lark.keyboard.edittext2.edittors.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends SimpleTarget<Bitmap> {
    public final /* synthetic */ UrlImageSpanView a;

    public c(UrlImageSpanView r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        Resources r0 = this.a.getResources();
        b r1 = new b(r5, this.a, r0);
        r1.setBounds(0, 0, r1.getIntrinsicWidth(), r1.getIntrinsicHeight());
        UrlImageSpanView.a(this.a).setImageDrawable(r1);
        Log.d("UrlImageSpanView", "onResourceReady: imageView.setImageDrawable called");
    }
}
