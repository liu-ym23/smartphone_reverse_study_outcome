package com.bytedance.android.ec.common.impl.sku.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ ButtonPresenter a;

    public t(ButtonPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        String r10 = (String) r1;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L12;
        ButtonPresenter.e0(this.a).logChooseSkuCompleteEvent();
        return;
    L12:
        return;
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L9
    }
}
