package com.bytedance.android.ec.common.impl.sku.presenter;

import android.widget.TextView;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w0<T> implements Observer {
    public final /* synthetic */ f1 a;

    public w0(f1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r14) {
        Long r15 = (Long) r14;
        if (r15 == null) goto L30;
        r15.longValue();
        Long r0 = (Long) f1.e0(this.a).m1028getCurrentPrice().a();
        if (r0 == null) goto L7;
        long r10 = r0.longValue();
    L8:
        SkuInfoVO r1 = (SkuInfoVO) f1.e0(this.a).getSkuInfo().a();
        boolean r11 = true;
        String r16 = th.a.h(this.a.Y().c(), 2131914026, new Object[]{r15});
        String r12 = null;
        if (r1 == null) goto L11;
        String r13 = r1.getNewBonusText();
    L12:
        Long r17 = (Long) f1.e0(this.a).m1027getCurrentCount().a();
        if (r17 == null) goto L15;
        long r18 = r17.longValue();
    L17:
        if (r18 > 1) goto L20;
        r11 = false;
    L20:
        if (r11 == false) goto L22;
        r12 = r13;
    L22:
        if (r12 == null) goto L28;
        StringBuilder r19 = new StringBuilder();
        r19.append(r16);
        if (r10 <= 0) goto L27;
        r12 = f1.e0(this.a).getCurrentNewBonusText();
    L27:
        r19.append(r12);
        r16 = r19.toString();
    L28:
        ((TextView) this.a.Z().b(2131391470).f()).setText(r16);
        this.a.i = r16;
        return;
    L15:
        r18 = 0;
        goto L17
    L11:
        r13 = null;
        goto L12
    L7:
        r10 = 0;
        goto L8
    }
}
