package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.Bitmap;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p<T> implements com.bytedance.android.ec.core.utils.y.c {
    public final /* synthetic */ n a;
    public final /* synthetic */ TextView b;

    public p(n r1, TextView r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // com.bytedance.android.ec.core.utils.y.c
    public final void accept(Object r10) {
        this.a.post(new o(this, (Bitmap) r10));
    }
}
