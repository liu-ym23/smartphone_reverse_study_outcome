package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ ButtonOptimizePresenter a;

    public j(ButtonOptimizePresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        String r11 = (String) r10;
        if ((System.currentTimeMillis() - this.a.n) <= 500) goto L13;
        if (r11 != null) goto L6;
    L9:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L14;
        ButtonOptimizePresenter.e0(this.a).logChooseSkuCompleteEvent();
        this.a.n = System.currentTimeMillis();
        return;
    L14:
        return;
    L6:
        if (r11.length() == 0) goto L9;
        r12 = false;
        goto L10
    }
}
