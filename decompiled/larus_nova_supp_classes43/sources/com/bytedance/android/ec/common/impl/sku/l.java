package com.bytedance.android.ec.common.impl.sku;

import android.app.Dialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ SkuPanelOptimizeFragment a;

    public l(SkuPanelOptimizeFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        rg.a r10 = (rg.a) r1;
        Dialog r11 = this.a.getDialog();
        if (r11 == null) goto L6;
        r11.hide();
        return;
    }
}
