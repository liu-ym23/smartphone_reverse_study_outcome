package com.bytedance.android.ec.common.impl.sku;

import com.bytedance.android.ec.opt.prerender.PrerenderDialog;
import com.bytedance.android.ec.opt.prerender.PrerenderDialogFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ SkuFragment a;

    public g(SkuFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        rg.a r10 = (rg.a) r1;
        PrerenderDialog r11 = ((PrerenderDialogFragment) this.a).g;
        if (r11 == null) goto L6;
        r11.hide();
        return;
    }
}
