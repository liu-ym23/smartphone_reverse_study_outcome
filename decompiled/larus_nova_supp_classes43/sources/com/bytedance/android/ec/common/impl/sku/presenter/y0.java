package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.TextView;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y0<T> implements Observer {
    public final /* synthetic */ f1 a;

    public y0(f1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r15) {
        Long r16 = (Long) r15;
        if (r16 == null) goto L26;
        r16.longValue();
        SkuInfoVO r0 = (SkuInfoVO) f1.e0(this.a).getSkuInfo().a();
        Long r1 = (Long) f1.e0(this.a).m1028getCurrentPrice().a();
        if (r1 == null) goto L7;
        long r10 = r1.longValue();
    L8:
        boolean r11 = true;
        String r12 = th.a.h(this.a.Y().c(), 2131914026, new Object[]{f1.e0(this.a).getCurrentStock().a()});
        String r13 = null;
        if (r0 == null) goto L11;
        String r14 = r0.getNewBonusText();
    L13:
        if (r16.longValue() > 1) goto L16;
        r11 = false;
    L16:
        if (r11 == false) goto L18;
        r13 = r14;
    L18:
        if (r13 == null) goto L24;
        StringBuilder r17 = new StringBuilder();
        r17.append(r12);
        if (r10 <= 0) goto L23;
        r13 = f1.e0(this.a).getCurrentNewBonusText();
    L23:
        r17.append(r13);
        r12 = r17.toString();
    L24:
        ((TextView) this.a.Z().b(2131391470).f()).setText(r12);
        return;
    L11:
        r14 = null;
        goto L13
    L7:
        r10 = 0;
        goto L8
    }
}
