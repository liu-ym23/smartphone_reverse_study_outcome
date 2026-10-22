package com.bytedance.android.ec.common.impl.sku;

import com.bytedance.android.ec.opt.prerender.PrerenderDialog;
import com.bytedance.android.ec.opt.prerender.PrerenderDialogFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ SkuFragment a;

    public f(SkuFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        rg.a r11 = (rg.a) r10;
        if (r11 == null) goto L13;
        PrerenderDialog r0 = ((PrerenderDialogFragment) this.a).g;
        if (r0 == null) goto L8;
        r0.hide();
    L8:
        Function0 r12 = (Function0) r11.b;
        if (r12 == null) goto L12;
        Unit r13 = (Unit) r12.invoke();
        return;
    L12:
        return;
    }
}
