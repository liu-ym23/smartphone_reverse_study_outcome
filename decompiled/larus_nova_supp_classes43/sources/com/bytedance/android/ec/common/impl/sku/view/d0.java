package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d0<T> implements com.bytedance.android.ec.core.utils.y.c {
    public final /* synthetic */ SpecItemView a;

    public d0(SpecItemView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.ec.core.utils.y.c
    public final void accept(Object r10) {
        this.a.post(new c0(this, (Bitmap) r10));
    }
}
