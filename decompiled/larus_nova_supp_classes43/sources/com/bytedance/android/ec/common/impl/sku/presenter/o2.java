package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o2 implements View.OnClickListener {
    public final /* synthetic */ t2 a;

    public o2(t2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        t2.d0(this.a).m1030getSkuInfo();
    }
}
