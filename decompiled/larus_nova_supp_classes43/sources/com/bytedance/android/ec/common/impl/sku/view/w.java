package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w<T> implements com.bytedance.android.ec.core.utils.y.c {
    public final /* synthetic */ SpecItemOptimizeView a;
    public final /* synthetic */ s.c b;

    public w(SpecItemOptimizeView r1, s.c r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // com.bytedance.android.ec.core.utils.y.c
    public final void accept(Object r10) {
        this.a.post(new v(this, (Bitmap) r10));
    }
}
