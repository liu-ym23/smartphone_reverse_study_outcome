package com.bytedance.android.ec.common.impl.sku.view;

import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.core.utils.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t implements s.b {
    public final /* synthetic */ s a;

    @Override // com.bytedance.android.ec.common.impl.sku.view.s.b
    public final void a(boolean r10) {
        s r0 = this.a;
        int r1 = r0.getChildCount();
        int r11 = r0.g;
    L3:
        if (r11 >= r1) goto L17;
        Object r12 = r0.getChildAt(r11);
        if (r12 == null) goto L16;
        SpecItemOptimizeView r13 = (SpecItemOptimizeView) r12;
        r13.d = r10;
        r13.b6(r13.b);
        r13.Z5();
        int r14 = r13.p;
        s.c r15 = r13.b;
        if (r14 != 0) goto L14;
        SkuViewModel r16 = r13.o;
        if (r16 == null) goto L14;
        if (r15 == null) goto L12;
        String r17 = r15.e;
    L13:
        r16.setCurrentSpecHasPrice(a2.b(r17));
        goto L14
    L12:
        r17 = null;
    L14:
        r13.T5(r13.p, r13.b);
        r11 = r11 + 1;
        goto L3
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeView");
    }

    public t(s r1, SpecItemOptimizeGroupLayout.d r10) {
        this.a = r1;
    }
}
