package com.bytedance.android.ec.common.impl.sku;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ SkuPanelOptimizeFragment a;

    public m(SkuPanelOptimizeFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        SkuPanelOptimizeFragment r0 = this.a;
        int r11 = ((Integer) r10).intValue();
        View r1 = r0.g;
        if (r1 == null) goto L8;
        NestedScrollView r12 = r1.findViewById(2131387796);
        if (r12 == null) goto L9;
        r12.smoothScrollTo(0, r11);
        return;
    L9:
        return;
    }
}
