package com.bytedance.android.live.recharge;

import android.graphics.Typeface;
import android.widget.EditText;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.utils.e4;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ CustomRechargeDialogFragment a;

    public b(CustomRechargeDialogFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r13) {
        Long r14 = (Long) r13;
        CustomRechargeDialogFragment r0 = this.a;
        if (r14 == null) goto L5;
        int r3 = CustomRechargeDialogFragment.G;
        r0.getClass();
        long r4 = r14.longValue();
    L7:
        if (r4 <= 0) goto L11;
        EditText r5 = r0.o;
        if (r5 == null) goto L15;
        r5.setTypeface(Typeface.DEFAULT_BOLD);
    L15:
        if (r14 != null) goto L17;
    L31:
        r0.Y90(s1.C(2131916125, new Object[]{e4.a(), Long.valueOf((long) (r0.B / 100.0f))}), s1.h(2131107261), false);
        r0.X90(0, com.bytedance.android.live.recharge.combinedpay.a.a());
        return;
    L17:
        if (r14.longValue() < r0.B) goto L31;
        if (r14.longValue() < r0.C) goto L30;
        int r7 = ToastUtil.a;
        Object[] r6 = new Object[2];
        r6[0] = e4.a();
        int r8 = com.bytedance.android.live.recharge.util.b.a;
        long r9 = r0.C;
        if (r9 > 0) goto L24;
        float r1 = 0.0f;
    L25:
        long r2 = (long) r1;
        long r10 = 10000;
        if (r9 >= r10) goto L28;
        String r12 = String.valueOf(r2);
    L29:
        r6[1] = r12;
        ToastUtil.b(s1.C(2131916124, r6), 0);
        goto L30
    L28:
        r12 = String.valueOf(r2 / r10) + "万";
        goto L29
    L24:
        r1 = r9 / 100.0f;
    L30:
        r0.F = r14.longValue();
        r0.Z90(r14.longValue());
        r0.X90(r14.longValue(), com.bytedance.android.live.recharge.combinedpay.a.a());
        return;
    L11:
        EditText r15 = r0.o;
        if (r15 == null) goto L15;
        r15.setTypeface(Typeface.DEFAULT);
        goto L15
    L5:
        r4 = 0;
        goto L7
    }
}
