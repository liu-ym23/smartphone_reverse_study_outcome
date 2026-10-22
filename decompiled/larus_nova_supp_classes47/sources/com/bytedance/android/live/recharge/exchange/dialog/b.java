package com.bytedance.android.live.recharge.exchange.dialog;

import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.android.live.recharge.utils.q;
import com.bytedance.android.livesdk.utils.r3;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ CashExchangeDialogNew a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;
    public final /* synthetic */ ExchangeInfo f;
    public final /* synthetic */ String g;
    public final /* synthetic */ ExchangeType h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ int j;
    public final /* synthetic */ Map k;
    public final /* synthetic */ zv0.e l;

    public b(CashExchangeDialogNew r1, Ref.ObjectRef r2, Ref.ObjectRef r3, long r4, long r6, ExchangeInfo r8, String r9, ExchangeType r10, boolean r12, int r13, Map r14, zv0.e r15) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
    }

    public final void accept(Object r15) {
        com.bytedance.android.live.recharge.platform.business.model.income.e r16 = (com.bytedance.android.live.recharge.platform.business.model.income.e) ((ExtraResponse) r15).data;
        int r0 = r16.cashAmount;
        int r17 = r16.goldAmount;
        this.a.s = com.bytedance.android.live.recharge.utils.e.a(r0, r17);
        this.b.element = s1.C(2131915493, new Object[]{r3.c()});
        if (r17 != 0) goto L7;
        this.c.element = s1.C(2131915495, new Object[]{String.valueOf(this.d), r3.b()});
        TextView r1 = this.a.k;
        if (r1 == null) goto L14;
        r1.setText(s1.C(2131915496, new Object[]{q.b(this.e)}));
    L14:
        Button r2 = this.a.i;
        if (r2 == null) goto L17;
        r2.setText(s1.C(2131915490, new Object[]{r3.c()}));
    L17:
        CashExchangeDialogNew r3 = this.a;
        com.bytedance.android.live.recharge.exchange.a r4 = r3.p;
        if (r4 == null) goto L20;
        r4.d = r17;
    L20:
        if (r4 == null) goto L22;
        r4.c = r0;
    L22:
        r3.J0(this.g, this.h, (String) this.b.element, (String) this.c.element, this.d, this.i, this.j, this.k, this.l);
        return;
    L7:
        if (r0 == 0) goto L11;
        this.c.element = s1.C(2131915491, new Object[]{String.valueOf(this.d), r3.b()});
        TextView r5 = this.a.k;
        if (r5 == null) goto L14;
        r5.setText(s1.C(2131915492, new Object[]{q.b(r0), q.b(r17)}));
        goto L14
    L11:
        this.c.element = s1.C(2131915497, new Object[]{String.valueOf(this.d), r3.b()});
        TextView r6 = this.a.k;
        if (r6 == null) goto L14;
        r6.setText(s1.C(2131915498, new Object[]{Integer.valueOf(this.f.getMaxGoldCount()), r3.b()}));
        goto L14
    }
}
