package com.bytedance.android.ec.common.impl.sku.presenter;

import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i2 implements NestedScrollView.OnScrollChangeListener {
    public final /* synthetic */ j2 a;

    public i2(j2 r1) {
        this.a = r1;
    }

    public final void onScrollChange(NestedScrollView r1, int r10, int r11, int r12, int r13) {
        m2.d0(this.a.a).getScrollViewScrollY().g(Integer.valueOf(r11));
    }
}
